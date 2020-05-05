
package projeto_opengl;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jogamp.opengl.GLWorkerThread.start;
import projeto_opengl.arquivo.Arquivo;
import projeto_opengl.model.Cobra;
import projeto_opengl.model.Ferramentas;
import projeto_opengl.model.Grid;
import projeto_opengl.model.Obstaculo;
import projeto_opengl.model.Ponto;


public class Designer implements GLEventListener, KeyListener {
    
    int tamanhoC = 0;
    Grid grid = new Grid();
    Ferramentas F = new Ferramentas();
    Obstaculo Ob = new Obstaculo();
    Ponto P = new Ponto();
    Cobra c = new Cobra();
    Arquivo arq = new Arquivo();
    boolean zerar = false;
    
    @Override
    public void display(GLAutoDrawable glad) {
        final GL2 gl = glad.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
        
        
        try {
            F.sleep(5);
        } catch (InterruptedException ex) {
            Logger.getLogger(Designer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(zerar == true){
            c.cleanCobra();
            grid.cleanMatriz();
            grid.setStatus(false);
            grid.gameOver = false;
            zerar = false;
        }
        
        if(grid.cheakGameOver() == true){
            grid.drawGameOver(gl);
            
        }
        
        if(grid.status == false && tamanhoC == 0){
            grid.setStatus(true);
            c.init();
            tamanhoC = c.getTamanho();
            P.setPonto(gl);
        }
        
        c.draw(gl);
        grid.draw(gl);
        grid.printMatriz();
        c.printCobra();
        
        if(tamanhoC != c.getTamanho()){
            tamanhoC = c.getTamanho();
            P.setPonto(gl);
            Ob.setObstaculo(gl);
        }
        
        c.cleanDraw();
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        
        if(!grid.cheakGameOver()){
            switch (ke.getKeyCode()){
                case 37:
                    c.Esquerda(grid);
                    break;
                case 38:
                    c.Cima(grid);
                    break;
                case 39:
                    c.Direita(grid);
                    break;
                case 40:
                    c.Baixo(grid);
                    break;

                default:
            }
        }
    }
    
    
    @Override
    public void init(GLAutoDrawable glad) {
        glad.getGL().setSwapInterval(1);
    }

    @Override
    public void dispose(GLAutoDrawable glad) {
    }


    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }


    @Override
    public void keyReleased(KeyEvent ke) {
    }
    
}
