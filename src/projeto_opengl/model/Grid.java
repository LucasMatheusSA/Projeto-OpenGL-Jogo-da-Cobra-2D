
package projeto_opengl.model;

import com.jogamp.opengl.GL2;


public class Grid {
    
    public static int[][] matriz_jogo = new int[10][10];
    public boolean status = false;
    public boolean gameOver = false;
    
    public void draw(GL2 gl) {
        float num1,num2;
        
        Ponto P = new Ponto();
        Obstaculo Ob = new Obstaculo();
       
        gl.glColor3f(0f, 1f, 0f);
        
        for (float i = -1; i < 1 ; i = (float) (i + 0.2)){
            setLineX(gl,i);
        }

        for (float i = -1; i < 1 ; i = (float) (i + 0.2)){
            setLineY(gl,i);
        }
        
        for(float l = 0; l < 10; l = l + 1){
            for(float c = 0; c < 10; c = c + 1){
                if(matriz_jogo[(int) c][(int) l] == 1){
                    num1 = ((l - 5) / 10) * 2;
                    num2 = (((c - 5) / 10) * 2) * -1;
                    P.draw(gl, num1, num2);
                }else if(matriz_jogo[(int) c][(int) l] == 2){
                    num1 = (( l - 5) / 10) * 2;
                    num2 = (((c - 5) / 10) * 2) * -1;
                    Ob.draw(gl, num1, num2);
                }
            }
        }
        System.out.println("-----------------------------------");
    }
    
    private void setLineX(GL2 gl, float x) {
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex2d(x , -1);
        gl.glVertex2d(x , 1);
        gl.glEnd();
    }
    
    private void setLineY(GL2 gl, float y) {
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex2d(-1, y );
        gl.glVertex2d(1, y );
        gl.glEnd();
    }
    
    public void setPosition(int type, int x, int y){
        matriz_jogo[x][y] = type;
    }
    
    public int checkPosition(int x, int y){
        return matriz_jogo[x][y];
    }
    
    public void printMatriz(){
       for (int l = 0; l < 10; l++){  
        for (int c = 0; c < 10; c++){ 
           System.out.print(matriz_jogo[l][c] + " "); 
       }  
       System.out.println(" "); 
     } 
    }
    
    public boolean cheakGameOver(){
        if (this.gameOver == true){
            return true;
        }else if(status == true){
            for (int l = 0; l < 10; l++){  
            for (int c = 0; c < 10; c++){ 
                if(matriz_jogo[l][c] != 0){
                    return false;
                }
            }  
            }
            this.gameOver = true;
            return true;
        }
        return false;
    }

    public static int[][] getMatriz_jogo() {
        return matriz_jogo;
    }
    
    public void drawGameOver(GL2 gl){
        float num1,num2;
        Obstaculo Ob = new Obstaculo();
        for(int c = 0; c < 10; c++){
            for(int l = 0; l < 10; l++){
                if(c + l == 9 || c == l){
                    matriz_jogo[c][l] = 2;
                }
            }
        }
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public void cleanMatriz(){
        for(int c = 0; c < 10; c++){
            for(int l = 0; l < 10; l++){
                matriz_jogo[c][l] = 0;
            }
        }
    }
    
    public void cleanCobra(){
        for(int c = 0; c < 10; c++){
            for(int l = 0; l < 10; l++){
                if(matriz_jogo[c][l] == 3){
                    matriz_jogo[c][l] = 0;
                }
            }
        }
    }
    
    public void zerar(){
        Cobra c = new Cobra();
        c.cleanCobra();
        cleanMatriz();
        setStatus(false);
        this.gameOver = false;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
    
    
}
