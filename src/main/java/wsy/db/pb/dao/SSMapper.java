package wsy.db.pb.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import wsy.db.pb.domain.SS;
import wsy.db.pb.domain.Student;

import java.util.List;

/**
 * @author: dabibio
 * @create: 2019-06-27 00:25
 */
@Mapper
@Component
public interface SSMapper {

    Integer insert(SS ss);

    List<Student> list();

    Integer delete(SS ss);

    SS selectOne(@Param("mySno") String mySno, @Param("friendSno") String friendSno);


}
