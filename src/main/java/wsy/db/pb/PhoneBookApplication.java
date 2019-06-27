package wsy.db.pb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import wsy.db.pb.dao.SSMapper;
import wsy.db.pb.dao.StudentMapper;
import wsy.db.pb.domain.SS;
import wsy.db.pb.domain.Student;

import java.util.List;

/**
 * @author: dabibio
 * @create: 2019-06-27 00:18
 */
@SpringBootApplication
public class PhoneBookApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(PhoneBookApplication.class, args);
    }

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    SSMapper ssMapper;


    @Override
    public void run(String... args) throws Exception {
//        studentMapper.insert(new Student("1","1","1","1","1","1"));
//        studentMapper.insert(new Student("2","1","1","1","1","1"));
//        studentMapper.insert(new Student("3","1","1","1","1","1"));

//        ssMapper.insert(new SS("1","2"));
//        ssMapper.insert(new SS("1","3"));
//        ssMapper.insert(new SS("2","3"));

//       System.out.println(ssMapper.selectOne("1","3"));

//        List<Student> studentList= (List<Student>) studentMapper.selectBySno("1");
//
//        for(Student student:studentList)
//        {
//            System.out.println(student);
//        }
       // System.out.println(studentMapper.selectBySno("1"));
//        List<Student> studentList = studentMapper.selectBySname("1");
//        for(Student student: studentList)
//        {
//            System.out.println(student);
//        }

//
//        List<SS> ssList = ssMapper.list();
//        for (SS ss : ssList) {
//            System.out.println(ss);
//        }
//

    }
}
