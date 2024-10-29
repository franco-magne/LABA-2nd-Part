package patterns.mvc.model;

public class SampleModel {
    private String message;

    public SampleModel(){
        this.message = "Hello from the Model!";
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }
}
