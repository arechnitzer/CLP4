                  /*  File:  VFh.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class VFh extends Template {

     static {templateClass = new VFh() ; }

     public void setup() {
          filePrefix = "VFh" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2 ;      // in inches
          ysize = 2 ;   // in inches. 
          xmin = -4 ;
          xmax = 4 ;
          ymin = -4 ;
          ymax = 4 ;
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
          String Pink = "1 0.3333 0.6666 setrgbcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          fEnv("useColorPs", "true") ;

          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;


          double scale = 0.4 ;
          
          double[] xlist = {-3, -2, -1, 0, 1, 2, 3} ;
          double[] ylist = {-3, -2, -1, 0, 1, 2, 3} ;
          int nx = xlist.length ;
          int ny = ylist.length ;


          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ;
          fEnv("lineWidth", 0.5) ;
          fEnv("headHalfWidth", 2.0*1.0) ;
          fEnv("headLength", 6.0*1.0) ;

          double dx, dy, len ;
          for (int i=0; i<ny ; i++) {
          for (int j=0; j<nx ; j++) {
               len = Math.sqrt(xlist[j]*xlist[j]+ylist[i]*ylist[i]) ;
               if ( (xlist[j] !=0) || (ylist[i] != 0) ) {
               if ( len < 20 ) {
                    dx = scale*ylist[i]/len ; 
                    dy = -scale*xlist[j]/len ;
                    fArrow(xlist[j]-dx, ylist[i]-dy, xlist[j]+dx, ylist[i]+dy) ;
               }} 
               
          }}

//          double r = 0.1 ;
//          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
//          fDisk(0,0, r, r*aspect, FILLED) ;

          
     }
}
