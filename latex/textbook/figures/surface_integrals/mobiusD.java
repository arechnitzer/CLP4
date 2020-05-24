                  /*  File:  mobiusD.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class mobiusD extends Template {

     static {templateClass = new mobiusD() ; }

     public void setup() {
          filePrefix="mobiusD";
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0*90/50*0.5 ;   // in inches
          ysize = 2.0*0.5 ;   // in inches
          xmin = -10 ;
          xmax = 80 ;
          ymin = -25 ;
          ymax = 25 ;
          topmargin = 0.0 ;   // in inches
          bottommargin = 0.0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double x = 70 ;
          double X = 45 ;
          int    nx = 12 ;
          double dx = x/nx ;
          double y = 15 ;
          int    ny = 3 ;
          double dy = y/ny ;
          double r = 1.6 ;

          String Black = "0 0 0 1 setcmykcolor  " ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Yellow = "0 0 1 0 setcmykcolor  " ;
          String GGreen = "1 0 1 0.2 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;

          fEnv("lineWidth", 0.5) ;
          fLine(0, 0, xmax, 0) ; 
          fTeXlabel(xmax, -1 , "tr", "$\\theta$") ;
          fLine(0, y, 0, ymax) ;
          fLine(0, ymin, 0, -y) ;
          fTeXlabel(-1, ymax, "tr", "$v$") ;
          fEnv("lineWidth", 1.0) ;
//          fLine(0, y, x, y) ;
//          fLine(0,-y, x,-y) ;
//          fLine(0, -y, 0, y) ;
//          fLine(x, -y, x, y) ;


          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("lineWidth", 1.5) ;
          fLine(X, -y, X, y) ;
          fEnv("lineWidth", 0.5) ;
          fLine(0, -y, 0, y) ;
          fLine(x, -y, x, y) ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fLine(0, y, x, y) ;
          canvas.append( new fPsWrite(GGreen+"\n")) ;
          fLine(0,-y, x,-y) ;


          fEnv("lineWidth", 1.5) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fLine(0, 0, x, 0) ;

          fDisk(X,0,r,r,FILLED) ;

          fEnv("lineWidth", 0.5) ;
          fEnv("headHalfWidth", 2.0) ;
          fEnv("headLength", 6.0) ;


          double ddy = 6 ; double w = 4 ;
          fLine(x, -y-ddy-w, x, -y-ddy+w ) ;
          fArrow( x/2 - 1.2*w,-y-ddy,  0,-y-ddy) ;
          fArrow(x/2+1.2*w, -y-ddy, x,  -y-ddy) ;
          fTeXlabel(x/2,  -y-ddy, "cc", "$\\ell$") ;

          fLine(-ddy-w, y, -ddy+w, y ) ;
          fLine(-ddy-w, -y, -ddy+w, -y ) ;
          fArrow( -ddy,   1.2*w, -ddy, y) ;
          fArrow( -ddy, - 1.2*w, -ddy, -y) ;
          fTeXlabel(-ddy,  0, "cc", "$w$") ;




     }
}