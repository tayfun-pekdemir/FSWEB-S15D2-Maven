package org.example;

import org.example.entity.Task;
import org.example.entity.TaskData;

import java.util.HashSet;
import java.util.Set;

import static org.example.entity.StringSet.findUniqueWords;


public class Main {
    public static void main(String[] args) {

        System.out.println("************** Task *********************");
        Task task1 = new Task("Java1","task1");
        Task task2 = new Task("Java2","task2");
        Task task3 = new Task("Java3","task3");
        Task task4 = new Task("Java4","task4");
        Task task5 = new Task("Java5","task5");
        Task task6 = new Task("Java6","task6");

        Set<Task> allTasks = new HashSet<>();
        allTasks.add(task1);
        allTasks.add(task2);
        allTasks.add(task3);
        allTasks.add(task4);
        allTasks.add(task5);
        allTasks.add(task6);

        Set<Task> annsTasks = new HashSet<>();
        annsTasks.add(task1);
        annsTasks.add(task3);
        annsTasks.add(task4);

        Set<Task> bobsTasks = new HashSet<>();
        bobsTasks.add(task2);
        bobsTasks.add(task3);
        bobsTasks.add(task4);

        Set<Task> carolsTasks = new HashSet<>();
        carolsTasks.add(task3);
        carolsTasks.add(task4);
        carolsTasks.add(task5);

        Set<Task> unassignedTasks = new HashSet<>();

        TaskData taskData = new TaskData(annsTasks, bobsTasks, carolsTasks, unassignedTasks);

        // Tüm çalışanlarının üzerindeki tasklar nelerdir ?

        System.out.println("Tüm çalışanların taskları: " + taskData.getTasks("all"));

        //  Her bir çalışanın üzerindeki tasklar nelerdir ?

        System.out.println("Ann's tasks: " + taskData.getTasks("ann"));
        System.out.println("Bob's tasks: " + taskData.getTasks("bob"));
        System.out.println("Carol's tasks: " + taskData.getTasks("carol"));

        // Herhangi bir çalışana atanması yapılmamış olan tasklar nelerdir ?

        System.out.println("Atama yapılmayan task: " + taskData.getDifferences(allTasks,taskData.getTasks("all")));

        // Birden fazla çalışana atanmış task var mı ? Varsa bunlar hangileri ?

        System.out.println("Birden çok atanan task: " + taskData.getIntersection(taskData.getUnion(annsTasks,bobsTasks),carolsTasks));

        System.out.println("*************** StringSet ********************");

        System.out.println(findUniqueWords());
        System.out.println(findUniqueWords().size());

    }
}