/**
 * Pseudo-code:
 * 1) for each frosh, put it's class combo into a hash-map
 * 2) for each subsequent frosh, compare all five courses at a time
 *    a) if no difference, popularity++ (store popularity)
 *    b) if find any difference, break and move on to next frosh
 * 3) have a tracker to track highest popularity, output
 */
 

public class Conformity {
    Kattio io = new Kattio(System.in, System.out);
    int numOfFrosh = io.getInt();
    
    for(int i = 0; i < numOfFrosh; i++) {
        String courses = io.getLine();
        // split the input of courses
        addCourse(0, /* course 1 */);
        addCourse(1, /* course 2 */);
    }
    
    for(int i = 0; i < numOfFrosh; i++) {
        for(int j = 0; j < numOfFrosh - 1; j++) {
            if(i != j) {
                /* compare all the courses */ 
            }
        }
    }
    
}

class Frosh {
    private HashMap<Integer, Integer> courses;
    private int popularity;
    
    public Frosh() {
        this.courses = new HashMap<Integer, Integer>();
        this.popularity = popularity;
    }
    
    public int getPopularity() {
        return this.popularity;
    }
    
    public void addCourse(int i, int course) {
        courses.put(i, course);
    }
    
    public int getCourse(int i) {
        courses.get(i);
    }
    
    /* make the frosh a comparable */
    public boolean compareTo
}
