                  /*  File:  workIntegralA.java    */


import figPac.* ;
import fnPac.* ;
//import java.applet.* ;
//import java.awt.* ;


public class workIntegralA extends Template {

     static {templateClass = new workIntegralA() ; }

     public void setup() {
          filePrefix = "workIntegralA" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.5 ;   // in inches. 
          xmin = -0.1 ;
          xmax =1.2 ;
          ymin = -0.1 ;
          ymax = 1.2 ;
          topmargin = 0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
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
          fLine(xmin,0, xmax, 0) ;
          fLine(0, ymin,0, ymax) ;
          fTeXlabel(xmax, -0.04, "tr", "$x$") ;
          fTeXlabel(-0.02, ymax, "tr", "$y$") ;

          fEnv("lineWidth", 1.0) ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ; 
          fLine(0,0, 1,1) ;
          double r = 0.02 ; 
          fDisk(0, 0, r, r, FILLED+CLOSED) ;
          fTeXlabel(0.015,-0.04, "tl", "$P_0$") ;
          fDisk(1, 1, r, r, FILLED+CLOSED) ;
          fTeXlabel(1.04,1.0, "cl", "$P_1$") ;
          fTeXlabel(0.5,0.5-0.04, "tl", "$\\cC_1$") ;
          double th = 350 ; double thRad = th*Math.PI/180 ;
          double x = 0.5 ; double y = 0.5 ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          fArrowhead(x,y, 45) ;

          fLine(0,0, 1,0) ;
          fLine(1,0, 1,1) ;
          fArrowhead(0.5,0, 0) ;
          fArrowhead(1.0,0.5, 90) ;
          fTeXlabel(0.5,0.0-0.04, "tl", "$\\cC_2$") ;
          fTeXlabel(1.05,0.5, "lc", "$\\cC_2$") ;
          
          fCurve("[t*t,t]",1, 0, 1, OPEN) ;
          x=0.5 ; y = Math.sqrt(0.5) ; th = Math.atan(1/(2*y))*180/Math.PI ;
          fTeXlabel(x,y+0.06, "bc", "$\\cC_3$") ;
          fArrowhead(x,y, th) ;

          
     }
}


