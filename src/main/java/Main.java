import Controllers.MainController;

import java.io.IOException;
import java.text.ParseException;

public class Main {

    // Createing main class
    public static void main(String[] args) throws IOException, ParseException {
        MainController mainController = new MainController();
        mainController.run();
    }

}
