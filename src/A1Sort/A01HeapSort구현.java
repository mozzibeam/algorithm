package A1Sort;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

//트리탐색 + 재귀적 호출
public class A01HeapSort구현 {
    public static void main(String[] args) {
        int[] arr = {7,6,5,8,3,5,9,1,6};
//        완전이진트리 모든 노드의 개수를 2로 나누고 -1 하면 부모 노드의 인덱스만 얻을 수 있음
//        최초힙 구성 : n*log(n)
        for (int i = (arr.length/2)-1; i >= 0; i--) {
            heapify(arr, i, arr.length);    //참조할 전체 배열과, 부모노드를 매개변수로 전달
        }
//    루트노드와 최하위노드를 자리 chage해가면서 heapify재귀
        for (int i = arr.length-1; i >= 0; i--) {
//            0번째 index와 마지막 index의 자리 change
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, 0, i);
        }
        System.out.println(Arrays.toString(arr));

//        pq를 통한 정렬
        Queue<Integer> pq = new PriorityQueue<>(Arrays.asList(7,6,5,8,3,5,9,1,6));
        System.out.println(pq.poll());  //log(n)
        pq.add(6);  //log(n) 복잡도    //

    }


    static void heapify(int[] arr, int parent, int length) {
//        자식노드와의 비교 : 왼쪽자식노드(parent*2+1), 오른쪽자식노드(parent*2+2) 깊이가 내려갈수록 2배씩 커지기 때문
//        자식노드가 없는 경우가 : arr.length를 넘어가는 경우
        int left = parent * 2 + 1;
        int right = parent * 2 + 2;
        int smallest = parent;

        if (left < length && arr[smallest] > arr[left]) {
            smallest = left;
        }
        if (right < length && arr[smallest] > arr[right]) {
            smallest = right;
        }
        if (smallest != parent) {
            int temp = arr[parent];
            arr[parent] = arr[smallest];
            arr[smallest] = temp;

            heapify(arr, smallest, length);
        }

    }
}
