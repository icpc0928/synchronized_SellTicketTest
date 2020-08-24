public class SellTicket {
    public static void main(String[] args){

        TicketWindow tw = new TicketWindow();
        Thread t1 = new Thread(tw, "1號窗口");
        Thread t2 = new Thread(tw, "2號窗口");
        Thread t3 = new Thread(tw, "3號窗口");

        t1.start();

        t2.start();
        t3.start();
        for(int i = 0; i < 20; i ++){
            int rand = (int)(Math.random() * 1000);
            t1.start();
            if ((rand % 2 == 0)) {
                t2.start();
            } else {
                t3.start();
            }
            if((rand % 3 == 0)){
                t3.start();
            }else{
                t2.start();
                t1.start();
            }
        }

    }



}

class TicketWindow implements Runnable{

    private int tickets = 10;

    @Override
    public synchronized void run() {
        System.out.println(Thread.currentThread().getName() + " Coming");
//        while(true){
            if(tickets > 0){
                System.out.println("剩餘 " + tickets + " 張票");
                tickets--;
                System.out.println(Thread.currentThread().getName() + "賣出一張票，還剩" + tickets + "張");

            }else{
                System.out.println("賣完惹");
                try {
                    System.out.println("ThreadSleep");
                    Thread.sleep(1000 * 60 * 5);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
//        }
    }
}
