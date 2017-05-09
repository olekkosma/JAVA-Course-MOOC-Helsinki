
import java.util.Comparator;


public class SortAgaintsPoints implements Comparator<Jumper>{
    
    @Override
    public int compare(Jumper jumper1, Jumper jumper2){
        
        if(jumper1.getPoints()>jumper2.getPoints()){
            return 1;
        }else{
            return -1;
        }
    }
    
}
