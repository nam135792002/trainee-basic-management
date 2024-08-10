package vn.edu.likelion.service;

import vn.edu.likelion.model.TraineeDTO;

import java.util.List;

public interface TraineeInterface {
    TraineeDTO create(TraineeDTO traineeDTO);
    TraineeDTO update(TraineeDTO traineeDTO);
    List<TraineeDTO> listAll();
    String delete(Integer traineeId);
}
