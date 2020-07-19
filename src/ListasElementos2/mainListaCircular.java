package ListasElementos2;

import java.util.Scanner;

public class mainListaCircular {

    static Scanner sc = new Scanner(System.in);
    static boolean strongLine;
    static listaCircular list = new listaCircular();

    public static void main(String[] args) {
        onDisplay();
    }

    static void onDisplay() {
        int option = -1;

        while (option != 0) {
            strongLine = true;
            System.out.print("\n" + line() + "\n\tLista Circular de Elementos      |\n"
                    + line() + "\n"
                    + "1)> Insertar elemento aleatorio          |\n"
                    + "2)> Mostrar elementos                    |\n"
                    + "3)> Eliminar elemento                    |\n"
                    + "4)> Buscar un elemento                   |\n"
                    + "5)> Ordenar la lista                     |\n"
                    + "6)> Intercambiar elementos               |\n"
                    + "7)> Modificar un elemento                |\n"
                    + "0)> Salir                                |\n" + line());

            System.out.print("\nIngrese una opcion: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    list.addNumber();
                    break;
                case 2:
                    list.showList();
                    break;
                case 3:
                    remove();
                    break;
                case 4:
                    System.out.print("Buscar elemento: ");
                    int s = sc.nextInt();
                    list.search(s);
                    break;
                case 5:
                    sortOption();
                    break;
                case 6:
                    exchange();
                    break;
                case 7:
                    System.out.print("Elemento a modificar: ");
                    int e = sc.nextInt();
                    System.out.print("Nuevo elemento:");
                    int ne = sc.nextInt();
                    list.editNumber(e, ne);
                    break;
                case 0:
                    System.out.println("Saliendo del sistema");
                    break;
                default:
                    System.out.println("No es una opcion");
                    break;

            }
        }

    }

    static void sortOption() {
        strongLine = false;
        System.out.print("\n" + line()
                + "\n\t Ordenar          |\n" + line()
                + "\n 1)> Ascendente           |"
                + "\n 2)> Descendente          |"
                + "\n 0)> Menu                 |\n" + line() + "\n");
        System.out.print("Opcion: ");
        int option = sc.nextInt();

        if (option == 1) {
            list.sortNumber(true);
        }
        if (option == 2) {
            list.sortNumber(false);
        }

    }

    static void remove() {
        strongLine = false;
        System.out.print("\n" + line()
                + "\n\t Eliminar         |\n" + line()
                + "\n1)> Al inicio             |"
                + "\n2)> Al final              |"
                + "\n3)> Por posición          |"
                + "\n0)> Menu                  |\n" + line() + "\n");
        System.out.print("Opcion: ");
        int option = sc.nextInt();

        if (option == 1) {
            list.removexFirst();
        }
        if (option == 2) {
            list.removexLast();
        }
        if (option == 3) {
            System.out.print("Ingrese posicion: ");
            int place = sc.nextInt();
            list.removexPlace(place);
        }

    }

    static void exchange() {
        strongLine = false;
        System.out.print("\n" + line() + "---------------"
                + "\n\t\tIntercambio              |\n" + line() + "---------------"
                + "\n 1)> Elemento mayor con ultimo elemento  |"
                + "\n 2)> Elemento menor con primer elemento  |"
                + "\n 3)> Primer par con el primer impar      |"
                + "\n 0)> menu                                |\n" + line()
                + "---------------\n");
        System.out.print("Opcion: ");
        int option = sc.nextInt();
        if (option == 1) {
            list.majorxLast();
        }
        if (option == 2) {
            list.minorxFirst();
        }
        if (option == 3) {
            list.evenxOdd();
        }

    }

    static String line() {
        String l1 = "▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀";
        String l2 = "---------------------------";
        if (strongLine) {
            return l1;
        } else {
            return l2;
        }

    }

}
