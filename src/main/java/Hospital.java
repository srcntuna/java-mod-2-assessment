import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hospital {

  public String name;
  public List<Division> divisions;
  public int currPatientId;

  Hospital(String name) {
    this.name = name;
    this.currPatientId = 1;
    this.divisions = new ArrayList<Division>();

    var radiology = new Division("Radiology");
    var dermatology = new Division("Dermatology");
    var cardiology = new Division("Cardiology");

    this.divisions.add(radiology);
    this.divisions.add(dermatology);
    this.divisions.add(cardiology);

  }

  public void addDoc(String doctorsName, String divisionsName) {

    for (Division division : divisions) {
      if (division.name.equals(divisionsName)) {
        var newDoctor = new Doctor(doctorsName, divisionsName);
        division.addDoctor(newDoctor);
        return;
      }
    }

    System.out.println("Sorry but that kind of department does not exist in this hospital!");

  }

  public void addPatient(String patientName, String specialityNeeded) {

    for (Division division : this.divisions) {

      if (division.name.equals(specialityNeeded)) {
        var newPatient = new Patient(patientName, specialityNeeded, this.currPatientId);

        Random rand = new Random();
        Doctor randomDoctor = division.doctors.get(rand.nextInt(division.doctors.size()));
        randomDoctor.addPatient(newPatient);
        System.out.println(patientName + " has been assigned to Doctor " + randomDoctor.getDoctorsName() + " from "
            + randomDoctor.getSpeciality() + " division.");

        this.currPatientId++;
        return;

      }

    }

    System.out.println("Sorry but that kind of department does not exist in this hospital!");

  }

  @Override
  public String toString() {
    return this.name + ": " + this.divisions;
  }

}
