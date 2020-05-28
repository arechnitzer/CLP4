                  /*  File:  dcircleA.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class dcircleA extends Template {

     static {templateClass = new dcircleA() ; }

     public void setup() {
          filePrefix = "dcircleA" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.5 ;   // in inches. 
          xmin = -1.2 ;
          xmax = 1.2;
          ymin = -1.2 ;
          ymax = 1.2;
          topmargin = 0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0.0 ;   // in inches
          rightmargin = 0.0 ;   // in inches
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
          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;
          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$y$") ;

          fEnv("psFillColor", Red) ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 2.0) ;
          fCurve("[sin( cos(t) ) , sin( sin(t) )]", 1, 0, 2*Math.PI,  OPEN) ;

          fEnv("headLength", 6.0*1.5) ;
          fEnv("headHalfWidth", 2.0*1.5) ;

          double t = Math.PI/4 ;
          double x = Math.sin( Math.cos(t) ) ;
          double y = Math.sin( Math.sin(t) ) ;
          double dx = -Math.cos( Math.cos(t) )*Math.sin(t);
          double dy =  Math.cos( Math.sin(t) )*Math.cos(t) ;
          double th = Math.atan(dy/dx)*180/Math.PI + 180 ;
          fArrowhead(x,y,th) ;
          fTeXlabel(1.05*x, 1.05*y, "bl", "$C$") ;



     }
}
