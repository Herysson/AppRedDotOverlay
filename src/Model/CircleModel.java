package Model;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class CircleModel {
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
    public void saveConfigurationToFile(){
        //criar um comando para salvar a configuração
        try {
            FileWriter writer = new FileWriter("circleConfig.txt");
            writer.write(color.getRed() + "\n");
            writer.write(color.getGreen() + "\n");
            writer.write(color.getBlue() + "\n");
            writer.write(centerX + "\n");
            writer.write(centerY + "\n");
            writer.write(radius + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadConfigurationToFile() {
        //sempre que o programa for aberto fazer load da configuração.
    }
}
