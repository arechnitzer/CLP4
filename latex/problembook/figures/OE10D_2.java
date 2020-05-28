                  /*  File:  OE10D_2.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class OE10D_2 extends Template {

     static {templateClass = new OE10D_2() ; }

     public void setup() {
          filePrefix = "OE10D_2" ;
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
          fLine(-1, ymin,-1, ymax) ;
          fTeXlabel(xmax, -0.07, "tr", "$x$") ;
          fTeXlabel(-1.04, ymax, "tr", "$y$") ;
          fTeXlabel(0.9, 0.5, "bl", "$(x-1)^2+y^2=1$") ;

          double th = (90+25)*Math.PI/180.0 ; double R=0.2 ;
          double x = Math.cos(th) ; double y = Math.sin(th) ;
          canvas.append( new fPsWrite("[2 2] 1.0 setdash\n")) ;
          fLine(x,y, x,0) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;



          fEnv("lineWidth", 1.0) ;
          fCurve("[cos(t), sin(t)]", 1, 0, Math.PI, OPEN) ;

          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          double r = 0.07 ;
          fDisk(0, 0, r, r*aspect, FILLED) ;
          fTeXlabel(0, -0.05, "tc", "$\\big(1\\,,\\,0\\big)$") ;


          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          fEnv("lineWidth", 0.5) ;
          fEllipticalArc(0, 0, R, R, 90+25, 180, OPEN) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fLine(0, 0, x, y) ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fDisk(x, y, r, r*aspect, FILLED) ;
          fTeXlabel(x-0.3, y+0.1, "bl", "$\\big(1-\\cos\\theta\\,,\\,\\sin\\theta\\big)$") ;
          fTeXlabel(-R-0.05, 0.1, "cb", "$\\theta$") ;

          canvas.append( new fPsWrite(Black+"\n")) ;


     }
}
