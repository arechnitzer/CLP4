                  /*  File:  OE06A_4.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class OE06A_4 extends Template {

     static {templateClass = new OE06A_4() ; }

     public void setup() {
          filePrefix = "OE06A_4" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.7*0.6 ;   
          ysize = 4.8*0.3 ;   
          xmin = -0.1  ;
          xmax = 1.6 ;
          ymin = -2.4 ;
          ymax = 2.4 ;
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
          double X = 0.7 ;
          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;


          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 1.5) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ;
          fLine( 0,0, 1,-2) ;      fArrowhead(0.5, -1.0, -60) ; 
          fLine( 0,0, 1,2) ;      fArrowhead(1.0, 0.0, 90) ;
          fLine( 1,2, 1,-2) ;      fArrowhead(0.5, 1.0, -120) ;
          fTeXlabel(0.73, 1.5, "br", "${\\scriptstyle y=2x}$") ;
          fTeXlabel(0.73, -1.5, "tr", "${\\scriptstyle y=-2x}$") ;
//          fTeXlabel(0.73, 1.5, "br", "$y=2x$") ;



          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fDisk(0,0, r,r*aspect, FILLED) ;
          fDisk(1,-2, r,r*aspect, FILLED) ;
          fTeXlabel(-0.05,  -0.05, "tr", "$(0,0)$") ;
          fTeXlabel(1,  -2-0.05, "tl", "$(1,-2)$") ;
          fDisk(1,2, r,r*aspect, FILLED) ;
          fTeXlabel(1,  2+0.05, "bl", "$(1,2)$") ;

          fEnv("lineWidth", 3.0) ;
          fLine(X,-2*X, X,2*X) ;


          fTeXlabel(xmax, -0.05, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$y$") ;





     }
}
