package mrhaki.micronaut;

public class ResponseData {
    private MessageResponseData json;
    public MessageResponseData getJson() { return json; }
    public void setJson(final MessageResponseData json) { this.json = json; }
    
    static class MessageResponseData {
        private String message;
        public String getMessage() { return message; }
        public void setMessage(final String message) { this.message = message; }
    }
}
