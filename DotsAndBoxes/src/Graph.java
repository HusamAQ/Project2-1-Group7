import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
    int[][] matrix;
    List<Vertex> vertexList;
    List<Edge> edgeList;
    int height;
    int width;
    Group group;
    public Graph(int h, int w){
        height=h;
        width=w;
    }
    public void createGraph(){
        vertexList= new ArrayList<>();
        int id=0;
        for(int w=0;w<height*width;w++){
            vertexList.add(new Vertex(id));
            id++;
        }
        matrix= new int[vertexList.size()][vertexList.size()];
        id=0;
        for(int l=0;l<height;l++){
            for(int e=0;e<width;e++){
                Vertex temp = vertexList.get(id);
                if(e!=0){
                    temp.setLeftVertex(vertexList.get(id-1));
                }
                if(e!=width-1){
                    temp.setRightVertex(vertexList.get(id+1));
                }
                if(l!=0){
                    temp.setUpVertex(vertexList.get(id-width));
                }
                if(l!=height-1){
                    temp.setDownVertex(vertexList.get(id+width));
                }
                vertexList.set(id,temp);
                id++;
            }
        }
        for (Vertex a:vertexList) {
            System.out.println(a);
        }
        for (Vertex a:vertexList) {
            if(a.leftVertex!=null){
                matrix[a.id][a.leftVertex.id]=1;
            }
            if(a.rightVertex!=null){
                matrix[a.id][a.rightVertex.id]=1;
            }
            if(a.upVertex!=null){
                matrix[a.id][a.upVertex.id]=1;
            }
            if(a.downVertex!=null){
                matrix[a.id][a.downVertex.id]=1;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        edgeList= new ArrayList<>();
        int[][] matrixCopy = matrix;
        for(int r=0;r<matrix.length;r++){
            for(int q=0;q<matrix[0].length;q++){
                if(matrixCopy[r][q]==1){
                    edgeList.add(new Edge(vertexList.get(r), vertexList.get(q)));
                    matrixCopy[q][r]=3;
                }
            }
        }
        for(Edge ed:edgeList){
            System.out.println(ed);
        }
    }
    public void setGroup(Group a){
        group=a;
    }

    public class Edge {
        ArrayList<Vertex> vertices;
        Line line;
        public Edge(Vertex one, Vertex two){
            vertices=new ArrayList<>();
            vertices.add(one);
            vertices.add(two);
        }
        public void createLine(){
            line = new Line();
            line.setStartX(vertices.get(0).width);
            line.setStartY(vertices.get(0).height);
            line.setEndX(vertices.get(1).width);
            line.setEndY(vertices.get(1).height);
            line.setStroke(Color.GRAY);
            line.setStrokeWidth(5);
            EventHandler<MouseEvent> eventHandler = new EventHandler() {
                @Override
                public void handle(Event event) {
                    line.setStroke(Color.BLACK);
                    System.out.println(Edge.this.toString());
                    matrix[vertices.get(0).id][vertices.get(1).id]=2;
                    matrix[vertices.get(1).id][vertices.get(0).id]=2;
                    ArrayList<ArrayList<Vertex>> boxes = checkBox();
                    if(boxes!=null){
                        for(ArrayList<Vertex> box:boxes){
                            Text text = new Text();
                            text.setText("BOX ");
                            text.setX((box.get(0).width+box.get(1).width+box.get(2).width+box.get(3).width)/4);
                            text.setY((box.get(0).height+box.get(1).height+box.get(2).height+box.get(3).height)/4);
                            text.setFont(Font.font(30));
                            group.getChildren().add(text);
                            Main.setGroup(group);
                            Main.callMain();
                        }
                    }
                }
            };
            line.addEventHandler(MouseEvent.MOUSE_CLICKED,eventHandler);
        }
        public ArrayList<ArrayList<Vertex>> checkBox(){
            ArrayList<ArrayList<Vertex>> listOfBoxes = new ArrayList<>();
            if(vertices.get(1).id-vertices.get(0).id==1){
                if(vertices.get(0).upVertex!=null){
                    if(matrix[vertices.get(0).id][vertices.get(0).upVertex.id]==2&&matrix[vertices.get(1).id][vertices.get(1).upVertex.id]==2&&matrix[vertices.get(0).upVertex.id][vertices.get(1).upVertex.id]==2){
                        ArrayList<Vertex> box = new ArrayList<>();
                        box.add(vertices.get(0));
                        box.add(vertices.get(1));
                        box.add(vertices.get(0).upVertex);
                        box.add(vertices.get(1).upVertex);
                        listOfBoxes.add(box);
                    }
                }
                if(vertices.get(0).downVertex!=null){
                    if(matrix[vertices.get(0).id][vertices.get(0).downVertex.id]==2&&matrix[vertices.get(1).id][vertices.get(1).downVertex.id]==2&&matrix[vertices.get(0).downVertex.id][vertices.get(1).downVertex.id]==2){
                        ArrayList<Vertex> box = new ArrayList<>();
                        box.add(vertices.get(0));
                        box.add(vertices.get(1));
                        box.add(vertices.get(0).downVertex);
                        box.add(vertices.get(1).downVertex);
                        listOfBoxes.add(box);
                    }
                }
            }else{
                if(vertices.get(0).rightVertex!=null){
                    if(matrix[vertices.get(0).id][vertices.get(0).rightVertex.id]==2&&matrix[vertices.get(1).id][vertices.get(1).rightVertex.id]==2&&matrix[vertices.get(0).rightVertex.id][vertices.get(1).rightVertex.id]==2){
                        ArrayList<Vertex> box = new ArrayList<>();
                        box.add(vertices.get(0));
                        box.add(vertices.get(1));
                        box.add(vertices.get(0).upVertex);
                        box.add(vertices.get(1).upVertex);
                        listOfBoxes.add(box);
                    }
                }
                if(vertices.get(0).leftVertex!=null){
                    if(matrix[vertices.get(0).id][vertices.get(0).leftVertex.id]==2&&matrix[vertices.get(1).id][vertices.get(1).leftVertex.id]==2&&matrix[vertices.get(0).leftVertex.id][vertices.get(1).leftVertex.id]==2){
                        ArrayList<Vertex> box = new ArrayList<>();
                        box.add(vertices.get(0));
                        box.add(vertices.get(1));
                        box.add(vertices.get(0).leftVertex);
                        box.add(vertices.get(1).leftVertex);
                        listOfBoxes.add(box);
                    }
                }
            }
            if(listOfBoxes.size()==0){
                listOfBoxes=null;
            }
            return listOfBoxes;
        }
        public String toString(){
            return vertices.get(0).id + " -- "+ vertices.get(1).id+". ";
        }
    }
}
