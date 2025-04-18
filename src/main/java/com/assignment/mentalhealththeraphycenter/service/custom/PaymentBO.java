package com.assignment.mentalhealththeraphycenter.service.custom;

import com.assignment.mentalhealththeraphycenter.dto.PaymentDTO;
import com.assignment.mentalhealththeraphycenter.service.SuperBO;


import java.util.List;

public interface PaymentBO extends SuperBO {
    List<PaymentDTO> getALL() throws Exception;
}
