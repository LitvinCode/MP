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
public class Executor {
    
    private Lenta L = new Lenta();
    private MapACT MA = new MapACT();
    
    private int NamCell;
    private String State = new String();
    
    Executor(){
        
    }
    
    public void Start(){
        if("".equals(State)){
            State = "Start";
        }
        
        while(MA.getActiv(State) != Activ.END && NamCell < L.size()){
            switch(MA.getActiv(State)){
                case RIG:
                    Right();
                    setState(MA.getState1(State));
                    break;
                case LEF:
                    Left();
                    setState(MA.getState1(State));
                    break;
                case MAR:
                    Mark();
                    setState(MA.getState1(State));
                    break;
                case DEL:
                    unMark();
                    setState(MA.getState1(State));
                    break;
                case DCS:
                    if(DeterCellState() == false){
                        setState(MA.getState1(State));
                    } else {
                        setState(MA.getState2(State));
                    }
                    break;
                case END:
                    break;
                default:
                    System.out.println("Действие не определено");
                    break;
            }
        }
    }
    
    private void Right(){
        NamCell++;
    }//Движение вправо
    
    private void Left(){
        NamCell--;
    }//Движение влево
    
    private void Mark(){
        if(L.getCell(NamCell) == false){
            L.setCell(NamCell, Boolean.TRUE);
        }
    }//Поставить метку
    
    private void unMark(){
        if(L.getCell(NamCell) == true){
            L.setCell(NamCell, Boolean.FALSE);
        }
    }//Стереть метку
    
    private boolean DeterCellState(){
        return L.getCell(NamCell);
    }//Определить значение метки 
    
    public void setLenta(Lenta L){
        this.L = L;
    }
    
    public void setMapAct(MapACT MA){
        this.MA = MA;
    }
    
    public void setNamCell(int i){
        this.NamCell = i;
    }
    
    public void setState(String s){
        this.State = s;
    }
    
    public String getState(){
        return State;
    }
    
    public int getNamCell(){
        return NamCell;
    }
    
    public Lenta getLenta(){
        return L;
    }
}