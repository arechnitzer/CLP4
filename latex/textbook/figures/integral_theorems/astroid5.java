                  /*  File:  astroid5.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class astroid5 extends Template {

     static {templateClass = new astroid5() ; }

     public void setup() {
          filePrefix = "astroid5" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1 ;      // in inches
          ysize = 1 ;   // in inches. 
          xmin = -100 ;
          xmax = 100 ;
          ymin = -100 ;
          ymax = 100 ;
          topmargin = 0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = -0.1 ;   // in inches
          rightmargin = -0.1 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 1.0) ;
          fCurve("[100*cos(t)*cos(t)*cos(t) , 100*sin(t)*sin(t)*sin(t)]", 1, 0, 2*Math.PI,                   OPEN) ;
          fTeXlabel(0,-125, "cc", "piecewise smooth") ;
          fTeXlabel(0,-155, "cc", "curve") ;

     }
}
