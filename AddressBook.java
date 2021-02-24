
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;
import java.util.logging.Logger;

public class AddressBook {

    private TreeMap<String, ContactDetails> addressBookRegistry;

    private static Logger logger;

    public AddressBook() {
        addressBookRegistry = new TreeMap<>(); //diamant notasjon
    }

    public static void main(String[] args) {

        AddressBook addressBook = new AddressBook();

        logger = Logger.getLogger(AddressBook.class.toString());

        try {
            logger.info("Creating contacts for Pippi");
            logger.warning("Setting negative value to age");
            ContactDetails contactDetails1 = new ContactDetails("Pippi",
                    "12345678", "Stockholm", 21);
            System.out.println("Name: " + contactDetails1.getName() + "\n"
                    + "Phone: " + contactDetails1.getPhoneNumber() + "\n"
                    + "Address: " + contactDetails1.getAddress() + "\n"
                    + "Age: " + contactDetails1.getAge());

            ContactDetails contactDetails2 = new ContactDetails("Håkon",
                    "94859658", "Gjøvik", 20);
            System.out.println("Name: " + contactDetails2.getName() + "\n"
                    + "Phone: " + contactDetails2.getPhoneNumber() + "\n"
                    + "Address: " + contactDetails2.getAddress() + "\n"
                    + "Age: " + contactDetails2.getAge());

            ContactDetails contactDetails3 = new ContactDetails("Vegard",
                    "67584065", "Gjøvik", 22);
            System.out.println("Name: " + contactDetails3.getName() + "\n"
                    + "Phone: " + contactDetails3.getPhoneNumber() + "\n"
                    + "Address: " + contactDetails3.getAddress() + "\n"
                    + "Age: " + contactDetails3.getAge());

            addressBook.addressBookRegistry.put(contactDetails1.getPhoneNumber(), contactDetails1);
            addressBook.addressBookRegistry.put(contactDetails2.getPhoneNumber(), contactDetails2);
            addressBook.addressBookRegistry.put(contactDetails3.getPhoneNumber(), contactDetails3);

            System.out.println(addressBook.addressBookRegistry.toString());

            addressBook.writetoFile();

        }catch(IllegalArgumentException | NullPointerException e){
            System.out.println("One of the arguments was not right.");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            System.err.println("Illegal argument provided");
        }catch(Exception e){
            System.out.println("System was not happy.");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            System.out.println("Ta kontakt med admin.");
        }finally{
            //close connection to database.
        }

    }

    public void writetoFile() throws IOException {
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter("SavedContactDetails.txt");
            // write to file
            for(ContactDetails contactDetails:addressBookRegistry.values()) {
                fileWriter.write(contactDetails.getName() +", "
                        + contactDetails.getPhoneNumber() +", "
                         + contactDetails.getAddress() + "\n");
            }
        }
        finally {
            fileWriter.close();
        }

    }

}
