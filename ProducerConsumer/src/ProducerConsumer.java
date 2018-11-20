import java.util.ArrayList;

class ProducerConsumer {
    int capacity;// maximum capacity of the list
    ArrayList<Integer> items = new ArrayList<Integer>();

    ProducerConsumer() {
        capacity = 5;//by default capacity
    }

    ProducerConsumer(int a) {
        capacity = a;
    }

    synchronized public void produce(int item) {
        try {
            

                if (items.size() == capacity) {
                    wait();// has to wait if buffer is full
                }
                items.add(item);
                System.out.println("producer produced item" + item + "\n");
                notify();// notify all the threads after adding items to the buffer
                
                Thread.sleep(1000);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    synchronized public void consume() {
        try {
            
                if (items.size() == 0) {
                    wait();// has to wait if the buffer is empty
                }
                int item = items.get(0);
                items.remove(0);
                System.out.println("consumer consumed item" + item + "\n");
                notify();// notify all the threads after consuming
                Thread.sleep(1000);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}