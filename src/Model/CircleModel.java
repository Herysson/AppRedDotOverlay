package Model;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.io.*;
import java.util.Arrays;

public class CircleModel implements Serializable{
    private int centerX;
    private int centerY;
    private int radius;
    private Color color;
    private int colorIndex = 0;
    private static final Color[] colors = {Color.RED, Color.GREEN, Color.BLUE};
    public CircleModel(int centerX, int centerY, int radius, Color color) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.color = color;
    }
    public int getCenterX() {
        return centerX;
    }
    public int getCenterY() {
        return centerY;
    }
    public Color getColor() {
        return color;
    }
    public void setCenterX(int x) {
        centerX = x;
    }
    public void setCenterY(int y) {
        centerY = y;
    }
    public void changeSize(){
        int[] sizes = {2, 4, 6, 8, 10}; // Array de tamanhos diferentes
        int currentIndex = Arrays.binarySearch(sizes, radius); // Encontra o índice do tamanho atual no array

        if (currentIndex >= 0) { // Se o tamanho atual estiver no array
            currentIndex = (currentIndex + 1) % sizes.length; // Avança para o próximo tamanho no array
        } else { // Se o tamanho atual não estiver no array
            currentIndex = 0; // Define o primeiro tamanho do array como o novo tamanho
        }
        radius = sizes[currentIndex]; // Define o novo tamanho
    }
    public void changeColor() {
        colorIndex = (colorIndex + 1) % colors.length;
        color = colors[colorIndex];
    }
    public Ellipse2D getShape() {
        return new Ellipse2D.Double(centerX - radius, centerY - radius, radius * 2, radius * 2);
    }
    public void saveConfiguration(String arquivo){
        //criar um comando para salvar a configuração
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(arquivo));
            outputStream.writeObject(this);
            outputStream.close();
            JOptionPane.showMessageDialog(null,"Configurações salvas com sucesso.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar as configurações: "
                    + e.getMessage());
        }
    }
    public static CircleModel loadConfigurationToFile(String arquivo) {
        //sempre que o programa for aberto fazer load da configuração.
        CircleModel circleModel = null;
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(arquivo));
            circleModel = (CircleModel) inputStream.readObject();
            inputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,"Erro ao carregar as configurações: "
                    + e.getMessage());
        }
        return circleModel;
    }
}
