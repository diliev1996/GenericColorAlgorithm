/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GenericColorAlgorithm;

import java.util.Random;

/**
 *
 * @author viva
 */
public class Chromosone implements Comparable<Object>{

    int[] genes = new int[3];
    Random rand = new Random();
    double fitness;

    public Chromosone(int red, int green, int blue) {
        setRed(red);
        setGreen(green);
        setBlue(blue);
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public void mutate() {
        for (int i = 0; i < genes.length; i++) {
            if (rand.nextInt(100) <= 5) {
                setRed(rand.nextInt(256));
                setGreen(rand.nextInt(256));
                setBlue(rand.nextInt(256));
            }
        }
    }

    public Chromosone() {
    }

    public int getBlue() {
        return genes[2];
    }

    public int getGreen() {
        return genes[1];
    }

    public int getRed() {
        return genes[0];
    }

    public void setGreen(int green) {
        genes[1] = green;
    }

    public void setBlue(int blue) {
        genes[2] = blue;
    }

    public void setRed(int red) {
        genes[0] = red;
    }

    @Override
    public String toString() {
        return "Red is " + genes[0] + " Green is " + genes[1] + " Blue is " + genes[2];
    }

    @Override
    public int compareTo(Object o) {
      Chromosone that = (Chromosone)o;
      return (int) (this.fitness - that.fitness);
    }

}
