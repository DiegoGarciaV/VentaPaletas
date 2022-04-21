package com.dinobotica.paletas.service.ConexionBD;

import java.sql.*;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("ConexionDatos")
public class ConexionDatosImp implements ConexionDatos{

    
    private HashMap<String,String> BDpametros = new HashMap<>();
    Connection conn = null;
    
    @Override
    public boolean abrirConexionBD() {
        
        StringBuilder url = new StringBuilder();
        url.append("jdbc:mysql://")
        .append(BDpametros.get("host"))
        .append(":")
        .append(BDpametros.get("port"))
        .append("/")
        .append(BDpametros.get("database"));

        try 
        {
            Class.forName(BDpametros.get("driver"));
            conn = DriverManager.getConnection( 
                                    url.toString(),
                                    BDpametros.get("username"),
                                    BDpametros.get("password")
                                );

            return !conn.isClosed();
            
        } catch (Exception e) {

            System.out.println(e.toString());
        }
        

        return false;
    }

    @Override
    public boolean cerrarConexionBD() {
        
        try 
        {
            conn.close();
            conn = null;
            return true;

        } catch (Exception e) {

            System.out.println(e.toString());
        }
        return false;
    }

    @Override
    public String getBDNombre() {
        
        return BDpametros.get("database");
    }

    @Override
    public void setBDparams(HashMap<String, String> BDpametros) {
        this.BDpametros = BDpametros;
    }

    @Override
    public HashMap<String, String> getBDparams() {
        return this.BDpametros;
    }

    @Override
    public int insertarDatos(String tabla, HashMap<String,String> valores)
    {
        StringBuilder inserciones = new StringBuilder();
        StringBuilder campos = new StringBuilder();
        int i = 0;
        for(Map.Entry<String, String> tupla : valores.entrySet())
        {
            char separador = ((i++ < (valores.size() - 1)) ? ',' : ' ');
            
            inserciones.append("?")
            .append(separador);

            campos.append(tupla.getKey())
            .append(separador);
        }

        StringBuilder sql = new StringBuilder();
        sql
        .append("INSERT INTO        ")
        .append(tabla)
        .append("(")
        .append(campos)
        .append(")\n")
        .append("VALUES             (")     
        .append(inserciones)
        .append(");");

        try 
        {
            PreparedStatement insercion = conn.prepareStatement(sql.toString());
            i = 1;
            for(Map.Entry<String, String> tupla : valores.entrySet())
            {
                insercion.setString(i, tupla.getValue());
                i++;
            }
            return insercion.executeUpdate();

        } catch(SQLIntegrityConstraintViolationException sqlicve){
            System.err.println("No se ha podido insertar registro debido a que ya existe ese Id registrado.");
            return -1;
        } catch (Exception e) {
            System.err.println(e.toString());
            return -1;
        }
        
        

    }

    @Override
    public LinkedList<HashMap<String, String>> consultaQuery(String sqlq) {
        
        try 
        {
            PreparedStatement consulta = conn.prepareStatement(sqlq);
            ResultSet rs = consulta.executeQuery();
            LinkedList<HashMap<String, String>> Resultado = new LinkedList<>();
            while(rs.next())
            {
                HashMap<String,String> registro = new HashMap<>();
                int i = 0;
                int cCount = rs.getMetaData().getColumnCount();
                while(i < cCount)
                {
                    registro.put(rs.getMetaData().getColumnName(i+1), rs.getString(i+1));
                    i++;
                }
                Resultado.push(registro);
            }
            return Resultado;

        } catch (Exception e) {
            System.err.println(e.toString());
            return new LinkedList<>();
        }
    }

    @Override
    public LinkedList<HashMap<String, String>> ejecProc(String proc, LinkedList<Object> params) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int eliminaDatos(String tabla, String criterio) {

        StringBuilder sqlq = new StringBuilder("DELETE FROM ");
        sqlq.append(tabla)
        .append("\nWHERE ")
        .append(criterio);

        try 
        {
            PreparedStatement eliminacion = conn.prepareStatement(sqlq.toString());
            return eliminacion.executeUpdate();

        } catch (Exception e) {
            System.err.println(e.toString());
            return -1;
        }
    }
    
}
;