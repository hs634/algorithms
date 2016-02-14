__author__ = 'hs634'

class CircularBuffer {
    int[] buffer;
    // next spot for reading
    int head;
    // next spot for writing
    int tail;
    mutex mtx;
    condition_variable cv_dequeue;
    condition_variable cv_enqueue;

    public CircularBuffer(int capacity) {
        buffer = new int[capacity + 1]; // to account for open slot that is maintained
        head, tail = 0;
        mutex = new mutex();
        cv_dequeue = new condition_variable();
        cv_enqueue = new condition_variable();
    }

    int size() {
       return (tail - head) % buffer.size();
    }

    bool enqueue(int item) {
        mtx.lock();
        // wait until there is space to insert
        while (tail == (head - 1) % buffer.size())
            cv_enqueue.wait();
        buffer[tail] = item;
        tail = (tail + 1) % buffer.size();
        cv_dequeue.signal();
        mtx.unlock();
    }

    int dequeue() {
        mtx.lock();
        // wait until there is an item to read
        while (head == tail)
            cv_dequeue.wait();
        int result = buffer[head];
        head = (head + 1) % buffer.size();
        cv_enqueue.signal();
        mtx.unlock();
        return result;
    }
}