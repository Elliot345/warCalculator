package warCalculator;

import warCalculator.countries.Country;

public class Main {
    String[] names = new String[] {null, null, null, null};
    Country[] countries = new Country[] {null, null, null, null};
    DisplayManager dm;
    boolean running;

    public void run() throws Exception {
        dm = new DisplayManager(80, 10);

        while (running) {
            dm.clear();

            for (byte i = 0; i < names.length; i ++) {
                if (names[i] == null) {
                    dm.drawText("Player " + (i + 1) + ": Null", 1, i + 1);
                    dm.drawText("Press " + (i + 1), 20, i + 1);
                } else {
                    dm.drawText(names[i] + ": " + countries[i].getDisplayName(), 1, i + 1);
                }
            }

            dm.render();
        }
    }

    public byte fight(int team1Strength, int team2Strength) {
        if (getRandomNumber(1, team1Strength + team2Strength) < team1Strength) {
            return 1;
        } else {
            return 2;
        }
    }

    public int getRandomNumber(int min, int max) {
        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();

        main.running = true;
        main.run();
    }
}
