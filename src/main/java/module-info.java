module com.assignment.mentalhealththeraphycenter {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires static lombok;


    opens com.assignment.mentalhealththeraphycenter to javafx.fxml;
    exports com.assignment.mentalhealththeraphycenter;
}