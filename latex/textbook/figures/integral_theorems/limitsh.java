                  /*  File:  limitsh.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class limitsh extends Template {

     static {templateClass = new limitsh() ; }

     public void setup() {
          filePrefix = "limitsh" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;   
          ysize = 1.0 ;   
          xmin = -3 ;
          xmax =  3 ;
          ymin = -2 ;
          ymax = 2 ;
          topmargin = 0.1 ;
          bottommargin = 0 ;
          leftmargin = 0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          double a = 2 ;
          double b = Math.sqrt(2) ;
          fDisk(0, 0, a, b, CLOSED) ;
          fEnv("lineWidth", 3.0) ;
          double y = 0.8 ;
          double x = Math.sqrt(4-2*y*y) ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fLine(x,y, -x, y) ;
          canvas.append( new fPsWrite(Black+"\n")) ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;

          fTeXlabel(xmax,-0.15, "tr", "$x$") ;
          fTeXlabel(-0.08,ymax, "tr", "$y$") ;
          fTeXlabel(1.7,1.2, "cl", "$x^2+2y^2=4$") ;

     }
}
