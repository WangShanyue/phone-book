package wsy.db.pb.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import wsy.db.pb.domain.Student;

import java.util.List;

/**
 * @author: dabibio
 * @create: 2019-06-27 00:25
 */

@Mapper
@Component
public interface StudentMapper {

    Integer insert(Student student);

    List<Student> list();

    Student selectBySno(String sno);

}
