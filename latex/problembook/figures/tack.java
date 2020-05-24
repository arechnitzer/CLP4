                  /*  File:  tack.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class tack extends Template {

     static {templateClass = new tack() ; }

     public void setup() {
          filePrefix = "tack" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 14.2*0.3 ;      // in inches
          ysize = 2.3*0.3 ;   // in inches. 
          xmin = -0.2 ;
          xmax = 14 ;
          ymin = -0.2 ;
          ymax = 2.1 ;
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
          fLine(xmin,0, xmax, 0) ;
          fLine(0, ymin,0, ymax) ;
          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;
          fTeXlabel(2*Math.PI, -0.1, "tc", "$2\\pi$") ;
          fTeXlabel(4*Math.PI, -0.1, "tc", "$4\\pi$") ;
          fTeXlabel(3*Math.PI, 2.1, "bc", 
                   "$\\vr(t) = \\big(t-\\sin t\\,,\\,1-\\cos t\\big)$") ;

          fEnv("lineWidth", 1.0) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fCurve("[t-sin(t) , 1-cos(t)]", 1, 0, 4*Math.PI,  OPEN) ;

          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;

//          double t = -0.85 ; double slope = 2/(5*t*t*t) ;
//          double thDeg = Math.atan(slope)*180/Math.PI ;
//          fArrowhead(t*t*t*t*t, t*t, thDeg) ;
//
//          t = 0.85 ; slope = 2/(5*t*t*t) ;
//          thDeg = Math.atan(slope)*180/Math.PI ;
//          fArrowhead(t*t*t*t*t, t*t, thDeg) ;
//
//
//          fTeXlabel(0, -0.1, "tc", "$t=0$") ;

     }
}
