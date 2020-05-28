                  /*  File:  pathIndep.java    */


import figPac.* ;
import fnPac.* ;
//import java.applet.* ;
//import java.awt.* ;


public class pathIndep extends Template {

     static {templateClass = new pathIndep() ; }

     public void setup() {
          filePrefix = "pathIndep" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;      // in inches
          ysize = 1.0 ;   // in inches. 
          xmin = -2.2 ;
          xmax = 2.2 ;
          ymin = -1.1 ;
          ymax = 1.1 ;
          topmargin = 0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
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

          fEnv("lineWidth", 1.0) ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ;
          fCurve("-(x+1)*(x+1)",0, -2, -1, OPEN) ;
          fCurve("(x-1)*(x-1)",0, 1, 2, OPEN) ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fCurve("(x*x-1)*(x*x-1)/2",0, -1, 1, OPEN) ;
          fCurve("-(x*x-1)*(x*x-1)/2",0, -1, 1, OPEN) ;
          double r = 0.04 ; 
          fDisk(-1, 0, r, r, FILLED+CLOSED) ;
          fTeXlabel(-0.9, 0.1, "br", "$P_0'$") ;
          fDisk(1, 0, r, r, FILLED+CLOSED) ;
          fTeXlabel(0.9, -0.1, "tl", "$P_1'$") ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ;
          fDisk(-2, -1, r, r, FILLED+CLOSED) ;
          fTeXlabel(-2.05, -1, "cr", "$P_0$") ;
          fDisk(2, 1, r, r, FILLED+CLOSED) ;
          fTeXlabel(2.05, 1, "cl", "$P_1$") ;

          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          double x = -1.6 ; double y = -(x+1)*(x+1) ; double yp = -2*(x+1) ;
          double th = Math.atan(yp)*180/Math.PI ;
          fArrowhead(x,y, th) ;
          fTeXlabel(x-0.2,y+0.05, "bc", "$\\cC_\\ell$") ;
          x = 1.6 ; y = (x-1)*(x-1) ;  yp = 2*(x-1) ;
          th = Math.atan(yp)*180/Math.PI ;
          fArrowhead(x,y, th) ;
          fTeXlabel(x+0.2,y-0.05, "tc", "$\\cC_r$") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          x = 0 ; y = (x*x-1)*(x*x-1)/2 ; 
          fArrowhead(x,y, 0) ;
          fTeXlabel(x,y+0.1, "bc", "$\\cC'_1$") ;
          x = 0 ; y = -(x*x-1)*(x*x-1)/2 ; 
          fArrowhead(x,y, 0) ;
          fTeXlabel(x,y-0.15, "tc", "$\\cC'_2$") ;

          
     }
}


