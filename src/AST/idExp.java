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
public class idExp extends Exp{
    public String id;
    public idExp(String i)
    {
        id = i;
    }
    
    public void setValor(Entorno entorno)
    {
        valor = entorno.getValor(id);
    }

    @Override
    public Nodo ejecutar(Entorno entorno) {
        setValor(entorno);
        return this;
    }
}
