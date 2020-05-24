                  /*  File:  torusTop.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class torusTop extends Template {

     static {templateClass = new torusTop() ; }

     public void setup() {
          filePrefix = "torusTop" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;   
          ysize = 2.0 ;   
          xmin = -1.2  ;
          xmax = 1.2 ;
          ymin = -1.2 ;
          ymax = 1.2 ;
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
          double th = 40 ;
          double thRad = th*Math.PI/180.0 ; 
          double R=0.3 ;
          double r = 0.05 ;
          double rho = 0.9 ;
          double x = rho*Math.cos(thRad) ; double y = -rho*Math.sin(thRad) ;
          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax,0) ;
          fTeXlabel(xmax, -0.03, "tr", "$y$") ;
          fLine(0, ymin, 0,ymax) ;
          fTeXlabel(-0.015, ymin, "br", "$x$") ;

          fTeXlabel(xmax/2+0.2, ymin, "bc", "top view") ;
          fLine(0, 0, x, y) ;
          fEllipticalArc(0, 0, R, R, -90, -th, OPEN) ;
          fTeXlabel(0.2*0.85, -(R+0.1)*0.85, "ct", "$\\psi$") ;



          fEnv("lineWidth", 1.0) ;
          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fDisk(0, 0, rho, rho, CLOSED) ;
          fDisk(rho, 0, r, r, FILLED) ;
          fTeXlabel(rho+0.06, 0.04, "bl",
                "$(0,\\rho,r\\sin\\theta)$") ;
          fEnv("psFillColor", Black) ;
          fDisk(x, y, r, r, FILLED) ;
          fTeXlabel(x+0.08, y+0.02, "tl",
                "$(\\rho\\cos\\psi,\\rho\\sin\\psi,r\\sin\\theta)$") ;
     }
}
