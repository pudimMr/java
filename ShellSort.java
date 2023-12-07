//BY André Gomes de Jesus Macêdo
//Matricula: 01621768
//GitHub: github.com/pudimMr
//Importando as bibliotecas que serão utilizadas
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class ShellSort {

    // Método de ordenação ShellSort para vetores
    public static void shellSort(int[] vetor) {
        int n = vetor.length; // Variável para obter o tamanho do vetor
        int intervalo = n / 2; // Variável que define o intervalo inicial

        while (intervalo > 0) { // Loop principal do ShellSort
            for (int i = intervalo; i < n; i++) {
                int temp = vetor[i];
                int j = i;

                // Loop para realizar a comparação e troca de elementos dentro do intervalo
                while (j >= intervalo && vetor[j - intervalo] > temp) {
                    vetor[j] = vetor[j - intervalo];
                    j -= intervalo;
                }

                vetor[j] = temp; // Insere o elemento na posição correta
            }

            intervalo /= 2; // Reduz o intervalo pela metade
        }
    }

    // Método de ordenação ShellSort para pilhas
    public static void shellSortPilha(Stack<Integer> stack) {
        int[] array = stack.stream().mapToInt(Integer::intValue).toArray(); // Converte a pilha para um array
        int n = array.length; // Obtém o tamanho do array
        int intervalo = n / 2; // Define o intervalo inicial

        while (intervalo > 0) { // Inicia o loop principal do ShellSort
            for (int i = intervalo; i < n; i++) {
                int temp = array[i];
                int j = i;

                // Loop para realizar a comparação e troca de elementos dentro do intervalo
                while (j >= intervalo && array[j - intervalo] > temp) {
                    array[j] = array[j - intervalo];
                    j -= intervalo;
                }

                array[j] = temp; // Insere o elemento na posição correta
            }

            intervalo /= 2; // Reduz o intervalo pela metade
        }

        stack.clear(); // Limpa a pilha original
        Arrays.stream(array).forEach(stack::push); // Reconstrói a pilha ordenada
    }

    // Método de ordenação ShellSort para listas encadeadas
    public static void shellSortLista(LinkedList<Integer> lista) {
        int n = lista.size(); // Obtém o tamanho da lista
        int intervalo = n / 2; // Define o intervalo inicial

        while (intervalo > 0) { // Inicia o loop principal do ShellSort
            for (int i = intervalo; i < n; i++) {
                int temp = lista.get(i);
                int j = i;

                // Loop para realizar a comparação e troca de elementos dentro do intervalo
                while (j >= intervalo && lista.get(j - intervalo) > temp) {
                    lista.set(j, lista.get(j - intervalo));
                    j -= intervalo;
                }

                lista.set(j, temp); // Insere o elemento na posição correta
            }

            intervalo /= 2; // Reduz o intervalo pela metade
        }
    }

    // Função para gerar vetores com números aleatórios já que precisaria usar mais de uma vez
    public static int[] Aleatorizar(int tamanho) {
        int[] vetor = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            vetor[i] = (int) (Math.random() * 100);
        }

        return vetor;
    }

    // Método principal
    public static void main(String[] args) {
        // Tamanhos dos vetores
        int n1 = 4;
        int n2 = 6;
        int n3 = 10;
        int n4 = 12;

        // Gera vetores aleatórios
        int[] vetor4 = Aleatorizar(n1);
        int[] vetor6 = Aleatorizar(n2);
        int[] vetor10 = Aleatorizar(n3);
        int[] vetor12 = Aleatorizar(n4);

        String spa = "========================================================"; // Apenas estética

        // Imprime os vetores originais e após a ordenação
        System.out.println("Vetor original (n=" + n1 + "): " + Arrays.toString(vetor4));
        shellSort(vetor4);
        System.out.println("Vetor ordenado (n=" + n1 + "): " + Arrays.toString(vetor4));
        System.out.println(spa);

        System.out.println("Vetor original (n=" + n2 + "): " + Arrays.toString(vetor6));
        shellSort(vetor6);
        System.out.println("Vetor ordenado (n=" + n2 + "): " + Arrays.toString(vetor6));
        System.out.println(spa);

        System.out.println("Vetor original (n=" + n3 + "): " + Arrays.toString(vetor10));
        shellSort(vetor10);
        System.out.println("Vetor ordenado (n=" + n3 + "): " + Arrays.toString(vetor10));
        System.out.println(spa);

        System.out.println("Vetor original (n=" + n4 + "): " + Arrays.toString(vetor12));
        shellSort(vetor12);
        System.out.println("Vetor ordenado (n=" + n4 + "): " + Arrays.toString(vetor12));
        System.out.println(spa);

        // Ordenação de pilha
        Stack<Integer> pilha = new Stack<>();   // Randomiza os numeros da pilha
        int tamanhoDaPilha = 12;

        for (int i = 0; i < tamanhoDaPilha; i++) {
            pilha.push((int) (Math.random() * 100));
        }
        // Imprime o antes e depois da ordenação
        System.out.println("Pilha original: " + pilha);
        shellSortPilha(pilha);
        System.out.println("Pilha ordenada: " + pilha);
        System.out.println(spa);

        // Ordenação de lista encadeada
        LinkedList<Integer> lista = new LinkedList<>(); // Randomiza os numeros da lista
        int tamanhoDaLista = 20;

        for (int i = 0; i < tamanhoDaLista; i++) {
            lista.add((int) (Math.random() * 100));
        }
        // Imprime o antes e depois da ordenação
        System.out.println("Lista original: " + lista);
        shellSortLista(lista);
        System.out.println("Lista ordenada: " + lista);
    }
}
//Observações: Não consegui fazer com que os numeros aleatórios repetidos que as vezes aprecem tanto no vetor quanto na pila e lista parassem
//tentei usar o mesmo método do jogo da senha mas dava um erro maluco, então deixei assim(não se mexe em time que tá ganhando)
//espero que considere