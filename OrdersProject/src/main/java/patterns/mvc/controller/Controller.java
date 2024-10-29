package patterns.mvc.controller;

import patterns.mvc.model.SampleModel;
public class Controller {
    private SampleModel model;

    public Controller(SampleModel model){
        this.model = model;
    }

    public String getSampleMessage(){
        return model.getMessage();
    }

    public void updateSampleMessage(String newMessage){
        model.setMessage(newMessage);
    }
}
