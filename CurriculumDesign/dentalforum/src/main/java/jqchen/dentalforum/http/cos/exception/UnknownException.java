package jqchen.dentalforum.http.cos.exception;

// 未知异常
public class UnknownException extends AbstractCosException {

    private static final long serialVersionUID = 4303770859616883146L;

    public UnknownException(String message) {
        super(CosExceptionType.UNKNOWN_EXCEPTION, message);
    }

}
