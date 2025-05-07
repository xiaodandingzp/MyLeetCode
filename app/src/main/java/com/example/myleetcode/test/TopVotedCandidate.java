package com.example.myleetcode.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 在选举中，第i张票是在times[i]时刻投给persons[i]的。对于发生在t时刻的查询，需要找出在t时刻在选举中领先的候选人的编号
 */
public class TopVotedCandidate {

    List<int[]> list = new ArrayList<>();
    public TopVotedCandidate(int[] persons, int[] times) {
        int val = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            int time = times[i];
            int person = persons[i];
            map.put(person, map.getOrDefault(person, 0) + 1);
            if (map.get(person) >= val) {
                val = map.get(person);
                list.add(new int[]{time, person});
            }
        }
    }

    public int q(int i) {
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid)[0] <= i) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return list.get(l)[0] <= i ? list.get(l)[1] : 0;
    }
}
