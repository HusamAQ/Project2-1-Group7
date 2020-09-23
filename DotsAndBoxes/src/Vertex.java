import javafx.scene.shape.Circle;

public class Vertex {
    int id;
    Vertex leftVertex=null;
    Vertex rightVertex=null;
    Vertex upVertex=null;
    Vertex downVertex=null;
    Circle circle;
    int height;
    int width;
    public Vertex(Vertex left, Vertex right, Vertex up, Vertex down){
        leftVertex=left;
        rightVertex=right;
        upVertex=up;
        downVertex=down;
    }
    public Vertex(int id){
        this.id=id;
    }
    public void setLeftVertex(Vertex leftVertex) {
        this.leftVertex = leftVertex;
    }

    public void setRightVertex(Vertex rightVertex) {
        this.rightVertex = rightVertex;
    }

    public void setUpVertex(Vertex upVertex) {
        this.upVertex = upVertex;
    }

    public void setDownVertex(Vertex downVertex) {
        this.downVertex = downVertex;
    }
    public void setPosition(int Gwidth, int Gheight){
        int widthM=900/(Gwidth-1);
        int heightM=900/(Gheight-1);
        width=50+(id%Gwidth)*widthM;
        height=50+(id/Gwidth)*heightM;
    }
    public void createCircle(){
        circle=new Circle();
        circle.setCenterX(width);
        circle.setCenterY(height);
        circle.setRadius(10);
    }
    public String toString(){
        String toReturn = "ID: "+id;
        if(rightVertex!=null){
            toReturn+=". Right: "+rightVertex.id;
        }
        if(leftVertex!=null){
            toReturn+=". Left: "+leftVertex.id;
        }
        if(downVertex!=null){
            toReturn+=". Down: "+downVertex.id;
        }
        if(upVertex!=null){
            toReturn+=". Up: "+upVertex.id;
        }
        return toReturn;
    }
}
