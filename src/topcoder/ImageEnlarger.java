package topcoder;



/**
 * Created by jalpanranderi on 10/24/14.
 */
public class ImageEnlarger{

    public static void main(String[] args) {

        String[] image = {"---------",
                          "-TTT--CC-",
                          "--T--C---",
                          "--T--C---",
                          "--T---CC-",
                          "---------"};
        int factor = 10;

        new ImageEnlarger().enlarge(image, factor);
    }

    public String[] enlarge(String[] image, int factor){
        String[] scaled = new String[image.length * factor];

//        StringBuilder scaledString = new StringBuilder();

        for(int org_i=0, scale_i=0; org_i < image.length && scale_i < scaled.length; org_i++){
            String scaledString = getScaledString(image[org_i].toCharArray(), factor);
            int rep = factor;

            while(rep > 0){
                scaled[scale_i] = scaledString;
                scale_i++;
                rep--;

            }
        }

        return scaled;

    }

    private String getScaledString(char[] str, int scale){
        char[] answer =  new char[str.length * scale];

        System.out.printf("original length %d  and scaled is %d\n",str.length, str.length * scale);

        for(int str_i = 0, scaled_i =0; str_i < str.length && scaled_i < answer.length; str_i++ ){
            int rep = scale;

            while(rep > 0){
                System.out.printf("sclaed_i is %d \n",scaled_i);
                answer[scaled_i] = str[str_i];
                scaled_i++;
                rep--;
//                break;
            }
        }

        return new String(answer);
    }



}
