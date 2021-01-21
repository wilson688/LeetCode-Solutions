package arrays;

class KclosestPointstoOrigin {
    int heapSize;
    int[][] maxHeap;
    int currentSizeOfHeap;

    public int[][] kClosest(int[][] points, int K) {
        heapSize = K;
        maxHeap = new int[K][2];
        int length = points.length;

        // Construct the maxHeap of size K from the given points.
        for (int i = 0; i < length; i++) {
            addPointToHeap(points[i][0], points[i][1]);
        }
        return maxHeap;
    }

    private void addPointToHeap(int x, int y) {
        if (currentSizeOfHeap < heapSize) {
            maxHeap[currentSizeOfHeap][0] = x;
            maxHeap[currentSizeOfHeap++][1] = y;
            if (currentSizeOfHeap == heapSize) {
                // convert this array to a maxHeap.
                // First element will be the one which has largest distance from
                // origin out of all present
                // in heap.
                for (int i = currentSizeOfHeap / 2; i >= 0; i--) {
                    maxHeapify(i);
                }
            }
        } else if (distanceFromOrigin(x, y) < distance(0)) {

            // Distance of this point is minimum than the maxDistance present in the heap.
            // Replace them and max Heapify first node again.
            maxHeap[0][0] = x;
            maxHeap[0][1] = y;
            maxHeapify(0);
        }
    }

    // Generic function to maxHeapify the subTree starting from this node.
    private void maxHeapify(int pos) {
        int leftChild = pos * 2 + 1;
        int rightChild = pos*2 + 2;
        int largest = pos;

        if(leftChild < heapSize && distance(leftChild) > distance(pos)) {
            largest = leftChild;
        }
        if(rightChild < heapSize && distance(rightChild) > distance(largest)) {
            largest = rightChild;
        }

        if(largest != pos) {
            swap(largest,pos);
            maxHeapify(largest);
        }
    }

    // Swap values of these two points.
    private void swap(int first, int second) {
        int tempX = maxHeap[first][0];
        int tempY = maxHeap[first][1];

        maxHeap[first][0] = maxHeap[second][0];
        maxHeap[first][1] = maxHeap[second][1];

        maxHeap[second][0] = tempX;
        maxHeap[second][1] = tempY;
    }

    private double distance(int pos) {
        return distanceFromOrigin(maxHeap[pos][0],maxHeap[pos][1]);
    }

    // Function to calculate the Euclidean distance for a given point.
    // We are not calculating the square root in order to reduce running time, as we just need to compare
    // disatance of one point with another and do not need the exact distance itself.
    private int distanceFromOrigin(int x, int y) {
        return (y*y) + (x*x);
    }
}