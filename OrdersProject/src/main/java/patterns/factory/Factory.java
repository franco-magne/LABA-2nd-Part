package patterns.factory;

import java.util.ArrayList;

public class Factory {
    public Object createObject(String type){
        if(type.equalsIgnoreCase("String")){
            return "";
        } else if (type.equalsIgnoreCase("Integer")){
            return 0;
        } else if (type.equalsIgnoreCase("List")){
            return new ArrayList<>();
        }
        return null;
    }
}
