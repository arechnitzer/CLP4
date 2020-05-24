                  /*  File:  limitsv3.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class limitsv3 extends Template {

     static {templateClass = new limitsv3() ; }

     public void setup() {
          filePrefix = "limitsv3" ;
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
          double y = 1  ;
          double x = (6-2*y)/3 ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fLine(x,y, 0, y) ;
          canvas.append( new fPsWrite(Black+"\n")) ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fLine(0, 3, -0.2, 3) ;
          fLine(2, 0, 2, -0.2) ;

          fTeXlabel(xmax,-0.15, "tr", "$x$") ;
          fTeXlabel(-0.08,ymax, "tr", "$y$") ;
          fTeXlabel(1.5,1.2, "cl", "$x=\\frac{1}{3}(6-2y)$") ;
          fTeXlabel(-0.25,3.0, "cr", "$3$") ;
          fTeXlabel(2.0,-0.27, "tc", "$2$") ;

     }
}
