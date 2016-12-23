package jqchen.dentalforum.data.bean;

/**
 * Created by jqchen on 2016/12/23.
 * Use to
 */
public class BaseReturnBean {
    /**
     * status : 1
     * success : true
     */

    private int status;
    private boolean success;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
