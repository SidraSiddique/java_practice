import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server started. Waiting for client...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String choice;
            do {
                out.println(getMenu());
                choice = in.readLine();

                switch (choice) {
                    case "1":
                        out.println("Enter name:");
                        String name = in.readLine();
                        out.println("Enter roll number:");
                        String rollNo = in.readLine();
                        out.println("Enter department:");
                        String department = in.readLine();
                        out.println("Enter CGPA:");
                        double cgpa = Double.parseDouble(in.readLine());
                        students.add(new Student(name, rollNo, department, cgpa));
                        out.println("Student added successfully.\n");
                        break;
                    case "2":
                        if (students.isEmpty()) {
                            out.println("No students found.\n");
                        } else {
                            StringBuilder sb = new StringBuilder();
                            for (Student s : students) {
                                sb.append("Name: ").append(s.name)
                                  .append(", Roll No: ").append(s.rollNo)
                                  .append(", Dept: ").append(s.department)
                                  .append(", CGPA: ").append(s.getCgpa())
                                  .append("\n");
                            }
                            out.println(sb.toString());
                        }
                        break;
                    case "3":
                        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.ser"))) {
                            oos.writeObject(students);
                            out.println("Students saved to file.\n");
                        } catch (IOException e) {
                            out.println("Error saving to file: " + e.getMessage());
                        }
                        break;
                    case "4":
                        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.ser"))) {
                            @SuppressWarnings("unchecked")
                            List<Student> loadedStudents = (List<Student>) ois.readObject();
                            students = loadedStudents;
                            out.println("Students loaded from file.\n");
                        } catch (IOException | ClassNotFoundException e) {
                            out.println("Error loading from file: " + e.getMessage());
                        }
                        break;
                    case "5":
                        out.println("Exiting. Goodbye!");
                        break;
                    default:
                        out.println("Invalid option. Try again.\n");
                }
            } while (!"5".equals(choice));

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getMenu() {
        return "------- Student Management System -------\n" +
               "1. Add New Student\n" +
               "2. Display All Students\n" +
               "3. Save Students to File\n" +
               "4. Load Students from File\n" +
               "5. Exit\n" +
               "-----------------------------------------\n" +
               "Enter your choice:";
    }
}
