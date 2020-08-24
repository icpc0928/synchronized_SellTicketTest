public class SellTicketVision2 {

    public static void main(String[] args){
        String str = "lock";
        Ticket ticket = new Ticket(1000);
        new Thread(ticket, "1號窗口").start();
        new Thread(ticket, "2號窗口").start();
        new Thread(ticket, "3號窗口").start();
        new Thread(ticket, "4號窗口").start();
        new Thread(ticket, "5號窗口").start();
        new Thread(ticket, "6號窗口").start();
        new Thread(ticket, "7號窗口").start();
        new Thread(ticket, "8號窗口").start();
        new Thread(ticket, "9號窗口").start();
    }

}

class Ticket implements Runnable{
    private int num;
    private int init = 1;
    private String lock;

    public Ticket(int num){
        this.num = num;
//        this.lock = lock;

    }

    @Override
    public void run() {
        while(true){
//            synchronized (lock){
            synchronized (this){
//                if(init > num){
//                    System.out.println("賣完惹!");
//                    return;
//                }
                try{
                    //模擬出票過程，否則因為執行太快，大部分被一個線程執行完了
                    this.wait((int)(Math.random() * 1000 + 1));
//                    this.wait(0);
//                    Thread.sleep(100);
                }catch (Exception e ){
                    e.printStackTrace();
                }
                if (init > num) {
                    System.out.println(Thread.currentThread().getName()+": 已經賣完惹");
                    return;
                }
                System.out.println(Thread.currentThread().getName() + "售出火車票: " + init++);

            }
        }

    }
}