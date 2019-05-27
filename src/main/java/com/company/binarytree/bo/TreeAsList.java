package com.company.binarytree.bo;

import com.company.binarytree.utilities.Beans;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author PERSONAL
 */
@Component(Beans.TREE_AS_LIST)
public class TreeAsList implements BinaryTree {

    private Integer value;
    private List<List<Integer>> nodeList;

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public List<List<Integer>> getNodeList() {
        return nodeList;
    }

    @Override
    public void setNodeList(List<List<Integer>> nodeList) {
        this.nodeList = nodeList;
        this.value = this.nodeList.get(0).get(0);
    }

    @Override
    public Integer getCommonParent(Integer value1, Integer value2) {
        List<Integer> firstList = null;
        List<Integer> secondList = null;

        for (List<Integer> tmp : this.nodeList) {
            if (tmp.contains(value1)) {
                firstList = tmp;
            }
            if (tmp.contains(value2)) {
                secondList = tmp;
            }
            if (firstList != null && secondList != null) {
                break;
            }
        }

        if (firstList != null && secondList != null) {
            int id1 = firstList.indexOf(value1);
            int id2 = secondList.indexOf(value2);

            if (id1 > id2) {
                return processCommonParent(id1, firstList, id2, secondList);
            } else {
                return processCommonParent(id2, secondList, id1, firstList);
            }
        }

        return null;
    }

    private Integer processCommonParent(int biggerIndex, List<Integer> biggerList,
            int smallerIndex, List<Integer> smallerList) {

        for (int x = biggerIndex - 1; x >= 0; x--) {
            int bigValue = biggerList.get(x);

            for (int y = smallerIndex - 1; y >= 0; y--) {
                int smallValue = smallerList.get(y);
                if (bigValue == smallValue) {
                    return smallValue;
                }
            }
        }
        return null;
    }

}
