package programming_interview_exposed;

/**
 * Created by jalpanranderi on 11/17/14.
 */
public class TelephoneWords {

    public static void main(String[] args) {
        generateWords(4971927);

        System.out.println(getUnitNumber(4971927));

    }


    private static void generateWords(int number){
        wordHelper(number, 0, new char[7]);
    }

    private static void wordHelper(int number, int current,char[] ans) {
        if(current == 7){
            System.out.println(String.valueOf(ans));
        }else{
            char[] words = getCharForLetter(getUnitNumber(number));
            for (char word : words) {
                ans[6 - current] = word;
                wordHelper(number / 10, current + 1, ans);
                ans[6 - current] = '-';
            }
        }
    }


    private static int getUnitNumber(int number){
        return number % 10;
    }


    private static char[] getCharForLetter(int letter){
        switch(letter){
            case 0: return new char[] {'0'};
            case 1: return new char[] {'1'};
            case 2: return new char[] {'a', 'b', 'c'};
            case 3: return new char[] {'d', 'e', 'f'};
            case 4: return new char[] {'g', 'h', 'i'};
            case 5: return new char[] {'j', 'k', 'l'};
            case 6: return new char[] {'m', 'n', 'o'};
            case 7: return new char[] {'p', 'q', 'r', 's'};
            case 8: return new char[] {'t', 'u', 'v'};
            case 9: return new char[] {'w', 'x', 'y', 'z'};
            default:
                return new char[]{};

        }
    }
}
