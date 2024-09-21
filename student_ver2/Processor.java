package student_ver2;

import java.util.Scanner;

public class Processor {

    public static void main(String[] args) {
        StudentList studentList = new StudentList();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("=== Student Management System ===");
            System.out.println("1. Them sinh vien moi");
            System.out.println("2. Cap nhat sinh vien bang ID");
            System.out.println("3. Xoa sinh vien bang ID");
            System.out.println("4. Hien thi tat ca sinh vien");
            System.out.println("5. Tim sinh vien co GPA cao nhat");
            System.out.println("6. Tim sinh vien co hoc bong");
            System.out.println("7. Tinh tong hoc phi cua tat ca sinh vien");
            System.out.println("0. Exit");
            System.out.print("Nhap lua chon cua ban: ");
            
            while (!scanner.hasNextInt()) {
                System.out.println("Vui long nhap mot so!");
                scanner.next(); // Clear invalid input
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng trống sau khi nhập số

            switch (choice) {
                case 1:
                    studentList.addStudent();
                    break;

                case 2:
                    System.out.print("Nhap ID sinh vien can cap nhat: ");
                    String updateId = scanner.nextLine();
                    Student updateStudent = studentList.findStudentById(updateId);
                    if (updateStudent != null) {
                        System.out.print("Nhap ten moi: ");
                        String newName = scanner.nextLine();
                        updateStudent.setFullName(newName);

                        float newGpa = -1;
                        while (newGpa < 0) {
                            System.out.print("Nhap GPA moi: ");
                            newGpa = scanner.nextFloat();
                            if (newGpa < 0) {
                                System.out.println("GPA khong the am. Vui long nhap lai.");
                            }
                        }
                        updateStudent.setGpa(newGpa);

                        System.out.print("Nhap nganh hoc moi: ");
                        scanner.nextLine(); // Đọc bỏ dòng trống
                        String newMajor = scanner.nextLine();
                        updateStudent.setMajor(newMajor);
                        System.out.println("Cap nhat sinh vien thanh cong!");
                    } else {
                        System.out.println("Khong tim thay sinh vien voi ID nay.");
                    }
                    break;

                case 3:
                    System.out.print("Nhap ID sinh vien can xoa: ");
                    String deleteId = scanner.nextLine();
                    studentList.deleteStudentById(deleteId);
                    break;

                case 4:
                    System.out.println("Danh sach sinh vien:");
                    studentList.displayAllStudents();
                    break;

                case 5:
                    Student topStudent = studentList.findTopStudent();
                    if (topStudent != null) {
                        System.out.println("Sinh vien co GPA cao nhat:");
                        topStudent.displayInfo();
                    } else {
                        System.out.println("Danh sach sinh vien rong.");
                    }
                    break;

                case 6:
                    System.out.println("Sinh vien co hoc bong:");
                    for (Student scholarshipStudent : studentList.findScholarshipStudents()) {
                        scholarshipStudent.displayInfo();
                    }
                    break;

                case 7:
                    double totalTuition = studentList.calculateTuitionOfAllStudents();
                    System.out.println("Tong hoc phi cua tat ca sinh vien: " + totalTuition);
                    break;

                case 0:
                    System.out.println("Thoat chuong trinh.");
                    break;

                default:
                    System.out.println("Lua chon khong hop le, vui long thu lai.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
