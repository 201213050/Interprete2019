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
public class Or extends Exp
{
    public Exp valor1;
    public Exp valor2;
    
    public Or(Exp val1, Exp val2)
    {
        this.valor1 = val1;
        this.valor2 = val2;
    }

    public void setValor(Entorno entorno)
    {
        Object val1 = this.valor1.ejecutar(entorno);
        Object val2 = this.valor2.ejecutar(entorno);
        
        if((val1 instanceof Boolean) && (val2 instanceof Boolean))
        {
            Boolean v1 = (Boolean)val1;
            Boolean v2 = (Boolean)val2;            
            this.valor = Boolean.toString(v1 || v2);
        }        
    }
    
    @Override
    public Nodo ejecutar(Entorno entorno) 
    {
        setValor(entorno);
        return this;
    }


    
}
