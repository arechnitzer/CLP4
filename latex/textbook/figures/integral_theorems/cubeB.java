                  /*  File:  cubeB.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class cubeB extends Template {

     static {templateClass = new cubeB() ; }

     public void setup() {
          filePrefix = "cubeB" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.3 ;      // in inches
          ysize = 1.3 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -59 ;
          xmax = 41 ;
          ymin = -20 ;
          ymax = 90 ;
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
          double x1 = 50*0.8 ;
          double y1 = -20*0.8 ;
          double x2 = -10 ;
          double y2 = 50 ;
          double x3 = -20 ;
          double y3 = 40 ;
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
          
          fTeXlabel(x1/2-8,y1/2-10, "lt", "$\\scriptstyle\\veps\\vb_2(t)$") ;
          fTeXlabel(-4,y2/2, "lb", "$\\scriptstyle\\veps\\vb_1(t)$") ;
          fTeXlabel(x3/2-7,y3-10, "tr", "$\\scriptstyle\\veps\\vb_3(t)$") ;


          
     }
}
