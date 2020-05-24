                  /*  File:  GreenDiv.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class GreenDiv extends Template {

     static {templateClass = new GreenDiv() ; }

     public void setup() {
          filePrefix = "GreenDiv" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.6*1.3 ;   
          ysize = 1.8*1.3 ;   
          xmin = -0.1 ;
          xmax = 1.5 ;
          ymin = -0.5 ;
          ymax = 1.3;
          topmargin = 0.0 ;
          bottommargin = 0.0 ;
          leftmargin = 0.0 ;
          rightmargin = 0.0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;

          fEnv("lineWidth", 1.5) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillGray", 0.8) ;
          fDisk(0.5, 0.5, 0.4, 0.3, FILLED) ;
          fDisk(0.5, 0.5, 0.4, 0.3, CLOSED) ;

          fEnv("psFillColor", Blue) ;
          fEnv("useColorPs", "true") ;
          fEnv("headLength", 6.0*1.2) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fArrowhead(0.5, 0.2, 0) ;
          fTeXlabel(0.7,0.23, "tl", "$C$") ;
          fTeXlabel(0.5,0.5, "cc", "$R$") ;

          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("psFillColor", Black) ;
          fEnv("lineWidth", 0.5) ;
          fEnv("headLength", 6.0*1.0) ;
          fEnv("headHalfWidth", 2.0*1.0) ;
          fArrow(0.5+0.4,0.5, 0.5+0.4+0.2, 0.5) ;
          fTeXlabel(0.5+0.4+0.17,0.54, "bc", "$\\hn$") ;


          fLine(xmin, 0.1, xmax, 0.1) ;
          fLine(0.0, 0.0, 0.0, 0.8) ;
          fTeXlabel(xmax, 0.05, "tr", "$x$") ;
          fTeXlabel(-0.03, 0.8, "tr", "$y$") ;


     }
}
