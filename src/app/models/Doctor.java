package app.models;

public class Doctor {
    private String id, name, educationalBkgrd, phone;

    public Doctor() {
    }
//TEST
    public Doctor(String id, String name, String educationalBkgrd, String phone) {
        this.id = id;
        this.name = name;
        this.educationalBkgrd = educationalBkgrd;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
        public String getEducationalBkgrd() {
        return educationalBkgrd;
    }

    public void setEducationalBkgrd(String educationalBkgrd) {
        this.educationalBkgrd = educationalBkgrd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
