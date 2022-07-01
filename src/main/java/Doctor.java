import java.util.ArrayList;

public class Doctor {

  private String name;
  private String speciality;
  private ArrayList<Patient> patients;

  Doctor(String name, String speciality) {
    this.name = name;
    this.speciality = speciality;
    this.patients = new ArrayList<Patient>();

  }

  void addPatient(Patient patient) {
    this.patients.add(patient);
  }

  String getDoctorsName() {
    return this.name;
  }

  String getSpeciality() {
    return this.speciality;
  }

  ArrayList<Patient> getPatiensList() {

    return this.patients;

  }

  @Override
  public String toString() {
    return "Doctor-" + this.name + ": " + this.patients;
  }

}