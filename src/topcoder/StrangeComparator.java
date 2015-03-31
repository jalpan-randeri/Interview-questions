package topcoder;

/**
 * Created by jalpanranderi on 11/23/14.
 */
public class StrangeComparator {

    public String[] compareString(String[] a, String[] b){
        String[] ans = new String[a.length];
        String yes = "YES";
        String no = "NO";

        for(int i = 0; i < a.length; i++){
            if(a[i].length() == b[i].length() && isDifferByOne(a[i], b[i])){
                ans[i] = yes;
            }else{
                ans[i] = no;
            }
        }
      return ans;
    }

    private boolean isDifferByOne(String a, String b){
        int count = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                count++;
                if(count > 1){
                    return false;
                }
            }
        }
        return true;
    }
}
