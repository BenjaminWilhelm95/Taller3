package data.dao;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;

import static org.jooq.impl.DSL.*;

public class EntradaDAO {
    private final DSLContext dsl;

    public EntradaDAO(DSLContext dsl) {
        this.dsl = dsl;
    }

    public void venderEntrada(String tipo, double precio, int cantidadDisponible, int idEvento) {
        dsl.insertInto(table("EntradaDAO"), field("tipo"), field("precio"), field("cantidad_disponible"), field("evento_id"))
                .values(tipo, precio, cantidadDisponible, idEvento)
                .execute();
    }

    public Result<Record> obtenerEntradasPorEvento(int idEvento) {
        return dsl.select().from(table("EntradaDAO")).where(field("evento_id").eq(idEvento)).fetch();
    }
}
