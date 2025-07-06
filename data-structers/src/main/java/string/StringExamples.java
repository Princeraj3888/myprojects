package string;

public class StringExamples {

    public static void main(String args[]){

        //length method, to find number of characters
        String str = "number of characters";
        System.out.println("number of characters length: "+str.length());

        //charAt(index)
        System.out.println("character at index 5 is: "+str.charAt(5));

        //substring method with begin index
        System.out.println("substring method with begin index method: "+str.substring(10));

        //substring with begin and end index
        System.out.println("substring with begin and end index: "+str.subSequence(7, 9));

        //contains method with sequence of characters
        System.out.println("contains method with sequence of characters: "
                +str.contains("number")+" no available: "+str.contains("any"));

        //startsWith method
        System.out.println("startsWith method example: "+str.startsWith("array")+" no: "+str.startsWith("number"));

        //endsWith method
        System.out.println("endsWith method example: "+str.endsWith("characters")+" no: "+str.endsWith("any"));

        //indexOf method
        System.out.println("indexOf method example: "+str.indexOf("o"));

        //lastIndex of method
        System.out.println("lastIndex of method: "+str.lastIndexOf("r"));

        int arr1[] = new int[5];
        arr1[0] = 4;
        int brr[] = arr1;
        brr[0] = 5;
        System.out.println(arr1[0]);
        System.out.println(brr[0]);

    }
}
