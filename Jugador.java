/**
 * Clase Jugador
 * Clase hija de Combatiente, tiene las propiedades del jugador y sus metodos.
 * 
 * @version 1.0, 27/09/2021
 * finalizacion 28/09/2021
 * 
 * @author Diego E. Lemus L. - 21469
 */

public class Jugador extends Combatiente{
    
    //-----PROPIEDADES-----
    protected int items;

    //-----METODOS-----
    /** 
     * Metodo constructor del jugador (combatiente)
     */
    public Jugador(String tipo){
        super(tipo);

        if(this.tipo.equals("Guerrero")){
            this.items = 5;
        }
        if(this.tipo.equals("Explorador")){
            this.items = 10;
        }
    }

    /** 
     * Metodo para que el jugador utilice su habilidad especial (item)
     * @param obj
     * @param it
     * @return String
     */
    public String habilidad(Combatiente obj, String it){
        String msg = "";

        if(items > 0){
            //Item: Botiquin
            if(it.equals("Botiquin")){
                items--;
                curarVida(obj, 5);
                msg = "Se ha utlizado un botiquin.";
            }

            //Item: Pocion de fuerza
            if(it.equals("Pocion de fuerza")){
                items--;
                incrAtaque(obj, 2);
                msg = "Se ha utilzado una pocion de fuerza.";
            }

            //Item: Carga Espada Ancestral
            if(it.equals("Carga Espada Ancestral")){
                items-=2;
                ataque(obj, 10);
                msg = "Se ha utilizado una carga de Espada Ancestral contra "+obj;
            }

            //Item: Hoja Oculta
            if(it.equals("Hoja Oculta")){
                items-=2;
                ataque(obj, 8);
                msg = "Se ha utilizado la hoja oculta contra "+obj;
            }

            //Item: Ballesta Portable
            if(it.equals("Ballesta Portable")){
                items-=2;
                ataque(obj, 6);
                msg = "Se ha utilizado la ballesta portable contra "+obj;
            }else{
                //Si el item no existe
                msg = "Este item no existe.";
            }
        //Si el jugador se quedo sin items
        }else{
            msg = "¡Te has quedado sin items!";
        }
        return msg;
    }
}
