package ListasElementos2;

import java.util.Random;

public class listaCircular {

    private elemento first, last;
    private int size;
    final Random random = new Random();

    public listaCircular() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public int randomNumber() {
        int number = (int) random.nextInt(91) + 10;
        return number;
    }

    public void addNumber() {
        elemento newElement = new elemento();
        newElement.setNumber(randomNumber());
        if (isEmpty()) {
            first = newElement;
            last = newElement;
            last.setNext(first);
        } else {
            newElement.setNext(first);
            first = newElement;
            last.setNext(first);
        }
        System.out.println("Numero insertado");
        size++;
    }

    public void showList() {
        if (!isEmpty()) {
            elemento aux = first;
            System.out.println("");
            do {
                System.out.print("[" + aux.getNumber() + "]__");
                aux = aux.getNext();
            } while (aux != first);
            System.out.println("");
        } else {
            System.out.println("La lista esta vacia");
        }
    }

    public void removexFirst() {
        if (!isEmpty()) {
            int number = first.getNumber();
            if (first == last) {
                first = null;
            } else {
                elemento aux = first;
                first = aux.getNext();
                last.setNext(first);
            }
            size--;
            System.out.println("Eliminado: " + number);
            showList();
        } else {
            System.out.println("La lista esta vacia");
        }
    }

    public void removexLast() {
        if (!isEmpty()) {
            int number = last.getNumber();
            if (first == last) {
                first = null;
            } else {
                elemento aux = first;
                elemento temp = aux;
                while (aux != last) {
                    temp = aux;
                    aux = aux.getNext();
                }
                last = temp;
                last.setNext(first);
            }
            size--;
            System.out.println("Eliminado: " + number);
            showList();
        } else {
            System.out.println("La lista esta vacia");
        }
    }

    public void removexPlace(int place) {
        if (!isEmpty()) {
            elemento aux = first;
            elemento temp = aux;
            if (place == 1) {
                removexFirst();
            }
            if (place == size) {
                removexLast();
            } else {
                for (int i = 0; i < size && i < place - 1; i++) {
                    temp = aux;
                    aux = aux.getNext();
                }
                temp.setNext(aux.getNext());
            }
            size--;
            System.out.println("Eliminado: " + aux.getNumber());
            showList();
        } else {
            System.out.println("La lista esta vacia");
        }
    }

    public void search(int s) {
        if (!isEmpty()) {
            elemento aux = first;
            do {
                if (s == aux.getNumber()) {
                    System.out.println("Dato encontrado: " + s);
                    break;
                } else {
                    aux = aux.getNext();
                }
                if (aux == first) {
                    System.out.println("Dato no encontrado");
                }
            } while (aux != first);
            showList();
        } else {
            System.out.println("La lista esta vacia");
        }

    }

    public void sortNumber(boolean verify) {
        if (!isEmpty()) {
            for (int i = 0; i < size; i++) {
                elemento aux = first;
                elemento aux2 = aux.getNext();
                int temp;
                do {
                    if (aux.getNumber() > aux2.getNumber() && verify == true) {
                        temp = aux.getNumber();
                        aux.setNumber(aux2.getNumber());
                        aux2.setNumber(temp);
                    }
                    if (aux.getNumber() < aux2.getNumber() && verify == false) {
                        temp = aux.getNumber();
                        aux.setNumber(aux2.getNumber());
                        aux2.setNumber(temp);
                    }
                    aux = aux2;
                    aux2 = aux2.getNext();
                } while (aux != last);
            }
            showList();
        } else {
            System.out.println("La lista esta vacia");
        }
    }

    public void editNumber(int e, int ne) {
        if (!isEmpty()) {
            elemento aux = first;
            do {
                if (aux.getNumber() == e) {
                    aux.setNumber(ne);
                    break;
                }
                aux = aux.getNext();
                if (aux == first) {
                    System.out.println("Dato no encontrado");
                }

            } while (aux != first);
            showList();
        } else {
            System.out.println("La lista esta vacia");
        }
    }

    public void majorxLast() {
        if (!isEmpty()) {
            elemento aux = first;
            elemento temp = aux;
            int major = 0;
            do {
                if (aux.getNumber() > major) {
                    temp = aux;
                    major = aux.getNumber();
                }
                aux = aux.getNext();
            } while (aux != first);
            System.out.println("Número mayor: " + temp.getNumber() + "\nUltimo número: " + last.getNumber());
            temp.setNumber(last.getNumber());
            last.setNumber(major);
            showList();
        } else {
            System.out.println("Lla lista esta vacia");
        }
    }

    public void minorxFirst() {
        if (!isEmpty()) {
            elemento aux = first;
            elemento temp = aux;
            int minor = aux.getNumber();
            do {
                if (aux.getNumber() < minor) {
                    temp = aux;
                    minor = aux.getNumber();
                }
                aux = aux.getNext();
            } while (aux != first);
            System.out.println("Número menor: " + temp.getNumber() + "\nPrimer número: " + first.getNumber());
            temp.setNumber(first.getNumber());
            first.setNumber(minor);
            showList();
        } else {
            System.out.println("La lista esta vacia");
        }
    }

    public void evenxOdd() {
        if (!isEmpty()) {
            elemento aux = first;
            elemento temp1 = aux, temp2 = aux;
            int even = 0, odd = 0;
            boolean evenVerify = true, oddVerify = true;

            do {
                if (aux.getNumber() % 2 == 0 && evenVerify == true) {
                    temp1 = aux;
                    even = aux.getNumber();
                    evenVerify = false;
                } else if (aux.getNumber() % 2 != 0 && oddVerify == true) {
                    temp2 = aux;
                    odd = aux.getNumber();
                    oddVerify = false;
                }
                aux = aux.getNext();
            } while (aux != first);
            System.out.println("Primer par: " + even + "\nPrimer impar: " + odd);
            temp1.setNumber(odd);
            temp2.setNumber(even);
            showList();
        } else {
            System.out.println("La lista esta vacia");
        }

    }

    public boolean isEmpty() {
        return first == null;
    }

}
