package section12.Challenges.IntegratingBoundedTypesAndComparators;

import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        
        QueryList<SubStudent> queryList = new QueryList<>();
        for (int i = 0; i < 25; i++) {
            queryList.add(new SubStudent());
        }

        System.out.println("Comparator.naturalOrder()");
        queryList.sort(Comparator.naturalOrder());
        printList(queryList);

        System.out.println("Students under 50% completion");
        var matches = queryList.getMatches("percentComplete", "50");
        printList(matches);

        //  check QueryList.java to find out why you can chain .getMatches()
        System.out.println("Students under 50% completion && Java Course");
        var matchesChain = queryList
                        .getMatches("percentComplete", "50")
                        .getMatches("course", "Java");
        printList(matchesChain);

        System.out.println("Students ordered by course completion");
        queryList.sort(new StudentComparator());
        printList(queryList);


    }

    public static void printList(List<?> students) {
        for (var student : students) {
            if (student instanceof Student s1) {
                System.out.println(s1);
            }
        }
        System.out.println();
    }

}


