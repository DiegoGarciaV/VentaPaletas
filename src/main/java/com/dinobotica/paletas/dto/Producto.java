package com.dinobotica.paletas.dto;

import java.util.HashMap;

public class Producto implements Modelo{

    private long    id;
    private String  sabor;
    private String  form;
    private String  formato;
    private float   compra;
    private float   venta;
    private String  imagen;

    public Producto(){}

    public long getId(){
        return id;
    }

    public void setSabor(String sabor){
        this.sabor = sabor;
    }
    public String getSabor(){
        return this.sabor;
    }

    public void setForm(String form){
        this.form = form;
    }
    public String getForm(){
        return this.form;
    }

    public void setFormato(String formato){
        this.formato = formato;
    }
    public String getFormato(){
        return this.formato;
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


    public void setImagen(String imagen){
        this.imagen = imagen;
    }
    public String getImagen(){
        return this.imagen;
    }
    


    @Override
    public boolean setValorAtributo(String atributo, Object valor) {
        switch(atributo)
        {
            case "id":
                id = (Long)valor;
                break;

            case "sabor":
                sabor = (String)valor;
                break;

            case "formato":
                formato = (String)valor;
                break;

            case "form":
                form = (String)valor;
                break;

            case "compra":
                compra = (Float)valor;
                break;

            case "venta":
                venta = (Float)valor;
                break;

            case "imagen":
                imagen = (String)valor;
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
            case "id":
                id = Integer.parseInt(valor);
                break;

            case "sabor":
                sabor = valor;
                break;

            case "formato":
                formato = valor;
                break;

            case "form":
                form = valor;
                break;

            case "compra":
                compra = Float.parseFloat(valor);
                break;

            case "venta":
                venta = Float.parseFloat(valor);
                break;

            case "imagen":
                imagen = valor;
                break;

            default:
                return false;
            
        }

        return true;
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
    public String toString() {
        
        StringBuilder movimiento = new StringBuilder();

        movimiento.append("{\n");
        movimiento.append("    \"id\":              ").append(id).append(",\n");
        movimiento.append("    \"sabor\":           \"").append(sabor).append("\",\n");
        movimiento.append("    \"formato\":         \"").append(formato).append("\",\n");
        movimiento.append("    \"form\":            \"").append(form).append("\",\n");
        movimiento.append("    \"compra\":          ").append(compra).append(",\n");
        movimiento.append("    \"venta\":           ").append(venta).append(",\n");
        movimiento.append("    \"imagen\":           ").append(imagen).append("\n");
        movimiento.append("}\n");
        return movimiento.toString();

    }

    @Override
    public HashMap<String, Object> toHMap() {
        
        HashMap<String,Object> movimientoTo = new HashMap<>();

        movimientoTo.put("idMovimiento",id);
        movimientoTo.put("sabor",sabor);
        movimientoTo.put("formato",formato);
        movimientoTo.put("form",form);
        movimientoTo.put("compra",compra);
        movimientoTo.put("venta",venta);
        movimientoTo.put("imagen",imagen);

        return movimientoTo;
    }

    @Override
    public HashMap<String, String> toHMapS() {
        
        HashMap<String,String> movimientoTo = new HashMap<>();

        movimientoTo.put("idMovimiento",Long.toString(id));
        movimientoTo.put("sabor",sabor);
        movimientoTo.put("formato",formato);
        movimientoTo.put("form",form);
        movimientoTo.put("compra",Float.toString(compra));
        movimientoTo.put("venta",Float.toString(venta));
        movimientoTo.put("imagen",imagen);

        return movimientoTo;
    }
    
}
