import java.util.Scanner; // Importando bibliotecas necessárias
import java.util.HashSet;

public class JogoDaSenha {
    private int quant; // Quantidade de números que vão ser advinhados
    private int[] lista; // Array para armazenar os Inputs do usuário
    private int[] aleatorio; // Array para armazenar os números aleatórios 
    private HashSet<Integer> Acertados; // Conjunto para acompanhar os números aleatórios que foram acertados
    private int Tentativas; // Contador de tentativas
    private int ContPesq; // Contador de comparações

    public JogoDaSenha() { // Construtor da classe
        this.quant = 5; // Definindo a quantidade de números a adivinhar (5)
        this.lista = new int[quant]; // Inicializando o array para números inseridos
        this.aleatorio = new int[30]; // Inicializando o array para números aleatórios
        this.Acertados = new HashSet<>(); // Inicializando o conjunto de números aleatórios acertados
        this.Tentativas = 1; // Inicializando o contador de tentativas
        this.ContPesq = 0; // Inicializando o contador de comparações
    }

    public void Random() { // Método para gerar os números aleatórios
        for (int i = 0; i < 30; i++) {
            int NumRd; // Variável que irá armazenar números aleatórios
            do {
                NumRd = (int) (Math.random() * 100) + 1; // Gera número aleatório de 1 a 100
            } while (Acertados.contains(NumRd)); // Verifica se o número gerado já foi acertado
            Acertados.add(NumRd); // Adiciona o número gerado ao conjunto de números aleatórios acertados
            aleatorio[i] = NumRd; // Armazena o número aleatório no array aleatorio
        }
    }

    public void FazerTentativa() { // Método para realizar tentativas
        Scanner fazTent = new Scanner(System.in);//criando um Scanner que vai ler o os inputs do usuario
        System.out.println("Joguinho de adivinhação");

        while (true) { // Loop do jogo
            System.out.println("Digite 5 números de 1 a 100:");
            int acertou = 0; // Contador de números acertados
            HashSet<Integer> advinhado = new HashSet<>(); // Conjunto para acompanhar os números adivinhados

            for (int i = 0; i < quant; i++) {//loop que armazena os inputs na lista
                lista[i] = fazTent.nextInt();

                if (Acertados.contains(lista[i]) && !advinhado.contains(lista[i])) {//verifica se o numero está correto e se já não foi usado
                    acertou++; // Incrementa o contador de números acertados
                    ContPesq++; // Incrementa o contador de comparações
                    advinhado.add(lista[i]); // Adiciona o número adivinhado ao conjunto
                }
            }

            if (acertou == quant) { // Se todos os números forem adivinhados
                System.out.println("Parabéns, você conseguiu adivinhar os 5 números");
                System.out.println("A senha era: " + getSenha()); // A senha será mostrada pelo do método getSenha

                while (true) { // Loop para verificar se o jogador deseja jogar novamente
                    System.out.println("Deseja jogar novamente? Digite 1 para sim e 2 para não");
                    int Resp = fazTent.nextInt();
                    if (Resp == 1) { //Caso o usuario opte por jogar novamente
                        Tentativas = 1; // Reinicia o contador de tentativas
                        Random(); // Gera uma nova senha aleatória
                        break;//encerra o loop da pergunta
                    } else if (Resp == 2) {// caso não queira mais jogar
                        System.out.println("Obrigado por jogar!");
                        fazTent.close();//fecha o scanner para não ler mais os inputs do usuário
                        return; // Encerra o jogo
                    } else {
                        System.out.println("Erro de sintaxe ou comando inexistente!! Digite apenas 1 para sim ou 2 para não");
                    }
                }
            } else if (acertou != 0 && acertou < quant) { // Se alguns números forem adivinhados
                System.out.println("Você acertou " + acertou + " números");
                System.out.println("Tentativa " + Tentativas);
                Tentativas++; // Incrementa o contador de tentativas
            } else { // Se nenhum número for adivinhado
                System.out.println("Você errou");
                Tentativas++; // Incrementa o contador de tentativas
                System.out.println("Tentativa " + Tentativas);
            }
        }
    }

    public void getContadorPesquisa() { // Método para exibir o número de comparações
        System.out.println("Número de comparações: " + ContPesq);
    }

    public String getSenha() { // Método para formatar a senha como uma string
        StringBuilder senha = new StringBuilder();
        for (int i = 0; i < aleatorio.length; i++) {
            senha.append(aleatorio[i]);//Adiciona o número aleatório atual na senha em formato string
            if (i < aleatorio.length - 1) {// Verifica se não é o último número na lista
                senha.append(" - "); // Adiciona um hífen entre os números exceto o último
            }
        }
        return senha.toString();//Retorna a senha em formato String
    }
}
