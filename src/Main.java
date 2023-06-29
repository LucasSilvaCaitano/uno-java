import match.Match;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Match match = new Match(2);
        
        while (true){
            System.out.printf("Mãos do jogador atual:\n%s.\n", match.getCurrentPlayer().getHand());
            System.out.printf("Última carta na pilha: %s\n", match.getLastCard());

            System.out.println("Digite a sua ação");
            System.out.println("1 - jogar carta");
            System.out.println("2 - comprar carta");

            int opcao = in.nextInt();

            switch (opcao){
                case 1:
                    System.out.println("Digite o indice da carta");
                    int cardIndex = in.nextInt();
                    match.addCard(cardIndex);
                    break;
                case 2:
                    match.buyCard();
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }

    }
}