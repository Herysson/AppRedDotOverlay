package Controller;


import Model.CircleModel;
import View.AppView;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MenuController implements KeyListener {
    private final AppView view;
    private final CircleModel circle;
    public MenuController(AppView view, CircleModel circle) {
        this.view = view;
        this.circle = circle;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_F2:
                //Muda a visibilidade do Menu
                view.changeMenuVisibility();
                break;
            case KeyEvent.VK_Z:
                // Executa ação para Z - Change Color
                circle.changeColor();
                break;
            case KeyEvent.VK_X:
                // Executa ação para X - Change Shape
                break;
            case KeyEvent.VK_C:
                // Executa ação para C - Change Size
                circle.changeSize();
                break;
            case KeyEvent.VK_F3:
                // Executa ação para F3 - Exit DotOverlay
                System.exit(0);
                break;
            case KeyEvent.VK_LEFT:
                circle.setCenterX(circle.getCenterX()-1);
                break;
            case KeyEvent.VK_RIGHT:
                circle.setCenterX(circle.getCenterX()+1);
                break;
            case KeyEvent.VK_UP:
                circle.setCenterY(circle.getCenterY()-1);
                break;
            case KeyEvent.VK_DOWN:
                circle.setCenterY(circle.getCenterY()+1);
                break;
            default:
                break;
        }
        view.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
