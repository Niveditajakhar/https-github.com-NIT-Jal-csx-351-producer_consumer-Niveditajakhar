import java.util.*;
import java.lang.*;
import java.io.*;

public class PCmethod extends Thread {

    static ProducerConsumer pc;//object of producer consumer class
    int item = 1;// item in the item list

    PCmethod(String s) {
        super(s);//passing name of the thread
    }

    public static void main(String args[]) {
        try {
        	Scanner scanner = new Scanner(System. in); 
            System.out.println("enter the maximum number of items to be produced\n");// maximum size of the list
            int n = scanner. nextInt();
          
          //  System.out.println("object of producer consumer problem created\n");
            pc = new ProducerConsumer(n);//object of class producerConsumer created
            PCmethod t1 = new PCmethod("produce");//producer thread
            PCmethod t2 = new PCmethod("consume");//consumer thread
            t1.start();
            t2.start();
            System.out.println("Thread created\n");
            t1.join();
            t2.join();
            System.out.println("Thread stopped\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
//overriding run method

    public void run() {
        System.out.println(this.getName());
        if (this.getName() == "produce") {
            //produce will call produce function to produce the items
            while (true) {
                pc.produce(item);
                item++;
            }
        } else if (this.getName() == "consume") {
            //consumer will call consume function to consume the items
            while (true) {
                pc.consume();
            }
        }

    }

}