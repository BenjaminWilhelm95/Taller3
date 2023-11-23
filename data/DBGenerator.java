package data;

import org.jooq.DSLContext;
import org.jooq.DataType;
import org.jooq.impl.DSL;

import java.sql.Connection;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.*;

public class DBGenerator {
    public static void iniciarBD(String nombreBD) throws ClassNotFoundException {
        Connection connection = DBConnector.connection("root", "");
        DSLContext create = DSL.using(connection);
        crearBaseDato(create, nombreBD);
        create = actualizarConexion(connection, nombreBD);
        crearTablas(create);
        DBConnector.closeConnection();
    }

    private static void crearBaseDato(DSLContext create, String nombreBD) {
        create.createDatabaseIfNotExists(nombreBD).execute();
    }

    private static DSLContext actualizarConexion(Connection connection, String nombreBD) {
        DBConnector.closeConnection();
        connection = DBConnector.connection(nombreBD, "root", "");
        DSLContext create = DSL.using(connection);
        return create;
    }

    private static void crearTablas(DSLContext create) {
        crearTablaUsuario(create);
        crearTablaArtista(create);
        crearTablaEvento(create);
        crearTablaAsistente(create);
        crearTablaEntrada(create);
    }

    private static void crearTablaUsuario(DSLContext create) {
        create.createTableIfNotExists("Usuario")
                .column("rut", VARCHAR(50))
                .column("nombre", VARCHAR(100))
                .column("edad", INTEGER)
                .constraint(primaryKey("rut"))
                .execute();
    }

    private static void crearTablaArtista(DSLContext create) {
        create.createTableIfNotExists("ArtistaDAO")
                .column("id", INTEGER.identity(true))
                .column("nombre_artistico", VARCHAR(100))
                .column("genero_musical", VARCHAR(50))
                .constraint(primaryKey("id"))
                .execute();
    }

    private static void crearTablaEvento(DSLContext create) {
        create.createTableIfNotExists("EventoDAO")
                .column("id", INTEGER.identity(true))
                .column("nombre_evento", VARCHAR(100))
                .column("fecha", DATE)
                .column("lugar", VARCHAR(100))
                .constraint(primaryKey("id"))
                .execute();

        // Relación entre EventoDAO y ArtistaDAO (muchos a muchos)
        create.createTableIfNotExists("Evento_Artista")
                .column("evento_id", INTEGER)
                .column("artista_id", INTEGER)
                .constraint(primaryKey("evento_id", "artista_id"))
                .constraint(foreignKey("evento_id").references("EventoDAO"))
                .constraint(foreignKey("artista_id").references("ArtistaDAO"))
                .execute();
    }

    private static void crearTablaAsistente(DSLContext create) {
        create.createTableIfNotExists("AsistenteDAO")
                .column("id", INTEGER.identity(true))
                .column("nombre", VARCHAR(100))
                .column("correo", VARCHAR(100))
                .column("telefono", VARCHAR(20))
                .column("preferencias_musicales", VARCHAR(200))
                .constraint(primaryKey("id"))
                .execute();
    }

    private static void crearTablaEntrada(DSLContext create) {
        create.createTableIfNotExists("EntradaDAO")
                .column("id", INTEGER.identity(true))
                .column("tipo", VARCHAR(50))
                .column("precio", DECIMAL(10, 2))
                .column("cantidad_disponible", INTEGER)
                .column("evento_id", INTEGER)
                .constraint(primaryKey("id"))
                .constraint(foreignKey("evento_id").references("EventoDAO"))
                .execute();
    }
}
