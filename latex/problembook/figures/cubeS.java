                  /*  File:  cubeS.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class cubeS extends Template {

     static {templateClass = new cubeS() ; }

     public void setup() {
          filePrefix = "cubeS" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 0.75 ;    
          ysize = 0.75 ;  
          xmin = -10 ;
          xmax = 65 ;
          ymin = -10 ;
          ymax = 65 ;
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
          fEnv("psFillGray", 0.8) ;
          {double[] xlist = {0, 50, 50, 0} ;
           double[] ylist = {0,  0, 50, 50} ;
           fPolygon(xlist,ylist,4,FILLED) ;
          }
          String Pink = "1 0.3333 0.6666 setrgbcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ; ;

          fEnv("lineWidth", 1.5) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          {double[] xlist = {0, 50, 50, 0} ;
           double[] ylist = {0,  0, 50, 50} ;
           fPolygon(xlist,ylist,4,CLOSED) ;
          }

          fEnv("psFillGray", 0.0) ;
          double r = 3 ;
          fDisk(0,0, r, r, FILLED) ;
          fDisk(50,0, r, r, FILLED) ;
          fDisk(50,50, r, r, FILLED) ;
          fDisk(0,50, r, r, FILLED) ;

          fTeXlabel(-1,-1, "tr", "$(-1,-1,-1)$") ;
          fTeXlabel(25,-6, "tc", "$C_1$") ;
          fTeXlabel(51,-1, "tl", "$(1,-1,-1)$") ;
          fTeXlabel(55,25, "cl", "$C_2$") ;
          fTeXlabel(51,51, "bl", "$(1,1,-1)$") ;
          fTeXlabel(-1,51, "br", "$(-1,1,-1)$") ;
          fTeXlabel(25,55, "bc", "$C_3$") ;
          fTeXlabel(-5,25, "cr", "$C_4$") ;


          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Blue) ;
          fArrowhead(25,0, 0) ;
          fArrowhead(50,25, 90) ;
          fArrowhead(25,50, 180) ;
          fArrowhead(0,25, -90) ;
          
     }
}
