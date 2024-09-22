package student_ver4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class PersonList {
    private ArrayList<Student> studentList = new ArrayList<>();
    private ArrayList<Teacher> teacherList = new ArrayList<>();
    public Scanner scanner = new Scanner(System.in);
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public void addStudent() {
        try {
            System.out.println("Nhap ma student: ");
            String studentId = scanner.nextLine();
            System.out.println("Nhap name: ");
            String studentName = scanner.nextLine();
            System.out.println("Nhap ngay sinh (dd/MM/yyyy): ");
            Date dateOfBirth = dateFormat.parse(scanner.nextLine());
            System.out.println("Nhap GPA: ");
            float gpa = scanner.nextFloat();
            scanner.nextLine(); // Xóa dòng mới
            System.out.println("NHap chuyen nganh: ");
            String major = scanner.nextLine();
            studentList.add(new Student(studentId, studentName, dateOfBirth, gpa, major));
            System.out.println("Them hoc sinh thanh cong.");
        } catch (ParseException e) {
            System.out.println("Ngay khong hop le , vui long nhap lai.");
        }
    }

    public void addTeacher() {
        try {
            System.out.println("Nhap ma giao vien: ");
            String teacherId = scanner.nextLine();
            System.out.println("Nhap ten giao vien: ");
            String teacherName = scanner.nextLine();
            System.out.println("Nhap ngay sinh (dd/MM/yyyy): ");
            Date dateOfBirth = dateFormat.parse(scanner.nextLine());
            System.out.println("Nhap khoa: ");
            String department = scanner.nextLine();
            System.out.println("Nhap mon giang day: ");
            String subject = scanner.nextLine();
            teacherList.add(new Teacher(teacherId, teacherName, dateOfBirth, department, subject));
            System.out.println("Them giao vien thanh cong.");
        } catch (ParseException e) {
            System.out.println("ngay khong hop le,vui long nhap lai.");
        }
    }

    

    public void updatePerson() {
        System.out.println("Nhap ma nguoi can update: ");
        String id = scanner.nextLine();
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                System.out.println("Cap nhat thong tin hoc sinh.");
                updateStudent(student);
                return;
            }
        }
        for (Teacher teacher : teacherList) {
            if (teacher.getId().equals(id)) {
                System.out.println("Cap nhat thong tin giao vien.");
                updateTeacher(teacher);
                return;
            }
        }
        System.out.println("Khong tim thay nguoi voi ma id nay.");
    }
    private void updateStudent(Student student) {
        try {
            System.out.println("Nhap new name: ");
            String newName = scanner.nextLine();
            if (!newName.isEmpty()) student.setFullName(newName);
            
            System.out.println("Nhap new dateofbirth: ");
            String newDateOfBirth = scanner.nextLine();
            if (!newDateOfBirth.isEmpty()) {
                student.setDateOfBirth(dateFormat.parse(newDateOfBirth));
            }
            
            System.out.println("NHap new GPA: ");
            String gpaInput = scanner.nextLine();
            if (!gpaInput.isEmpty()) student.setGpa(Float.parseFloat(gpaInput));
            
            System.out.println("Nhap chuyen nganh moi: ");
            String newMajor = scanner.nextLine();
            if (!newMajor.isEmpty()) student.setMajor(newMajor);
            
            System.out.println("Cap nhat thong tin sinh vien thanh cong.");
        } catch (ParseException e) {
            System.out.println("Ngay khong hop le cap nhat that bai.");
        } catch (NumberFormatException e) {
            System.out.println("GPA khong hop le cap nhat that bai.");
        }
    }
    private void updateTeacher(Teacher teacher) {
        try {
            System.out.println("nhap new name teacher: ");
            String newName = scanner.nextLine();
            if (!newName.isEmpty()) teacher.setFullName(newName);
            
            System.out.println("nhap ngay sinh moi(dd/MM/yyyy): ");
            String newDateOfBirth = scanner.nextLine();
            if (!newDateOfBirth.isEmpty()) {
                teacher.setDateOfBirth(dateFormat.parse(newDateOfBirth));
            }
            
            System.out.println("Nhap khoa moi: ");
            String newDepartment = scanner.nextLine();
            if (!newDepartment.isEmpty()) teacher.setDepartment(newDepartment);
            
            System.out.println("Nhap mon giang day moi: ");
            String newSubject = scanner.nextLine();
            if (!newSubject.isEmpty()) teacher.setTeachingSubject(newSubject);
            
            System.out.println("Cap nhat thong tin thanh cong");
        } catch (ParseException e) {
            System.out.println("ngay khong hop le cap nhat that bai.");
        }
    }

    public void deletePerson() {
        System.out.println("Nhap ma nguoi can xoa: ");
        String id = scanner.nextLine();
        studentList.removeIf(student -> student.getId().equals(id));
        teacherList.removeIf(teacher -> teacher.getId().equals(id));
        System.out.println("Xoa thanh cong neu ton tai.");
    }

    public void displayEveryone() {
        System.out.println("Danh sach hoc sinh:");
        for (Student student : studentList) {
            student.displayInfo();
        }
        System.out.println("\nDanh sach giao vien:");
        for (Teacher teacher : teacherList) {
            teacher.displayInfo();
        }
    }

    public void findTopStudent() {
        if (studentList.isEmpty()) {
            System.out.println("Khong co hc sinh nao.");
            return;
        }
        Student topStudent = null;
        for (Student student : studentList) {
            if (topStudent == null || student.getGpa() > topStudent.getGpa()) {
                topStudent = student;
            }
        }
        System.out.println("Hoc sinh co GPA cao nhat:");
        topStudent.displayInfo();
    }

    public void findTeacherByDepartment() {
        System.out.println("Nhap ten khoa: ");
        String department = scanner.nextLine();
        for (Teacher teacher : teacherList) {
            if (teacher.getDepartment().equals(department)) {
                teacher.displayInfo();
                return;
            }
        }
        System.out.println("Khong co giao vien nao trong khoa nay.");
    }
}


