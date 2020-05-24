                  /*  File:  astroidS.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class astroidS extends Template {

     static {templateClass = new astroidS() ; }

     public void setup() {
          filePrefix = "astroidS" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2 ;      // in inches
          ysize = 2 ;   // in inches. 
          xmin = -5 ;
          xmax = 90 ;
          ymin = -5 ;
          ymax = 90 ;
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
          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin,0, xmax, 0) ;
          fLine(0, ymin,0, ymax) ;
          fTeXlabel(xmax, -3, "tr", "$x$") ;
          fTeXlabel(-1.5, ymax, "tr", "$y$") ;
          fEnv("lineWidth", 1.0) ;
          fCurve("[80*cos(t)*cos(t)*cos(t) , 80*sin(t)*sin(t)*sin(t)]", 1, 0, Math.PI/2,                   OPEN) ;
          fEnv("lineWidth", 0.5) ;
          fEnv("psFillColor", Blue) ;
          fCurve("[87*cos(t)*cos(t)*cos(t) , 87*sin(t)*sin(t)*sin(t)]", 1, 
                Math.PI/12, Math.PI/4,  OPEN) ;
          double t = Math.PI/4 ; double s = 3*20*(1-Math.cos(2*t) ) ;
          double x = 80*Math.cos(t)*Math.cos(t)*Math.cos(t) ;
          double y = 80*Math.sin(t)*Math.sin(t)*Math.sin(t) ;
          double r = 2 ;
          fEnv("psFillColor", Red) ;
          fDisk(x, y, r, r, FILLED) ;
          x = 86*Math.cos(t)*Math.cos(t)*Math.cos(t) ;
          y = 86*Math.sin(t)*Math.sin(t)*Math.sin(t) ;
          fTeXlabel(x, y, "bl", "$\\vR(s)$") ;
          x = 77*Math.cos(t)*Math.cos(t)*Math.cos(t) ;
          y = 77*Math.sin(t)*Math.sin(t)*Math.sin(t) ;
          fTeXlabel(x, y, "tr", "$\\vr(t)$") ;
          double S = 0.6*s ;
          x = 80*(1-S/120)*Math.sqrt(1-S/120) ;
          y = 80*(S/120)*Math.sqrt(S/120) ;
          fTeXlabel(x*1.13, y*1.13, "bl", "$s$") ;



     }
}
