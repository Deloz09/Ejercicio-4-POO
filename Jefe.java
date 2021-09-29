/**
 * Clase Enemigo
 * Clase hija de Combatiente, tiene las propiedades de los jefes enemigos y sus metodos.
 * 
 * @version 1.0, 27/09/2021
 * finalizacion 28/09/2021
 * 
 * @author Diego E. Lemus L. - 21469
 */

 public class Jefe extends Enemigo{
    
    //-----PROPIEDADES-----
    protected String habilidadJefe;

    //-----METODOS-----
    /** 
     * Metodo constructor del JEFE enemigo (combatiente)
     */
    public Jefe(String tipo){
        super(tipo);
        //Jefe enemigo Duende
        if(this.tipo.equals("Duende")){
            this.habilidad = "Aplasta Calabazas";
            carga = 10;
            this.vida = this.vida*2;
        }
        //Jefe enemigo Hechicero
        if(this.tipo.equals("Hechicero")){
            this.habilidad = "Pocion Curacion Maximizada";
            carga = 10;
            this.vida = this.vida*2;
        }
    }
}
