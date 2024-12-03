package adventOfCode1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner tomaDatos = new Scanner(System.in);
        String ubicacionEntrada;

        // Preguntamos al usuario por la ubicación del input
        //Ask the user for the file location
        System.out.println("Saludos usuario, para continuar, por favor localice el fichero del input (ubicacion+input.txt): ");
        ubicacionEntrada = tomaDatos.nextLine();

        if (ubicacionEntrada.endsWith(".txt")) {
            try {
                FileReader fr = new FileReader(ubicacionEntrada);
                BufferedReader bf = new BufferedReader(fr);
                List<String[]> filas = new ArrayList<>();
                String sCadena;

                // Lo dividivimos aquí y le quitamos los espacios
                //lets divide it here and remove spaces
                while ((sCadena = bf.readLine()) != null) {
                    
                    String[] columnas = sCadena.trim().split("\\s+");
                    filas.add(columnas); 
                }

                bf.close();

                ArrayList<String> colIzq = new ArrayList<String>();
                ArrayList<String> colDcha = new ArrayList<String>();
                for (int i = 0; i < filas.size(); i++) {
                    String[] columnas = filas.get(i);
                    System.out.println("Línea " + (i + 1) + ":");
                    int contadorCol=0;
                    for (int j = 0; j < columnas.length; j++) {
                    	
                    	//guardamos cada cosa en colIzq y colDcha si el contador está a cero o no 
                    	//store everything in colIzq(left column) and colDcha(right column)if the counter is at zero or not
                    	if(contadorCol==0) {
                    		colIzq.add(columnas[j]);
                    	}else {
                    		colDcha.add(columnas[j]);
                    	}
                        System.out.println("  Columna " + (j + 1) + ": " + columnas[j]);
                        contadorCol++;
                    }
                }
                
              
                //ahora ya tengo las dos columnas separadas, toca ordenarlas
                //now we have two separated columns, we have to sort it
                Collections.sort(colIzq);
                Collections.sort(colDcha);
                //una vez ordenadas, se hace la comparación y se hace la resta, cuyo resultado se almacenará en listaRes
                //once they are sorted, we compare it and rest it, the solution of it will be stored in listaRes
                int[] listaRes= new int[colDcha.size()];
                int distanciaFinal=0;
                for(int i =0; i< colDcha.size();i++) {
                	System.out.print(colIzq.get(i)+" - "+colDcha.get(i)+" = ");
                	listaRes[i]=Integer.valueOf(colIzq.get(i)) - Integer.valueOf(colDcha.get(i));
                	if(listaRes[i]<0) {
                		listaRes[i]=listaRes[i]*(-1);
                	}
                	System.out.print(listaRes[i]+"\n");
                	distanciaFinal+=listaRes[i];
                }
               System.out.println("La distancia es: "+distanciaFinal);
            } catch (IOException ioe) {
                System.err.println("Error al leer el archivo. Verifica la ubicación.");
                ioe.printStackTrace();
            }
        } else {
            System.out.println("Ubicación o tipo de archivo no válido");
        }

        tomaDatos.close(); 
    }
}
