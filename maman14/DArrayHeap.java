package maman14;

/** Class D-ary Heap **/
class DArrayHeap {
    /** The number of children each node has **/
    private int _d;
    private int _heapSize;
    private int[] _heap;

    /** Constructor **/

    public DArrayHeap(int[] values, int d) {
        this._heapSize = 0;
        this._d = d;
        this._heap = new int[values.length];
        for (int value : values) {
            insert(value);
        }
    }

    /** ToString function **/
    public String toString() {
        String str = "[";
        for (int i = 0; i < this._heap.length; i++) {
            str += this._heap[i];
            if (i != this._heap.length - 1)
                str += ", ";
        }
        str += "] (d=" + this._d + ")";
        return str;
    }

    /** Function to check if heap is empty **/
    public int[] getHeap() {
        return this._heap;
    }

    /** Function to check if heap is empty **/
    public boolean isEmpty() {
        return this._heapSize == 0;
    }

    /** Check if heap is full **/
    public boolean isFull() {
        return this._heapSize == this._heap.length;
    }

    /** Clear heap */
    public void clear() {
        this._heapSize = 0;
    }

    /** Function to get index parent of i **/
    private int parent(int i) {
        return (i - 1) / this._d;
    }

    /** Function to get index of k th child of i **/
    private int kthChild(int i, int k) {
        return this._d * i + k;
    }

    /** Function to insert element */
    public void insert(int x) {
        if (isFull()) {
            System.out.println("JOB FAILD: Heap is full");
            return;
        }
        /** Percolate up **/
        this._heap[this._heapSize++] = x;
        heapifyUp(this._heapSize - 1);
    }

    /** Function to find least element **/
    public int findMin() {
        if (isEmpty()) {
            System.out.println("JOB FAILD: Heap is empty");
            return -1;
        }
        return this._heap[0];
    }

    /** Function to delete element at an index **/
    public int delete(int i) {
        if (isEmpty()) {
            System.out.println("JOB FAILD: Heap is empty");
            return -1;
        }
        int keyItem = this._heap[i];
        this._heap[i] = this._heap[this._heapSize - 1];
        this._heapSize--;
        heapifyDown(i);
        return keyItem;
    }

    /** Function heapifyUp **/
    private void heapifyUp(int childIndex) {
        int tmp = this._heap[childIndex];
        while (childIndex > 0 && tmp < this._heap[parent(childIndex)]) {
            this._heap[childIndex] = this._heap[parent(childIndex)];
            childIndex = parent(childIndex);
        }
        this._heap[childIndex] = tmp;
    }

    /** Function heapifyDown **/
    private void heapifyDown(int i) {
        int child;
        int tmp = this._heap[i];
        while (kthChild(i, 1) < this._heapSize) {
            child = minChild(i);
            if (this._heap[child] < tmp)
                this._heap[i] = this._heap[child];
            else
                break;
            i = child;
        }
        this._heap[i] = tmp;
    }

    /** Function to get smallest child **/
    private int minChild(int i) {
        int bestChild = kthChild(i, 1);
        int k = 2;
        int pos = kthChild(i, k);
        while ((k <= this._d) && (pos < this._heapSize)) {
            if (this._heap[pos] < this._heap[bestChild])
                bestChild = pos;
            pos = kthChild(i, k++);
        }
        return bestChild;
    }

}
