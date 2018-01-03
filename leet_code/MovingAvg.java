/*
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

For example,
MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3

*/

class MovingAverage {
    int[] arr;
    int start;
    int size;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.arr = new int[size];
        this.start = 0;
        this.size = size;
    }
    
    public double next(int val) {
        arr[start % size] = val;
        start++;
        return getAvg();
    }
    
    private double getAvg(){
        if(start >= size)
            return calcAvg(size);
        return calcAvg(start);
    }
    
    private double calcAvg(int num){
        double count = 0;
        for(int i = 0; i < num; i++){
            count += arr[i];
        }
        return count / num;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
