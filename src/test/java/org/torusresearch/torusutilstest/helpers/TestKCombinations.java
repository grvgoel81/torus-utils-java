package org.torusresearch.torusutilstest.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.torusresearch.torusutils.helpers.Common;

import java.util.ArrayList;
import java.util.List;

public class TestKCombinations {
    @Test
    public void testKCombinations() {
        List<Integer> set = new ArrayList<>();
        List<List<Integer>> allCombis = Common.kCombinations(set, 0);
        assertEquals(allCombis.size(), 0);

        set.add(0);
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);


        allCombis = Common.kCombinations(set, 10);
        assertEquals(allCombis.size(), 0);

        allCombis = Common.kCombinations(set, 6);
        assertEquals(allCombis.size(), 1);

        allCombis = Common.kCombinations(set, 1);
        assertEquals(allCombis.size(), 6);

        allCombis = Common.kCombinations(set, 2);
        assertEquals(allCombis.size(), 15);

        set.remove(0);
        allCombis = Common.kCombinations(set, 3);
        assertEquals(allCombis.size(), 10);
    }
}
