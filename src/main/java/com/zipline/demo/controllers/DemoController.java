package com.zipline.demo.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.zipline.demo.models.Content;
import com.zipline.demo.models.Message;
import com.zipline.demo.models.Nested;
import io.ipfs.api.IPFS;
import io.ipfs.api.NamedStreamable;
import io.ipfs.multihash.Multihash;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;


@RestController
public class DemoController {
    private String gateway = "https://gateway.ipfs.io/ipfs/";
    private IPFS ipfs = new IPFS("/ip4/127.0.0.1/tcp/5001");

    @CrossOrigin
    @PostMapping("/post")
    public String publicPost(
            @RequestParam(value="sender") String sender,
            @RequestParam(value="body") String body,
            @RequestParam(value="timestamp") String timestamp
    ) {
        Message post = new Message(sender, body, timestamp);
        String hash = publishMessage(post);
        return "{\"hash\": \"" + hash + "\"}";
    }

    private String publishMessage(Message message) {
        byte[] json;
        Multihash added;
        try {
            json = writeJsonBytes(message);
            added = addJson(json);
            return added.toString();
        } catch (Exception e) {
            System.out.println("error " + e.getMessage());
        }
        return "";
    }

    private byte[] writeJsonBytes(Content payload) throws Exception {
        return new ObjectMapper().writeValueAsBytes(payload);
    }

    private Multihash addJson(byte[] json) throws Exception {
        NamedStreamable.ByteArrayWrapper file = new NamedStreamable.ByteArrayWrapper(json);
        return ipfs.add(file).get(0).hash;
    }

    private String getJsonString(String jsonHashAddress) throws Exception {
        return IOUtils.toString(new URL((gateway + jsonHashAddress)), Charset.forName("UTF-8"));
    }
}
