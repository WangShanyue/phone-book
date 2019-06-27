package wsy.db.pb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wsy.db.pb.AppContext;
import wsy.db.pb.dao.SSMapper;
import wsy.db.pb.dao.StudentMapper;
import wsy.db.pb.domain.SS;
import wsy.db.pb.domain.Student;
import wsy.db.pb.service.SSInfoService;
import wsy.db.pb.vo.Response;

import javax.swing.text.Style;
import java.util.List;

@Service
public class SSInfoServiceImpl implements SSInfoService {
    @Autowired
    private SSMapper ssMapper;

    @Autowired
    private StudentMapper studentMapper;


    @Override
    public Response add(int choice ,Student student) {
        SS ss = new SS(AppContext.getNowStudent().getSno(),student.getSno());

        SS ss2 = ssMapper.selectOne(ss.getMySno(),ss.getFriendSno());
        if(choice==1)//没在学生表中
        {
            studentMapper.insert(student);
            ssMapper.insert(ss);
            return  Response.success("添加成功！");
        }
        if(ss2!=null)
        {
            return Response.failed("您的列表中已经有这个朋友");
        }
        else {
            ssMapper.insert(ss);
            return  Response.success("添加成功！");
        }

    }

    @Override
    public Response listFriends() {
        List<Student> flist = studentMapper.listCurFriends(AppContext.getNowStudent().getSno());
        return Response.success(flist);
    }

    @Override
    public Response dropFriends(String sno, String sno2) {
        Integer del = ssMapper.delete(new SS(sno, sno2));
        return  Response.success(del);
    }

}
