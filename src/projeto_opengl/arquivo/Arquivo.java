
package projeto_opengl.arquivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Arquivo {
    
    public static ArrayList<String> leitor() throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader("C:\\Users\\LUCAS MATHEUS\\Documents\\NetBeansProjects\\Projeto_OpenGL\\src\\projeto_opengl\\arquivo\\score.txt"));
        ArrayList<String> data = new ArrayList<String>();
        
        for(int i = 0; i < 3; i ++){
            data.add(buffRead.readLine());
        }
        
        buffRead.close();
        
        return data;
    }
 
    public static void escritor(String score, int pontos) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter("C:\\Users\\LUCAS MATHEUS\\Documents\\NetBeansProjects\\Projeto_OpenGL\\src\\projeto_opengl\\arquivo\\score.txt"));
        ArrayList<String> data = leitor();
        for(int i = 0; i < 3; i++){
            try {
                int num = Integer.parseInt(data.get(i).replaceAll("[\\D]", "")); 
                
                if(pontos > num){
                    if(i == 0){
                        data.set(2, data.get(1));
                        data.set(1, data.get(0));
                        data.set(i, score);
                    }else if(i == 1){
                        data.set(2, data.get(1));
                        data.set(i, score);
                    }else{
                        data.set(i, score);
                    }
                    break;
                }
                
            } catch (NumberFormatException e) {
              System.out.println("Erro na escrita de arquivo!");
            } 
        }
        
        for(int i = 0; i < 3; i++){
            buffWrite.append(data.get(i));
        }
        
        buffWrite.close();
    }
}
