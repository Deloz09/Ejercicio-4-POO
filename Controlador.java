/**
 * Clase Controlador
 * Encargada de ejecutar el programa, llevar a cabo la seleccion de opciones, comunicarse con las
 * demás clases y sus respectivos procesos.
 * 
 * @version 1.0, 27/09/2021
 * finalizacion 28/09/2021
 * 
 * @author Diego E. Lemus L. - 21469
 */

public class Controlador {
    
    /** 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        
        //-----PROPIEDADES-----
        Juego juego = new Juego();
        Vista vista = new Vista();
        Combatiente jugador = null;
        int op = 0;

        try{
            //Muestra la bienvenida
            vista.bienvenida();
            int turnos = 0;

            //Pide el tipo de Jugador
            String tipo = vista.pedirTipo();
            //Genera el jugador
            jugador = new Jugador(tipo);
            //Muestra el mensaje de inicio del jugador
            String msgInicio = jugador.getMsgInicio();
            vista.msgIncio(msgInicio);

            //Genera los enemigos
            String msgInicioEnemigos = juego.generarEnemigos();
            //Muestra el mensaje de inicio de los enemigos
            vista.msgIncio(msgInicioEnemigos);

            while(op!=4){
                //Muestra el menu
                op = vista.mostrarMenu();
                //Muestra el historial
                String historial = juego.mostrarHistorial();
                vista.historial(historial);

                switch(op){

                    //OPCION 1: Atacar
                    case 1:
                        //Pide el objetivo del ataque
                        int id = vista.pedirObjetivo();
                        Combatiente objetivo = juego.getObjetivo(id);
                        juego.atacar(objetivo, id);
                        //Verifica si hubo una derrota
                        String derrota = juego.derrota();
                        vista.msgMuerte(derrota);
                        //Muestra los resultados del turno
                        String resultado = juego.resultado();
                        vista.mostrarResultado(resultado);

                        //Se confirma si el juego sigue
                        if(juego.getGame()==true){
                            op = 4;  
                        }

                        turnos++;
                    break;

                    //OPCION 2: Usar habilidad
                    case 2:
                        //Pide la habilidad a utilizar
                        String habilidad = vista.pedirHabilidad();
                        int id2 = vista.pedirObjetivo();
                        //Pide el objetivo del ataque
                        Combatiente objetivo2 = juego.getObjetivo(id2);
                        juego.usarHabilidad(habilidad, objetivo2, id2);
                        //Verifica si hubo una derrota
                        String derrota2 = juego.derrota();
                        vista.msgMuerte(derrota2);
                        //Muestra los resultados del turno
                        String resultado2 = juego.resultado();
                        vista.mostrarResultado(resultado2);

                        //Se confirma si el juego sigue
                        if(juego.getGame()==true){
                            op = 4;  
                        }

                        turnos++;
                    break;
                    
                    //OPCION 3: Pasar turno
                    case 3:
                        juego.pasarTurno();
                        turnos++;
                    break;

                    //OPCION 4: Salir
                    case 4:
                        op = 4;
                    break;

                    default://En caso de valor de opcion invalido
                    vista.avisoError();       
                }
            }
            vista.turnos(turnos);
            //Mensaje de despedida
            vista.despedida();
        }catch(Exception e){
           vista.avisoError();
        }
    }
}
