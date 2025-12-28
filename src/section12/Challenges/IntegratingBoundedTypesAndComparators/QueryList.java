package section12.Challenges.IntegratingBoundedTypesAndComparators;

import java.util.ArrayList;
import java.util.List;

public class QueryList<T extends Student & QueryItem> extends ArrayList<T> {

    public QueryList(List<T> items) {
        //  call to ArrayList constructor
        super(items);
    }

    public QueryList() {
        
    }

    //  Why return QueryList? Instead of List or ArrayList?
    //  Because it allowes you to chain this method
    public QueryList<T> getMatches(String field, String value) {
        QueryList<T> matches = new QueryList<>();
        //  for item : THIS (instance of QueryList)
        for (var item : this) {
            if (item.matchFieldValue(field, value)) {
                //  match found!
                matches.add(item);
            }
        }
        return matches;
    }

}
