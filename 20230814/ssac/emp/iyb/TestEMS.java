package ssac.emp.iyb;

// 프로그램 내용
// 등록, 목록, 상세, 수정, 삭제, 검색

import java.util.Scanner;

public class TestEMS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeMGR emgr = new EmployeeMGR();

        System.out.println("EMS(Employee Management System) 프로그램을 실행합니다.");
        while (true) {
            System.out.println("1.목록 2.등록 3.검색 4.종료");
            System.out.print("실행할 기능의 번호를 입력해주세요(1~4): ");
            int runCode1 = scanner.nextInt();
            System.out.println("------------------------------");

            if (runCode1 == 1) {
                emgr.selectAll();
                if (emgr.runEMS == false) {
                    break;
                }

                System.out.print("상세 내용을 확인할 이름을 입력해주세요: ");
                String name = scanner.next();
                emgr.select(name);

                System.out.println("1.수정 2.삭제");
                System.out.print("실행할 기능의 번호를 입력해주세요(1~2): ");
                int runCode2 = scanner.nextInt();
                System.out.println("------------------------------");

                if (runCode2 == 1) {
                    emgr.update(name);
                } else if (runCode2 == 2) {
                    emgr.delete(name);
                }

            } else if (runCode1 == 2) {
                emgr.insert();

            } else if (runCode1 == 3) {
                emgr.search();

            } else if (runCode1 == 4) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }


    }
}
