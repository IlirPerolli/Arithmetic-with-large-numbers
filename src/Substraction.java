public class Substraction {
    public static String sub(String s1, String s2){

        String zeros = "";
        String number1 = s1;
        String number2 = s2;
        String sub = "";
        String sign = "+";

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

        if ((number1.charAt(number1.length()-1) < number2.charAt(number2.length()-1)) || s1.length() < s2.length()){
            String temp = "";
            temp = number1;
            number1 = number2;
            number2 = temp;
            sign = "-";
        }

        number1 = reverse(number1);
        number2 = reverse(number2);

        int reminder = 0;
        for (int i = 0; i < number1.length(); i++) {
            int substractedNumbers;
            if (reminder == 1 && (number1.charAt(i) == number2.charAt(i))) {

                int number = Integer.parseInt(Character.toString(number1.charAt(i)))+10;

                substractedNumbers = (number- Integer.parseInt(Character.toString(number2.charAt(i))))-reminder;

                reminder = 1;

                sub += substractedNumbers;
                continue;
            }
            if (number1.charAt(i) < number2.charAt(i)){
                substractedNumbers = ((Integer.parseInt(Character.toString(number1.charAt(i)))+10) - Integer.parseInt(Character.toString(number2.charAt(i))))-reminder;
                reminder = 1;
            }
            else{
                substractedNumbers = (Integer.parseInt(Character.toString(number1.charAt(i))) - Integer.parseInt(Character.toString(number2.charAt(i))))-reminder;
                reminder = 0;
            }
            sub += substractedNumbers;
        }
        sub = reverse(sub);
        if (sign.equals("-")){
            sub = sign + sub;
        }
        return sub;
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
        String s1 = "6";
        String s2 = "5";
        System.out.print(s1 + " - " + s2 + " = " + sub(s1,s2));

    }
}
