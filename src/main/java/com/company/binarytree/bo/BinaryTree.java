package com.company.binarytree.bo;

import java.util.List;

/**
 *
 * @author PERSONAL
 */
public interface BinaryTree {

    public Integer getValue();

    public List<List<Integer>> getNodeList();

    public void setNodeList(List<List<Integer>> nodeList);

    public Integer getCommonParent(Integer value1, Integer value2);

}
