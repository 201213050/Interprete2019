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
public class MenorQue extends Exp{
    public Exp left, right;
    
    public MenorQue(Exp l, Exp r)
    {
        left = l;
        right = r;
    }
    
    public void setValor(Entorno entorno)
    {
        Object v1 = left.ejecutar(entorno).valor;
        Object v2 = right.ejecutar(entorno).valor;
        int operacion = 0;
        if(v1 instanceof Integer)
        {
            operacion += 1;
        }
        if(v2 instanceof Integer)
        {
            operacion += 1;
        }    
        if(v1 instanceof Double)
        {
            operacion += 2;
        }
        if(v2 instanceof Double)
        {
            operacion += 2;
        } 
        
        switch(operacion)
        {
            case 2:
            case 3: // double + int  o int + double
            case 4: // double  + double 
                valor = Double.parseDouble(v1.toString()) < Double.parseDouble(v2.toString());   
                break;                
            default:
                entorno.ventana.setSalida("Error de tipos en multiplicación linea:"+linea + "\tColumna:"+columna);
                break;
        }         
        
    }
    
    @Override
    public Nodo ejecutar(Entorno entorno) {
        setValor(entorno);
        return this;
    }
    
}
