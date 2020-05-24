                  /*  File:  bowl.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class bowl extends Template {

     static {templateClass = new bowl() ; }

     public void setup() {
          filePrefix = "bowl" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3*0.8 ;      
          ysize = 3*1.4/2.2*0.8 ;  
          xmin = -1.1 ;
          xmax = 1.1 ;
          ymin = -0.1 ;
          ymax = 1.4 ;
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
          double H = 1 ;
          double h = 0.53 ;
          double hh = 0.61 ;
          double X = Math.sqrt( Math.sqrt(H) ) ;
          double x = Math.sqrt( Math.sqrt(h) ) ;
          double xx = Math.sqrt( Math.sqrt(hh) ) ;
          double A = 6.0 ;
          fEnv("lineWidth", 0.5) ;
          fEnv("psFillGray", 0.8) ;
          fDisk(0,H,X,X/A, FILLED) ;
          fTeXlabel(X+0.05,H, "cl", "$z=1$") ;
          fEllipticalArc(0,h,x,x/A, 170, 370, FILLED) ;
          fEnv("psFillGray", 1.0) ;
          fEllipticalArc(0,hh,xx,xx/A, 180, 360, FILLED) ;

          fEnv("lineWidth", 2.0) ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEllipticalArc(0,H, X,X/A, 0, 360, OPEN) ;
          canvas.append( new fPsWrite("[3 3] 1.5 setdash\n")) ;
          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fEllipticalArc(0,hh, xx,xx/A, 0, 180, OPEN) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
          fEllipticalArc(0,hh, xx,xx/A, 180, 360, OPEN) ;
          fEllipticalArc(0,h, x,x/A, 180, 360, OPEN) ;

          fEnv("lineWidth", 2.0) ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fCurve("x*x*x*x", 0, -X, X, OPEN ) ;

          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          double x1 = 0.7 ;
          double y1 = x1*x1*x1*x1 ;
          fTeXlabel(x1+0.05, y1, "cl", "$S$") ;
          fTeXlabel(-0.6, H+X/A, "br", "$D$") ;



          double l = 0.35 ;
          x1 = 0.6 ;
          y1 = x1*x1*x1*x1 ;
          fArrow(0.5,H, 0.5, H+l) ;
          fTeXlabel(0.55, H+l, "cl", "$\\hk$") ; 

          l = 0.25 ;      
          double u = 1 ;
          double v = 4*x1*x1*x1 ;
          double dx = -l*v/Math.sqrt(u*u+v*v) ;
          double dy = l*u/Math.sqrt(u*u+v*v) ; 
          fArrow(x1,y1, x1+dx, y1+dy) ;
          fTeXlabel(x1+dx-0.02, y1+dy, "tr", "$\\hn$") ; 



     }
}
