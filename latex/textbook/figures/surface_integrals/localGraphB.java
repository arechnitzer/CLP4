                  /*  File:  localGraphB.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class localGraphB extends Template {

     static {templateClass = new localGraphB() ; }

     public void setup() {
          filePrefix = "localGraphB" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 4.4*0.5 ;   
          ysize = 3.3*0.5 ;   
          xmin = -1.2  ;
          xmax = 3.2 ;
          ymin = -1.5 ;
          ymax = 1.8 ;
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
          fTeXlabel(-0.85, -0.5, "tr", "$x^2+y^2+z^2=1$") ;


          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite("[3 3] 1.4 setdash\n")) ;
          fDisk(1,0, Math.sqrt(2), Math.sqrt(2), CLOSED) ;
          fTeXlabel(2.3, -0.5, "tl", "$(x-1)^2+y^2+z^2=2$") ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;


          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          double r = 0.07 ;

          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          fEnv("lineWidth", 1.0) ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fCurve("[cos(t), sin(t)]", 1, 0, 2*Math.PI, OPEN) ;
          fDisk(0, 1, r, r*aspect, FILLED) ;
          fTeXlabel(-0.05,1.05, "br", "$(0,0,1)$") ;
          fDisk(1, 0, r, r*aspect, FILLED) ;
          fTeXlabel(1.05,-0.1, "tl", "$(1,0,0)$") ;
          fTeXlabel(xmax, -0.07, "tr", "$x$") ;
          fTeXlabel(-0.05, ymax, "tr", "$z$") ;

     }
}
