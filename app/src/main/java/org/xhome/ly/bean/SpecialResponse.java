package org.xhome.ly.bean;

import java.util.List;

/**
 * Created by liurongchan on 14/12/15.
 */
public class SpecialResponse {

    protected int status;
    protected List<Case1Up> body;

    public SpecialResponse(){}

    public SpecialResponse(int status) {
        this.status = status;
    }
    public SpecialResponse(int status, List<Case1Up> body) {
        this(status);
        this.body = body;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public List<Case1Up> getBody() {
        return body;
    }
    public void setBody(List<Case1Up> body) {
        this.body = body;
    }
}
