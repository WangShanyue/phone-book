package wsy.db.pb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import wsy.db.pb.dao.SSMapper;
import wsy.db.pb.dao.StudentMapper;
import wsy.db.pb.domain.SS;

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
        ssMapper.delete(new SS("1", "2"));
        List<SS> ssList = ssMapper.list();
        for (SS ss : ssList) {
            System.out.println(ss);
        }
    }
}
