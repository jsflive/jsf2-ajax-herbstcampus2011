package at.irian.herbstcampus2011;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ManagedBean
@SessionScoped
public class Test {

    private String first;
    private String last;
    private String country;
    private String state;

    private Map<String, List<String>> statesMap;

    @PostConstruct
    public void init() {
        statesMap = new HashMap<String, List<String>>();

        List<String> states = new ArrayList<String>();
        states.add("Oberösterreich");
        states.add("Niederösterreich");
        states.add("Wien");
        statesMap.put("Österreich", states);

        states = new ArrayList<String>();
        states.add("Bayern");
        states.add("Hessen");
        states.add("Rheinland-Pfalz");
        statesMap.put("Deutschland", states);
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        String name = "";
        name += first != null ? first + " " : "";
        name += last != null ? last : "";
        return name;
    }

    public List<SelectItem> getCountryItems() {
        List<SelectItem> countryItems = new ArrayList<SelectItem>();
        countryItems.add(new SelectItem(null, "Bitte auswählen", "", false, true, true));
        for (String country : statesMap.keySet()) {
            countryItems.add(new SelectItem(country, country));
        }
        return countryItems;
    }

    public List<SelectItem> getStateItems() {
        List<SelectItem> stateItems = new ArrayList<SelectItem>();

        if (country != null) {
            List<String> statesList = statesMap.get(country);
            if (statesList != null) {
                for (String country : statesList) {
                    stateItems.add(new SelectItem(country, country));
                }
            }
        }
        return stateItems;
    }

    public void changeCountry(ValueChangeEvent ev) {
        state = null;
    }

}
