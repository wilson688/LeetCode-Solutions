 ###SORT ARRAYLIST
 Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
 Arrays.sort(intervals,(a,b) -> Integer.compare(a.start, b.start));
 
 ###CYCLIC SORT
 MISSING NUMBERS/DUPLICATES
 
 ### FAST AND SLOW POINTER 
 MIDDLE NUMBER/ START OF CYCLE/ PALINDROME 
 
 ###PALINDROME LINKEDLIST 
 Divide into 2 half and reverse the second half and check 
 
 ### IS ARRAY EMPYT? 
 arr == null?
 
 ### SLIDING WINDOW 
 -> always declare windowStart as global variable 
 -> always declare windowEnd as local varaible
 -> loop inside with 0 and loop until arr.length
 
 ### RECURSION 
 Fibonacci -> time complexity O(S)*R
 
 ### DEPTH OF TREE 
 DFS 
 
 ### POWER OF X
 Divide the iteration into 2 half 
 if n % 2 == 0 (n is even) productHalf*productHalf 
 else productHalf*productHalf*x

and make sure you are check for N (power) if it is N or -N 
      if(N < 0) {
          x = 1/x; 
          N = -N;
      }

### MAX & MIN VALUES
maxValue = Integer.MAX_VALUE;
minValue = Integer.MIN_VALUE;

### Length of column of a matrix 
matrix[0].length;

### MAP.KEYSET() 
returns set view of keys


### PRIORITY QUEUE 
PQ<> pq = new PR<>((n1,n2) -> n2 - n1); 
 
 
### Char digit into int digit 
int digit = int (s.charAt(i) - '0);

### convert char into digit 
int digit = s.charAt(i) - 'a';

### ITTERATE LIST & MAP OR SET
Iterator<Interval> intervalItr = intervals.iterator();
Map.Entry<K,V> mp: MAP.entrySet();

eg: 
```Iterator<Interval> intervalItr = intervals.iterator();
Interval interval = intervalItr.next();
int start = interval.start;
int end = interval.end;
while(intervalItr.next()) {
 interval = intervalItr.next();
      if (interval.start <= end) { // overlapping intervals, adjust the 'end'
        end = Math.max(interval.end, end);
      } else { // non-overlapping interval, add the previous interval and reset
        mergedIntervals.add(new Interval(start, end));
        start = interval.start;
        end = interval.end;
      }
}
