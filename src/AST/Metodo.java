/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST;

import java.util.ArrayList;

/**
 *
 * @author erick
 */
public class Metodo extends Sentencia{

    public ArrayList<Sentencia> sentencias ;
    public String id;
    public Metodo(String i)
    {
        id = i;
        sentencias = new ArrayList<Sentencia>();
    }
    public Metodo()
    {
        id = "";
        sentencias = new ArrayList<Sentencia>();
    }  
    
    public Metodo(ArrayList<Sentencia> s)
    {
        id = "";
        sentencias = s;
    }

    public void setSentencias(ArrayList<Sentencia> sentencias) {
        this.sentencias = sentencias;
    }

    public void setId(String id) {
        this.id = id;
    }
        
    
    public void add(Sentencia s)
    {
        sentencias.add(s);
    }
    
    @Override
    public Nodo ejecutar(Entorno entorno) 
    {
        for (Sentencia sentencia : sentencias) 
        {
            if(sentencia instanceof Metodo)
            {
                sentencia.ejecutar(new Entorno(entorno,entorno.ventana));
            }
            else
            {
                sentencia.ejecutar(entorno);
            }
        }
        return this;
    }
    
}
