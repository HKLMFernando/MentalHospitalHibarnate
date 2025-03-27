module com.assignment.mentalhealththeraphycenter {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.assignment.mentalhealththeraphycenter to javafx.fxml;
    exports com.assignment.mentalhealththeraphycenter;
}