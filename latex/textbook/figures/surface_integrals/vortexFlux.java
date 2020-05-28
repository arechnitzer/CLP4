                  /*  File:  vortexFlux.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class vortexFlux extends Template {

     static {templateClass = new vortexFlux() ; }

     public void setup() {
          filePrefix = "vortexFlux" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.5 ;      // in inches
          ysize = 2.5 ;   // in inches. 
          xmin = -5 ;
          xmax = 5 ;
          ymin = -5 ;
          ymax = 5 ;
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
          fEnv("lineWidth", 0.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
//          fLine(xmin, 0, xmax, 0) ;
//          fLine(0, ymin, 0, ymax) ;
//          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
//          fTeXlabel(-0.1, ymax, "tr", "$y$") ;
          canvas.append( new fPsWrite(Black+"\n")) ;

          double r1 = 1.0 ; double l1 = 0.7 ;
          double x1 = 1.0/Math.sqrt(2) ; double y1 = 1.0/Math.sqrt(2) ;
          
          double[] xlist =   {x1,  -x1,  -x1, x1} ;
          double[] ylist =   {y1,   y1,  -y1, -y1} ;
          double[] lenlist = { l1 , l1, l1, l1} ;
          int nx = xlist.length ;
          int ny = ylist.length ;


          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ;
          fEnv("headHalfWidth", 2.0) ;
          fEnv("headLength", 6.0) ;
          double dx, dy, len ;
          for (int i=0; i<nx ; i++) {
               len = lenlist[i]/Math.sqrt(xlist[i]*xlist[i]+ylist[i]*ylist[i]) ;
                    dx = -len*ylist[i] ; 
                    dy = len*xlist[i] ;
                    fArrow(xlist[i], ylist[i], xlist[i]+dx, ylist[i]+dy) ;
          }
          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("psFillColor", Black) ;
          double x = 2.0/Math.sqrt(2) ; double y = 2.0/Math.sqrt(2) ;
          len = 1.2/Math.sqrt(x*x+y*y) ;
          dx = len*x ;  dy = len*y ;
          fArrow(x, y, x+dx, y+dy) ;
          fTeXlabel(x+1.1*dx,y+1.1*dy, "bl", "$\\hn$") ;


          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 2.0) ;
          fDisk(0,0, 2, 2, CLOSED) ;
          
     }
}
