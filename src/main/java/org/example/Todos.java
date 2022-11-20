package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Todos {
    protected List<String> tasks = new ArrayList<>();
    protected final int taskSize = 7;


    public void addTask(String task) {
        if (tasks.size() < taskSize) {
            tasks.add(task);
        }
    }

    public void removeTask(String task) {
        tasks.remove(task);
    }

    public String getAllTasks() {
        String listTasks = tasks.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.joining(" "));
        return listTasks;
    }

}
