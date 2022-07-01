import java.util.ArrayList;
import java.util.List;

public class Division {

  public String name;
  public List<Doctor> doctors;

  Division(String name) {
    this.name = name;
    this.doctors = new ArrayList<Doctor>();

  }

  public void addDoctor(Doctor doctor) {
    this.doctors.add(doctor);
    System.out.println(doctor.getDoctorsName() + " has been successfully added to " + this.name + " division!");
  }

  @Override
  public String toString() {
    return this.name + ": " + this.doctors;
  }

}
