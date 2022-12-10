import java.util.*;

public class FamilyTree {

    ArrayList<Members> familyMembers = new ArrayList<>();

    /**
     * adds event to Member object's arrayList of events
     * @param name name of person who attended event
     * @param year the year the event occurred
     * @param whatHappened what happened at the event
     */
    public void addEvent(String name, int year, String whatHappened) {
        Events newEvent = new Events(name, year, whatHappened);
        for (Members familyMember : familyMembers) {
            if (familyMember.name.equals(name)) {
                familyMember.events.add(newEvent);
            }
        }

    }

    /**
     * adds a person to the family
     * @param name name of the person
     * @param dob year the person was born
     * @param maybeAlive 0 if they are still alive; a year if they're deceased
     */
    public void addPerson(String name, int dob, int maybeAlive) {
        Members familyMember = new Members(name, dob, maybeAlive);
        familyMembers.add(familyMember);
    }

    /**
     *
     * @param array does Depth First Search and prints the family members from adjacent matrix
     * @param i index to search
     * @param visited array with T/F if we have visited the index in adjacent matrix
     * @param count length of adjacent matrix
     * @param indent the amount of tabs needed for printing; needed to indicate generations
     */
    public void searchMe(int array[][], int i, boolean visited[], int count, int indent) {
        int j;
        int temp = indent;
        while(temp != 0) {
            System.out.print("\t");
            temp--;
        }
        System.out.print(familyMembers.get(i).name +" (" +familyMembers.get(i).dob+ "-");

        if(familyMembers.get(i).maybeDeath != 0) {
            System.out.print(familyMembers.get(i).maybeDeath);
        }
        System.out.print(")");

        int len = familyMembers.get(i).events.size();
        int ct = 1;
        if (len > 1){
            while (len != 1) {
                System.out.print("; "+familyMembers.get(i).events.get(ct).date+": "+familyMembers.get(i).events.get(ct).whatHappened);
                ct++;
                len--;
            }
        }

        if (familyMembers.get(i).spouse.length() > 0) {
            System.out.print(" m. "+ (getMember(familyMembers.get(i).spouse).name) +" (" +(getMember(familyMembers.get(i).spouse).dob)+ "-");
            if((getMember(familyMembers.get(i).spouse).maybeDeath) != 0)
                System.out.print((getMember(familyMembers.get(i).spouse).maybeDeath));
            System.out.print(")");
            len = getMember(familyMembers.get(i).spouse).events.size();
            ct = 1;
            while (len != 1) {
                System.out.print("; "+getMember(familyMembers.get(i).spouse).events.get(ct).date+": "+getMember(familyMembers.get(i).spouse).events.get(ct).whatHappened);
                ct++;
                len--;
            }
            int spousenum = getNumber(familyMembers.get(i).spouse);
            visited[spousenum] = true;
        }


            System.out.println();
        visited[i] = true;
        for(j = 0; j < count; j++) {
            if(!visited[j] && array[i][j] == 1) {
                searchMe(array, j, visited, count, indent + 1);
            }
        }
    }

    /**
     *
     * @param name Name of Person's parent/spouse
     * @param personRelated name of Person
     * @param howRelated whether a name is a parent or married to personRelated
     * @return returns 2D array with name's index in arrayList as array[0] and
     *          personRelated's index in arrayList
     */
    public int[] addRelationship(String name, String personRelated, String howRelated) {
        int array[] = new int [2];
        array[0] = 99;
        array[1] = 99;
        int count = 0;
        int from = 0;
        int to = 0;
            if (Objects.equals(howRelated, "parent")) {
                for (Members familyMember : familyMembers) {

                    if (Objects.equals(familyMember.name, name)) {
                        from = count;
                    }
                    else if (Objects.equals(familyMember.name, personRelated)) {
                        to = count;
                    }

                    count++;
                }
            }

            else if(Objects.equals(howRelated, "married")) {
                for (Members familyMember : familyMembers) {

                    if (Objects.equals(familyMember.name, name)) {
                        familyMember.spouse = personRelated;
                    }

                }
            }

            if (to != 0 && array[1] != 0) {
                array[0] = from;
                array[1] = to;
                return array;
            }

        return null;
    }

    /**
     *
     * @param name name of member we want to find
     * @return returns the member we want with the matching name
     */
    public Members getMember(String name) {
        for (Members familyMember : familyMembers) {
            if (Objects.equals(name, familyMember.name)) {
                return familyMember;
            }

        }
        return null;

    }

    /**
     *
     * @param name the name of the person whose index we want to find
     * @return index of member with matching name
     */
    public int getNumber(String name) {
        int count = 0;
        for (Members familyMember : familyMembers) {
            if (Objects.equals(name, familyMember.name)) {
              return count;
            }
            count++;
        }
        return -1;
    }

    /**
     *
     * @param family the adjacency matrix
     * @param count length of adjacency matrix
     */
    public void printFamTree(AdjMatrix family, int count) {
        int cd = 0;
        boolean [] visited = new boolean[count];
        for (int i = 0; i < count; i++) {
            if (!visited[i])
                searchMe (family.adjMatrix, i, visited, count, cd);
        }

    }
}
