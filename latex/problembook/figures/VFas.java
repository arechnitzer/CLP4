                  /*  File:  VFas.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class VFas extends Template {

     static {templateClass = new VFas() ; }

     public void setup() {
          filePrefix = "VFas" ;    
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
          String Pink = "1 0.3333 0.6666 setrgbcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          fEnv("useColorPs", "true") ;

          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;

          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ;
          fEnv("lineWidth", 2.0) ;
          fDisk(0,0, 3,3, CLOSED) ;
          fTeXlabel(2.8, 0.3, "br", "$\\cC$") ;
          fEnv("headHalfWidth", 2.0*1.4) ;
          fEnv("headLength", 6.0*1.4) ;
          double th = 30 ; double thRad = th*Math.PI/180.0 ;
          double x = 3*Math.cos(thRad) ; 
          double y = 3*Math.sin(thRad) ; 
          fArrowhead(x,y, th-90) ;

          double scale = 0.15 ;
          double[] xlist = {-4, -3, -2, -1, 0, 1, 2, 3, 4} ;
          double[] ylist = {-4, -3, -2, -1, 0, 1, 2, 3, 4} ;
          int nx = xlist.length ;
          int ny = ylist.length ;


          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite(Pink+"\n")) ;
          fEnv("psFillColor", Pink) ;
          fEnv("headHalfWidth", 2.0*0.9) ;
          fEnv("headLength", 6.0*0.9) ;
          double dx, dy, len ;
          for (int i=0; i<ny ; i++) {
          for (int j=0; j<nx ; j++) {
               len = xlist[j]*xlist[j]+ylist[i]*ylist[i] ;
               if ( (xlist[j] !=0) || (ylist[i] != 0) ) {
               if ( len < 20 ) {
                    dx = scale*ylist[i] ; 
                    dy = -scale*xlist[j] ;
                    fArrow(xlist[j]-dx, ylist[i]-dy, xlist[j]+dx, ylist[i]+dy) ;
               }} 
               
          }}

          double r = 0.1 ;
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          fDisk(0,0, r, r*aspect, FILLED) ;

          
     }
}
