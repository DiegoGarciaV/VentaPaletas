package com.dinobotica.paletas.service.Consulta;

import java.util.HashMap;
import java.util.LinkedList;

import com.dinobotica.paletas.dto.Producto;
import com.dinobotica.paletas.service.ConexionBD.ConexionDatos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsultaProductosImp implements ConsultaProductos{

    @Autowired
    ConexionDatos conexionDatos;

    @Override
    public LinkedList<Producto> getProductos() {
        
        return consultaProductosSQL("select * from detalleProductos;");
    }

    @Override
    public Producto getProductoId(int idProducto) {
        StringBuilder sqlq = new StringBuilder("select * from detalleProductos WHERE id = ");
        sqlq.append(idProducto);
        LinkedList<Producto> resultado = consultaProductosSQL(sqlq.toString());
        if(resultado.size() == 1)
            return resultado.getFirst();
        else
            return new Producto();
        
    }

    @Override
    public LinkedList<Producto> getProductoFiltro(String filtro) {
        
        return consultaProductosSQL("select * from detalleProductos WHERE " + filtro);

    }

    private LinkedList<Producto> consultaProductosSQL(String sql)
    {
        LinkedList<Producto> movimientos = new LinkedList<>();
        LinkedList<HashMap<String,String>> movimientosBD;
        if(conexionDatos.abrirConexionBD())
        {
            movimientosBD = conexionDatos.consultaQuery(sql);
            conexionDatos.cerrarConexionBD();    
            
            for(HashMap<String,String> registro : movimientosBD)
            {
                Producto movimiento = new Producto();
                movimiento.setAtributosS(registro);
                movimientos.add(movimiento);
            }
        }
        return movimientos;
    }
    
}
