package arrays;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {

    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for(int i = 0; i < intervals.length - 1; i++) {
            if(intervals[i][0] > intervals[i][1] || intervals[i+1][0] > intervals[i+1][1]) return false;
            if(intervals[i][1] > intervals[i + 1][0]) return false;
        }

        return true;
    }


    public static void main(String[] args) {
        MeetingRooms mr = new MeetingRooms();
        System.out.println(mr.canAttendMeetings(new int[][] {{0,30},{5,10},{15,20}}));
        System.out.println(mr.canAttendMeetings(new int[][] {{7,10},{2,4}}));
        System.out.println(mr.canAttendMeetings(new int[][] {{11,10},{2,4}}));
        System.out.println(mr.canAttendMeetings(new int[][] {{5,8},{6,8}}));
    }
}
