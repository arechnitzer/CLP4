                  /*  File:  OE17A_6b.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class OE17A_6b extends Template {

     static {templateClass = new OE17A_6b() ; }

     public void setup() {
          filePrefix = "OE17A_6b" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.5 ;   
          ysize = 2.5 ;   
          xmin = -1.1  ;
          xmax = 1.4 ;
          ymin = -1.1 ;
          ymax = 1.4 ;
          topmargin = 0.0 ;
          bottommargin = 0 ;
          leftmargin = 0.0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          fEnv("headHalfWidth", 2.0*1.5) ;
          fEnv("headLength", 6.0*1.5) ;
          fEnv("lineWidth", 0.5) ;
          double r = 0.04 ;  double R =  5*r ;
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          
          double x1 = -1 ; double y1 = -1 ;  double x12 = 0.0 ; double y12 = -0.5 ;
          double x2 = 1 ; double y2 = 0 ;  double x23 = 0.5 ; double y23 = 0.5 ;
          double x3 = 0 ; double y3 = 1 ;  double x31 = -0.5    ; double y31 = 0.0 ;

          fEnv("psFillGray", 0.9) ;
         {  double[] xlist = {x1, x2, x3} ;
             double[] ylist = {y1, y2, y3} ;
             fPolygon(xlist, ylist,  3, FILLED) ; }
          fEnv("psFillGray", 1.0) ;
          fDisk(0,0, R, R, FILLED) ;

          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;

          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 1.5) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ;
          fLine( x1,y1, x2,y2) ;      fArrow(x1,y1, x12, y12) ; 
          fLine( x2,y2, x3,y3) ;      fArrowhead(x23, y23, 135) ;
          fLine( x3, y3, x1,y1) ;      fArrow(x3,y3, x31, y31) ;

          fEnv("psFillColor", Blue) ;
          fDisk(x1,y1, r,r*aspect, FILLED) ;
          fDisk(x2,y2, r,r*aspect, FILLED) ;
          fDisk(x3,y3, r,r*aspect, FILLED) ;
          fTeXlabel(x1,  y1-0.02, "tc", "$(1,1)$") ;
          fTeXlabel(x2+0.02,  y2+0.02, "bl", "$(0,1)$") ;
          fTeXlabel(x3-0.02,  y3+0.02, "br", "$(0,1)$") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fDisk(0,0, r,r*aspect, FILLED) ;
          fDisk(0,0, R, R, CLOSED) ;
          double R2 = R/Math.sqrt(2) ;
          fArrowhead(R2,R2,  -45) ;
          fTeXlabel(R2-0.1, R2+0.04, "bl", "$-C_r$") ;


          fTeXlabel(xmax, -0.05, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$y$") ;
          fTeXlabel(0.2, 0.5, "cc", "$\\cR$") ;
          fTeXlabel(0.6, 0.5, "cl", "$C$") ;





     }
}
