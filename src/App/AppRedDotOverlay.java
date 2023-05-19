package App;

import Controller.MenuController;
import Model.CircleModel;
import View.AppView;

import java.awt.*;

public class AppRedDotOverlay {
    public static void main(String[] args) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) (screenSize.getWidth()/2);
        int centerY = (int) (screenSize.getHeight()/2);

        CircleModel circle = CircleModel.loadConfigurationToFile("configuration.ser");
        if(circle==null){
            circle = new CircleModel(centerX,centerY,6,Color.RED);
        }

        AppView view = new AppView(circle);
        MenuController controller = new MenuController(view, circle);

        view.addKeyListener(controller);
    }
}
