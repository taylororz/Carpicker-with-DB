package gr.uom.carpicker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Brand {
    private String name;
    private List<String> models = new ArrayList<String>();

    private HashMap<String,Media> media = new HashMap<String, Media>();


    public Brand(String b, String m, String p) {
        name = b;
        models = Arrays.asList(m.split(","));
        String[] imageArray = p.split(",");
        for (int i=0; i<this.models.size(); i++){
            media.put(this.models.get(i), new Media(imageArray[i]));
        }
    }

    public boolean hasName(String b) {
        return name.equals(b);
    }

    public String getName() {return name; }
    public List<String> getAllModels() {return models;}

    public Media getMedia(String key){ return this.media.get(key);};
}
