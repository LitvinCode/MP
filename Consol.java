/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpprod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Consol {
    
    private Executor E = new Executor();
    private Lenta L = new Lenta();
    private Coder C = new Coder();
    
    private Scanner in = new Scanner(System.in);
    
    private boolean work = true;
    
    public void StartConsol() throws IOException{
        System.out.println("=========Машина Поста=========\n"
                + "введите help для помощи");
        while(work){
            System.out.print(">>>");
            List<String> LK;
            LK = parseComand(inputComand());
            identComand(LK.get(0), LK.get(1), LK.get(2));            
        }
    }
    
    private String inputComand(){
        String Com = in.nextLine();
        
        return Com;
    }
    
    private List<String> parseComand(String com){
        List<String> LS = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(com, " ");
        
        while(st.hasMoreTokens()) {
	    LS.add(st.nextToken());
        }
        
        LS.add(null);
        LS.add(null);
        LS.add(null);//избыточное заполнение
        
        return LS;
    }
    
    private void identComand(String act, String opt, String val) throws IOException{
        if(null == act){
            
        } else switch (act) {
            case "help":
                help(opt, val);
                break;
            case "lenta":
                lenta(opt, val);
                break;
            case "code":
                code(opt, val);
                break;
            case "exec":
                exec(opt, val);
                break;
            case "start":
                start();
                break;
            case "exit":
                work = false;
                break;
            default:
                System.out.print("Такой команды не обнаруженно\n");
                help(" ", " ");
                break;
        }
        
    }//определить действие
    
    private void help(String com, String opt){
        switch (com) {
            case "lenta":
                System.out.print("lenta: посволяет загружать ленту в машину Поста");
                if(opt == null){
                    System.out.print(". Доступные опции -l -f -r -g -c \n");
                } else {
                    if("-l".equals(opt) || "-f".equals(opt) || "-r".equals(opt) || "-g".equals(opt) || "-c".equals(opt)){
                        helpOpt(opt);
                    } else {
                        System.out.print(". Такой опции нет для данной операции");
                        System.out.print(". Доступные опции -l -f -r -g -c \n");
                    }
                }
                break;
            case "code":
                System.out.print("code: посволяет загружать алгоритм в машину Поста");
                if(opt == null){
                    System.out.print(". Доступные опции -l -f \n");
                } else {
                    if("-l".equals(opt) || "-f".equals(opt)){
                        helpOpt(opt);
                    } else {
                        System.out.print(". Такой опции нет для данной операции");
                        System.out.print(". Доступные опции -l -f \n");
                    }
                }
                break;
            case "exec":
                System.out.print("exec: посволяет устанавливать входные значения в машину Поста");
                if(opt == null){
                    System.out.print(". Доступные опции -n -s \n");
                } else {
                     if("-n".equals(opt) || "-s".equals(opt)){
                        helpOpt(opt);
                    } else {
                        System.out.print(". Такой опции нет для данной операции");
                        System.out.print(". Доступные опции -n -s \n");
                    }
                }
                break;
            case "start":
                if(opt != null){
                    System.out.print("start: запускает машину поста с ранее введенными параметрами\n");
                    System.out.print(". Oпций для операции не существует\n");
                }System.out.print("start: запускает машину поста с ранее введенными параметрами\n");
            case "exit":
                if(opt != null){
                    System.out.print("exit: закрывает приложение");
                    System.out.print(". Oпций для операции не существует\n");
                }System.out.print("exit: закрывает приложение\n");
                break;
            default:
                System.out.println("===Список команд===\n"
                        + "lenta\n"
                        + "start\n"
                        + "code\n"
                        + "exec\n"
                        + "exit\n"
                        + "help\n\n"
                        + "Введите help и название команды");
                break;
        }
    }
    
    void helpOpt(String opt){
        switch(opt){
            case "-l":
                System.out.println(". Позволяет вводить данные из ком. строки");
                break;
            case "-f":
                System.out.println(". Загружает файл по полному расположению");
                break;
            case "-r":
                System.out.println(". Создаёт случайную ленту с указанной длиной");
                break;
            case "-g":
                System.out.println(". Выводит ленту в ком. строку");
                break;
            case "-c":
                System.out.println(". Отчищает ленту от значений");
                break;
            case "-n":
                System.out.println(". Устанавливает начальную ячейку");
                break;
            case "-s":
                System.out.println(". Устанавливает начальное состояние");
                break;
        }
    }
    
    private void lenta(String opt, String val) throws IOException{
        switch (opt) {
            case "-f":
                if(val == null){
                    L.createLent(nextVal());
                } else {
                    L.createLent(val);
                }
                break;
            case "-l":
                if(val == null){
                    L.createLentLine(nextVal());
                } else {
                    L.createLentLine(val);
                }
                break;
            case "-c":
                L.clerLenta();
                break;
            case "-r":
                if(val == null){
                    L.createRandomLent(Integer.parseInt(nextVal()));
                } else {
                    L.createRandomLent(Integer.parseInt(val));
                }
                break;
            case "-g":
                System.out.println(Arrays.toString(L.getLenta()));
                break;
            default:
                
                break;
        }
    }
    
    private void code(String opt, String val) throws IOException{
        switch (opt) {
            case "-f":
                if(val == null){
                    C.setFileCode(nextVal());
                } else {
                    C.setFileCode(val);
                }
                break;
            case "-l":
                if(val == null){
                    System.out.println("Пока не готово. Воспользуйтесь файлом -f");
                } else {
                    System.out.println("Пока не готово. Воспользуйтесь файлом -f");
                }
                break;
            default:
                System.out.println("Пока не готово. Воспользуйтесь файлом -f");
                break;
        }
    }
    
    private void exec(String opt, String val){
        switch (opt) {
            case "-n":
                if(val == null){
                    E.setNamCell(Integer.parseInt(nextVal()));
                } else {
                    E.setNamCell(Integer.parseInt(val));
                }
                break;
            case "-s":
                if(val == null){
                    E.setState(nextVal());
                } else {
                    E.setState(val);
                }
                break;
            default:
                
                break;
        }
    }
    
    private String nextVal(){
        String val = in.nextLine();
        
        return val;
    }
    
    private void start(){
        E.setLenta(L);
        C.StartCoder();
        E.setMapAct(C.getMap());
        E.Start();
    }
}
