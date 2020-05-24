                  /*  File:  cube.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class cube extends Template {

     static {templateClass = new cube() ; }

     public void setup() {
          filePrefix = "cube" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.3 ;      // in inches
          ysize = 1.3 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -59 ;
          xmax = 41 ;
          ymin = -20 ;
          ymax = 80 ;
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

          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;

          fEnv("lineWidth", 1.0) ;
          double x1 = 40*0.8 ;
          double y1 = 30*0.8 ;
          double x2 = 00 ;
          double y2 = 50 ;
          double x3 = -50 ;
          double y3 = 00 ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
//          fEnv("arrowHeadColor", Red) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          fArrow(0, 0, x1, y1) ;
          fArrow(0, 0, x2, y2) ;
          fArrow(0, 0, x3, y3) ;
          fEnv("useColorPs", "false") ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("psFillColor", Black) ;
          fDisk(0, 0, 2.2, 2.2, FILLED) ;

          fEnv("lineWidth", 0.5) ;
          fLine(x1, y1, x1+x2, y1+y2) ;
          fLine(x3, y3, x3+x2, y3+y2) ;
          fLine(x2, y2, x2+x3, y2+y3) ;
          fLine(x2, y2, x2+x1, y2+y1) ;
          fLine(x1+x2, y1+y2, x1+x2+x3, y1+y2+y3) ;
          fLine(x3+x2, y3+y2, x1+x2+x3, y1+y2+y3) ;
          
          fTeXlabel(2,-4, "tl", "$\\vx_0$") ;
          fTeXlabel(x1/2,y1/2-3, "lc", "$\\veps\\ha{2}$") ;
          fTeXlabel(-2,y2/2, "rb", "$\\veps\\ha{1}$") ;
          fTeXlabel(x3/2-5,-2, "tc", "$\\veps\\ha{3}$") ;


          
     }
}
