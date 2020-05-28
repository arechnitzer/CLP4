                  /*  File:  mobiusA.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class mobiusA extends Template {

     static {templateClass = new mobiusA() ; }

     public void setup() {
          filePrefix="mobiusA";
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0*70/40*0.7 ;   // in inches
          ysize = 2.0*0.7 ;   // in inches
          xmin = -3 ;
          xmax = 67 ;
          ymin = -20 ;
          ymax = 20 ;
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
          double x = 60 ;
          int    nx = 12 ;
          double dx = x/nx ;
          double y = 15 ;
          int    ny = 3 ;
          double dy = y/ny ;

          String Black = "0 0 0 1 setcmykcolor  " ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Yellow = "0 0 1 0 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          String GGreen = "1 0 1 0.2 setcmykcolor  " ;

          fEnv("lineWidth", 0.5) ;
          fEnv("headHalfWidth", 1.5) ;
          fEnv("headLength", 4.5) ;
          fLine(xmin, 0, xmax, 0) ; 
          fTeXlabel(xmax, -1 , "tr", "$\\theta$") ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(-1, ymax, "tr", "$v$") ;

          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          for (int n1 = 0; n1 <= nx ; n1++) {
               fLine(n1*dx, -y, n1*dx, y) ;
          }
          fEnv("lineWidth", 1.5) ;
          fLine(0, -y, 0, y) ;
          fLine(x, -y, x, y) ;

          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          for (int n2 = -ny; n2 <= ny ; n2++) {
               fLine(0, n2*dy, x, n2*dy) ;
          }
          fEnv("lineWidth", 1.5) ;
          fLine(0, y, x, y) ;
          canvas.append( new fPsWrite(GGreen+"\n")) ;
          fLine(0,-y, x,-y) ;

          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("lineWidth", 0.5) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
//          fArrowhead(0, y/2, 90) ;
//          fArrowhead(x, -y/2, -90) ;
          fArrow(0, 0, 0, 0.95*y) ;
          fArrow(x, 0, x, -0.95*y) ;


     }
}