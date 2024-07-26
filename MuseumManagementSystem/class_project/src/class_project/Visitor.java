package class_project;


public class Visitor {

    private String visitorId, visitorFname, visitorLname, visitorGender, visitorPhone, visitorEmail, visitorVisitDate,VisitorPayment;

    public Visitor(String visitorId, String visitorFname, String visitorLname, String visitorGender, String visitorPhone, String visitorEmail, String visitorVisitDate,String VisitorPayment) {
        this.visitorId = visitorId;
        this.visitorFname = visitorFname;
        this.visitorLname = visitorLname;
        this.visitorGender = visitorGender;
        this.visitorPhone = visitorPhone;
        this.visitorEmail = visitorEmail;
        this.visitorVisitDate = visitorVisitDate;
        this.VisitorPayment = VisitorPayment;
    }

    public String getVisitorId() {
        return visitorId;
    }

    public String getVisitorFname() {
        return visitorFname;
    }

    public String getVisitorLname() {
        return visitorLname;
    }

    public String getVisitorGender() {
        return visitorGender;
    }

    public String getVisitorPhone() {
        return visitorPhone;
    }

    public String getVisitorEmail() {
        return visitorEmail;
    }

    public String getVisitorVisitDate() {
        return visitorVisitDate;
    }
    
    public String getVisitorPayment(){
        return VisitorPayment;
    }
}
