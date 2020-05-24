                  /*  File:  OE03A_4.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class OE03A_4 extends Template {

     static {templateClass = new OE03A_4() ; }

     public void setup() {
          filePrefix = "OE03A_4" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2 ;   
          ysize = 2 ;   
          xmin = -0.1  ;
          xmax = 2.6 ;
          ymin = -0.1 ;
          ymax = 2.6 ;
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
          double r = 0.08 ;
          double X = 1.3 ;

          fEnv("psFillGray", 0.9) ;
          {  double[] xlist = {1, 1, Math.sqrt(2), 2} ;
             double[] ylist = {1, 2, Math.sqrt(2), 1} ;
             fPolygon(xlist, ylist, 4, FILLED) ; }
          fEnv("psFillGray", 1.0) ;
          fCurve("y=2/x",     0, 1, 2, FILLED) ;


          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          fLine(xmin, 1, xmax, 1) ;
          fLine(1, ymin, 1, ymax) ;
          fCurve("y=2/x",     0, 0.5, xmax, OPEN) ;



          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 1.5) ;
//          fEnv("psFillColor", Blue) ;
          fLine( 1,1, 1,2) ;      
          fLine( 1,1, 2,1) ;  
          fCurve("y=2/x",     0, 1, 2, OPEN) ;
          fTeXlabel(0.5, 1.03, "bc", "$y=1$") ;
          fTeXlabel(1.03, 0.5, "cl", "$x=1$") ;
          fTeXlabel(xmax+0.05, 2/xmax, "cl", "$xy=2$") ;



//          canvas.append( new fPsWrite(Red+"\n")) ;
//          fEnv("psFillColor", Red) ;
//          fDisk(2,0, r,r*aspect, FILLED) ;
//          fTeXlabel(2,  0.05, "bl", "$(2,0)$") ;
//          fDisk(0,2, r,r*aspect, FILLED) ;
//          fTeXlabel(0.05,  2.05, "bl", "$(0,2)$") ;

          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("lineWidth", 3.0) ;
          fLine(X,1, X,2/X) ;


          fTeXlabel(xmax, -0.05, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$y$") ;





     }
}
