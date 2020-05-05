
package projeto_opengl.model;

import com.jogamp.opengl.GL2;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import projeto_opengl.MainWindow;
import projeto_opengl.arquivo.Arquivo;


public class Cobra {
    
    ArrayList<Corpo> cobra = new ArrayList<Corpo>();
    int tamanho = cobra.size();
    
    Grid G = new Grid();

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
    
    public void init(){
        Grid g = new Grid();
        Corpo c = new Corpo();
        c.setX1(0);
        c.setX2(0);
        c.setX3(0.2);
        c.setX4(0.2);
        c.setY1(0);
        c.setY2(-0.2);
        c.setY3(-0.2);
        c.setY4(0);
        cobra.add(c);
        g.setPosition(3,5,5);
        this.tamanho = 1;
    }
    
    public void draw(GL2 gl){
        Grid g = new Grid();
        int num1, num2;        
                
        for(int i = 0; i < cobra.size(); i++){
            Corpo c = cobra.get(i);
            
            num1 = (int) (((c.X1 * 10) / 2) + 5);
            num2 = (int) (((((c.Y1 * 10) / 2) + 4) - 9) * -1);
            
            G.setPosition(3, num2, num1);
            
            gl.glBegin(GL2.GL_QUADS);  
        
            gl.glColor3f( 0.0f,0.0f,1.0f );  

            gl.glVertex2d(c.X1 , c.Y1);
            gl.glVertex2d(c.X2 , c.Y2);
            gl.glVertex2d(c.X3 , c.Y3);
            gl.glVertex2d(c.X4 , c.Y4);

            gl.glEnd(); 
            
        }
    }
    
    public void cleanDraw(){
        int num1, num2;  
        
        for(int i = 0; i < cobra.size(); i++){
            Corpo c = cobra.get(i);
            
            num1 = (int) (((c.X1 * 10) / 2) + 5);
            num2 = (int) (((((c.Y1 * 10) / 2) + 4) - 9) * -1);
            
            G.setPosition(0, num2, num1);
        }
    }
    
    public void cleanCobra(){
        this.cobra.clear();
        this.tamanho = cobra.size();
    }
    
    public void printCobra(){
        int num1, num2;  
        
        for(int i = 0; i < cobra.size(); i++){
            Corpo c = cobra.get(i);
            
            num1 = (int) (((c.X1 * 10) / 2) + 5);
            num2 = (int) (((((c.Y1 * 10) / 2) + 4) - 9) * -1);
            System.out.println("no" + i + ":" + num2 + "/" + num1);
        }
    }
    
    public void updateCobra(){
        for(int i = cobra.size() - 1; i > 0; i--){
            cobra.set(i, cobra.get(i - 1));
        }
    }
    
    public void Cima(Grid G){
        Corpo C = new Corpo();
        int num1,num2;
        if(G.cheakGameOver()){
            return;
        }
        if(cobra.get(0).X1 == -1){
            num1 = 0;
        }else{
            num1 = (int) ((cobra.get(0).X1 / 2) *10) + 5;
        }
        if(cobra.get(0).Y1 == 1){
            num2 = 0;
        }else{
            num2 = (int) (((cobra.get(0).Y1 * -1) / 2) *10) + 5;
        }
        if(cobra.get(0).Y1 != 1 && G.checkPosition(num2 - 1, num1) == 0){
            updateCobra();
            C.setX1(cobra.get(0).X1);C.setY1(cobra.get(0).Y1 + 0.2);
            C.setX2(cobra.get(0).X2);C.setY2(cobra.get(0).Y2 + 0.2);
            C.setX3(cobra.get(0).X3);C.setY3(cobra.get(0).Y3 + 0.2);
            C.setX4(cobra.get(0).X4);C.setY4(cobra.get(0).Y4 + 0.2);
            cobra.set(0,C);
        }else if(cobra.get(0).Y1 != 1 && G.checkPosition(num2 - 1, num1) == 1){
            MainWindow w = new MainWindow();
            w.setPontos(10);
            tamanho ++ ;
            cobra.add(cobra.get(cobra.size()-1));
            updateCobra();
            C.setX1(cobra.get(0).X1);C.setY1(cobra.get(0).Y1 + 0.2);
            C.setX2(cobra.get(0).X2);C.setY2(cobra.get(0).Y2 + 0.2);
            C.setX3(cobra.get(0).X3);C.setY3(cobra.get(0).Y3 + 0.2);
            C.setX4(cobra.get(0).X4);C.setY4(cobra.get(0).Y4 + 0.2);
            cobra.set(0,C);
        }else if(G.checkPosition(num2 - 1, num1) == 2 || G.checkPosition(num2 - 1, num1) == 3){
            MainWindow w = new MainWindow();
            Arquivo arq = new Arquivo();
            G.setGameOver(true);
            try {
                arq.escritor(w.nome_player + w.ponto_player, w.ponto_player);
            } catch (IOException ex) {
                Logger.getLogger(Cobra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void Baixo(Grid G){
        Corpo C = new Corpo();
        int num1,num2;
        if(G.cheakGameOver()){
            return;
        }
        if(cobra.get(0).X1 == -1){
            num1 = 0;
        }else{
            num1 = (int) ((cobra.get(0).X1 / 2) *10) + 5;
        }
        if(cobra.get(0).Y1 == 1){
            num2 = 0;
        }else{
            num2 = (int) (((cobra.get(0).Y1 * -1) / 2) *10) + 5;
        }
        if(cobra.get(0).Y1 != -0.8 && G.checkPosition(num2 + 1, num1) == 0){
            updateCobra();
            C.setX1(cobra.get(0).X1);C.setY1(cobra.get(0).Y1 - 0.2);
            C.setX2(cobra.get(0).X2);C.setY2(cobra.get(0).Y2 - 0.2);
            C.setX3(cobra.get(0).X3);C.setY3(cobra.get(0).Y3 - 0.2);
            C.setX4(cobra.get(0).X4);C.setY4(cobra.get(0).Y4 - 0.2);
            cobra.set(0,C);
        }else if(cobra.get(0).Y1 != -0.8 && G.checkPosition(num2 + 1, num1) == 1){
            MainWindow w = new MainWindow();
            w.setPontos(10);
            tamanho ++;
            cobra.add(cobra.get(cobra.size()-1));
            updateCobra();
            C.setX1(cobra.get(0).X1);C.setY1(cobra.get(0).Y1 - 0.2);
            C.setX2(cobra.get(0).X2);C.setY2(cobra.get(0).Y2 - 0.2);
            C.setX3(cobra.get(0).X3);C.setY3(cobra.get(0).Y3 - 0.2);
            C.setX4(cobra.get(0).X4);C.setY4(cobra.get(0).Y4 - 0.2);
            cobra.set(0,C);
        }else if(G.checkPosition(num2 + 1, num1) == 2 || G.checkPosition(num2 + 1, num1) == 3){
            MainWindow w = new MainWindow();
            Arquivo arq = new Arquivo();
            G.setGameOver(true);
            try {
                arq.escritor(w.nome_player + w.ponto_player, w.ponto_player);
            } catch (IOException ex) {
                Logger.getLogger(Cobra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void Direita(Grid G){
        Corpo C = new Corpo();
        int num1,num2;
        if(G.cheakGameOver()){
            return;
        }
        if(cobra.get(0).X1 == -1){
            num1 = 0;
        }else{
            num1 = (int) ((cobra.get(0).X1 / 2) *10) + 5;
        }
        if(cobra.get(0).Y1 == 1){
            num2 = 0;
        }else{
            num2 = (int) (((cobra.get(0).Y1 * -1) / 2) *10) + 5;
        }
        if(cobra.get(0).X1 != 0.8 && G.checkPosition(num2, num1 + 1) == 0){
            updateCobra();
            C.setX1(cobra.get(0).X1 + 0.2);C.setY1(cobra.get(0).Y1);
            C.setX2(cobra.get(0).X2 + 0.2);C.setY2(cobra.get(0).Y2);
            C.setX3(cobra.get(0).X3 + 0.2);C.setY3(cobra.get(0).Y3);
            C.setX4(cobra.get(0).X4 + 0.2);C.setY4(cobra.get(0).Y4);
            cobra.set(0,C);
        }else if(cobra.get(0).X1 != 0.8 && G.checkPosition(num2, num1 + 1) == 1){
            MainWindow w = new MainWindow();
            w.setPontos(10);
            tamanho ++;
            cobra.add(cobra.get(cobra.size()-1));
            updateCobra();
            C.setX1(cobra.get(0).X1 + 0.2);C.setY1(cobra.get(0).Y1);
            C.setX2(cobra.get(0).X2 + 0.2);C.setY2(cobra.get(0).Y2);
            C.setX3(cobra.get(0).X3 + 0.2);C.setY3(cobra.get(0).Y3);
            C.setX4(cobra.get(0).X4 + 0.2);C.setY4(cobra.get(0).Y4);
            cobra.set(0,C);
        }else if(G.checkPosition(num2, num1 + 1) == 2 || G.checkPosition(num2, num1 + 1) == 3){
            MainWindow w = new MainWindow();
            Arquivo arq = new Arquivo();
            G.setGameOver(true);
            try {
                arq.escritor(w.nome_player + w.ponto_player, w.ponto_player);
            } catch (IOException ex) {
                Logger.getLogger(Cobra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void Esquerda(Grid G){
        Corpo C = new Corpo();
        int num1,num2;
        if(G.cheakGameOver()){
            return;
        }
        if(cobra.get(0).X1 == -1){
            num1 = 0;
        }else{
            num1 = (int) ((cobra.get(0).X1 / 2) *10) + 5;
        }
        if(cobra.get(0).Y1 == 1){
            num2 = 0;
        }else{
            num2 = (int) (((cobra.get(0).Y1 * -1) / 2) *10) + 5;
        }
        if(cobra.get(0).X1 != -1 && G.checkPosition(num2, num1 - 1) == 0){
            updateCobra();
            C.setX1(cobra.get(0).X1 - 0.2);C.setY1(cobra.get(0).Y1);
            C.setX2(cobra.get(0).X2 - 0.2);C.setY2(cobra.get(0).Y2);
            C.setX3(cobra.get(0).X3 - 0.2);C.setY3(cobra.get(0).Y3);
            C.setX4(cobra.get(0).X4 - 0.2);C.setY4(cobra.get(0).Y4);
            cobra.set(0,C);
        }else if(cobra.get(0).X1 != -1 && G.checkPosition(num2, num1 - 1) == 1){
            MainWindow w = new MainWindow();
            w.setPontos(10);
            tamanho ++;
            cobra.add(cobra.get(cobra.size()-1));
            updateCobra();
            C.setX1(cobra.get(0).X1 - 0.2);C.setY1(cobra.get(0).Y1);
            C.setX2(cobra.get(0).X2 - 0.2);C.setY2(cobra.get(0).Y2);
            C.setX3(cobra.get(0).X3 - 0.2);C.setY3(cobra.get(0).Y3);
            C.setX4(cobra.get(0).X4 - 0.2);C.setY4(cobra.get(0).Y4);
            cobra.set(0,C);
        }else if(G.checkPosition(num2, num1 - 1) == 2 || G.checkPosition(num2, num1 - 1) == 3){
            MainWindow w = new MainWindow();
            Arquivo arq = new Arquivo();
            G.setGameOver(true);
            try {
                arq.escritor(w.nome_player + w.ponto_player, w.ponto_player);
            } catch (IOException ex) {
                Logger.getLogger(Cobra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
