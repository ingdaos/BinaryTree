package com.company.binarytree.services;

import com.company.binarytree.utilities.PathConstants;
import com.company.binarytree.utilities.Response;
import com.company.binarytree.utilities.Utilities;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author PERSONAL
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TreeServiceTest {

    private static final String TREE_SERVICE_PATH = "http://127.0.0.1:8443/BinaryTree/treeService/";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCommonParent() {
        createTree();
        getCommonParent(70, 40, 78, 70);
        getCommonParent(70, 51, 37, 49);
        getCommonParent(70, 76, 85, 84);
    }

    private void createTree() {
        List<Integer> a = Arrays.asList(70, 84, 85);
        List<Integer> b = Arrays.asList(70, 84, 78, 80);
        List<Integer> c = Arrays.asList(70, 84, 78, 76);
        List<Integer> d = Arrays.asList(70, 49, 54, 51);
        List<Integer> e = Arrays.asList(70, 49, 37, 40);
        List<Integer> f = Arrays.asList(70, 49, 37, 22);
        List<List<Integer>> nodeList = Arrays.asList(a, b, c, d, e, f);

        String url = TREE_SERVICE_PATH.concat(PathConstants.CREATE_TREE);
        Map<String, Object> request = new HashMap<>();
        request.put("nodeList", nodeList);

        Response response = Utilities.sendPostRequest(restTemplate, url, request);
        assertNotNull(response);

        Integer treeValue = (Integer) response.getData().get("treeValue");
        assertNotNull(treeValue);
        assertEquals("No se creo el árbol", Long.valueOf(70), Long.valueOf(treeValue));
    }

    private void getCommonParent(Integer treeValue, Integer nodeValue1,
            Integer nodeValue2, Integer parent) {
        String url = TREE_SERVICE_PATH.concat(PathConstants.GET_COMMON_PARENT);
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url);
        uriBuilder.queryParam("treeValue", treeValue);
        uriBuilder.queryParam("nodeValue1", nodeValue1);
        uriBuilder.queryParam("nodeValue2", nodeValue2);
        String uri = uriBuilder.build().toString();

        Response response = Utilities.sendGetRequest(restTemplate, uri);
        assertNotNull(response);

        Integer commonParent = (Integer) response.getData().get("commonParent");
        assertNotNull(commonParent);
        assertEquals("No se calculo el padre comun", Long.valueOf(parent), Long.valueOf(commonParent));
    }

}
