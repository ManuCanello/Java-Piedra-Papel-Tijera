import java.util.Random;

public class Jugador {
    
    private int vidas = 3;
    private String nombre;
    private String accion;
    
    
    public Jugador(){
        
    }

    public void setNombre(String n){
        this.nombre = n;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setAccion(String a){
        this.accion = a;
    }

    public String getAccion(){
        return this.accion;
    }

    public void perderVida(){
        if(this.vidas!=0)
            vidas--;
    }

    public int getVidas(){
        return this.vidas;
    }

    public String accionAleatoria(){
        Random random = new Random();
        int n = random.nextInt(3) + 1;

        if(n==1)
            return "piedra";
        
        if(n==2)
            return "papel";

        if(n==3)
            return "tijera";
        
        return "";
    }


}
