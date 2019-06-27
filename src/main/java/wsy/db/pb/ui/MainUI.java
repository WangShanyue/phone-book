package wsy.db.pb.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wsy.db.pb.AppContext;

import wsy.db.pb.domain.Student;
import wsy.db.pb.service.SSInfoService;
import wsy.db.pb.service.StudentInfoService;
import wsy.db.pb.vo.Response;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

@Component
public class MainUI {

    private  boolean    doneFlag =false;
    private Scanner sc = new Scanner(System.in);
    @Autowired
    private SSInfoService ssInfoService;

    @Autowired
    private StudentInfoService studentInfoService;

    @Autowired
  //  private PFService pfService;


    public void start() {
        while (!doneFlag) {
           home();
        }
    }

    private void home() {
        divideLine();
        if (AppContext.isLogined()) {
            loginHome();
        } else {
            unloginHome();
        }
    }
    private void unloginHome() {
        System.out.println("欢迎使用学生通讯录系统！");
        System.out.println("您可以：");
        System.out.println("1）登陆\n" +
                "2）注册\n" +
                "3）退出\n");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                login();
                break;
            case 2:
                register();
                break;
            case 3:
                bye();
                break;
            default:
                wrongChoice();
                break;
        }
    }

    private void loginHome() {
        Student nowStudent = AppContext.getNowStudent();
        System.out.println("您好！亲爱的" + nowStudent.getSname() );
        System.out.println("您可以：");
        System.out.println("1）查看所有朋友信息\n" +
                "2）搜索\n" +
                "3）添加新朋友\n" +
                "4）删除朋友\n" +
                "5）注销\n" +
                "6）退出\n");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                friendsInfo();
                break;
            case 2:
                findfriendInfo();
                break;
            case 3:
                addFriends();
                break;
            case 4:
                dropFriends();
                break;
            case 5:
                logout();
                break;
            case 6:
                bye();
                break;
            default:
                wrongChoice();
                break;
        }
    }

    private void addFriends() {
        System.out.println("请输入你要添加的朋友的学号：");
        String sno = sc.next();
        Response res=studentInfoService.find(1,sno);
        List<Student> lists= (List<Student>) res.getData();
        Student stu=lists.get(0);
        String sname,sgender,stel,semail,saddress;
        if(stu==null)
        {
            System.out.println("请输入你要添加的朋友的姓名：");
             sname = sc.next();
            System.out.println("请输入你要添加的朋友的性别：(男/女)");
             sgender = sc.next();
            System.out.println("请输入你要添加的朋友的电话号码：");
             stel = sc.next();
            System.out.println("请输入你要添加的朋友的邮箱");
             semail = sc.next();
            System.out.println("请输入你要添加的朋友的地址");
             saddress = sc.next();
            Response registerResponse = ssInfoService.add(1,new Student(sno, sname,sgender,stel,semail,saddress));
            System.out.println(registerResponse.getMessage());
        }
        else
        {
            System.out.println("搜索到信息如下：");
            System.out.println(stu);
            ssInfoService.add(0,stu);
            System.out.println("已将其添加到您的朋友中：");
        }

    }
    private void dropFriends() {
        System.out.println("请输入您要删除的朋友的学号：");
        String dropSno = sc.next();
        Response res=studentInfoService.find(1,dropSno);
        if(res==null) System.out.println("没有这个人");
        else{
            Response dropFriendResponse = ssInfoService.dropFriends(AppContext.getNowStudent().getSno(),dropSno);
            System.out.println("删除成功！");
        }
    }
    private void findfriendInfo() {
        System.out.println("选择您的查找方式：");
        System.out.println("1）按学号查找\n" +
                "2）按姓名查找\n" +
                "3）按性别查找\n" +
                "4）按电话号码查找\n" +
                "5）按邮件查找\n" +
                "6）按地址查找\n"+
                "7)您可能认识的人" );
          String[] pros = {"","学号","姓名","性别","电话号码","邮件","地址"};


        int choice = sc.nextInt();
        if(choice<1 || choice >7)
        {
            System.out.println("没有这个选项");
            return;
        }
        System.out.println("请输入您要查找的"+pros[choice]);
        String args = sc.next();
        List<Student> studentList = (List<Student>) studentInfoService.find(choice,args).getData();
        if(studentList==null) System.out.println("您还未添加朋友");
        else{
            for (Student eachStudent : studentList) {
                System.out.println(eachStudent);
            }
        }
    }



    private void friendsInfo() {
        System.out.println("以下是您的朋友信息：");
        Response listFriendResponse = ssInfoService.listFriends();
        List<Student> studentList = (List<Student>) listFriendResponse.getData();
        if(studentList==null) System.out.println("您还未添加朋友");
        else{
            for (Student eachStudent : studentList) {
                System.out.println(eachStudent);
            }
        }
    }



    private void login() {
        System.out.println("请输入学号和姓名！");
        System.out.println("学号：");
        String pno = sc.next();
        System.out.println("姓名：");
        String pname = sc.next();
        Response loginResponse = studentInfoService.login(pno, pname);
        System.out.println(loginResponse.getMessage());
    }

    private void register() {
        System.out.println("欢迎注册！");
        System.out.println("请输入您的学号：");
        String sno = sc.next();
        System.out.println("请输入您的姓名：");
        String sname = sc.next();
        System.out.println("请输入您的性别：(男/女)");
        String sgender = sc.next();
        System.out.println("请输入您的电话号码：");
        String stel = sc.next();
        System.out.println("请输入您的邮箱");
        String semail = sc.next();
        System.out.println("请输入您的地址");
        String saddress = sc.next();
        Response registerResponse = studentInfoService.register(new Student(sno, sname,sgender,stel,semail,saddress));
        System.out.println(registerResponse.getMessage());
    }

    private void bye() {
        studentInfoService.logout();
        doneFlag = true;
        System.out.println("您已退出系统！");
    }

    private void wrongChoice() {
        System.out.println("选项错误！");
    }


    private void logout() {
        //System.out.println("即将注销！");
        Response logoutResponse = studentInfoService.logout();
        System.out.println(logoutResponse.getMessage());
    }


    private void divideLine() {
        System.out.println("**********************************************");
    }

}
