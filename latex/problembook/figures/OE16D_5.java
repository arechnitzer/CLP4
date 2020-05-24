                  /*  File:  OE16D_5.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class OE16D_5 extends Template {

     static {templateClass = new OE16D_5() ; }

     public void setup() {
          filePrefix = "OE16D_5" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 4.0*0.6 ;   
          ysize = 3.2*0.6 ;   
          xmin = -0.5 ;
          xmax = 3.5 ;
          ymin = -1.5  ;
          ymax = 1.7 ;
          topmargin = 0.1 ;
          bottommargin = 0 ;
          leftmargin = 0.0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          double X1 = 0 ; double Y1 = -1 ; 
          double X2 = 3 ; double Y2 = -1 ; 
          double X3 = 3 ; double Y3 = 1 ;
          double X4 = 0 ; double Y4 = 1 ;
          double l = 0.5 ;

          fEnv("psFillGray", 0.9) ;
          {  double[] xlist = {X1, X2, X3, X4} ;
             double[] ylist = {Y1, Y2, Y3, Y4} ;
             fPolygon(xlist, ylist, 4, FILLED) ; }


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;
          fTeXlabel(xmax, -0.07, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$y$") ;
          fTeXlabel(1.5, -0.5, "cc", "$R$") ;
//          fTeXlabel(0.83,  1.06, "bc", "$C$") ;
          fTeXlabel(0.83,  -1.06, "tc", "$L_1$") ;
          fTeXlabel(3.06,  -0.4, "lc", "$L_2$") ;
          fTeXlabel(0.83,  1.06, "bc", "$L_3$") ;
          fTeXlabel(-0.06,  0.4, "rc", "$L_4$") ;

          fArrow(1.7, -1, 1.7, -1-l) ; fTeXlabel(1.75, -l-1, "cl", "$\\hn$") ;
          fArrow(1.7,  1, 1.7,  1+l) ; fTeXlabel(1.75,  l+1.05, "cl", "$\\hn$") ;
          fArrow(3.0, 0.4, 3.0+l, 0.4) ; fTeXlabel(3.1+l, 0.45, "br", "$\\hn$") ;
          fArrow(0.0, -0.4, -l,  -0.4) ; fTeXlabel(-l+0.1, -0.45, "tr", "$\\hn$") ;


          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fEnv("lineWidth", 1.5) ;
          {  double[] xlist = {X1, X2, X3, X4} ;
             double[] ylist = {Y1, Y2, Y3, Y4} ;
             fPolygon(xlist, ylist, 4, CLOSED) ; }
 
//          fEnv("arrowHeadColor", Red) ;  
          fEnv("headHalfWidth", 2.0*1.5) ;  
          fEnv("headLength", 6.0*1.5) ;
          fArrowhead(1.5,-1, 0) ;  
          fArrowhead(1.5, 1, 180) ;  
          fArrowhead(3,0.2, 90) ;  
          fArrowhead(0,-0.2, -90) ;

          fEnv("psFillColor", Blue) ;
          double r = 0.06 ;
          fDisk(0,-1, r,r, FILLED) ; fTeXlabel(-0.06, -1.03, "tr", "$(0,-1)$") ;
          fDisk(3,-1, r,r, FILLED) ; fTeXlabel(3.06, -1.03, "tl", "$(3,-1)$") ;
          fDisk(3,1, r,r, FILLED) ; fTeXlabel(3.06, 1.03, "bl", "$(3,1)$") ;
          fDisk(0,1, r,r, FILLED) ; fTeXlabel(-0.06, 1.03, "br", "$(0,1)$") ;


     
     }
}
