package app.models;

public class Patient {
    private String kd, name, age, addr, job, gender, phone, phoneFr, marital;

    public Patient() {
    }

    public Patient(String kd, String name, String age, String addr, String job, String gender, String phone,
                   String phoneFr, String marital) {
        this.kd = kd;
        this.name = name;
        this.age = age;
        this.addr = addr;
        this.job = job;
        this.gender = gender;
        this.phone = phone;
        this.phoneFr = phoneFr;
        this.marital = marital;
    }

    public String getKd() {
        return kd;
    }

    public void setKd(String kd) {
        this.kd = kd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoneFr() {
        return phoneFr;
    }

    public void setPhoneFr(String phoneFr) {
        this.phoneFr = phoneFr;
    }

    public String getMarital() {
        return marital;
    }

    public void setMarital(String marital) {
        this.marital = marital;
    }
}
