package health.data.optoehr.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import health.data.optoehr.models.Prescription;
import health.data.optoehr.models.Patient;
import health.data.optoehr.repositories.PrescriptionRepository;

@Service
public class PrescriptionService {
    @Autowired
    private PrescriptionRepository prescriptionRepo;

    public Prescription createRx(Prescription prescription) {
        return prescriptionRepo.save(prescription);
    }

    public List<Prescription> allRx() {
        return prescriptionRepo.findAll();
    }

    public List<Prescription> getPatientRx(Patient patientRx) {
        return prescriptionRepo.findBypatientRx(patientRx);
    }

    public Prescription getPatientRxs(Long id) {
        Optional<Prescription> optPrescription = prescriptionRepo.findById(id);
        if (optPrescription.isPresent()) {
            return optPrescription.get();
        }
        return null;
    }

}
