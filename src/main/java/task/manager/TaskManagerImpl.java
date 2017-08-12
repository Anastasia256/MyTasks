package task.manager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class TaskManagerImpl implements TaskManager {

    private Map<LocalDateTime, Task> tasks = new TreeMap<>();

    @Override
    public void add(LocalDateTime date, Task task) {
        tasks.put(date, task);
    }

    @Override
    public void remove(LocalDateTime date) {
        tasks.remove(date);
    }

    @Override
    public Set<String> getCategories() {
        Set<String> categories = new TreeSet<>();

        for (Task task : tasks.values()) {
            categories.add(task.getCategory());
        }
        return categories;
    }

    @Override
    public Map<String, List<Task>> getTasksByCategories(String... categories) {

        Map<String, List<Task>> listTasks = new TreeMap<>();

        for (String category : categories) {
            if (getTasksByCategory(category).size() != 0) {
                listTasks.put(category, getTasksByCategory(category));
            }
        }
        return listTasks;
    }

    @Override
    public List<Task> getTasksByCategory(String category) {

        List<Task> listTasks = new ArrayList<>();

        for (Task task : tasks.values()) {
            if (task.getCategory().equals(category)) {
                listTasks.add(task);
            }
        }
        return listTasks;
    }

    @Override
    public List<Task> getTasksForToday() {

        LocalDate today = LocalDate.now();

        List<Task> listTasks = new ArrayList<>();

        for (Map.Entry<LocalDateTime, Task> entry : tasks.entrySet()){
            LocalDate key = entry.getKey().toLocalDate();
            if (key.equals(today)){
                listTasks.add(entry.getValue());
            }
        }
        return listTasks;
    }
}