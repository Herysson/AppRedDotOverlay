package View;

import Model.CircleModel;

import javax.swing.*;
import java.awt.*;

public class AppView extends JFrame {
    private final CircleModel circle;
    private JPanel menuPanel;
    private String htmlMenu;
    public AppView(CircleModel circle) {
        this.circle = circle;
        criaHtmlMenu();
        initComponents();
    }
    private void initComponents(){
        // Configurações do JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));

        // Cria a fonte e define o tamanho
        Font font = new Font("Arial", Font.BOLD, 20);
        // Cria a cor e a define
        Color color = Color.WHITE;

        // Criação dos JPanels
        DrawingPanel drawingPanel = new DrawingPanel(circle);
        menuPanel = new JPanel();

        // Cria um JLabel com a mensagem a ser exibida no menu
        JLabel messageLabel = new JLabel(htmlMenu);

        // Define a fonte e a cor do JLabel
        messageLabel.setFont(font);
        messageLabel.setForeground(color);

        // Configuração do drawingPanel (transparente)
        drawingPanel.setBackground(new Color(0, 0, 0, 0));
        drawingPanel.setLayout(null); // Layout nulo para posicionamento absoluto

        // Configuração do menuPanel (preto)
        menuPanel.setBackground(Color.BLACK);
        menuPanel.setSize(250, 320);

        // Posicionamento do menuPanel no canto superior direito
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = screenSize.width - menuPanel.getWidth()-15;
        menuPanel.setLocation(x, 15);

        // Adiciona os JPanels ao JFrame
        menuPanel.add(messageLabel);
        drawingPanel.add(menuPanel);
        add(drawingPanel);

        //deixa a tela sempre a frente
        setAlwaysOnTop(true);
        // Exibe a tela
        setVisible(true); // Adicionado

        // Define o tamanho da tela após torná-la visível
        setSize(screenSize.width, screenSize.height);
    }
    public void changeMenuVisibility(){
        menuPanel.setVisible(!menuPanel.isVisible());
    }
    private void criaHtmlMenu(){
        this.htmlMenu = "<html>"
                + "<h1>&nbsp DOT OVERLAY V1</h1>"
                + "<table>"
                + "<tr>"
                + "<td>F2</td>"
                + "<td>Hide/Show Menu</td>"
                + "</tr>"
                + "<tr>"
                + "<td>&nbsp Z</td>"
                + "<td>Change Color</td>"
                + "</tr>"
                + "<tr>"
                + "<td>&nbsp C</td>"
                + "<td>Change Size</td>"
                + "</tr>"
                + "<tr>"
                + "<td>&uarr&darr</td>"
                + "<td>Change VPosition</td>"
                + "</tr>"
                + "<tr>"
                + "<td>&larr&rarr</td>"
                + "<td>Change HPosition</td>"
                + "</tr>"
                + "<tr>"
                + "<td>F3</td>"
                + "<td>Save Configuration</td>"
                + "</tr>"
                + "<tr>"
                + "<td>F9</td>"
                + "<td>Reset Configuration</td>"
                + "</tr>"
                + "<tr>"
                + "<td>F4</td>"
                + "<td>Exit DotOverlay</td>"
                + "</tr>"
                + "</table>"
                + "</html>";
    }
}
