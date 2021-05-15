package warCalculator;

import java.util.*;

public class DisplayManager {
    private final int width, height;
    // the characters that will get drawn on-screen
    private char[][] characters;

    public DisplayManager(int width, int height) {
        this.width = width;
        this.height = height;

        characters = new char[height][width];
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

    public void clear() {
        for (int row = 0; row < characters.length; row ++) {
            for (int col = 0; col < characters[row].length; col ++) {
                characters[row][col] = ' ';
            }
        }
    }

    public void render() throws Exception {
        // emptying display
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

        // rendering data
        for (char[] row : characters) {
            for (char col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    public void drawCharacter(char character, int x, int y) {
        if (height > y && width > x && x > -1 && y > -1) {
            characters[y][x] = character;
        }
    }

    public void drawText(String message, int x, int y) {
        char[] messageSplit = message.toCharArray();

        for (int character = 0; character < messageSplit.length; character ++) {
            drawCharacter(messageSplit[character], x + character, y);
        }
    }
    public void drawCenteredText(String message, int x, int y) {
        drawText(message, x - message.length() / 2, y);
    }

    public void drawHorizontalLine(int y, int startX, int endX) {
        for (int x = startX; x <= endX; x++) {
            drawCharacter('-', x, y);
        }
    }
    public void drawVerticalLine(int x, int startY, int endY) {
        for (int y = startY; y <= endY; y++) {
            drawCharacter('|', x, y);
        }
    }
    public void drawRect(int x, int y, int width, int height) {
        drawHorizontalLine(y, x, x + width - 1); // top line
        drawHorizontalLine(y + height - 1, x, x + width - 1); // bottom line
        drawVerticalLine(x, y, y + height - 1); // left line
        drawVerticalLine(x + width - 1, y, y + height - 1); // right line
    }

    /**
     * used to show the viewer how big the window is
     * if their terminal is too small they'll know it
     */

    public void displayWindowSize() throws Exception {
        // drawing window dimensions
        clear();

        drawRect(0, 0, width, height);
        drawCenteredText("These are the window dimensions; resize terminal accordingly", Math.round(width / 2), Math.round(height / 2));
        drawCenteredText("Press <enter> to continue", Math.round(width / 2), Math.round(height / 2) + 1);

        render();

        waitTillEnter();
    }

    public void waitTillEnter() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}