
public class Main {



    public static void main (String[] args) {
        FamilyTree tree = new FamilyTree();

        tree.addPerson("Morrison Days", 1944, 1996);
        tree.addPerson("George Kitts Jr.", 1990, 0);
        tree.addPerson("Leonard Kitts", 1964, 0);
        tree.addPerson("George Kitts", 1966, 0);
        tree.addPerson("Helena Days", 1948, 0);
        tree.addPerson("Clifford Sings", 1944, 0);
        tree.addPerson("May Sings", 1967, 0);
        tree.addPerson("Kayla Sings", 1979, 0);
        tree.addPerson("Misty Sings",2003, 0);
        tree.addPerson("Maude Days", 1950, 0);
        tree.addPerson("Fawn Jones", 1977, 0);
        tree.addPerson("Darius Jones",1949, 0);
        tree.addPerson("Jichael Willis", 1967, 0);
        tree.addPerson("Tiffany Willis",2003, 0);
        tree.addPerson("Fonte Jones",1980, 0);
        tree.addPerson("Michaela Brown",1977, 0);
        tree.addPerson("Michelle Jones",2000, 0);

        tree.addEvent("George Kitts", 1988, "Hiked Mt. Everest");
        tree.addEvent("May Sings",1995 ,"Performed at the Grammy’s, won an award for best album, and became an EGOT");
        tree.addEvent("May Sings", 1987,"Won her first Tony Award for her role in Fences");
        tree.addEvent("Leonard Kitts", 1989,"Sold his first home as a new real estate agent");
        tree.addEvent("Tiffany Willis", 2019,"Accidentally started a pandemic");
        tree.addEvent("Tiffany Willis", 2020,"Developed the first vaccine for the COVID-19 virus");
        tree.addEvent("Clifford Sings", 1959,"Wrote his first song");
        tree.addEvent("Clifford Sings", 1980,"Produced a song for Michael Jackson and won his fifth Grammy");
        tree.addEvent("Fawn Jones", 1993,"Met Mother Theresa");
        tree.addEvent("Maude Days", 2003,"Became the coolest grandmother on Earth");
        tree.addEvent("Michaela Brown", 2005,"Won the Nobel Prize in Chemistry");

        int count = 0;

        for (Members familyMember : tree.familyMembers) {
            mergeSort eventsList = new mergeSort(familyMember.events);
            eventsList.sortGivenArray();
            count++;

        }

        AdjMatrix graph = new AdjMatrix(count);
        int array[] = new int[2];
        array = tree.addRelationship("Morrison Days", "George Kitts", "parent");
        if (array != null)
            graph.addEdge(array[0], array[1]);
        array = tree.addRelationship("Morrison Days", "Leonard Kitts", "parent");
        if (array != null)
            graph.addEdge(array[0], array[1]);
        array = tree.addRelationship("George Kitts", "George Kitts Jr.", "parent");
        if (array != null)
            graph.addEdge(array[0], array[1]);
        array = tree.addRelationship("Helena Days", "Clifford Sings", "married");
        if (array != null)
            graph.addEdge(array[0], array[1]);
        array = tree.addRelationship("Helena Days", "May Sings", "parent");
        if (array != null)
            graph.addEdge(array[0], array[1]);
        array = tree.addRelationship("Helena Days", "Kayla Sings", "parent");
        if (array != null)
            graph.addEdge(array[0], array[1]);
        array = tree.addRelationship("Kayla Sings", "Misty Sings", "parent");
        if (array != null)
            graph.addEdge(array[0], array[1]);
        array = tree.addRelationship("Maude Days", "Darius Jones", "married");
        if (array != null)
            graph.addEdge(array[0], array[1]);
        array = tree.addRelationship("Maude Days", "Fawn Jones", "parent");
        if (array != null)
            graph.addEdge(array[0], array[1]);
        array = tree.addRelationship("Maude Days", "Fonte Jones", "parent");
        if (array != null)
            graph.addEdge(array[0], array[1]);
        array = tree.addRelationship("Fawn Jones", "Jichael Willis", "married");
        if (array != null)
            graph.addEdge(array[0], array[1]);
        array = tree.addRelationship("Fawn Jones", "Tiffany Willis", "parent");
        if (array != null)
            graph.addEdge(array[0], array[1]);
        array = tree.addRelationship("Fonte Jones", "Michaela Brown", "married");
        if (array != null)
            graph.addEdge(array[0], array[1]);
        array = tree.addRelationship("Fonte Jones", "Michelle Jones", "parent");
        if (array != null)
            graph.addEdge(array[0], array[1]);

        tree.printFamTree(graph, count);
    }
}
