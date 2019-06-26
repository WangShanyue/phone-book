package wsy.db.pb.domain;

/**
 * @author: dabibio
 * @create: 2019-06-27 00:20
 */
public class SS {

    private String mySno;
    private String friendSno;

    @Override
    public String toString() {
        return "SS{" +
                "mySno='" + mySno + '\'' +
                ", friendSno='" + friendSno + '\'' +
                '}';
    }

    public SS(String mySno, String friendSno) {
        this.mySno = mySno;
        this.friendSno = friendSno;
    }

    public String getMySno() {
        return mySno;
    }

    public void setMySno(String mySno) {
        this.mySno = mySno;
    }

    public String getFriendSno() {
        return friendSno;
    }

    public void setFriendSno(String friendSno) {
        this.friendSno = friendSno;
    }
}
