/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorventas.modelo;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author root
 */
public class Transaccion {
    private String nombreCliente;
    private String productoComprado;
    private int precio;
    private LocalDate fecha;
    private String ciudad;
    /**
     * @param nombre
     * @param producto
     * @param precio
     * @param fecha
     * @param ciudad 
     */
    public Transaccion(String nombre, String producto,int precio, String fecha, String ciudad) {
        String dia;
        String mes;
        String ano;
        if (nombre.matches(".* .*"))
            this.nombreCliente = nombre.trim().substring(0,nombre.indexOf(" "));
        else
            this.nombreCliente = nombre.trim();
        this.productoComprado = producto.trim();
        //System.out.println(this.nombreCliente + " " +  precio);
        this.precio = precio;
        if (fecha.matches("\\d{4}-\\d{2}-\\d{2}")){
            ano=fecha.substring(0,fecha.indexOf('-'));
            if (ano.matches("\\d\\d"))
                ano = "20"+ano;
            mes=fecha.substring(fecha.indexOf('-')+1,fecha.lastIndexOf("-"));
            if (mes.matches("\\d"))
                mes = "0" + mes;
            dia = fecha.substring(fecha.lastIndexOf("-")+1,fecha.length());
            if (dia.matches("\\d"))
                dia = "0" + dia;
            this.fecha = LocalDate.parse(ano+"-"+mes+"-"+dia);
        }
        else if (fecha.matches("\\d{2}/\\d{2}/\\d{4}")){
            dia = fecha.substring(0,fecha.indexOf("/"));
            mes = fecha.substring(fecha.indexOf("/")+1,fecha.lastIndexOf("/"));
            ano = fecha.substring(fecha.lastIndexOf("/")+1,fecha.length());
            this.fecha = LocalDate.parse(ano+"-"+mes+"-"+dia);
        }
        else{
            mes=fecha.substring(0,fecha.indexOf('/'));
            if (mes.matches("\\d"))
                mes = "0" + mes;
            //System.out.println(dia);
            dia=fecha.substring(fecha.indexOf('/')+1,fecha.lastIndexOf("/"));
            if (dia.matches("\\d"))
                dia = "0" + dia;
            //System.out.println(mes);
            ano = fecha.substring(fecha.lastIndexOf("/")+1,fecha.indexOf(" "));
            if (ano.matches("\\d\\d"))
                ano = "20"+ano;
            //System.out.println(ano);
            this.fecha = LocalDate.parse(ano+"-"+mes+"-"+dia);
        }
        this.ciudad = ciudad.trim();
    }
    //Constructor de objeto vacio
    public Transaccion(){
        this.nombreCliente="";
        this.productoComprado="";
        this.precio=0;
        this.fecha=LocalDate.now();
        this.ciudad="";
    }
    /**
     * @param t 
     */
    //Setter que he creado para, en un caso especifico poder modificar la transaccion completa
    //y no tener que modifcar campo a campo
    public void setTransaccion(Transaccion t){
        this.nombreCliente = t.nombreCliente;
        this.productoComprado = t.productoComprado;
        this.precio = t.precio;
        this.fecha = t.fecha;
        this.ciudad = t.ciudad;
           
    }
/**
 * @return nombreCliante
 */
    public String getNombreCliente() {
        return nombreCliente;
    }
/**
 * @return ProductoComprado
 */
    public String getProductoComprado() {
        return productoComprado;
    }
/**
 * @return Precio
 */
    public int getPrecio() {
        return precio;
    }
/**
 * @return Fecha
 */
    public String getFecha() {
        return fecha.toString();
    }
/**
 * @return ciudad
 */
    public String getCiudad() {
        return ciudad;
    }
/**
 * 
 * @param nombreCliente 
 */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
/**
 * 
 * @param productoComprado 
 */
    public void setProductoComprado(String productoComprado) {
        this.productoComprado = productoComprado;
    }
/**
 * 
 * @param precio 
 */
    public void setPrecio(int precio) {
        this.precio = precio;
    }
/**
 * 
 * @param fecha 
 */
    public void setFecha(String fecha) {
        String dia;
        String mes;
        String ano;
        ano=fecha.substring(0,fecha.indexOf('-'));
        if (ano.matches("\\d\\d"))
            ano = "20"+ano;
        mes=fecha.substring(fecha.indexOf('-')+1,fecha.lastIndexOf("-"));
        if (mes.matches("\\d"))
            mes = "0" + mes;
        dia = fecha.substring(fecha.lastIndexOf("-")+1,fecha.length());
        if (dia.matches("\\d"))
            dia = "0" + dia;
        this.fecha = LocalDate.parse(ano+"-"+mes+"-"+dia);
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.nombreCliente);
        hash = 59 * hash + Objects.hashCode(this.productoComprado);
        hash = 59 * hash + this.precio;
        hash = 59 * hash + Objects.hashCode(this.fecha);
        hash = 59 * hash + Objects.hashCode(this.ciudad);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Transaccion other = (Transaccion) obj;
        if (this.precio != other.precio) {
            return false;
        }
        if (!Objects.equals(this.nombreCliente, other.nombreCliente)) {
            return false;
        }
        if (!Objects.equals(this.productoComprado, other.productoComprado)) {
            return false;
        }
        if (!Objects.equals(this.ciudad, other.ciudad)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }    
}