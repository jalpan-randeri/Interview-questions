package topcoder;

/**
 * Created by jalpanranderi on 12/19/14.
 */
public class LightSwitchingPuzzle {

    public static void main(String[] args) {
        minFlips("YYYYYY");
        minFlips("YNYNYNYNY");
    }

    public static int minFlips(String state){
        char[] lights = state.toCharArray();
        int steps = 0;

        for(int i = 0; i < lights.length; i++){
            if(lights[i] == 'Y'){
                steps++;
                filpState(lights, i, i+1);
            }
        }

        System.out.println(steps);

        return steps;
    }

    private static void filpState(char[] lights, int start, int incrment) {
        for(int i = start; i < lights.length; i += incrment){
            lights[i] = lights[i] == 'Y' ? 'N' : 'Y';
        }
    }
}
