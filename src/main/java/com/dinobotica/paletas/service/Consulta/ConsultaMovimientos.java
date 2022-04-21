package com.dinobotica.paletas.service.Consulta;

import java.util.LinkedList;

import com.dinobotica.paletas.dto.Movimiento;

public interface ConsultaMovimientos {

    public LinkedList<Movimiento> getMovimientos();

    public LinkedList<Movimiento> getMovimientosIntervalo(String fechaIni, String fechaFin);

    public LinkedList<Movimiento> getMovimientosDepto(String[] deptos);

    public LinkedList<Movimiento> getMovimientosFiltro(String filtro);

    public boolean nuevoMovimiento(Movimiento movimiento);

    public int nuevosMovimientos(LinkedList<Movimiento> movimientos);
    
}
