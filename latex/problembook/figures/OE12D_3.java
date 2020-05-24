                  /*  File:  OE12D_3.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class OE12D_3 extends Template {

     static {templateClass = new OE12D_3() ; }

     public void setup() {
          filePrefix = "OE12D_3" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.0*0.6 ;   
          ysize = 3.2*0.6 ;   
          xmin = -0.1  ;
          xmax = 2.9 ;
          ymin = -1.0 ;
          ymax = 2.2 ;
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
          double r = 0.06 ;
          double Y = -0.5 ;
          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;


          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 1.5) ;
          fEnv("psFillColor", Red) ;
          fLine(1,1, 2,2) ;

          fArrowhead(1.55,1.55, 45) ; 
          fTeXlabel(1.5,  1.7, "bc", "$L$") ;

          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ;
          fLine( 2,2, 2,Y) ;      fArrowhead(2, 0.5*2+0.5*Y, -90) ; 
          fTeXlabel(2.1,  0.5*2+0.5*Y, "lc", "$L_1$") ;
          fLine( 2,Y, 1,Y) ;      fArrowhead(1.5, Y, 180) ;
          fTeXlabel(1.5,  Y-0.15, "tc", "$L_2$") ;
          fLine( 1,Y, 1,1) ;      fArrowhead(1, 0.5*1+0.5*Y, 90) ;
          fTeXlabel(0.9,  0.5*1+0.5*Y, "rc", "$L_3$") ;


          fEnv("psFillColor", Red) ;
          fDisk(1,1, r,r, FILLED) ;
          fDisk(2,2, r,r, FILLED) ;
          fTeXlabel(1,  1.1, "br", "$(1,1)$") ;
          fTeXlabel(2,  2.1, "bl", "$(2,2)$") ;

          fEnv("psFillColor", Blue) ;
          fDisk(1,Y, r,r, FILLED) ;
          fDisk(2,Y, r,r, FILLED) ;
          fTeXlabel(1,  Y-0.1, "tr", "$(1,Y)$") ;
          fTeXlabel(2,  Y-0.1, "tl", "$(2,Y)$") ;





          fTeXlabel(xmax, -0.15, "tr", "$x$") ;
          fTeXlabel(-0.05, ymax, "tr", "$y$") ;





     }
}
