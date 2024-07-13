import java.util.*;

public class SearchSuggestionsSystem {
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // Sort the products lexicographically
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        
        String prefix = "";
        
        // For each character in searchWord, find the suggestions
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            List<String> suggestions = new ArrayList<>();
            int start = binarySearch(products, prefix);
            
            // Collect up to 3 products starting with the current prefix
            for (int i = start; i < products.length && suggestions.size() < 3; i++) {
                if (products[i].startsWith(prefix)) {
                    suggestions.add(products[i]);
                } else {
                    break;
                }
            }
            
            result.add(suggestions);
        }
        
        return result;
    }
    
    // Binary search to find the starting index of products matching the prefix
    private int binarySearch(String[] products, String prefix) {
        int low = 0, high = products.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (products[mid].compareTo(prefix) >= 0) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    
    public static void main(String[] args) {
        ProductSuggester suggester = new ProductSuggester();
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";
        List<List<String>> result = suggester.suggestedProducts(products, searchWord);
        for (List<String> list : result) {
            System.out.println(list);
        }
        // Expected output:
        // ["mobile", "moneypot", "monitor"]
        // ["mobile", "moneypot", "monitor"]
        // ["mouse", "mousepad"]
        // ["mouse", "mousepad"]
        // ["mouse", "mousepad"]
    }
}


//You are given an array of strings products and a string searchWord.

//Design a system that suggests at most three product names from products after each character of searchWord is typed. 
//Suggested products should have common prefix with searchWord. If there are more than three products with a common prefix return 
//the three lexicographically minimums products.

//Return a list of lists of the suggested products after each character of searchWord is typed.