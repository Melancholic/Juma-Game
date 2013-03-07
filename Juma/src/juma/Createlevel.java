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
                        Xtmp-=GetVX(Xtmp,Ytmp,args[i+1].X,args[i+1].Y);
                        Ytmp=args[i].Y;
                        AddRecordFile(file,Xtmp,Ytmp);
                    } 
                } else if((args[i].Y<args[i+1].Y)){
                     while(window.GetDistToPoint(Xtmp, Ytmp, args[i+1].X, args[i+1].Y)>=ball.Size){
                         System.err.println("зацикливание тут3");
                         System.out.println('x'+Xtmp+" ( "+args[i+1].X+" ) "+ "y:"+Ytmp+" ( "+args[i+1].Y+" ) ");
                        Xtmp-=GetVX(Xtmp,Ytmp,args[i+1].X,args[i+1].Y);
                        Ytmp+=GetVY(Xtmp,Ytmp,args[i+1].X,args[i+1].Y);
                        AddRecordFile(file,Xtmp,Ytmp);
                    }
                }
            } else if (args[i].X==args[i+1].X){
                if(args[i].Y>args[i+1].Y){
                    while(window.GetDistToPoint(Xtmp, Ytmp, args[i+1].X, args[i+1].Y)>=ball.Size){ 
                        System.err.println("зацикливание тут4");
                        Xtmp=ball.Size;
                        Ytmp-=GetVY(Xtmp,Ytmp,args[i+1].X,args[i+1].Y);;
                        AddRecordFile(file,Xtmp,Ytmp);
                    }
                } else if((args[i].Y<args[i+1].Y)){
                     while(window.GetDistToPoint(Xtmp, Ytmp, args[i+1].X, args[i+1].Y)>=ball.Size){  
                         System.err.println("зацикливание тут5");
                        Xtmp=args[i+1].X;
                        Ytmp+=GetVY(Xtmp,Ytmp,args[i+1].X,args[i+1].Y);;
                        AddRecordFile(file,Xtmp,Ytmp);
                    }
                }
                
            }else if(args[i].X<args[i+1].X){
                if(args[i].Y>args[i+1].Y){
                    while(window.GetDistToPoint(Xtmp, Ytmp, args[i+1].X, args[i+1].Y)>=ball.Size){
                        System.err.println("зацикливание тут6");
                        Xtmp+=GetVX(Xtmp,Ytmp,args[i+1].X,args[i+1].Y);;
                        Ytmp-=GetVY(Xtmp,Ytmp,args[i+1].X,args[i+1].Y);;
                        AddRecordFile(file,Xtmp,Ytmp);
                    }
                } else if(args[i].Y==args[i+1].Y){
                     while(window.GetDistToPoint(Xtmp, Ytmp, args[i+1].X, args[i+1].Y)>=ball.Size){
                         System.err.println("зацикливание тут7");
                          System.out.println('x'+Xtmp+" ( "+args[i+1].X+" ) "+ "y:"+Ytmp);
                        Xtmp+=GetVX(Xtmp,Ytmp,args[i+1].X,args[i+1].Y);;
                        Ytmp=args[i].Y;
                        AddRecordFile(file,Xtmp,Ytmp);
                    } 
                } else if((args[i].Y<args[i+1].Y)){
                     while(window.GetDistToPoint(Xtmp, Ytmp, args[i+1].X, args[i+1].Y)>=ball.Size){
                         System.err.println("зацикливание тут8");
                        Xtmp+=GetVX(Xtmp,Ytmp,args[i+1].X,args[i+1].Y);;
                        Ytmp+=GetVY(Xtmp,Ytmp,args[i+1].X,args[i+1].Y);;
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
            //file.writeChars(" ");
            file.writeDouble(Y);
           // file.writeChars("\n");
        } catch (IOException ex) {
            System.err.println("Err in Createlevel::SaveToFile::IOException");
        }
    } 
    static private double GetVX(double x1,double y1, double x2, double y2){
        return Math.abs((x2 - x1) / Math.sqrt((double) (Math.pow(x2 - x1, 2) + (Math.pow(y2 - y1, 2)))) * (window.Height + window.Width) * Level.lvl()/1000);
    }
    static private double GetVY(double x1,double y1, double x2, double y2){
        return Math.abs((y1 - y2) / Math.sqrt((double) (Math.pow(x2 - x1, 2) + (Math.pow(y2 - y1, 2)))) * (window.Height + window.Width) * Level.lvl()/1000);
    }
    
}
