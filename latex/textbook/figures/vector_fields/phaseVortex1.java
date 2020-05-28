                  /*  File:  phaseVortex1.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class phaseVortex1 extends Template {

     static {templateClass = new phaseVortex1() ; }

     public void setup() {
          filePrefix = "phaseVortex1" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;      // in inches
          ysize = 2.0 ;   // in inches. 
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
          fEnv("lineWidth", 1.0) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
//          fEnv("psFillColor", Red) ; 
          fLine(xmin, 0, xmax, 0) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.2, "tr", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;
          canvas.append( new fPsWrite(Black+"\n")) ;

          double scale = 0.15 ;
          
          double[] xlist = {-3,  0, 3} ;
          double[] ylist = {-3,  0, 3} ;
          int nx = xlist.length ;
          int ny = ylist.length ;


          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          double len = 1.4 ; double dx, dy ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ; 
          for (int i=0; i<ny ; i++) {
          for (int j=0; j<nx ; j++) {
               if (xlist[j] !=0) {
                    dy = len*xlist[j]/Math.abs(xlist[j]) ;
                    fArrow(xlist[j], ylist[i], xlist[j], ylist[i]+dy) ;
               }
          }}
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ; 
          for (int i=0; i<ny ; i++) {
          for (int j=0; j<nx ; j++) {
               if (ylist[i] != 0) {
                    dx = len*ylist[i]/Math.abs(ylist[i])  ; 
                    fArrow(xlist[j], ylist[i], xlist[j]-dx, ylist[i]) ;
               } 
               
          }}

          double r = 0.2 ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("psFillColor", Black) ; 
          fDisk(0, 0, r, r, FILLED) ;

          
     }
}
