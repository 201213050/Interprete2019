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
public class Asignacion extends Sentencia{
    public String id;
    public Exp exp;
    public Asignacion(String i, Exp e)
    {
        id = i;
        exp = e;
    }

    public void setValor(Entorno entorno)
    {
        valor = entorno.actualizarSimbolo(id, exp.ejecutar(entorno).valor);
    }
    @Override
    public Nodo ejecutar(Entorno entorno) 
    {
        setValor(entorno);
        return this;
    }
}
