                  /*  File:  trapGn.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class trapGn extends Template {

     static {templateClass = new trapGn() ; }

     public void setup() {
          filePrefix = "trapGn" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 0.4*2 ;      // in inches
          ysize = 0.8*2 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -1 ;
          xmax = 2 ;
          ymin = -3 ;
          ymax = 3 ;
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
          fEnv("psFillGray", 0.8) ;
         { double[] xlist = {0, 0, 1,1} ;
           double[] ylist = {2,-2,-1,1} ;
           fPolygon(xlist, ylist,  4, FILLED) ; }
          fEnv("psFillGray", 0.0) ;
          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax+0.1,0, "lc", "$x$") ;
          fTeXlabel(0,ymax+0.1, "bc", "$y$") ;

          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;

          fEnv("lineWidth", 1.5) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;   
          fLine(0, 2, 0, -2) ;
          fLine(0, 2, 1, 1) ;
          fLine(1, -1, 1, 1) ;
          fLine(1, -1, 0, -2) ;
          double r = 0.12 ;
          fDisk(0,2, r, r, FILLED) ;
          fDisk(0,-2, r, r, FILLED) ;
          fDisk(1,1, r, r, FILLED) ;
          fDisk(1,-1, r, r, FILLED) ;

          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Blue) ;
          fArrowhead(0,-0.25, -90) ;
          fArrowhead(0.5,-1.5, 45) ;
          fArrowhead(1,0.25, 90) ;
          fArrowhead(0.5,1.5, 135) ;

          
          fTeXlabel(-0.1,2, "br", "$(0,2)$") ;
          fTeXlabel(-0.1,-2, "tr", "$(0,-2)$") ;
          fTeXlabel(1.1,1, "bl", "$(1,1)$") ;
          fTeXlabel(1.1,-1, "tl", "$(1,-1)$") ;
          fTeXlabel(0.5,0.5, "cc", "$T$") ;
     }
}
