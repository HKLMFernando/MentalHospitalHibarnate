package com.assignment.mentalhealththeraphycenter.service;

import com.assignment.mentalhealththeraphycenter.service.custom.impl.*;

public class BOFactory {
    public static BOFactory boFactory;
    private BOFactory() {}

    public static BOFactory getInstance() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }
    @SuppressWarnings("unchecked")
    public <T extends SuperBO>T getBO(BOType type) {
        return switch (type) {
            case USER -> (T) new UserBOImpl();
            case APPOINTMENT -> (T) new AppoinmentBOImpl();
            case PATIENT -> (T) new PatientBOImpl();
            case PAYMENT -> (T) new PaymentBOImpl();
            case THERAPIST -> (T) new TherapistBOImpl();
            case THERAPY_PROGRAMS -> (T) new TProgrmeBOImpl();
        };
    }

}
