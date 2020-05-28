                  /*  File:  reparCircleB.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class reparCircleB extends Template {

     static {templateClass = new reparCircleB() ; }

     public void setup() {
          filePrefix = "reparCircleB" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.6*0.7 ;   
          ysize = 1.5*0.7 ;   
          xmin = -1.3  ;
          xmax = 1.3 ;
          ymin = -0.2 ;
          ymax = 1.3 ;
          topmargin = 0.0 ;
          bottommargin = 0.0 ;
          leftmargin = 0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 0.5) ;
          fLine(xmin,0, xmax, 0) ;
          fLine(0, ymin,0, ymax) ;
          fTeXlabel(xmax, -0.07, "tr", "$x$") ;
          fTeXlabel(-0.04, ymax, "tr", "$y$") ;
          fTeXlabel(-0.85, 0.5, "br", "$x^2+y^2=r^2$") ;


          fEnv("lineWidth", 1.0) ;
          fCurve("[cos(t), sin(t)]", 1, 0, Math.PI, OPEN) ;

          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          double r = 0.07 ;

          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          double th = 45*Math.PI/180.0 ; double R=0.2 ;
          double x = Math.cos(th) ; double y = Math.sin(th) ;
          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fLine(0, y, x, y) ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fDisk(x, y, r, r*aspect, FILLED) ;
          fTeXlabel(x+0.05, y+0.03, "bl", "$\\big(x\\,,\\,\\sqrt{r^2-x^2}\\,\\big)$") ;
          fTeXlabel(x/2, y-0.05, "tc", "$x$") ;

          canvas.append( new fPsWrite(Black+"\n")) ;


     }
}
