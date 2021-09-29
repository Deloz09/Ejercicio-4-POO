/**
 * Clase Combatiente
 * Encargada de simular a un combatiente, junto a sus caracteristicas.
 * 
 * @version 1.0, 27/09/2021
 * finalizacion 28/09/2021
 * 
 * @author Diego E. Lemus L. - 21469
 */

public class Combatiente {

    //-----PROPIEDADES-----
    protected String tipo;
    protected int vida;
    protected int ataque;
    protected String habilidad;
    protected String msgIncio;
    protected String msgDerrota;
    protected String msgVictoria;

    //-----METODOS-----
    /** 
     * Metodo constructor del combatiente
     */
    public Combatiente(String t){
        this.tipo = t;

        //Jugador Guerrero
        if(this.tipo.equals("Guerrero")){
            this.vida = 50;
            this.ataque = 5;
            this.habilidad = "item";
            this.msgIncio = "Soy el mejor guerrero de este reino, preparense para ser derrotados.";
            this.msgDerrota = "He perecido, ha sido un honor pelear por este reino.";
        }
        //Jugador Explorador
        if(this.tipo.equals("Explorador")){
            this.vida = 30;
            this.ataque = 3;
            this.habilidad = "item";
            this.msgIncio = "Se sorprenderan al ver todo lo que un explorador tiene preparado, suerte.";
            this.msgDerrota = "Parece que no pude cumplir mi objetivo.";
        }
        //Enemigo Duende
        if(this.tipo.equals("Duende")){
            this.vida = 15;
            this.ataque = 2;
            this.habilidad = "especial";
            this.msgIncio = "Dennos vuestro oro o destruiremos su reino.";
            this.msgDerrota = "AaaAaHhHHh";
        }
        //Enemigo Hechicero
        if(this.tipo.equals("Hechicero")){
            this.vida = 20;
            this.ataque = 5;
            this.habilidad = "especial";
            this.msgIncio = "Preparense para ser aniquilados por mi magia negra.";
            this.msgDerrota = "Algun dia regresaré y los destruire junto con este reino.";
        }
    }

    /** 
     * Metodo para obtener el tipo del combatiente
     * @return String
     */
    public String getTipo(){
        return tipo;
    }

    /** 
     * Metodo para obtener la vida del combatiente
     * @return int
     */
    public int getVida(){
        return vida;
    }

    /** 
     * Metodo para obtener el ataque del combatiente
     * @return int
     */
    public int getAtaque(){
        return ataque;
    }

    /** 
     * Metodo para obtener el mensaje de inicio del combatiente
     * @return String
     */
    public String getMsgInicio(){
        return this.msgIncio;
    }

    /** 
     * Metodo para obtener el mensaje de derrota del combatiente
     * @return String
     */
    public String getMsgDerrota(){
        return this.msgDerrota;
    }

    /** 
     * Metodo para obtener el mensaje de victoria del combatiente
     * @return String
     */
    public String getMsgVictoria(){
        return this.msgVictoria;
    }

    /** 
     * Metodo para modificar la vida del combatiente
     * @param d
     */
    public void setVida(int d){
        this.vida -= d;
    }

    /** 
     * Metodo de ataque del combatiente
     * @param obj
     * @param d
     * @return String
     */
    public String ataque(Combatiente obj, int d){
        obj.setVida(d);
        String msg = "Se ha atacado a "+obj;
        return msg;
    }

    /** 
     * Metodo de ataque del combatiente
     * @param obj
     * @return String
     */
    public String ataque(Combatiente obj){
        obj.setVida(ataque);
        String msg = "Se ha atacado a "+obj;
        return msg;
    }

    /** 
     * Metodo de uso de habilidad del combatiente
     * @param habilidad
     * @param obj
     * @return String
     */
    public String habilidad(String habilidad, Combatiente obj){
        String msg = "Se ha ejecutado la habilidad "+habilidad+" en contra de "+obj;
        return msg;
    }

    /** 
     * Metodo para curar la vida del combatiente
     * @param obj
     * @param v
     * @return String
     */
    public String curarVida(Combatiente obj, int v){
        obj.vida += v;
        String msg = "Se ha restaurado la vida de "+obj;
        return msg;
    }

    /** 
     * Metodo para incrementar el ataque del combatiente
     * @param obj
     * @param c
     */
    public void incrAtaque(Combatiente obj, int c){
        obj.ataque += c;
    }

    
    /** 
     * Metodo para disminuir el ataque del combatiente
     * @param obj
     * @param c
     */
    public void dismAtaque(Combatiente obj, int c){
        obj.ataque -= c;
    }
}