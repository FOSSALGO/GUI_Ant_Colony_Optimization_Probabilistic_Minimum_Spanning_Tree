package util;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ReadWriteGraph {

    public static boolean writeToFile(File file, Graph graph) {
        boolean result = false;
        try {
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            Point[] position = graph.getPosition();
            float[] probability = graph.getProbabilitasVertex();
            int[][] adjacency = graph.getAdjacency();
            int n = position.length;
            int gridSize = graph.getGridSize();
            int numGridX = graph.getNumGridX();
            int numGridY = graph.getNumGridY();

            printWriter.println("GRAPH ACO_PMST");
            printWriter.println("number of vertices  : " + (n));
            printWriter.println("number of x-grid    : " + (numGridX));
            printWriter.println("number of y-grid    : " + (numGridY));
            printWriter.println("number of cell width: " + (gridSize));
            printWriter.println();
            printWriter.println("POSITION");
            for (int i = 0; i < position.length; i++) {
                printWriter.println((position[i].x) + " " + (position[i].y));
            }
            printWriter.println();
            printWriter.println("PROBABILITY");
            for (int i = 0; i < probability.length; i++) {
                printWriter.println(probability[i]);
            }
            printWriter.println();
            printWriter.println("ADJACENCY");
            for (int i = 0; i < adjacency.length; i++) {
                for (int j = 0; j < adjacency[i].length; j++) {
                    if (j > 0) {
                        printWriter.print(" ");
                    }
                    printWriter.print(adjacency[i][j]);
                }
                printWriter.println();
            }
            result = true;
            printWriter.close();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Graph readFromFile(File file) {
        Graph graph = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            /*membaca data*/
            String thisLine = bufferedReader.readLine();
            System.out.println(thisLine);
            thisLine = bufferedReader.readLine();
            int length = Integer.parseInt(thisLine.split(":")[1].trim());
            thisLine = bufferedReader.readLine();
            int numGridX = Integer.parseInt(thisLine.split(":")[1].trim());
            thisLine = bufferedReader.readLine();
            int numGridY = Integer.parseInt(thisLine.split(":")[1].trim());
            thisLine = bufferedReader.readLine();
            int gridSize = Integer.parseInt(thisLine.split(":")[1].trim());

            Point[] position = new Point[length];
            float[] probability = new float[length];
            int[][] adjacency = new int[length][length];

            /*read position*/
            thisLine = bufferedReader.readLine();
            thisLine = bufferedReader.readLine();
            for (int i = 0; i < length; i++) {
                thisLine = bufferedReader.readLine();
                String[] sPoint = thisLine.split(" ");
                Point point = new Point((Integer.parseInt(sPoint[0].trim())), (Integer.parseInt(sPoint[1].trim())));
                position[i] = point;
            }

            /*read probability*/
            thisLine = bufferedReader.readLine();
            thisLine = bufferedReader.readLine();
            for (int i = 0; i < length; i++) {
                thisLine = bufferedReader.readLine();
                float pi = Float.parseFloat(thisLine.trim());
                probability[i] = pi;
            }

            /*read adjacency*/
            thisLine = bufferedReader.readLine();
            thisLine = bufferedReader.readLine();
            for (int i = 0; i < length; i++) {
                thisLine = bufferedReader.readLine();
                String[] sAdj = thisLine.split(" ");
                for (int j = 0; j < sAdj.length; j++) {
                    int vAdj = Integer.parseInt(sAdj[j].trim());
                    adjacency[i][j] = vAdj;
                }
            }

            /*set Graph*/
            graph = new Graph(position, probability, adjacency, gridSize, numGridX, numGridY);
            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return graph;
    }

}
