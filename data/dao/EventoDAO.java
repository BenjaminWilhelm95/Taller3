package data.dao;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;

import static org.jooq.impl.DSL.*;

public class EventoDAO {
    private final DSLContext dsl;

    public EventoDAO(DSLContext dsl) {
        this.dsl = dsl;
    }

    public void insertarEvento(String nombreEvento, String fecha, String lugar) {
        dsl.insertInto(table("EventoDAO"), field("nombre_evento"), field("fecha"), field("lugar"))
                .values(nombreEvento, fecha, lugar)
                .execute();
    }

    public void cancelarEvento(int idEvento) {
        dsl.deleteFrom(table("EventoDAO")).where(field("id").eq(idEvento)).execute();
    }

    public Result<Record> obtenerTodosLosEventos() {
        return dsl.select().from(table("EventoDAO")).fetch();
    }
}

