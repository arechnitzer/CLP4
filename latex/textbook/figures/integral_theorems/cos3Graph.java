                  /*  File:  cos3Graph.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class cos3Graph extends Template {

     static {templateClass = new cos3Graph() ; }

     public void setup() {
          filePrefix = "cos3Graph" ;    // used as the prefix for ps and lbl files 
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.5 ;    
          ysize = 1.8 ;   
          double pi = Math.PI ;
          xmin = -0.5*pi ;
          xmax =  2.5*pi ;
          ymin = -1.1 ;
          ymax = 1.4 ;
          topmargin = 0.15 ;   // in inches
          bottommargin = 0.15 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double pi = Math.PI ;
          fEnv("psFillGray", 0.6) ;
          fCurve("y= cos(x)*cos(x)*cos(x)", 0, -0.5*pi, 0.5*pi, FILLED) ;
          fCurve("y= cos(x)*cos(x)*cos(x)", 0,  0.5*pi, 1.5*pi, FILLED) ;
          fEnv("psFillGray", 0.8) ;
          fCurve("y= cos(x)*cos(x)*cos(x)", 0,  1.5*pi, 2.5*pi, FILLED) ;
          {double[] xlist = {0.5*pi, pi, pi, 0.5*pi} ;
           double[] ylist = {0,     0, -1,    -0.9} ;
           fPolygon(xlist, ylist, 4, FILLED) ;} 
          fEnv("psFillGray", 1.0) ;
          fCurve(new xcos(),0,pi,FILLED)  ;
          {double[] xlist = {2*pi, 3*pi, 3*pi, 2*pi} ;
           double[] ylist = {0,     0,      1,    1} ;
           fPolygon(xlist, ylist, 4, FILLED) ;} 
          {double[] xlist = {0, -0.5*pi, -0.5*pi, 0} ;
           double[] ylist = {0,   0,   1, 1} ;
           fPolygon(xlist, ylist, 4, FILLED) ;} 
          fEnv("lineWidth", 0.5) ;
          double xm = -0.2*pi ;
          double xM =  2.2*pi ;
          fLine(xm,0, xM,0) ;
          fLine(0,ymin, 0, ymax) ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;
          fTeXlabel(xM+0.1, 0, "cl", "$x$") ;
          for(int i=0 ; i<5 ; i++) {
               fLine(i*pi/2, 0,  i*pi/2, -0.08) ;
          }
          fTeXlabel(pi,-0.13, "tc", "$\\scriptstyle\\pi$") ;
          fTeXlabel(0.5*pi,-0.12, "tc", "$\\nicefrac{\\pi}{2}$") ;
          fTeXlabel(2*pi,-0.13, "tc", "$\\scriptstyle2\\pi$") ;
          fTeXlabel(1.5*pi,-0.12, "tc", "$\\nicefrac{3\\pi}{2}$") ;
          fLine(-0.13,1,  0,1) ;
          fLine(-0.13,-1,  0,-1) ;
          fTeXlabel(-0.2,1, "rc", "$\\scriptstyle 1$") ;
          fTeXlabel(-0.2,-1, "rc", "$\\scriptstyle -1$") ;

          fEnv("lineWidth", 1.0) ;
          fTeXlabel(2*pi, 1.05, "bc", "$y=\\cos^3 x$") ;
          fCurve("y= cos(x)*cos(x)*cos(x)", 0, xm, xM, OPEN) ;
          fEnv("psFillGray", 1.0) ;
          {double[] xlist = {-0.2*pi, -0.5*pi, -0.5*pi, -0.2*pi} ;
           double[] ylist = {0,     0,      1,    1} ;
           fPolygon(xlist, ylist, 4, FILLED) ;} 
          {double[] xlist = {2.2*pi, 2.5*pi, 2.5*pi, 2.2*pi} ;
           double[] ylist = {0,     0,      1,    1} ;
           fPolygon(xlist, ylist, 4, FILLED) ;} 
     }
}

class xcos implements S2V {

     double pi = Math.PI ;

   public xcos() { 
   }

     public double[] map(double t) {
          double[] out = {0,0} ;
          out[0] = t ;
          if (t>pi/2.0) 
             out[1] = Math.cos(t)*Math.cos(t)*Math.cos(t) ; 
          else 
             out[1] = Math.cos(pi-t)*Math.cos(pi-t)*Math.cos(pi-t) ;
          return out ;
   }
}





