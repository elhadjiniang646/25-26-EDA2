package entregas.elhadjiniang.reto003;

public class Main {

    public static void main(String[] args) {

        int[] original = {5,2,8,1,9,3};

        System.out.println("\n===============================");
        System.out.println("INSERTION SORT ITERATIVO");
        System.out.println("===============================");
        InsertionSort.ordenar(original.clone());


        System.out.println("\n===============================");
        System.out.println("INSERTION SORT RECURSIVO");
        System.out.println("===============================");
        InsertionSort.ordenar(original.clone(), original.length);


        System.out.println("\n===============================");
        System.out.println("MERGE SORT RECURSIVO");
        System.out.println("===============================");
        MergeSort.resetNivel();
        int[] a3 = original.clone();
        MergeSort.ordenar(a3,0,a3.length-1);
        System.out.println("Array final: " + MergeSort.arrayToString(a3));


        System.out.println("\n===============================");
        System.out.println("MERGE SORT ITERATIVO");
        System.out.println("===============================");
        int[] a4 = original.clone();
        MergeSort.ordenarIterativo(a4);
        System.out.println("Array final: " + MergeSort.arrayToString(a4));


        System.out.println("\n===============================");
        System.out.println("QUICK SORT");
        System.out.println("===============================");
        QuickSort.resetNivel();
        int[] a5 = original.clone();
        QuickSort.ordenar(a5,0,a5.length-1);
        System.out.println("Array final: " + QuickSort.arrayToString(a5));

    }
}



