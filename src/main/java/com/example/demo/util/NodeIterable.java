package com.example.demo.util;

import org.jsoup.nodes.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class NodeIterable implements Iterable<Node>{
    private Node root;

    public NodeIterable(Node root){
        this.root = root;
    }

    @Override
    public Iterator<Node> iterator() {
        return new NodeIterator();
    }

    private class NodeIterator implements Iterator<Node> {
        Deque<Node> stack;

        public NodeIterator() {
            stack = new ArrayDeque<>();
            stack.push(root);
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public Node next() {
            if (stack.isEmpty()) {
                throw new NoSuchElementException();
            }

            Node node = stack.pop();
            List<Node> nodes = node.childNodes();
            List<Node> childNodes = new ArrayList<>(nodes);
            Collections.reverse(childNodes);
            for (Node child : childNodes) {
                stack.push(child);
            }
            return node;
        }
    }
}
