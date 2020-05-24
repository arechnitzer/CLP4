                  /*  File:  limitsv2.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class limitsv2 extends Template {

     static {templateClass = new limitsv2() ; }

     public void setup() {
          filePrefix = "limitsv2" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.1*0.3 ;   
          ysize = 4.1*0.3 ;   
          xmin = -0.2 ;
          xmax =  2.9 ;
          ymin = -0.2 ;
          ymax =  3.9 ;
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
          double b = 3 ;
          fEnv("lineWidth", 1.0) ;
          { double[] xlist = {0, a, 0, 0} ;
            double[] ylist = {0, 0, b, 0} ;
            fPolygon(xlist, ylist, 4, CLOSED) ; }
          fEnv("lineWidth", 3.0) ;
          double x = 0.7 ;
          double y = (6-3*x)/2  ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fLine(x,y, x, 0) ;
          canvas.append( new fPsWrite(Black+"\n")) ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fLine(0, 3, -0.2, 3) ;
          fLine(2, 0, 2, -0.2) ;

          fTeXlabel(xmax,-0.15, "tr", "$x$") ;
          fTeXlabel(-0.08,ymax, "tr", "$y$") ;
          fTeXlabel(1.5,1.2, "cl", "$y=\\frac{3}{2}(2-x)$") ;
          fTeXlabel(-0.25,3.0, "cr", "$3$") ;
          fTeXlabel(2.0,-0.27, "tc", "$2$") ;

     }
}
