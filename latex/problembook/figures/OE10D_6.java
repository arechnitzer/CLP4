                  /*  File:  OE10D_6.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE10D_6 extends Template {

     static {templateClass = new OE10D_6() ; }

     public void setup() {
          filePrefix = "OE10D_6" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 6*0.2 ;      // in inches
          ysize = 10*0.2 ;   // in inches. 
          xmin = -2.5 ;
          xmax = 3.5 ;
          ymin = -5.0 ;
          ymax = 5.0 ;
          topmargin = 0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = -0.1 ;   // in inches
          rightmargin = -0.1 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double a = 1 ;
          double h = 1 ;
          fEnv("lineWidth", 0.5) ;
          fLine(xmin,0, xmax, 0) ;
          fLine(0, ymin,0, ymax) ;
          fTeXlabel(xmax, -0.12, "tr", "$x$") ;
          fTeXlabel(-0.07, ymax, "tr", "$z$") ;

          fEnv("lineWidth", 0.5) ;
          double th = 45*Math.PI/180.0 ;
          double x = -2*Math.cos(th) ;
          double y = -2*Math.sin(th) ;
          double xx = -3.5*Math.cos(th) ;
          double yy = -3.5*Math.sin(th) ;
          fArrow(x,x, xx,yy) ;



          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;

          fEnv("lineWidth", 1.0) ;
          fEllipticalArc(0,0 , 2,2,90, 270, OPEN)  ;
          canvas.append( new fPsWrite("[2 2] 1.0 setdash\n")) ;
          fEllipticalArc(0,0 , 2,2,-90, 90, OPEN)  ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;

          fTeXlabel(-1.5, 1.5, "br", "$\\textcolor{blue}{x^2+z^2=4}$") ;

          canvas.append( new fPsWrite(Red+"\n")) ;
          canvas.append( new fPsWrite("[2 2] 1.0 setdash\n")) ;
          fCurve("[-1 +t*t/4, t]", 1, -2, 2, OPEN) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
          fCurve("[-1 +t*t/4, t]", 1, 2, 4, OPEN) ;
          fCurve("[-1 +t*t/4, t]", 1, -2, -4, OPEN) ;
          fTeXlabel(3,-4.1, "tc", "$\\textcolor{red}{z^2=4(x+1)}$") ;
     }
}



