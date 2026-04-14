import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i+1].startsWith(phone_book[i])) {
                return false;
            }
        }
        
        return true;
        /*
        String[] phone_book_sort = phone_book.clone();
        Arrays.sort(phone_book_sort, Comparator.comparingInt(String::length));
        
        for(int i = 0; i < phone_book_sort.length; i++){
            String phone = phone_book_sort[i];
            for(int j = (i + 1); j < phone_book.length; j++){
                if(phone_book[j].startsWith(phone)) return false;
            }
        }
        
        return true;
        */
    }
}