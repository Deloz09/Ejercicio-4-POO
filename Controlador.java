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

            String tipo = vista.pedirTipo();
            jugador = new Jugador(tipo);
            String msgInicio = jugador.getMsgInicio();
            vista.msgIncio(msgInicio);

            String msgInicioEnemigos = juego.generarEnemigos();
            vista.msgIncio(msgInicioEnemigos);

            while(op!=4){
                //Muestra el menu
                op = vista.mostrarMenu();

                String historial = juego.mostrarHistorial();
                vista.historial(historial);

                switch(op){

                    //OPCION 1: Atacar
                    case 1:
                        int id = vista.pedirObjetivo();
                        Combatiente objetivo = juego.getObjetivo(id);
                        juego.atacar(objetivo, id);

                        String derrota = juego.derrota();
                        vista.msgMuerte(derrota);
                        
                        String resultado = juego.resultado();
                        vista.mostrarResultado(resultado);

                        if(juego.getGame()==true){
                            op = 4;  
                        }

                        turnos++;
                    break;

                    //OPCION 2: Usar habilidad
                    case 2:
                        String habilidad = vista.pedirHabilidad();
                        int id2 = vista.pedirObjetivo();

                        Combatiente objetivo2 = juego.getObjetivo(id2);
                        juego.usarHabilidad(habilidad, objetivo2, id2);

                        String derrota2 = juego.derrota();
                        vista.msgMuerte(derrota2);
                        
                        String resultado2 = juego.resultado();
                        vista.mostrarResultado(resultado2);

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
