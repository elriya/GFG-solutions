class kQueues {
    int[] arr;
    int[] next;
    int[] front;
    int[] rear;
    int free;
    int n, k;

    kQueues(int n, int k) {
        this.n = n;
        this.k = k;
        arr = new int[n];
        next = new int[n];
        front = new int[k];
        rear = new int[k];

        for (int i = 0; i < k; i++) {
            front[i] = -1;
            rear[i] = -1;
        }

        free = 0;
        for (int i = 0; i < n - 1; i++) {
            next[i] = i + 1;
        }
        next[n - 1] = -1; 
    }

    void enqueue(int x, int i) {
        if (isFull()) return;

        int index = free;      
        free = next[index];    

        if (isEmpty(i)) {
            front[i] = index;  
        } else {
            next[rear[i]] = index; 
        }

        next[index] = -1;    
        rear[i] = index;       
        arr[index] = x;       
    }

    int dequeue(int i) {
        if (isEmpty(i)) return -1;

        int index = front[i];   
        front[i] = next[index]; 

        next[index] = free;
        free = index;

        return arr[index];
    }

    boolean isEmpty(int i) {
        return front[i] == -1;
    }

    boolean isFull() {
        return free == -1;
    }
}