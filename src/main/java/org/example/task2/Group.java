package org.example.task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;


public class Group<T> extends Task<T> {
    public String groupUuid;
    private List<Task<T>> tasks;
    private Visitor visitor = new Visitor();

    public Group<T> addTask(Task<T> task) {
        if (tasks == null) {
            tasks = new ArrayList<>();
        }
        tasks.add(task);
        return this;
    }

    @Override
    public void freeze() {
        super.freeze();
        groupUuid = UUID.randomUUID().toString();
        for (Task<T> task: tasks) {
            task.freeze();
        }
    }

    @Override
    public void apply(T arg) {
        this.freeze();
        this.visitor.onStart(this, this.getHeaders());
        tasks = Collections.unmodifiableList(tasks);
        for (Task<T> task: tasks) {
            task.apply(arg);
        }
        this.visitor.inTheEnd(this, this.getHeaders());
    }
}
