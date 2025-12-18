public class Queue_Homework 
{
    public static void main(String[] args) 
    {
        Queue<Integer> q1=new Queue<Integer>();
        q1.insert(1);
        q1.insert(3);
        q1.insert(3);
        Queue<Integer> q2=ex1_QueueCopy(q1);
        printQ(q2);
        System.out.println(ex2_avgQ(q1));
        System.out.println(ex3_modQ(q1, 3));
        Queue<Double> q3=new Queue<Double>();
        q3.insert(1.0);
        q3.insert(3.0);
        Queue<Double> q4=ex1_QueueCopy(q3);
        System.out.println(ex4_allDivide(q3, q4));
        System.out.println(ex5_2inARow(q1, 1));

    }
    public static <T> Queue ex1_QueueCopy(Queue<T> q1)
    {
        Queue<T> q2=new Queue<T>();
        Queue<T> q3=new Queue<T>();
        while (!q1.isEmpty())
        {
            T a= q1.remove();
            q2.insert(a);
            q3.insert(a);
        }    
        while (!q3.isEmpty())
            q1.insert(q3.remove());
        return q2;      
    }
    public static <T> void printQ(Queue<T> q1)
    {
       Queue <T> q2=ex1_QueueCopy(q1);      
       while (!q2.isEmpty())
        System.out.println(q2.remove());  
       return;
    }
    public static double ex2_avgQ(Queue <Integer> q1)
    {
        double x=0;
        int i=0;
        Queue <Integer> q2 = ex1_QueueCopy(q1);
        while (!q2.isEmpty())
        {    
            x+=q2.remove();
            i++;
        }
        return x/i;    
    }
    public static int ex3_modQ(Queue <Integer> q1, int x)
    {
        int i=0;
        Queue <Integer> q2 = ex1_QueueCopy(q1);
        while (!q2.isEmpty())
        {
            if (q2.remove()%x==0)
                i++;
        }
        return i;    
    }
    public static boolean ex4_allDivide(Queue <Double> q1, Queue <Double> q2)
    {
        boolean checker=false;
        Queue <Double> q3 = ex1_QueueCopy(q1);
        Queue <Double> q4 = ex1_QueueCopy(q2);
        while (!q3.isEmpty())
        {
            checker=false;
            double a = q3.remove();
            q4 = ex1_QueueCopy(q2);
            while (!q4.isEmpty())
            {
                double b=q4.remove();
                if (a%b==0)
                    checker=true;
            }
            if (checker==false)   
                return false; 
        }
        return true;    
    }
    public static <T> boolean ex5_2inARow(Queue <T> q1, T x)
    {
        Queue <T> q2=ex1_QueueCopy(q1);
        T a= q2.remove();
        while (!q2.isEmpty())
        {
            T b=q2.remove();
            if (a==b && b==x)
                return true;
            a=b;
        }
        return false;    
    }
}
