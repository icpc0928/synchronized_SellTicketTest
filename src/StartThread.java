import java.io.*;

public class StartThread {
    public static void main(String[] args){
        Thread thread1 = new Thread(new Txt1("Leo"));
        Thread thread2 = new Thread(new Txt1("Wei"));
        Thread thread3 = new Thread(new Txt1("May"));
        Thread thread4 = new Thread(new Txt1("ABC"));
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();


    }
}

class Txt1 implements Runnable{

    private Runnable target;
    private String playerID = "Player";

    public Txt1(String playerID){
        this.playerID = playerID;
    }

    @Override
    public void run() {
        System.out.println(playerID);
//        if(target != null){
//            target.run();
//        }

        String pathName = "D:\\testInput.txt";
        File fileName = new File(pathName);
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(fileName));
            BufferedReader br = new BufferedReader(reader);
//            StringBuilder line = new StringBuilder();
//            while(br.ready()){
//                line.append(br.readLine() + "\r\n");
//
//            }
            String line = br.readLine();
            int num = Integer.parseInt(line) + (int) (Math.random() * 5);
            System.out.println("Num: " + num);
            String wr = String.valueOf(num);

            //寫入檔案
            File writeName = new File("D:\\testInput.txt");
            BufferedWriter out = new BufferedWriter(new FileWriter(writeName));
//            out.write(String.valueOf(line));

//            for(int i = 0; i < 1000; i++){
//                out.write(playerID + ": " + i + "\r\n");
//            }

            out.write(wr);

            out.flush();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
