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
public class BoolExp extends Exp{
    public boolean bool ;
    public BoolExp(boolean b)
    {
        bool = b;
    }

    public void setValor()
    {
        valor = bool;
    }

    @Override
    public Nodo ejecutar(Entorno entorno) {
        setValor();
        return this;
    }
}
