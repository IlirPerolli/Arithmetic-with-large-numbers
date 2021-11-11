
public class Multiplication {
    public static String multiply(String s1, String s2){

        String number1 = s1;
        String number2 = s2;

        number1 = reverse(number1);
        number2 = reverse(number2);

        String [] multiply = new String[number2.length()];
        String mult = "";
        int reminder = 0;

        for (int i = 0; i < number2.length(); i++) {

            mult = "";

            for (int j = 0; j < number1.length(); j++) {

                int multipliedNumbers = (Integer.parseInt(Character.toString(number2.charAt(i))) * Integer.parseInt(Character.toString(number1.charAt(j))))+reminder;
                if (multipliedNumbers > 9 && j != number1.length()-1){

                    reminder = multipliedNumbers / 10;
                    multipliedNumbers = multipliedNumbers % 10;

                }
                else reminder = 0;

                mult = multipliedNumbers + mult;

            }

            multiply[i] = mult;

        }

        // shto 0 ne vargun multiply djatht
        String zeros = "";

        for (int i=0; i<multiply.length; i++){
            zeros = "";
            if (i != 0){
                for (int j=0; j<i;j++){
                   zeros += "0";
                }
                multiply[i] = multiply[i]+zeros;
            }
        }
        // shto 0 ne vargun multiply majt
        for (int i=0; i<multiply.length; i++){
            zeros = "";
            int loop = maxValue(multiply) - multiply[i].length();
            for (int j = 0; j < loop; j++){
                zeros += "0";
            }
            multiply[i] = zeros + multiply[i];

        }

        String multiplyAcc = multiply[0];
        for (int i=1; i<multiply.length; i++){
            multiplyAcc = sumNumbers(reverse(multiplyAcc), reverse(multiply[i]));
        }

        for (int i=0; i<multiply.length; i++){

                System.out.println(multiply[i]);
            }

        return multiplyAcc;
    }

    public static int maxValue(String [] arr){
        int max = 0;
        for (int i = 0; i<arr.length; i++){
            if (arr[i].length() > arr[max].length()){
                max = i;
            }
        }
        return arr[max].length();
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
    public static String sumNumbers(String number1, String number2){
        int reminder = 0;

        String sum = "";
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
    public static void main(String[] args){
        String s1 = "116516165161561651651651111111654654687916515616116168486466191";
        String s2 = "1561561981098091879879165148604986497496161023054987984313211";
        System.out.println(s1 + " * " + s2 + " = " + multiply(s1,s2));

    }
}
