import java.util.ArrayList;
import java.util.Random;

public class Juego {
    private Random rand = new Random();
    private ArrayList<Combatiente> combatientes = new ArrayList<Combatiente>();
    private ArrayList<Enemigo> enemigos = new ArrayList<Enemigo>();
    private int cantEnemigos = 3;
    private ArrayList<String> historial = new ArrayList<String>();
    private boolean gameover = false;

    public Juego(){
        for(int i=0;i<3;i++){
            historial.add("");
        }
    }
    
    public void accion(String a){
        historial.add(a);
    }
    
    public String generarEnemigos(){
        String msg = "";
        int num =  rand.nextInt(3)+1;

        if(num==3){
            Enemigo duende = new Enemigo("Duende");
            enemigos.add(duende);
            msg += duende.getMsgInicio();
            Enemigo duende2 = new Enemigo("Duende");
            enemigos.add(duende2);
            msg += duende2.getMsgInicio();
            Enemigo duende3 = new Enemigo("Duende");
            enemigos.add(duende3);
            msg += duende3.getMsgInicio();
        }
        if(num==2){
            Enemigo duende = new Enemigo("Duende");
            enemigos.add(duende);
            msg += duende.getMsgInicio();
            Enemigo duende2 = new Enemigo("Duende");
            enemigos.add(duende2);
            msg += duende2.getMsgInicio();
            Enemigo hechicero = new Enemigo("Hechicero");
            enemigos.add(hechicero);
            msg += hechicero.getMsgInicio();
        }
        if(num==1){
            Enemigo duende = new Enemigo("Duende");
            enemigos.add(duende);
            msg += duende.getMsgInicio();
            Enemigo hechicero = new Enemigo("Hechicero");
            enemigos.add(hechicero);
            msg += hechicero.getMsgInicio();
            Enemigo hechicero2 = new Enemigo("Hechicero");
            enemigos.add(hechicero2);
            msg += hechicero2.getMsgInicio();
        }
        return msg;
    }

    public String generarJefeEnemigo(){
        String msg = "";
        int num =  rand.nextInt(2)+1;
        
        if(num==1){
            Enemigo jefe = new Jefe("Duende");
            enemigos.add(jefe);
            msg = "Se ha generado un nuevo jefe "+jefe.getTipo();
        }else if(num==2){
            Enemigo jefe = new Jefe("Hechicero");
            enemigos.add(jefe);
            msg = "Se ha generado un nuevo jefe "+jefe.getTipo();
        }
        return msg;
    }

    public String mostrarHistorial() throws Exception{
        String historialS = "";

        try{
            int historialT = this.historial.size();
            if(historialT>1){
                for (int i = historialT-1; i >= historialT-3; i--)
                    if (this.historial.get(i) != null)
                        historialS += this.historial.get(i) + "\n";
            }else{
                historialS = "No se ha realziado ninguna accion todavia.";
            }
        }catch(Exception e){
            String s = "Error en el historial " + e.getMessage();
            throw new Exception(s);
        }
        return historialS;
    }

    public void atacar(Combatiente obj, int id) throws Exception{
        try{
            if(combatientes.get(id) != null){
                String ataque = combatientes.get(id).ataque(obj);
                accion(ataque);
            }
        }catch(Exception e){
            String s = "Error en accion: atacar "+e.getMessage();
            throw new Exception(s);
        }
    }

    public Combatiente getObjetivo(int obj) throws Exception{
        Combatiente combatiente = null;

        try{
            combatiente = combatientes.get(obj);
        } catch (Exception e){
            String s = "Error al seleccionar objetivo" + e.getMessage();
			throw new Exception(s);
        }
        return combatiente;
    }

    public void usarHabilidad(String hab, Combatiente obj, int id) throws Exception{
        try{
            if(combatientes.get(id) != null){
                String habilidad = combatientes.get(id).habilidad(hab, obj);
                accion(habilidad);
            }
        }catch(Exception e){
            String s = "Error en accion: habilidad "+e.getMessage();
            throw new Exception(s);
        }
    }

    public String derrota(){
        String derrotas = "";

        for (int i = 0; i < combatientes.size(); i++){
            if(combatientes.get(i) != null){
                if (combatientes.get(i).getVida() <= 0){
                    derrotas += combatientes.get(i).getMsgDerrota();
                    String derrota = combatientes.get(i) + " ha sido derrotado";
                    accion(derrota);
                    if(combatientes.get(i).getTipo().equals("Explorador") || combatientes.get(i).getTipo().equals("Guerrero"))
                        gameover = true;
                    else
                        cantEnemigos--;
                    combatientes.remove(combatientes.get(i));
                }
            }
        }
        if(cantEnemigos==1){
            generarJefeEnemigo();
        }

        return derrotas;
    }

    public String resultado(){
        String resultado = "";
        if(cantEnemigos == 0){
            resultado = combatientes.get(0).getMsgVictoria();
        }else if(gameover == true){
            for (int i = 1; i < combatientes.size(); i++){
                if(enemigos.get(i) != null){
                    resultado += "\n" + combatientes.get(i).getMsgVictoria();
                }
            }
        }else{
            for (int i = 1; i < combatientes.size(); i++){
                if(enemigos.get(i) != null){
                    resultado += "\n" + combatientes.get(i).getMsgVictoria();
                }
            }
        }
        return resultado;
    }

    public void pasarTurno(){
        String msg = "Se ha elegido pasar turno";
        accion(msg);
    }

    public boolean getGame(){
        return gameover;
    }
}
