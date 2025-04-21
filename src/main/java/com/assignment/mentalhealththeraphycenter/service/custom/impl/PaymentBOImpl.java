package com.assignment.mentalhealththeraphycenter.service.custom.impl;

import com.assignment.mentalhealththeraphycenter.dto.PaymentDTO;
import com.assignment.mentalhealththeraphycenter.entity.Payment;
import com.assignment.mentalhealththeraphycenter.repostory.DAOFactory;
import com.assignment.mentalhealththeraphycenter.repostory.DAOType;
import com.assignment.mentalhealththeraphycenter.repostory.custom.PaymentDAO;
import com.assignment.mentalhealththeraphycenter.service.custom.PaymentBO;

import java.util.ArrayList;
import java.util.List;

public class PaymentBOImpl implements PaymentBO {
    PaymentDAO paymentDAO = DAOFactory.getInstance().getDAO(DAOType.PAYMENT);
    @Override
    public List<PaymentDTO> getALL() throws Exception {
        List<Payment> payments = paymentDAO.getAll();
        List<PaymentDTO> paymentDTOS = new ArrayList<>();
        for (Payment payment : payments) {
            paymentDTOS.add(new PaymentDTO(
                    payment.getPaymentID(),
                    payment.getPatientName(),
                    payment.getPaymentAmount(),
                    payment.getPaymentMethod(),
                    payment.getPaymentDate(),
                    payment.getPaymentTime()
            ));
        }
        return paymentDTOS;
    }
}
