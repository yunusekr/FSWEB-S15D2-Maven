package org.example.entity;

import java.util.HashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getTasks(String name){
        Set<Task> unionTasks = new HashSet<>();
        unionTasks.addAll(annsTasks);
        unionTasks.addAll(bobsTasks);
        unionTasks.addAll(carolsTasks);
        return switch (name) {
            case "ann" -> annsTasks;
            case "bob" -> bobsTasks;
            case "carol" -> carolsTasks;
            case "all" -> unionTasks;
            default -> unassignedTasks;
        };
    }

    public Set<Task> getUnion(Set<Task> allTask,Set<Task> allTask1){
        Set<Task> total = new HashSet<>(allTask);
        total.addAll(allTask1);
        return total;
    }

    public Set<Task> getIntersection(Set<Task> task1, Set<Task> task2){
        Set<Task> total = new HashSet<>(task1);
        total.retainAll(task2);
        return total;
    }

    public Set<Task> getDifferences(Set<Task> task1, Set<Task> task2){
        Set<Task> total = new HashSet<>(task1);
        total.removeAll(task2);
        return total;
    }
}