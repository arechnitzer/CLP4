                  /*  File:  beadRod.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class beadRod extends Template {

     static {templateClass = new beadRod() ; }

       static  double al = 80 ;

       // cabinet projection
      static double[][] proj = { {0.5*Math.cos(Math.PI*(1+al/180)), 1, 0},
                                {0.5*Math.sin(Math.PI*(1+al/180)), 0, 1}   } ;

       // cavalier projection
//     static double[][] proj = { {Math.cos(Math.PI*(1+al/180)), 1, 0},
//                                {Math.sin(Math.PI*(1+al/180)), 0, 1}   } ;

       // Orthogonal isometric projection with direction of view (1,1,1).  
//     static double[][] proj = { {-Math.sqrt(3)/2.0, Math.sqrt(3)/2.0, 0},
//                                {             -0.5,             -0.5, 1}   } ;


     public void setup() {
          filePrefix = "beadRod" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.0*3.0 ;    
          ysize = 1.0*3.0 ;  
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
          double r1 = 2.5 ;
          double r2 = 3.0 ;
          double r3 = 12.0 ;
          double w1 = 3.0 ;
          double w2 = 4.0 ;
          double phi = Math.PI/4 ; double phiDeg = phi*180/Math.PI ;
          double A = 80 ; double R = 40 ; double L = 30 ;
          double xm = 80 ;
          double ym = 60 ;
          double zm = 130 ;
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;


          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          String Yellow = "0 0 1 0 setcmykcolor  " ;

          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("lineWidth", 0.5) ;
          fLine3d(0,0,0, 0,L,0) ;
          fEllipticalArc(0,0, r3, r3*aspect, 0, phiDeg-5, OPEN) ;
          double x = r3*Math.cos(phi-18*Math.PI/180.0) ;
          double y = r3*aspect*Math.sin(phi-18*Math.PI/180.0) ;
          fEnv("headHalfWidth", 2.0*0.6) ;
          fEnv("headLength", 6.0*0.6) ;
          fArrowhead(x,y, phi+103) ;

          fTeXlabel(r3+2, 2.5, "bl", "$\\Omega t$") ;

          fEnv("psFillColor", Blue) ;
          fEnv("lineWidth", w2) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fCurve(new circ3d(proj,   0,R,R, 0,r2,r2,  0,-r2,r2), 60,300,OPEN)  ;
          fEnv("lineWidth", w1) ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fLine3d(0,0,0, 0,A,A) ;
          fEnv("lineWidth", w2) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fCurve(new circ3d(proj,   0,R,R, 0,r2,r2,  0,-r2,r2), -90,90,OPEN)  ;

          canvas.append( new fPsWrite(Black+"\n")) ;
          fDot3d(0,0,0, r1, r1*aspect, FILLED) ;

     }

     public void fLine3d(double xl, double yl, double zl,
                         double xr, double yr, double zr) {
          double X1 = xl*proj[0][0]+yl*proj[0][1]+zl*proj[0][2] ;
          double Y1 = xl*proj[1][0]+yl*proj[1][1]+zl*proj[1][2] ;
          double X2 = xr*proj[0][0]+yr*proj[0][1]+zr*proj[0][2] ;
          double Y2 = xr*proj[1][0]+yr*proj[1][1]+zr*proj[1][2] ;
          fLine(X1,Y1,X2,Y2) ;
     }


     public void fTeXlabel3d(double xl, double yl, double zl,
                         String biase, String label) {
          double X = xl*proj[0][0]+yl*proj[0][1]+zl*proj[0][2] ;
          double Y = xl*proj[1][0]+yl*proj[1][1]+zl*proj[1][2] ;

          fTeXlabel(X, Y, biase, label) ;
     }

     public void fDot3d(double x, double y, double z,
                         double rx, double ry, long TYPE) {
          double X = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          double Y = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;
          fDisk(X, Y, rx, ry, TYPE) ;     
     }

}


class circ3d implements S2V {

     double[][] proj = { {1, 0, 0},   { 0,  1, 0}   };
     double cx = 0.0 ;
     double cy = 0.0 ;
     double cz = 0.0 ;
     double xa = 100.0 ;
     double ya = 0.0 ;
     double za = 0.0 ;
     double xb = 0.0 ;
     double yb = 100.0 ;
     double zb = 0.0 ;

   public circ3d(double[][] proj, 
                 double cx, double cy, double cz, double r) {
        this.proj = proj ;
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


   public circ3d(double[][] proj, 
                 double cx, double cy, double cz, 
                 double xa, double ya, double za, 
                 double xb, double yb, double zb) {
        this.proj = proj ;
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
          
          double[] out = {0,0} ;
          double x = cx+xa*Math.cos(t*Math.PI/180)+xb*Math.sin(t*Math.PI/180) ;
          double y = cy+ya*Math.cos(t*Math.PI/180)+yb*Math.sin(t*Math.PI/180) ;
          double z = cz+za*Math.cos(t*Math.PI/180)+zb*Math.sin(t*Math.PI/180) ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;

          return out ;
   }
}



