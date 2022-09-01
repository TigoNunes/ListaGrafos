public class Vertice {
    private int n;
    private Vertice suc = null;
    private Vertice ant = null;

    // Construtor
    public Vertice(int n) {
        this.n = n;
    }

    
    public void inserirSucessor(int n) {
        Vertice v = this;
        while (v.suc != null) {
            v = v.suc;
        }
        v.suc = new Vertice(n);
    }

    
    public void inserirAntecessor(int n) {
        Vertice v = this;
        while (v.ant != null) {
            v = v.ant;
        }
        v.ant = new Vertice(n);
    }

    
    public int getN() {
        return this.n;
    }

    
    public void makeListaSuc() {
        System.out.print("Lista de Sucessores do vértice " + this.n + ": [");
        Vertice v = this.suc;
        if (v == null)
            System.out.print("nenhum vértice sucessor");
        while (v != null) {
            System.out.print(v.getN());
            v = v.suc;
            if (v != null) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

  
    public void makeListaAnt() {
        System.out.print("Lista de Antecessores do vértice " + this.n + ": [");
        Vertice v = this.ant;
        if (v == null)
            System.out.print("nenhum vértice antecessor");
        while (v != null) {
            System.out.print(v.getN());
            v = v.ant;
            if (v != null) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public int getGrauSaida() {
        int counter = 0;
        Vertice v = this;

        while ((v = v.suc) != null)
            counter++;

        return counter;
    }

    public int getGrauEntrada() {
        int counter = 0;
        Vertice v = this;

        while ((v = v.ant) != null)
            counter++;

        return counter;
    }
}
