                  /*  File:  applecore.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class applecore extends Template {

     static {templateClass = new applecore() ; }

     public void setup() {
          filePrefix = "applecore" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 0.8*2.0 ;      // in inches
          ysize = 1.0*2.0 ;   // in inches. 
          xmin = -4 ;
          xmax = 4 ;
          ymin = -5 ;
          ymax = 5 ;
          topmargin = 0 ;   // in inches
          bottommargin = -0.3 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double phi = 30 ;
          fEnv("lineWidth", 0.4) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fLine(0, 0, Math.sqrt(12),2) ;
          fLine(0, 0, -Math.sqrt(12),2) ;
          fTeXlabel(0,ymax+0.3,"bc", "$z$") ;
          fTeXlabel(xmax+0.3,0,"lc", "$r$") ;


          String Pink = "1 0.3333 0.6666 setrgbcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("lineWidth", 1.5) ;
          fEllipticalArc(0, 0, 4, 4, phi, 180-phi, OPEN) ;
          fEllipticalArc(0, 0, 4, 4, 180+phi, 360-phi, OPEN) ;
          fCurve("[sqrt(t*t+8),t]", 1, -2, 2, OPEN) ;
          fCurve("[-sqrt(t*t+8),t]", 1, -2, 2, OPEN) ;
          fTeXlabel(0.7,1.2,"cc", "$\\phi_1$") ;
          double r = 0.2 ;
          fDisk(Math.sqrt(12),2, r,r, FILLED) ;
          fTeXlabel(Math.sqrt(12)+0.4,2.1,"lc", "$r=\\sqrt{12},\\ z=2$") ;
          fTeXlabel(-2,3.7,"br", "$S_1$") ;
          fTeXlabel(-3.1,0.8,"rc", "$S_2$") ;
          


     }
}
