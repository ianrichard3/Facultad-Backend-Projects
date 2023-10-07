package org.example;


/*
1. Ejercicio Tamagotchi
Introducción
Modelar e implementar en java la clase "Mascota" a partir de la cual se puedan instanciar
objetos que representan una
mascota virtual en una aplicación que emula este tipo de juegos.
Esencialmente la mascota tiene energía un número entero entre 0 y 100 y humor un valor
entero entre 1 y 5 que significa: muy enojado, enojado, neutral, contento y chocho
respectivamente desde el 1 hasta el 5.
Dicha mascota debe responder a los siguientes mensajes implementados en comportamientos
que están divididos en comportamientos de ingesta, comportamientos de actividad y otros.
Comportamientos de ingesta:
comer => incrementa la energía (que es un número entre 0 y 100 unidades) en 10% de la
energía que tiene la mascota y incrementa el humor en 1 nivel.
beber => incrementa la energía (que es un número entre 0 y 100 unidades) en 5% de la
energía que tiene la mascota y incrementa el humor en 1 nivel.
Comportamientos de actividades:
correr => decrementa la energía en un 35% de la energía que tiene la mascota.
Y decrementa el humor en 2 niveles.
saltar => decrementa la energía en un 15% de la energía que tiene la mascota.
Y decrementa el humor en 2 niveles.
Otros comportamientos:
dormir => la mascota pasa a estado durmiendo y no responde a ningún otro
comportamiento excepto despertar. Además la energía se incrementa en 25 unidades
y el humor en 2 niveles.
despertar => la mascota pasa a estado despierta y comienza a responder a los
demás comportamientos. Además el humor se decrementa en un nivel.

Por otro lado se deben respetar las siguientes reglas adicionales para todos
los comportamientos en general:
1 - A partir de la 3 ingesta consecutiva el nivel de humor comienza a decrementar
en 1 por cada ingesta.
2 - Cuando la energía llega a 0 la mascota muere de cansada.
3 - Si la mascota realiza 5 ingestas consecutivas muere de empacho.
4 - Si la mascota realiza 3 actividades consecutivas se empaca y se duerme.

Agregar además el comportamiento toString que devuelva una representación de
cadena de la mascota incluyendo su nombre, unidades de energía, nivel de alegría,
si duerme y si vive.
Notas:
1. la energía no puede superar 100 unidades, es decir si está en 100 no aumenta
 y si baja de cero la mascota muere y ya no responde más a ningún comportamiento.
2. el nivel de alegría fluctúa entre 1 muuuuy enojado y 5 chocho y si la alegría
llega a 0 la mascota se va a dormir por propia iniciativa.
3. cuando la mascota está en un estado que no responde a cierto comportamiento
el mismo debe retornar false y si el comportamiento se pudo realizar correctamente retorna true.

Ejercicio
Escribir la clase MascotaVirtual de forma que implemente comportamientos
 para contemplar todos los casos mencionados y responda al Test Unitario que agregaremos.
 */


import java.util.Scanner;

public class Mascota {

    private static void menu(){
        System.out.println(
                "| Menu de opciones |\n" +
                        "s - Salir\n" +
                        "e - Ver estado actual\n" +
                        "c - Comer\n" +
                        "b - beber\n" +
                        "r - correr\n" +
                        "j - saltar\n" +
                        "d - dormir\n" +
                        "w - despertar"
        );
    }




    public static void main(String[] args) {
        Mascot m1 = new Mascot("Flaquito Ian");
        Scanner scan = new Scanner(System.in);
        char opcion = '0';
        boolean murio = false;



        while (opcion != 's'){
            Mascota.menu();
            System.out.print(">>> ");
            opcion = scan.nextLine().charAt(0);
            if (m1.isDead() && !murio) {
                System.out.println("La mascota murio");
                murio = true;
            }

            switch (opcion){
                case 's':
                    System.out.println("Hasta luego");
                    break;
                case 'e':
                    System.out.println(m1.toString());
                    break;
                case 'c':
                    if (m1.comer()) System.out.println("Comiendo...");
                    break;
                case 'b':
                    if (m1.beber()) System.out.println("Bebiendo...");
                    break;
                case 'r':
                    if (m1.correr()) System.out.println("Corriendo...");
                    break;
                case 'j':
                    if (m1.saltar()) System.out.println("Saltando...");
                    break;
                case 'd':
                    if (m1.dormir()) System.out.println("Durmiendo...");
                    break;
                case '2':
                    if (m1.despertar()) System.out.println("Despertando...");
                    break;

                default:
                    System.out.println("Opcion Invalida");
            }


        }
    }

}



class Mascot {

    static String[] humores = new String[]
            {"A Dormir", "muy enojado", "enojado",
            "neutral", "contento", "chocho"};
    private String nombre;
    private double energia;
    private int humor;
    private String estado;
    private int cntIngestas;
    private int cntAct;

    public Mascot(String nombre) {
        this.nombre = nombre;
        this.energia = 100.0;
        this.humor = 3;
        this.estado = "Despierto";
        this.cntAct = 0;
        this.cntIngestas = 0;
    }

    public boolean isDead(){
        return (this.estado.equals("Muerto"));
    }


    public String toString(){
        String ret = "";
        ret += "Nombre: " + this.nombre + "\n";
        ret += "Energia: " + this.energia + "\n";
        ret += "Humor: " + this.getHumor() + "\n";
        ret += "Estado: " + this.estado + "\n";
        return ret;
    }

    private String getHumor() {
        return Mascot.humores[this.humor];
    }

    private boolean addEnergia(double energia){
        if (!(this.energia + energia <= 100.0)) return false;
        this.energia += energia;
        return true;
    }

    private boolean addPorcEnergia(double porc){
        double valor = this.energia * (porc/100.0);
        this.addEnergia(valor);
        return true;
    }

    private boolean addHumor(int hum) {
        if (!(this.humor + hum <= 5 && this.humor + hum >= 0)) return false;
        this.humor += hum;
        return true;
    }

    private boolean validarMuerte(){
        if (cntIngestas == 5 || cntAct == 3 || this.energia == 0.0) {
            this.estado = "Muerto";
            return false;
            }
        return true;
    }

    private boolean validarSuenio(){
        if (this.humor < 1 || cntAct >= 3) {
            this.dormir();
            return false;
        }
        return true;
    }


    public boolean ingerir(boolean isFood){
        if (!this.estado.equals("Despierto")) return false;

        this.cntIngestas += 1;
        this.cntAct = 0;
        if (isFood) this.addPorcEnergia(10);
        else this.addPorcEnergia(5);

        if (this.cntIngestas >= 3) this.addHumor(-1);
        else this.addHumor(1);

        this.validarMuerte();
        this.validarSuenio();


        return true;
    }
    public boolean comer(){
        return this.ingerir(true);
    }
    public boolean beber(){
        return this.ingerir(false);
    }

    public boolean actividad(boolean isRun){
        if (!this.estado.equals("Despierto")) return false;

        this.cntAct += 1;
        this.cntIngestas = 0;
        if (isRun) this.addPorcEnergia(-35);
        else this.addPorcEnergia(-15);
        this.addHumor(-2);
        return true;
    }


    public boolean correr() {
        return this.actividad(true);
    }

    public boolean saltar(){
        return this.actividad(false);
    }

    public boolean dormir(){
        if (!this.estado.equals("Despierto")) return false;
        this.estado = "Dormido";
        this.addEnergia(25);
        this.addHumor(2);
        this.cntAct = 0;
        this.cntIngestas = 0;
        return true;
    }

    public boolean despertar(){
        if (!this.estado.equals("Dormido")) return false;
        this.estado = "Despierto";
        this.addHumor(-1);
        this.cntAct = 0;
        this.cntIngestas = 0;
        return true;
    }

}