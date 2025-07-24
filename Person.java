public abstract class Person {
    protected String name;
    protected String rollNo;
    protected String department;

    public Person(String name, String rollNo, String department) {
        this.name = name;
        this.rollNo = rollNo;
        this.department = department;
    }

    public abstract void displayInfo();
}
