package day3;

public class FindPalindromeIndex {

    public static void main(String[] args){
        String s = "aaa";

        System.out.println("find palindrome index: "+findPalindromeIndex(s));

    }

    private static int findPalindromeIndex(String s) {
        char[] c = s.toCharArray();
        //aaab
        int left = 0;
        int right = s.length() - 1; //3
        while(left < right){
            if(c[left]!=c[right]){
                if(isPalindrome(c, left+1, right)){
                    return left;
                }

                if(isPalindrome(c, left, right - 1)){
                    return right;
                }
                return -1;
            }
            left++;
            right--;
        }
        return -1;
    }

    private static boolean isPalindrome(char[] ch, int left, int right) {
        while(left < right){
            if(ch[left]!=ch[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


}

