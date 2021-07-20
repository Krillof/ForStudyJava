package car_number_generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberGenerator {
    private static List<Character> symbols;
    private static Random random;
    private static String constant_part = " 116 RUS";

    public static String last_number = "А000АА 116 RUS";

    public static final int NUMBERS_AMOUNT = 1728000;

    static {
        random = new Random();
        symbols = new ArrayList<>();
        symbols.add('А');
        symbols.add('В');
        symbols.add('Е');
        symbols.add('К');
        symbols.add('М');
        symbols.add('Н');
        symbols.add('О');
        symbols.add('Р');
        symbols.add('С');
        symbols.add('Т');
        symbols.add('У');
        symbols.add('Х');


    }

    public static String getRandom(){
        int digits = random.nextInt( 1000); // [0, 999]
        Character first = symbols.get(random.nextInt(12));
        Character second = symbols.get(random.nextInt(12));
        Character third = symbols.get(random.nextInt(12));
        last_number = first + Integer.toString(digits) + second + third + constant_part;
        return last_number;
    }

    private static String threeDigitsNumbersToString(int numbers){
        if (numbers < 100){
            if (numbers < 10){
                return "00" + Integer.toString(numbers);
            } else {
                return "0" + Integer.toString(numbers);
            }
        } else {
            if (numbers > 999) return "";
            else return Integer.toString(numbers);
        }
    }

    public static String getNext(){
        Character first = last_number.charAt(0);
        int digit_first = Integer.parseInt(last_number.charAt(1) + "");
        int digit_second = Integer.parseInt(last_number.charAt(2) + "");
        int digit_third = Integer.parseInt(last_number.charAt(3) + "");
        Character second = last_number.charAt(4);
        Character third = last_number.charAt(5);
        int digits = digit_first*100 + digit_second*10+digit_third;


        if (digits == 999){
            int i3 = symbols.indexOf(third);
            if (i3 == 11){
                i3 = 0;
                int i2 = symbols.indexOf(second);
                if (i2 == 11){
                    i2 = 0;

                    int i1 = symbols.indexOf(first);
                    if (i1 == 11){
                        i1 = 0;             //All to zero
                    } else {
                        i1++;
                    }

                    first = symbols.get(i1);

                } else {
                    i2++;
                }
                second = symbols.get(i2);
            } else {
                i3++;
            }

            third = symbols.get(i3);
            digits = 0;

        } else {
            digits++;
        }

        last_number = first + threeDigitsNumbersToString(digits) + second + third + constant_part;
        return last_number;
    }


}
