                  /*  File:  dcircleC.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class dcircleC extends Template {

     static {templateClass = new dcircleC() ; }

     public void setup() {
          filePrefix = "dcircleC" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;      // in inches
          ysize = 2.0 ;   // in inches. 
          xmin = -1.2 ;
          xmax = 1.2;
          ymin = -1.2 ;
          ymax = 1.2;
          topmargin = 0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0.0 ;   // in inches
          rightmargin = 0.0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          double a = 0.3 ;
          double thO = 3 ; double thOrad = thO*Math.PI/180 ;
          double thI = 10 ; double thIrad = thI*Math.PI/180 ;
          double xlt = Math.sin(Math.cos(Math.PI-thOrad)) ;
          double ylt = Math.sin(Math.sin(Math.PI-thOrad)) ;
          double xlb = Math.sin(Math.cos(-Math.PI+thOrad)) ;
          double ylb = Math.sin(Math.sin(-Math.PI+thOrad)) ;
          double xrt = a*Math.cos(Math.PI-thIrad) ;
          double yrt = a*Math.sin(Math.PI-thIrad) ;
          double xrb = a*Math.cos(-Math.PI+thIrad) ;
          double yrb = a*Math.sin(-Math.PI+thIrad) ;
          double xmt = 0.4*xlt+0.6*xrt ;
          double ymt = 0.4*ylt+0.6*yrt ;
          double xmb = 0.6*xlb+0.4*xrb ;
          double ymb = 0.6*ylb+0.4*yrb ;



          fEnv("psFillGray", 0.8) ;
          fCurve("[sin( cos(t) ) , sin( sin(t) )]", 1, 0, 2*Math.PI,  FILLED) ;
          fEnv("psFillGray", 1.0) ;
          fDisk(0,0, a, a, FILLED) ;
          { double[] xlist = {xlt, xrt, xrb, xlb} ;
            double[] ylist = {ylt, yrt, yrb, ylb} ;
            fPolygon(xlist, ylist, 4, FILLED) ; }
          fEnv("psFillColor", Red) ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 1.7) ;
          fCurve("[sin(cos(t)),sin(sin(t))]", 1, -Math.PI+thOrad, Math.PI-thOrad,  OPEN) ;
          fEllipticalArc(0,0, a, a, -180+thI, 180-thI, OPEN) ;

          fEnv("headLength", 6.0*1.8) ;
          fEnv("headHalfWidth", 2.0*1.8) ;

          double t = Math.PI/4 ;
          double x = Math.sin( Math.cos(t) ) ;
          double y = Math.sin( Math.sin(t) ) ;
          double dx = -Math.cos( Math.cos(t) )*Math.sin(t);
          double dy =  Math.cos( Math.sin(t) )*Math.cos(t) ;
          double th = Math.atan(dy/dx)*180/Math.PI + 180 ;
          fArrowhead(x,y,th) ;
          fTeXlabel(1.05*x, 1.05*y, "bl", "$C_\\veps$") ;
          x = a*Math.cos(t) ;
          y = a*Math.sin(t) ;
          fArrowhead(x,y,t*180/Math.PI-90) ;

          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;
          fTeXlabel(xmax, -0.07, "tr", "$x$") ;
          fTeXlabel(-0.02, ymax, "tr", "$y$") ;

          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 1.7) ;
          fLine(xlt,ylt, xrt,yrt) ;
          fArrow(xlt,ylt, xmt,ymt) ;
          fLine(xrb,yrb, xlb,ylb) ;
          fArrow(xrb,yrb, xmb,ymb) ;

          fTeXlabel(-1.8*x, 1.8*y, "bl", "$R_\\veps$") ;
          fTeXlabel(1.1*x, 1.1*y, "bl", "$C_\\veps$") ;





     }
}
