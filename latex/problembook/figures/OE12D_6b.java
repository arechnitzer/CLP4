                  /*  File:  OE12D_6b.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE12D_6b extends Template {

     static {templateClass = new OE12D_6b() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;

     public void setup() {
          filePrefix = "OE12D_6b" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 6.0*0.3 ;    
          ysize = 8.0*0.3 ;  
          xmin = -2 ;
          xmax =  4 ;
          ymin = -4 ;
          ymax =  4 ;
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
          double al = 70 ;
          double projFactor = 0.5 ;
          x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
          x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
//          x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
//          x1 = Math.sin(Math.PI*(1+al/180)) ;


          double xm = 6 ;
          double ym = 4 ;
          double zm = 4 ;
          fEnv("lineWidth", 0.5) ;
          fEnv("psFillGray", 0.9) ;
          fLine3d(0,0,0, xm,0,0) ;
          fLine3d(0,3,0, 0,ym,0) ;
          fLine3d(0,0,3, 0,0, zm) ;

          fTeXlabel3d(xm,0,0, "tr", "$x$") ;
          fTeXlabel3d(0,ym, -0.1, "tr", "$y$") ;
          fTeXlabel3d(0,-0.1,zm,  "tr", "$z$") ;

          fEnv("psFillGray", 0.9) ;
          fCurve(new circ3d(al, projFactor, 0,0,0, 0,3,0, 0,0,3),
                      0,90,FILLED)  ;
          fCurve(new circ3d(al, projFactor, 5,0,0, 0,3,0, 0,0,3),
                      0,90,FILLED)  ;
          {  double[] xlist = {0, 0, 0} ;
             double[] ylist = {0, 3, 0} ;
             double[] zlist = {0, 0, 3} ;
             fPolygon3d(xlist, ylist, zlist, 3, FILLED) ; }
          {  double[] xlist = {5, 5, 5} ;
             double[] ylist = {0, 3, 0} ;
             double[] zlist = {0, 0, 3} ;
             fPolygon3d(xlist, ylist, zlist, 3, FILLED) ; }
          fEnv("psFillGray", 0.0) ;
          fArrow3d(2.5,3,0,  2.5,4,0) ;
          fTeXlabel3d(2.45,4.1,0, "lc", "$\\hn$") ;
          fTeXlabel3d(2.5,-0.1,3, "rc", "$S$") ;
          fTeXlabel3d(5,1.3,1.3, "cc", "$T$") ;
          fArrow3d(5,1.5,0,  6.7,1.5,0) ;
          fTeXlabel3d(6.3,1.7,0, "lc", "$\\hi$") ;





          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;


          fEnv("lineWidth", 1.5) ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fCurve(new circ3d(al, projFactor, 0,0,0, 0,3,0, 0,0,3),
                      0,90,OPEN)  ;
          fLine3d(0,0,3, 5,0,3) ;
          fLine3d(0,3,0, 5,3,0) ;
          canvas.append( new fPsWrite("[3 3] 1.5 setdash\n")) ;
          fLine3d(0,0,0, 5,0,0) ;
          fLine3d(0,0,0, 0,3,0) ;
          fLine3d(0,0,0, 0,0,3) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;


          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ;
          fCurve(new circ3d(al, projFactor, 5,0,0, 0,3,0, 0,0,3),
                      0,90,OPEN)  ;
          fLine3d(5,0,0, 5,3,0) ;
          fLine3d(5,0,0, 5,0,3) ;

          fEnv("headHalfWidth", 2.0*1.4) ;
          fEnv("headLength", 6.0*1.4) ;


          
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




