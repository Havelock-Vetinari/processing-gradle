package pl.net.julian.processing;

import processing.core.PApplet;
import processing.video.Capture;

public class App extends PApplet {

    private Capture video;

    public static void main(String[] args) {
        PApplet.main(App.class, args);
    }

    public void settings() {
        size(480, 320);
    }

    public void setup() {
        String[] cameras = Capture.list();
        if (cameras.length == 0) {
            println("There are no cameras available for capture.");
            exit();
        } else {
            println("Available cameras:");
            for (String camera : cameras) {
                println(camera);
            }
        }
        video = new Capture(this, this.width, this.height, cameras[0], 30);
        video.start();
    }

    public void draw() {
        image(video, 0, 0);
        noFill();
    }

    public void captureEvent(Capture c) {
        c.read();
    }
}
