                  /*  File:  rigid.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class rigid extends Template {

     static {templateClass = new rigid() ; }

     public void setup() {
          filePrefix = "rigid" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.5 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -30 ;
          xmax = 70 ;
          ymin = 0 ;
          ymax = 100 ;
          topmargin = 0 ;   // in inches
          bottommargin = 0.15 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 0.5) ;
          fRotate(-20*Math.PI/180.0) ;
          fLine( 0, 0, 0, 95) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          fArrow( 0, 0, 0, 75) ;
          fArrow( 0, 0 ,  40, 50) ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("lineWidth", 1.0) ;
          fCurve(new pEllipse( 0, 50, 40, 12), 0, 2*Math.PI, CLOSED) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("lineWidth", 0.5) ;
          fArrow( 40, 50,  30, 70) ;
          double r = 2 ;
          fDisk(40, 50, r, r, FILLED) ;

          fEnv("headHalfWidth", 2.0*0.8) ;
          fEnv("headLength", 6.0*0.8) ;
          fCurve(new pEllipse(0,85,10,5),130*Math.PI/180.0,410*Math.PI/180.0,OPEN);
          fArrowhead( 6, 89, 150) ;

          fTeXlabel( 43, 50, "lc", "$\\vr$") ;
          fTeXlabel( 33, 72, "lc", "$\\vv$") ;
          fTeXlabel( -5, 0,  "tr", "$\\vZero$") ;
          fTeXlabel( -5, 75, "rc", "$\\Ha$") ;
          fTeXlabel( 12, 90, "lc", "$\\Om$") ;

          fCurve(new pEllipse(0,0,15,15),51*Math.PI/180.0,90*Math.PI/180.0,OPEN);
          fTeXlabel( 7, 22, "cc", "$\\theta$") ;
     }
}
