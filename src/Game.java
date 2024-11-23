import java.io.IOException;
import java.util.Scanner;

public class Game {
    Scanner sc = new Scanner(System.in);
    Jugador j1 = new Jugador();
    Jugador cpu = new Jugador();
    
    public Game(){
        
    }

    public void iniciarJuego(){
        mostrarTitulo();
        pedirNombre();
        juego();
    }
        
    
    public void juego(){
        do { 
            menu();
        } while (j1.getVidas()!= 0 && cpu.getVidas()!=0);

        if(cpu.getVidas()==0)
            System.out.println(j1.getNombre()+" es el ganador\n");
        else
            System.out.println("Cpu es el ganador");
        
    }
    
    private void menu(){
        System.out.print("\n"+j1.getNombre()+":"+corazones(j1));
        System.out.print("    ");
        System.out.print(cpu.getNombre()+":"+corazones(cpu)+"\n");
        int r; 
        boolean continuar = false;

        do { 
            System.out.println("1)Piedra\n2)Papel\n3)Tijera\n4)Aleatorio");
            r = sc.nextInt();
            System.out.println("\033c");

            switch (r) {
                case 1 -> {
                    j1.setAccion("piedra");
                    cpu.setAccion(cpu.accionAleatoria());
                    mostrarEleccion();
                    ganadorDuelo();
                    continuar=true;
                }
                case 2 -> {
                    j1.setAccion("papel");
                    cpu.setAccion(cpu.accionAleatoria());
                    mostrarEleccion();
                    ganadorDuelo();
                    continuar=true;
                }
                case 3 -> {
                    j1.setAccion("tijera");
                    cpu.setAccion(cpu.accionAleatoria());
                    mostrarEleccion();
                    ganadorDuelo();
                    continuar=true;
                }
                case 4 ->{
                    j1.setAccion(j1.accionAleatoria());
                    cpu.setAccion(cpu.accionAleatoria());
                    mostrarEleccion();
                    ganadorDuelo();
                    continuar=true;
                }
                
                default -> System.out.println("Error, fuera de rango\n");
            }
        } while (!continuar);


    }

    private String corazones(Jugador j){
        String c="";
        for(int i=0;i<j.getVidas();i++){
            c=c+"<3 ";
        }

        return c;
    }
    
    private void ganadorDuelo(){
        if(j1.getAccion().equals(cpu.getAccion())){
            System.out.println("EMPATE\n");
            limpiarPantalla();
        }
        
        //acciones para ganar p1
        if(j1.getAccion().equals("piedra") && cpu.getAccion().equals("tijera")){
            cpu.perderVida();
            System.out.print(j1.getNombre()+" a destrozado las tijeras de CPU\n");
            limpiarPantalla();
        }

        if(j1.getAccion().equals("papel") && cpu.getAccion().equals("piedra")){
            cpu.perderVida();
            System.out.print(j1.getNombre()+" a envuelto la piedra de CPU\n");
            limpiarPantalla();
        }

        if(j1.getAccion().equals("tijera") && cpu.getAccion().equals("papel")){
            cpu.perderVida();
            System.out.print(j1.getNombre()+" a cortado al CPU\n");
            limpiarPantalla();
        }

        //acciones para ganar cpu
        //acciones para ganar p1
        if(j1.getAccion().equals("piedra") && cpu.getAccion().equals("papel")){
            j1.perderVida();
            System.out.print("CPU a envuelta la piedra de "+j1.getNombre()+"\n");
            limpiarPantalla();
        }

        if(j1.getAccion().equals("papel") && cpu.getAccion().equals("tijera")){
            j1.perderVida();
            System.out.print("CPU a cortado en trozos al papel de "+j1.getNombre()+"\n");
            limpiarPantalla();
        }

        if(j1.getAccion().equals("tijera") && cpu.getAccion().equals("piedra")){
            j1.perderVida();
            System.out.print("CPU a reventado a piedrazos la tijera de "+j1.getNombre()+"\n");
            limpiarPantalla();
        }
    }

    
    private void limpiarPantalla(){
        try {
            System.in.read();  
        } catch (IOException e) {
            
        }
        System.out.println("\033c");
    }
    
    private void mostrarEleccion(){
        
        secuencia();
        //mostrar lo elejido por el jugador
        if(j1.getAccion().equals("piedra"))
            mostrarPiedra(1);
        
        if(j1.getAccion().equals("papel"))
            mostrarPapel(1);

        if(j1.getAccion().equals("tijera"))
            mostrarTijera(1);
        
        //mostrar lo elegido por la cpu

        if(cpu.getAccion().equals("piedra"))
            mostrarPiedra(2);
        
        if(cpu.getAccion().equals("papel"))
            mostrarPapel(2);

        if(cpu.getAccion().equals("tijera"))
            mostrarTijera(2);
        
    }



    private void secuencia(){
        System.out.println("\nPIEDRA");
        esperar();
        System.out.println("PAPEL");
        esperar();
        System.out.println("TIJERA\n");
        esperar();
        System.out.println("\033c");
    }
    
    private void esperar(){
        try {
            Thread.sleep(1000);  
        } catch (InterruptedException e) {
            
        }
    }
    
    private void mostrarTitulo() {
        System.out.println("  _____ _____ ______ _____  _____              _____        _____  ______ _        _______ _____     _ ______ _____");
        System.out.println(" |  __ \\_   _|  ____|  __ \\|  __ \\     /\\     |  __ \\ /\\   |  __ \\|  ____| |      |__   __|_   _|   | |  ____|  __ \\     /\\");
        System.out.println(" | |__) || | | |__  | |  | | |__) |   /  \\    | |__) /  \\  | |__) | |__  | |         | |    | |     | | |__  | |__) |   /  \\");
        System.out.println(" |  ___/ | | |  __| | |  | |  _  /   / /\\ \\   |  ___/ /\\ \\ |  ___/|  __| | |         | |    | | _   | |  __| |  _  /   / /\\ \\");
        System.out.println(" | |    _| |_| |____| |__| | | \\ \\  / ____ \\  | |  / ____ \\| |    | |____| |____     | |   _| || |__| | |____| | \\ \\  / ____ \\");
        System.out.println(" |_|   |_____|______|_____/|_|  \\_\\/_/    \\_\\ |_| /_/    \\_\\_|    |______|______|    |_|  |_____\\____/|______|_|  \\_\\/_/    \\_\\");
        System.out.println("                                                                                                                         BY KNE\n");
        
    }

    private void pedirNombre(){
        System.out.println("Nombre:");
        
        j1.setNombre(sc.nextLine());
        cpu.setNombre("CPU");
        System.out.println("\033c");
        
    }

    private void mostrarPiedra(int n){
        //muestra el del jugador
        if(n==1){
            System.out.println("    _______");
            System.out.println("---'   ____)");
            System.out.println("      (_____)");
            System.out.println("      (_____)");
            System.out.println("      (____)");
            System.out.println("---.__(___)");
        }
        //muestra el de la pc
        if(n==2){
            System.out.println("    _______");
            System.out.println("   (____   '---");
            System.out.println("  (_____)");
            System.out.println("  (_____)");
            System.out.println("   (____)");
            System.out.println("    (___)__.---");
        }
    }

    private void mostrarPapel(int n){
        
        if(n==1){
            System.out.println("     _______");
            System.out.println("---'    ____)");
            System.out.println("           ______)");
            System.out.println("          _______)");
            System.out.println("         _______)");
            System.out.println("---.__________)");
        }

        if(n==2){
            System.out.println("         _______");
            System.out.println("    ____(____   '---");
            System.out.println("   (______");
            System.out.println("   (_______");
            System.out.println("    (_______");
            System.out.println("     (__________.---");
        }
    }

    public void mostrarTijera(int n){
        
        if(n==1){
            System.out.println("    _______");
            System.out.println("---'   ____)____");
            System.out.println("          ______)");
            System.out.println("       __________)");
            System.out.println("      (____)");
            System.out.println("---.__(___)");
        }

        if(n==2){
            System.out.println("        _______");
            System.out.println("   ____(____   '---");
            System.out.println("  (______");
            System.out.println(" (__________");
            System.out.println("       (____)");
            System.out.println("        (___)__.---");
        }
    }


    
}
