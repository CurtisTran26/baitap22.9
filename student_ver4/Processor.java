package student_ver4;

public class Processor {
    public static void main(String[] args) {
        PersonList personList = new PersonList();

        while (true) {
            System.out.println("1. Them hoc sinh moi");
            System.out.println("2. Them giao vien moi");
            System.out.println("3. Cap nhat thong tin theo ID");
            System.out.println("4. Xoa nguoi theo ID");
            System.out.println("5. Hien thi all");
            System.out.println("6. Tim hoc sinh co GPA cao nhat");
            System.out.println("7. Tim giao vien theo khoa");
            System.out.println("8. exit");

            int option = personList.scanner.nextInt();
            personList.scanner.nextLine(); // Xóa dòng mới sau khi nhập số

            switch (option) {
                case 1:
                    personList.addStudent();
                    break;
                case 2:
                    personList.addTeacher();
                    break;
                case 3:
                    personList.updatePerson();
                    break;
                case 4:
                    personList.deletePerson();
                    break;
                case 5:
                    personList.displayEveryone();
                    break;
                case 6:
                    personList.findTopStudent();
                    break;
                case 7:
                    personList.findTeacherByDepartment();
                    break;
                case 8:
                    System.out.println("Chuong trinh ket thuc.");
                    return;
                default:
                    System.out.println("Lua chon khong hop le ,vui long chon lai.");
            }
        }
    }
}
