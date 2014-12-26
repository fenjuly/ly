package org.xhome.ly.bean;

import java.util.List;

/**
 * Created by liurongchan on 14/12/24.
 */
public class Special3Response {

    protected int status;
    protected List<Case3Up> body;

    public Special3Response(){}

    public Special3Response(int status) {
        this.status = status;
    }
    public Special3Response(int status, List<Case3Up> body) {
        this(status);
        this.body = body;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public List<Case3Up> getBody() {
        return body;
    }
    public void setBody(List<Case3Up> body) {
        this.body = body;
    }
}
