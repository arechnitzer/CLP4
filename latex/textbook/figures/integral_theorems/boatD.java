                  /*  File:  boatD.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class boatD extends Template {

     static {templateClass = new boatD() ; }

     public void setup() {
          filePrefix = "boatD" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.5 ;      // in inches
          ysize = 2.5 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -60 ;
          xmax = 60 ;
          ymin = -60 ;
          ymax = 60 ;
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
          fEnv("lineWidth", 1.0) ;
          fEnv("psFillGray", 0.6) ;
          double x1 = 20 ;
          double x2 = 5 ;
          double y1 = 50 ;
          double y2 = 25 ;
          double yg = 38 ;
          double yb = 28 ;
          double l = 23 ;
          double th = 160*Math.PI/180.0 ;
          fRotate(th) ;
          { double[] xlist = {-x2, 0, x2} ;
            double[] ylist = {y2, 0, y2} ;
            fBezier bez = new fBezier(xlist, ylist, 3, FILLED) ;
            bez.configure("vertex0outAngle",-45) ;
            bez.configure("vertex1outAngle",90) ;
            bez.configure("vertex1inAngle", -90) ;
            bez.configure("vertex2inAngle",45) ;
            canvas.append(bez) ;
          }
          { double[] xlist = {-x1, -x2, 0, x2, x1} ;
            double[] ylist = {y1, y2, 0, y2, y1} ;
            fBezier bez = new fBezier(xlist, ylist, 5, OPEN) ;
            bez.configure("vertex0outAngle",-90) ;
            bez.configure("vertex1inAngle",-45) ;
            bez.configure("vertex1outAngle",-45) ;
            bez.configure("vertex2outAngle",90) ;
            bez.configure("vertex2inAngle", -90) ;
            bez.configure("vertex3inAngle",45) ;
            bez.configure("vertex3outAngle",45) ;
            bez.configure("vertex4inAngle",90) ;
            canvas.append(bez) ;
          }
          fLine(-x1, y1, x1, y1) ;
          fEnv("lineWidth", 0.5) ;
          fEnv("headLength", 6.0*1.2) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fArrow(0, yg, l*Math.sin(th), yg+l*Math.cos(th) ) ;
          fArrow(0, yb, -l*Math.sin(th), yb-l*Math.cos(th) ) ;
          fTeXlabel(l*Math.sin(th)+1, yg+l*Math.cos(th),  "br", "$\\vB$") ;
          fTeXlabel(-l*Math.sin(th)-2, yb-l*Math.cos(th)+1,  "tr", "$\\vG$") ;
          fEnv("psFillGray", 0.0) ;
          fDisk(0, yg, 1.3, 1.3, FILLED) ;
          fDisk(0, yb, 1.3, 1.3, FILLED) ;
     }
}
