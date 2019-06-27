package wsy.db.pb;

import wsy.db.pb.domain.Student;

public class AppContext {

    private static Student nowStudent = null;

    public static Student getNowStudent() {
        return nowStudent;
    }

    public static void setNowStudent(Student nowStudent) {
        AppContext.nowStudent = nowStudent;
    }

    public static boolean isLogined() {
        return !(nowStudent == null);
    }

}
