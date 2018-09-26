/*
 * Copyright (c) 2018. From whut_zhaotian  Email:zhaotian@whut.edu.cn
 */

package P51_P70;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhaotian
 * @date 2018/9/23 15:32
 */
public class P56 {
    public static void main(String[] args) {
        Interval interval1 = new Interval(1, 3);
        Interval interval2 = new Interval(4, 6);
        Interval interval3 = new Interval(7, 18);
        Interval interval4 = new Interval(2, 3);
        List<Interval> intervals = new ArrayList<>();
        intervals.add(interval1);
        intervals.add(interval2);
        intervals.add(interval3);
        intervals.add(interval4);
        List<Interval> res = merge(intervals);
        for (Interval i : res
                ) {

            System.out.println("[" + i.start + "," + i.end + "]");
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start>o2.start){
                    return 1;
                }
                else if(o1.start<o2.start){
                    return -1;
                }
                else {
                    if (o1.end==o2.end){
                        return 0;
                    }
                    return o1.end > o2.end ? 1 : -1;
                }
            }
        });
        List<Interval> res = new ArrayList<>();
        for (Interval i:intervals
             ) {
            System.out.println("["+i.start+","+i.end+"]");
            if (res.size() == 0) {
                res.add(i);
            }
            else {
                int exist_start = res.get(res.size() - 1).start;
                int exist_end = res.get(res.size() - 1).end;
                if (i.start>=exist_start&&i.start<=exist_end) {
                    res.set(res.size() - 1, new Interval(exist_start, exist_end > i.end ? exist_end : i.end));
                }
                else {
                    res.add(i);
                }
            }
        }
        return res;
    }
}

class Interval {
    int start;
    int end;
    Interval() {
        start = 0;
        end = 0;
    }
    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

