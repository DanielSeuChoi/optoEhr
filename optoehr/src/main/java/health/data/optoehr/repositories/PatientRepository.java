package health.data.optoehr.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import health.data.optoehr.models.Patient;
import health.data.optoehr.models.Prescription;

public interface PatientRepository extends CrudRepository<Patient, Long> {
    List<Patient> findAll();

    List<Patient> findByFirstNameContains(String phrase);

    List<Patient> findAllByPrescriptions(Prescription prescription);

    Optional<Patient> findById(Long id);
}
