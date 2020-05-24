                  /*  File:  sourceCurl.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class sourceCurl extends Template {

     static {templateClass = new sourceCurl() ; }

     public void setup() {
          filePrefix = "sourceCurl" ;    
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

          double scale = 1 ;
          double r1 = 0.8 ; double l1 = 0.8 ;
          double r2 = 0.8/Math.sqrt(2) ; double l2 = 0.8 ;
          double r3 = 2.0 ; double l3 = 1.0 ;
          double r4 = 2.0/Math.sqrt(2) ; double l4 = 1.0 ;
          
          double[] xlist =   {-r1,  0,  r1, 0,    r2,  r2, -r2, -r2,  -r3, 0,  r3, 0,    r4,  r4, -r4, -r4} ;
          double[] ylist =   {  0, -r1,  0, r1,   r2, -r2,  r2, -r2,  0, -r3, 0,  r3,   r4, -r4,  r4, -r4};
          double[] lenlist = { l1 , l1, l1, l1,   l2,  l2,  l2,  l2,  l3, l3, l3, l3,   l4,  l4,  l4,  l4} ;
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
                    dx = len*xlist[i] ; 
                    dy = len*ylist[i] ;
                    fArrow(xlist[i], ylist[i], xlist[i]+dx, ylist[i]+dy) ;
          }
          double x = 2.0/Math.sqrt(2) ; double y = 2.0/Math.sqrt(2) ;
          len = 1.2/Math.sqrt(x*x+y*y) ;
          dx = len*x ;  dy = len*y ;


          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 2.0) ;
          fDisk(0,0, 2, 2, CLOSED) ;

          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("psFillColor", Black) ;
          double R1 = 1.6 ; 
          double R2 = 2.4 ;
          double R3 = 0.2 ;
          fEnv("lineWidth", 1.0) ;
          fLine(-R1,0,R1,0) ;
          fLine(0,-R1,0,R1) ;
          fEnv("lineWidth", 4.0) ;
          fLine(-R1,0,-R2,0) ;
          fLine(R1,0,R2,0) ;
          fLine(0,-R1,0,-R2) ;
          fLine(0,R1,0,R2) ;
          fDisk(0,0, R3,R3, FILLED) ;



          
     }
}
