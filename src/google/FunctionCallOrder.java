package google;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 *
 *
 * main() {
 A()
 C()
 }

 A() {
 B()
 }

 B() {}
 C() {}

 input:
 t1 main enter
 t2 A enter
 t3 B enter
 t4 B exit
 t5 A exit
 t6 C enter
 t7 C exit
 t8 main exit

 output:
 main (t8-t1)
  A (t5-t2)
   B (t4-t3)
  C (t7-t6)

 * Created by jalpanranderi on 11/21/14.
 */
public class FunctionCallOrder {
    public static void main(String[] args) {
        String[] ip = {"t1 main enter" ,
                "t2 A enter",
                "t3 B enter" ,
                "t4 B exit" ,
                "t5 A exit" ,
                "t6 C enter" ,
                "t7 C exit" ,
                "t8 main exit"};

        printCallHiarchicy(ip);
    }


    public static void printCallHiarchicy(String[] ip){
        Stack<String> call_stack = new Stack<>();
        HashMap<String, String> lifetime = new HashMap<>();
        Queue<String> call_sequance = new LinkedList<>();

        for(String i : ip){
            processInput(i.split(" "), call_stack, lifetime, call_sequance);
        }



        while(!call_sequance.isEmpty()){
            String key = call_sequance.remove();
            System.out.println(lifetime.get(key));
        }

    }

    private static void processInput(String[] params, Stack<String> stack, HashMap<String, String> lifetime, Queue<String> sequance){
        if("enter".equals(params[2])){
            stack.push(params[1] + " "+ params[0]);
            sequance.add(params[1]);
        }else{
            String[] returnValue = stack.pop().split(" ");
            String life = addSpace(stack.size())+returnValue[0] + " ("+ params[0] +" - " + returnValue[1]+")";
            lifetime.put(returnValue[0], life);
        }
    }

    private static String addSpace(int count){
        StringBuilder builder = new StringBuilder();
        while(count > 0){
            builder.append(" ");
            count--;
        }
        return builder.toString();
    }
}
