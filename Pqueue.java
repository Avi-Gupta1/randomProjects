import java.util.*;
class PQueue {
    
     public static class MyPriorityQueue<T> {
        ArrayList < T > data;
        Comparator comparable;

        public MyPriorityQueue() {
            data = new ArrayList < > ();
        }
        
        public MyPriorityQueue(Comparator<T> c) {
            
            data = new ArrayList<>();
            comparable = c;
        }
        
        // public PriorityQueue(int[] arr) {
        //     data = new ArrayList<>();
        //     for (int i = 0; i < arr.length; i++) {
        //         data.add(arr[i]);
        //     }
            
            
        // }
        public boolean ismin(int idx1,int idx2) {
            
            if(comparable == null) {
            Comparable ith = (Comparable)data.get(idx1);
            Comparable jth = (Comparable)data.get(idx2);
            
            int ans = ith.compareTo(jth);
            if(ans < 0) {
                return true;
            }
            
            return false;
            }else{
                T ith = data.get(idx1);
                T jth = data.get(idx2);
                return (comparable.compare(ith,jth) < 0);
            }
        }
        
        public void swap(int ci, int pi) {
            T ith = data.get(ci);
            T jth = data.get(pi);
            data.set(ci, jth);
            data.set(pi, ith);
        }
        public void upheapify(int ci) {
            if (ci == 0) {
                return;
            }

            int pi = (ci - 1) / 2;
            if (ismin(ci,pi)) {
                swap(ci, pi);
                upheapify(pi);
            }

        }
        public void add(T val) {
            data.add(val);
            upheapify(data.size() - 1);
        }

        public void downheapify(int pi) {
            int lc = 2 * pi + 1;
            int rc = 2 * pi + 2;


            int isv = pi;

            if (lc < data.size() && ismin(lc,isv)) {
                isv = lc;
            }
            if (rc < data.size() && ismin(rc,isv)) {
                isv = rc;
            }

            if (isv != pi) {
                swap(isv, pi);
                downheapify(isv);
            }

        }

        public T remove() {
            if (data.size() == 0) {
                System.out.println("Underflow");
                return null;
            }
            swap(0, data.size() - 1);
            T rv = data.remove(data.size() - 1);
            downheapify(0);
            return rv;
        }

        public T peek() {
            if (data.size() == 0) {
                System.out.println("Underflow");
                return null;
            }
            return data.get(0);
        }

        public int size() {
            return data.size();
        }
    }
    
    
    
    
    
    
     public static class Student implements Comparable<Student>{
        int roll_no;
        int wt;
        int ht;
        int marks;
        
        public Student(int roll_n0,int wt,int ht,int marks) {
            this.roll_no = roll_n0;
            this.wt = wt;
            this.ht = ht;
            this.marks = marks;
        }
        
        public int compareTo(Student o){
            return this.roll_no - o.roll_no;
        }
        
        public String toString() {
            return this.roll_no + " -- > " +"height : " + this.ht + "  weight : "+ this.wt + " Marks : " + this.marks;
        }
        
    }
    
    public static class Studentwt implements Comparator<Student> {
        public int compare(Student s1,Student s2) {
            return s1.wt - s2.wt;
        }
    }
    
    
    
    public static void main(String[] args) {
      Student[] arr = new Student[5];
        arr[0] = new Student(4,54,100,54);
        arr[1] = new Student(1,73,120,78);
        arr[2] = new Student(3,91,110,74);
        arr[3] = new Student(2,67,90,69);
        arr[4] = new Student(6,82,94,60);   
        MyPriorityQueue<Student>  m = new MyPriorityQueue<>(new Studentwt());
        for (Student s : arr) {
            m.add(s);
        }
        
        while(m.size() != 0){
            System.out.println(m.remove());
        }
        
    }
}