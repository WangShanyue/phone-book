package wsy.db.pb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wsy.db.pb.AppContext;
import wsy.db.pb.dao.StudentMapper;
import wsy.db.pb.domain.Student;
import wsy.db.pb.service.StudentInfoService;
import wsy.db.pb.vo.Response;

import java.awt.geom.RectangularShape;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentIndoServiceImpl implements StudentInfoService {
    @Autowired
    StudentMapper studentMapper;

    @Override
    public Response register(Student student) {
        Student person1 = studentMapper.selectBySno(student.getSno());

        if (person1 != null) {
            return Response.failed("学生已经存在！");
        } else {
            studentMapper.insert(student);
            return Response.success("注册成功！");
        }
    }

    @Override
    public Response login(String sno, String name) {
        Student student = studentMapper.selectBySno(sno);
        System.out.println(sno+name+student);
        if (student != null && student.getSname().equals(name)) {
            AppContext.setNowStudent(student);
            return Response.success("登陆成功！");
        } else {
            return Response.failed("登陆失败！");
        }
    }

    @Override
    public Response logout() {
        Student nowStudent = AppContext.getNowStudent();
        if (nowStudent != null) {
            AppContext.setNowStudent(null);
        }
        return Response.success("注销成功！");
    }

    @Override
    public Response find(Integer choice, String args) {


        switch (choice){
            case 1://sno
                Student student = studentMapper.selectBySno(args);
                List<Student> List_sno = new ArrayList<Student>();
                List_sno.add(student);
                return Response.success(List_sno);

            case 2://name
                List<Student> studentList_name = studentMapper.selectBySname(AppContext.getNowStudent().getSno(),args);
                return  Response.success(studentList_name);

            case 3://gender
                List<Student> studentList_gender = studentMapper.selectByGender(AppContext.getNowStudent().getSno(),args);
                return Response.success(studentList_gender);

            case 4://tel
                List<Student> studentList_tel = studentMapper.selectByStel(AppContext.getNowStudent().getSno(),args);
                return Response.success(studentList_tel);
            case  5:
                List<Student> studentList_email = studentMapper.selectBySemail(AppContext.getNowStudent().getSno(),args);
                return Response.success(studentList_email);
            case  6:
                List<Student> studentList_address = studentMapper.selectBySaddress(AppContext.getNowStudent().getSno(),args);
                return Response.success(studentList_address);
            case  7:
                List<Student> studentList_someone = studentMapper.list();
                int len=studentList_someone.size();
                return Response.success(studentList_someone);
            default:
                return Response.failed("没有此选项");
        }
    }


}
