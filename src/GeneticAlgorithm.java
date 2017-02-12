/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GenericColorAlgorithm;

import java.awt.Color;
import java.util.Random;

/**
 *
 * @author viva
 */
class GeneticAlgorithm {
 
    public double evaluateFitness(Color idealColor, Chromosone a) {

        int red = checkIfZero(Math.abs(idealColor.getRed() - a.getRed()));
        int green = checkIfZero(Math.abs(idealColor.getGreen() - a.getGreen()));
        int blue = checkIfZero(Math.abs(idealColor.getBlue() - a.getBlue()));
        double fitness = (red * green * blue) / 3;
        a.setFitness(fitness);
        return Math.round(fitness);
    }

    private int checkIfZero(int i) {
        if (i != 0) {
            return i;
        } else {
            return 1;
        }
    }

    public Chromosone crossover(Chromosone a, Chromosone b) {
        Chromosone c = new Chromosone();
        Random r = new Random();
        for (int i = 0; i < 3; i++) {
           int max = Math.max(a.genes[i], b.genes[i]);
           int min = Math.min(a.genes[i], b.genes[i]);
            if (max != min) {
                c.genes[i] = r.nextInt(max - min) + min;
            } else {
                c.genes[i] = r.nextInt(256);
            }
        }
        c.setFitness(evaluateFitness(Population.desiredColor, c));
        return c;
    }
}
