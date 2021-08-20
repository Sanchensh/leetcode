package com.mrxu.datastructure;

/**
 * @author jlxu@telenav.cn
 * @date 2021/8/16/16:33
 */
public class CustomLinkedList<T> {

    private int size = 0;
    private Node<T> head;
    private Node<T> tail;

    public CustomLinkedList() {
        head = new Node<>(); //don't save any value,in order to implement
        tail = new Node<>(); //don't save any value,in order to implement
        head.next = tail;
        tail.previous = head;
    }

    public void add(T value) {
        add(size, value);
    }

    public void add(int index, T value) {
        checkIndex(index);
        if (index < size / 2){
            int i = 0;
            Node<T> tempNode = head;
            while (i < index) {
                tempNode = tempNode.next;
                i++;
            }
            Node<T> next = tempNode.next;
            Node<T> newNode = new Node<>(value, tempNode, next);
            tempNode.next = newNode;
            next.previous = newNode;
        } else {
            int i = size;
            Node<T> tempNode = tail;
            while (index < i) {
                tempNode = tempNode.previous;
                i--;
            }
            Node<T> previous = tempNode.previous;
            Node<T> newNode = new Node<>(value, previous, tempNode);
            previous.next = newNode;
            tempNode.previous = newNode;
        }
        size++;
    }


    void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index must be greater than 0 and less than size,current size is " + size);
        }
    }

    String print() {
        Node<T> tempNode = head.next;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (tempNode.next != null) {
            sb.append(tempNode.value);
            tempNode = tempNode.next;
            i++;
            if (i != size) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    private class Node<T> {
        T value;
        Node<T> previous;
        Node<T> next;

        Node(T value, Node<T> previous, Node<T> next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }

        Node() {
        }
    }

    @Override
    public String toString() {
        return "CustomLinkedList{" + print() + '}';
    }
}
