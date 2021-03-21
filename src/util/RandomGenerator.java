package util;

public class RandomGenerator {

    public static int randomBetweenInt(int min, int max) {
        return (int) (min + Math.random() * (max - min + 1));
    }

    public static float randomBetweenFloat(float min, float max) {
        return (float) (min + (max - min) * Math.random());
    }

    public static double randomBetweenDouble(double min, double max) {
        return (double) (min + (max - min) * Math.random());
    }

    public static boolean randomBoolean() {
        boolean rndBoolean = false;
        float max = randomBetweenFloat(10.0f, 1000.0f);
        if (randomBetweenFloat(0.0f, max) >= max / 2.0f) {
            rndBoolean = true;
        }
        return rndBoolean;
    }
}
