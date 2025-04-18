package com.assignment.mentalhealththeraphycenter.service.custom;



import com.assignment.mentalhealththeraphycenter.dto.ProgramDto;
import com.assignment.mentalhealththeraphycenter.dto.TherapyProgramDTO;
import com.assignment.mentalhealththeraphycenter.service.SuperBO;

import java.util.List;

public interface TProgramBO extends SuperBO {
    boolean saveTPrograms(TherapyProgramDTO therapyProgramDTO);
    boolean updateTPrograms(TherapyProgramDTO therapyProgramDTO);
    boolean deleteTProgram(String therapyProgramID);
    List<ProgramDto> getALLTPrograms() throws Exception;
    String getNextProgramID();
    List<ProgramDto> getALL () throws Exception;
}
