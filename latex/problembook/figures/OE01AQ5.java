                  /*  File:  OE01AQ5.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE01AQ5 extends Template {

     static {templateClass = new OE01AQ5() ; }

     public void setup() {
          filePrefix = "OE01AQ5" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 14*0.15 ;      // in inches
          ysize = 13*0.15 ;   // in inches. 
          xmin = -5 ;
          xmax = 9 ;
          ymin = -6.5 ;
          ymax =  6.5 ;
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
          double R1 = 1.5 ;
          double R9 = 6 ; double XC9 = 2 ; 
          fEnv("lineWidth", 1.0) ;
          fEnv("psFillGray", 0.8) ;
          fDisk(XC9,0, R9,R9, FILLED) ;
          fEnv("psFillGray", 1.0) ;
          fDisk(0,0, R1, R1, FILLED) ;
          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(R1+0.2,0.3, "bl", "$\\cC_3$") ;
          fTeXlabel(R9+XC9+0.2,0.2, "bl", "$\\cC_2$") ;
          fTeXlabel(XC9+3,2, "cc", "$W$") ;
          fDisk(0,0, R1, R1,  CLOSED) ;
          fDisk(XC9,0, R9,R9, CLOSED) ;
          double x = R1/Math.sqrt(2) ;
          fEnv("headLength", 6.0*1.2) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fArrowhead(x, x, 135) ;
          double xx = XC9+R9/Math.sqrt(2) ;
          double yy = R9/Math.sqrt(2) ;
          double th = 135 ;
          fArrowhead(xx, yy, th) ;

     }

}

