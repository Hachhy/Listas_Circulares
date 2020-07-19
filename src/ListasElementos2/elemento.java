package ListasElementos2;

public class elemento {

    private int number;
    private elemento next;

    public elemento() {
        this.number = 0;
        this.next = null;
    }

    public elemento(int n, elemento next) {
        this.number = n;
        this.next = next;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int n) {
        this.number = n;
    }

    public elemento getNext() {
        return next;
    }

    public void setNext(elemento next) {
        this.next = next;
    }

}
