package data.dao;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;

import static org.jooq.impl.DSL.*;

public class ArtistaDAO {
    private final DSLContext dsl;

    public ArtistaDAO(DSLContext dsl) {
        this.dsl = dsl;
    }

    public void insertarArtista(String nombreArtistico, String generoMusical) {
        dsl.insertInto(table("ArtistaDAO"), field("nombre_artistico"), field("genero_musical"))
                .values(nombreArtistico, generoMusical)
                .execute();
    }

    public Result<Record> obtenerTodosLosArtistas() {
        return dsl.select().from(table("ArtistaDAO")).fetch();
    }

}
