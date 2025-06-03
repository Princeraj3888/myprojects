package immutable;

import java.util.ArrayList;
import java.util.List;

public record RecordSample(int id, String name, List<String> stringList) {

    public RecordSample{
        stringList = List.copyOf(stringList);
    }

    public static void main(String[] args){
        List<String> stringList = new ArrayList<>();
        stringList.add("first");

        RecordSample sample = new RecordSample(1, "test", stringList);
        System.out.println("sample: "+sample);
        /*stringList = sample.stringList();
        stringList.add("second");
        System.out.println("after editing sample: "+sample);*/
    }

}
