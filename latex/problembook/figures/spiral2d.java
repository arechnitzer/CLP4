                  /*  File:  spiral2d.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class spiral2d extends Template {

     static {templateClass = new spiral2d() ; }

     public void setup() {
          filePrefix = "spiral2d" ;    // used as the prefix for any ps, lbl files 
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5;      // in inches
          ysize = 1.5 ;   // in inches
          xmin = -25 ;
          xmax = 25 ;
          ymin = -25 ;
          ymax = 25;
          topmargin = -0.0 ;   // in inches
          bottommargin = -0.0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 0.5) ;
//          fLine(xmin,0, xmax,0) ;
//          fTeXlabel(xmax, -0.3, "tr", "$x$") ;
//          fLine(0,ymin, 0, ymax) ;
//          fTeXlabel(-0.2, ymax, "tr", "$y$") ;

          fEnv("lineWidth", 1.0) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fCurve("[t*cos(t) , t*sin(t)]",
                                1, 0, 8*Math.PI, OPEN) ;
          double t = 4.5*Math.PI ;
          double x = t*Math.cos(t) ;
          double y = t*Math.sin(t) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fArrowhead(x,y,180) ;

//          fEnv("useColorPs", "false") ;
//          canvas.append( new fPsWrite(Black+"\n")) ;
//          fEnv("psFillGray", 1.0) ;
          fEnv("psFillColor", Blue) ;

//          fEnv("lineWidth", 0.5) ;
//          fDisk(0, 0, 0.6, 0.6, CLOSED+FILLED) ;


          
     }
}
