import java.util.*;

public class OnlineStockSpan {
    Stack<int[]> stack; // int[] {price, span}

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }
        
        stack.push(new int[]{price, span});
        
        return span;
    }
    
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        
        System.out.println(stockSpanner.next(100)); // Output: 1
        System.out.println(stockSpanner.next(80));  // Output: 1
        System.out.println(stockSpanner.next(60));  // Output: 1
        System.out.println(stockSpanner.next(70));  // Output: 2
        System.out.println(stockSpanner.next(60));  // Output: 1
        System.out.println(stockSpanner.next(75));  // Output: 4
        System.out.println(stockSpanner.next(85));  // Output: 6
    }
}


//Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.

//The span of the stock's price in one day is the maximum number of consecutive days (starting from that day and going backward) 
//for which the stock price was less than or equal to the price of that day.

//For example, if the prices of the stock in the last four days is [7,2,1,2] and the price of the stock today is 2, 
//then the span of today is 4 because starting from today, the price of the stock was less than or equal 2 for 4 consecutive days.
//Also, if the prices of the stock in the last four days is [7,34,1,2] and the price of the stock today is 8, 
//then the span of today is 3 because starting from today, the price of the stock was less than or equal 8 for 3 consecutive days.
//Implement the StockSpanner class: