import java.math.BigInteger;

public class Division {
    public static void main(String[] args)
    {
        BigInteger res;

        String input1 = "4050987616065313521684";

        String input2 = "265065061651320";

        BigInteger a
                = new BigInteger(input1);
        BigInteger b
                = new BigInteger(input2);

        res = a.divide(b);

        System.out.println(a + " / " + b + " = " + res );
    }
}