package org.example;

/*
2. Puerto de Carga
El Puerto de Rosario nos ha solicitado el desarrollo de un programa con el propósito
 de conocer información referida al operatorio de carga y descarga en los diferentes
  muelles del mismo en un periodo de tiempo, para ello nos proveen de un archivo barcos.csv
   que contendrá dicha información, la cual deberemos importar en nuestro programa.
   A continuación detallamos el conjunto de clases que se desprendieron del análisis determinado.

- Puerto: que va a contener todos los barcos que necesitan ser procesados para
generar la informacion del sistema pedido
- Barco: qde una embarcacion se conoce matricula, numero de muelle de carga,
capacidad de carga permitida en toneladas, costo alquiler por hora de amarre y
 quien comanda la nave
- Capitan: abstraccion que representa a una persona a cargo de una embarcación,
se conocen un identificador, un nombre, apellido y la antigüedad en el cargo

En base a esto se pide:
1 - Generar el modelo de clases que soporte este dominio de problema con la
estructura basica de atributos y metodos

2 - Cargar las embarcaciones del archivo csv en un array de objetos del tipo Barco

3 - Asumiendo que el tiempo promedio de carga de una embarcacion son 15 hs,
cual seria el total de carga que recaudaria el puerto con todos los barcos
 amarrados (barcos cargados en el array)

4 - Informar todos los barcos, en un listado, cuyo capitan tiene mas de 18 años de experiencia.

5 - Determinar la carga promedio en toneladas de todos los barcos en posiciones pares de amarre.
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PuertoCarga {
    public static void main(String[] args){
        Puerto p = new Puerto();
        p.cargarBarcos("barcos.csv");
//        p.printBarcos();
//        String m = "messi,goles,lol";
//        System.out.println(Arrays.toString(m.split(",")));
        System.out.println("Carga promedio: " + p.cargaPromedio() + " Toneladas");
    }
}

class Capitan {
    private String nombre;
    private String apellido;
    public Capitan(String name1, String name2){
        this.apellido = name1;
        this.nombre = name2;
    }
    public String getNombre() {
        return this.nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
}
class Barco {

    private String matricula;
    private int nroMuelle;
    private int capCarga;
    private double costoAlquiler;
    private Capitan capitan;
    public Barco(String[] fields) {
        this.matricula = fields[4];
        this.nroMuelle = Integer.parseInt(fields[1]);
        this.capCarga = Integer.parseInt(fields[2]);
        this.costoAlquiler = Double.parseDouble(fields[3]);
        this.capitan = new Capitan(fields[5], fields[6]);
    }

    public String toString(){
        return "Mat: " + this.matricula + " | Muelle: " + this.nroMuelle
                + " | Carga: " + this.capCarga + " | Costo: $" + costoAlquiler +
                " | Capitan: " + this.capitan.getNombre() + this.capitan.getApellido();
    }

    public int getCapacidad(){
        return capCarga;
    }

}

class Puerto {
    public void cargarBarcos(String filename) {
        try {
            Scanner scanner = new Scanner(new File("barcos.csv"));
            String header = scanner.nextLine();
            String[] headerFields = header.split(",");

            while (scanner.hasNextLine()) {
//                System.out.println(scanner.nextLine());
                String[] fields = scanner.nextLine().split(",");
//                System.out.println(Arrays.toString(fields));
                barcos.add(new Barco(fields));
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private List<Barco> barcos = new ArrayList<Barco>();
    public void printBarcos(){
        for (Barco barco: barcos) {
            System.out.println(barco.toString());
        }
    }

    public double cargaPromedio(){
        double tot = 0.0;
        for (Barco barco: barcos
             ) {
            tot += (double) barco.getCapacidad();
        }
        return tot / barcos.size();
    }

}