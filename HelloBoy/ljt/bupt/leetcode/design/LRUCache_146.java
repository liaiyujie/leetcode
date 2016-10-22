package ljt.bupt.leetcode.design;

import java.util.Iterator;
import java.util.LinkedList;


//缓存讲究的就是快，所以我们必须做到O(1)的获取速度，这样看来只有哈希表可以胜任。
//但是哈希表无序的，我们没办法在缓存满时，将最早更新的元素给删去。那么是否有一种数据结构，
//可以将先进的元素先出呢？那就是队列。所以我们将元素存在队列中，并用一个哈希表记录下键值和元素的映射，
//就可以做到O(1)获取速度，和先进先出的效果。然而，当我们获取一个元素时，还需要把这个元素再次放到队列头，
//这个元素可能在队列的任意位置，可是队列并不支持对任意位置的增删操作。
//而最适合对任意位置增删操作的数据结构又是什么呢？是链表。我可以用链表来实现一个队列，
//这样就同时拥有链表和队列的特性了。不过，如果仅用单链表的话，在任意位置删除一个节点还是很麻烦的，
//要么记录下该节点的上一个节点，要么遍历一遍。所以双向链表是最好的选择。
//我们用双向链表实现一个队列用来记录每个元素的顺序，用一个哈希表来记录键和值的关系，就行了。


//数据结构用列表。get()和set()方法就不多讲，重要的是遇到下两种情况：
//
//元素被访问过，要将其放到列表头部，实现函数：moveToHead(Node node)
//元素个数达到最大值，删除尾部元素，实现函数：removeTail()
//
//同时为了快速选中元素，就采用HashMap<Integer, Node>来保存键值。
/*
public class LRUCache {

    private int capacity;
    private Node head, tail;
    private HashMap<Integer, Node> keyNodeMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        this.keyNodeMap = new HashMap<Integer, Node>();
    }

    public int get(int key) {
        Node node = keyNodeMap.get(key);
        if (node != null) {
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    public void set(int key, int value) {
        Node node = null;
        if (keyNodeMap.containsKey(key)) {
            node = keyNodeMap.get(key);
            node.value = value;
        } else {
            node = new Node(key, value);
            if (keyNodeMap.size() == capacity) {
                keyNodeMap.remove(removeTail());
            }
            keyNodeMap.put(key, node);
        }
        moveToHead(node);
    }

    private void moveToHead(Node node) {
        if (node.pre != null || node.next != null) {
            node.next.pre = node.pre;
            node.pre.next = node.next;
        }
        node.next = head.next;
        head.next.pre = node;
        node.pre = head;
        head.next = node;
    }

    private int removeTail() {
        int lastKey = -1;
        if (tail.pre != head) {
            Node lastNode = tail.pre;
            lastKey = lastNode.key;
            lastNode.pre.next = tail;
            tail.pre = lastNode.pre;
            lastNode = null;
        }
        return lastKey;
    }

    class Node{
        int key;
        int value;
        Node pre;
        Node next;
        public Node(int k, int v) {
            key = k;
            value = v;
        }
    }
}*/



/*public class LRUCache_146 {
    
    private Map<Integer, Integer> map;
    
    public LRUCache_146(int capacity) {
        map = new LinkedCappedHashMap<>(capacity);
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) { return -1; }
        return map.get(key);
    }
    
    public void set(int key, int value) {
        map.put(key,value);
    }

    private static class LinkedCappedHashMap<K,V> extends LinkedHashMap<K,V> {
        
        int maximumCapacity;
        
        LinkedCappedHashMap(int maximumCapacity) {
            super(16, 0.75f, true);
            this.maximumCapacity = maximumCapacity;
        }
        
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > maximumCapacity;
        }
    }
}*/

// 结果已经正确了，但是超时，效率低,是自己设计链表，而不是借用javaAPI中的LinkedList
public class LRUCache_146 {

	LinkedList<Strut> contain = null;
	int capacity;

	public LRUCache_146(int capacity) {
		contain = new LinkedList<>();
		this.capacity = capacity;
	}
	
//执行了get操作，也需要将get到的元素移到最前面
	public int get(int key) {
		int i = 0;
		for(i = 0 ; i<contain.size();i++){
			if (contain.get(i).key == key) {
				break;
			}
		}
		if(i<contain.size()){
			int v = contain.get(i).value;
			Strut s = new Strut(key,v);
			contain.remove(i);
			contain.addFirst(s);
			return v;
		}
			
		return -1;
	}

	public void set(int key, int value) {
		Strut s = new Strut();
		s.key = key;
		s.value = value;
		if (this.get(key) != -1) {// 容器中已经有了key，删除这个，新添加就行
			// 获得该key的下标，然后删除该key，将新key-value添加到链表首位
			int i = 0;
			for (i = 0; i < contain.size(); i++) {
				if (contain.get(i).key == key) {
					break;
				}
			}
			contain.remove(i);
			contain.addFirst(s);
		} else {// 容器没有这个key，这时候得看容器是否满了
			if (contain.size() < this.capacity) {// 还没满
				contain.addFirst(s);
			} else {
				contain.remove(contain.size() - 1);
				contain.addFirst(s);
			}

		}
	}
	// if(contain.size()<this.capacity){//还没满
	// // 先检索contain里面是否含有key这个Strut。没有直接加进去
	// if(this.get(key)==-1){
	// contain.addLast(s);
	// }else{
	// //获得该key的下标，然后删除该key，将新key-value添加到链表首位
	// int i = 0;
	// for(i = 0 ; i < contain.size();i++){
	// if(contain.get(i).key == key){
	// break;
	// }
	// }
	// contain.remove(i);
	// contain.addFirst(s);
	// }
	//
	// }else{
	// //即使这时候容器已经满了，还是得看看容器中时候含有key，这是公共代码
	// contain.remove(contain.size()-1);
	// contain.addLast(s);
	// }
	
	public static void main(String[] args) {
		LRUCache_146 lru = new LRUCache_146(1);
//		Strut s1 = new Strut(2,1);
//		Strut s2 = new Strut(2,2);
//		Strut s3 = new Strut(1,1);
//		Strut s4 = new Strut(4,1);
		lru.set(2, 1);
//		lru.set(2, 2);
		System.out.println(lru.get(2));
//		lru.set(1, 1);
//		lru.set(4, 1);
//		System.out.println(lru.get(2));
	}

}

class Strut {
	int key;
	int value;
	public Strut(int key, int value) {
		super();
		this.key = key;
		this.value = value;
	}
	public Strut() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
