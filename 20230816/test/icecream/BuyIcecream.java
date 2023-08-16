package test.icecream;

// 20230816 실습
/* <pre>
편의점에서 아이스크림 구매하는 알고리즘 짜기
- Project: IcecreamProject
- package: test.icecream
- Main-class: BuyIcecream
- 내용
    - 아이스크림 심부름하기
    - 출연진: 나, 자바, 편의점 점원
    - 데이터: 1000원, “누가바”
    - 심부름 과정을 7~9줄로 서술하기
1. 자바야 왼손 줘→ 왼손에 1000원을 쥐어 준다.
2. 자바야 아이스크림 사와(”누가바”)라고 명령한다. (자바는 편의점을 찾아간다.)
3. 자바가 편의점에 들어간다.
4. 자바가 편의점 점원한테 아이스크림(”누가바”) 주세요라고 말한다. (편의점 점원은 아이스크림 매대에 간다.)
5. 편의점 점원은 “누가바”를 꺼내어 자바 오른손에 쥐어 준다. (자바는 집으로 돌아온다.)
6. 자바는 (나에게) 오른손에 있는 것을 준다.
7. 맛있게 먹는다.

1. left ← 1000;
2. buyIcecream(left);
3. Cu cu;
4. cu.getIcecream(left);
5. this.right = “누가바”;
6. return this.right;
7. right = 6번(4번) 과정의 return 값을 받는다.
8. sout(right);
</pre>
 */

public class BuyIcecream {
    public static void main(String[] args) {
        int left = 1000;
        String right = buyIcecream(left);

        System.out.println(right);
    }

    private static String buyIcecream(int left) {
        CU cu = new CU();

        String right = cu.getIcecream(left);
        return right;
    }

}
