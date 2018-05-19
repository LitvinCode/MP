/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpprod;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author egor
 */

public class MapACT{
    private Map<String, Tail> MapCom = new HashMap<>();
    
    public void setNewString(String State){
        MapCom.put(State, null);
    }
    
    public void setNewString(String State, Activ Act){
        MapCom.put(State, new Tail(Act));
    }
    
    public void setNewString(String State, Activ Act, String State1){
        MapCom.put(State, new Tail(Act, State1));
    }
    
    public void setNewString(String State, Activ Act, String State1, String State2){
        MapCom.put(State, new Tail(Act, State1, State2));
    }
    
    public boolean getState(String State){
        return MapCom.containsKey(State);
    }
    
    public Activ getActiv(String State){
        if(MapCom.containsKey(State) != false){
            return MapCom.get(State).getAct();
        } else {
            return null;
        }
    }
    
    public String getState1(String State){
        if(MapCom.containsKey(State) != false){
            return MapCom.get(State).getState1();
        } else {
            return null;
        }
    }
    
    public String getState2(String State){
        if(MapCom.containsKey(State) != false){
            return MapCom.get(State).getState2();
        } else {
            return null;
        }
    }
    
    public void clear(){
        MapCom.clear();
    }
}

class Tail {
    
    private Activ Act;
    private String State1;
    private String State2;

    Tail(){

    }

    Tail(Activ Act){
        this.Act = Act;
    }

    Tail(Activ Act, String State1){
        this.Act = Act;
        this.State1 = State1;
    }

    Tail(Activ Act, String State1, String State2){
        this.Act = Act;
        this.State1 = State1;
        this.State2 = State2;
    }

    public void setAct(Activ Act){
        this.Act = Act;
    }

    public void setState1(String State1){
        this.State1 = State1;
    }

    public void setState2(String State2){
        this.State2 = State2;
    }

    public Activ getAct(){
        return Act;
    }

    public String getState1(){
        return State1;
    }

    public String getState2(){
        return State2;
    }
}
