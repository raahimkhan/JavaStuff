import java.util.ArrayList;
import java.util.List;

public class PersonTest {
    public static void main(final String[] args) 
    {
        final Person personA = new Person("Gary", 16);
        final Person studentA = new Person("Debbie", 24);
        
        final List<String> names = new ArrayList<>();
        names.add(personA.getName());
        names.add(studentA.getName());   
        
        System.out.println("After adding two names:");
        for (final String name : names) {
            System.out.println(name);
        }
        
        names.remove("Gary");
        
        System.out.println("After removing one name:");
        for (final String name : names) {
            System.out.println(name);
        }
        
        // Modified code starts from here
        
        // Removing Debbie also and will add all person's names again in order inside the names list
        names.remove("Debbie");
        
        // new list to add ages of all the people
        final List<Integer> ages = new ArrayList<>();
        
        // Adding in 5 more people with names and ages as mentioned in pdf document
        final Person personB = new Person("Sven", 12);
        final Person studentB = new Person("Siobhan", 28);
        final Person personC = new Person("Jerry", 29);
        final Person studentC = new Person("Isla", 19);
        final Person personD = new Person("Roe", 82);
        
        // adding all person's names to names list
        names.add(personA.getName());
        names.add(studentA.getName());
        names.add(personB.getName());
        names.add(studentB.getName());
        names.add(personC.getName());
        names.add(studentC.getName());
        names.add(personD.getName());
        
        // adding all person's ages to ages list
        ages.add(personA.getAge());
        ages.add(studentA.getAge());
        ages.add(personB.getAge());
        ages.add(studentB.getAge());
        ages.add(personC.getAge());
        ages.add(studentC.getAge());
        ages.add(personD.getAge());
        
        // loop which prints out all of the names of all the people.
        System.out.println("Names of all the people after modifying:");
        for (final String name : names) {
            System.out.println(name);
        }
        
        // loop which prints out all of the ages of all the people.
        System.out.println("Ages of all the people after modifying:");
        for (final Integer age : ages) {
            System.out.println(age);
        }
        
        // new Person list
        final List<Person> persons = new ArrayList<>();
        
        // Adding all Person to persons list
        persons.add(personA);
        persons.add(studentA);
        persons.add(personB);
        persons.add(studentB);
        persons.add(personC);
        persons.add(studentC);
        persons.add(personD);
        
        // loop to print the persons list
        int counter = 1;
        System.out.println("---------------------Student Record------------------------");
        for (final Person p : persons) {
            System.out.println("Person " + Integer.toString(counter) + ": " + p.getName() + ", " +  Integer.toString(p.getAge()) + ".");
            counter = counter + 1;
        }
        System.out.println("------------------Record finished-------------------------");
    }
}