/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juma;
import java.io.File; 
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 *
 * @author sosnov
 */
class Createlevel {
    static void CreateDefaultAll(){
        for (int i=0;i<9;++i){
            CreateDefault(i);
        }
    }
    static void CreateDefault(int Number){
        Number=Number%9;
        switch(Number){
            case 0:CreateDefault_0();break;
            case 1:CreateDefault_1();break;
            case 2:CreateDefault_2();break;
            case 3:CreateDefault_3();break;
            case 4:CreateDefault_4();break;
            case 5:CreateDefault_5();break;
            case 6:CreateDefault_6();break;
            case 7:CreateDefault_7();break;
            case 8:CreateDefault_8();break;
            default:System.err.print("Err value in Createlevel::CreateDefault(int a) ");
        }          
    }
    static void CreateDefault_0(){
        Createlevel.SaveToFile(0,
        new point(Level.getStartX(),Level.getStartY()), 
        new point(window.Width*.95, Level.getStartY()),
        new point(window.Width*0.95,window.Height*0.80),
        new point(window.Width*0.85 , window.Height*0.80),
        new point(window.Width*0.85,window.Height*0.20),
        new point(window.Width*0.20,window.Height*0.20),
        new point(window.Width*0.20,window.Height*0.90),
        new point(Level.getStopX(),Level.getStopY())
        );
    }
     static void CreateDefault_1(){
        Createlevel.SaveToFile(1,
        new point(Level.getStartX(),Level.getStartY()), 
        new point(window.Width-window.Width*0.05, Level.getStartY()),
        new point(window.Width-window.Width*0.05,window.Height*0.2),
        new point(window.Width*0.2 , window.Height*0.2),
        new point(window.Width*0.2,window.Height-window.Height*0.20),
        new point(window.Width*0.95,window.Height*0.8),
       // new point(window.Width*0.95,window.Height*0.95)
        new point(Level.getStopX(),Level.getStopY())
        );
    }
    static void CreateDefault_2(){
        Createlevel.SaveToFile(2,
        new point(Level.getStartX(),Level.getStartY()), 
        new point(Level.getStartX(),Level.getStartY()), 
        new point(window.Width-window.Width*0.05, Level.getStartY()),
        new point(window.Width-window.Width*0.05,window.Height*0.2),
        new point(window.Width*0.2 , window.Height*0.2),
        new point(window.Width*0.2,window.Height-window.Height*0.20),
        new point(window.Width*0.95,window.Height*0.8),
       // new point(window.Width*0.95,window.Height*0.95)
        new point(Level.getStopX(),Level.getStopY())
        );
    }
    static void CreateDefault_3(){
        Createlevel.SaveToFile(3,
        new point(Level.getStartX(),Level.getStartY()), 
        new point(window.Width-window.Width*0.05, window.Height*0.05),
        new point(window.Width-window.Width*0.05,window.Height*0.2),
        new point(window.Width*0.2 , window.Height*0.2),
        new point(window.Width*0.2,window.Height-window.Height*0.20),
        new point(window.Width*0.95,window.Height*0.8),
       // new point(window.Width*0.95,window.Height*0.95)
        new point(Level.getStopX(),Level.getStopY())
        );
    }
    static void CreateDefault_4(){
        Createlevel.SaveToFile(4,
        new point(Level.getStartX(),Level.getStartY()), 
        new point(window.Width*.95, window.Height*0.05),
        new point(window.Width*0.95,window.Height*0.80),
        new point(window.Width*0.85 , window.Height*0.80),
        new point(window.Width*0.85,window.Height*0.20),
        new point(window.Width*0.20,window.Height*0.20),
        new point(window.Width*0.20,window.Height*0.90),
        //new point(window.Width*0.95,window.Height*0.90)
        new point(Level.getStopX(),Level.getStopY())
        );
    }    
    static void CreateDefault_5(){
        Createlevel.SaveToFile(5,
        new point(Level.getStartX(),Level.getStartY()), 
        new point(window.Width-window.Width*0.05, window.Height*0.05),
        new point(window.Width-window.Width*0.05,window.Height*0.2),
        new point(window.Width*0.2 , window.Height*0.2),
        new point(window.Width*0.2,window.Height-window.Height*0.20),
        new point(window.Width*0.95,window.Height*0.8),
        //new point(window.Width*0.95,window.Height*0.95)
        new point(Level.getStopX(),Level.getStopY())
        );
    }
    static void CreateDefault_6(){
        Createlevel.SaveToFile(6,
        new point(Level.getStartX(),Level.getStartY()), 
        new point(window.Width*.95, window.Height*0.05),
        new point(window.Width*0.95,window.Height*0.80),
        new point(window.Width*0.85 , window.Height*0.80),
        new point(window.Width*0.85,window.Height*0.20),
        new point(window.Width*0.20,window.Height*0.20),
        new point(window.Width*0.20,window.Height*0.90),
        //new point(window.Width*0.95,window.Height*0.90)
        new point(Level.getStopX(),Level.getStopY())
        );
    }  
    static void CreateDefault_7(){
        Createlevel.SaveToFile(7,
        new point(Level.getStartX(),Level.getStartY()), 
        new point(window.Width-window.Width*0.05, window.Height*0.05),
        new point(window.Width-window.Width*0.05,window.Height*0.2),
        new point(window.Width*0.2 , window.Height*0.2),
        new point(window.Width*0.2,window.Height-window.Height*0.20),
        new point(window.Width*0.95,window.Height*0.8),
        //new point(window.Width*0.95,window.Height*0.95)
        new point(Level.getStopX(),Level.getStopY())
        );
    }
    static void CreateDefault_8(){
        Createlevel.SaveToFile(8,
        new point(Level.getStartX(),Level.getStartY()), 
        new point(window.Width*.95, window.Height*0.05),
        new point(window.Width*0.95,window.Height*0.80),
        new point(window.Width*0.85 , window.Height*0.80),
        new point(window.Width*0.85,window.Height*0.20),
        new point(window.Width*0.20,window.Height*0.20),
        new point(window.Width*0.20,window.Height*0.90),
       // new point(window.Width*0.95,window.Height*0.90)
        new point(Level.getStopX(),Level.getStopY())
        );
    }  
        
    static void SaveToFile(long lvl, point ... args) {
        try {
            DataOutputStream file = new DataOutputStream(new FileOutputStream("./data/levels/"+Long.toString(lvl)+".dat"));
        for (int i=0; i<args.length-1;++i){
           
            double Xtmp=args[i].X;
            double Ytmp=args[i].Y;
            if(args[i].X>args[i+1].X){
                if(args[i].Y>args[i+1].Y){
                    while(window.GetDistToPoint(Xtmp, Ytmp, args[i+1].X, args[i+1].Y)>=ball.Size){  
                        System.err.println("зацикливание тут1");
                        Xtmp-=GetVX(Xtmp,Ytmp,args[i+1].X,args[i+1].Y);
                        Ytmp+=GetVY(Xtmp,Ytmp,args[i+1].X,args[i+1].Y);
                        AddRecordFile(file,Xtmp,Ytmp);
                    }
                } else if(args[i].Y==args[i+1].Y){
                     while(window.GetDistToPoint(Xtmp, Ytmp, args[i+1].X, args[i+1].Y)>=ball.Size){
                         System.err.println("зацикливание тут2");
                       // Xtmp-=GetVX(Xtmp,Ytmp,args[i+1].X,args[i+1].Y);
                         Xtmp-=1;
                        Ytmp=args[i].Y;
                        AddRecordFile(file,Xtmp,Ytmp);
                    } 
                } else if((args[i].Y<args[i+1].Y)){
                     while(window.GetDistToPoint(Xtmp, Ytmp, args[i+1].X, args[i+1].Y)>=ball.Size){
                         System.err.println("зацикливание тут3");
                        Xtmp-=GetVX(Xtmp,Ytmp,args[i+1].X,args[i+1].Y);
                        Ytmp+=GetVY(Xtmp,Ytmp,args[i+1].X,args[i+1].Y);
                        AddRecordFile(file,Xtmp,Ytmp);
                    }
                }
            } else if (args[i].X==args[i+1].X){
                if(args[i].Y>args[i+1].Y){
                    while(window.GetDistToPoint(Xtmp, Ytmp, args[i+1].X, args[i+1].Y)>=ball.Size){ 
                        System.err.println("зацикливание тут4");
                        Xtmp=args[i+1].X;
                       // Ytmp-=GetVY(Xtmp,Ytmp,args[i+1].X,args[i+1].Y);
                        Ytmp-=1;
                        AddRecordFile(file,Xtmp,Ytmp);
                    }
                } else if((args[i].Y<args[i+1].Y)){
                     while(window.GetDistToPoint(Xtmp, Ytmp, args[i+1].X, args[i+1].Y)>=ball.Size){  
                         System.err.println("зацикливание тут5");
                        Xtmp=args[i+1].X;
                       // Ytmp+=GetVY(Xtmp,Ytmp,args[i+1].X,args[i+1].Y);
                        Ytmp+=1;
                        AddRecordFile(file,Xtmp,Ytmp);
                    }
                }
                
            }else if(args[i].X<args[i+1].X){
                if(args[i].Y>args[i+1].Y){
                    while(window.GetDistToPoint(Xtmp, Ytmp, args[i+1].X, args[i+1].Y)>=ball.Size){
                        System.err.println("зацикливание тут6");
                        System.out.println('x'+Xtmp+" ( "+args[i+1].X+" ) "+ "y:"+Ytmp+" ( "+args[i+1].Y+" ) ");
                        Xtmp+=GetVX(Xtmp,Ytmp,args[i+1].X,args[i+1].Y);
                        Ytmp-=GetVY(Xtmp,Ytmp,args[i+1].X,args[i+1].Y);
                        AddRecordFile(file,Xtmp,Ytmp);
                    }
                } else if(args[i].Y==args[i+1].Y){
                     while(window.GetDistToPoint(Xtmp, Ytmp, args[i+1].X, args[i+1].Y)>=ball.Size){
                         System.err.println("зацикливание тут7");
                         System.out.println('x'+Xtmp+" ( "+args[i+1].X+" ) "+ "y:"+Ytmp+" ( "+args[i+1].Y+" ) ");
                        //Xtmp+=GetVX(Xtmp,Ytmp,args[i+1].X,args[i+1].Y);
                         Xtmp+=1;
                        Ytmp=args[i].Y;
                        AddRecordFile(file,Xtmp,Ytmp);
                    } 
                } else if((args[i].Y<args[i+1].Y)){
                     while(window.GetDistToPoint(Xtmp, Ytmp, args[i+1].X, args[i+1].Y)>=ball.Size){
                         System.err.println("зацикливание тут8");
                         System.out.println('x'+Xtmp+" ( "+args[i+1].X+" ) "+ "y:"+Ytmp+" ( "+args[i+1].Y+" ) ");
                         System.out.println(GetVX(Xtmp,Ytmp,args[i+1].X,args[i+1].Y));
                        Xtmp+=GetVX(Xtmp,Ytmp,args[i+1].X,args[i+1].Y);
                        Ytmp+=GetVY(Xtmp,Ytmp,args[i+1].X,args[i+1].Y);
                        AddRecordFile(file,Xtmp,Ytmp);
                    }
                }
            }
 
         }
        
            file.close();
        } catch (IOException ex) {
            System.err.println("Err in Createlevel::SaveToFile::IOException");
        }
     }
    
    static private void  AddRecordFile(DataOutputStream file, double X, double Y){
        try {
            file.writeDouble(X);
            file.writeDouble(Y);
        } catch (IOException ex) {
            System.err.println("Err in Createlevel::SaveToFile::IOException");
        }
    } 
    static private double GetVX(double x1,double y1, double x2, double y2){
        return Math.abs((x2 - x1) / Math.sqrt((double) (Math.pow(x2 - x1, 2) +
        (Math.pow(y2 - y1, 2)))) * (window.Height + window.Width));
    }
    static private double GetVY(double x1,double y1, double x2, double y2){
        return Math.abs((y1 - y2) / Math.sqrt((double) (Math.pow(x2 - x1, 2) + 
        (Math.pow(y2 - y1, 2)))) * (window.Height + window.Width));
    }
    
}
