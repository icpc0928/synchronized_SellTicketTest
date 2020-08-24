public class BinaryPlusBinary {
    public static void main(String[] args){
        String a = "1000101";
        String b = "1111";
        String res = new Solution().addBinary(a, b);
        System.out.println(res);
    }
}

class Solution{
    public String addBinary(String a, String b){
        int carry = 0;
        int sum = 0;
        int opa = 0;
        int opb = 0;

        StringBuilder res = new StringBuilder();

        while(a.length() != b.length()){
            if(a.length() > b.length())
                b = "0" + b;
            else
                a = "0" + a;
        }

        //從後面往前作加法
        for(int i = a.length() - 1 ; i >= 0; i--){
            opa = a.charAt(i) - '0';
            opb = b.charAt(i) - '0';
            sum = opa + opb + carry;
            if(sum >= 2){
                carry = 1;
                res.append((sum - 2));
            }else{
                carry = 0;
                res.append(sum);
            }
        }
        if(carry == 1){
            res.append("1");
        }
        return res.reverse().toString();
    }
}
