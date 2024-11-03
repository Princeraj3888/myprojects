package com.demo.springboot_cache.test;

import com.demo.springboot_cache.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestApp {

    public static void main(String args[]){
        ComputeAdd compute = (a, b)->{
            return a + b;
        };

        int c = compute.add(10, 20);
        System.out.println("addition is : "+c);

        List<User> studentList = new ArrayList<>();
        User user1 = new User();  user1.setId(Long.valueOf(1)); user1.setUserName("test1");
        User user2 = new User();  user2.setId(Long.valueOf(2)); user2.setUserName("test2");
        User user3 = new User();  user3.setId(Long.valueOf(3)); user3.setUserName("test3");
        User user4 = new User();  user4.setId(Long.valueOf(4)); user4.setUserName("test4");
        User user5 = new User();  user5.setId(Long.valueOf(5)); user5.setUserName("test5");

        studentList.add(user1);
        studentList.add(user2);
        studentList.add(user3);
        studentList.add(user4);
        studentList.add(user5);

        Map<Long, String> newStudentMap = new HashMap<>();

        studentList.stream().forEach( student -> {
            newStudentMap.put(student.getId(), student.getUserName());
        });

        System.out.println("new map is: "+newStudentMap.size());

        newStudentMap.forEach((key, value) ->{
            System.out.println("key= "+key + " value= "+value);
        });
    }
}
