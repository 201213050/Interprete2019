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
public abstract class Nodo 
{
    public Object valor;
    public int linea, columna;    
    public abstract Nodo ejecutar(Entorno entorno);
}
