package example.framework.layer.exception;


import example.framework.layer.protocol.response.Error;

public class CheckException extends BaseException {

    private final int code;

    public CheckException(Error error) {
        super(error.toString());
        this.code = error.getCode();
    }

    /**
     * 用于一种code对英语多种语义的情况，需要加remark，最后的msg为apiresult Enum.getMessage()+":"+remark
     *
     * @param error  输出的结果对象
     * @param remark 补充remark
     */
    public CheckException(Error error, String remark) {
        super(error.toString(remark));
        this.code = error.getCode();
    }

    /**
     * 用于异常转译
     *
     * @param error 输出的结果对象
     * @param cause 下层异常栈
     */
    public CheckException(Error error, Throwable cause) {
        super(error.toString(), cause);
        this.code = error.getCode();
    }


    /**
     * 用于异常转译切code对英语多种语义的情况，需要加remark，最后的msg为{@link #getMessage()}
     * +":"+message
     *
     * @param error   输出的结果对象
     * @param cause   下层异常栈
     * @param message 异常信息
     */
    public CheckException(Error error, Throwable cause, String message) {
        super(error.toString(message), cause);
        this.code = error.getCode();
    }

    public CheckException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
