import java.util.ArrayList;

public class Members {
     String name;
     int dob;
     int maybeDeath;
     String spouse;
    ArrayList<Events> events = new ArrayList<>();

    /**
     *
     * @param name name of family member
     * @param dob year family member was born
     * @param date if dead,== a year; if not dead, ==0
     * @return returns a string
     */
    public String familyMembered(String name, int dob, int date) {
        System.out.println(this.name +" "+ this.dob + " "+ this.maybeDeath);

        this.name = name;
        this.dob = dob;
        this.maybeDeath = date;

        System.out.println(this.name +" "+ this.dob + " "+ this.maybeDeath);
        return this.name +" "+ this.dob + " "+ this.maybeDeath;
    }

    /**
     *
     * @param name new Person's name
     * @param dob year they were born
     * @param maybeDeath if dead,== a year; if not dead, == 0
     */
    Members(String name, int dob, int maybeDeath) {
        this.name = name;
        this.dob = dob;
        this.maybeDeath = maybeDeath;
        Events shitHappened = new Events(name, dob, "was born");
        events.add(shitHappened);
        spouse = "";

    }



}
