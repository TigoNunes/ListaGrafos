import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner leitaozinho = new Scanner(System.in);
        System.out.print("Insira o numero do vertice: ");
        String numero = leitaozinho.nextLine();
        try {
            File arquivo = new File("graph-test-100.txt");
        BufferedReader br = new BufferedReader(new FileReader(arquivo));

        String linha = br.readLine().trim().replaceAll(" +", " ");
        String[] temp = linha.split(" ");

        int pesquisa = Integer.parseInt(numero);
        int n = Integer.parseInt(temp[0]); 
        int m = Integer.parseInt(temp[1]); 

        if (pesquisa > n || pesquisa < 1) {
            System.out.println("Erro: vértice inválido. Escolha um valor de 1 a " + n);

            br.close();
            return;
        }

        // Vetor com os vértices:
        Vertice[] grafo = new Vertice[n];
        int cont = 0;

        while ((linha = br.readLine()) != null && cont++ < m) {
            // Formatando string
            linha = linha.trim().replaceAll(" +", " ");
            temp = linha.split(" ");

            int v = Integer.parseInt(temp[0]);
            int adj = Integer.parseInt(temp[1]);

            // Adicionando vértices às listas de adjacência
            if (grafo[v - 1] == null)
                grafo[v - 1] = new Vertice(v);
            if (grafo[adj - 1] == null)
                grafo[adj - 1] = new Vertice(adj);

            grafo[v - 1].inserirSucessor(adj);
            grafo[adj - 1].inserirAntecessor(v);
        }
        
        System.out.println("VÉRTICE " + pesquisa + "\n");
        System.out.println("Grau de saída: " + grafo[pesquisa - 1].getGrauSaida());
        System.out.println("Grau de entrada: " + grafo[pesquisa - 1].getGrauEntrada());
        if (grafo[pesquisa - 1] != null) {
            grafo[pesquisa - 1].makeListaSuc();
            grafo[pesquisa - 1].makeListaAnt();
        }
        ;
        br.close();       
      
        } catch (Exception e) {}
        
    }
}

