package Logica;

/**
 *
 * @author Juan David
 */
public class Nodo {

    private int procesos;
    private String nombre;
    private Nodo Siguiente;
    private Nodo Anterior;

    public Nodo(int procesos, String nombre) {
        this.procesos = procesos;
        this.nombre = nombre;
        this.Siguiente = new Nodo();
    }

    public Nodo() {
    }

    public Nodo getAnterior() {
        return Anterior;
    }

    public void setAnterior(Nodo Anterior) {
        this.Anterior = Anterior;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getProcesos() {
        return procesos;
    }

    public void setProcesos(int procesos) {
        this.procesos = procesos;
    }

    public Nodo getSiguiente() {
        return Siguiente;
    }

    public void setSiguiente(Nodo Siguiente) {
        this.Siguiente = Siguiente;
    }

    @Override
    public String toString() {
        return "Nodo{Nombre= " + nombre + ", procesos= " + procesos + ", NodoSig= " + Siguiente.getNombre() + '}';
    }
}
