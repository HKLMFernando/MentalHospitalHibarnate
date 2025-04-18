package com.assignment.mentalhealththeraphycenter.repostory.custom;



import com.assignment.mentalhealththeraphycenter.entity.Patient;
import com.assignment.mentalhealththeraphycenter.repostory.CrudDAO;

import java.util.List;

public interface PatientDAO extends CrudDAO<Patient,String> {
    List<Patient> searchPatientName(String searchByName);
    String search(String patientName);

}
