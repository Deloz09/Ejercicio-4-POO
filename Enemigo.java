public class Enemigo extends Combatiente{
    protected String habilidad;
    protected int carga;

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

    public String habilidadEspecial(Combatiente obj, String it){
        String msg = "";

        if(this.carga < 0){
            if(this.tipo.equals("Duende")){
                if(habilidad.equals("Horda")){
                    ataque(obj, 7);
                    carga-=2;
                    msg = this.tipo +" ha utilizado el ataque horda contra "+obj;
                }
            }

            if(this.tipo.equals("Hechicero")){
                if(habilidad.equals("Pocion Curacion")){
                    curarVida(obj, 4);
                    carga-=2;
                    msg = this.tipo +" ha utlizado una pocion de curacion.";
                }
            }
            else{
                msg = "Esta habilidad no existe.";
            }

        }else{
            msg = "El enemigo se ha quedado sin cargas";
        }

        return msg;
    }

    public String getTipo(){
        return this.tipo;
    }

    public int getCarga(){
        return this.carga;
    }
}
