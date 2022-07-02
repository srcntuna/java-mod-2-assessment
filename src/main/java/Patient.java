public class Patient {

  private String name;
  private String specialityNeeded;
  private int patientId;

  Patient(String name, String specialityNeeded, int patientId) {

    this.name = name;
    this.specialityNeeded = specialityNeeded;
    this.patientId = patientId;
  }

  String getPatientsName() {
    return name;
  }

  String getSpecialityNeeded() {
    return specialityNeeded;
  }

  int getPatientsID() {
    return patientId;
  }

  @Override
  public String toString() {
    return "Patient: " + this.name;
  }

}
