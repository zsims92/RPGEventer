package main.com.RPGEventer.database.javaFX.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.com.RPGEventer.database.databaseMain;
import main.com.RPGEventer.launcher.launcher;

public class databaseMainController {
    private final databaseMain dbMain = new databaseMain();

    //Main window buttons
    public Button connectBtn;
    public Button disconnectBtn;
    public Button updateBtn;
    public Button deleteBtn;
    public Button insertBtn;

    //User info bottom panel
    public TextField serverIP;
    public TextField userName;
    public TextField databaseName;
    public TextField port;
    public PasswordField passWord;

    //Insert Menu Items
    private TextField insert_tableName;
    private TextField insert_columns;
    private TextField insert_values;

    //Update Menu Items
    private TextField update_tableName;
    private TextField update_col1val1;
    private TextField update_col2val2;

    //Delete Menu Items
    private TextField del_tableName;
    private TextField del_col1val1;

    @FXML
    public void onClickUpdate() {
        if(update_tableName.getText().equals("") ||
                update_col1val1.getText().equals("") ||
                update_col2val2.getText().equals("")){
            System.out.println("Please enter valid tables, columns, values");
        }

        String tableName = update_tableName.getText();
        String col1val1 = update_col1val1.getText();
        String col2val2 = update_col2val2.getText();

        dbMain.updateData(tableName, col1val1, col2val2);
    }

    @FXML
    public void onClickInsert(){

        if(insert_tableName.getText().equals("") ||
                insert_columns.getText().equals("") ||
                insert_values.getText().equals("")){
            System.out.println("Please enter valid tables, columns, values");
        }

        String tableName = insert_tableName.getText();
        String[] columns = {insert_columns.getText()};
        String[] values = {insert_values.getText()};

        dbMain.insertData(tableName, columns, values);
    }

    @FXML
    public void onClickDelete(){
        if(del_tableName.getText().equals("") || del_col1val1.getText().equals("") ) {
            System.out.println("Please enter valid tables, columns, values");
        }

        String tableName = del_tableName.getText();
        String col1val1 = del_col1val1.getText();

        dbMain.deleteData(tableName, col1val1);

    }

    @FXML
    public void onClickConnect(){

        if(serverIP.getText().equals("") || userName.getText().equals("") || databaseName.getText().equals("")) {
            System.out.println("Please check hostname/database name/username");

        }else {
            String ip = serverIP.getText();
            String name = userName.getText();
            String dbName = databaseName.getText();
            String pass = passWord.getText();
            String portNumber = port.getText();

            if (port.getText().equals("")) {
                portNumber = "3306";
            }

            dbMain.initConnection(ip, dbName, name, pass, portNumber);
        }
    }

    public void onClickDisconnect() {
        //TODO
        // dbMain.closeConnection();
    }

    @FXML
    public void openMenuInsert(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("insert.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setTitle("Insert Menu");
            stage.setScene(new Scene(root1));
            stage.show();

        }catch (Exception e) {
            System.out.println("Cant load new window");
        }
    }

    @FXML
    public void openMenuDelete(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("delete.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setTitle("Delete Menu");
            stage.setScene(new Scene(root1));
            stage.show();

        }catch (Exception e) {
            System.out.println("Cant load new window");
        }
    }

    @FXML
    public void openMenuUpdate(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("update.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setTitle("Update Menu");
            stage.setScene(new Scene(root1));
            stage.show();

        }catch (Exception e) {
            System.out.println("Cant load new window");
        }
    }

    @FXML
    public void openMenuDebug(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("debug.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setTitle("Debug Menu");
            stage.setScene(new Scene(root1));
            stage.show();

        }catch (Exception e) {
            System.out.println("Cant load new window");
        }
    }

    @FXML
    public void closeDatabaseGUI(){
        launcher.manager.setStage("Launcher", true);
        launcher.manager.setScene("Launcher", "Launcher");
        launcher.manager.removeStage("databse");
    }

}
