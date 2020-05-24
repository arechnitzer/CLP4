                  /*  File:  OE10A_5.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE10A_5 extends Template {

     static {templateClass = new OE10A_5() ; }

     public void setup() {
          filePrefix = "OE10A_5" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.4*0.8 ;      
          ysize = 2.4*0.8 ;  
          xmin = -1.2 ;
          xmax = 1.2 ;
          ymin = -1.2 ;
          ymax = 1.2 ;
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
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;

          fEnv("lineWidth", 2) ;
          fCurve("[t , 1-t*t]", 1, -1, 1, OPEN) ;
          double x = 0.5 ; double y = 1-x*x ;
          fTeXlabel(x, y+0.02, "bl", "$\\sigma_1,\\ z=1-x^2-y^2$") ;
          fCurve("[t , t*t-1]", 1, -1, 1, OPEN) ;
          x = 0.5 ;  y = x*x -1 ;
          fTeXlabel(x, y-0.05, "tl", "$\\sigma_2,\\ z=x^2+y^2-1$") ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fLine(-1,0, 1,0) ;
          fTeXlabel(x, -0.07, "tl", "$\\sigma_3$") ;


//          canvas.append( new fPsWrite(Black+"\n")) ;
//          fEnv("psFillColor", Black) ;
//
//          fEnv("lineWidth", 0.5) ;
//          fEnv("headHalfWidth", 2.0*1.2) ;
//          fEnv("headLength", 6.0*1.2) ;
//          fArrow(0,a, 0, a+L) ; 
//          fArrow(x,0, x+L, 0) ; 
//          fArrow(0,h, 0, h+L) ; 
//          fArrow(0,-h, 0, -h-L) ; 
//
//          fTeXlabel(0, -h/1.5, "cc", "$E_a$") ;
//          fTeXlabel(0, -a-1, "tl", "$\\sigma_a$") ;
//          fTeXlabel(1.5*x, -0.5*h, "lb", "$\\sigma$") ;
     }
}
