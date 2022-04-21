package com.dinobotica.paletas.dto;

import java.util.HashMap;

public class Movimiento implements Modelo{

    private long    idMovimiento;
    private String  sabor;
    private String  formato;
    private String  departamento;
    private String  fecha;
    private String  hora;    
    private float   compra;
    private float   venta;
    private int     cantidad;


    public Movimiento(String sabor, String formato, String departamento, String fecha, String hora, float compra, float venta, int cantidad)
    {
        this.sabor          = sabor;
        this.formato        = formato;
        this.departamento   = departamento;
        this.fecha          = fecha;
        this.hora           = hora;    
        this.compra         = compra;
        this.venta          = venta;
        this.cantidad       = cantidad;
    }



    public Movimiento()
    {
       
    }

    public long getIdMovimiento(){
        return idMovimiento;
    }

    public void setSabor(String sabor){
        this.sabor = sabor;
    }
    public String getSabor(){
        return this.sabor;
    }


    public void setFormato(String formato){
        this.formato = formato;
    }
    public String getFormato(){
        return this.formato;
    }


    public void setDepartamento(String departamento){
        this.departamento = departamento;
    }
    public String getDepartamento(){
        return this.departamento;
    }


    public void setFecha(String fecha){
        this.fecha = fecha;
    }
    public String getFecha(){
        return this.fecha;
    }


    public void setHora(String hora){
        this.hora = hora;
    }
    public String getHora(){
        return this.hora;
    }


    public void setCompra(float compra){
        this.compra = compra;
    }
    public float getCompra(){
        return this.compra;
    }


    public void setVenta(float venta){
        this.venta = venta;
    }
    public float getVenta(){
        return this.venta;
    }


    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    public int getCantidad(){
        return this.cantidad;
    }

    @Override
    public boolean setValorAtributo(String atributo, Object valor) {
        switch(atributo)
        {
            case "idMovimiento":
                idMovimiento = (Long)valor;
                break;

            case "sabor":
                sabor = (String)valor;
                break;

            case "formato":
                formato = (String)valor;
                break;

            case "departamento":
                departamento = (String)valor;
                break;

            case "fecha":
                fecha = (String)valor;
                break;

            case "hora":
                hora = (String)valor;
                break;

            case "compra":
                compra = (Float)valor;
                break;

            case "venta":
                venta = (Float)valor;
                break;

            case "cantidad":
                cantidad = (Integer)valor;
                break;

            default:
                return false;
            
        }

        return true;
    }

    @Override
    public boolean setValorAtributo(String atributo, String valor) {
        
        switch(atributo)
        {
            case "idMovimiento":
                idMovimiento = Integer.parseInt(valor);
                break;

            case "sabor":
                sabor = valor;
                break;

            case "formato":
                formato = valor;
                break;

            case "departamento":
                departamento = valor;
                break;

            case "fecha":
                fecha = valor;
                break;

            case "hora":
                hora = valor;
                break;

            case "compra":
                compra = Float.parseFloat(valor);
                break;

            case "venta":
                venta = Float.parseFloat(valor);
                break;

            case "cantidad":
                cantidad = Integer.parseInt(valor);
                break;

            default:
                return false;
            
        }

        return true;
    }

    @Override
    public String toString() {
        
        StringBuilder movimiento = new StringBuilder();

        movimiento.append("{\n");
        movimiento.append("    \"idMovimiento\":         ").append(idMovimiento).append(",\n");
        movimiento.append("    \"sabor\":           \"").append(sabor).append("\",\n");
        movimiento.append("    \"formato\":         \"").append(formato).append("\",\n");
        movimiento.append("    \"departamento\":    \"").append(departamento).append("\",\n");
        movimiento.append("    \"fecha\":           \"").append(fecha).append("\",\n");
        movimiento.append("    \"hora\":            \"").append(hora).append("\",\n");
        movimiento.append("    \"compra\":          ").append(compra).append(",\n");
        movimiento.append("    \"venta\":           ").append(venta).append(",\n");
        movimiento.append("    \"cantidad\":           ").append(cantidad).append("\n");
        movimiento.append("}\n");
        return movimiento.toString();
    }

    @Override
    public boolean setAtributos(HashMap<String, Object> atributos) {
        boolean res = true;
        for(HashMap.Entry<String,Object> tupla : atributos.entrySet())
        {
            res = res && setValorAtributo(tupla.getKey(), tupla.getValue());
        }

        return res;
    }

    @Override
    public boolean setAtributosS(HashMap<String, String> atributos) {
        
        boolean res = true;
        for(HashMap.Entry<String,String> tupla : atributos.entrySet())
        {
            res = res && setValorAtributo(tupla.getKey(), tupla.getValue());
        }

        return res;
    }

    @Override
    public HashMap<String, Object> toHMap() {

        HashMap<String,Object> movimientoTo = new HashMap<>();

        movimientoTo.put("idMovimiento",idMovimiento);
        movimientoTo.put("sabor",sabor);
        movimientoTo.put("formato",formato);
        movimientoTo.put("departamento",departamento);
        movimientoTo.put("fecha",fecha);
        movimientoTo.put("hora",hora);
        movimientoTo.put("compra",compra);
        movimientoTo.put("venta",venta);
        movimientoTo.put("cantidad",cantidad);

        return movimientoTo;
    }

    @Override
    public HashMap<String, String> toHMapS() {
        
        HashMap<String,String> movimientoTo = new HashMap<>();

        movimientoTo.put("idMovimiento",Long.toString(idMovimiento));
        movimientoTo.put("sabor",sabor);
        movimientoTo.put("formato",formato);
        movimientoTo.put("departamento",departamento);
        movimientoTo.put("fecha",fecha);
        movimientoTo.put("hora",hora);
        movimientoTo.put("compra",Float.toString(compra));
        movimientoTo.put("venta",Float.toString(venta));
        movimientoTo.put("cantidad",Float.toString(cantidad));

        return movimientoTo;
    }
    
}
