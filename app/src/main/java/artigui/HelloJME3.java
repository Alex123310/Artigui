package artigui;

import com.jme3.app.SimpleApplication;
import com.jme3.light.DirectionalLight;
import com.jme3.math.Vector3f;
import com.jme3.scene.Spatial;

public class HelloJME3 extends SimpleApplication {

    public void Visualizza(){
        HelloJME3 app = new HelloJME3();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        Spatial teapot = assetManager.loadModel("Models/Teapot/Teapot.obj");

        teapot.scale(0.1f, 0.1f, 0.1f);
        teapot.rotate(0.0f, 3.0f, 0.0f);
        teapot.setLocalTranslation(0.0f, -1.0f, -2.0f);

        rootNode.attachChild(teapot);

        DirectionalLight sun = new DirectionalLight();
        sun.setDirection(new Vector3f(-1.0f, -0.5f, -1.0f));

        rootNode.addLight(sun);
    }
}