package class_project;

import java.util.Date;

public class Staff {

    private String staffId, staffFname, staffLname, staffGender, staffPhone, staffAddress, staffEmail;

    public Staff(String staffId, String staffFname, String staffLname, String staffGender, String staffPhone, String staffAddress, String staffEmail) {
        this.staffId = staffId;
        this.staffFname = staffFname;
        this.staffLname = staffLname;
        this.staffGender = staffGender;
        this.staffPhone = staffPhone;
        this.staffAddress = staffAddress;
        this.staffEmail = staffEmail;
    }

    public String getStaffId() {
        return staffId;
    }

    public String getStaffFname() {
        return staffFname;
    }

    public String getStaffLname() {
        return staffLname;
    }

    public String getStaffGender() {
        return staffGender;
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public String getStaffAddress() {
        return staffAddress;
    }

    public String getStaffEmail() {
        return staffEmail;
    }
}
