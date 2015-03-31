package cracking_code.algo;

/**
 * Created by jalpanranderi on 10/22/14.
 */
public class StaticBlockAndConstructor {

    public static void main(String[] args) {
        new Child();
    }

    
    
    public static class Parent{


        static{
            System.out.println("static paren");
        }

        public Parent() {
            System.out.println("parent");
        }

        {
            System.out.println("normal parent");
        }

    }
    
    
    public static class Child extends Parent{
        static{
            System.out.println("static child");
        }

        public Child() {
            System.out.println("Child");
        }

        {
            System.out.println("normal child");
        }

    }
}
