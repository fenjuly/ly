package org.xhome.ly.bean;

import java.util.List;

/**
 * Created by liurongchan on 14/12/24.
 */
public class Special2Response {
    protected int status;
    protected List<Case2Up> body;

    public Special2Response(){}

    public Special2Response(int status) {
        this.status = status;
    }
    public Special2Response(int status, List<Case2Up> body) {
        this(status);
        this.body = body;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public List<Case2Up> getBody() {
        return body;
    }
    public void setBody(List<Case2Up> body) {
        this.body = body;
    }
}
