package fatec.ipiranga.p3crud.repository;

import fatec.ipiranga.p3crud.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findAllOrderByName(String name);
    Enrollment findByCode(String code);
}
