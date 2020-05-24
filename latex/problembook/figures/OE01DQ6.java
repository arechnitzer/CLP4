                  /*  File:  OE01DQ6.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE01DQ6 extends Template {

     static {templateClass = new OE01DQ6() ; }

     public void setup() {
          filePrefix = "OE01DQ6" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.5 ;   // in inches. 
          xmin = -6 ;
          xmax = 6 ;
          ymin = -6 ;
          ymax =  6 ;
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
          fEnv("lineWidth", 1.0) ;
          fEnv("psFillGray", 0.8) ;
          fDisk(0,0, 4,5, FILLED) ;
          fEnv("psFillGray", 1.0) ;
          fDisk(0,0, 1, 1, FILLED) ;
          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(1.2,0.3, "bl", "$C$") ;
          fTeXlabel(4.2,0.2, "bl", "$C_0$") ;
          fTeXlabel(-2,2, "cc", "$W$") ;
          fDisk(0,0, 1, 1,  CLOSED) ;
          fDisk(0,0, 4,5, CLOSED) ;
          double x = 1/Math.sqrt(2) ;
          fEnv("headLength", 6.0*1.2) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fArrowhead(x, x, 143) ;
          double xx = 4/Math.sqrt(2) ;
          double yy = 5/Math.sqrt(2) ;
          double th = Math.atan(1.2)*180/Math.PI ;
          fArrowhead(xx, yy, th+77) ;

     }

}

