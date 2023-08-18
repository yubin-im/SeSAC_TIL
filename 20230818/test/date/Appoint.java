package test.date;

public class Appoint extends Date{
    private String subject;

    public Appoint(int year, int month, int day, String subject) {
        super(year, month, day);
        this.subject = subject;

    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "[약속 정보]\n제목: " + subject + "\n시간: " + super.toString();
    }
}
