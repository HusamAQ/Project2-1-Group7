import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    static Group group = new Group();
    public static void setGroup(Group g){
        group=g;
    }
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Graph test = new Graph(3,3);
        test.createGraph();
        for(int h=0;h<test.vertexList.size();h++){
            test.vertexList.get(h).setPosition(test.width,test.height);
            test.vertexList.get(h).createCircle();
            group.getChildren().addAll(test.vertexList.get(h).circle);
        }
        for(int w=0;w<test.edgeList.size();w++){
            test.edgeList.get(w).createLine();
            group.getChildren().addAll(test.edgeList.get(w).line);
        }
        test.setGroup(group);
        Scene scene = new Scene(group,1000,1000);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Dots and Boxes");
        primaryStage.show();
    }
    static void callMain(){
        main(null);
    }
}
