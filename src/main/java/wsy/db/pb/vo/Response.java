package wsy.db.pb.vo;

public class Response {

    private Integer code;
    private String message;
    private Object data;

    public static Response success(String message) {
        return new Response(RCode.SUCCESS.getCode(), message, null);
    }

    public static Response success(Object data) {
        return new Response(RCode.SUCCESS.getCode(), null, data);
    }

    public static Response success(Object data, String message) {
        return new Response(RCode.SUCCESS.getCode(), message, data);
    }

    public static Response failed(String content) {
        return new Response(RCode.FAILED.getCode(), content, null);
    }

    private Response(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

