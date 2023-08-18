package test.date;

// 20230817 실습
/*
- Project: DateProject
- package: test.date
- Main_class: TestDate
- 내용: 일정관리 프로그램을 위한 날짜를 표현하기 위한 클래스 만들기, 날짜는 연월일(y, m, d)의 값으로 표현

1. int y, m, d;
2. date 의미
3. data type 생성: class Date (1번 데이터 포함)
4. 사용
5. today
6. today.m = 1;
7. 디버깅
 */

public class TestDate {
    public static void main(String[] args) {
        int y, m, d;
        y = 2023;
        m = 8;
        d = 17;
        System.out.println(y + "-" + m + "-" + d);

        Date today = new Date(2023, 8, 17);
        // toString() 오버라이드 해야 주소값이 출력안되고 문자열이 출력된다.
        System.out.println(today);

        // 월의 범위: 1 ~ 12
        today.setMonth(-1);
        today.setDay(150);
        today.setMonth(2);
        today.print();

        // 윤년 확인 (ex. 1988, 2400 ...)
        today.setYear(1988);
        today.setMonth(2);
        today.setDay(30);
        today.print();

        Appoint appoint = new Appoint(2023, 8, 19, "점심약속");
        appoint.print();


//        // equals() 필요성
//        Date today2 = new Date(2023, 8, 17);
//        System.out.println(
//                (today == today2) ? "same" : "not same");
//        // equals() 오버라이드를 해야지 same이 출력된다.
//        System.out.println(
//                (today.equals(today2) ? "same" : "not same")
//        );

    }
}
