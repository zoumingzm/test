package com.zm.collection;

import org.junit.Test;

import java.util.LinkedList;
import static java.lang.System.out;

/**
 * Created by Administrator on 2017/4/28.
 */
public class BinaryTree {

    @Test
    public void test(){
        LinkedList<Node<Integer>> nodes = new LinkedList<>();
        for (Integer i = 0; i < 10; i++) {
            nodes.add(new Node<>(i));
        }

        for (Integer parentIndex = 0; parentIndex<nodes.size()/2-1; parentIndex++){
            nodes.get(parentIndex).left = nodes.get(parentIndex*2+1);
            nodes.get(parentIndex).right = nodes.get(parentIndex*2+2);
        }

        //最后一个父节点可能没有右孩子，所以单独拿出来处理
        int lastParentIndex = nodes.size()/2-1;
        nodes.get(lastParentIndex).left = nodes.get(lastParentIndex*2+1);
        if (nodes.size()%2 ==1){
            nodes.get(lastParentIndex).right = nodes.get(lastParentIndex*2+2);
        }

        out.println(nodes);

        preorder(nodes.getFirst());
        midorder(nodes.getFirst());
        postorder(nodes.getFirst());

    }


    /**
     * 前序遍历
     * @param note
     */
    private void preorder(Node<Integer> note){
        if (note != null){
            out.print(note.data);
            preorder(note.left);
            preorder(note.right);
        }
    }

    /**
     * 中序遍历
     * @param note
     */
    private void midorder(Node<Integer> note){
        if (note != null){
            preorder(note.left);
            out.print(note.data);
            preorder(note.right);
        }
    }

    /**
     * 后续遍历
     * @param note
     */
    private void postorder(Node<Integer> note){
        if (note != null){
            preorder(note.left);
            preorder(note.right);
            out.print(note.data);
        }
    }





    public class Node<T>{
        private Node left;
        private Node right;
        private T data;

        public Node(T data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public Node(T data, Node left, Node right ){
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
}
