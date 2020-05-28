                  /*  File:  heat2.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class heat2 extends Template {

     static {templateClass = new heat2() ; }

     public void setup() {
          filePrefix = "heat2" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.75 ;      // in inches
          ysize = 1.75 ;   // in inches. 
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
          fEnv("lineWidth", 0.5) ;
          fDisk(20, 0, 80, 60, CLOSED+FILLED) ;
          fEnv("lineWidth", 1.5) ;
          fEllipticalArc(20, 0, 80, 60, 80, 100, OPEN) ;
          fTeXlabel(10,65,"br", "$\\dee{S}$") ;
          fTeXlabel(20,0,"cc", "$V$") ;
          fTeXlabel(93,30,"bl", "$\\partial V$") ;
          fEnv("lineWidth", 0.5) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          fArrow(20, 60, 20, 100) ;
          fTeXlabel(25,100,"lc", "$\\hn$") ;

     }
}
