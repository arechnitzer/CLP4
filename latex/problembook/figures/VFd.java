                  /*  File:  VFd.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class VFd extends Template {

     static {templateClass = new VFd() ; }
     private static double pi = Math.PI ;

     public void setup() {
          filePrefix = "VFd" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.5 ;      // in inches
          ysize = 2.5 ;   // in inches
          xmin = -0.5 ;
          xmax = 10 ;
          ymin = -0.5 ;
          ymax = 10 ;

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
          String Pink = "1 0.3333 0.6666 setrgbcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          fEnv("useColorPs", "true") ;

          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;

          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite(Pink+"\n")) ;
          fEnv("psFillColor", Pink) ;
          fEnv("headHalfWidth", 2.0*0.9) ;
          fEnv("headLength", 6.0*0.9) ;

          double len = 0.35 ;
          double r = 0.07 ;
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          double[] xlist = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9} ;
          double[] ylist = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 } ;
          int nx = xlist.length ;
          int ny = ylist.length ;

          double dx, dy ;
          for (int i=0; i<ny ; i++) {
          for (int j=0; j<nx ; j++) {
                    dx = 0 ; 
                    dy = 0.2*Math.exp(ylist[i]/14.0+0.2) ;
                    fArrow(xlist[j]-dx, ylist[i]-dy, xlist[j]+dx, ylist[i]+dy) ;
          }}
          
     }
}
