package game;

import graphics.Paths;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

import static game.Graph.player1Score;
import static game.Graph.player2Score;

public class paintBoard extends JPanel {
    Graph graph;
    public paintBoard(Graph gr){
        graph=gr;
        this.setLayout(null);
        this.setBackground(Color.WHITE);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        for(int h=0;h<graph.vertexList.size();h++) {
            graph.vertexList.get(h).setPosition(graph.width, graph.height);
            graph.vertexList.get(h).createCircle();
        }
        for(int w=0;w<graph.edgeList.size();w++){
            graph.edgeList.get(w).createLine();
            this.add(graph.edgeList.get(w).line);
        }
        for(int h=0;h<graph.vertexList.size();h++) {
            g2.fill(graph.vertexList.get(h).circle);
        }
        this.add(Graph.score1);
        this.add(Graph.score2);
    }
}
