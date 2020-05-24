                  /*  File:  OE16D_8.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class OE16D_8 extends Template {

     static {templateClass = new OE16D_8() ; }

     public void setup() {
          filePrefix = "OE16D_8" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.0*0.3 ;   
          ysize = 5.0*0.3 ;   
          xmin = -0.5 ;
          xmax = 2.5 ;
          ymin = -0.5  ;
          ymax = 4.5 ;
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

          double X1 = 0 ; double Y1 = 0 ;
          double X2 = 2 ; double Y2 = 0 ;
          double X3 = 2 ; double Y3 = 4 ;
          double X4 = 0 ; double Y4 = 2 ;

          fEnv("psFillGray", 0.9) ;
          {  double[] xlist = {X1, X2, X3, X4} ;
             double[] ylist = {Y1, Y2, Y3, Y4} ;
             fPolygon(xlist, ylist, 4, FILLED) ; }


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;
          fTeXlabel(xmax, -0.09, "tr", "$y$") ;
          fTeXlabel(-0.05, ymax, "tr", "$z$") ;
          canvas.append( new fPsWrite("0.7 setgray\n")) ;
          fLine(xmin, 2+xmin, xmax, 2+xmax) ;
          fTeXlabel(xmax+0.1, 2+xmax, "lc", "$z=2+y$") ;
          fTeXlabel(2.15, 2, "lc", "$y=2$") ;
          fTeXlabel(1, 1.5, "cc", "$E$") ;


//          fTeXlabel(r+0.05,-r+0.06, "bl", "$\\theta$") ;
//          fTeXlabel(R+0.02,R+0.02, "bl", "$x^2+y^2=4z^2$") ;
//


          fEnv("lineWidth", 1.5) ;
          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          {  double[] xlist = {X1, X2, X3, X4} ;
             double[] ylist = {Y1, Y2, Y3, Y4} ;
             fPolygon(xlist, ylist, 4, CLOSED) ; }

 
     
     
     }
}
