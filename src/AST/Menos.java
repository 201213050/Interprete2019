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
public class Menos extends Exp{
    public Exp exp;
    public Menos(Exp e)
    {
        exp = e;                       
    }
    
    public void setValor(Entorno entorno)
    {
        Object v1 = exp.ejecutar(entorno).valor;               
        int operacion = 0;
        if(v1 instanceof Integer)
        {
            operacion += 1;
        }  
        if(v1 instanceof Double)
        {
            operacion += 2;
        }

        
        switch(operacion)
        {
            case 2: // int + int
                valor = Integer.parseInt(v1.toString()) * -1;
                break;
            case 3: // double + int  o int + double
            case 4: // double  + double 
                valor = Double.parseDouble(v1.toString()) * -1;
                break;                
            default:
                entorno.ventana.setSalida("Error de tipos en menos linea:"+linea + "\tColumna:"+columna);
                break;
        }      
    }

    @Override
    public Nodo ejecutar(Entorno entorno) 
    {
        setValor(entorno);
        return this;
    }
}
