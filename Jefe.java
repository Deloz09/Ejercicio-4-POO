public class Jefe extends Enemigo{
    
    protected String habilidadJefe;

    public Jefe(String tipo){
        super(tipo);

        if(this.tipo.equals("Duende")){
            this.habilidad = "Aplasta Calabazas";
            carga = 10;
            this.vida = this.vida*2;
        }

        if(this.tipo.equals("Hechicero")){
            this.habilidad = "Pocion Curacion Maximizada";
            carga = 10;
            this.vida = this.vida*2;
        }
    }
}
