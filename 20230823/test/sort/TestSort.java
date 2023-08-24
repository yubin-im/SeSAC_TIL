package test.sort;
// 20230822 실습
// 정렬 알고리즘
import java.util.ArrayList;

public class TestSort {
    private static ArrayList<Integer> data;
    private static ArrayList<Integer>[] queue = new ArrayList[10];
    // static initializer(클래스 초기화)
    static {
        for(int i = 0; i < 10; i++){
            queue[i] = new ArrayList();
        }
    }

    public static void main(String[] args) {
        data = new ArrayList<Integer>();

        data.add(3);
        data.add(8);
        data.add(65);
        data.add(68);
        data.add(53);
        data.add(100);
        data.add(48);
        data.add(25);
        data.add(86);
        data.add(4);

        System.out.println("정렬 전:: " + data);
        //insertSort(data, data.size());
        //bubbleSort(data, data.size());
        //mergeSort(data, data.size());
        //quickSort(data, data.size());
        radixSort(data, data.size());
        System.out.println("정렬 후:: " + data);
    }


    // 삽입 정렬 알고리즘
    private static void insertSort(ArrayList<Integer> data, int size){
        int key = 0;
        int i = 0;
        int j = 0;

        for(i = 1; i < data.size(); i++) {  // 전체 데이터를 순차적으로 접근(0번 인덱스는 비교할 대상이 없으므로 1번부터)
            key = data.get(i);  // 데이터를 가져온다.

            for(j = i-1; j >= 0; j--) {  // i 번째의 값과 그 앞자리의 값을 비교하면서 선택 정렬 수행
                if(data.get(j) > key) {
                    data.set(j+1, data.get(j));  // replace 기능
                } else {
                    break;
                }
            }
            data.set(j+1, key);
        }
    }


    // 버블 정렬 알고리즘
    private static void bubbleSort(ArrayList<Integer> data, int size) {
        int temp = 0;
        int i = 0;
        int j = 0;

        for (i = 1; i < data.size() - 1; i++) {
            for (j = 0; j < data.size() - 1 - i; j++) {
                if (data.get(j) > data.get(j + 1)) {
                    temp = data.get(j);
                    data.set(j, data.get(j + 1));
                    data.set(j + 1, temp);

                }
            }
        }
    }


    // 병합 정렬 알고리즘
    private static ArrayList<Integer> newData;

    private static void mergeSort(ArrayList<Integer> data, int size){
        partition(0, size-1);  // 전체 데이터를 2개로 나누고 병합 정렬 수행
    }

    private static void partition(int left, int right){
        if (left < right) {
            int mid = (left + right) / 2;  // 전체 데이터를 2개로 나누기 위해 중간 값을 선정
            partition(left, mid);  // 앞 부분을 다시 2개로 나눈다. (재귀호출로 나눌 수 없을 때까지 나눈다.)
            partition(mid + 1, right);  // 뒷 부분을 다시 2개로 나눈다. (재귀호출로 나눌 수 없을 때까지 나눈다.)
            merge(left, right);  // 정렬
        }
    }

    private static void merge(int left, int right){
        newData = new ArrayList<Integer>(data);  // 복사의 개념이 아니고 크기를 같게 만들기위함.

        // 절반짜리 arr을 newData에 복사
        for (int i = left; i <= right; i++) {
            newData.add(data.get(i));
        }

        int mid = (left + right) / 2;

        int tempLeft = left;
        int tempRight = mid+1;
        int curIndex = left;

        //newData를 순환하여 왼쪽 절반과 오른쪽 절반 비교해서 더 작은 값을 data에 복사
        while (tempLeft <= mid && tempRight <= right) {  // left와 right를 비교해서 순서를 바꿔주는 작업
            if (newData.get(tempLeft) <= newData.get(tempRight)) {
                data.set(curIndex++, newData.get(tempLeft++));
            } else {
                data.set(curIndex++, newData.get(tempRight++));
            }
        }

        //왼쪽 절반에 남은 원소들을 원래 배열에 복사
        int remain = mid - tempLeft;
        for (int i = 0; i <= remain; i++) {  // newData에 있는 앞자리 값을 원본 데이터 data에 복사해 넣는 작업
            data.set(curIndex + i, newData.get(tempLeft + i));
        }
    }


    // 퀵 정렬 알고리즘
    private static void quickSort(ArrayList<Integer> data, int size){
        quick(0, size - 1);
    }

    private static void quick(int left, int right) {
        if (left < right) {
            int p = partitionQuick(left, right);  // 피봇 값의 최종 위치 확정

            quick(left, p-1);  // 피봇 기준 왼쪽 다시 정렬
            quick(p+1, right);  // 피봇 기준 오른쪽 다시 정렬
        }
    }

    private static int partitionQuick(int left, int right){
        int pivot = data.get(right);  // 맨 마지막 값을 피봇으로 선정
        int i = left - 1;

        for(int j = left; j <= right - 1; j++){  // right-1은 피벗을 제외한 마지막 값의 위치
            if(data.get(j) <= pivot) {  // 배열 순회하며 피봇이랑 같거나 작은 값 탐방
                i++;  // i 인덱스 위치와 교체
                Swap(data, i, j);
            }
        }
        // partition 구분 종료 후 pivot의 값을 최종 위치(i+1)값과 교체
        Swap(data, i+1, right);
        return i + 1;
    }

    private static void Swap(ArrayList<Integer> data, int a, int b){
        int temp = data.get(a);
        data.set(a, data.get(b));
        data.set(b, temp);
    }


    // 기수 정렬 알고리즘
    // queue: 0~9, 총 10개(배열)의 queue(ArrayList)로 구성된 전체 데이터
    private static void radixSort(ArrayList<Integer> data, int length) {
        int radix = 1; boolean flag = false;
        while (true) {
            for(int i=0; i < data.size(); i++) {
                if (radix < data.get(i)) flag=true;
                else flag=false;

            }
            if(flag) radix *= 10; // 처음부터
            else break;
            // 더이상 radix보다 큰 값이 없으면 while을 빠져 나감.
        }

        System.out.println("총radix ::"+radix);
        for(int i=1; i <= radix; i*=10) {
            for(int j=0; j< length; j++) {
                int k;
                if(data.get(j)<i) {
                    k=0;
                }else {
                    k = (data.get(j)/i) % 10;

                }
                queue[k].add(data.get(j));


            }
            for(ArrayList q : queue) {
                System.out.println("radix["+i+"]::"+q);
            }
            int idx=0;
            for(int j=0; j< 10; j++) {
                while (queue[j].size() != 0) { // 고쳐보세요.. (for-each문으로 가능)
                    data.set(idx, queue[j].remove(0));
                    idx++;

                }
            }


        }


    }

}

