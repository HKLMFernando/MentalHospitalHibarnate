package com.assignment.mentalhealththeraphycenter.service.custom.impl;

import com.assignment.mentalhealththeraphycenter.dto.ProgramDto;
import com.assignment.mentalhealththeraphycenter.dto.TherapyProgramDTO;
import com.assignment.mentalhealththeraphycenter.service.custom.TProgramBO;

import java.util.List;

public class TProgrmeBOImpl  implements TProgramBO {
    @Override
    public boolean saveTPrograms(TherapyProgramDTO therapyProgramDTO) {
        return false;
    }

    @Override
    public boolean updateTPrograms(TherapyProgramDTO therapyProgramDTO) {
        return false;
    }

    @Override
    public boolean deleteTProgram(String therapyProgramID) {
        return false;
    }

    @Override
    public List<ProgramDto> getALLTPrograms() throws Exception {
        return List.of();
    }

    @Override
    public String getNextProgramID() {
        return "";
    }

    @Override
    public List<ProgramDto> getALL() throws Exception {
        return List.of();
    }
}
