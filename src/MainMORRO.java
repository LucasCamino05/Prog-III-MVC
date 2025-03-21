package org.example;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MainMORRO {

    private static final List<Integer> numeros = List.of(8, 3, 5, 1, 9, 6, 12, 3, 7, 4, 2, 10, 15, 20);
    private static final List<String> nombres = List.of("Juan", "Ana", "Pedro", "Carla", "Miguel");
    private static final List<String> palabras = List.of("Java", "Stream", "Lambda", "Funcional", "API");

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            Menu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea
            switch (opcion) {
                case 1 -> System.out.println(filtrarNumerosPares());
                case 2 -> System.out.println(transformarNombresAMayusculas());
                case 3 -> System.out.println(ordenarListaNumeros());
                case 4 -> System.out.println(contarMayoresQue(7)) ;
                case 5 -> System.out.println(obtenerPrimeros5Elementos());
                case 6 -> System.out.println(convertirPalabrasALongitud());
                case 7 -> System.out.println(concatenarNombres());
                case 8 -> System.out.println(eliminarDuplicados());
                case 9 -> System.out.println(obtenerTop3Numeros());
                case 10 -> System.out.println(agruparPalabrasPorLongitud());
                case 11 -> System.out.println(productoDeNumeros());
                case 12 -> System.out.println(nombreMasLargo());
                case 13 -> System.out.println(listaEnterosComoString());
                case 14 -> agruparParesEImpares();
                case 15 -> System.out.println(sumaDeCuadradosImpares());
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida, intente de nuevo.");
            }
        } while (opcion != 0);
        scanner.close();
    }

    public static List<Integer> filtrarNumerosPares(){
        List<Integer> pares = numeros.stream()
                .filter(i -> i%2==0)
                .toList();
        return pares;
    }

    public static List<String> transformarNombresAMayusculas(){
        List<String>mayusculas = nombres.stream()
                .map(String::toUpperCase)
                .toList();
        return mayusculas;
    }

    public static List<Integer> ordenarListaNumeros(){
        List<Integer>ordnum = numeros.stream()
                .sorted()
                .toList();

        return ordnum;
    }

    public static Long contarMayoresQue(int num){
        Long mayor = numeros.stream()
                .filter(i -> i>num)
                .count();
        return mayor;
    }

    public static List<Integer> obtenerPrimeros5Elementos(){
        List<Integer>primeros=numeros.stream()
                .limit(5)
                .toList();
        return primeros;
    }

    public static List <Integer> convertirPalabrasALongitud(){
        List<Integer>longitudes=palabras.stream()
                .map(String::length)
                .toList();
        return longitudes;
    }

    public static String concatenarNombres(){
        String concatenado=nombres.stream()
                .reduce(String::concat)
                .toString();
        return concatenado;
    }
    public static List<Integer> eliminarDuplicados(){
        List<Integer> nodup=numeros.stream()
                .distinct()
                .toList();
        return nodup;
    }
    public static List<Integer> obtenerTop3Numeros(){
        List<Integer> obttres=numeros
                .reversed().stream()
                .limit(3)
                .sorted()
                .toList();
        return obttres;
    }

    public static Map<Integer,List<String>> agruparPalabrasPorLongitud(){
        Map<Integer,List<String>> agrupados=palabras.stream()
                .collect(Collectors.groupingBy(String::length));
        return agrupados;
    }

    public static Integer productoDeNumeros(){
        Integer producto=numeros.stream()
                .reduce(1,(inic,num)->inic*num);
        return producto;
    }

    public static String nombreMasLargo(){
        String nombreLargo=nombres.stream()
                .reduce((str1, str2) -> str1.length() > str2.length() ? str1 : str2)
                //signo de pregunta si se cumple entra o no
                .orElse("");
        return nombreLargo;
    }

    public static String listaEnterosComoString(){
        String transformados=numeros.stream()
                .map(String::valueOf)
                .collect(Collectors.joining("-"))
                .toString();
        return transformados;
    }
    public static void agruparParesEImpares(){
        Map<Boolean,List <Integer>> partisionados=numeros.stream()
                .collect(Collectors.partitioningBy(num -> num%2==0));
        System.out.println("Impares:" + partisionados.get(false));
        System.out.println("Pares:" + partisionados.get(true));
    }

    public static Integer sumaDeCuadradosImpares(){
        Integer sumatoria=numeros.stream()
                .filter(i -> i%2!=0)
                .map(num->num*num)
                .reduce(0,(inic,num)->inic+num);
        return sumatoria;
    }
    public static void Menu(){
        // Menú de opciones
        System.out.println("\n===== MENÚ DE EJERCICIOS STREAMS Y LAMBDAS =====");
        System.out.println("1. Filtrar números pares");
        System.out.println("2. Transformar una lista de nombres a mayúsculas");
        System.out.println("3. Ordenar una lista de números");
        System.out.println("4. Contar elementos mayores a un valor dado");
        System.out.println("5. Obtener los primeros 5 elementos de una lista");
        System.out.println("6. Convertir una lista de palabras en su longitud");
        System.out.println("7. Concatenar nombres con una separación");
        System.out.println("8. Eliminar duplicados de una lista");
        System.out.println("9. Obtener los 3 números más grandes de una lista");
        System.out.println("10. Agrupar palabras por su longitud");
        System.out.println("11. Encontrar el producto de todos los números de una lista");
        System.out.println("12. Obtener el nombre más largo de una lista");
        System.out.println("13. Convertir una lista de enteros en una cadena separada por guiones");
        System.out.println("14. Agrupar una lista de números en pares e impares");
        System.out.println("15. Obtener la suma de los cuadrados de los números impares");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }
}