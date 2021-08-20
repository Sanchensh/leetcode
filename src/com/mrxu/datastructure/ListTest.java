package com.mrxu.datastructure;

import java.util.List;

/**
 * @author jlxu@telenav.cn
 * @date 2021/7/30/15:53
 */
public class ListTest {
    public static void main(String[] args) {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);
        list.add(4,6);
        System.out.println(list);
    }
}
