package vn.edu.likelion.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.likelion.entity.Trainee;
import vn.edu.likelion.model.TraineeDTO;
import vn.edu.likelion.repository.TraineeRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TraineeServiceImpl implements TraineeInterface {

    @Autowired private TraineeRepository traineeRepository;
    @Autowired private ModelMapper modelMapper;

    @Override
    public TraineeDTO create(TraineeDTO traineeDTO) {
        Trainee trainee = modelMapper.map(traineeDTO, Trainee.class);
        return modelMapper.map(traineeRepository.save(trainee), TraineeDTO.class);
    }

    @Override
    public TraineeDTO update(TraineeDTO traineeDTO) {
        Trainee traineeInDB = traineeRepository.findById(traineeDTO.getId())
                .orElseThrow(() -> new NoSuchElementException("Not found with id: " + traineeDTO.getId()));
        traineeInDB.setName(traineeDTO.getName());
        traineeInDB.setEmail(traineeDTO.getEmail());
        traineeInDB.setDateOfBirth(traineeDTO.getDateOfBirth());
        traineeInDB.setClassName(traineeInDB.getClassName());

        return modelMapper.map(traineeRepository.save(traineeInDB), TraineeDTO.class);
    }

    @Override
    public List<TraineeDTO> listAll() {
        List<Trainee> listTrainee = traineeRepository.findAll();
        return listTrainee.stream().map(trainee -> modelMapper.map(trainee, TraineeDTO.class)).toList();
    }

    @Override
    public String delete(Integer traineeId) {
        Trainee traineeInDB = traineeRepository.findById(traineeId)
                .orElseThrow(() -> new NoSuchElementException("Not found with id: " + traineeId));

        traineeRepository.delete(traineeInDB);
        return "Delete a trainee successfully";
    }
}
