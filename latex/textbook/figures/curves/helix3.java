                  /*  File:  helix3.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class helix3 extends Template {

     static {templateClass = new helix3() ; }

     public void setup() {
          filePrefix = "helix3" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.0*2.5 ;    
          ysize = 1.0*2.5 ;  
          xmin = -50 ;
          xmax =  100 ;
          ymin = -70 ;
          ymax =  130 ;
          topmargin = 0.0 ;   // in inches
          bottommargin = 0.0 ;   // in inches
          leftmargin = 0.0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double al = 50 ;
          double x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
          double x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
//          double x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
//          double x1 = Math.sin(Math.PI*(1+al/180)) ;
          double a = 65 ;
          double r = 40 ;
          double h = 15 ;
          double z = 100 ;
          double xm = 80 ;
          double ym = 60 ;
          double zm = 130 ;
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;


          fEnv("lineWidth", 1.0) ;
          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fCurve(new circ3d(al, a, 0.5,   0,0,0, r),180,510,OPEN)  ;

          double th = 150*Math.PI/180 ;
          double xx = r*Math.cos(th) ; double yy = r*Math.sin(th) ; double zz = 0;
          double X = xx*x0+yy ;  double Y = xx*x1+zz ;
          double R = 2.0;
          fArrowhead(X,Y, 170) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fArrow(0,0,0,80) ;

          
     }
}


class circ3d implements S2V {

     double al = 45 ;
     double a = 65 ;
     double projFactor = 0.5 ;
          // normally 0.5 for cabinet projection
          // normally 1.0 for cavalier projection
     double cx = 0.0 ;
     double cy = 0.0 ;
     double cz = 0.0 ;
     double r = 50.0 ;

   public circ3d(double al, double a, double projFactor, 
                 double cx, double cy, double cz, double r) {
        this.al = al ;
        this.a = a ;
        this.projFactor = projFactor ;
        this.cx = cx ;
        this.cy = cy ;
        this.cz = cz ;
        this.r  = r ;
   }

     public double[] map(double t) {
          
          double x0 = projFactor*Math.cos(Math.PI*(1+al/180)) ; 
          double x1 = projFactor*Math.sin(Math.PI*(1+al/180)) ;
          double[] out = {0,0} ;
          double x = cx+r*Math.cos(t*Math.PI/180) ;
          double y = cy+r*Math.sin(t*Math.PI/180) ;
          double z = cz ;
          out[0] = x*x0+y ;
          out[1] = x*x1+z;
          return out ;
   }
}





