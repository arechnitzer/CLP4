                  /*  File:  coneB.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class coneB extends Template {

     static {templateClass = new coneB() ; }

     public void setup() {
          filePrefix = "coneB" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3*0.6 ;      
          ysize = 3*126/120*0.6 ;  
          xmin = -60 ;
          xmax = 60 ;
          ymin = -1 ;
          ymax = 125 ;
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
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          double r = 30 ;
          double H = 80 ;
          double h = 40 ;
          double X = r*H/H ;
          double x = r*h/H ;
          fEnv("lineWidth", 0.5) ;
          fEnv("psFillGray", 0.8) ;
          fDisk(0,H,X,X/3.0, FILLED) ;
          fDisk(0,h,x,x/3.0, FILLED) ;

          fEnv("lineWidth", 2.0) ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fLine(-X,H, -x,h) ;
          fLine(X, H, x,h) ;
          fEllipticalArc(0,H, X,X/3.0, 0, 360, OPEN) ;
          fEllipticalArc(0,h, x,x/3.0, 180, 360, OPEN) ;
          canvas.append( new fPsWrite("[3 3] 1.5 setdash\n")) ;
          fEllipticalArc(0,h, x,x/3.0, 0, 180, OPEN) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
          fTeXlabel(-(x+X)/2-3, (h+H)/2-5, "cr", "$S$") ;
          fTeXlabel(0, (h+H)/2-3, "cc", "$V$") ;

          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("lineWidth", 0.5) ;
          double y = 0.6*h+0.4*H ;
          x = r*y/H ;
          double l = 18 ;
          double dx = l*H/Math.sqrt(r*r+H*H) ;
          double dy = -l*r/Math.sqrt(r*r+H*H) ;       
          fArrow(x,y, x+dx, y+dy) ;
          fTeXlabel(x+dx+2, y+dy, "cl", "$\\hn$") ; 
          fArrow(0.4*x,H, 0.4*x, H+l) ;
          fTeXlabel(0.4*x+2, H+l+2, "cl", "$\\hn=\\hk$") ; 
          fArrow(0.35*x,h-5, 0.35*x, h-l) ;
          fTeXlabel(0.35*x+2, h-l, "cl", "$\\hn=-\\hk$") ; 
          fTeXlabel(-0.5*x, H+X/3+2, "cb", "$D_2$") ;
          fTeXlabel(-0.5*x+6, h-8, "ct", "$D_1$") ;

     }
}
