package health.data.optoehr.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import health.data.optoehr.models.Patient;
import health.data.optoehr.repositories.PatientRepository;
import health.data.optoehr.models.Prescription;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepo;

    public Patient createPatient(Patient patient) {
        return patientRepo.save(patient);
    }

    public List<Patient> allPatients() {
        return patientRepo.findAll();
    }

    public List<Patient> findByFirstName(String firstnam) {
        return patientRepo.findByFirstNameContains(firstnam);
    }

    public Patient getOnePatient(Long id) {
        Optional<Patient> optPatient = patientRepo.findById(id);
        if (optPatient.isPresent()) {
            return optPatient.get();
        }
        return null;
    }

    public List<Patient> getPatientsRx(Prescription prescription) {
        return patientRepo.findAllByPrescriptions(prescription);
    }

}
