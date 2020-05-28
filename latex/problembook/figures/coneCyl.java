                  /*  File:  coneCyl.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class coneCyl extends Template {

     static {templateClass = new coneCyl() ; }

     public void setup() {
          filePrefix = "coneCyl" ;    // used as the prefix for any ps or lbl files 
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.1*0.7 ;      // in inches
          ysize = 2.0*0.7 ;   // in inches. 
          xmin = -10 ;
          xmax = 100 ;
          ymin = -100 ;
          ymax = 100 ;
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
          fLine(xmin,0, xmax, 0) ;
//          fLine(0, ymin,0, ymax) ;
          fTeXlabel(xmax,-5, "tr", "$r$") ;
          fTeXlabel(-5,ymax, "tr", "$z$") ;

          fLine(-100,-100, 100, 100) ;
               fTeXlabel(105,100, "cl", "$z=r$") ;
          fLine(-100,100, 100, -100) ;
               fTeXlabel(105,-100, "bl", "$z=-r$") ;


//          fEnv("useColorPs", "true") ;
          String Pink = "1 0.3333 0.6666 setrgbcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;

          fEnv("lineWidth", 1.0) ;
          double r = 70 ;
          canvas.append( new fPsWrite(Pink+"\n")) ;
          fLine(0,-100, 0, 100) ;
          fLine(r,-100, r, 100) ;
               fTeXlabel(r-15,-105, "tc", "$\\scriptstyle r=2a\\sin\\theta$") ;

          fEnv("lineWidth", 2.0) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fLine(r,-r, r, r) ;
          fLine(r,-r, 0, 0) ;
          fLine(0,0, r, r) ;



     }
}
