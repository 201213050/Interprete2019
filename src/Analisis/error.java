/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis;

/**
 *
 * @author erick
 */
public class error 
{
    public String tipo;
    public String descripcion;
    public int linea;
    public int columna;
    public String archivo;
    
    public error(String tipo, String descripcion, int linea, int columna)
    {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.linea = linea;
        this.columna = columna;
    }
    
    public error(String tipo, String descripcion, String archivo, int linea, int columna)
    {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.linea = linea;
        this.columna = columna;
        this.archivo = archivo;
    }    
    
    public void imprimir()
    {        
        System.out.println(this.getMensaje());
    }
    public String getMensaje()
    {
        return this.tipo + "\t" + this.descripcion +"\t"+ linea +"\t"+ columna;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getLinea() {
        return linea;
    }

    public int getColumna() {
        return columna;
    }

    public String getArchivo() {
        return archivo;
    }                    
}
