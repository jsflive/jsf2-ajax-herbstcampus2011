package at.irian.herbstcampus2011;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class HelloController {
    private String name;
    private String greeting;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGreeting() {
        return greeting;
    }

    public String sayHello() {
        if (name == null || name.isEmpty()) {
            greeting = null;
        } else {
            greeting = "Hello " + name;
        }
        return null;
    }

}
