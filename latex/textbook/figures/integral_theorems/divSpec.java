                  /*  File:  divSpec.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class divSpec extends Template {

     static {templateClass = new divSpec() ; }

     public void setup() {
          filePrefix = "divSpec" ; // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;      // in inches
          ysize = 2.0 ;   // in inches. 
          xmin = -3 ;
          xmax = 3 ;
          ymin = -3 ;
          ymax = 3 ;
          topmargin = 0.1 ;   // in inches
          bottommargin = 0.2 ;   // in inches
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

          double R = 2 ;
          double h = 1.4 ;
          double thRad = Math.atan(Math.sqrt(R*R-h*h)/h) ; double th = thRad*180/Math.PI ;
          double r = 0.1 ;
          double x1 = Math.sqrt(R*R-h*h) - 0.9 ;
          double y1 = h - Math.sqrt(R*R-x1*x1) ;
          double x2 = Math.sqrt(R*R-h*h) ;
          double x3 = Math.sqrt(R*R-h*h) + 0.9 ;
          double ym = 1.5 ;
          fEnv("lineWidth", 1.5) ;
          fEnv("psFillGray", 0.9) ;
          fEllipticalArc(0,h, R,R, -90-th, -90+th, FILLED) ;
          fEllipticalArc(0,-h, R,R, 90-th, 90+th, FILLED) ;
          fEllipticalArc(0,h, R,R, -90-th, -90+th, OPEN) ;
          fEllipticalArc(0,-h, R,R, 90-th, 90+th, OPEN) ;


          fEnv("lineWidth", 0.5) ;
          fLine(x1,-ym,  x1, ym) ;
          fLine(x2,-ym,  x2, ym) ;
          fLine(x3,-ym,  x3, ym) ;


          fEnv("psFillColor", Red) ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fDisk(Math.sqrt(R*R-h*h),0, r, r, FILLED) ;
          fEnv("lineWidth", 1.5) ;
          fLine(x1,-y1, x1,y1) ;


          fTeXlabel(-x1/2,0, "cc", "$V$") ;

          }
}
