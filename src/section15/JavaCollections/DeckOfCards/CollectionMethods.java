package section15.JavaCollections.DeckOfCards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionMethods {
    
    public static void main(String[] args) {

        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck, "Standard Deck");

        Card[] aceOfHeartsDeck = new Card[13];
        Card aceOfHearts = Card.getFaceCard(Card.Suit.HEART, 'A');
        Arrays.fill(aceOfHeartsDeck, aceOfHearts);
        Card.printDeck(Arrays.asList(aceOfHeartsDeck), "Ace of Hearts Deck", 1);



        //  COLLECTION METHODS
        //  As a rule of thumb, you want to use the methods on the interfaces (List, Queue, etc) instead of on the Collections class!



        //  Collections.fill()
        //  This method works differently than Arrays.fill, as it only replaces existing elements;
        //  If a list is empty, no value will be replaced!
        List<Card> cards = new ArrayList<>(52);
        Collections.fill(cards, aceOfHearts);
        System.out.println(cards);                                  //  output: []                            
        System.out.println("cards.size() = " + cards.size());       //  output: cards.size() = 0



        //  Collections.nCopies()
        //  Returns a list of N copies of the provided object;
        List <Card> aceOfHeartsDeck2 = Collections.nCopies(13, aceOfHearts);
        Card.printDeck(aceOfHeartsDeck2, "Ace of Hearts Deck 2", 1);

        Card kingOfClubs = Card.getFaceCard(Card.Suit.CLUB, 'K');
        List <Card> kingOfClubsDeck = Collections.nCopies(13, kingOfClubs);
        Card.printDeck(kingOfClubsDeck, "King of Clubs Deck", 1);



        //  Collections.addAll()
        //  Adds elements to a Collection;
        //  Elements can be passed individually or as an array;
        Collections.addAll(cards, aceOfHeartsDeck);
        //  List.addAll() cannot receive arrays as argument!
        // cards.addAll(aceOfHearts);
        Card.printDeck(kingOfClubsDeck, "Card Collection Deck", 1);



        //  Collections.copy()
        //  Overwrites elements in a target List, with elements from another list;
        //  List becomes IMMUTABLE!
        //  Size of target list must be equal or greter to the list to be copied!
        //  Like Collections.fill(), an empty (target) list will result in an exception!
        Collections.copy(cards, kingOfClubsDeck);
        Collections.addAll(cards, aceOfHeartsDeck);
        Card.printDeck(cards, "Card Collection with Kings copied", 2);



        //  List.copyOf()
        //  Similar to Collections.copy(), but returns a new List instance that is mutable;
        cards = List.copyOf(kingOfClubsDeck);
        Card.printDeck(cards, "List Copy of Kings", 1);



        //  SORTING METHODS

        List<Card> newDeck = Card.getStandardDeck();
        Card.printDeck(newDeck, "Standard Deck");

        //  Collections.shuffle()
        //  Randomizes the order of elements in a List;
        Collections.shuffle(newDeck);
        Card.printDeck(newDeck, "Shufled Deck", 4);

        //  Collections.reverse()
        //  Reverses the order of a list;
        Collections.reverse(newDeck);
        Card.printDeck(newDeck, "Reversed Standard Deck of Cards");

        //  see Section14 for a refresher on Lambas and Method References;
        var sortingAlgorithm = Comparator.comparing(Card::rank).thenComparing(Card::suit);

        //  Collections.sort()
        //  Will sort a list with a given Comparator;
        Collections.sort(newDeck, sortingAlgorithm);
        Card.printDeck(newDeck, "Standard Deck sorted by rank, suit", 13);

        Collections.reverse(newDeck);
        Card.printDeck(newDeck, "Standard Deck reverse sorted by rank, suit", 13);

        //  List.subList()
        //  Extract a range of elements from a given list;
        List<Card> kings = new ArrayList<>(newDeck.subList(4, 8));
        Card.printDeck(kings, "Kings in Deck", 1);

        List<Card> tens = new ArrayList<>(newDeck.subList(16, 20));
        Card.printDeck(tens, "Tens in Deck", 1);

        //  Collections.indexOfSubList()
        //  returns the index of a sublist inside another list;
        //  returns -1 if not found;
        //  elements must be stored contiguously;
        int subListIndex = Collections.indexOfSubList(newDeck, tens);
        System.out.println("sublist index for tens = " + subListIndex);
        //  List.containsAll()
        //  has a similar purpose, but elements need not be stored contiguously
        System.out.println("Contains = " + newDeck.containsAll(tens));
        //  If you shufle the deck, Collections.indexOfSubList() will not find the sublist;
        //  But List.containsAll() will;
        Collections.shuffle(newDeck);
        int subListIndex2 = Collections.indexOfSubList(newDeck, tens);
        System.out.println("sublist index for tens = " + subListIndex2);
        System.out.println("Contains = " + newDeck.containsAll(tens));

        //  Collections.disjoint()
        //  returns true if two collections have no elements in common;
        boolean disjoint = Collections.disjoint(newDeck, tens);
        System.out.println("disjoint = " + disjoint);
        boolean disjoint2 = Collections.disjoint(kings, tens);
        System.out.println("disjoint = " + disjoint2);



        System.out.printf("%n%n%n");
        //  BINARY SEARCH, FREQUENCY, MIN, MAX, ROTATE



        //  Collections.binarySearch()
        //  Does what you think it does;
        //  You can pass a Comparable as key to be searched; or a Comparator instance instead;
        Card tenOfHearts = Card.getNumericCard(Card.Suit.HEART, 10);
        int foundIndex = Collections.binarySearch(newDeck, tenOfHearts, sortingAlgorithm);
        //  Binary Search limitations apply:
        //  List should be sorted;
        //  List should have no duplicates;
        //  Here we run binnary search on a unsorted list:    
        System.out.println("foundIndex = " + foundIndex);
        try {System.out.println(newDeck.get(foundIndex));} 
        catch (IndexOutOfBoundsException e) {System.out.println("Cannot reach index " + foundIndex);}
        //  Results are not consistent;
        //  Now we sort it and run it again:
        newDeck.sort(sortingAlgorithm);
        foundIndex = Collections.binarySearch(newDeck, tenOfHearts, sortingAlgorithm);
        System.out.println("foundIndex = " + foundIndex);
        try {System.out.println(newDeck.get(foundIndex));} 
        catch (IndexOutOfBoundsException e) {System.out.println("Cannot reach index " + foundIndex);}
        //  Key is found consistently;

        //  List.indexOf()
        //  this will find the key on a list regardless of order or duplicates, as long as it is there;
        //  it is however much more inefficient;
        System.out.println();
        Collections.shuffle(newDeck);
        System.out.println("foundIndex = " + newDeck.indexOf(tenOfHearts));

        //  Collections.replaceAll()
        //  Replaces all instances of an element for another element on a given list;
        newDeck.sort(sortingAlgorithm);
        Card tenOfClubs = Card.getNumericCard(Card.Suit.CLUB, 10);
        Collections.replaceAll(newDeck, tenOfClubs, tenOfHearts);
        Card.printDeck(newDeck.subList(32, 36), "Ten's Row", 1);
        Collections.replaceAll(newDeck, tenOfHearts, tenOfClubs);
        Card.printDeck(newDeck.subList(32, 36), "Ten's Row", 1);
        //  Returns a boolean as well;
        if (Collections.replaceAll(newDeck, tenOfClubs, tenOfHearts)) {
            System.out.println("Ten's of Clubs replaced with Ten's of Hearts");
        }

        //  Collections.frequency()
        //  returns an int with the number of instances of an element on a given list;
        //  usefull for finding duplicates;
        System.out.println("Ten of Clubs Cards = " + 
            Collections.frequency(newDeck, tenOfClubs)
        );
        System.out.println("Ten of Hearts Cards = " + 
            Collections.frequency(newDeck, tenOfHearts)
        );

        //  Collections.max()
        //  Collections.min()
        //  Find the maximum and minimum element on a given list;
        //  Works with both Comparable and Comparator;
        System.out.println("Best Card = " + Collections.max(newDeck, sortingAlgorithm));
        System.out.println("Worst Card = " + Collections.min(newDeck, sortingAlgorithm));
        
        //  Sorting newDeck again;
        var sortBySuit = Comparator.comparing(Card::suit).thenComparing(Card::rank);
        newDeck.sort(sortBySuit);
        Card.printDeck(newDeck, "Sorted by Suit, Rank");

        //  Collections.rotate()
        //  If n > 0:
        //  Moves n number of elements from the end to the start of the list;
        List<Card> copiedDeck = new ArrayList<>(newDeck.subList(0, 13));
        Collections.rotate(copiedDeck, 2);
        System.out.println("Unrotated: " + newDeck.subList(0, 13));
        System.out.println("Rotated " + 2 + ": " + copiedDeck);
        //  If n<0:
        //  Moves n number of elements from the start to the end of the list;
        copiedDeck = new ArrayList<>(newDeck.subList(0, 13));
        Collections.rotate(copiedDeck, -2);
        System.out.println("Unrotated: " + newDeck.subList(0, 13));
        System.out.println("Rotated " + -2 + ": " + copiedDeck);

        //  Collections.swap()
        //  Swaps elements at two given indexes, on a given list;
        copiedDeck = new ArrayList<>(newDeck.subList(0, 13));
        for(int i = 0; i < copiedDeck.size() / 2; i++) {
            Collections.swap(copiedDeck, i, copiedDeck.size() -1 -i);
        }
        System.out.println("Manual reverse with Collections.swap(): " + copiedDeck);

        //  Collections.reverse()
        //  reverses the order of the elements on a given list;
        copiedDeck = new ArrayList<>(newDeck.subList(0, 13));
        Collections.reverse(copiedDeck);
        System.out.println("Using Collections.reverse(): " + copiedDeck);

    }

}
