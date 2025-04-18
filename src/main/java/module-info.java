module com.assignment.mentalhealththeraphycenter {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires net.sf.jasperreports.core;
    requires java.mail;
    requires mysql.connector.j;
    requires jakarta.persistence;
    requires java.naming;
    requires org.hibernate.orm.core;
    requires  lombok;
    opens com.assignment.mentalhealththeraphycenter.config to jakarta.persistence;
    opens com.assignment.mentalhealththeraphycenter.entity to org.hibernate.orm.core;

    exports com.assignment.mentalhealththeraphycenter.entity;


    opens com.assignment.mentalhealththeraphycenter to javafx.fxml;
    exports com.assignment.mentalhealththeraphycenter;
    exports com.assignment.mentalhealththeraphycenter.controller;
    opens com.assignment.mentalhealththeraphycenter.controller to javafx.fxml;
    opens com.assignment.mentalhealththeraphycenter.dto.TM to javafx.base;

    exports com.assignment.mentalhealththeraphycenter.dto to org.hibernate.orm.core;

}