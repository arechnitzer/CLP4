                  /*  File:  seesaw.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class seesaw extends Template {

     static {templateClass = new seesaw() ; }

     public void setup() {
          filePrefix = "seesaw" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.1*1.5 ;      // in inches
          ysize = 1.0*1.5 ;   // in inches. 
          xmin = -10 ;
          xmax = 200 ;
          ymin = -10 ;
          ymax = 90 ;
          topmargin = 0.1 ;   // in inches
          bottommargin = 0.1 ;   // in inches
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
          fRotate(20*Math.PI/180) ;
          { double[] xlist = {30, 170, 170, 30} ;
            double[] ylist = {20,  20,   0,  0} ;
            fPolygon(xlist, ylist, 4, CLOSED) ;
          }
//          { double[] xlist = {80, 90, 100} ;
//            double[] ylist = {-10, -0.5, -10} ;
//            fPolygon(xlist, ylist, 3, CLOSED) ;
//          }
          double[] xlist = {40, 80, 120, 160, 40, 80, 120, 160} ;
          double[] ylist = {5 ,  5,   5,   5, 15, 15,  15,  15} ;
          canvas.append( new fPsWrite("0.7 setgray\n")) ;
          for (int i=0; i< 4; i++) {
               fLine(xlist[i], ylist[i], xlist[i+4], ylist[i+4]) ;
          }
          for (int i=0; i< 3; i++) {
               fLine(xlist[i], ylist[i], xlist[i+1], ylist[i+1]) ;
          }
          for (int i=4; i< 7; i++) {
               fLine(xlist[i], ylist[i], xlist[i+1], ylist[i+1]) ;
          }
          fLine(xlist[0], ylist[0], xlist[5], ylist[5]) ;
          fLine(xlist[1], ylist[1], xlist[4], ylist[4]) ;
          fLine(xlist[2], ylist[2], xlist[5], ylist[5]) ;
          fLine(xlist[1], ylist[1], xlist[6], ylist[6]) ;
          fLine(xlist[2], ylist[2], xlist[7], ylist[7]) ;
          fLine(xlist[3], ylist[3], xlist[6], ylist[6]) ;

          canvas.append( new fPsWrite("0.0 setgray\n")) ;
          for (int i=0; i< xlist.length; i++) {
               fDisk(xlist[i], ylist[i], 3, 3, FILLED) ;
          }


          
     }
}
