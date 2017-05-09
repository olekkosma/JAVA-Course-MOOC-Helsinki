
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import static jdk.nashorn.internal.objects.NativeArray.map;

/**
 *
 * @author Ukleja
 */
public class numbers {

    private Map<String, Set<String>> numbers;

    public numbers() {
        this.numbers = new HashMap<String, Set<String>>();
    }

    public void add(String person, String number) {

        if (!this.numbers.containsKey(person)) {

            this.numbers.put(person, new HashSet<String>());
        }

        this.numbers.get(person).add(number);

    }

    public Set<String> searchByPerson(String person) {

        Set<String> numberList = new HashSet<String>();
        if (this.numbers.containsKey(person)) {

            return this.numbers.get(person);
        }
        return null;

    }

    public String searchByNumber(String number) {

        String name = "";
        for (String setString : this.numbers.keySet()) {
            if (this.numbers.get(setString).contains(number)) {
                return name = setString;
            }

        }

        return null;
    }

    public void delete(String person) {

        if (this.numbers.containsKey(person)) {
            this.numbers.remove(person);
        }
    }

    public boolean searchByKeyWord(String keyword) {

        for (String setString : this.numbers.keySet()) {

            if (setString.contains(keyword)) {
                
                return true;
            }
        }

        return false;

    }
    
    public ArrayList searchbyKeywordToFindPerson(String keyword) {
        ArrayList foundedPerson = new ArrayList();
        
        for (String setString : this.numbers.keySet()) {

            if (this.numbers.get(setString).contains(keyword) || setString.contains(keyword)) {
                foundedPerson.add(setString);

            }
        }
        
            return foundedPerson;
        
    }
    public ArrayList sortNumbers(){
        Set<String> keys  = this.numbers.keySet();
        ArrayList list = new ArrayList(keys);
        Collections.sort(list);
        return list;
    }

}
