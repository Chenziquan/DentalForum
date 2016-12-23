package jqchen.dentalforum.http.cos.exception;

import org.json.JSONException;
import org.json.JSONObject;

import jqchen.dentalforum.http.cos.http.ResponseBodyKey;


/**
 * 封装cos异常
 *
 * @author chengwu
 */
public abstract class AbstractCosException extends Exception {

    private static final long serialVersionUID = 7547532865194837136L;

    private CosExceptionType type;

    public AbstractCosException(CosExceptionType type, String message) {
        super(message);
        this.type = type;
    }

    public CosExceptionType getType() {
        return type;
    }

    @Override
    public String toString() {
        JSONObject responseObj = new JSONObject();
        try {
            responseObj.put(ResponseBodyKey.CODE, type.getErrorCode());
            responseObj.put(ResponseBodyKey.MESSAGE, getMessage());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return responseObj.toString();
    }

}
