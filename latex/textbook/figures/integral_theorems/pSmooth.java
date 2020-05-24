                  /*  File: pSmooth.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class pSmooth extends Template {

     static {templateClass = new pSmooth() ; }

     public void setup() {
          filePrefix="pSmooth";//used as the prefix for the ps and lbl files
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 5.5*0.4 ;   // in inches
          ysize = 2.1*0.4 ;   // in inches
          xmin = 0.5 ;
          xmax =  5 ;
          ymin = -1 ;
          ymax = 1.1 ;
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
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;

          fEnv("lineWidth", 1.0) ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          double R = 1 ; double s = 0.1 ;
          fEllipticalArc(R,0,R,R, 0, 90, OPEN) ;
          fTeXlabel(1.5*R,0.85*R,"tr","$\\cC_1$") ;
          double x = R + R*Math.cos(Math.PI/4) ; double y = R*Math.sin(Math.PI/4) ; 
          fArrowhead(x,y, -45) ;
          
          fEllipticalArc(3*R,0,R,R, 0, 180, OPEN) ;
          fTeXlabel(3*R,0.85*R-0.5*s,"tc","$\\cC_2$") ;
          fArrowhead(3.0*R,R, 0) ;

          fLine(4*R,0, 5*R, 0) ;
          fTeXlabel(4.6*R, 1.5*s,"bc","$\\cC_3$") ;
          fArrowhead(4.5*R,0, 0) ;

     }
}
