                  /*  File:  domainTriangle.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class domainTriangle extends Template {

     static {templateClass = new domainTriangle() ; }

     public void setup() {
          filePrefix = "domainTriangle" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;    
          ysize = 1.5 ;  
          xmin = -70 ;
          xmax =  80 ;
          ymin = -70 ;
          ymax =  80 ;
          topmargin = 0.2 ;   // in inches
          bottommargin = 0.1 ;   // in inches
          leftmargin = 0.3 ;   // in inches
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
          double th = -135*Math.PI/180 ;
          double x0 = Math.cos(th) ;
          double x1 = Math.sin(th) ;
          double a = 40 ;
          double b = 50 ;
          double c = 70 ;
          double xm = 50 ;
          double ym = 60 ;
          double zm = 80 ;

          {fEnv("psFillGray", 0.8) ;
           double[] xlist = {0, a*x0, b} ;
           double[] ylist = {0, a*x1, 0} ;
           fPolygon(xlist, ylist, 3, FILLED) ;
           }

          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fEnv("useColorPs", "true") ;
          fEnv("lineWidth", 1.0) ;
          fEnv("headLength", 6.0*1.2) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fLine(0,c,b,0) ;
          fArrow(b,0, b/2, c/2) ;
          fTeXlabel(b/2+2,c/2, "bl", "$C_2$") ;
          fLine(a*x0,a*x1,b,0) ;
          fArrow(a*x0,a*x1, b/2+a*x0/2, a*x1/2) ;
          fTeXlabel(b/2+a*x0/2, a*x1/2-2, "tl", "$C_1$") ;
          fLine(a*x0,a*x1,0,c) ;
          fArrow(0,c, a*x0/2, a*x1/2+c/2) ;
          fTeXlabel(a*x0/2-3, a*x1/2+c/2, "br", "$C_3$") ;
          canvas.append( new fPsWrite(Black+"\n")) ;

          fEnv("lineWidth", 0.5) ;
          fLine(0,0,ym,0) ;
          fLine(0,0,0,zm) ;
          fLine(0,0, xm*x0, xm*x1) ;
          fTeXlabel(ym+5,0, "lc", "$y$") ;
          fTeXlabel(0,zm+5, "bc", "$z$") ;
          fTeXlabel((xm+5)*x0, (xm+5)*x1, "tr", "$x$") ;
          
     }
}

