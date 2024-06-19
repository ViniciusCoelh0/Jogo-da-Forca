import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class JogoDaForca {
  public static void main(String[] args) {
    System.out.print("Digite a palavras secreta toda em minusculo: ");
    Scanner scanner = new Scanner(System.in);

    String palavraSecreta = scanner.nextLine(); // Palavra secreta
    Set<Character> letrasAdivinhadas = new HashSet<>();
    int tentativasRestantes = 6;
    boolean jogoTerminado = false;

    while (!jogoTerminado) {
      // Exibir palavra com as letras adivinhadas até o momento
      exibirPalavra(palavraSecreta, letrasAdivinhadas);

      // Pedir ao jogador para adivinhar a próxima letra
      System.out.println("Digite uma letra: ");
      char letra = scanner.next().charAt(0);

      // Verificar se a letra já foi adivinhada
      if (letrasAdivinhadas.contains(letra)) {
        System.out.println(letra + " já foi adivinhada. Tente outra letra.");
        continue;
      }

      // Adicionar a letra às letras adivinhadas
      letrasAdivinhadas.add(letra);

      if (!palavraSecreta.contains(String.valueOf(letra))) {
        tentativasRestantes--;
        System.out.println("Letra incorreta! Tentativas restantes: " + tentativasRestantes);
      }

      // Verificar se o jogador ganhou ou perdeu
      if (todasLetrasAdivinhadas(palavraSecreta, letrasAdivinhadas)) {
        System.out.println("Parabéns! Você acertou a palavra: " + palavraSecreta);
        jogoTerminado = true;
      } else if (tentativasRestantes == 0) {
        System.out.println("Você errou a palavra. A palavra era: " + palavraSecreta);
        jogoTerminado = true;
      }
    }

    scanner.close();
  }

  // Método para exibir a palavra com as letras adivinhadas até o momento
  public static void exibirPalavra(String palavra, Set<Character> letrasAdivinhadas) {
    for (char letra : palavra.toCharArray()) {
      if (letrasAdivinhadas.contains(letra)) {
        System.out.print(letra + " ");
      } else {
        System.out.print("_ ");
      }
    }
    System.out.println(); // Adicionar nova linha após exibir a palavra
  }

  // Método para verificar se todas as letras foram adivinhadas
  public static boolean todasLetrasAdivinhadas(String palavra, Set<Character> letrasAdivinhadas) {
    for (char letra : palavra.toCharArray()) {
      if (!letrasAdivinhadas.contains(letra)) {
        return false;
      }
    }
    return true;
  }
}
