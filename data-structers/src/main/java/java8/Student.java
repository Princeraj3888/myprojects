package java8;

import lombok.Data;

import java.util.List;

@Data
public class Student {

    private String name;
    private List<Integer> marks;
    private List<String> subjects;//6 subjects
    private Integer age;
}
