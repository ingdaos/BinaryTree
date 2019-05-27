package com.company.binarytree.bo;

/**
 *
 * @author PERSONAL
 */
public class Node {

    private Integer parent;
    private Integer value;
    private Integer leftChild;
    private Integer rightChild;

    public Node(Integer value) {
        this.value = value;
    }

    public Node(Integer parent, Integer value) {
        this.parent = parent;
        this.value = value;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getLeftChild() {
        return leftChild;
    }

    public Integer getRightChild() {
        return rightChild;
    }

    public void setChild(Integer value) {
        if (this.leftChild == null && this.rightChild == null) {
            this.leftChild = value;
        } else if (this.leftChild == null && this.rightChild != null) {
            setChilds(value, this.rightChild);
        } else {
            setChilds(value, this.leftChild);
        }
    }

    public void setChilds(Integer value1, Integer value2) {
        if (value1 != null && value2 != null) {
            processChilds(value1, value2);
        } else {
            System.out.println("Error al intentar procesar hijos del nodo " + this.value);
        }
    }

    private void processChilds(Integer value1, Integer value2) {
        if (value1 > value2) {
            this.rightChild = value1;
            this.leftChild = value2;
        } else {
            this.rightChild = value2;
            this.leftChild = value1;
        }
    }

}
