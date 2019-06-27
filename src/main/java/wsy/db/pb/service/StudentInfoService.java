package wsy.db.pb.service;

import wsy.db.pb.domain.Student;
import wsy.db.pb.vo.Response;

public interface StudentInfoService {
    Response register (Student student);
    Response login (String sno,String name);
    Response logout();
    Response find(Integer num,String args);
}
