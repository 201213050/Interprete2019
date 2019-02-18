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
public class Imprimir extends Sentencia {
    public Exp exps;
    public Imprimir(Exp e)
    {
        exps = e;
    }
    
    public void setValor(Entorno entorno)
    {
        valor = exps.ejecutar(entorno).valor;        
    }
    @Override
    public Nodo ejecutar(Entorno entorno) 
    {
        setValor(entorno);                
        entorno.ventana.setSalida(valor.toString());
        return this;
    }
}
