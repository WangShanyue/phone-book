package wsy.db.pb.domain;

/**
 * @author: dabibio
 * @create: 2019-06-27 00:18
 */
public class Student {

    private String sno;
    private String sname;
    private String sgender;
    private String stel;
    private String semail;
    private String saddress;

    @Override
    public String toString() {
        return "Student{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", sgender='" + sgender + '\'' +
                ", stel='" + stel + '\'' +
                ", semail='" + semail + '\'' +
                ", saddress='" + saddress + '\'' +
                '}';
    }

    public Student(String sno, String sname, String sgender, String stel, String semail, String saddress) {
        this.sno = sno;
        this.sname = sname;
        this.sgender = sgender;
        this.stel = stel;
        this.semail = semail;
        this.saddress = saddress;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSgender() {
        return sgender;
    }

    public void setSgender(String sgender) {
        this.sgender = sgender;
    }

    public String getStel() {
        return stel;
    }

    public void setStel(String stel) {
        this.stel = stel;
    }

    public String getSemail() {
        return semail;
    }

    public void setSemail(String semail) {
        this.semail = semail;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }
}
