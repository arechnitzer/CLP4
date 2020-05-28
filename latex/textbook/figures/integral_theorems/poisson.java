                  /*  File:  poisson.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class poisson extends Template {

     static {templateClass = new poisson() ; }

     public void setup() {
          filePrefix = "poisson" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2 ;      // in inches
          ysize = 2 ;   // in inches. 
          xmin = -100 ;
          xmax = 100 ;
          ymin = -100 ;
          ymax = 100 ;
          topmargin = 0 ;   // in inches
          bottommargin = -0.2 ;   // in inches
          leftmargin = -0.1 ;   // in inches
          rightmargin = -0.1 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("psFillGray", 0.8) ;
          fEnv("lineWidth", 1.0) ;
          fDisk(20, 0, 80, 60, CLOSED+FILLED) ;
          fEnv("psFillGray", 1.0) ;
          fDisk(0, 0, 30, 30, CLOSED+FILLED) ;
          fEnv("psFillGray", 0.0) ;
          fDisk(0, 0, 2,  2, FILLED) ;
          fTeXlabel(0,0,"tr", "$\\vr_0$") ;
          fTeXlabel(65,0,"cc", "$V_\\veps$") ;
          fTeXlabel(90,30,"bl", "$V$") ;
          fTeXlabel(23,20,"bl", "$S_\\veps$") ;
          fEnv("lineWidth", 0.3) ;
          fArrow(0, 30, 0, 10) ;
          fArrow(20, 60, 20, 80) ;

     }
}
