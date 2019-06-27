package wsy.db.pb.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import wsy.db.pb.domain.Student;

import javax.swing.text.Style;
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

    List<Student> listCurFriends(@Param("mySno") String mysno);//查询当前用户的朋友

    Student selectBySno(String sno);

    List<Student> selectBySname(@Param("mySno") String mySno, @Param("sname") String sname);

    List<Student> selectByStel(@Param("mySno") String mySno, @Param("stel") String stel);

    List<Student> selectBySemail(@Param("mySno") String mySno, @Param("semail") String email);

    List<Student>  selectBySaddress(@Param("mySno") String mySno, @Param("saddress") String address);

    List<Student> selectByGender(@Param("mySno") String mySno, @Param("sgender") String sgender);

}
