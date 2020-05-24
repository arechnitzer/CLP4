                  /*  File:  revTop.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class revTop extends Template {

     static {templateClass = new revTop() ; }

     public void setup() {
          filePrefix = "revTop" ;
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
          fEllipticalArc(0, 0, R, R, -th, 0, OPEN) ;
          fTeXlabel((R+0.13)*0.85, -0.07*0.85, "ct", "$\\theta$") ;



          fEnv("lineWidth", 1.0) ;
          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fDisk(0, 0, rho, rho, CLOSED) ;
          fEnv("psFillColor", Blue) ;
          fDisk(rho, 0, r, r, FILLED) ;
          fTeXlabel(rho+0.06, 0.04, "bl",
                "$(0,Y,e^Y)$") ;
          fEnv("psFillColor", Red) ;
          fDisk(x, y, r, r, FILLED) ;
          fTeXlabel(0.55*x, 0.55*y-0.05, "tr", "$Y$") ;
          fTeXlabel(x+0.08, y+0.02, "tl",
                "$(Y\\sin\\theta,Y\\cos\\theta,e^Y)$") ;
     }
}
