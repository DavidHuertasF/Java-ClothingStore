
package run;
import controllers.Controller;
import models.ErroridNotFound;
public class Run {
    public static void main(String[] args) throws ErroridNotFound {
        new Controller();
    }
}
