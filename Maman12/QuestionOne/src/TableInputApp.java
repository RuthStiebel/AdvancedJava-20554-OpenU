import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableInputApp extends Application {

    private ObservableList<TableRowData> tableData = FXCollections.observableArrayList();
    private TableView<TableRowData> tableView;

    public static void main(String[] args) {
        launch(args);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Table Input App");

        // Create table columns
        TableColumn<TableRowData, String> column1 = new TableColumn<>("Column 1");
        column1.setCellValueFactory(cellData -> cellData.getValue().column1Property());

        TableColumn<TableRowData, String> column2 = new TableColumn<>("Column 2");
        column2.setCellValueFactory(cellData -> cellData.getValue().column2Property());

        // Create TableView
        tableView = new TableView<>();
        tableView.setItems(tableData);
        tableView.getColumns().addAll(column1, column2);

        // Create input fields
        TextField textField1 = new TextField();
        textField1.setPromptText("Enter text for Column 1");

        TextField textField2 = new TextField();
        textField2.setPromptText("Enter text for Column 2");

        // Create buttons
        Button addButton = new Button("Add Row");
        addButton.setOnAction(event -> {
            tableData.add(new TableRowData(textField1.getText(), textField2.getText()));
            textField1.clear();
            textField2.clear();
        });

        Button doneButton = new Button("Done");
        doneButton.setOnAction(event -> {
            printTableData();
            primaryStage.close();
        });

        // Create layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(tableView, new HBox(10, textField1, textField2, addButton, doneButton));

        primaryStage.setScene(new Scene(layout, 400, 300));
        primaryStage.show();
    }

    private void printTableData() {
        System.out.println("Table Data:");
        for (TableRowData row : tableData) {
            System.out.println(row.getColumn1() + "\t" + row.getColumn2());
        }
    }

    // Data model for table row
    public static class TableRowData {
        private final StringProperty column1;
        private final StringProperty column2;

        public TableRowData(String column1, String column2) {
            this.column1 = new SimpleStringProperty(column1);
            this.column2 = new SimpleStringProperty(column2);
        }

        public StringProperty column1Property() {
            return column1;
        }

        public StringProperty column2Property() {
            return column2;
        }

        public String getColumn1() {
            return column1.get();
        }

        public String getColumn2() {
            return column2.get();
        }
    }
}
