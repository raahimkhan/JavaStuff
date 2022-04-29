public class Person
{
    private int age;
    private String name;

    public Person(final String name, final int age)
    {
        this.setName(name);
        this.setAge(age);
    }
    
    public int getAge() 
    {
        return this.age;
    }
    
    public String getName() 
    {
        return this.name;
    }
    
    public void setAge(final int age) 
    {
        this.age = age;
    }
    
    public void setName(final String name) 
    {
        this.name = name;
    }
}
