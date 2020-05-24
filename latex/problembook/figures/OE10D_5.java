                  /*  File:  OE10D_5.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE10D_5 extends Template {

     static {templateClass = new OE10D_5() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;

     public void setup() {
          filePrefix = "OE10D_5" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 6.0*0.3 ;    
          ysize = 8.0*0.3 ;  
          xmin = -2 ;
          xmax =  4 ;
          ymin = -1.5 ;
          ymax =  2.5 ;
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
          double al = 30 ;
          double projFactor = 0.5 ;
          x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
          x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
//          x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
//          x1 = Math.sin(Math.PI*(1+al/180)) ;
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;


          double xm = 3 ;
          double ym = 4 ;
          double zm = 2;


          fEnv("lineWidth", 0.5) ;
          fEnv("psFillGray", 0.9) ;
          fLine3d(0,0,0, xm,0,0) ;
          fLine3d(0,0,0, 0,ym,0) ;
          fLine3d(0,0,0, 0,0, zm) ;

          fTeXlabel3d(xm+0.1,0,0, "tr", "$x$") ;
          fTeXlabel3d(0,ym, -0.05, "tr", "$y$") ;
          fTeXlabel3d(0,-0.07,zm,  "tr", "$z$") ;

          fEnv("psFillGray", 0.9) ;
          {  double[] xlist = {2, 2, 4, 4} ;
             double[] ylist = {2, 4, 4, 2} ;
             double[] zlist = {2, 2, 2, 2} ;
             fPolygon3d(xlist, ylist, zlist, 4, FILLED) ; }
          double x = 3 ; double y = 3 ; double zt = 1.7 ;
          fArrow3d(x,y,zt, x,y,1.3) ;
          canvas.append( new fPsWrite("[2 2] 1 setdash\n")) ;
          fLine3d(x,y,2, x,y,zt) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
          fTeXlabel3d(x,y+0.1,1.3,  "cl", "$\\hn$") ;


          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;


          fEnv("lineWidth", 1.5) ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;

          {  double[] xlist = {2, 2, 4, 4} ;
             double[] ylist = {2, 4, 4, 2} ;
             double[] zlist = {2, 2, 2, 2} ;
             fPolygon3d(xlist, ylist, zlist, 4, CLOSED) ; }
          fEnv("headHalfWidth", 2.0*1.5) ;
          fEnv("headLength", 6.0*1.5) ;
          fArrow3d(2,2,2, 2,3.3,2) ;
          fArrow3d(2,4,2, 3.4,4,2) ;
          fArrow3d(4,4,2, 4,2.8,2) ;
          fArrow3d(4,2,2, 2.6,2,2) ;

          double r = 0.1 ;
          fDisk3d(2,2,2, r,r*aspect, FILLED) ;
          fTeXlabel3d(2,2,2.05, "bc", "${\\scriptstyle (2,2,2)}$") ;
          fDisk3d(2,4,2, r,r*aspect, FILLED) ;
          fTeXlabel3d(2,4.05,2.05, "bl", "${\\scriptstyle (2,4,2)}$") ;
          fDisk3d(4,2,2, r,r*aspect, FILLED) ;
          fTeXlabel3d(4,1.75,1.9, "tl", "${\\scriptstyle (4,2,2)}$") ;
          fDisk3d(4,4,2, r,r*aspect, FILLED) ;
          fTeXlabel3d(4,4,1.95, "tl", "${\\scriptstyle (4,4,2)}$") ;
          fTeXlabel3d(3,4.1,2, "tl", "$C$") ;



          
     }

     public void fLine3d(double xl, double yl, double zl,
                         double xr, double yr, double zr) {
          double X1 = xl*x0+yl;
          double Y1 = xl*x1+zl;
          double X2 = xr*x0+yr;
          double Y2 = xr*x1+zr;
          fLine(X1,Y1,X2,Y2) ;
     }

     public void fDisk3d(double x, double y, double z,
                         double r1, double r2, long TYPE) {
          double X = x*x0+y;
          double Y = x*x1+z ;
          fDisk(X,Y,r1,r2,TYPE) ;
     }

     public void fArrow3d(double xl, double yl, double zl,
                         double xr, double yr, double zr) {
          double X1 = xl*x0+yl;
          double Y1 = xl*x1+zl;
          double X2 = xr*x0+yr;
          double Y2 = xr*x1+zr;
          fArrow(X1,Y1,X2,Y2) ;
     }

     public void fTeXlabel3d(double xl, double yl, double zl,
                         String biase, String label) {
          double X = xl*x0+yl;
          double Y = xl*x1+zl;
          fTeXlabel(X, Y, biase, label) ;
     }

     public void fPolygon3d(double[] xlist, double[] ylist, double[] zlist,
                                  int nopoints, long type) {
          double[] xx = new double[nopoints] ;
          double[] yy = new double[nopoints] ;
          for (int i = 0 ; i < nopoints ; i++) {
               xx[i] = xlist[i]*x0+ylist[i] ;
               yy[i] = xlist[i]*x1+zlist[i] ;
          }
          fPolygon(xx,yy,nopoints,type) ;
     }


}

class circ3d implements S2V {

     double al = 45 ;
     double projFactor = 0.5 ;
          // normally 0.5 for cabinet projection
          // normally 1.0 for cavalier projection
     double cx = 0.0 ;
     double cy = 0.0 ;
     double cz = 0.0 ;
     double xa = 100.0 ;
     double ya = 0.0 ;
     double za = 0.0 ;
     double xb = 0.0 ;
     double yb = 100.0 ;
     double zb = 0.0 ;

   public circ3d(double al, double projFactor, 
                 double cx, double cy, double cz, double r) {
        this.al = al ;
        this.cx = cx ;
        this.cy = cy ;
        this.cz = cz ;
        this.xa = r ; ;
        this.ya = 0 ;
        this.za = 0 ;
        this.xb = 0 ;
        this.yb = r ;
        this.zb = 0 ;
   }


   public circ3d(double al, double projFactor, 
                 double cx, double cy, double cz, 
                 double xa, double ya, double za, 
                 double xb, double yb, double zb) {
        this.projFactor = projFactor ;
        this.al = al ;
        this.cx = cx ;
        this.cy = cy ;
        this.cz = cz ;
        this.xa = xa ;
        this.ya = ya ;
        this.za = za ;
        this.xb = xb ;
        this.yb = yb ;
        this.zb = zb ;
   }

     public double[] map(double t) {
          double x0 = projFactor*Math.cos(Math.PI*(1+al/180)) ; 
          double x1 = projFactor*Math.sin(Math.PI*(1+al/180)) ;
          double[] out = {0,0} ;
          double x = cx+xa*Math.cos(t*Math.PI/180)+xb*Math.sin(t*Math.PI/180) ;
          double y = cy+ya*Math.cos(t*Math.PI/180)+yb*Math.sin(t*Math.PI/180) ;
          double z = cz+za*Math.cos(t*Math.PI/180)+zb*Math.sin(t*Math.PI/180) ; ;
          out[0] = x*x0+y ;
          out[1] = x*x1+z;
          return out ;
   }
}




