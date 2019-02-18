/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AST;


import ht1.Ventana;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author erick
 */
public class Entorno 
{
    public Entorno anterior;
    public Hashtable<String, Simbolo> tablaSimbolos;
    public Ventana ventana;
    public Entorno(Entorno anterior)
    {        
        this.anterior = anterior;
        tablaSimbolos = new Hashtable<String, Simbolo>();                
    }
    public Entorno(Entorno anterior, Ventana v)
    {
        this.anterior = anterior;
        tablaSimbolos = new Hashtable<String, Simbolo>(); 
        this.ventana = v;
    }
    
    public boolean insertarSimbolo(Simbolo simbolo)
    {
        if(existeSimbolo(simbolo.id))
        {
            return false;
        }
        else
        {
           //Comprobación de tipos perros
           boolean flag = false;
           String tipo = simbolo.valor.getClass().toString().toLowerCase();
           String[] t = tipo.split(".");
           
           switch(simbolo.tipo)
           {
               case "string":
                   if(simbolo.valor instanceof String)
                   {                       
                       flag = true;
                   }                   
                   break;
               case "int":
                   if(simbolo.valor instanceof Integer)
                   {                       
                       flag = true;
                   }                   
                   if(simbolo.valor instanceof Double)
                   {
                       simbolo.valor = ((Double)simbolo.valor).intValue();
                       flag = true;
                   }                          
                   break;
               case "double":
                   if(simbolo.valor instanceof Integer)
                   {
                       simbolo.valor = (Double)simbolo.valor;
                       flag = true;
                   }                   
                   if(simbolo.valor instanceof Double)
                   {                       
                       flag = true;
                   }                    
                   break;                   
               case "boolean":
                   if(simbolo.valor instanceof Boolean)
                   {
                       flag = true;
                   }                   
                   break;               
               
           }
           if(flag)
           {
               tablaSimbolos.put(simbolo.id, simbolo);
           }
           else
           {
               ventana.setSalida("Error Semantico: Se esperaba un valor :" +simbolo.tipo + " Enviando:" + tipo);
           }
        }
        return false;
    }
    
    
    public boolean existeSimbolo(String id)
    {
        Entorno ent = this;
        while(ent!=null)
        {
            Simbolo sim = ent.tablaSimbolos.get(id);
            if(sim !=null)
            {
                return true;
            } 
            ent = ent.anterior;
        }
        return false;
    }
    
    
    public Object getValor(String id)
    {
        Entorno ent = this;
        while(ent!=null)
        {
            Simbolo sim = ent.tablaSimbolos.get(id);
            if(sim !=null)
            {                
                return sim.valor;
            }    
            ent = ent.anterior;
        }        
        ventana.setSalida("Error, no existe la variable buscada:\t"+id);
        return "";
    }    
        
    
    public boolean actualizarSimbolo(String id, Object valor)                
    {
        Entorno ent = this;
        while(ent!=null)
        {
            Simbolo sim = ent.tablaSimbolos.get(id);
            if(sim !=null)
            {
                String tipo1 = "";
                String tipo2 = "";
                if(valor instanceof String)
                {
                    tipo1 = "string";
                }
                if(sim.valor instanceof String)
                {
                    tipo2 = "string";
                }                
                if(valor instanceof Integer)
                {
                    tipo1 = "int";
                }
                if(sim.valor instanceof Integer)
                {
                    tipo2 = "int";
                }  
                if(valor instanceof Boolean)
                {
                    tipo1 = "bool";
                }
                if(sim.valor instanceof Boolean)
                {
                    tipo2 = "bool";
                }                
                
                if(tipo1.equals(tipo2))
                {
                    sim.valor = valor;
                    return true;   
                }                
                else
                {
                    boolean f = false;
                    switch(tipo1)
                    {
                        case "string":
                            switch(tipo2)
                            {
                                case "string":
                                    f = true;
                                    break;
                            }
                            break;
                        case "int":
                            switch(tipo2)
                            {
                                case "int":
                                    f = true;
                                    break;
                                case "double":
                                    valor = Integer.parseInt((String)valor);
                                    f = true;
                                    break;                                    
                            }                            
                        case "double":
                            switch(tipo2)
                            {
                                case "int":
                                    valor = Double.parseDouble((String)valor);
                                    f = true;
                                    break;
                                case "double":                                    
                                    f = true;
                                    break;                                    
                            }                                                        
                        default:                           
                    }
                    if(!f)
                    {
                        ventana.setSalida("Error de tipos. Esperado: " +tipo1 + "\tEnviado:"+tipo2);
                        return false;                         
                    }
                    else
                    {
                        sim.valor = valor;
                        return true;                         
                    }
                }
            }
            ent = ent.anterior;
        }
        return false;
    }   
    
    
    public String imprimir()
    {
        String cadena = "";
        Set<String> keys = this.tablaSimbolos.keySet();
        String str;
        //Obtaining iterator over set entries
        Iterator<String> itr = keys.iterator();

        //Displaying Key and value pairs
        while (itr.hasNext()) { 
           // Getting Key
           str = itr.next();

           /* public V get(Object key): Returns the value to which 
            * the specified key is mapped, or null if this map 
            * contains no mapping for the key.
            */           
           cadena += "\nvariable: " +this.tablaSimbolos.get(str).tipo + "\t tipo:"+this.tablaSimbolos.get(str).id;
        }         
        return cadena;
    }
    
    
    
}
