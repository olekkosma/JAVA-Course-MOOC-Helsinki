
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ukleja
 */
public class arraysFusion {

    public ArrayList<String> fusion(ArrayList<String> first, ArrayList<String> second) {

        if (!first.isEmpty()) {
            for (String person : first) {
                if(!second.contains(person)){
                    second.add(person);
                }
            }
        }

        
        return second;

    }

}
