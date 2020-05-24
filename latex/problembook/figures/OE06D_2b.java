                  /*  File:  OE06D_2b.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class OE06D_2b extends Template {

     static {templateClass = new OE06D_2b() ; }

     public void setup() {
          filePrefix = "OE06D_2b" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.5*0.8 ;   
          ysize = 2.5*0.8 ;   
          xmin = -0.1  ;
          xmax = 5.5 ;
          ymin = -0.1 ;
          ymax = 5.5 ;
          topmargin = 0.0 ;
          bottommargin = 0 ;
          leftmargin = 0.0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          fEnv("headHalfWidth", 2.0*1.5) ;
          fEnv("headLength", 6.0*1.5) ;
          fEnv("lineWidth", 0.5) ;
          double r = 0.1 ;
          double X = 0.7 ;
          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;

          double X1 = 0 ; double Y1 = 0 ; 
          double X2 = 0 ; double Y2 = 1 ; 
          double X3 = 1 ; double Y3 = 1 ; 
          double X4 = 1 ; double Y4 = 2 ; 
          double X5 = 2 ; double Y5 = 2 ; 
          double X6 = 2 ; double Y6 = 3 ; 
          double X7 = 3 ; double Y7 = 3 ; 
          double X8 = 3 ; double Y8 = 4 ; 
          double X9 = 4 ; double Y9 = 4 ; 
          double X10 = 4 ; double Y10 = 5 ; 
          double X11 = 5 ; double Y11 = 5 ; 

          double dX1 = X2-X1 ; double dY1 = Y2-Y1 ; 
          double dX2 = X3-X2 ; double dY2 = Y3-Y2 ; 
          double dX3 = X4-X3 ; double dY3 = Y4-Y3 ; 
          double dX4 = X5-X4 ; double dY4 = Y5-Y4 ; 
          double dX5 = X6-X5 ; double dY5 = Y6-Y5 ; 
          double dX6 = X7-X6 ; double dY6 = Y7-Y6 ; 
          double dX7 = X8-X7 ; double dY7 = Y8-Y7 ; 
          double dX8 = X9-X8 ; double dY8 = Y9-Y8 ; 
          double dX9 = X10-X9 ; double dY9 = Y10-Y9 ; 
          double dX10 = X11-X10 ; double dY10 = Y11-Y10 ; 
          double dX11 = X1-X11 ; double dY11 = Y1-Y11 ; 



         fEnv("psFillGray", 0.8) ;
         {  double[] xlist = {X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11} ;
             double[] ylist = {Y1, Y2, Y3, Y4, Y5, Y6, Y7, Y8, Y9, Y10, Y11} ;
             fPolygon(xlist, ylist, 11, FILLED) ; }

          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          fEnv("lineWidth", 1.5) ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          {  double[] xlist = {X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11} ;
             double[] ylist = {Y1, Y2, Y3, Y4, Y5, Y6, Y7, Y8, Y9, Y10, Y11} ;
             fPolygon(xlist, ylist, 11, OPEN) ; }


          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ;
          fLine(X11,Y11, X1,Y1) ;
          fArrowhead(0.5*X11+0.5*X1, 0.5*Y11+0.5*Y1, -135) ;
          fTeXlabel(0.5*X11+0.5*X1+0.05, 0.5*Y11+0.5*Y1-0.05, "tl", "$L$") ;




          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fDisk(X1,Y1, r,r, FILLED) ;
          fDisk(X2,Y2, r,r, FILLED) ;
          fDisk(X3,Y3, r,r, FILLED) ;
          fDisk(X4,Y4, r,r, FILLED) ;
          fDisk(X5,Y5, r,r, FILLED) ;
          fDisk(X6,Y6, r,r, FILLED) ;
          fDisk(X7,Y7, r,r, FILLED) ;
          fDisk(X8,Y8, r,r, FILLED) ;
          fDisk(X9,Y9, r,r, FILLED) ;
          fDisk(X10,Y10, r,r, FILLED) ;
          fDisk(X11,Y11, r,r, FILLED) ;

          fEnv("headLength", 6.0*1.4) ;
          fEnv("headHalfWidth", 2.0*1.4) ;
          fArrowhead(0.5*X1+0.5*X2, 0.5*Y1+0.5*Y2, 90) ;
          fArrowhead(0.5*X2+0.5*X3, 0.5*Y2+0.5*Y3,  0) ;
          fArrowhead(0.5*X3+0.5*X4, 0.5*Y3+0.5*Y4, 90) ;
          fArrowhead(0.5*X4+0.5*X5, 0.5*Y4+0.5*Y5,  0) ;
          fArrowhead(0.5*X5+0.5*X6, 0.5*Y5+0.5*Y6, 90) ;
          fArrowhead(0.5*X6+0.5*X7, 0.5*Y6+0.5*Y7,  0) ;
          fArrowhead(0.5*X7+0.5*X8, 0.5*Y7+0.5*Y8, 90) ;
          fArrowhead(0.5*X8+0.5*X9, 0.5*Y8+0.5*Y9,  0) ;
          fArrowhead(0.5*X9+0.5*X10, 0.5*Y9+0.5*Y10, 90) ;
          fArrowhead(0.5*X10+0.5*X11, 0.5*Y10+0.5*Y11, 0) ;


          fTeXlabel(-0.05,  -0.05, "tr", "$(0,0)$") ;
          fTeXlabel(-0.05,   0.95, "tr", "$(0,1)$") ;
          fTeXlabel(1.05,   0.95, "tl", "$(1,1)$") ;
          fTeXlabel(2.05,   1.95, "tl", "$(2,2)$") ;
          fTeXlabel(3.05,   2.95, "tl", "$(3,3)$") ;
          fTeXlabel(4.05,   3.95, "tl", "$(4,4)$") ;
          fTeXlabel(5.05,   4.95, "tl", "$(5,5)$") ;
          fDisk(1,2, r,r, FILLED) ;
          fTeXlabel(1,  2.1, "bc", "$(1,2)$") ;
          fTeXlabel(2,  3.1, "bc", "$(2,3)$") ;
          fTeXlabel(3,  4.1, "bc", "$(3,4)$") ;
          fTeXlabel(4,  5.1, "bc", "$(4,5)$") ;
          fTeXlabel(0.87, 1.1, "br", "$C$") ;



          fTeXlabel(xmax, -0.05, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$y$") ;





     }
}
