package data.dao;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;

import static org.jooq.impl.DSL.*;

public class AsistenteDAO {
    private final DSLContext dsl;

    public AsistenteDAO(DSLContext dsl) {
        this.dsl = dsl;
    }

    public void insertarAsistente(String nombre, String correo, String telefono, String preferenciasMusicales) {
        dsl.insertInto(table("AsistenteDAO"), field("nombre"), field("correo"), field("telefono"), field("preferencias_musicales"))
                .values(nombre, correo, telefono, preferenciasMusicales)
                .execute();
    }

    public Result<Record> obtenerTodosLosAsistentes() {
        return dsl.select().from(table("AsistenteDAO")).fetch();
    }

}
