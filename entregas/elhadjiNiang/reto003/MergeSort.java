package entregas.elhadjiniang.reto003;

import java.util.Arrays;

public class MergeSort {

    static int nivel = 0;

    public static void resetNivel() {
        nivel = 0;
    }

    static String tabs() {
        return "  ".repeat(nivel);
    }

    public static String arrayToString(int[] a) {
        return Arrays.toString(a);
    }

    public static void ordenar(
            int[] array,
            int izquierda,
            int derecha
    ) {

        System.out.println(
                tabs()
                + "ordenar(" + izquierda + "," + derecha + ") "
                + subarray(array, izquierda, derecha)
        );

        if (izquierda >= derecha) {

            System.out.println(
                    tabs()
                    + "Caso base: un elemento"
            );

            return;
        }

        int medio
                = izquierda + (derecha - izquierda) / 2;

        System.out.println(
                tabs()
                + "Dividir en ["
                + izquierda + "," + medio + "] y ["
                + (medio + 1) + "," + derecha + "]"
        );

        nivel++;
        ordenar(array, izquierda, medio);
        ordenar(array, medio + 1, derecha);
        nivel--;

        fusionar(
                array,
                izquierda,
                medio,
                derecha
        );

        System.out.println(
                tabs()
                + "Tras fusion: "
                + arrayToString(array)
        );

    }

    public static void ordenarIterativo(
            int[] array
    ) {

        System.out.println(
                "Array inicial: " + arrayToString(array)
        );

        int n = array.length;

        for (int tamano = 1; tamano < n; tamano *= 2) {

            System.out.println();
            System.out.println(
                    "Tamano bloques=" + tamano
            );

            for (int izquierda = 0;
                    izquierda < n - tamano;
                    izquierda += 2 * tamano) {

                int medio  = izquierda + tamano - 1;

                int derecha = Math.min(
                        izquierda + 2 * tamano - 1,  n - 1
                );

                System.out.println(
                        "Fusionando bloques "   + subarray(   array, izquierda,  medio )
                        + " y " + subarray( array,  medio + 1, derecha )
                );

                fusionar(
                        array,
                        izquierda,
                        medio,
                        derecha
                );

                System.out.println(
                        "Array: "
                        + arrayToString(array)
                );

            }
        }
    }

    private static void fusionar(
            int[] array,
            int izquierda,
            int medio,
            int derecha
    ) {

        System.out.println(
                tabs()
                + "Fusionar "
                + subarray(array,
                        izquierda,
                        medio)
                + " con "
                + subarray(array,
                        medio + 1,
                        derecha)
        );

        int tamanoIzquierda
                = medio - izquierda + 1;

        int tamanoDerecha
                = derecha - medio;

        int[] mitadIzquierda
                = new int[tamanoIzquierda];

        int[] mitadDerecha
                = new int[tamanoDerecha];

        for (int i = 0;
                i < tamanoIzquierda; i++) {
            mitadIzquierda[i]
                    = array[izquierda + i];
        }

        for (int i = 0;
                i < tamanoDerecha; i++) {
            mitadDerecha[i]
                    = array[medio + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = izquierda;

        while (i < tamanoIzquierda
                && j < tamanoDerecha) {

            System.out.println(
                    tabs()
                    + "Comparo "
                    + mitadIzquierda[i]
                    + " y "
                    + mitadDerecha[j]
            );

            if (mitadIzquierda[i]
                    <= mitadDerecha[j]) {

                System.out.println(
                        tabs()
                        + "Tomo "
                        + mitadIzquierda[i]
                );

                array[k] = mitadIzquierda[i];
                i++;
            } else {

                System.out.println(
                        tabs()
                        + "Tomo "
                        + mitadDerecha[j]
                );

                array[k] = mitadDerecha[j];
                j++;
            }

            k++;
        }

        while (i < tamanoIzquierda) {

            System.out.println(
                    tabs()
                    + "Copiar restante "
                    + mitadIzquierda[i]
            );

            array[k] = mitadIzquierda[i];
            i++;
            k++;
        }

        while (j < tamanoDerecha) {

            System.out.println(
                    tabs()
                    + "Copiar restante "
                    + mitadDerecha[j]
            );

            array[k] = mitadDerecha[j];
            j++;
            k++;
        }

    }

    private static String subarray(
            int[] a,
            int ini,
            int fin
    ) {

        int[] b
                = Arrays.copyOfRange(
                        a,
                        ini,
                        fin + 1
                );

        return Arrays.toString(b);

    }

}
