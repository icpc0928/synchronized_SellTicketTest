import java.io.*;

public class Txt {
    public static void main(String[] args){
        try{
            //防止檔案建立或讀取失效，用catch捕捉錯誤並列印
            //讀取txt檔案
            String pathname = "D:\\testInput.txt";
            File filename = new File(pathname); //要讀取路徑
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));  //建立一個輸入流物件reader
            BufferedReader br = new BufferedReader(reader); //建立一個物件，他把檔案內容轉成計算機能讀懂的語言
//            StringBuilder line = new StringBuilder();
//            while(br.ready()){
//
//                line.append(br.readLine()).append("\r\n");   //一次讀入一行資料
//            }
            String line = "";
            line = br.readLine();
            int num = Integer.parseInt(line);




            //寫入txt檔案
            File writeName = new File("D:\\testInput.txt");
//            writeName.createNewFile();  //建立新檔案
            BufferedWriter out = new BufferedWriter(new FileWriter(writeName));




//            out.write(String.valueOf(line));

//            for(int i = 0; i < 10; i++){
//                out.write("test: " + i + " \r\n");
//            }
            out.write(num + 1);

            out.flush();
            out.close();

        }catch(Exception e){
            System.out.println("catch: " + e.toString());
        }
    }
}
