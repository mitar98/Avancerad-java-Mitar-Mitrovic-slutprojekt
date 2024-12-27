package org.example.todofrontend;

import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ToDoApp extends Application {
    private final ApiService apiService = new ApiService();
    private final TableView<Task> tableView = new TableView<>();

    @Override
    public void start(Stage primaryStage) {
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> showTaskDialog(null));

        Button editButton = new Button("Edit");
        editButton.setOnAction(e -> {
            Task selectedTask = tableView.getSelectionModel().getSelectedItem();
            if (selectedTask != null) {
                showTaskDialog(selectedTask);
            }
        });

        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> {
            Task selectedTask = tableView.getSelectionModel().getSelectedItem();
            if (selectedTask != null) {
                deleteTask(selectedTask);
            }
        });

        HBox buttonBar = new HBox(10, addButton, editButton, deleteButton);
        VBox root = new VBox(10, tableView, buttonBar);
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setTitle("To-Do List");
        primaryStage.show();

        setupTable();
        loadTasks();
    }

    private void setupTable() {
        TableColumn<Task, String> descriptionCol = new TableColumn<>("Description");
        descriptionCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDescription()));

        TableColumn<Task, Boolean> completedCol = new TableColumn<>("Completed");
        completedCol.setCellValueFactory(data -> new SimpleBooleanProperty(data.getValue().isCompleted()));

        tableView.getColumns().addAll(descriptionCol, completedCol);
    }

    private void loadTasks() {
        try {
            ObservableList<Task> tasks = apiService.fetchTasks();
            tableView.setItems(tasks);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showTaskDialog(Task task) {
        TextInputDialog dialog = new TextInputDialog(task == null ? "" : task.getDescription());
        dialog.setTitle(task == null ? "Add Task" : "Edit Task");
        dialog.setHeaderText(null);
        dialog.setContentText("Description:");

        dialog.showAndWait().ifPresent(description -> {
            if (task == null) {
                createTask(new Task(null, description, false));
            } else {
                task.setDescription(description);
                updateTask(task);
            }
        });
    }

    private void createTask(Task task) {
        try {
            apiService.createTask(task);
            loadTasks();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateTask(Task task) {
        try {
            apiService.updateTask(task);
            loadTasks();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteTask(Task task) {
        try {
            apiService.deleteTask(task.getId());
            loadTasks();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}