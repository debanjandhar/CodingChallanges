package leetcode.thirtyday;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

class LRUCache {

	int capacity;

	LinkedHashMap<Integer, Integer> cache;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		cache = new LinkedHashMap<Integer, Integer>();
	}

	public int get(int key) {
		int ret = -1;
		if (cache.containsKey(key)) {
			ret = cache.get(key);
			cache.remove(key);
			cache.put(key, ret);
		}
		display();
		return ret;
	}

	public void put(int key, int value) {
		if (cache.containsKey(key)) {
			cache.remove(key);
			cache.put(key, value);
			
		}else if (cache.size() == capacity) {
			int firstKey = cache.entrySet().iterator().next().getKey();
			cache.remove(firstKey);
		}
		cache.put(key, value);
		display();
	}

	private void display() {
		System.out.println("Printing cache...");
		for (Entry<Integer, Integer> ele : cache.entrySet()) {
			System.out.println("[" + ele.getKey() + "] : [" + ele.getValue() + "]");
		}
	}
}

public class LRUCacheImpl {
	public static void main(String[] args) {
		LRUCache c = new LRUCache(2);
		c.put(2, 1);
		c.put(1, 1);
		c.put(2, 3);
		c.put(4, 1);
		c.get(1);
		c.get(2);
	}
}
