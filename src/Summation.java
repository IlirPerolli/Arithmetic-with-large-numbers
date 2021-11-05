public class Summation {
    public static String sum(String s1, String s2){
        String zeros = "";
        String number1 = s1;
        String number2 = s2;
        String sum = "";

        if (s1.length() < s2.length()){
            for(int i=0; i<s2.length() - s1.length();i++){
                zeros += "0";
            }
            zeros += number1;
            number1 = zeros;
        }
        else{
            for(int i=0; i<s1.length() - s2.length();i++){
                zeros += "0";
            }
            zeros += number2;
            number2 = zeros;
        }

        number1 = reverse(number1);
        number2 = reverse(number2);

        int reminder = 0;

        for (int i = 0; i < number1.length(); i++) {

            int addedNumbers = (Integer.parseInt(Character.toString(number1.charAt(i))) + Integer.parseInt(Character.toString(number2.charAt(i))))+reminder;
            if (addedNumbers > 9){
                addedNumbers = addedNumbers % 10;
                reminder = 1;
            }
            else reminder = 0;

            sum += addedNumbers;

            if (i == number1.length()-1 && reminder == 1){
                sum += "1";
            }
        }
        return reverse(sum);
    }


    public static String reverse(String s1){
        char r;
        String reverse = "";
        for (int i=0; i<s1.length(); i++)
        {
            r= s1.charAt(i);
            reverse= r+reverse;
        }
        return reverse;
    }
    public static void main(String[] args){
        String s1 = "250505050202020505051020202022100";
        String s2 = "062051505050505050505050585055050055052";
        System.out.print(s1 + " + " + s2 + " = " + sum(s1,s2));
    }
}
