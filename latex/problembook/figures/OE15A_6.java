                  /*  File:  OE15A_6.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE15A_6 extends Template {

     static {templateClass = new OE15A_6() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;




// Oblique projection with direction of view (1,-Xy, -Xz). The point 
// (x,y,z) is projected to (0, yp, zp) = (x,y,z) + a (1,-Xy, -Xz) with a 
// chosen so that x+a=0. 
     static double al = 60 ;
     // cabinet projection
     static double[][] proj = { {0.5*Math.cos(Math.PI*(1+al/180)), 1, 0},
                                {0.5*Math.sin(Math.PI*(1+al/180)), 0, 1}   } ;
//     // cavalier projection
//     static double[][] proj = { {Math.cos(Math.PI*(1+al/180)), 1, 0},
//                                {Math.sin(Math.PI*(1+al/180)), 0, 1}   } ;
     static double[] view = {1, -proj[0][0], -proj[1][0]} ;




     public void setup() {
          filePrefix = "OE15A_6" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;    
          ysize = 2.0 ;  

          double Xmin= -0.1 ;
          double Xmax= 3.2 ;
          double Ymin= -0.1 ;
          double Ymax= 3.2 ;
          double Zmin= -0.2 ;
          double Zmax= 12.0 ;
          xmin = xmax = Xmin*proj[0][0]+Ymin*proj[0][1]+Zmin*proj[0][2] ;
          ymin = ymax = Xmin*proj[1][0]+Ymin*proj[1][1]+Zmin*proj[1][2] ;
          double Dx = (Xmax-Xmin)*proj[0][0] ;
          double Dy = (Xmax-Xmin)*proj[1][0] ;
          if (Dx>0) xmax += Dx ; else xmin += Dx ;
          if (Dy>0) ymax += Dy ; else ymin += Dy ;
          Dx = (Ymax-Ymin)*proj[0][1] ;
          Dy = (Ymax-Ymin)*proj[1][1] ;
          if (Dx>0) xmax += Dx ; else xmin += Dx ;
          if (Dy>0) ymax += Dy ; else ymin += Dy ;
          Dx = (Zmax-Zmin)*proj[0][2] ;
          Dy = (Zmax-Zmin)*proj[1][2] ;
          if (Dx>0) xmax += Dx ; else xmin += Dx ;
          if (Dy>0) ymax += Dy ; else ymin += Dy ;


//          xmin = -70 ;
//          xmax =  90 ;
//          ymin = -70 ;
//          ymax =  90 ;
          topmargin = 0.0 ;   // in inches
          bottommargin = 0.0 ;   // in inches
          leftmargin = 0.0 ;   // in inches
          rightmargin = 0.0 ;   // in inches
//          useZoom = true ;
//          useDrag = true ;
//          showCoords = true ;
//          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double al = 45 ;
          x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
          x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
//          x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
//          x1 = Math.sin(Math.PI*(1+al/180)) ;
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;

          double Y = 3.0 ;
          double Z = 9.0 ; 
          double YY = 2.5 ;
          double ZZ = 2.5*2.5 ; 
          double r = 0.1 ;

          double xm = 3.2 ;
          double ym = 3.2 ;
          double zm = 10.0 ;
          int nth = 5 ;
          int nphi = 1 ;
          double dth = 90/nth ;
          double dphi = 90/nphi ;

          fEnv("psFillGray", 0.9) ;
          fCurve(new circ3d(proj,   0,0,Z, 0,Y,0, Y,0,0),
                      0,90,FILLED)  ;
          { double[] xlist = {Z*proj[0][2], Y*proj[0][1]+Z*proj[0][2], Y*proj[0][0]+Z*proj[0][2]} ;
            double[] ylist = {Z*proj[1][2], Y*proj[1][1]+Z*proj[1][2], Y*proj[1][0]+Z*proj[1][2]} ;
            fPolygon(xlist, ylist, 3, FILLED) ; }



          fEnv("lineWidth", 0.5) ;
          fLine3d(0,0,Z, 0,0,zm) ;
          fLine3d(0,0,0, 0,ym,0) ;
          fLine3d(0,0,0, xm,0,0) ;
          fTeXlabel3d(0,0,zm+0.1, "cb", "$z$") ;
          fTeXlabel3d(0,ym+0.1,0, "cl", "$y$") ;
          fTeXlabel3d(xm+0.05,-0.05,0, "tr", "$x$") ;
          fTeXlabel3d(0, 0.75*Y,0.5*Z, "cl", "$z=x^2+y^2$") ;
          fTeXlabel3d(0, 0.5*Y,Z+0.3, "cb", "$z=4$") ;

          fLine3d(0,0,Z,  0,Y,Z) ;
          fLine3d(0,0,Z,  Y,0,Z) ;
          fLine3d(0,0,0, xm,0,0) ;

          canvas.append( new fPsWrite("[3 3] 1.5 setdash\n")) ;
//          fLine3d(0,0,ZZ,  0,YY,ZZ) ;
//          fLine3d(0,0,ZZ,  YY,0,ZZ) ;
          fLine3d(0,0,0,   0,0,Z) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;

          fArrow3d(0.5*Y, 0.3*Y, Z,   0.5*Y, 0.3*Y, Z+2) ;
          fTeXlabel3d(0.5*Y, 0.3*Y, Z+2, "br", "$\\hk$") ;
          double y1=0.5*Y ;   double z1 = y1*y1 ;
          double L = 0.5; double y2 = y1-L ;  double z2 = z1+2*L ;
          fArrow3d(0,y1,z1,  0,y2,z2) ;
          fTeXlabel3d(0, y2+0.1, z2+0.1, "bc", "$\\hn$") ;

          fEnv("lineWidth", 2.0) ;
          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fCurve(new revYZ(proj),  0,3,OPEN)  ;
          fCurve(new revXZ(proj),  0,3,OPEN)  ;
          fCurve(new circ3d(proj,   0,0,Z, 0,Y,0, Y,0,0),
                      0,90,OPEN)  ;
//          fTeXlabel3d(0, 0.2*Y,0.6*Z, "cc", "$E$") ;
          fTeXlabel3d(0.9*Y, 0,0.6*Z, "cr", "$S$") ;
          fTeXlabel3d(0.4*Y, 0.5*Y,Z, "cr", "$D$") ;


//          canvas.append( new fPsWrite(Blue+"\n")) ;
//          fEnv("psFillColor", Blue) ;
//          fCurve(new circ3d(proj,   0,0,ZZ, 0,YY,0, YY,0,0),
//                      0,90,OPEN)  ;
     }


     public void fLine3d(double xl, double yl, double zl,
                         double xr, double yr, double zr) {
          double X1 = xl*proj[0][0]+yl*proj[0][1]+zl*proj[0][2] ;
          double Y1 = xl*proj[1][0]+yl*proj[1][1]+zl*proj[1][2] ;
          double X2 = xr*proj[0][0]+yr*proj[0][1]+zr*proj[0][2] ;
          double Y2 = xr*proj[1][0]+yr*proj[1][1]+zr*proj[1][2] ;
          fLine(X1,Y1,X2,Y2) ;
     }


     public void fArrow3d(double xl, double yl, double zl,
                         double xr, double yr, double zr) {
          double X1 = xl*proj[0][0]+yl*proj[0][1]+zl*proj[0][2] ;
          double Y1 = xl*proj[1][0]+yl*proj[1][1]+zl*proj[1][2] ;
          double X2 = xr*proj[0][0]+yr*proj[0][1]+zr*proj[0][2] ;
          double Y2 = xr*proj[1][0]+yr*proj[1][1]+zr*proj[1][2] ;
          fArrow(X1,Y1,X2,Y2) ;
     }


     public void fTeXlabel3d(double xl, double yl, double zl,
                         String biase, String label) {
          double X = xl*proj[0][0]+yl*proj[0][1]+zl*proj[0][2] ;
          double Y = xl*proj[1][0]+yl*proj[1][1]+zl*proj[1][2] ;

          fTeXlabel(X, Y, biase, label) ;
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
          
//          double x0 = projFactor*Math.cos(Math.PI*(1+al/180)) ; 
//          double x1 = projFactor*Math.sin(Math.PI*(1+al/180)) ;
          double[] out = {0,0} ;
          double x = cx+xa*Math.cos(t*Math.PI/180)+xb*Math.sin(t*Math.PI/180) ;
          double y = cy+ya*Math.cos(t*Math.PI/180)+yb*Math.sin(t*Math.PI/180) ;
          double z = cz+za*Math.cos(t*Math.PI/180)+zb*Math.sin(t*Math.PI/180) ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;

//          out[0] = x*x0+y ;
//          out[1] = x*x1+z;
          return out ;
   }
}

class revYZ implements S2V {

     double[][] proj = { {1, 0, 0},   { 0,  1, 0}   };

   public revYZ(double[][] proj) {
        this.proj = proj ;
   }


     public double[] map(double t) {
          
          double[] out = {0,0} ;
          double y = t ;
          double z = t*t ;
          double x = 0 ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;

          return out ;
   }
}


class revXZ implements S2V {

     double[][] proj = { {1, 0, 0},   { 0,  1, 0}   };

   public revXZ(double[][] proj) {
        this.proj = proj ;
   }


     public double[] map(double t) {
          
          double[] out = {0,0} ;
          double x = t ;
          double z = t*t ;
          double y = 0 ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;

          return out ;
   }
}




