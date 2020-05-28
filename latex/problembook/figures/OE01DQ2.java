                  /*  File:  OE01DQ2.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE01DQ2 extends Template {

     static {templateClass = new OE01DQ2() ; }

     public void setup() {
          filePrefix = "OE01DQ2" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.0 ;      // in inches
          ysize = 1.0 ;   // in inches. 
          xmin = -1 ;
          xmax = 4 ;
          ymin = -2.5 ;
          ymax =  2.5 ;
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
          fEnv("lineWidth", 0.2) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fEnv("lineWidth", 0.8) ;
          fCurve("[sqrt(t*t+5),t]", 1, ymin, ymax,  OPEN) ;
          fDisk(3,2, 0.15, 0.15, FILLED) ;
          fDisk(3,-2, 0.15, 0.15, FILLED) ;
          fTeXlabel(3.3,2, "cl", "$(3,2)$") ;
          fTeXlabel(3.3,-2, "cl", "$(3,-2)$") ;
          fArrowhead(Math.sqrt(5), 0, 90) ;

     }

}

