package topcoder;

import java.util.Arrays;
import java.util.Stack;

/**
 * Examples
 0)

     
 {"BACK", "BACK", "FORWARD", "FORWARD"}
 Returns: { }
 No page needs to be loaded, because no page visit command is issued.
 1)

     
 {"a.com", "b.com", "c.com", "BACK", "BACK", "BACK",
 "FORWARD", "FORWARD", "FORWARD"}
 Returns: {"a.com", "b.com", "c.com", "b.com", "a.com", "b.com", "c.com" }
 There may be more BACK or FORWARD commands than those that can be executed.
 2)

     
 {"a.com", "b.com", "BACK", "c.com", "BACK", "FORWARD"}
 Returns: {"a.com", "b.com", "a.com", "c.com", "a.com", "c.com" }
 When "c.com" is loaded, the browser forgets "b.com" as a forward page.
 3)

     
 {"a.com", "b.com", "b.com", "BACK"}
 Returns: {"a.com", "b.com", "a.com" }
 The second "b.com" command is ignored, so the "BACK" command goes to "a.com".
 4)

     
 {"a.com", "b.com", "BACK", "a.com", "FORWARD"}
 Returns: {"a.com", "b.com", "a.com", "b.com" }
 The second "a.com" command is ignored, so b.com is not ignored as a forward page.
 5)

     
 {"ag", "BACK", "bh", "BACK", "af", "bp", "BACK", "FORWARD",
 "ao", "BACK", "bo", "FORWARD", "BACK", "BACK", "ah"}
 Returns: {"ag", "bh", "ag", "af", "bp", "af", "bp", "ao", "bp", "bo", "bp", "af", "ah" }
 *
 *
 * Created by jalpanranderi on 11/8/14.
 */
public class WebBrowser {

    public static void main(String[] args) {
        String[] actions0 = {BACK, FORWARD, BACK, BACK};
        String[] answer0 = {};

        String[] actions1 =  {"a", "b", "BACK", "FORWARD", "FORWARD"};
        String[] answer1 =  {"a", "b", "a", "b" };
//
        String[] actions2 = {"a.com", "b.com", "c.com", "BACK", "BACK", "BACK",
                "FORWARD", "FORWARD", "FORWARD"};
        String[] answer2= {"a.com", "b.com", "c.com", "b.com", "a.com", "b.com", "c.com" };

        String[] actions3 = {"a.com", "b.com", "BACK", "c.com", "BACK", "FORWARD"};
        String[] answer3 = {"a.com", "b.com", "a.com", "c.com", "a.com", "c.com" };

        String[] actions4 = {"a.com", "b.com", "b.com", "BACK"};
        String[] answer4 = {"a.com", "b.com", "a.com" };

        String[] actions5 = {"a.com", "b.com", "BACK", "a.com", "FORWARD"};
        String[] answer5 =  {"a.com", "b.com", "a.com", "b.com" };

        String[] actions6 = {"ag", "BACK", "bh", "BACK", "af", "bp", "BACK", "FORWARD",
                             "ao", "BACK", "bo", "FORWARD", "BACK", "BACK", "ah"};
        String[] answer6 = {"ag", "bh", "ag", "af", "bp", "af", "bp", "ao", "bp", "bo", "bp", "af", "ah" };

        System.out.println("Test 0 "+Arrays.equals(getSequence(actions0), answer0));
        System.out.println("Test 1 "+Arrays.equals(getSequence(actions1), answer1));
        System.out.println("Test 2 "+Arrays.equals(getSequence(actions2), answer2));
        System.out.println("Test 3 "+Arrays.equals(getSequence(actions3), answer3));
        System.out.println("Test 4 "+Arrays.equals(getSequence(actions4), answer4));
        System.out.println("Test 5 "+Arrays.equals(getSequence(actions5), answer5));
        System.out.println("Test 6 "+Arrays.equals(getSequence(actions6), answer6));


//        System.out.println(Arrays.toString(getSequence(actions)));
    }

    private static final String BACK = "BACK";
    private static final String FORWARD = "FORWARD";



    public static String[] getSequence(String[] actions){

        Stack<String> history = new Stack<>();
        Stack<String> future = new Stack<>();
        Stack<String> load  = new Stack<>();
        String curr = null;
        String last = null;
        for(String action : actions) {


            switch (action) {
                case BACK:
                    if (!history.isEmpty()) {
                        future.push(curr);
                        curr = history.pop();
                    }
                    last = BACK;
                    break;
                case FORWARD:
                    if (!future.isEmpty()) {
                        history.push(curr);
                        curr = future.pop();
                    }
                    last = FORWARD;
                    break;
                default:
                    if(curr != null && !curr.equals(action) ) {
                        history.push(curr);
                        if(last != null){
                            future.removeAllElements();
                        }
                    }
                    curr = action;

                    last = null;
                    break;
            }

            insertLoadedPage(curr, load);
        }

        return getTrack(load);
    }

    private static String[] getTrack(Stack<String> load) {
        String[] track = new String[load.size()];
        int count = track.length - 1;
        while(!load.empty()){
            track[count--] = load.pop();
        }

        return track;
    }


    private static void insertLoadedPage(String page, Stack<String> load){
        if(page == null || BACK.equals(page) && FORWARD.equals(page)){
            return;
        }else if(load.isEmpty()){
            load.push(page);
        }else if(!load.peek().equals(page)){
            load.push(page);
        }
    }
}
