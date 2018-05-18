/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpprod;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author egor
 */
public class Coder {
    private String Code;
    private List<String> LinkCode = new ArrayList<>();
    private MapACT MA = new MapACT();
    
    public void StartCoder(){        
        setCode(CharRepl(Code, " ", ""));
        LinkCode.addAll(Arrays.asList(CharRepl(Code, "\n", "").split(";")));
        
        int i = 0;
        while(i < LinkCode.size()){
            Activ ACT;
            List<String> LC = new ArrayList<>();
            
            LC.addAll(Arrays.asList(LinkCode.get(i).split(",", 4)));
            
            LC.add("");
            LC.add("");
            LC.add("");
            LC.add("");//избыточное заполнение
            
            if(LC.get(1) != null){
                
                switch(LC.get(1)){
                    case "RIG":
                        MA.setNewString(LC.get(0), Activ.RIG, LC.get(2), LC.get(3));
                        break;
                    case ">":
                        MA.setNewString(LC.get(0), Activ.RIG, LC.get(2), LC.get(3));
                        break;
                    case "LEF":
                        MA.setNewString(LC.get(0), Activ.LEF, LC.get(2), LC.get(3));
                        break;
                    case "<":
                        MA.setNewString(LC.get(0), Activ.LEF, LC.get(2), LC.get(3));
                        break;
                    case "MAR":
                        MA.setNewString(LC.get(0), Activ.MAR, LC.get(2), LC.get(3));
                        break;
                    case "1":
                        MA.setNewString(LC.get(0), Activ.MAR, LC.get(2), LC.get(3));
                        break;
                    case "DEL":
                        MA.setNewString(LC.get(0), Activ.DEL, LC.get(2), LC.get(3));
                        break;
                    case "0":
                        MA.setNewString(LC.get(0), Activ.DEL, LC.get(2), LC.get(3));
                        break;
                    case "DCS":
                        MA.setNewString(LC.get(0), Activ.DCS, LC.get(2), LC.get(3));
                        break;
                    case "?":
                        MA.setNewString(LC.get(0), Activ.DCS, LC.get(2), LC.get(3));
                        break;
                    case "END":
                        MA.setNewString(LC.get(0), Activ.END, LC.get(2), LC.get(3));
                        break;
                    case "!":
                        MA.setNewString(LC.get(0), Activ.END, LC.get(2), LC.get(3));
                        break;
                    default:
                        System.out.println("Действие не определено");
                    break;
                }
                
                LC.clear();
            }
            i++;
        }
    }
    
    private String CharRepl(String S, String E, String F){
        return S.replaceAll(E, F);
    }
    
    public MapACT getMap(){
        return MA;
    }
    
    public void setCode(String Code){
        this.Code = Code;
    }
    
    public void setFileCode(String file) throws FileNotFoundException, IOException{
        String code = new Scanner(new File(file)).useDelimiter("\\Z").next();
        this.Code = code;
    }
    
    public void clearCode(){
        MA.clear();
        LinkCode.clear();
        Code = null;
    }
}
