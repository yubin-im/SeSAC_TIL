package test.date;

import java.util.Objects;

public class Date {
    private int year;
    private int month;
    private int day;
    private int[] lastDayOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return year == date.year && month == date.month && day == date.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }

    public void print(){
        System.out.println(this);
    }

    public int getMonth() {
        return month;
    }

    // month는 개월을 뜻함, 1~12의 값을 갖는다.
    // 그 외의 값이 들어오면 1보다 작은 값일 경우 1로, 12보다 큰 값일 경우 12로 대체
    public void setMonth(int month) {
        if (month < 1) {
            month = 1;
        } else if (month > 12) {
            month = 12;
        }
        this.month = month;
        setDay(this.day);
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (day < 1) {
            day = 1;
        } else if (day > lastDayOfMonth[month-1]) {
            day = lastDayOfMonth[month-1];
        }
        this.day = day;
        checkLeapYear();
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
        checkLeapYear();
    }

    // 윤년 계산
    private void checkLeapYear() {
//        if (this.month == 2) {
//            if (this.year % 4 == 0 && this.year % 100 != 0) {
//                this.day = 29;
//            } else if (this.year % 4 == 0 && this.year % 100 != 0 && this.year % 400 == 0) {
//                this.day = 29;
//            }
//        }

        int day = 28;
        if (this.year % 4 == 0) {
            this.day = 29;
            if (this.year % 100 == 0) {
                this.day = 28;
                if (this.year % 400 == 0) {
                    this.day = 29;
                }
            }
        }
    }

}
