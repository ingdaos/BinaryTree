package com.company.binarytree.services;

import com.company.binarytree.bo.BinaryTree;
import com.company.binarytree.utilities.PathConstants;
import com.company.binarytree.utilities.Response;
import com.company.binarytree.utilities.Trees;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PERSONAL
 */
@RestController
@RequestMapping(path = PathConstants.TREE_SERVICE)
public class TreeService {

    @Autowired
    private BinaryTree binaryTree;

    @RequestMapping(path = PathConstants.CREATE_TREE,
            method = POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Response> createTree(@RequestBody Map<String, Object> requestBody) {
        Response resp = new Response();
        try {
            List<List<Integer>> tree = (List<List<Integer>>) requestBody.get("nodeList");
            Trees trees = Trees.getInstance();
            trees.setTree(tree);
            Map<String, Object> data = new HashMap<>();
            data.put("treeValue", tree.get(0).get(0));
            resp.setData(data);
            return new ResponseEntity<>(resp, HttpStatus.CREATED);
        } catch (Exception ex) {
            Map<String, String> error = new HashMap<>();
            error.put("error", ex.toString());
            resp.setError(error);
            return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = PathConstants.GET_TREE, method = GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Response> getTree(@RequestParam("value") Integer value) {
        Response resp = new Response();
        try {
            Trees trees = Trees.getInstance();
            List<List<Integer>> nodeList = trees.getTree(value);
            Map<String, Object> data = new HashMap<>();
            data.put("treeValue", value);
            data.put("nodeList", nodeList);
            resp.setData(data);
            return new ResponseEntity<>(resp, HttpStatus.OK);
        } catch (Exception ex) {
            Map<String, String> error = new HashMap<>();
            error.put("error", ex.toString());
            resp.setError(error);
            return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = PathConstants.GET_COMMON_PARENT, method = GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Response> getCommonParent(
            @RequestParam("treeValue") Integer treeValue,
            @RequestParam("nodeValue1") Integer nodeValue1,
            @RequestParam("nodeValue2") Integer nodeValue2) {
        Response resp = new Response();
        try {
            Trees trees = Trees.getInstance();
            List<List<Integer>> nodeList = trees.getTree(treeValue);
            binaryTree.setNodeList(nodeList);
            Integer parent = binaryTree.getCommonParent(nodeValue1, nodeValue2);
            Map<String, Object> data = new HashMap<>();
            data.put("treeValue", treeValue);
            data.put("commonParent", parent);
            data.put("nodeValue1", nodeValue1);
            data.put("nodeValue2", nodeValue2);
            resp.setData(data);
            return new ResponseEntity<>(resp, HttpStatus.OK);
        } catch (Exception ex) {
            Map<String, String> error = new HashMap<>();
            error.put("error", ex.toString());
            resp.setError(error);
            return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
