/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GenericColorAlgorithm;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author viva
 */
public class Population {

    Random rand = new Random();
    GeneticAlgorithm ga = new GeneticAlgorithm();
    int GenerationCounter = 0;
    public static List<Chromosone> list = new ArrayList<>(100);
    public static List<Chromosone> finalList = new ArrayList<>(50);
    int treshold = 10000;
    double targetFitness = 0;
    public static Color desiredColor;

    public int getGenerationCounter() {
        return GenerationCounter;
    }

    public static void setDesiredColor(Color desiredColor) {
        Population.desiredColor = desiredColor;
    }
    
    public List<Chromosone> populate(int chromosomes) {
        GenerationCounter++;
        for (int i = 0; i < chromosomes - finalList.size(); i++) {
            Chromosone chrom = new Chromosone(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            if (ga.evaluateFitness(desiredColor, chrom) < treshold) {
                list.add(chrom);
            }
        }
        return list;
    }

    public static double averageFitness(List<Chromosone> list) {
        double average = 0;
        for (Chromosone ch : list) {
            average = average + ch.getFitness();
        }
        return average / list.size();
    }

    public boolean crossoversBestAndWorst(double probiability) {
        if (rand.nextDouble() > probiability) {
            int size = list.size();
            for (int i = 0; i < size / 2; i++) {
                finalList.add(ga.crossover(list.get(i), list.get((size - 1) - i)));
            }
            takeBest(finalList);
            return true;
        }
        return false;
    }

    public boolean crossoverBest(double probiability) {
        if (rand.nextDouble() > probiability) {
            int size = list.size();
            for (int i = 0; i < size; i = i + 2) {
                finalList.add(ga.crossover(list.get(i), list.get(i++)));
            }
           // checkIfEven(size, list);
            takeBest(finalList);
            return true;
        }
        return false;
    }
    public void crossoverBest() {
            int size = list.size();
            for (int i = 0; i < size; i = i + 2) {
                finalList.add(ga.crossover(list.get(i), list.get(i++)));
            }
            takeBest(finalList);
    }

    public Chromosone takeBest(List<Chromosone> list) {
        Collections.sort(list);
        if(list.size() >= 6){
            list = list.subList(0, list.size() / 2);
        }
        targetFitness = list.get(0).getFitness();
        return list.get(0);
    }
 
}
