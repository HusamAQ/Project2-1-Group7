package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import static game.Graph.player2Score;
import static game.Graph.player1Score;
import static game.Graph.player1Turn;



public class ELine extends JLabel {
    boolean activated = false;
    Dimension d;
    int startX;
    int startY;
    ArrayList<Vertex> vertices;
    public ELine(int w,int h,int x,int y,Color c,ArrayList<Vertex> v){
        vertices=v;
        d = new Dimension(w,h);
        startX=x;
        startY=y;
        setBackground(c);
        setBounds(x,y,w,h);
        setOpaque(true);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(!activated) {
                    activated=true;
                    System.out.println("V0:" + vertices.get(0).id + " V1:" + vertices.get(1).id);
                    setBackground(Color.BLACK);
                    repaint();
                    Graph.matrix[vertices.get(0).id][vertices.get(1).id] = 2;
                    Graph.matrix[vertices.get(1).id][vertices.get(0).id] = 2;
                    ArrayList<ArrayList<Vertex>> boxes = checkBox();
                    if (boxes != null) {
                        for (ArrayList<Vertex> box : boxes) {
                            System.out.println("BOX: " + box.get(0).id + "," + box.get(1).id + "," + box.get(2).id + "," + box.get(3).id);
                            if (player1Turn) {
                                player1Score++;
                                Graph.score1.setScore();
                                System.out.println("Player 1: " + player1Score);
                            } else {
                                player2Score++;
                                Graph.score2.setScore();
                                System.out.println("Player 2: " + player2Score);
                            }
                        }
                    } else {
                        if (player1Turn) {
                            player1Turn = false;
                        } else {
                            player1Turn = true;
                        }
                    }
                }
            }
        });
    }
    public ArrayList<ArrayList<Vertex>> checkBox(){
        ArrayList<ArrayList<Vertex>> listOfBoxes = new ArrayList<>();
        if(vertices.get(1).id-vertices.get(0).id==1){
            if(vertices.get(0).upVertex!=null){
                if(Graph.matrix[vertices.get(0).id][vertices.get(0).upVertex.id]==2&&Graph.matrix[vertices.get(1).id][vertices.get(1).upVertex.id]==2&&Graph.matrix[vertices.get(0).upVertex.id][vertices.get(1).upVertex.id]==2){
                    ArrayList<Vertex> box = new ArrayList<>();
                    box.add(vertices.get(0));
                    box.add(vertices.get(1));
                    box.add(vertices.get(0).upVertex);
                    box.add(vertices.get(1).upVertex);
                    listOfBoxes.add(box);
                }
            }
            if(vertices.get(0).downVertex!=null){
                if(Graph.matrix[vertices.get(0).id][vertices.get(0).downVertex.id]==2&&Graph.matrix[vertices.get(1).id][vertices.get(1).downVertex.id]==2&&Graph.matrix[vertices.get(0).downVertex.id][vertices.get(1).downVertex.id]==2){
                    ArrayList<Vertex> box2 = new ArrayList<>();
                    box2.add(vertices.get(0));
                    box2.add(vertices.get(1));
                    box2.add(vertices.get(0).downVertex);
                    box2.add(vertices.get(1).downVertex);
                    listOfBoxes.add(box2);
                }
            }
        }else{
            if(vertices.get(0).rightVertex!=null){
                if(Graph.matrix[vertices.get(0).id][vertices.get(0).rightVertex.id]==2&&Graph.matrix[vertices.get(1).id][vertices.get(1).rightVertex.id]==2&&Graph.matrix[vertices.get(0).rightVertex.id][vertices.get(1).rightVertex.id]==2){
                    ArrayList<Vertex> box3 = new ArrayList<>();
                    box3.add(vertices.get(0));
                    box3.add(vertices.get(1));
                    box3.add(vertices.get(0).rightVertex);
                    box3.add(vertices.get(1).rightVertex);
                    listOfBoxes.add(box3);
                }
            }
            if(vertices.get(0).leftVertex!=null){
                if(Graph.matrix[vertices.get(0).id][vertices.get(0).leftVertex.id]==2&&Graph.matrix[vertices.get(1).id][vertices.get(1).leftVertex.id]==2&&Graph.matrix[vertices.get(0).leftVertex.id][vertices.get(1).leftVertex.id]==2){
                    ArrayList<Vertex> box4 = new ArrayList<>();
                    box4.add(vertices.get(0));
                    box4.add(vertices.get(1));
                    box4.add(vertices.get(0).leftVertex);
                    box4.add(vertices.get(1).leftVertex);
                    listOfBoxes.add(box4);
                }
            }
        }
        if(listOfBoxes.isEmpty()){
            return null;
        }
        System.out.println(listOfBoxes.size());
        for(ArrayList<Vertex> box:listOfBoxes){
            System.out.println(box.get(0).id+box.get(1).id+box.get(2).id+box.get(3).id);
        }
        return listOfBoxes;
    }
}
