package Logica;

import java.util.ArrayList;

/**
 *
 * @author Juan David
 */
public class Lista {

    Nodo cajero, ultimo;
    Nodo aux;

    public Lista() {
        cajero = new Nodo(0, "Cajero");
        ultimo = new Nodo();
        cajero.setSiguiente(cajero);
        aux = cajero.getSiguiente();
    }

    public void añadir(Nodo n) {
//        if (n != null) {
            if (cajero.getSiguiente() == cajero) {
                cajero.setSiguiente(n);
                cajero.setAnterior(n);
                n.setAnterior(cajero);
                n.setSiguiente(cajero);

                ultimo = n;
            } else {
                //Lista doblemente enlazada
                cajero.setAnterior(n);
                ultimo.setSiguiente(n);
                n.setAnterior(ultimo);
                n.setSiguiente(cajero);
                ultimo = n;
            }
//        }
    }

    public void atender() {

        do {
            if (aux.getProcesos() > 3) {
                if (aux == ultimo) {
                    int proceso = aux.getProcesos();
                    aux.setProcesos(proceso - 3);
                    atender();
                } else {
                    int proceso = aux.getProcesos();
                    aux.setProcesos(proceso - 3);
                    //Eiminar de la cola
                    aux.getAnterior().setSiguiente(aux.getSiguiente());
                    aux.getSiguiente().setAnterior(aux.getAnterior());
                    //Poner al final
                    aux.setSiguiente(cajero);
                    aux.setAnterior(ultimo);
                    ultimo.setSiguiente(aux);
                    cajero.setAnterior(aux);
                    ultimo = aux;
                }
                if (aux.getProcesos() <= 3) {
                        aux.setProcesos(0);
                    }
            }

            aux = aux.getSiguiente();
        } while (aux != cajero);
    }

    public ArrayList<Nodo> imprimir() {
        ArrayList arr = new ArrayList();
        Nodo aux = new Nodo();
        aux = cajero;

        do {
            arr.add(aux);
            aux = aux.getSiguiente();
        } while (aux != cajero);

        return arr;
    }
}
