                  /*  File:  OE11D_6.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class OE11D_6 extends Template {

     static {templateClass = new OE11D_6() ; }

     public void setup() {
          filePrefix = "OE11D_6" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.5*0.8 ;   
          ysize = 1.5*0.8 ;   
          xmin = -0.1  ;
          xmax = 2.5 ;
          ymin = -0.1 ;
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
          double Y = 1.0 ;
          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;


          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 1.5) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ;
          fLine( 0,0, 0,Y) ;      fArrowhead(0, 0.5*Y, 90) ; 
          fTeXlabel(-0.07,  0.5*Y, "rc", "$L_1$") ;
          fLine( 0,Y, 2,Y) ;      fArrowhead(1.0, Y, 0) ;
          fTeXlabel(1.0,  Y+0.1, "bc", "$L_2$") ;
          fLine( 2,Y, 2,0) ;      fArrowhead(2, 0.5*Y, -90) ;
          fTeXlabel(2.07,  0.5*Y, "lc", "$L_3$") ;


          fEnv("psFillColor", Red) ;
          fDisk(0,0, r,r, FILLED) ;
          fDisk(2,0, r,r, FILLED) ;
          fTeXlabel(-0.05,  -0.05, "tr", "$(0,0)$") ;
          fTeXlabel(2,  -0.05, "tr", "$(2,0)$") ;

          fEnv("psFillColor", Blue) ;
          fDisk(0,Y, r,r, FILLED) ;
          fDisk(2,Y, r,r, FILLED) ;
          fTeXlabel(-0.05,  Y+0.05, "br", "$(0,Y)$") ;
          fTeXlabel(2,  Y+0.05, "bl", "$(2,Y)$") ;

          fTeXlabel(xmax, -0.05, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$y$") ;





     }
}
