/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST;

/**
 *
 * @author erick
 */
public class Declaracion  extends Sentencia{
    public String id;
    public String tipo;
    public Exp exp;
    
    public Declaracion(String i, String t, Exp e)
    {
        id = i;
        tipo = t;
        exp = e;
    }
    
    public Declaracion(String i, String t)
    {
        id = i;
        tipo = t;        
    }    
    
    
    public void setValor(Entorno entorno)
    {
        if(exp!=null)
        {
            valor = entorno.insertarSimbolo(new Simbolo(id, tipo, "var",exp.ejecutar(entorno).valor));            
        }   
        else
        {
            Object v = null;
            switch(tipo)
            {
                case "string":
                    v = "";
                    break;
                case "int":
                    v = 0;
                    break;
                case "double":
                    v = 0.00;
                    break;
                case "bool":
                    v = false;
                    break;                
            }
            valor = entorno.insertarSimbolo(new Simbolo(id, tipo, "var",v));
            
        }
    }
    
    
    @Override
    public Nodo ejecutar(Entorno entorno) 
    {
        setValor(entorno);
        return null;
    }
    
}
