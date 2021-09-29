public class Combatiente {

    //-----PROPIEDADES-----
    protected String tipo;
    protected int vida;
    protected int ataque;
    protected String habilidad;
    protected String msgIncio;
    protected String msgDerrota;
    protected String msgVictoria;

    public Combatiente(String t){
        this.tipo = t;

        if(this.tipo.equals("Guerrero")){
            this.vida = 50;
            this.ataque = 5;
            this.habilidad = "item";
            this.msgIncio = "Soy el mejor guerrero de este reino, preparense para ser derrotados.";
            this.msgDerrota = "He perecido, ha sido un honor pelear por este reino.";
        }
        if(this.tipo.equals("Explorador")){
            this.vida = 30;
            this.ataque = 3;
            this.habilidad = "item";
            this.msgIncio = "Se sorprenderan al ver todo lo que un explorador tiene preparado, suerte.";
            this.msgDerrota = "Parece que no pude cumplir mi objetivo.";
        }
        if(this.tipo.equals("Duende")){
            this.vida = 15;
            this.ataque = 2;
            this.habilidad = "especial";
            this.msgIncio = "Dennos vuestro oro o destruiremos su reino.";
            this.msgDerrota = "AaaAaHhHHh";
        }
        if(this.tipo.equals("Hechicero")){
            this.vida = 20;
            this.ataque = 5;
            this.habilidad = "especial";
            this.msgIncio = "Preparense para ser aniquilados por mi magia negra.";
            this.msgDerrota = "Algun dia regresaré y los destruire junto con este reino.";
        }
    }

    public String getTipo(){
        return tipo;
    }

    public int getVida(){
        return vida;
    }

    public int getAtaque(){
        return ataque;
    }

    public String getMsgInicio(){
        return this.msgIncio;
    }

    public String getMsgDerrota(){
        return this.msgDerrota;
    }

    public String getMsgVictoria(){
        return this.msgVictoria;
    }

    public void setVida(int d){
        this.vida -= d;
    }

    public String ataque(Combatiente obj, int d){
        obj.setVida(d);
        String msg = "Se ha atacado a "+obj;
        return msg;
    }

    public String ataque(Combatiente obj){
        obj.setVida(ataque);
        String msg = "Se ha atacado a "+obj;
        return msg;
    }

    public String habilidad(String habilidad, Combatiente obj){
        String msg = "Se ha ejecutado la habilidad "+habilidad+" en contra de "+obj;
        return msg;
    }

    public String curarVida(Combatiente obj, int v){
        obj.vida += v;
        String msg = "Se ha restaurado la vida de "+obj;
        return msg;
    }

    public void incrAtaque(Combatiente obj, int c){
        obj.ataque += c;
    }

    public void dismAtaque(Combatiente obj, int c){
        obj.ataque -= c;
    }
}