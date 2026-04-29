package entregas.elhadjiniang.reto003;

import java.util.Arrays;

public class QuickSort {

static int nivel=0;

public static void resetNivel(){
 nivel=0;
}

static String tabs(){
 return "  ".repeat(nivel);
}

public static String arrayToString(int[] a){
 return Arrays.toString(a);
}




public static void ordenar(
int[] array,
int izquierda,
int derecha
){

System.out.println(
 tabs()+
 "QuickSort("+
 izquierda+","+
 derecha+") "
 +arrayToString(array)
);

if(izquierda>=derecha){

System.out.println(
 tabs()+"Caso base"
);

return;
}

nivel++;
int indicePivote=
particionar(
array,
izquierda,
derecha
);

System.out.println(
 tabs()+
 "Pivote queda en "
 +indicePivote
);

ordenar(
array,
izquierda,
indicePivote-1
);

ordenar(
array,
indicePivote+1,
derecha
);

nivel--;

}


private static int particionar(
int[] array,
int izquierda,
int derecha
){

int pivote=
array[derecha];

System.out.println(
 tabs()+
 "Pivote="+pivote
);

int i=izquierda-1;

for(
int j=izquierda;
j<derecha;
j++
){

System.out.println(
 tabs()+
 "Comparar "
 +array[j]+
 " <= "+pivote+
 " ?"
);

if(array[j]<=pivote){

System.out.println(
 tabs()+"true"
);

i++;

System.out.println(
 tabs()+
 "Intercambio "
 +array[i]+
 " con "
 +array[j]
);

int temporal=array[i];
array[i]=array[j];
array[j]=temporal;

System.out.println(
 tabs()+
 "Array: "
 +arrayToString(array)
);

}
else{
System.out.println(
 tabs()+"false"
);
}
}

System.out.println(
 tabs()+
 "Intercambio final con pivote"
);

int temporal=array[i+1];
array[i+1]=array[derecha];
array[derecha]=temporal;

System.out.println(
 tabs()+
 "Array tras pivote: "
 +arrayToString(array)
);

return i+1;

}

}