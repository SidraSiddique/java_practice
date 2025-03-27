// java syntax
public  class Main{
    public static void main(String[]args){
    System.out.println("hello world");
    }
}
//variables in java:
public  class Main{
    public static void main(String[]args){
        int number=123;
        System.out.println(number);
    }
}
// example:student info:
public  class Main{
    public static void main(String[]args){
        String name="Asad";
        int id=001;
        String section="afternoon";
        String degree="data science";
        Float gpa=3.87f;
        System.out.println("name:"+name);
        System.out.println("id:"+id);
        System.out.println("section:"+section);
        System.out.println("degree:"+degree);
        System.out.println("gpa:"+gpa);
    }
}   

//type casting
public class main{
    public static void main(String[]args){
        int mynum=9;
        double number=mynum;
        System.out.println(mynum);
        System.out.println(number);

    }
}

// 2nd example:
public class main{
    public static void main(String[]args){
        double mynum=99.6d;
        int number=(int)mynum;
        System.out.println(mynum);
        System.out.println(number);

    }
}

//array example:
public class Main {
    public static void main(String[] args) {
        String[] num = {"1", "2", "3", "4"}; 
        int max = Integer.MIN_VALUE; 
        for (int i = 0; i < num.length; i++) {
            int Number = Integer.parseInt(num[i]); 
            max = Math.max(max, Number);
        }
        System.out.println("Maximum value: " + max);
    }
}
//or without coverting string to int:
public class Main {
    public static void main(String[] args) {
       int[] num = {1, 2, 3, 4, 5};
       int max = num[0];
       for (int i = 1; i < num.length; i++) {
            max = Math.max(max, num[i]);
        }
        System.out.println("Maximum value: " + max);
    }
}

