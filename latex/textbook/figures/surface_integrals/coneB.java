                  /*  File:  coneB.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class coneB extends Template {

     static {templateClass = new coneB() ; }

     public void setup() {
          filePrefix = "coneB" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2*0.7 ;      
          ysize = 2*150/120*0.8 ;  
          xmin = -60 ;
          xmax = 60 ;
          ymin = -10 ;
          ymax = 90 ;
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
          double r = 30 ;
          double h = 50 ;
          double y = h ;
          double x = r*y/h ;
          fEnv("lineWidth", 1) ;
          fEnv("psFillGray", 0.8) ;
          fDisk(0,h,x,x/3.0, CLOSED+FILLED) ;
          fLine(0,0, -x,h) ;
          fLine(0,0, x,h) ;
          fTeXlabel(x/2+5, h/2, "cl", "$x^2+y^2=z^2$") ;
     }
}
