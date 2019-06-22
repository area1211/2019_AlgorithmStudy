package datastructure.cache;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

// TODO: 2019-06-22  
public class LRUCache {

    // 캐시의 키를 저장한다.
    // 가장 최근에 참조한 값 순서대로 큐에 저장한다.
    // 큐의 양 끝에서 값을 참조/삭제 하기 위해서 Deque 를 쓴다.
    static Deque<Integer> dq;
    // 캐시 키의 참조를 저장한다.
    // 키의 참조를 O(1) 시간으로 확인하기 위해서 Set 형태의 자료구조를 쓴다.
    static HashSet<Integer> map;
    static int cacheSize;

    LRUCache(int n) {
        dq = new LinkedList<>();
        map = new HashSet<>();
        cacheSize = n;
    }

    public void refer(int x) {
        if (!map.contains(x)) {
            if (dq.size() == cacheSize) {
                // 큐가 꽉 찼다면 제일 참조한지 오래된 값을 삭제한다.
                // 이 떄, 이 값은 큐의 제일 마지막 끝에 위치하므로,
                // removeLast()를 호출한다.
                int last = dq.removeLast();
                // map 에서도 해당 값의 존재를 없앤다.
                map.remove(last);
            }
        } else {
            // 큐에서 값을 삭제할 때 O(N) 시간이 걸린다.
            // 이 부분은 각 키 값에 대한 참조를 hash map 에 저장한다면
            // O(1) 시간으로 최적화할 수 있다.
            int index = 0, i = 0;
            Iterator<Integer> itr = dq.iterator();
            while (itr.hasNext()) {
                if (itr.next() == x) {
                    index = i;
                    break;
                }
                i++;
            }
            dq.remove(index);
        }

        dq.push(x); // 큐의 헤드에 넣는다.
        map.add(x);
    }

    public void display() {
        Iterator<Integer> itr = dq.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next() + " ");
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(4);
        lruCache.refer(1);
        lruCache.refer(2);
        lruCache.refer(3);
        lruCache.refer(1);
        lruCache.refer(4);
        lruCache.refer(5);

        lruCache.display();
    }

}
