                  /*  File:  polar1.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class polar1 extends Template {

     static {templateClass = new polar1() ; }

     public void setup() {
          filePrefix = "polar1" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.0*0.7 ;      // in inches
          ysize = 1.0*0.7 ;   // in inches. 
          xmin = -2 ;
          xmax = 8 ;
          ymin = -2 ;
          ymax =  8 ;
          topmargin = 0.0 ;   // in inches
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
          fLine(xmin,0,xmax,0) ;
          fLine(0,ymin,0,ymax) ;
          fTeXlabel(xmax,-0.3, "tr", "$x$") ;
          fTeXlabel(-0.3, ymax, "tr", "$y$") ;
          double r = 8 ; double th = 45 ; double thrad=th*Math.PI/180.0 ;
          double x = r*Math.cos(thrad) ; double y = r*Math.sin(thrad) ; 
          fLine(0, 0,  x, y) ;
          fDisk(x,y, 0.25, 0.25, FILLED) ;
          fEllipticalArc(0, 0, 1, 1, 0, th, OPEN) ;
          fTeXlabel(x+0.2,y, "bl", "$(x,y)$") ;
          fTeXlabel(0.6*x,0.6*y+0.2, "br", "$r$") ;
          fTeXlabel(1.5,0.3, "bl", "$\\theta$") ;

     }
}
