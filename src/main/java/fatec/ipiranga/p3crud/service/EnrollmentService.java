package fatec.ipiranga.p3crud.service;

import fatec.ipiranga.p3crud.dto.CreateEnrollmentDTO;
import fatec.ipiranga.p3crud.model.Enrollment;
import fatec.ipiranga.p3crud.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public Enrollment createEnrollment(CreateEnrollmentDTO enrollmentDTO) {
        // check if enrollment already exists EnrollmentRepository.findByCode
        Enrollment enrollment = enrollmentRepository.findByCode(enrollmentDTO.code());
        if (enrollment != null) {
            throw new RuntimeException("Enrollment already exists");
        }
        Enrollment newEnrollment = new Enrollment();
        newEnrollment.setCode(enrollmentDTO.code());
        newEnrollment.setName(enrollmentDTO.name());
        newEnrollment.setEmail(enrollmentDTO.email());
        newEnrollment.setPassword(enrollmentDTO.password());
        newEnrollment.setDocument(enrollmentDTO.document());
        newEnrollment.setEnrollmentGroup(enrollmentDTO.enrollmentGroup());
        newEnrollment.setObservation(enrollmentDTO.observation());
        enrollmentRepository.save(newEnrollment);
        return newEnrollment;
    }

    public boolean updateEnrollment(Long id, CreateEnrollmentDTO enrollmentDTO) {
        Enrollment enrollment = enrollmentRepository.findById(id).orElseThrow(
                        () -> new RuntimeException("Enrollment not found"));

        enrollment.setCode(enrollmentDTO.code());
        enrollment.setName(enrollmentDTO.name());
        enrollment.setEmail(enrollmentDTO.email());
        enrollment.setPassword(enrollmentDTO.password());
        enrollment.setDocument(enrollmentDTO.document());
        enrollment.setEnrollmentGroup(enrollmentDTO.enrollmentGroup());
        enrollment.setObservation(enrollmentDTO.observation());
        enrollmentRepository.save(enrollment);
        return true;
    }

    public boolean deleteEnrollment(Long id) {
        Enrollment enrollment = enrollmentRepository.findById(id).orElseThrow(
                        () -> new RuntimeException("Enrollment not found"));
        enrollmentRepository.delete(enrollment);
        return true;
    }

    public List<Enrollment> findAll() {
        return enrollmentRepository.findAll();
    }
}
