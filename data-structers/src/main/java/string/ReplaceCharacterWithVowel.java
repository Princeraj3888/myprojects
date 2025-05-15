package string;

public class ReplaceCharacterWithVowel {

    public static void main(String args[]){
        String s = "bangalore";
        String vowel = "aeiou";
        int k = 3;

        System.out.println("original string: "+s);
        StringBuffer sbf = new StringBuffer();
        for(Character c : s.toCharArray()){
            //System.out.println("character: "+c+" updated string: "+sbf.toString());
            if(vowel.indexOf(c)!= -1){
                int index = (vowel.indexOf(c) + k) % vowel.length();
                sbf.append(vowel.charAt(index));
            }else{
                sbf.append(c);
            }
        }
        System.out.println("updated string: "+sbf.toString());


    }
}
