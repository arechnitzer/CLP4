                  /*  File:  resonance.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class resonance extends Template {

     static {templateClass = new resonance() ; }

     public void setup() {
          filePrefix = "resonance" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2*1.25 ;      // in inches
          ysize = 1.25*1.25 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -0.1 ;
          xmax = 10 ;
          ymin = -0.1 ;
          ymax = 10 ;
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
          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;

          fTeXlabel(xmax, -0.2 , "tr", "$\\om$") ;
          fTeXlabel(-0.1, ymax, "tr", "$\\cA$") ;
          fEnv("lineWidth", 1.0) ;
          double E =  1 ;
          double a =  0.01 ; // = L*L*C*C 
          double b =  Math.sqrt(0.0395) ; // = 2*L*C - R*R*C*C 
          fCurve("  y="+E+"/sqrt("+a+"*x*x*x*x-"+b+"*x*x+1)  ",
                     0, 0.0, xmax, OPEN) ;
     }
}
