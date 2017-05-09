
public class Jumper {
    
    private String name;
    private int points;

    public Jumper(String name) {
        this.name = name;
        this.points = 0;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return this.name + " ("+this.points+" points)";
    }
    
    public String printResults(){
        return this.name + " ("+this.points+" points)";
        
    }
    
    
    
     
}
