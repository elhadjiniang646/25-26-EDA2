package entregas.elhadjiniang.reto003;

import java.util.Arrays;

public class InsertionSort {

    private static int nivel=0;

    private static String tabs(){
        return "  ".repeat(nivel);
    }

    private static String arr(int[] a){
        return Arrays.toString(a);
    }



    public static void ordenar(int[] array) {

        System.out.println("Array inicial: " + arr(array));

        for (int i=1;i<array.length;i++) {

            int actual=array[i];
            int j=i-1;

            System.out.println();
            System.out.println("Iteracion i="+i+" actual="+actual);

            while (j>=0 && array[j]>actual) {

                System.out.println(
                    "Comparando "
                    +array[j]+" > "+actual+
                    " -> true"
                );

                System.out.println(
                   "Desplazar "+array[j]+
                   " de indice "+j+
                   " a "+(j+1)
                );

                array[j+1]=array[j];

                System.out.println(
                    "Array tras desplazamiento: "
                    +arr(array)
                );

                j--;
            }

            if(j>=0){
                System.out.println(
                    "Comparando "
                    +array[j]+" > "+actual+
                    " -> false"
                );
            }

            array[j+1]=actual;

            System.out.println(
                "Insertar "
                +actual+
                " en posicion " +(j+1)
            );

            System.out.println(
                "Array actual: "+arr(array)
            );
        }

        System.out.println("Array final: " + arr(array));
    }



    public static void ordenar(int[] array,int n){

        if(n==array.length){
            System.out.println("Array inicial: "+arr(array));
        }

        System.out.println(
            tabs()+"Llamada ordenar(n="+n+")"
        );

        if(n<=1){
            System.out.println(
               tabs()+"Caso base alcanzado n<=1"
            );
            return;
        }

        nivel++;
        ordenar(array,n-1);
        nivel--;

        int ultimo=array[n-1];
        int j=n-2;

        System.out.println(
          tabs()+"Insertando ultimo="+ultimo
        );

        while(j>=0 && array[j]>ultimo){

            System.out.println(
             tabs()+"Comparo "
             +array[j]+" > "+ultimo+
             " -> true"
            );

            array[j+1]=array[j];

            System.out.println(
               tabs()+"Desplazamiento: "+arr(array)
            );

            j--;
        }

        if(j>=0){
            System.out.println(
              tabs()+"Comparo "
              +array[j]+" > "+ultimo+
              " -> false"
            );
        }

        array[j+1]=ultimo;

        System.out.println(
          tabs()+"Insertado: "+arr(array)
        );

        if(n==array.length){
            System.out.println("Array final: "+arr(array));
        }
    }
}