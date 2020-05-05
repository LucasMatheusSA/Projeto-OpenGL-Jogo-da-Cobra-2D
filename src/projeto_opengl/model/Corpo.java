
package projeto_opengl.model;

import com.jogamp.opengl.GL2;

public class Corpo {
    double X1,Y1,X2,Y2,X3,Y3,X4,Y4;
    
    public void draw(GL2 gl,float x, float y){
        gl.glBegin(GL2.GL_QUADS);  
        
        gl.glColor3f( 0.0f, 0.0f, 1.0f );  
      
        gl.glVertex2d(x , y);
        gl.glVertex2d(x , y - 0.2);
        gl.glVertex2d(x + 0.2, y - 0.2);
        gl.glVertex2d(x + 0.2, y );  
      
        gl.glEnd();  
    }

    public void setX1(double X1) {
        this.X1 = X1;
    }

    public void setY1(double Y1) {
        this.Y1 = Y1;
    }

    public void setX2(double X2) {
        this.X2 = X2;
    }

    public void setY2(double Y2) {
        this.Y2 = Y2;
    }

    public void setX3(double X3) {
        this.X3 = X3;
    }

    public void setY3(double Y3) {
        this.Y3 = Y3;
    }

    public void setX4(double X4) {
        this.X4 = X4;
    }

    public void setY4(double Y4) {
        this.Y4 = Y4;
    }

    
    
    public double getX1() {
        return X1;
    }

    public double getY1() {
        return Y1;
    }

    public double getX2() {
        return X2;
    }

    public double getY2() {
        return Y2;
    }

    public double getX3() {
        return X3;
    }

    public double getY3() {
        return Y3;
    }

    public double getX4() {
        return X4;
    }

    public double getY4() {
        return Y4;
    }

    
    
}
