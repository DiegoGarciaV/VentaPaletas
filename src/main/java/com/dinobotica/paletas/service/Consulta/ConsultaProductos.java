package com.dinobotica.paletas.service.Consulta;

import java.util.LinkedList;

import com.dinobotica.paletas.dto.Producto;

public interface ConsultaProductos {

    public LinkedList<Producto> getProductos();

    public Producto getProductoId(int idProducto);

    public LinkedList<Producto> getProductoFiltro(String filtro);
    
}
