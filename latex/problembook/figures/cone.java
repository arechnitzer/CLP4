                  /*  File:  cone.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class cone extends Template {

     static {templateClass = new cone() ; }

     public void setup() {
          filePrefix = "cone" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 65*0.025 ;      // in inches
          ysize = 75*0.025 ;   // in inches. 
          xmin = -5 ;
          xmax = 60 ;
          ymin = -5 ;
          ymax = 70 ;
          topmargin = -0.2 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double x1 = 40 ; double y1 = 40 ;
          double rx = 15 ; double ry = 5 ;
          double h = 15 ;
          fEnv("lineWidth", 1.5) ;
          fEnv("psFillGray", 0.7) ;
          fDisk(x1, y1, rx, ry, BOUNDARY+FILLED) ;
          fEnv("lineWidth", 0.5) ;
          fLine(0,0, x1-rx, y1) ;
          fLine(0,0, x1+rx, y1-1) ;

          fEnv("headLength", 6.0*1.2) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fArrow(0,0, x1, y1) ;
          fArrow(x1,y1, x1, y1+h) ;
          fTeXlabel(x1+2,y1+h, "cl", "$\\hn$") ;
          fTeXlabel(0,0, "tr", "$(0,0,0)$") ;
          fTeXlabel(x1-0.7*rx,y1-2*ry, "br", "$\\vr$") ;
          fTeXlabel(x1+rx-2,y1+0.3*h, "bl", "$\\dee{S}$") ;
     }
}
