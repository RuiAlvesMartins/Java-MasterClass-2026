package section12.GenericsAdvanced;

import java.util.ArrayList;
import java.util.List;

//  Specifying MULTIPLE UPPER BOUNDS
//  Type Parameters can have multiple upper bounds;
//  By extending/implementing multiple classes/interfaces;
//  NOTE: although you use the keyword EXTENDS for both classes and interfaces;
//  You can only extend ONE class!
//  (and it must be the FIRST type listed!)
//  You may extend multiple interfaces;
public class QueryList<T extends Student & QueryItem> {

    private List<T> items;

    public QueryList(List<T> items) {
        this.items = items;
    }

    public List<T> getMatches(String field, String value) {
        List<T> matches = new ArrayList<>();
        for (var item : items) {
            if (item.matchFieldValue(field, value)) {
                //  match found!
                matches.add(item);
            }
        }
        return matches;
    }

    //  TYPE PARAMETERS in STATIC GENERIC METHODS
    //  Class TYPE PARAMETER can NOT be used in a STATIC Method! 
    //  (because they need an instance to perform type erasure);
    //  But Type Parameter may be used in a Static Method that is also GENERIC!
    //  In this case, the method type parameter T is completely different from the class type parameter, which is also T;
    //  However, you must specify an UPPER BOUND!
    public static <T extends QueryItem> List<T> getMatches(List<T> items, String field, String value) {
        List<T> matches = new ArrayList<>();
        for (var item : items) {
            if (item.matchFieldValue(field, value)) {
                //  match found!
                matches.add(item);
            }
        }
        return matches;
    }

}
