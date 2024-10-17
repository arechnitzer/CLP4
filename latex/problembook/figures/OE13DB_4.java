                  /*  File:  OE13DB_4.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE13DB_4 extends Template {

     static {templateClass = new OE13DB_4() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;

     public void setup() {
          filePrefix = "OE13DB_4" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;    
          ysize = 2.0*0.5 ;  
          xmin = -1.2 ;
          xmax =  2.5 ;
          ymin = -1.2 ;
          ymax =  1.5 ;
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
          x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
          x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
//          x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
//          x1 = Math.sin(Math.PI*(1+al/180)) ;

          double X1 = 2 ; double Y1 = 0 ; double Z1 = 0 ;
          double X2 = 0 ; double Y2 = 2 ; double Z2 = 0 ;
          double X3 = 0 ; double Y3 = 0 ; double Z3 = 1 ;
          double XC = 0.6 ; double YC = 0.6 ; double ZC = (2-XC-YC)/2 ;


          fEnv("lineWidth", 0.5) ;
          fEnv("psFillGray", 0.9) ;
          fLine(0,0,xmax,0) ;
          fLine(0,0,0,ymax) ;
          fLine(0,0, xmax*x0*1.1, xmax*x1*1.1) ;

          {  double[] xlist = {X1, X2, X3} ;
             double[] ylist = {Y1, Y2, Y3} ;
             double[] zlist = {Z1, Z2, Z3} ;
             fPolygon3d(xlist, ylist, zlist, 3, FILLED) ; }

          canvas.append( new fPsWrite("[3 3] 1.5 setdash\n")) ;
          fLine3d(0,0,0, 2,0,0) ;
          fLine3d(0,0,0, 0,2,0) ;
          fLine3d(0,0,0, 0,0,1) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;


          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;


          fEnv("lineWidth", 1.5) ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          {  double[] xlist = {X1, X2, X3} ;
             double[] ylist = {Y1, Y2, Y3} ;
             double[] zlist = {Z1, Z2, Z3} ;
             fPolygon3d(xlist, ylist, zlist, 3, CLOSED) ; }

          fEnv("headHalfWidth", 2.0*1.4) ;
          fEnv("headLength", 6.0*1.4) ;
          double x = -1 ;
          double y = 1 ;
          double z = 0 ;
          fArrow3d(X1+0.95*x,Y1+0.95*y,Z1+0.95*z, X1+1.05*x,Y1+1.05*y,Z1+1.05*z) ;
          x = 0 ;
          y = -1 ;
          z = 0.5 ;
          fArrow3d(X2+0.95*x,Y2+0.95*y,Z2+0.95*z, X2+1.05*x,Y2+1.05*y,Z2+1.05*z) ;
          x =1 ;
          y = 0 ;
          z = -0.5 ;
          fArrow3d(X3+0.95*x,Y3+0.95*y,Z3+0.95*z, X3+1.05*x,Y3+1.05*y,Z3+1.05*z) ;





          fEnv("lineWidth", 0.5) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("psFillColor", Black) ;
          double L = 0.6 ;
          double LZ = 1.2 ;
          fArrow3d(XC,YC,ZC, XC+L,YC+L,ZC+LZ) ;
          fTeXlabel3d(XC+L*1.05,YC+L*1.05,ZC+LZ*1.05,  "lb", "$\\hn$") ;
          fTeXlabel3d(X1,Y1,Z1-0.05,  "lt", "$(2,0,0)$") ;
          fTeXlabel3d(X2,Y2-0.4,Z2-0.2,  "lt", "$(0,2,0)$") ;
          fTeXlabel3d(X3,Y3-0.05,Z3,  "rb", "$(0,0,1)$") ;


          fTeXlabel(xmax+0.1,0, "lc", "$y$") ;
          fTeXlabel(0,ymax+0.1, "bc", "$z$") ;
          fTeXlabel(xmax*x0*1.1, xmax*x1*1.1, "tr", "$x$") ;
          
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




