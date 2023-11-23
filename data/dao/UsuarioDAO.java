package data.dao;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;

import static org.jooq.impl.DSL.*;

public class UsuarioDAO {
    private final DSLContext dsl;

    public UsuarioDAO(DSLContext dsl) {
        this.dsl = dsl;
    }

    public void insertarUsuario(String rut, String nombre, int edad) {
        dsl.insertInto(table("Usuario"), field("rut"), field("nombre"), field("edad"))
                .values(rut, nombre, edad)
                .execute();
    }

    public Result<Record> obtenerTodosLosUsuarios() {
        return dsl.select().from(table("Usuario")).fetch();
    }

}
