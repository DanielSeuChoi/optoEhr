package health.data.optoehr.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import health.data.optoehr.models.Prescription;
import health.data.optoehr.models.Patient;

public interface PrescriptionRepository extends CrudRepository<Prescription, Long> {
    List<Prescription> findAll();

    List<Prescription> findBypatientRx(Patient patientRx);

    Optional<Prescription> findById(Long id);
}
