
package projeto_opengl.model;

import com.jogamp.opengl.GL2;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;



public class Ferramentas {
    
    public float Gerador(){
        Random r = new Random();
        int num = r.nextInt(5);
        if(r.nextInt(2) == 0){
            return ((float)(num * 2)) / 10;
        }else {
            return ((float)(num * -2)) / 10;
        }
    }
    
    public void limparTela(GL2 gl){
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
    }
    
    public void sleep(int seg) throws InterruptedException {
        Thread.sleep(seg * 100);
    }
    

}
