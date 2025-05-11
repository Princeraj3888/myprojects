package java8.practice;

public class ReplaceCharacterInString {

    public static void main(String[] args){
        String str = "hi my native is hyderabad";
        String vowels = "aeiou";
        int k = 2;
        StringBuffer sbf = new StringBuffer();

        for(char ch : str.toCharArray()){
            if(vowels.indexOf(ch)!=-1){
                int index = (vowels.indexOf(ch) + k) % (vowels.length());
                sbf.append(vowels.charAt(index));
            }else {
                sbf.append(ch);
            }
        }

        System.out.println("string replaced with vowels: "+ sbf.toString());
    }
}
