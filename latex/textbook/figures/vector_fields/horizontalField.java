                  /*  File:  horizontalField.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class horizontalField extends Template {

     static {templateClass = new horizontalField() ; }

     public void setup() {
          filePrefix = "horizontalField" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2 ;      // in inches
          ysize = 2 ;   // in inches. 
          xmin = -2.5 ;
          xmax = 2.5 ;
          ymin = -2.5 ;
          ymax = 2.5 ;
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
          canvas.append( new fPsWrite(Red+"\n")) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.05, ymax, "tr", "$y$") ;
          canvas.append( new fPsWrite(Black+"\n")) ;

          fTeXlabel((xmax+xmin)/2, ymin-0.1, "tc", "vector field $\\vv =x\\,\\hi$") ;

          double scale = 0.15 ;
          
          double[] xlist = {-2, -1, 1, 2} ;
          double[] ylist = {-2, -1, 0, 1, 2} ;
          int nx = xlist.length ;
          int ny = ylist.length ;


          fEnv("headHalfWidth", 2.0*0.8) ;
          fEnv("headLength", 6.0*0.8) ;
          double dx, dy, len ;
          for (int i=0; i<ny ; i++) {
          for (int j=0; j<nx ; j++) {
               len = xlist[j]*xlist[j]+ylist[i]*ylist[i] ;
               if ( (xlist[j] !=0) || (ylist[i] != 0) ) {
               if ( len < 20 ) {
                    dx = scale*xlist[j] ; 
                    dy = 0 ;
                    fArrow(xlist[j]-dx, ylist[i]-dy, xlist[j]+dx, ylist[i]+dy) ;
               }} 
               
          }}

          double r = 0.07 ;
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          fDisk(0,0.5, r, r*aspect, FILLED) ;

          fEnv("lineWidth", 1.0) ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fLine(0,1.5, xmax, 1.5) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fLine(0,-1.5, xmin, -1.5) ;
          fEnv("useColorPs", "false") ;
          fEnv("psFillGray", 1.0) ;
          fDisk(0,1.5, r, r*aspect, FILLED) ;
          fDisk(0,-1.5, r, r*aspect, FILLED) ;

          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ; 
          fDisk(0,1.5, r, r*aspect, CLOSED) ;
          fArrowhead(1.25, 1.5, 0) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fDisk(0,-1.5, r, r*aspect, CLOSED) ;
          fArrowhead(-1.25, -1.5, 180) ;






          
     }
}
