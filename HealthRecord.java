import java.util.*;

class Patient {
    private int id;
    private String name;
    private Date dob;
    private String gender;
    private List<MedicalRecord> medicalHistory;

    public Patient(int id, String name, Date dob, String gender) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.medicalHistory = new ArrayList<>();
    }

    // Getters and setters for patient attributes

    public void addMedicalRecord(MedicalRecord record) {
        medicalHistory.add(record);
    }
}

class MedicalRecord {
    private Date date;
    private String diagnosis;
    private String treatment;
    private String medication;

    public MedicalRecord(Date date, String diagnosis, String treatment, String medication) {
        this.date = date;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.medication = medication;
    }

    // Getters and setters for medical record attributes
}

public class EHRManagementSystem {
    private List<Patient> patients;

    public EHRManagementSystem() {
        patients = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void addMedicalRecordToPatient(int patientId, MedicalRecord record) {
        Patient patient = findPatientById(patientId);
        if (patient != null) {
            patient.addMedicalRecord(record);
        } else {
            System.out.println("Patient not found.");
        }
    }

    public Patient findPatientById(int patientId) {
        for (Patient patient : patients) {
            if (patient.getId() == patientId) {
                return patient;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        EHRManagementSystem system = new EHRManagementSystem();

        // Create patients
        Patient patient1 = new Patient(1, "John Doe", new Date(), "Male");
        Patient patient2 = new Patient(2, "Jane Smith", new Date(), "Female");

        // Add patients to the system
        system.addPatient(patient1);
        system.addPatient(patient2);

        // Add medical records to patients
        MedicalRecord record1 = new MedicalRecord(new Date(), "Fever", "Rest", "Paracetamol");
        system.addMedicalRecordToPatient(1, record1);

        // Find a patient and display their medical history
        Patient foundPatient = system.findPatientById(1);
        if (foundPatient != null) {
            List<MedicalRecord> medicalHistory = foundPatient.getMedicalHistory();
            for (MedicalRecord record : medicalHistory) {
                System.out.println("Diagnosis: " + record.getDiagnosis());
                System.out.println("Treatment: " + record.getTreatment());
                System.out.println("Medication: " + record.getMedication());
                System.out.println("Date: " + record.getDate());
                System.out.println();
            }
        }
    }
}
