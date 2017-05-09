
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import javax.smartcardio.CommandAPDU;

public class Menu {

    Scanner reader = new Scanner(System.in);
    private String command = "";
    private numbers numbers = new numbers();
    private address adresses = new address();

    public void Menu() {
        System.out.println("phone search");
        System.out.println("available operations:");
        System.out.println(" 1 add a number");
        System.out.println(" 2 search for a number");
        System.out.println(" 3 search for a person by phone number");
        System.out.println(" 4 add an address");
        System.out.println(" 5 search for personal information");
        System.out.println(" 6 delete personal information");
        System.out.println(" 7 filtered listing");
        System.out.println(" x quit\n");

        while (true) {

            System.out.print("command: ");
            this.command = reader.nextLine();
            if (this.command.equals("1")) {
                System.out.print("whose number: ");
                String whose = reader.nextLine();
                System.out.print("number: ");
                String number = reader.nextLine();
                numbers.add(whose, number);
                System.out.println("");
            }

            if (this.command.equals("2")) {

                System.out.print("whose number: ");
                String whose = reader.nextLine();

                Set<String> searchedNumbersOfPerson = numbers.searchByPerson(whose);
                if (searchedNumbersOfPerson == null) {
                    System.out.println("  not found");
                } else {
                    for (String number : searchedNumbersOfPerson) {
                        System.out.println("  " + number);

                    }
                }

                System.out.println("");
            }
            if (this.command.equals("3")) {
                System.out.print("number: ");
                String number = reader.nextLine();

                String name = this.numbers.searchByNumber(number);
                if (name == null) {
                    System.out.println("  not found");
                } else {
                    System.out.println("  " + name);
                }
                System.out.println("");
            }
            if (this.command.equals("4")) {

                System.out.print("whose address: ");
                String whose = reader.nextLine();
                System.out.print("street: ");
                String street = reader.nextLine();
                System.out.print("city: ");
                String city = reader.nextLine();
                String cityStreet = street + " " + city;
                this.adresses.add(whose, cityStreet);
                System.out.println("");
            }
            if (this.command.equals("5")) {

                System.out.print("whose information: ");
                String whose = reader.nextLine();

                if (this.adresses.searchByPerson(whose) == null && this.numbers.searchByPerson(whose) == null) {
                    System.out.println("  not found");
                } else if (this.adresses.searchByPerson(whose) == null) {
                    System.out.println("  address unknown");
                    System.out.println("  phone numbers:");
                    Set<String> searchedNumbersOfPerson = numbers.searchByPerson(whose);
                    for (String number : searchedNumbersOfPerson) {
                        System.out.println("  " + number);

                    }
                } else if (this.numbers.searchByPerson(whose) == null) {
                    System.out.println("  address: " + this.adresses.searchByPerson(whose));
                    System.out.println("  phone number not found");

                } else {
                    System.out.println("  address: " + this.adresses.searchByPerson(whose));
                    System.out.println("  phone numbers:");
                    Set<String> searchedNumbersOfPerson = numbers.searchByPerson(whose);
                    for (String number : searchedNumbersOfPerson) {
                        System.out.println("  " + number);

                    }
                }

                System.out.println("");

            }

            if (this.command.equals(
                    "6")) {
                System.out.print("whose information: ");
                String whose = reader.nextLine();
                this.adresses.delete(whose);
                this.numbers.delete(whose);
                System.out.println("");
            }

            if (this.command.equals("7")) {
                System.out.print("keyword (if empty, all listed):");

                String whose2 = reader.nextLine();

                if (whose2.equals("")) {
                    ArrayList<String> sortedNamesAdresses = this.adresses.sortAdresses();
                    ArrayList<String> sortedNamesNumbers = this.numbers.sortNumbers();
                    for (String byAddress : sortedNamesAdresses) {
                        if (!sortedNamesNumbers.contains(byAddress)) {
                            sortedNamesNumbers.add(byAddress);
                        }
                    }

                    for (String whose : sortedNamesNumbers) {
                        System.out.println(" " + whose);
                        if (this.adresses.searchByPerson(whose) == null && this.numbers.searchByPerson(whose) == null) {
                            System.out.println("  not found");
                        } else if (this.adresses.searchByPerson(whose) == null) {
                            System.out.println("  address unknown");
                            System.out.println("  phone numbers:");
                            Set<String> searchedNumbersOfPerson = numbers.searchByPerson(whose);
                            for (String number : searchedNumbersOfPerson) {
                                System.out.println("  " + number);

                            }
                        } else if (this.numbers.searchByPerson(whose) == null) {
                            System.out.println("  address: " + this.adresses.searchByPerson(whose));
                            System.out.println("  phone number not found");

                        } else {
                            System.out.println("  address: " + this.adresses.searchByPerson(whose));
                            System.out.println("  phone numbers:");
                            Set<String> searchedNumbersOfPerson = numbers.searchByPerson(whose);
                            for (String number : searchedNumbersOfPerson) {
                                System.out.println("  " + number);

                            }
                        }

                    }

                } else {

                    ArrayList<String> sortedNamesAdresses= this.adresses.searchbyKeywordToFindPerson(whose2);
                    ArrayList<String> sortedNamesNumber= this.numbers.searchbyKeywordToFindPerson(whose2);
                         
                    arraysFusion fuzia = new arraysFusion();
                    sortedNamesAdresses = fuzia.fusion(sortedNamesNumber, sortedNamesAdresses);
                    
                    
                     
                    
                     Collections.sort(sortedNamesAdresses);
                   
                     if(sortedNamesAdresses.isEmpty()){
                         
                         System.out.println("keyword not found");
                     }
                     for (String whose : sortedNamesAdresses) {
                     System.out.println(" " + whose);
                     if (this.adresses.searchByPerson(whose) == null && this.numbers.searchByPerson(whose) == null) {
                     System.out.println("  not found");
                     } else if (this.adresses.searchByPerson(whose) == null) {
                     System.out.println("  address unknown");
                     System.out.println("  phone numbers:");
                     Set<String> searchedNumbersOfPerson = numbers.searchByPerson(whose);
                     for (String number : searchedNumbersOfPerson) {
                     System.out.println("  " + number);

                     }
                     } else if (this.numbers.searchByPerson(whose) == null) {
                     System.out.println("  address: " + this.adresses.searchByPerson(whose));
                     System.out.println("  phone number not found");

                     } else {
                     System.out.println("  address: " + this.adresses.searchByPerson(whose));
                     System.out.println("  phone numbers:");
                     Set<String> searchedNumbersOfPerson = numbers.searchByPerson(whose);
                     for (String number : searchedNumbersOfPerson) {
                     System.out.println("  " + number);

                     }
                            
                     }

                     }

                }

                System.out.println("");
            }

            if (this.command.equals(
                    "x")) {
                break;
            }
        }
    }
}
