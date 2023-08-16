package ssac.emp.iyb;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeMGR extends Employee{
    Scanner scanner = new Scanner(System.in);
    Map<String, Map<String, String>> db = new LinkedHashMap<>();
    Map<String, String> inDb;
    protected boolean runEMS = true;

    public EmployeeMGR() {
        super();
    }

    public void insert() {
        inDb = new LinkedHashMap<>();

        System.out.println("-등록-");
        System.out.print("이름을 입력해주세요: ");
        name = scanner.next();
        System.out.print("사번을 입력해주세요: ");
        sabun = scanner.next();
        System.out.print("번호를 입력해주세요: ");
        phone = scanner.next();
        System.out.print("주소를 입력해주세요 (ex. 양천구): ");
        addr = scanner.next();

        inDb.put("sabun", sabun);
        inDb.put("phone", phone);
        inDb.put("addr", addr);

        db.put(name, inDb);

        System.out.println("------------------------------");
        System.out.println(name + " 사원이 등록되었습니다. \n");
    }

    public void selectAll(){
        if (this.db.size() != 0) {
            System.out.println("-전체 사원 목록-");
            for (String name: this.db.keySet()){
                System.out.println(name);
            }
            System.out.println();
        } else {
            System.out.println("사원이 존재하지 않습니다.");
            System.out.println("프로그램을 종료합니다.");
            this.runEMS = false;

        }
    }

    public void select(String name) {
        inDb = this.db.get(name);

        System.out.println("------------------------------");
        System.out.println("-" + name + " 사원의 상세 내역-");
        System.out.println("사번: " + inDb.get("sabun"));
        System.out.println("번호: " + inDb.get("phone"));
        System.out.println("주소: " + inDb.get("addr"));
        System.out.println();
    }

    public void update(String name) {
        inDb = this.db.get(name);

        while (true) {
            System.out.println("1. 사번 2. 번호 3. 주소 4. 수정완료");
            System.out.print("수정할 내역의 번호를 입력해주세요(1~4): ");
            int modCode = scanner.nextInt();

            if (modCode == 1) {
                System.out.print("사번의 수정 내용을 입력해주세요: ");
                String modSabun = scanner.next();
                inDb.replace("sabun", modSabun);
            } else if (modCode == 2) {
                System.out.print("번호의 수정 내용을 입력해주세요: ");
                String modPhone = scanner.next();
                inDb.replace("phone", modPhone);
            } else if (modCode == 3) {
                System.out.print("주소의 수정 내용을 입력해주세요: ");
                String modAddr = scanner.next();
                inDb.replace("addr", modAddr);
            } else if (modCode == 4) {
                System.out.println(name+ " 사원의 수정이 완료되었습니다. \n");
                break;
            }
            System.out.println("------------------------------");
        }
    }

    public void delete(String name) {
        System.out.println(name + " 사원을 삭제 합니다. \n");
        this.db.remove(name);
    }

    public void search() {
        System.out.print("검색할 사원의 이름을 입력해주세요: ");
        String inputName = scanner.next();

        for (String name: this.db.keySet()) {
            if (name.equals(inputName)) {
                select(inputName);
                break;
            } else {
                System.out.println(inputName + " 사원이 목록에 존재하지 않습니다. \n");
            }
        }
    }

}
