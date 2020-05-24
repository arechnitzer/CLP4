                  /*  File:  domainTriangleA.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class domainTriangleA extends Template {

     static {templateClass = new domainTriangleA() ; }

     public void setup() {
          filePrefix = "domainTriangleA" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.0 ;    
          ysize = 1.0 ;  
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
          double th = -135*Math.PI/180 ;
          double x0 = 0.8*Math.cos(th) ;
          double x1 = 0.8*Math.sin(th) ;
          double a = 70 ;
          double b = 70 ;
          double c = 70 ;
          double A = 0.3 ;
          double B = 0.3 ;
          double C = 0.4 ;

          fEnv("useColorPs", "true") ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ;
          fEnv("lineWidth", 1.0) ;
          fLine(0,c,b,0) ;
          fLine(a*x0,a*x1,b,0) ;
          fLine(a*x0,a*x1,0,c) ;
          fArrow(b,0,b/2,c/2) ;
          fArrow(a*x0,a*x1,b/2+a*x0/2,a*x1/2) ;
          fArrow(0,c, a*x0/2,a*x1/2+c/2) ;

          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("psFillColor", Black) ;
          fEnv("lineWidth", 0.5) ;
          fLine(0,0,xmax,0) ;
          fLine(0,0,0,ymax) ;
          fLine(0,0, xmax*x0, xmax*x1) ;
          fArrow(A*a*x0+B*b,A*a*x1+C*c, 
                  (A+1.5)*a*x0+(B+1.5)*b,(A+1.5)*a*x1+(C+1.5)*c) ;
          fTeXlabel((A+1.5)*a*x0+(B+1.5)*b+2,(A+1.5)*a*x1+(C+1.5)*c+2, 
                           "bl", "$\\hn$") ;
          fTeXlabel(xmax+5,0, "lc", "$y$") ;
          fTeXlabel(0,ymax+5, "bc", "$z$") ;
          fTeXlabel(xmax*x0, xmax*x1, "tr", "$x$") ;
          
     }
}

