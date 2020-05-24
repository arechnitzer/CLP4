                  /*  File:  astroid6.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class astroid6 extends Template {

     static {templateClass = new astroid6() ; }

     public void setup() {
          filePrefix = "astroid6" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.5 ;   // in inches. 
          xmin = -120 ;
          xmax = 120 ;
          ymin = -120 ;
          ymax = 120 ;
          topmargin = 0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = -0.1 ;   // in inches
          rightmargin = -0.1 ;   // in inches
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
          fTeXlabel(xmax, -4, "tr", "$x$") ;
          fTeXlabel(-1, ymax, "tr", "$y$") ;

          fEnv("psFillColor", Red) ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 2.0) ;
          fCurve("[100*cos(t)*cos(t)*cos(t) , 100*sin(t)*sin(t)*sin(t)]", 1, 0, 2*Math.PI,                   OPEN) ;

          fEnv("headLength", 6.0*1.5) ;
          fEnv("headHalfWidth", 2.0*1.5) ;

          double t = Math.PI/4 ;
          double x = 100*Math.cos(t)*Math.cos(t)*Math.cos(t) ;
          double y = 100*Math.sin(t)*Math.sin(t)*Math.sin(t) ;
          fArrowhead(x,y,135) ;

          t = 3*Math.PI/4 ;
          x = 100*Math.cos(t)*Math.cos(t)*Math.cos(t) ;
          y = 100*Math.sin(t)*Math.sin(t)*Math.sin(t) ;
          fArrowhead(x,y,225) ;

          t = 5*Math.PI/4 ;
          x = 100*Math.cos(t)*Math.cos(t)*Math.cos(t) ;
          y = 100*Math.sin(t)*Math.sin(t)*Math.sin(t) ;
          fArrowhead(x,y,-45) ;

          t = 7*Math.PI/4 ;
          x = 100*Math.cos(t)*Math.cos(t)*Math.cos(t) ;
          y = 100*Math.sin(t)*Math.sin(t)*Math.sin(t) ;
          fArrowhead(x,y, 45) ;


     }
}
