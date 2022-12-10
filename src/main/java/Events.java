public class Events {
    String name;
    int date;
    String whatHappened;

    /**
     * constructor for Events class
     * @param name name of person
     * @param date date the person performed task
     * @param whatHappened task they performed
     */
    Events(String name, int date, String whatHappened) {
        this.name = name;
        this.date = date;
        this.whatHappened = whatHappened;
    }

    /**
     *
     * @return date the person did event
     */
    public int getDate() {
        return date;
    }

    /**
     *
     * @return string with the year the person performed a task and the corresponding task
     */
    @Override
    public String toString() {
        return date + ": " + whatHappened + '\'' ;
    }
}
