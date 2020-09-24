package game;


import graphics.Paths;

import javax.swing.*;
import java.awt.*;

public class GameBoard {
    JFrame frame;
    Graph graph;
    paintBoard panel;
    public GameBoard(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        graph = new Graph(30,20);
        graph.createGraph();
        panel = new paintBoard(graph);
        frame.setSize(Paths.FRAME_WIDTH,Paths.FRAME_HEIGHT);
        frame.setResizable(false);
        frame.add(panel);
        frame.setVisible(true);
    }
}
