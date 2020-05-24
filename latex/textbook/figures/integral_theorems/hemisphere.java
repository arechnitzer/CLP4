                  /*  File:  hemisphere.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class hemisphere extends Template {

     static {templateClass = new hemisphere() ; }

     public void setup() {
          filePrefix = "hemisphere" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.4*0.6 ;      // in inches
          ysize = 2.1*0.6 ;   // in inches. 
          xmin = -1.2 ;
          xmax = 1.2 ;
          ymin = -0.7 ;
          ymax = 1.4 ;
          topmargin = 0.0 ;   // in inches
          bottommargin = 0.0 ;   // in inches
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

          double R = 1 ;
          double RR = 1.5 ;
          double th = 60*Math.PI/180 ;
          double r = 0.3 ;
          double rr = 0.7 ;
          fEnv("lineWidth", 1.5) ;
          fEllipticalArc(0,0, R,R, 0, 180, OPEN) ;
          fEllipticalArc(0,0, R,r, 180, 360, OPEN) ;

          canvas.append( new fPsWrite("[3 3] 1.5 setdash\n")) ;
          fEllipticalArc(0, 0, R,r, 0, 180, OPEN) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;

          fTeXlabel(0, 0.6*r+0.4*R, "cc", "$V$") ;
          fTeXlabel(R+0.05,0.3, "lc", "$S$") ;
          
          fEnv("lineWidth", 0.5) ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          fArrow(R*Math.cos(th), R*Math.sin(th), RR*Math.cos(th), RR*Math.sin(th)) ;
          fTeXlabel(RR*Math.cos(th)+0.08, RR*Math.sin(th), "lc", "$\\hn$") ;
          fArrow(0, -r, 0, -rr) ;
          fTeXlabel(0.08, -rr+0.05, "lb", "$\\hn$") ;
     }
}
