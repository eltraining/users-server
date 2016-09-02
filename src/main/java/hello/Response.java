package hello;

public class Response {

    private final long id;
    private final boolean ok;
    private final String content;

    public Response(long id, boolean ok,String content) {
        this.id = id;
        this.ok = ok;
        this.content = content;
    }

    public long getId() {
        return id;
    }
    public String getContent() {
        return content;
    }
    public boolean isOk() {      return ok;    }

}