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
public class DoubleExp extends Exp{
    public double num;
    public DoubleExp(double n)
    {
        num = n;
    }

    public void setValor()
    {
        valor = num;
    }
    
    @Override
    public Nodo ejecutar(Entorno entorno) {
        setValor();
        return this;
    }
}
