                  /*  File:  transDiv.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class transDiv extends Template {

     static {templateClass = new transDiv() ; }

     public void setup() {
          filePrefix = "transDiv" ;    
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
          double X = 1.0 ; double Xs = 0.4 ;
          double x1=-3*X ; double x2=-X ; double x3=X ; double x4 = 3*X ;
          double Y = 0.8 ; 
          double y1=-3*Y ; double y2=-Y ; double y3=Y ; double y4 = 3*Y ;
          
          double[] xlist =   {x1-Xs,  x2-Xs,  x3-Xs, x4-Xs} ;
          double[] ylist =   {y1,      y2,      y3,    y4} ;
          double len = 1 ;
          int nx = xlist.length ;
          int ny = ylist.length ;


          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ;
          fEnv("headHalfWidth", 2.0) ;
          fEnv("headLength", 6.0) ;
          for (int i=0; i<nx ; i++) {
          for (int j=0; j<ny ; j++) {
              fArrow(xlist[i], ylist[j], xlist[i]+1, ylist[j]) ;
          }}


          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 2.0) ;
          fDisk(0,0, 2, 2, CLOSED) ;
          
     }
}
