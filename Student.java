import java.io.*;

public class Student extends Person implements SerializableEntity, Serializable {
    private double cgpa;

    public Student(String name, String rollNo, String department, double cgpa) {
        super(name, rollNo, department);  // Calling parent constructor
        this.cgpa = cgpa;
    }

    @Override
    public void displayInfo() {
        System.out.println("Name: " + name + ", Roll No: " + rollNo +
                           ", Dept: " + department + ", CGPA: " + cgpa);
    }

    @Override
    public void serializeToFile(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
        }
    }

    // Getter for cgpa
    public double getCgpa() {
        return cgpa;
    }
}
