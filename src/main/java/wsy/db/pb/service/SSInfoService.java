package wsy.db.pb.service;

import wsy.db.pb.domain.Student;
import wsy.db.pb.vo.Response;

public interface SSInfoService {
    Response add(int flag,Student student);

    Response listFriends();


    Response dropFriends(String sno1, String sno2);
}
