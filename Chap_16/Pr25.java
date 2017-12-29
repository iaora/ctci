/*
 * LRU Cache: DEsign and build a "least recently used" cache, which
 * evicts the least recently used item. The cache should map from keys
 * to value (allowing you to insert and retrieve a value associated
 * with a particular key) and be initialized with a max size. 
 * When it is full, it should evist the least recently used item.
 */

import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Iterator;
import java.sql.Timestamp;

public class Pr25{
    int maxSize;
    PriorityQueue<Pr25.Entry> pq;

    public Pr25(int maxSize){
        this.maxSize = maxSize;
        pq = new PriorityQueue<Pr25.Entry>(1,
                                            new Comparator<Pr25.Entry>() {
                                                @Override
                                                public int compare(Pr25.Entry o1, Pr25.Entry o2) {
                                                    return o1.getTime() < o2.getTime() ? -1 : 1;
                                                }
                                            }
                                          );
    }

    public static void main(String[] args){
        Pr25 pr = new Pr25(3);
        pr.add("hehe", 7, pr);
        pr.add("lol", 8, pr);
        pr.print(pr.pq);
    }

    private void add(String key, int value, Pr25 pr){
        Pr25.Entry e = pr.new Entry(key, value);
        if ( pq.size() < maxSize )
            pq.add(e);
        else if ( pq.contains(e) ){
            pq.remove(e);// HOW DO I CHECK FOR OBJECT EQUALITY.. UH
            pq.add(e);
        }else{
            pq.poll();
            pq.add(e);
        }
    }


    private void print(PriorityQueue<Pr25.Entry> pq){
        Pr25.Entry e = pq.peek();

        System.out.println(e.getKey());
        System.out.println(e.getValue());
        System.out.println(e.getTime());
        System.out.println(pq.size());
    }


    class Entry{
        private String key;
        private int value;
        private long time;

        private Entry(String key, int value){
            this.key = key;
            this.value = value;
            this.time = new Timestamp(System.currentTimeMillis()).getTime();
        }

        public String getKey(){return key;}
        public int getValue(){return value;}
        public long getTime(){return time;}
        public void setTime(long time){this.time = time;}
    }

}
