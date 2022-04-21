package com.dinobotica.paletas.service;

import java.util.HashMap;
import java.util.LinkedList;

import com.dinobotica.paletas.dto.Movimiento;
import com.dinobotica.paletas.dto.Producto;
import com.dinobotica.paletas.service.ConexionBD.ConexionDatos;
import com.dinobotica.paletas.service.Consulta.ConsultaMovimientos;
import com.dinobotica.paletas.service.Consulta.ConsultaProductos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("api/productos")
@CrossOrigin
public class ApiProductosController {

    @Autowired
    ConexionDatos conexionDatos;

    @Autowired
    ConsultaProductos consultaProductos;


 

    @GetMapping("")
    public ResponseEntity<LinkedList<Producto>> getProductos2()
    { 
        return new ResponseEntity<LinkedList<Producto>>(consultaProductos.getProductos(), HttpStatus.OK);
       
    }


    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoId(@PathVariable int id)
    { 
        return new ResponseEntity<Producto>(consultaProductos.getProductoId(id), HttpStatus.OK);
       
    }

    @PostMapping("/filtro")
    public ResponseEntity<LinkedList<Producto>> getProductosFiltro(@RequestBody LinkedList<HashMap<String,Object>> filtros)
    { 
        StringBuilder filtrado = new StringBuilder("FALSE ");
        for(HashMap<String,Object> filtPack : filtros)
        {
            filtrado.append("OR (TRUE ");
            if(filtPack.containsKey("sabor"))
            {
                filtrado.append("AND sabor = '")
                .append(filtPack.get("sabor"))
                .append("' ");
            }

            if(filtPack.containsKey("form"))
            {
                filtrado.append("AND form = '")
                .append(filtPack.get("form"))
                .append("' ");
            }
            filtrado.append(")");
                
        }
        return new ResponseEntity<LinkedList<Producto>>(consultaProductos.getProductoFiltro(filtrado.toString()), HttpStatus.OK);
       
    }
    
    
}
