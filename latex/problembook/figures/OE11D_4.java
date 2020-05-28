                  /*  File:  OE11D_4.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class OE11D_4 extends Template {

     static {templateClass = new OE11D_4() ; }

     public void setup() {
          filePrefix = "OE11D_4" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0*0.7 ;   
          ysize = 2.0*0.7 ;   
          xmin = -0.5  ;
          xmax = 1.5 ;
          ymin = -0.5 ;
          ymax = 1.5 ;
          topmargin = 0.0 ;
          bottommargin = 0 ;
          leftmargin = 0.0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          fEnv("headHalfWidth", 2.0*1.5) ;
          fEnv("headLength", 6.0*1.5) ;
          fEnv("lineWidth", 0.5) ;
          double r = 0.05 ;
          double L = 0.5 ;
          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;


          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 1.5) ;
          fEnv("psFillColor", Red) ;
          fLine(0,0, 1,0) ;
          fDisk(0,0, r,r, FILLED) ;
          fLine( 1,0, 1,1) ;  
          fDisk(1,0, r,r, FILLED) ;
          fLine( 1,1, 0,1) ;
          fDisk(1,1, r,r, FILLED) ;
          fLine( 0,1, 0,0) ;    
          fDisk(0,1, r,r, FILLED) ;

          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("psFillColor", Black) ;
          fEnv("lineWidth", 0.5) ;
          fArrow(0.5, 0, 0.5, -L) ;
          fArrow(0.5, 1, 0.5, 1+L) ;
          fArrow(0, 0.5, -L, 0.5) ;
          fArrow(1, 0.5, 1+L, 0.5) ;


          fTeXlabel(1.05,  1.1, "cl", "$(1,1)$") ;
          fTeXlabel(1,  -0.1, "tl", "$(1,0)$") ;
          fTeXlabel(-0.05,  1.1, "cr", "$(0,1)$") ;


          fTeXlabel(0.5, 0.07, "cb", "$L_1$") ;
          fTeXlabel(0.95, 0.5, "cr", "$L_2$") ;
          fTeXlabel(0.5, 0.93, "ct", "$L_3$") ;
          fTeXlabel(0.05, 0.5, "cl", "$L_4$") ;

          fTeXlabel(xmax+0.05, 0, "cl", "$x$") ;
          fTeXlabel(-0.05, ymax, "tr", "$y$") ;





     }
}
