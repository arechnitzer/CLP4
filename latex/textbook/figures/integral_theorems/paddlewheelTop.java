                  /*  File:  paddlewheelTop.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class paddlewheelTop extends Template {

     static {templateClass = new paddlewheelTop() ; }

     public void setup() {
          filePrefix = "paddlewheelTop" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.5 ;      // in inches
          ysize = 2.5 ;   // in inches. 
          xmin = -5 ;
          xmax = 5 ;
          ymin = -5 ;
          ymax = 5 ;
          topmargin = 0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 0.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
//          fLine(xmin, 0, xmax, 0) ;
//          fLine(0, ymin, 0, ymax) ;
//          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
//          fTeXlabel(-0.1, ymax, "tr", "$y$") ;
          canvas.append( new fPsWrite(Black+"\n")) ;



          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          double R1 = 1.6 ; 
          double R2 = 2.4 ;
          double R3 = 0.2 ;
          fEnv("lineWidth", 1.0) ;
          fLine(-R1,0,R1,0) ;
          fLine(0,-R1,0,R1) ;
          fEnv("lineWidth", 4.0) ;
          fLine(-R1,0,-R2,0) ;
          fLine(R1,0,R2,0) ;
          fLine(0,-R1,0,-R2) ;
          fLine(0,R1,0,R2) ;
          fDisk(0,0, R3,R3, FILLED) ;
          
     }
}
