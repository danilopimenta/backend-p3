package fatec.ipiranga.p3crud.controller;

import fatec.ipiranga.p3crud.dto.CreateEnrollmentDTO;
import fatec.ipiranga.p3crud.model.Enrollment;
import fatec.ipiranga.p3crud.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/forms")
public class P3FormsController {
    @Autowired
    EnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<Enrollment> createEnrollment(@RequestBody CreateEnrollmentDTO createEnrollmentDto) {
        return ResponseEntity.ok(enrollmentService.createEnrollment(createEnrollmentDto));
    }

    @PutMapping
    public ResponseEntity<Boolean> updateEnrollment(@RequestParam Long id, @RequestBody CreateEnrollmentDTO createEnrollmentDto) {
        return ResponseEntity.ok(enrollmentService.updateEnrollment(id, createEnrollmentDto));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteEnrollment(@RequestParam Long id) {
        return ResponseEntity.ok(enrollmentService.deleteEnrollment(id));
    }

    @GetMapping
    public ResponseEntity<List<Enrollment>> findAll() {
        return ResponseEntity.ok(enrollmentService.findAll());
    }
}
