package most_asked;

/**
 * Created by jalpanranderi on 11/8/14.
 */
public class ExcelSheet {


    public static void main(String[] args) {
//        for(int i = 1; i <= 706; i++) {
//            System.out.println(generateString(i));
//        }

        System.out.println(generateString(84));
//        System.out.println(generateString(27));
//        System.out.println(getNumber("abc"));
//        System.out.println(generateString(734));

        getNumber("cf");

    }


    public static String generateString(int n) {
        StringBuilder builder = new StringBuilder();

        do {
            if(n % 26 != 0){
                builder.append((char) ('a' + (n % 26) - 1));
            }
            n = n / 26;
        }while (n > 0);

        return builder.reverse().toString();
    }

    private static int getNumber(String no){

        int ans=0;

        for(int i =  0; i < no.length(); i++ ){
            int value = no.charAt(i) - 'a' + 1;
            ans = ans * 26;
            ans += value;
        }

        return ans;
    }


}
