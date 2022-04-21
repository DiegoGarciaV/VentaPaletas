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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("api/movimientos")
public class ApiMovimientosController {

    @Autowired
    ConexionDatos conexionDatos;

    @Autowired
    ConsultaMovimientos consultaMovimientos;


    @GetMapping("")
    public ResponseEntity<LinkedList<Movimiento>> getMovimientos()
    { 
        return new ResponseEntity<LinkedList<Movimiento>>(consultaMovimientos.getMovimientos(), HttpStatus.OK);
       
    }
    @PostMapping("/intervalo/params")
    public ResponseEntity<LinkedList<Movimiento>> getMovimientosIntParam(@RequestParam(value = "fechaIni") String fechaIni,@RequestParam(value = "fechaFin") String fechaFin)
    { 
        return new ResponseEntity<LinkedList<Movimiento>>(consultaMovimientos.getMovimientosIntervalo(fechaIni,fechaFin), HttpStatus.OK);   
    }

    @PostMapping("/intervalo/body")
    public ResponseEntity<LinkedList<Movimiento>> getMovimientosIntBody(@RequestBody String[] fechas)
    { 
        return new ResponseEntity<LinkedList<Movimiento>>(consultaMovimientos.getMovimientosIntervalo(fechas[0],fechas[1]), HttpStatus.OK);   
    }

    @PostMapping("/depto")
    public ResponseEntity<LinkedList<Movimiento>> getMovimientosDepto(@RequestBody String[] deptos)
    { 
        return new ResponseEntity<LinkedList<Movimiento>>(consultaMovimientos.getMovimientosDepto(deptos), HttpStatus.OK);   
    }


    
    
}
