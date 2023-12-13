package org.example.task2;

import java.util.Map;
import java.util.HashMap;

public class Visitor {
    private boolean Group;
    public Map onStart(Group group, Map<String, String> headers){
        this.Group = true;
        Map<String, Object> output = new HashMap<>();
        output.put("in_group", this.Group);
        output.put("stamped_headers", new String[]{"in_group"});
        return output;
    }

    public void inTheEnd(Group group, Map<String, String> headers){
        this.Group = false;
    }

    public Map forSignature(Signature signature, Map<String, String> headers){
        Map<String, Object> output = new HashMap<>();
        output.put("in_group", this.Group);
        output.put("stamped_headers", new String[]{"in_group"});
        return output;
    }

}
