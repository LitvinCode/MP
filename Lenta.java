package mpprod;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author egor
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author egor
 */
public class Lenta {
    
    private List<Boolean> Lenta = new ArrayList<>();    
    
    public void createLent(String NameFile) throws FileNotFoundException, IOException{
        try (FileReader fr = new FileReader(NameFile)) {
            while (fr.ready()) {
                int data = fr.read(); //читаем один символ (char будет расширен до int)
                
                switch (data) {
                    case 48://0 в int
                        setCell(Boolean.FALSE);
                        break;
                    case 49://1 в int
                        setCell(Boolean.TRUE);
                        break;
                    default:
                        //Error
                        break;
                }
            }
        }
    }//реализовать
    
    public void createLentLine(String l){
        int i = 0;
        
        while(i < l.length()){
            
            if(l.charAt(i) == '0'){
                setCell(Boolean.FALSE);
            } else {
                setCell(Boolean.TRUE);
            }
            
            i++;
        }
    }
    
    public void createRandomLent(int l){
        int i = 0;
        while(i < l){
            setCell(randomeCell());
            i++;
        }
    }
    
    private boolean randomeCell(){
        return Math.random() < 0.5;
    } 
    
    public void setCell(int I, Boolean V){
        if((I >= 0 && I < Lenta.size()) && (Objects.equals(V, Boolean.FALSE) || Objects.equals(V, Boolean.TRUE))){
            Lenta.remove(I);
            Lenta.add(I, V);
        } else {
            System.out.println("Error : попытка ввести (несуществующее)значение в несуществующею || отрицательную ячейку");
        }
    }//переработать ошибки
    
    public void setCell(Boolean V){
        if(Objects.equals(V, Boolean.FALSE) || Objects.equals(V, Boolean.TRUE)){
            Lenta.add(V);
        } else {
            System.out.println("Error : попытка ввести несуществующее значение в ячейку");
        }
    }
    
    public Boolean getCell(int I){
        return Lenta.get(I);
    }
    
    public Object[] getLenta(){
        return Lenta.toArray();
    }
    
    public void clerLenta(){
        Lenta.clear();
    }
    
    public int size(){
        return Lenta.size();
    }
}
