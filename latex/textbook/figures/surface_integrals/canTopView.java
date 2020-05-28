                  /*  File:  canTopView.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class canTopView extends Template {

     static {templateClass = new canTopView() ; }

     public void setup() {
          filePrefix = "canTopView" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.5 ;      // in inches
          ysize = 2.5 ;   // in inches. 
          xmin = -5 ;
          xmax = 5 ;
          ymin = -5 ;
          ymax = 5 ;
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
          fEnv("lineWidth", 0.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
//          fLine(xmin, 0, xmax, 0) ;
//          fLine(0, ymin, 0, ymax) ;
//          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
//          fTeXlabel(-0.1, ymax, "tr", "$y$") ;
          canvas.append( new fPsWrite(Black+"\n")) ;

          double r = 0.4 ; double l = 1.0 ;
          fLine(0,0, l,0) ;
          fEllipticalArc(0,0, r,r, 0, 45, OPEN) ;
          fTeXlabel(r+0.15, 0.07, "bl", "$\\theta$" ) ;
          fTeXlabel(0, -2.15, "tc", "top view" ) ;
          
          

          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fEnv("lineWidth", 2.0) ;
          fDisk(0,0, 2, 2, CLOSED) ;
          fEnv("headHalfWidth", 2.0) ;
          fEnv("headLength", 6.0) ;
          fEnv("lineWidth", 0.5) ;
          double x = 2.0/Math.sqrt(2) ; double y = 2.0/Math.sqrt(2) ;
          fArrow(0, 0, x, y) ;
          fTeXlabel(x/2,y/2, "br", "$\\textcolor{red}{\\vr}$") ;


          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ;

          double dx, dy, len ;
          len = 1.2/Math.sqrt(x*x+y*y) ;
          dx = len*x ;  dy = len*y ;
          fArrow(x, y, x+dx, y+dy) ;
          fTeXlabel(x+1.1*dx,y+1.1*dy, "bl", "$\\textcolor{blue}{\\hn}$") ;


          
     }
}
