package org.example.lesson5;

import java.lang.reflect.Array;
import java.util.Map;

public class HashMapTest {

    private int capacity = 16;
    Entry[] nodes = new Entry[24];

    public HashMapTest() {
    }

    //    [entry2,null,null,null,new Entry("key", 123),null,null,null,null,null,]
    public void put(String key, Integer value) {
        Entry entry1 = new Entry("key", 123);
        Entry entry2 = new Entry(null, 124);
        entry1.next = entry2;
        //key1.hashCode() % 15 = 10;
        //key2.hashCode() % 15 = 10;

        if (key != null) {
            int index = key.hashCode() % (16 - 1);
        }
    }

    public static class Entry {
        String key;
        Integer value;
        Entry next;

        Entry nextPut;
        Entry prevPut;

        public Entry(String key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }
}
