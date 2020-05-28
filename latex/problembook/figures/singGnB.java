                  /*  File:  singGnB.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class singGnB extends Template {

     static {templateClass = new singGnB() ; }

     public void setup() {
          filePrefix = "singGnB" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.4 ;      // in inches
          ysize = 1.6 ;   // in inches. 
          xmin = -1.2 ;
          xmax = 1.2 ;
          ymin = -0.2 ;
          ymax = 1.4 ;
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
          fEnv("lineWidth", 0.5) ;
          fLine(xmin,0, xmax,0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.05, "tr", "$x$") ;
          fTeXlabel(-0.03,ymax, "tr", "$y$") ;

          fEnv("lineWidth", 1.0) ;
          fEnv("useColorPs", "true") ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;

          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          fEllipticalArc(0, 0, 1, 1, 0, 180, OPEN) ;
          fEllipticalArc(0, 0, 0.5, 0.5, 0, 180, OPEN) ;
          fLine(-1,0, -0.5, 0) ;
          fLine(1,0, 0.5, 0) ;
          double th = 45*Math.PI/180.0 ;
          double x = Math.cos(th) ;
          double y = Math.sin(th) ;
          fArrowhead(x,y, 135) ;
          x = 0.5*Math.cos(th) ;
          y = 0.5*Math.sin(th) ;
          fArrowhead(x,y, -45) ;
          fArrow(0.75, 0, 0.85, 0) ;
          fArrow(-0.75, 0, -0.65, 0) ;
          fTeXlabel(0.72, 0.72, "bl", "$x^2+y^2=2$") ;
          fTeXlabel(0.05, 0.5, "bl", "$\\scriptstyle x^2+y^2=1$") ;
          fTeXlabel(-0.75, -0.05, "tc", "$\\Atop{y=0}{\\dee{y} =0}$") ;
          fTeXlabel(0.75, -0.05, "tc", "$\\Atop{y=0}{\\dee{y} =0}$") ;

     }
}
