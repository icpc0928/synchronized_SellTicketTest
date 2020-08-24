public class BinaryPlusBinaryVision2 {

    public static void main(String[] args){
        String a = "1000101";
        String b = "1111";
        String res = new SolutionV2().addBinary(a, b);
        System.out.println(res);
    }
}

class SolutionV2{
    public String addBinary(String a, String b){
        int a1 = Integer.parseInt(a, 2);
        int b1 = Integer.parseInt(b, 2);
        String s3 = Integer.toBinaryString(a1 + b1);
        System.out.println(s3);

        return "";
    }
}
