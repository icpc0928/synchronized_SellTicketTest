import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SellTicketInTXT {
    public static void main(String[] args){

        SellTicketVision3 ticket = new SellTicketVision3(100);
        String player = "Player";
        for(int i = 10; i <= 20; i++){
            new Thread(ticket, player + i).start();
        }

    }
}

class SellTicketVision3 implements Runnable{
    private int num;            //車票總數
    private int init = 1;       //起始值
    private int counter = 0;

    public SellTicketVision3(int num){
        this.num = num;
    }

    @Override
    public synchronized void run() {

        while(true){
//            System.out.println("Counter: " + counter++);
            synchronized (this){

                try{

                    String pathName = "D:\\SellTicket.txt";
                    File fileName = new File(pathName);
                    InputStreamReader reader = new InputStreamReader(new FileInputStream(fileName));
                    BufferedReader br = new BufferedReader(reader);

                    String line2 = br.readLine();
                    Pattern p = Pattern.compile("\\s*|\t|\r|\n");
                    Matcher m = p.matcher(line2);
                    String line = m.replaceAll("");
                    int txtNum = Integer.parseInt(line);
//                    System.out.println("txtNum: " + txtNum);

                    if(txtNum > num){
                        System.out.println(Thread.currentThread().getName() + "已經賣完惹");
                        return;
                    }
                    System.out.println(Thread.currentThread().getName() + "售出火車票: " + txtNum++);
//                    init = txtNum;
                    //寫入檔案
                    File writeName = new File("D:\\SellTicket.txt");
                    BufferedWriter out = new BufferedWriter(new FileWriter(writeName));
                    String text = String.valueOf(txtNum);
                    out.write(text);
                    out.flush();
                    out.close();

                    this.wait((int)(Math.random() * 1000 + 1));     //等待一下(模擬正常流程，不然跑太快都讓其中幾個執行序作完惹)
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}