                  /*  File:  coneC.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class coneC extends Template {

     static {templateClass = new coneC() ; }

     public void setup() {
          filePrefix = "coneC" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3*1.0 ;      
          ysize = 3*126/120*1.0 ;  
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
          double hh = 56 ;
          double hhh = 59 ;
          double X = r*H/H ;
          double x = r*h/H ;
          double xx = r*hh/H ;
          double xxx = r*hhh/H ;
          fEnv("lineWidth", 0.5) ;
          fEnv("psFillGray", 0.8) ;
          fDisk(0,H,X,X/3.0, FILLED) ;
          fTeXlabel(X+2,H, "cl", "$z=2$") ;
          fDisk(0,h,x,x/3.0, FILLED) ;
          fTeXlabel(x+2,h, "cl", "$z=1$") ;
          fEllipticalArc(0,hh,xx,xx/3.0, 160, 380, FILLED) ;
          fEnv("psFillGray", 1.0) ;
          fEllipticalArc(0,hhh,xxx,xxx/3.0, 180, 360, FILLED) ;

          fEnv("lineWidth", 2.0) ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEllipticalArc(0,H, X,X/3.0, 0, 360, OPEN) ;
          fEllipticalArc(0,h, x,x/3.0, 180, 360, OPEN) ;
          canvas.append( new fPsWrite("[3 3] 1.5 setdash\n")) ;
          fEllipticalArc(0,h, x,x/3.0, 0, 180, OPEN) ;
          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fEllipticalArc(0,hhh, xxx,xxx/3.0, 0, 180, OPEN) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;

          fEllipticalArc(0,hh, xx,xx/3.0, 180, 360, OPEN) ;
          fEllipticalArc(0,hhh, xxx,xxx/3.0, 180, 360, OPEN) ;

          fEnv("lineWidth", 2.0) ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fLine(-X,H, -x,h) ;
          fLine(X, H, x,h) ;

     }
}
