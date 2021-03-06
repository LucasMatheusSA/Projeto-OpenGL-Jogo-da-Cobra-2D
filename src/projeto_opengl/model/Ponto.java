
package projeto_opengl.model;

import com.jogamp.opengl.GL2;



public class Ponto  {
    
    public void draw(GL2 gl,float x, float y){
        gl.glBegin(GL2.GL_QUADS);  
        
        gl.glColor3f( 0.0f,1.0f,0.0f );  
        
        gl.glVertex2d(x + 0.1, y);
        gl.glVertex2d(x , y - 0.1);
        gl.glVertex2d(x + 0.1, y - 0.2);
        gl.glVertex2d(x + 0.2, y - 0.1);  
      
        gl.glEnd(); 
        gl.glFlush();
    }
    
    public void setPonto(GL2 gl){
        Ferramentas F = new Ferramentas();
        Grid G = new Grid();
        float num1, num2,X,Y;
        do{
            X = F.Gerador();
            Y = F.Gerador();
            num1 = ((X * 10) / 2) + 5;
            num2 = ((((Y * 10) / 2) + 4) - 9) * -1;
        }while(G.checkPosition((int) num2,(int) num1) != 0);
        G.setPosition(1,(int) num2,(int) num1);
        draw(gl,X,Y);
    }
}
