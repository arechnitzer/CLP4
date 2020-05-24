                  /*  File:  seesaw2.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class seesaw2 extends Template {

     static {templateClass = new seesaw2() ; }

     public void setup() {
          filePrefix = "seesaw2" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.1*2.0 ;      // in inches
          ysize = 0.6*2.0 ;   // in inches. 
          xmin = -10 ;
          xmax = 200 ;
          ymin = -30 ;
          ymax = 30 ;
          topmargin = 0.2 ;   // in inches
          bottommargin = 0.2 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 0.5) ;
          fEnv("lineWidth", 1.0) ;
          { double[] xlist = {30, 170, 170, 30} ;
            double[] ylist = {5,  5,   -5,  -5} ;
            fPolygon(xlist, ylist, 4, CLOSED) ;
          }
          double[] xlist = {40, 80, 120, 160} ;
          double[] ylist = {0 ,  0,   0,   0} ;
          canvas.append( new fPsWrite("0.7 setgray\n")) ;
          for (int i=0; i< 3; i++) {
               fLine(xlist[i], ylist[i], xlist[i+1], ylist[i+1]) ;
          }

          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          canvas.append( new fPsWrite("0.0 setgray\n")) ;
          for (int i=1; i<= xlist.length; i++) {
               fDisk(xlist[i-1], ylist[i-1], 3, 3, FILLED) ;
               fArrow(xlist[i-1], ylist[i-1], xlist[i-1], ylist[i-1]-30) ;
               fTeXlabel(xlist[i-1], ylist[i-1]-28, "tc", "$-m_"+i+"g\\,\\hk$") ;
          }
          fArrow(xlist[1], ylist[1], xlist[1], ylist[1]+30) ;
          fTeXlabel(xlist[1], ylist[1]+32, "bc", "$\\vPhi$") ;
          fTeXlabel(xlist[1]+1, 9, "cl", "$\\vp$") ;
          { double[] xxlist = {70, 80, 90} ;
            double[] yylist = {-15, -5.5, -15} ;
            fEnv("psFillGray", 0.7) ;
            fPolygon(xxlist, yylist, 3, FILLED) ;
            fPolygon(xxlist, yylist, 3, CLOSED) ;
          }


          
     }
}
