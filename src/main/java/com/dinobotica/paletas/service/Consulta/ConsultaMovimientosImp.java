package com.dinobotica.paletas.service.Consulta;

import java.util.HashMap;
import java.util.LinkedList;

import com.dinobotica.paletas.dto.Movimiento;
import com.dinobotica.paletas.service.ConexionBD.ConexionDatos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsultaMovimientosImp implements ConsultaMovimientos{

    @Autowired
    ConexionDatos conexionDatos;

    @Override
    public LinkedList<Movimiento> getMovimientos() {
        
        return consultaMovimientosSQL("select * from detalleMovimientos");
        
    }

    @Override
    public LinkedList<Movimiento> getMovimientosIntervalo(String fechaIni, String fechaFin) {
        
        StringBuilder sqlq = new StringBuilder("call getMovimientosIntervalo('");
        sqlq.append(fechaIni)
        .append("','")
        .append(fechaFin)
        .append("');");
        return consultaMovimientosSQL(sqlq.toString());

    }

    @Override
    public LinkedList<Movimiento> getMovimientosDepto(String[] deptos) {
        
        StringBuilder sqlq = new StringBuilder("departamento in (");
        int i = 0;
        for(String depto : deptos)
        {
            sqlq.append("'")
            .append(depto)
            .append("'");
            if(i< deptos.length -1)
                sqlq.append(",");

            i++;
        }
        sqlq.append(")");
        return getMovimientosFiltro(sqlq.toString());

    }
    
    @Override
    public LinkedList<Movimiento> getMovimientosFiltro(String filtro) {
        StringBuilder sqlq = new StringBuilder("select * from detalleMovimientos WHERE ");
        sqlq.append(filtro)
        .append(";");
        return consultaMovimientosSQL(sqlq.toString());
    }



    private LinkedList<Movimiento> consultaMovimientosSQL(String sql)
    {
        LinkedList<Movimiento> movimientos = new LinkedList<>();
        LinkedList<HashMap<String,String>> movimientosBD;
        if(conexionDatos.abrirConexionBD())
        {
            movimientosBD = conexionDatos.consultaQuery(sql);
            conexionDatos.cerrarConexionBD();    
            
            for(HashMap<String,String> registro : movimientosBD)
            {
                Movimiento movimiento = new Movimiento();
                movimiento.setAtributosS(registro);
                movimientos.add(movimiento);
            }
        }
        return movimientos;
    }

    @Override
    public boolean nuevoMovimiento(Movimiento movimiento) {
        
        boolean res = false;
        StringBuilder sqlq = new StringBuilder("INSERT INTO MOVIMIENTOS()");

        return res;
    }

    @Override
    public int nuevosMovimientos(LinkedList<Movimiento> movimientos) {
        // TODO Auto-generated method stub
        return 0;
    }
}
