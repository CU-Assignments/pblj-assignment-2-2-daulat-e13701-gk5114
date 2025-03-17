import java.util.*;


class Card {
    private String symbol;
    private String value;

    public Card(String symbol, String value) {
        this.symbol = symbol;
        this.value = value;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value + " of " + symbol;
    }
}

// CardCollection class using Collection interface to store and retrieve cards
class CardCollection {
    private Collection<Card> cards;

    public CardCollection() {
        cards = new ArrayList<>(); // Using ArrayList as implementation
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> findCardsBySymbol(String symbol) {
        List<Card> matchingCards = new ArrayList<>();
        for (Card card : cards) {
            if (card.getSymbol().equalsIgnoreCase(symbol)) {
                matchingCards.add(card);
            }
        }
        return matchingCards;
    }
}

public class CardGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardCollection collection = new CardCollection();

        // Adding sample cards
        collection.addCard(new Card("Hearts", "Ace"));
        collection.addCard(new Card("Spades", "King"));
        collection.addCard(new Card("Diamonds", "Queen"));
        collection.addCard(new Card("Hearts", "10"));
        collection.addCard(new Card("Clubs", "Jack"));
        collection.addCard(new Card("Hearts", "7"));

        // User input to search for cards
        System.out.print("Enter the symbol to find all matching cards: ");
        String symbol = scanner.nextLine();

        List<Card> result = collection.findCardsBySymbol(symbol);
        if (result.isEmpty()) {
            System.out.println("No cards found with symbol: " + symbol);
        } else {
            System.out.println("Cards with symbol " + symbol + ": " + result);
        }
    }
}