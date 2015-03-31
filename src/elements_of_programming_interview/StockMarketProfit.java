package elements_of_programming_interview;

/**
 * Created by jalpanranderi on 11/18/14.
 */
public class StockMarketProfit {
    public static void main(String[] args) {

        int[] start = {1,1,1};
        int[] low = {1, -1, -2};
        int[] high = {15, 5, 25};


        System.out.println(getProfit(start, low, high));

        System.out.println(getProfitImproved(start, low, high));

    }


    private static int getProfit(int[] start, int[] low, int[] high){

        int profit = Integer.MIN_VALUE;

        for(int high_index = 0; high_index < high.length; high_index++ ){
            for(int low_index = high_index; low_index >= 0; low_index--){
                int today_profit = high[high_index] - low[low_index];
                if(today_profit > profit){
                    profit = today_profit;
                    break;
                }
            }
        }

        return profit;
    }


    private static int getProfitImproved(int[] start, int[] low, int[] high){
        int min = low[0];
        int max = high[0];
        int prof = max - min;

        for(int i = 1; i < low.length; i++){
            int curr_profit = high[i] - low[i];

            if(low[i] < min && curr_profit > prof){
                min = low[i];
                max = high[i];
                prof = max - min;
            }else if(high[i] > max){
                max = high[i];
            }
        }


        return prof;
    }





}
