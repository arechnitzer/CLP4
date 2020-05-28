                  /*  File:  wireU.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class wireU extends Template {

     static {templateClass = new wireU() ; }

     public void setup() {
          filePrefix = "wireU" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.5*0.9/1.1 ;   // in inches. 
          xmin = -0.1 ;
          xmax = 1.0 ;
          ymin = -0.25 ;
          ymax = 0.65 ;
          topmargin = -0.1 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 1.0) ;
          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fCurve("y=x*x", 0, 0, 0.8, OPEN) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("lineWidth", 0.5) ;
          double x=0.4 ; double y=x*x ;
          double phi = Math.atan(2*x) ; double a = 0.6 ;
          double cphi=Math.cos(phi) ; double sphi=Math.sin(phi) ;
          fEnv("headHalfWidth", 2.0*1.4) ;
          fEnv("headLength", 6.0*1.4) ;
          fArrow(x,y, x-a*cphi, y-a*sphi) ;
               fTeXlabel( x-1.0*a*cphi-0.01, y-1.0*a*sphi, "br", "$\\hat\\vT$") ;
          fArrow(x,y, x-a*sphi, y+a*cphi) ;
               fTeXlabel( x-1.1*a*sphi+0.01, y+1.1*a*cphi, "tr", "$\\hat\\vN$") ;
          double r =0.02 ;
          fDisk(x,y, r,r, FILLED) ;
          
          
     }
}
