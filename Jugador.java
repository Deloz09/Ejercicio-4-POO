public class Jugador extends Combatiente{
    
    //-----PROPIEDADES-----
    protected int items;

    public Jugador(String tipo){
        super(tipo);

        if(this.tipo.equals("Guerrero")){
            this.items = 5;
        }
        if(this.tipo.equals("Explorador")){
            this.items = 10;
        }
    }

    public String habilidad(Combatiente obj, String it){
        String msg = "";

        if(items > 0){
            if(it.equals("Botiquin")){
                items--;
                curarVida(obj, 5);
                msg = "Se ha utlizado un botiquin.";
            }

            if(it.equals("Pocion de fuerza")){
                items--;
                incrAtaque(obj, 2);
                msg = "Se ha utilzado una pocion de fuerza.";
            }

            if(it.equals("Carga Espada Ancestral")){
                items-=2;
                ataque(obj, 10);
                msg = "Se ha utilizado una carga de Espada Ancestral contra "+obj;
            }

            if(it.equals("Hoja Oculta")){
                items-=2;
                ataque(obj, 8);
                msg = "Se ha utilizado la hoja oculta contra "+obj;
            }

            if(it.equals("Ballesta Portable")){
                items-=2;
                ataque(obj, 6);
                msg = "Se ha utilizado la ballesta portable contra "+obj;
            }else{
                msg = "Este item no existe.";
            }
        }else{
            msg = "¡Te has quedado sin items!";
        }
        return msg;
    }
}
