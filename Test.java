package lab;

// exp 1
class Area{
    void area(){
        System.out.println("No parameters");
    }
    void area(int side){
        System.out.println("The area of the square is: "+(side * side));
    }
    void area(float r){
        System.out.println("The area of te circle is: "+(3.14*r*r));
    }
    void area(int l,int b){
        System.out.println("The area of the rectangle is: "+(l*b));
    }
}  

public class Test{
    public static void main(String [] args){
        Area a = new Area();
        a.area();
        a.area(5);
        a.area(2.8f);
        a.area(9,3);
    }
}

// exp 2

import java.util.*;

public class Test{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array of integers: ");
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int sum = 0;
        int n;
        while(st.hasMoreTokens()){
            n = Integer.parseInt(st.nextToken());
            System.out.println(n);
            sum += n;
        }
        System.out.println("sum: "+sum);
    }
}

// exp 3 a

class Shape{
    int dim1,dim2;
    
    Shape(){
        dim1 = 0;
        dim2 = 0;
    }
    
    Shape(int a,int b){
        dim1 = a;
        dim2 = b;
    }
    
    void area(){
        System.out.println("Base class with no area");
    }
}

class Rectangle extends Shape{
    Rectangle(int a,int b){
        super(a,b);
    }
    
    void area(){
        System.out.println("Area of the rectangle is: "+(dim1*dim2));
    }
}

public class Test{
    public static void main(String [] args){
        Shape s = new Shape(4,5);
        Rectangle r = new Rectangle(3,4);
        
        s.area();
        r.area();
    }
}

// exp 3 b

import java.util.*;

class Student{
    int rollno;
    String name;

    Student(String n,int r){
        name = n;
        rollno = r;
    }
}

class Academics extends Student{
    int sub[];

    Academics(String n,int r,int s[]){
        super(n, r);
        sub = s;
    }
}

class Sports extends Academics{
    int sm;

    Sports(String n,int r,int s[],int sp){
        super(n, r, s);
        sm  = sp;
    }
}

class Result extends Sports{
    int total;
    float per;
    char grade;

    Result(String n,int r,int s[],int sp){
        super(n, r, s, sp);
    }

    void calculate(){
        for (int i : sub) {
            total += i;
        }
        total += sm;
        per = total/(float)(sub.length+1);
        if(per>=80 && per<=100){
            grade = 'A';
        } else if(per>=60 && per<80){
            grade = 'B';
        } else if(per>=40 && per<60){
            grade = 'C';
        } else if(per>0){
            grade = 'D';
        }
    }
    
    void display(){
        System.out.println("The total marks, percentage and grade of student " + name+" is:");
        System.out.println(total + " " + per +" "+grade);
    }
}

public class Test{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student's name: ");
        String name = sc.next();
        System.out.println("Enter student's roll no: ");
        int r = sc.nextInt();
        System.out.println("Enter the number of subjects: ");
        int n = sc.nextInt();
        int m[] = new int[n];
        System.out.println("Enter the marks: ");
        for(int i = 0;i<n;i++){
            m[i] = sc.nextInt();
        }
        System.out.println("Enter the sports marks: ");
        int sm = sc.nextInt();
        Result res = new Result(name, r, m, sm);
        res.calculate();
        res.display();
    }
}

// exp 4 a

import java.util.*;

interface Company{
    int pt = 200;
    int pf = 1800;
    int ta = 2000;
    int da = 5000;
    void grossSal();
}

class Employee{
    String name;
    int basicSal;
    
    Employee(String n,int bs){
        name = n;
        basicSal = bs;
    }
    
    void display(){
        System.out.println("Name of the employee is "+name+" and his basic salary is "+basicSal);
    }
}

class Salary extends Employee implements Company{
    int hra;
    
    Salary(String n,int bs,int h){
        super(n,bs);
        hra = h;
    }
    
    public void grossSal(){
        super.basicSal = super.basicSal -pt-pf+ta+hra+da;
    }
    
    void display(){
        super.display();
        grossSal();
        System.out.println("His gross salary is: "+super.basicSal);
    }
}

public class Test{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter employee name: ");
        String name = sc.next();
        System.out.print("Enter his basic salary: ");
        int bs = sc.nextInt();
        System.out.print("Enter his hra: ");
        int hra = sc.nextInt();
        Salary s = new Salary(name,bs,hra);
        s.display();
    }
}

// exp 4 b

abstract class Shape{
    int dim1,dim2;
    
    Shape(){
        dim1=0;
        dim2=0;
    }
    
    Shape(int a,int b){
        dim1 = a;
        dim2 = b;
    }
    
    abstract void area(); 
}

class Rectangle extends Shape{
    Rectangle(int a,int b){
        super(a,b);
    }
    
    void area(){
        System.out.println("Area of the rectangle is: "+(dim1*dim2));
    }
}

class Triangle extends Shape{
    Triangle(int a,int b){
        super(a,b);
    }
    
    void area(){
        System.out.println("Area of the triangle is: "+(dim1*dim2/2));
    }
}

public class Test{
    public static void main(String [] args){
        Shape s = new Rectangle(12,15);
        s.area();
        s = new Triangle(8,5);
        s.area();
    }
}

// exp 5 a

public class Test {
    public static void main(String[] args) {
        int [] a = {1,2,3,4};
        try{
            int x = 50/0;
            System.out.println(a[5]);
        } catch(ArithmeticException e){
            System.out.println(e);
        } catch(IndexOutOfBoundsException ie){
            System.out.println(ie);
        }
        System.out.println("I am last line of main");
    }
}

// exp 5 b

import java.util.*;

class InvalidAge extends Exception{
    InvalidAge(String s){
        super(s);
    }
}

public class Test{
    static void validate(int age) throws InvalidAge{
        if(age<18){
            throw new InvalidAge("Not valid for voting");
        } else{
            System.out.println("Welcome to voting");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int n = sc.nextInt();
        try {
            validate(n);
        } catch (InvalidAge e) {
            System.out.println(e);
        }
    }
}

// exp 6 a

class A extends Thread{
    public void run(){
        try{
            for(int i=0;i<5;i++){
                sleep(1000);
                System.out.println("CSE");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    } 
} 


class B extends Thread{
    public void run(){
        try{
            for(int i=0;i<5;i++){
                sleep(1000);
                System.out.println("IT");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    } 
} 

class C extends Thread{
    public void run(){
        try{
            for(int i=0;i<5;i++){
                sleep(1000);
                System.out.println("AIML");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    } 
} 

public class Test{
    public static void main(String [] args){
        A a1 = new A();
        B b1 = new B();
        C c1 = new C();
        a1.start();
        b1.start();
        c1.start();
    }
}

// exp 6 b

class A implements Runnable{
    public void run(){
        try{
            for(int i=0;i<5;i++){
                java.lang.Thread.sleep(1000);
                System.out.println("CSE");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    } 
} 


class B implements Runnable{
    public void run(){
        try{
            for(int i=0;i<5;i++){
                java.lang.Thread.sleep(1000);
                System.out.println("IT");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    } 
} 

class C implements Runnable{
    public void run(){
        try{
            for(int i=0;i<5;i++){
                java.lang.Thread.sleep(1000);
                System.out.println("AIML");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    } 
} 

public class Test{
    public static void main(String [] args){
        A a1 = new A();
        B b1 = new B();
        C c1 = new C();
        Thread t1 = new Thread(a1);
        Thread t2 = new Thread(b1);
        Thread t3 = new Thread(c1);
        t1.start();
        t2.start();
        t3.start();
    }
}


// exp 7 and 8

class A{
    int n;
    boolean b = false;
    
    synchronized int get(){
        if(!b){
            try{
                wait();
            } catch(Exception e){
                System.out.println(e);
            }
        }
        System.out.println("Got: " + n);
        b = false;
        notify();
        return n;
    }
    
    synchronized void put(int n){
        if(b){
            try{
                wait();
            } catch(Exception e){
                System.out.println(e);
            }
        }
        this.n = n;
        b = true;
        System.out.println("Put: "+n);
        notify();
    }
}

class Producer implements Runnable{
    A a1;
    Thread t1;
    Producer(A a1){
        this.a1 = a1;
        t1 = new Thread(this);
        t1.start();
    }
    public void run(){
        for(int i=0;i<=10;i++){
            a1.put(i);
        }
    }
}

class Consumer implements Runnable{
    A a1;
    Thread t1;
    Consumer(A a1){
        this.a1 = a1;
        t1 = new Thread(this);
        t1.start();
    }
    public void run(){
        for(int i=0;i<=10;i++){
            a1.get();
        }
    }
}

public class Test{
    public static void main(String [] args){
        A a1 = new A();
        Producer p1 = new Producer(a1);
        Consumer c1 = new Consumer(a1);
    }
}

// exp 9 a

import java.util.*;

class Test {
    public static void main(String [] args){
        ArrayList a = new ArrayList();
        a.add("A");
        a.add(10);
        a.add("A");
        a.add(null);
        System.out.println(a);
        a.remove(2);
        System.out.println(a);
        a.add(2,"m");
        a.add("n");
        System.out.println(a);  
    }
}

// exp 9 b

import java.util.*;

class Test{
    public static void main(String [] args){
        LinkedList l = new LinkedList();
        l.add("CSE");
        l.add(30);
        l.add(null);
        l.add("CSE");
        System.out.println(l);
        l.set(0, "Software");
        System.out.println(l);
        l.set(0,"Delittle");
        System.out.println(l);
        l.removeLast();
        System.out.println(l);
        l.addFirst("Wipro");
        System.out.println(l);
    }
}

// exp 9 c

import java.util.*;

class Test {
    public static void main(String [] args){
        TreeSet t = new TreeSet<>();
        t.add("A");
        t.add("B");
        t.add("Z");
        t.add("L");
        t.add(10);
        t.add(null);
    }
}

// exp 9 d

import java.util.*;

public class Test {
    public static void main(String [] args){
        HashMap m = new HashMap();
        m.put("xyz", 101);
        m.put("aaa", 102);
        m.put("bbb", 103);
        System.out.println(m);
        System.out.println(m.put("abc", 101));
        Set s = m.keySet();
        System.out.println(s);
        Set e = m.entrySet();
        System.out.println(e);
        Iterator itr = e.iterator();
        while(itr.hasNext()){
            Map.Entry ml = (Map.Entry) itr.next();
            System.out.println(ml.getKey() + " " + ml.getValue());
            if(ml.getKey().equals("bbb")){
                ml.setValue(1000);
            }
        }
        System.out.println(m);
    }
}

// exp 10 a

import java.util.*;

class Test {
    public static void main(String [] args){
        Vector v = new Vector();
        v.add(10);
        v.add(20);
        v.add(15);
        v.add(25);
        Enumeration e = v.elements();
        while(e.hasMoreElements()){
            System.out.println(e.nextElement());
        }
    }
}

// exp 10 b

import java.util.*;

class Test{
    public static void main(String [] args){
        Hashtable <String, Integer> ht = new Hashtable<String, Integer>();
        ht.put("a", 100);
        ht.put("b", 200);
        ht.put("c", 300);
        ht.put("d", 400);
        Set st = ht.entrySet();
        Iterator itr = st.iterator();
        while(itr.hasNext()){
            Map.Entry m = (Map.Entry) itr.next();
            System.out.println(m.getKey()+" "+m.getValue());
        }
    }
}

// exp 10 c

import java.util.*;

class Test {
    public static void main(String [] a){
        Dictionary <Integer,String> d = new Hashtable<Integer, String> ();
        d.put(1, "AA");
        d.put(2, "BB");
        d.put(3, "CC");
        Enumeration <Integer> key = d.keys();
        while(key.hasMoreElements()){
            System.out.println(key.nextElement());
        }
        Enumeration <String> element = d.elements();
        while(element.hasMoreElements()){
            System.out.println(element.nextElement());
        }
    }
}

// exp 11 a
import java.util.*;

public class Test{
    public static void main(String[] args){
        HashMap a=new HashMap();
        a.put("A",101);
        a.put("B",102);
        a.put("C",103);
        a.put("D",104);
        a.put("E",105);
        Set e=a.entrySet();
        Iterator i=e.iterator();
        while(i.hasNext()){
            Map.Entry m=(Map.Entry)i.next();
            
            System.out.println(m.getKey()+" "+m.getValue());
            if(m.getKey().equals("E")){
                m.setValue(106);
            }
        }
    }
}

// exp 11 b

import java.util.*;
public class Test{
    public static void main(String[] args){
       
        ArrayList a=new ArrayList();
        a.add("AB");
        a.add("ghttu");
        a.add(10);
        a.add(null);
        ListIterator li=a.listIterator();
        while(li.hasNext())
        {
            System.out.println(li.next());
        }
        while(li.hasPrevious())
        {
            System.out.println(li.previous());
        }
    }
}

// exp 12
import java.io.*;
public class Test {
    public static void main(String[] args) throws IOException{
        BufferedReaderbr = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\nEnter A FileName:";);
        String fName = br.readLine();
        File f = new File(fName);
        String result = f.exists() ? "exists." : "does not exist.";
        System.out.println("\nThe given file" + result);
        if(f.exists()) {
            result = f.canRead() ? "readable." : "not readable.";
            System.out.println("The given file is " + result);
            result = f.canWrite() ? "writable." : "not writable.";
            System.out.println("The given file is " + result);
            System.out.println("The given file length is " + f.length() + " inbytes.");
            if (fName.endsWith(".jpg") || fName.endsWith(".gif") || fName.endsWith(".png")) {
                System.out.println("The given file is an image file.");
            } else if (fName.endsWith(".exe")) {
                System.out.println("The given file is an executable file");
            } else if (fName.endsWith(".txt")) {
                System.out.println("The given file is a text file.");
            } else {
                System.out.println("The file type is unknown.");
            }
        }
    }
}

// exp 13
import java.io.*;

public class Test {
    public static void main(String [] args){
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream("input.txt");
            out = new FileOutputStream("output.txt");
            int c;
            while((c = in.read()) != -1){
                out.write(c);
            }
        } catch(Exception e){
            System.out.println(e);
        }
        finally{
            try{
                if(in != null){
                    in.close();
                }
                if(out != null){
                    out.close();
                }
            } catch(Exception e){
                System.out.println(e);
            }
        }
    }
}

// exp 14

class Student implements Serializable{
    String name;
    int id;
    Student(String n,int i){
        name=n;
        id=i;
    }
}
public class Test{
    public static void main(String[] args) {
        Student s=new Student("Ngit", 2453);
        System.out.println("Serialization started:");
        FileOutputStream Fos= new FileOutputStream("Student.ser");
        ObjectInputStream os= new ObjectInputStream(Fos);
        os.writeObject(s);
        System.out.println("Serilazation end");
        System.out.println("deseialization started");
        FileInputStream fis=new FileInputStream("Student.esr");
        ObjectInputStream ois= new ObjectInputStream(fis);
        s=(Student)ois.readObject();
        System.out.println("deserialization ends");
        System.out.println("Student details are=");
        System.out.println(s.name);
        System.out.println(s.id);
    }
}