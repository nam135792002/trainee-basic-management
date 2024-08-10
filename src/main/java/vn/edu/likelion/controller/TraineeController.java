package vn.edu.likelion.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.likelion.model.TraineeDTO;
import vn.edu.likelion.service.TraineeServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/trainee")
public class TraineeController {
    @Autowired private TraineeServiceImpl traineeService;

    @PostMapping("/save")
    public ResponseEntity<?> add(@RequestBody @Valid TraineeDTO traineeDTO){
        return new ResponseEntity<>(traineeService.create(traineeDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(TraineeDTO traineeDTO){
        return ResponseEntity.ok(traineeDTO);
    }

    @GetMapping("/list-all")
    public ResponseEntity<?> getAll(){
        List<TraineeDTO> listTrainee = traineeService.listAll();
        if(listTrainee.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(listTrainee);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(Integer traineeId){
        return ResponseEntity.ok(traineeService.delete(traineeId));
    }
}
