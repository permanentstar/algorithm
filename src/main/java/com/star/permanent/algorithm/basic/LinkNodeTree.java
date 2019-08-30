package com.star.permanent.algorithm.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LinkNodeTree {
    private static Node root;
    private static Integer[] vs = {5,3,7,4,8,1,5,7,9,10,13,3,2};
    public static void main(String[] args) {
        Integer[] v = vs;
        for(int i = 0;i<v.length; ++i) {
            insert(v[i]);
        }
        System.out.println(String.format("height is %d",height(root)));
        System.out.println("===== start inOrder ====");
        inOrder(root);
        System.out.println("===== start preOrder ====");
        preOrder(root);
        System.out.println("===== start postOrder ====");
        postOrder(root);
        Integer toFind = 7;
        List<Node> nodes = find(toFind);
        System.out.println(String.format("find %d seq %s",toFind, nodes.stream().map(n->n.seq).collect(Collectors.toList())));
    }

    private static void preOrder(Node node) {
        if (node == null) return;
        System.out.println(String.format("Node%d(%d)",node.seq, node.value));
        preOrder(node.left);
        preOrder(node.right);
    }

    private static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(String.format("Node%d(%d)",node.seq, node.value));
    }

    private static void inOrder(Node node) {
        inOrder(Collections.singletonList(node));
    }

    private static void inOrder(List<Node> children) {
        if (children.size() == 0) return;
        List<Node> nodes = new ArrayList<Node>(children.size() * 2);
        for(Node node: children) {
            System.out.println(String.format("Node%d(%d)",node.seq, node.value));
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
        inOrder(nodes);
    }

    private static void delete(Integer v) {

    }
    private static Integer seq = 0;
    private static void insert(Integer v) {
        if (root == null) {
            root = new Node(null, null, v, ++seq);
        } else {
            Node current = root;
            while (true) {
                if (current.value.equals(v)) {
                    if (current.right == null) {
                        current.right = new Node(null, null, v, ++seq);
                        break;
                    } else {
                        current = current.right;
                    }
                } else if (current.value > v) {
                    if (current.left == null){
                        current.left = new Node(null, null, v, ++seq);
                        break;
                    } else{
                        current = current.left;
                    }
                } else {
                    if(current.right == null) {
                        current.right = new Node(null, null, v, ++seq);
                        break;
                    } else{
                        current = current.right;
                    }
                }
            }
        }
    }

    private static List<Node> find(Integer v) {
        Node curr = root;
        List<Node> rs = new ArrayList<Node>();
        while (curr != null) {
            if (curr.value.equals(v)){
                rs.add(curr);
                curr = curr.right;
            } else if (curr.value < v) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        return rs;
    }

    private static Integer height(Node node) {
        if (node == null) return -1;
        return Math.max(height(node.left), height(node.right)) + 1;
    }


    public static class Node {
        public Node left;
        public Node right;
        public Integer value;
        public Integer seq;

        public Node(Node left, Node right, Integer value, Integer seq) {
            this.left = left;
            this.right = right;
            this.value = value;
            this.seq = seq;
        }
    }
}
