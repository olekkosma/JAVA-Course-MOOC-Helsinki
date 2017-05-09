
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ukleja
 */
public class address {

    private Map<String, String> addresses;

    public address() {
        this.addresses = new HashMap<String, String>();
    }

    public void add(String name, String streetCity) {
        this.addresses.put(name, streetCity);

    }

    public String searchByPerson(String person) {

        if (this.addresses.containsKey(person)) {

            return this.addresses.get(person);

        }
        return null;
    }

    public void delete(String person) {
        if (this.addresses.containsKey(person)) {
            this.addresses.remove(person);
        }
    }

    public address(Map<String, String> addresses) {
        this.addresses = addresses;
    }

    public boolean searchbyKeyword(String keyword) {

        for (String setString : this.addresses.keySet()) {

            if (this.addresses.get(setString).contains(keyword) || setString.contains(keyword)) {

                return true;
            }
        }
        return false;
    }

    public ArrayList<String> searchbyKeywordToFindPerson(String keyword) {
        
        ArrayList<String> foundedPerson = new ArrayList<String>();
        
        
        
        for (String setString : this.addresses.keySet()) {

            if (this.addresses.get(setString).contains(keyword) || setString.contains(keyword)) {
                foundedPerson.add(setString);

            }
        }
        
            return foundedPerson;
           
    }

    public ArrayList sortAdresses() {
        Set<String> keys = this.addresses.keySet();
        ArrayList list = new ArrayList(keys);
        Collections.sort(list);
        return list;
    }
}
