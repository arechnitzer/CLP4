                  /*  File:  cubeDTT.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class cubeDTT extends Template {

     static {templateClass = new cubeDTT() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;

     public void setup() {
          filePrefix = "cubeDTT" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;    
          ysize = 2.0*0.8 ;  
          xmin = -70 ;
          xmax =  110 ;
          ymin = -70 ;
          ymax =  90 ;
          topmargin = 0.2 ;   // in inches
          bottommargin = 0.0 ;   // in inches
          leftmargin = 0.0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double al = 60 ;
          x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
          x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
//          x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
//          x1 = Math.sin(Math.PI*(1+al/180)) ;
          double X1 = 60 ; double Y1 =  0 ; double Z1 = 60 ;
          double X2 = 60 ; double Y2 = 60 ; double Z2 = 60 ;
          double X3 =  0 ; double Y3 = 60 ; double Z3 = 60 ;
          double X4 =  0 ; double Y4 =  0 ; double Z4 = 60 ;
          double XC = (X1+X3)/2 ; double YC = (Y1+Y2)/2 ; double ZC = (Z1+Z2)/2 ;


          fEnv("lineWidth", 0.5) ;
          fEnv("psFillGray", 0.9) ;
          fLine(0,0,xmax,0) ;
          fLine(0,0,0,ymax) ;
          fLine(0,0, xmax*x0, xmax*x1) ;

//          {  double[] xlist = {X1, X2, X3, X4} ;
//             double[] ylist = {Y1, Y2, Y3, Y4} ;
//             double[] zlist = {0,   0,  0, 0} ;
//             fPolygon3d(xlist, ylist, zlist, 4, FILLED) ; }


//          fEnv("useColorPs", "true") ;
          String Pink = "1 0.3333 0.6666 setrgbcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ; ;


          fEnv("lineWidth", 1.5) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fLine3d(X1,Y1,Z1, X2,Y2,Z2) ;
          fLine3d(X2,Y2,Z2, X3,Y3,Z3) ;
          fLine3d(X3,Y3,Z3, X4,Y4,Z4) ;
          fLine3d(X4,Y4,Z4, X1,Y1,Z1) ;
          fLine3d(X1,Y1,0, X1,Y1,Z1) ;
          fLine3d(X2,Y2,0, X2,Y2,Z2) ;
          fLine3d(X3,Y3,0, X3,Y3,Z3) ;
          fLine3d(X4,Y4,0, X4,Y4,Z4) ;
          fLine3d(X1,Y1,0, X2,Y2,0) ;
          fLine3d(X2,Y2,0, X3,Y3,0) ;
          fLine3d(X3,Y3,0, X4,Y4,0) ;
          fLine3d(X4,Y4,0, X1,Y1,0) ;


          fEnv("lineWidth", 0.5) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          double L = 45 ;
          fArrow3d(XC,YC,ZC, XC,YC,ZC+L) ;
          fTeXlabel3d(XC,YC+4,ZC+L,  "lc", "$\\hn=\\hk$") ;
          fArrow3d(XC,YC,0, XC,YC,-L) ;
          fTeXlabel3d(XC,YC+4,-L,  "lc", "$\\hn=-\\hk$") ;
          ZC = 0.5*Z4 ;
          fArrow3d(XC,Y2,ZC, XC,Y2+L,ZC) ;
          fTeXlabel3d(XC,Y2+L+4,ZC,  "lc", "$\\hn=\\hj$") ;
          fArrow3d(XC,0,ZC, XC,-L,ZC) ;
          fTeXlabel3d(XC,-L-4,ZC,  "rc", "$\\hn=-\\hj$") ;


          fTeXlabel3d(X3,Y3+2,Z3,  "cl", "$(0,b,c)$") ;
          fTeXlabel3d(X2,Y2+2,0,  "lt", "$(a,b,0)$") ;
          fTeXlabel3d(0.7*X2,0.75*Y2,Z4,  "cc", "$S_1$") ;
          fTeXlabel3d(0.7*X2,0.75*Y2,0,  "cc", "$S_2$") ;


          fTeXlabel(xmax+5,0, "lc", "$y$") ;
          fTeXlabel(0,ymax+5, "bc", "$z$") ;
          fTeXlabel(xmax*x0-1.5, xmax*x1-1.5, "tr", "$x$") ;
          
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




