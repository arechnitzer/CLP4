                  /*  File:  mobiusF.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class mobiusF extends Template {

     static {templateClass = new mobiusF() ; }

     public void setup() {
          filePrefix="mobiusF";
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0*120/50*0.5 ;   // in inches
          ysize = 2.0*0.5 ;   // in inches
          xmin = -10 ;
          xmax = 110 ;
          ymin = -25 ;
          ymax = 25 ;
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
          double X = 80 ;
          double r = 1.6 ;
          double rr = 5 ;
          double phiDeg = 60 ; double phi = phiDeg*Math.PI/180 ;
          double u = 17  ;
          double v = 25  ;
          double xv = v*Math.cos(phi) ; double yv = v*Math.sin(phi) ;
          double V = 30  ;
          double xV = V*Math.cos(phi) ; double yV = V*Math.sin(phi) ;

          String Black = "0 0 0 1 setcmykcolor  " ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Yellow = "0 0 1 0 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          fEnv("useColorPs", "true") ;
          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite("0.7 setgray\n")) ;
          fLine(0, 0, xmax, 0) ; 
          fLine(0, ymin, 0, ymax) ;
          canvas.append( new fPsWrite("0.0 setgray\n")) ;
          fEnv("lineWidth", 1.0) ;


          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("lineWidth", 1.5) ;
          fLine(X-xV, -yV, X+xV, yV) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          fArrow(X,0, X+xv, yv) ;
          fTeXlabel(X+xv+0.5, yv-2.5, "cl", "$\\vu(v,\\theta,\\varphi)$") ;


          fEnv("lineWidth", 1.5) ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("arrowHeadColor", Red) ;
          fEnv("psFillColor", Red) ;
          fLine(0, 0, X, 0) ;
          fArrow(0,0, 0.99*X, 0) ;
          fTeXlabel(X/2, -2, "tc", "$\\frac{\\ell}{2\\pi}\\hr(\\theta)$") ;

          fEnv("psFillColor", Black) ;
          fDisk(X,0,r,r,FILLED) ;

          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("psFillColor", Black) ;

          fEnv("lineWidth", 0.5) ;
          fEnv("headHalfWidth", 2.0) ;
          fEnv("headLength", 6.0) ;
          fArrow(X,0, X+u, 0) ;
          fTeXlabel(X+u, -2, "tc", "$\\hr(\\theta)$") ;
          fArrow(X,0, X, u) ;
          fTeXlabel(X-2, u, "cr", "$\\hk$") ;
          fEllipticalArc(X,0, rr, rr, 0, phiDeg, OPEN) ;
          fTeXlabel(X+1.1*rr, 0.3*rr, "bl", "$\\varphi$") ;








     }
}