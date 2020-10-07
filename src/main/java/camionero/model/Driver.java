package camionero.model;

import java.time.LocalDate;

public class Driver {

    public enum License{
        LIGHT(2),
        MEDIUM(3),
        HEAVY(6);

        int truckWeight;

        License(int truckWeight) {
            this.truckWeight = truckWeight;
        }

        public int getTruckWeight() {
            return truckWeight;
        }
    }

    private final int dni;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private License licenseCategory;
    private String cellphone;

    public Driver(int dni) {
        this.dni = dni;
    }

    public int getDni() {
        return dni;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        //if (birthDate == null) this.birthDate = new LocalDate(1970,1,1);
         this.birthDate = birthDate;
    }

    public License getLicenseCategory() {
        return licenseCategory;
    }

    public void setLicenseCategory(String licenseCategory) {
        this.licenseCategory = License.valueOf(licenseCategory);
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }
}
