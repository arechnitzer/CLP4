                  /*  File:  coneCylA.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class coneCylA extends Template {

     static {templateClass = new coneCylA() ; }

     public void setup() {
          filePrefix = "coneCylA" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.6 ;   
          ysize = 1.6 ;   
          xmin = -1.3  ;
          xmax = 1.3 ;
          ymin = -1.3 ;
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
          fLine(xmin,-1, xmax, -1) ;
          fLine(0, ymin,0, ymax) ;
          fTeXlabel(xmax, -1.07, "tr", "$x$") ;
          fTeXlabel(-0.04, ymax, "tr", "$y$") ;
          fTeXlabel(-0.87, 0.5, "br", "$x^2+y^2=2ax$") ;



          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          double r = 0.05 ;

//          fEnv("useColorPs", "true") ;
          String Pink = "1 0.3333 0.6666 setrgbcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          double th = 60*Math.PI/180.0 ; double R=0.2 ;
          double x = 2*Math.cos(th)*Math.sin(th) ; 
          double y = 2*Math.sin(th)*Math.sin(th) ;
          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite("0.5 setgray\n")) ;
          fEllipticalArc(0, -1, R, R, 0, 60, OPEN) ;
          fLine(0, -1, x, y-1) ;

          canvas.append( new fPsWrite(Pink+"\n")) ;
//          fEnv("psFillColor", Pink) ;
          fEnv("lineWidth", 1.5) ;
          fCurve("[cos(t), sin(t)]", 1, 0, 2*Math.PI, OPEN) ;

          canvas.append( new fPsWrite("0.0 setgray\n")) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fDisk(x, y-1, r, r*aspect, FILLED) ;
          fTeXlabel(R+0.07, -1+0.1, "cb", "$\\theta$") ;
          fTeXlabel(x/2-0.07, y/2-1, "cb", "$r$") ;
          fDisk(0, 0, r, r*aspect, FILLED) ;
          fTeXlabel(-r-0.03, 0, "cr", "$(0,a)$") ;




     }
}
