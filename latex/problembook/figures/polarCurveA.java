                  /*  File:  polarCurveA.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class polarCurveA extends Template {

     static {templateClass = new polarCurveA() ; }

     public void setup() {
          filePrefix = "polarCurveA" ; // used as the prefix for any ps, lbl files 
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5;      // in inches
          ysize = 1.5 ;   // in inches
          xmin = -3.5 ;
          xmax = 3.5 ;
          ymin = -3.5 ;
          ymax = 3.5 ;
          topmargin = -0.1 ;   // in inches
          bottommargin = -0.2 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 0.5) ;
          fLine(xmin,0, xmax,0) ;
          fTeXlabel(xmax, -0.2, "tr", "$x$") ;
          fLine(0,ymin, 0, ymax) ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;

          fEnv("lineWidth", 1.0) ;
          String Pink = "1 0.3333 0.6666 setrgbcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fCurve("[( 2+sin(4*t) )*cos(t) , ( 2+sin(4*t) )*sin(t)]",
                                1, 0,2*Math.PI, OPEN) ;
//          fCurve("[( exp(t/4)+exp(-t/4) )*cos(t)/8 , ( exp(t/4)+exp(-t/4) )*sin(t)/8]",
//                                1, 0,20, OPEN) ;
     }
}
