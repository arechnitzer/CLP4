                  /*  File:  OE11A_7aiii.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE11A_7aiii extends Template {

     static {templateClass = new OE11A_7aiii() ; }

     public void setup() {
          filePrefix = "OE11A_7aiii" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2 ;      
          ysize = 2*180/120*1.3 ;  
          xmin = -60 ;
          xmax = 60 ;
          ymin = -90 ;
          ymax = 90 ;
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
          double r = 30 ;
          double h = 25 ;
          double y = h ;
          double x = r*y/h ;
          double a = 80 ;
          double b = h/Math.sqrt(a+1.03*r*1.03*r) ;
          fEnv("lineWidth", 1) ;
          fEnv("psFillGray", 0.8) ;
          fDisk(0,h,x,x/4.5, FILLED) ;
          fCurve(new hyp2(a,-b),-r,r,OPEN)  ;
//          fLine(x,-h, -x,h) ;
//          fLine(-x,-h, x,h) ;
          fEllipticalArc(0,-h, x,x/4.5, 180, 360, OPEN) ;
          canvas.append( new fPsWrite("[3 3] 1.5 setdash\n")) ;
          fEllipticalArc(0,-h, x,x/4.5, 0, 180, OPEN) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;

          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;

          canvas.append( new fPsWrite(Red+"\n")) ;
          fCurve(new hyp2(a,b),-r,r,OPEN)  ;
          fDisk(0,h,x,x/4.5, CLOSED) ;



     }
}

class hyp2 implements S2V {

     double a = 1.0 ;
     double b = 0.0 ;

   public hyp2(double a, double b) {
        this.a = a ;
        this.b = b ;
   }

     public double[] map(double t) {          
          double[] out = {0,0} ;
          out[0] = t ;
          out[1] = b*Math.sqrt(a+t*t);
          return out ;
   }
}

