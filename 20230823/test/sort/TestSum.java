package test.sort;
// 20230822 ½Ç½À
public class TestSum {
    int i = 0;
    int sum = 0;

    public static void main(String[] args) {
        testSum(100);
    }

    private static void testSum(int n) {
        int sum = 0;

        //for (int i = 1; i <= n; i++) {
        //    sum += i;
        //}

        System.out.print(n + " => ");
        while (n > 0) {
            sum = reCall(sum, n--);  // 0 + reCall(100); +100; sum = 100
                                        // +99; sum = 199
                                        // +1; sum = 5049
        }
        System.out.println(sum);
    }

    private static int reCall(int sum, int n) {
        int result = sum + n;
        // result = reCall(result, --n);
        return result;
        //return (n>0) ? reCall(result, --n) : result;
    }

}
