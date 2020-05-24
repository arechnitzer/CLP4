                  /*  File:  equalArea.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class equalArea extends Template {

     static {templateClass = new equalArea() ; }

     public void setup() {
          filePrefix = "equalArea" ;    // used as the prefix for any ps, lbl files 
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5;      // in inches
          ysize = 1.5 ;   // in inches
          xmin = -1 ;
          xmax = 10 ;
          ymin = -1 ;
          ymax = 10 ;
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
          fEnv("lineWidth", 0.5) ;
          double th1 = 30 ; double th1Rad = th1*Math.PI/180 ;
          double th2 = 60 ; double th2Rad = th2*Math.PI/180 ;
          double r = 8 ;
          double x1 = r*Math.cos(th1Rad) ;  double y1 = r*Math.sin(th1Rad) ; 
          double x2 = r*Math.cos(th2Rad) ;  double y2 = r*Math.sin(th2Rad) ; 
          double rth = 2 ;
          double xth = (rth+1)*Math.cos((th1Rad+th2Rad)/2) ; 
                 double yth = (rth+1)*Math.sin((th1Rad+th2Rad)/2) ; 

          fEnv("psFillGray", 0.8) ;
          fEllipticalArc(0,0, r, r, th1, th2, WEDGE+FILLED) ;
          fEllipticalArc(0,0, rth, rth, th1, th2, OPEN) ;
          fTeXlabel(xth,yth, "cc", "$\\dee{\\theta}$") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;

          fEnv("lineWidth", 1.5) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEllipticalArc(0,0, r, r, th1-10, th2+10, OPEN) ;

          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("headHalfWidth", 2.0*1.4) ;
          fEnv("headLength", 6.0*1.4) ;
          fArrow(0,0, x1,y1) ;
          fArrow(0,0, x2,y2) ;
          fTeXlabel(x1/2, y1/2, "tl", "$\\vr(t)$") ;
          fTeXlabel(x2/2, y2/2, "br", "$\\vr(t+\\dee{t})$") ;
          


          
     }
}
