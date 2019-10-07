package by.it.yuntsevich.jd02_03;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class Bucket {
    private Bucket() {
    }

    private String name;
    private Bucket(String name) {
        this.name = name;
    }

    private static final int bucketLimit = 50;
    private static final BlockingDeque<Bucket> bucketsStore = new LinkedBlockingDeque<>(bucketLimit);


    static {
        for (int i = 1; i < bucketLimit + 1; i++) {
            bucketsStore.add(new Bucket("Bucket №" + i));
        }
    }
    static Bucket takeBucket() throws InterruptedException {
        return bucketsStore.takeLast();
    }
    static void returnBucket(Bucket bucket) {
        bucketsStore.addLast(bucket);
    }

    private Deque<Goods> bucket = new LinkedList<>();

    Goods getGoodFromBasket() {
        return bucket.pollLast();
    }

    void putGoodToBasket(Goods good) {
        bucket.addLast(good);
    }

    void emptyBasket() {
        bucket.clear();
    }

    int basketContentSize() {
        return bucket.size();
    }

    @Override
    public String toString() {
        return name;
    }

}
