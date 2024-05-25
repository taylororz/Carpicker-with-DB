package gr.uom.carpicker;

import java.util.ArrayList;
import java.util.List;

public class CarBrandsList {
    ArrayList<Brand> cbList = new ArrayList<Brand>();

    public CarBrandsList(String ip) {
        String url = "http://" + ip + "/multimediaDBServices/getMedia.php";

        try {
            OkHttpHandler okHttpHandler = new OkHttpHandler();
            cbList = okHttpHandler.populateDropDown(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getAllBrands() {
        List<String> temp = new ArrayList<String>();
        for (int i = 0; i < cbList.size(); i++) {
            temp.add(cbList.get(i).getName());
        }
        return temp;
    }

    public List<String> getAllModels(String b) {
        List<String> temp = new ArrayList<String>();
        for (int i = 0; i < cbList.size(); i++) {
            if (cbList.get(i).hasName(b)) {
                temp = cbList.get(i).getAllModels();
            }
        }
        return temp;
    }

    public Media lookup(String brand, String model) {
        for (int i = 0; i < cbList.size(); i++) {
            if(cbList.get(i).hasName(brand)){
                return cbList.get(i).getMedia(model);
            }
        }
        return null;
    }
}