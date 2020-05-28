                  /*  File:  wireC.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class wireC extends Template {

     static {templateClass = new wireC() ; }

     public void setup() {
          filePrefix = "wireC" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.1*0.9 ;      // in inches
          ysize = 2.1*0.9*0.9/1.0 ;   // in inches. 
          xmin = -0.1 ;
          xmax = 1.1 ;
          ymin = -0.1 ;
          ymax = 0.9 ;
          topmargin = 0.1 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 1.5) ;
          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fCurve("y=x*x", 0, 0, 1, OPEN) ;
          fTeXlabel(0.95, 0.93, "bc", "wire") ;
          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          double x=0.6 ; double y=x*x ;
          double phi = Math.atan(2*x) ; double a = 0.5 ;
          double cphi=Math.cos(phi) ; double sphi=Math.sin(phi) ;
          fEnv("headHalfWidth", 2.0*1.4) ;
          fEnv("headLength", 6.0*1.4) ;
          fArrow(x,y, x-a*cphi, y-a*sphi) ;
               fTeXlabel( x-1.1*a*cphi-0.02, y-1.1*a*sphi+0.02, "tl", "$\\hat\\vT$") ;
//               fTeXlabel( x+0.12, y+0.02, "bl", "$\\phi$") ;
          double b = 1.2*a ;
          fArrow(x,y, x-b*sphi, y+b*cphi) ;
               fTeXlabel( x-1.1*b*sphi+0.03, y+1.1*b*cphi, "tr", "$W\\hat\\vN$") ;
//               fTeXlabel( x-0.025, y+0.12, "br", "$\\phi$") ;
          fArrow(x,y,    x, ymin) ;    
               fTeXlabel(x+0.04, ymin-0.02, "bl", "$-mg\\hj$ (gravity)") ;
          fArrow(x,y,     x, y+a) ;
          fTeXlabel(x,y+a+0.02, "cb", "$\\hj$") ;
          fArrow(x,y,     x+a, y) ;
          fTeXlabel(x+a+0.03,y+0.01, "cl", "$\\hi$") ;
          double r =0.03 ;
          fDisk(x,y, r,r, FILLED) ;
          fTeXlabel(x-0.05,y, "cr", "$(x,y)$") ;
          fTeXlabel(x+0.03,y-0.02, "tl", "bead") ;
          
          
     }
}
