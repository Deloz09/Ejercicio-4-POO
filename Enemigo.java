/**
 * Clase Enemigo
 * Clase hija de Combatiente, tiene las propiedades de los enemigos y sus metodos.
 * 
 * @version 1.0, 27/09/2021
 * finalizacion 28/09/2021
 * 
 * @author Diego E. Lemus L. - 21469
 */

 public class Enemigo extends Combatiente{

    //-----PROPIEDADES-----
    protected String habilidad;
    protected int carga;

    //-----METODOS-----
    /** 
     * Metodo constructor del enemigo (combatiente)
     */
    public Enemigo(String tipo){
        super(tipo);

        if(this.tipo.equals("Duende")){
            this.habilidad = "Horda";
            carga = 6;
        }

        if(this.tipo.equals("Hechicero")){
            this.habilidad = "Pocion Curacion";
            carga = 6;
        }
    }

    /** 
     * Metodo para que el enemigo utilice su habilidad especial
     * @param obj
     * @param it
     * @return String
     */
    public String habilidadEspecial(Combatiente obj, String it){
        String msg = "";
        
        if(this.carga < 0){
            //Enemigo tipo Duende - Horda
            if(this.tipo.equals("Duende")){
                if(habilidad.equals("Horda")){
                    ataque(obj, 7);
                    carga-=2;
                    msg = this.tipo +" ha utilizado el ataque horda contra "+obj;
                }
            }
            //Enemigo tipo hechicero - Pocion Curacion
            if(this.tipo.equals("Hechicero")){
                if(habilidad.equals("Pocion Curacion")){
                    curarVida(obj, 4);
                    carga-=2;
                    msg = this.tipo +" ha utlizado una pocion de curacion.";
                }
            }
            //En caso de elegir una habilidad que no existe
            else{
                msg = "Esta habilidad no existe.";
            }
        //En caso de que el enemigo se quede sin cargas de habilidad
        }else{
            msg = "El enemigo se ha quedado sin cargas";
        }
        return msg;
    }

    /** 
     * Metodo para obtener el tipo del enemigo
     * @return String
     */
    public String getTipo(){
        return this.tipo;
    }

    /** 
     * Metodo para obtener la carga de habilidad del enemigo
     * @return int
     */
    public int getCarga(){
        return this.carga;
    }
}
