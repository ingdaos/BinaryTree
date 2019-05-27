package com.company.binarytree.services;

import com.company.binarytree.utilities.PathConstants;
import com.company.binarytree.utilities.Response;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PERSONAL
 */
@RestController
@RequestMapping(path = PathConstants.UTILITIES_SERVICE)
public class UtilitiesService {

    @RequestMapping(path = PathConstants.GET_DATE, method = GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Response> getTime() {
        Response resp = new Response();
        try {
            Map<String, Object> data = new HashMap<>();
            SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            data.put("date", dt.format(new Date()));
            resp.setData(data);
            return new ResponseEntity<>(resp, HttpStatus.OK);
        } catch (Exception ex) {
            System.err.println(ex);
            Map<String, String> error = new HashMap<>();
            error.put("error", ex.toString());
            resp.setError(error);
            return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
