                  /*  File:  triangleTh.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class triangleTh extends Template {

     static {templateClass = new triangleTh() ; }

     public void setup() {
          filePrefix = "triangleTh" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 0.9*1.8 ;      // in inches
          ysize = 0.6*1.8 ;   // in inches. 
          xmin = -1 ;
          xmax = 5 ;
          ymin = -1 ;
          ymax = 6 ;
          topmargin = 0 ;   // in inches
          bottommargin = -0.1 ;   // in inches
          leftmargin = -0.1 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
     

     double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
     double angle = Math.atan2(5, 4) ;
     double x   = 4 ;
     double y   = 5 ;
     double r = 0.1 ;

     fEnv("lineWidth", 0.5) ;
     fLine(xmin, 0, xmax, 0) ;
     fLine(0, ymin, 0, ymax) ;
     fTeXlabel(xmax, -0.2, "tr", "$x$") ;
     fTeXlabel(-0.2, ymax, "tr", "$y$") ;


     fEnv("lineWidth", 0.5) ;
     fLine(0, 0, x, 0) ;
     fLine(0, 0, x, y) ;
     fLine(x, 0,  x, y) ;
     fDisk(x,y, r,r*aspect, FILLED) ;

     fTeXlabel(1.1,0.2, "bl", "$\\theta(x,y)$") ;
     fTeXlabel(x/2, -0.5, "tc", "$x$") ;
     fTeXlabel(x+0.2, y/2, "lc", "$y$") ;
     fTeXlabel(0.7*x, 0.7*y-0.1, "br", "$\\scriptstyle\\sqrt{x^2+y^2}$") ;
     fTeXlabel(x+0.1, y+0.1, "bl", "$(x,y)$") ;
          
     }
}
