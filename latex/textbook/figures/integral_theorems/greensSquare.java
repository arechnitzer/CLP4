                  /*  File:  greensSquare.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class greensSquare extends Template {

     static {templateClass = new greensSquare() ; }

     public void setup() {
          filePrefix = "greensSquare" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.9*0.7 ;   
          ysize = 1.2*0.7 ;   
          xmin = -0.1 ;
          xmax = 2.8 ;
          ymin = -0.1 ;
          ymax = 1.1;
          topmargin = -0.2 ;
          bottommargin = -0.2 ;
          leftmargin = -0.2 ;
          rightmargin = 0.2 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;
          fTeXlabel(xmax, -0.05, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$y$") ;

          fEnv("lineWidth", 2.0) ;
          fEnv("psFillGray", 0.8) ;
          { double[] xlist = {1, 2, 2, 1} ;
            double[] ylist = {0, 0, 1, 1} ;
            fPolygon(xlist, ylist, 4, FILLED) ; }
          fEnv("psFillColor", Red) ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          { double[] xlist = {1, 2, 2, 1} ;
            double[] ylist = {0, 0, 1, 1} ;
            fPolygon(xlist, ylist, 4, CLOSED) ; }
          fEnv("headLength", 6.0*1.5) ;
          fEnv("headHalfWidth", 2.0*1.5) ;
          fArrowhead(1.5, 0.0, 0) ;
          fArrowhead(2.0, 0.5, 90) ;
          fArrowhead(1.5, 1.0, 180) ;
          fArrowhead(1.0, 0.5, 270) ;

          fTeXlabel(2.1,0.5, "cl", "$C$") ;
          fTeXlabel(1.5,0.5, "cc", "$R$") ;
          fTeXlabel(1,-0.05, "tr", "$(1,0)$") ;
          fTeXlabel(1, 1.05, "br", "$(1,1)$") ;
          fTeXlabel(2,-0.05, "tl", "$(2,0)$") ;
          fTeXlabel(2, 1.05, "bl", "$(2,1)$") ;



     }
}
