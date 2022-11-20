import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.Task;
import org.example.Todos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodosTests {

    Todos todos = new Todos();
    Task task = new Task();

    @BeforeEach
    void setUp() {
        String jsonText = "{ \"type\": \"ADD\", \"task\": \"Сделать зарядку\" }";
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        task = gson.fromJson(jsonText, Task.class);
    }

    @Test
    public void testAddTask() {
        todos.addTask(task.task);
        Assertions.assertEquals("Сделать зарядку", todos.getAllTasks());
    }

    @Test
    public void testRemoveTask() {
        todos.addTask("Сходить в магазин");
        todos.addTask("Сделать зарядку");
        todos.addTask("Убраться в доме");
        todos.removeTask("Сделать зарядку");
        Assertions.assertEquals("Сходить в магазин Убраться в доме", todos.getAllTasks());
    }

    @Test
    public void testGetAllTasks() {
        todos.addTask("Сходить в магазин");
        todos.addTask("Сделать зарядку");
        todos.addTask("Убраться в доме");
        Assertions.assertEquals("Сходить в магазин Сделать зарядку Убраться в доме", todos.getAllTasks());
    }
}

