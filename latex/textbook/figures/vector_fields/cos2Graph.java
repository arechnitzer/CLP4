                  /*  File:  cos2Graph.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class cos2Graph extends Template {

     static {templateClass = new cos2Graph() ; }

     public void setup() {
          filePrefix = "cos2Graph" ;    // used as the prefix for ps and lbl files 
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.5 ;    
          ysize = 1.2 ;   
          double pi = Math.PI ;
          xmin = -0.2*pi ;
          xmax =  2.2*pi ;
          ymin = -0.2 ;
          ymax = 1.5 ;
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
          fCurve("y= cos(x)* cos(x)", 0, 0.75*pi, pi, FILLED) ;
          fCurve("y= cos(x)* cos(x)", 0, 1.75*pi, 2*pi, FILLED) ;
          {double[] xlist = {pi/2, pi, pi} ;
           double[] ylist = {0,     0,   1} ;
           fPolygon(xlist, ylist, 3, FILLED) ;} 
          {double[] xlist = {3*pi/2, 2*pi, 2*pi} ;
           double[] ylist = {0,     0,   1} ;
           fPolygon(xlist, ylist, 3, FILLED) ;} 
          fEnv("psFillGray", 0.8) ;
          {double[] xlist = {0, 0, pi/2} ;
           double[] ylist = {1, 0,   0} ;
           fPolygon(xlist, ylist, 3, FILLED) ;} 
          {double[] xlist = {pi, pi, 3*pi/2} ;
           double[] ylist = {1, 0,   0} ;
           fPolygon(xlist, ylist, 3, FILLED) ;} 
          fCurve("y= cos(x)* cos(x)", 0, 0, pi/2, FILLED) ;
          fCurve("y= cos(x)* cos(x)", 0, pi, 3*pi/2, FILLED) ;
          fEnv("psFillGray", 1.0) ;
          fCurve("y= cos(x)* cos(x)", 0, 0, pi, FILLED) ;
          fCurve("y= cos(x)* cos(x)", 0, pi, 2*pi, FILLED) ;
          fEnv("lineWidth", 0.5) ;
          fLine(xmin,0, xmax,0) ;
          fLine(0,ymin, 0, ymax) ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;
          fTeXlabel(xmax+0.1, 0, "cl", "$x$") ;
          for(int i=0 ; i<5 ; i++) {
               fLine(i*pi/2, 0,  i*pi/2, -0.08) ;
          }
          fTeXlabel(pi,-0.13, "tc", "$\\scriptstyle\\pi$") ;
          fTeXlabel(0.5*pi,-0.12, "tc", "$\\nicefrac{\\pi}{2}$") ;
          fTeXlabel(2*pi,-0.13, "tc", "$\\scriptstyle2\\pi$") ;
          fTeXlabel(1.5*pi,-0.12, "tc", "$\\nicefrac{3\\pi}{2}$") ;
          fLine(-0.13,1,  0,1) ;
          fTeXlabel(-0.2,1, "rb", "$\\scriptstyle 1$") ;

          fEnv("lineWidth", 1.0) ;
          fTeXlabel(pi, 1.05, "bc", "$y=\\cos^2 x$") ;
          fCurve("y= cos(x)* cos(x)", 0, xmin, xmax, OPEN) ;
     }
}




