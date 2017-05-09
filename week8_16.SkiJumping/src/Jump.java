
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class Jump {
    
    Jumper jumper;
    int jumpLength;
    int[] votes = new int[5];

    public Jump(Jumper jumper) {
        this.jumper = jumper;
        Random generator = new Random();
        
        this.jumpLength = generator.nextInt(60)+60;
        int i=0;
        for(i=0;i<5;i++){
            
            votes[i]=generator.nextInt(10)+10;
        }
        int[] temp = new int[5];
        for(i=0;i<5;i++){
            temp[i]=votes[i];
        }
        
        int tempPoints=jumper.getPoints();
       tempPoints += jumpLength;
       
       Arrays.sort(temp);
       for(i=1;i<4;i++){
           tempPoints+= temp[i];
       }
       jumper.setPoints(tempPoints);
       
    }
    @Override
    public String toString(){
        
        return "  "+jumper.getName()+"\n"+"    length:"+jumpLength+"\n    judge votes: ["
                +votes[0]+","+votes[1]+","+votes[2]+","+votes[3]+","+votes[4]+"]";
    }
    
    
   
    
}
