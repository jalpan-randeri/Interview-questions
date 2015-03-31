package google;

/**
 * Created by jalpanranderi on 11/20/14.
 */
public class LookAndSay {

    public static void main(String[] args) {
//        System.out.println(getNextLookAndSay(21));

        getNextLookAndSayInt(1);
        getNextLookAndSayInt(11);
        getNextLookAndSayInt(21);
        getNextLookAndSayInt(1211);

    }




    public static int getNextLookAndSay(int current){
        StringBuilder builder = new StringBuilder();
        String txt = String.valueOf(current);

        int count = 1;
        char prev = txt.charAt(0);

        for(int i = 1; i < txt.length(); i++){
            if(prev == txt.charAt(i)){
                count++;
            }else{
                builder.append(count);
                builder.append(prev);
                prev = txt.charAt(i);
                count = 1;
            }
        }

        builder.append(count);
        builder.append(prev);

        return Integer.parseInt(builder.toString());
    }


    public static int getNextLookAndSayInt(int current){
        int count = 0;
        int prev = 0;

        int answer = 0;


        while(current > 0){
            int unit = current % 10;
            if(unit == prev){
                count++;
            }else{
                answer = answer + ((prev + (count * 10)) * length(answer));
                count = 1;
                prev = unit;
            }

            current = current / 10;
        }

        answer = answer + ((prev + (count * 10)) * length(answer));

        System.out.println(answer);
        return  answer;
    }

    private static int length(int answer) {
        int count = 0;
        while(answer > 0){
            answer = answer / 10;
            count++;
        }
        return (int) Math.pow(10, count);
    }

}
