package com.durpdur;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @Test
    void mergeArrTest() {
        int[] arr1 = {3, 1, 5};
        int[] arr2 = {1, 2, 6};

        int[] res = Main.mergeArr(arr1, arr2);

        assertArrayEquals(new int[]{1, 1, 2, 3, 5, 6}, res);
    }

    @Test
    void mergedEmptyArr() {
        int[] arr1 = {};
        int[] arr2 = {1, 2, 5, 6};

        int[] res = Main.mergeArr(arr1, arr2);

        assertArrayEquals(new int[]{1, 2, 5, 6}, res);
    }
}
