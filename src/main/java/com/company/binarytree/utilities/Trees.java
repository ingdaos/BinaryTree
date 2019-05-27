package com.company.binarytree.utilities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author PERSONAL
 */
public class Trees {

    private static Trees instance;
    private static Map<Integer, Object> trees;

    private Trees() {
        trees = new HashMap<>();
    }

    public static Trees getInstance() {
        if (instance == null) {
            instance = new Trees();
        }
        return instance;
    }

    public void setTree(List<List<Integer>> tree) {
        int key = tree.get(0).get(0);
        Trees.trees.put(key, tree);
    }

    public List<List<Integer>> getTree(Integer value) {
        return (List<List<Integer>>) Trees.trees.get(value);
    }

}
