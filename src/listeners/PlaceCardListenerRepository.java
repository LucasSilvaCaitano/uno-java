package listeners;

import cards.WildCard;
import enums.EnumColor;

import java.util.HashMap;
import java.util.Scanner;

public class PlaceCardListenerRepository {

    public static final HashMap<String, PlayListener> placeCardListenerHashMap = new HashMap();
    public static final Scanner in;

    static {
        in = new Scanner(System.in);
        placeCardListenerHashMap.put("+2", match-> {match.getNextPlayer().buyCards(
                match.getDeck(), 2);
            match.getNextPlayer().setBloqued(true);
        });
        placeCardListenerHashMap.put("Ø",
                match -> match.getCurrentPlayer().setBloqued(true));
        placeCardListenerHashMap.put("↕", match -> match.reverse());
        placeCardListenerHashMap.put("+4", match -> {
            match.getNextPlayer().buyCards(match.getDeck(), 4);
            match.getNextPlayer().setBloqued(true);
            System.out.println("Selecione uma cor:\nAmarelo, Azul, Vermelho, Verde");
            String cor = in.next();
            switch (cor){
                case "Amarelo":
                    ((WildCard) match.getLastCard()).setCor(EnumColor.YELLOW);
                    break;
                case "Azul":
                    ((WildCard) match.getLastCard()).setCor(EnumColor.BLUE);
                    break;
                case "Vermelho":
                    ((WildCard) match.getLastCard()).setCor(EnumColor.RED);
                    break;
                case "Verde":
                    ((WildCard) match.getLastCard()).setCor(EnumColor.GREEN);
                    break;
            }
        });
        placeCardListenerHashMap.put("any", match -> {
            System.out.println("Selecione uma cor:\nAmarelo, Azul, Vermelho, Verde");
            String cor = in.next();
            switch (cor){
                case "Amarelo":
                    ((WildCard) match.getLastCard()).setCor(EnumColor.YELLOW);
                    break;
                case "Azul":
                    ((WildCard) match.getLastCard()).setCor(EnumColor.BLUE);
                    break;
                case "Vermelho":
                    ((WildCard) match.getLastCard()).setCor(EnumColor.RED);
                    break;
                case "Verde":
                    ((WildCard) match.getLastCard()).setCor(EnumColor.GREEN);
                    break;
            }
        });

    }


}
