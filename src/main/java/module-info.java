module com.example.tanks {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tanks to javafx.fxml;
    exports com.example.tanks;
}