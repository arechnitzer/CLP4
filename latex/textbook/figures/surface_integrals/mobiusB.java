                  /*  File:  mobiusB.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class mobiusB extends Template {

     static {templateClass = new mobiusB() ; }



//// Oblique projection with direction of view (1,-Xy, -Xz). The point 
//// (x,y,z) is projected to (0, yp, zp) = (x,y,z) + a (1,-Xy, -Xz) with a 
//// chosen so that x+a=0. 
//     static double al = 40 ;
//     static double[][] proj = { {Math.cos(Math.PI*(1+al/180)), 1, 0},
//                                {Math.sin(Math.PI*(1+al/180)), 0, 1}   } ;
//     static double[] view = {1, -proj[0][0], -proj[1][0]} ;

//  General orthogonal projection.  
     static double[] fwd = {1, 0.2, 1} ; 
     static double[] up = {0,0,1} ;
     static double Lfwd = Math.sqrt(fwd[0]*fwd[0]+fwd[1]*fwd[1]+fwd[2]*fwd[2]) ; 
     static double[] Nfwd = {fwd[0]/Lfwd,fwd[1]/Lfwd,fwd[2]/Lfwd} ; 

     static double Dot = Nfwd[0]*up[0]+Nfwd[1]*up[1]+Nfwd[2]*up[2] ; 
     static double[] Iup = {up[0]-Dot*Nfwd[0],up[1]-Dot*Nfwd[1],up[2]-Dot*Nfwd[2]};
     static double Lup = Math.sqrt(Iup[0]*Iup[0]+Iup[1]*Iup[1]+Iup[2]*Iup[2]) ; 
     static double[] Nup = {Iup[0]/Lup,Iup[1]/Lup,Iup[2]/Lup} ; 
     static double[] Nleft = {-Nfwd[1]*Nup[2]+Nfwd[2]*Nup[1],
                              -Nfwd[2]*Nup[0]+Nfwd[0]*Nup[2],
                              -Nfwd[0]*Nup[1]+Nfwd[1]*Nup[0]} ; 

     static double[][] proj = { {Nleft[0], Nleft[1], Nleft[2]},
                                { Nup[0],  Nup[1], Nup[2]}   } ;
     static double[] view = {fwd[0], fwd[1], fwd[2]} ;





     public void setup() {
          filePrefix = "mobiusB" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.8 ;    
          ysize = 2.0 ;  

          double Xmin= -10 ;
          double Xmax= 120 ;
          double Ymin= -90 ;
          double Ymax= 100 ;
          double Zmin= -90 ;
          double Zmax= 90 ;
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


          topmargin = 0.0 ;   // in inches
          bottommargin = 0.0 ;   // in inches
          leftmargin = 0.0 ;   // in inches
          rightmargin = 0.0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {

          double r = 20 ;
          double h = 20 ;
          double R = 80 ;
          double offset = 100 ;
          int    nth = 18 ;
          double dth = 360/nth ;
          int    nv = 2 ;
          double dv = h/nv ;

          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Yellow = "0 0 1 0 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          String GGreen = "1 0 1 0.2 setcmykcolor  " ;

          fEnv("lineWidth", 1.5) ;
          canvas.append( new fPsWrite(GGreen+"\n")) ;
          fCurve(new MobiusTh(proj, R, offset, -h),  0,360,OPEN)  ;


          fEnv("lineWidth", 1.5) ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fCurve(new MobiusTh(proj, R, offset, h),  0,360,OPEN)  ;


          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 0.5) ;
          for (int n2 = -nv+1; n2 <= nv ; n2++) {
               fCurve(new MobiusTh(proj, R, offset, n2*dv),  0,360,OPEN)  ;
          }

          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("lineWidth", 1.5) ;
          fCurve(new MobiusTh(proj, R, offset, 0),  0,360,OPEN)  ;


          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("lineWidth", 0.5) ;
          for (int n1 = 0; n1 <= nth ; n1++) {
               fCurve(new MobiusV(proj, R, offset, n1*dth),  -h,h,OPEN)  ;
          }
          fEnv("lineWidth", 1.5) ;
          fCurve(new MobiusV(proj, R, offset, 0),  -h,h,OPEN)  ;
          
          fEnv("psFillColor", Blue) ;
          MobiusV mb = new MobiusV(proj, R, offset, 0) ;
          fArrow(mb.map(-h)[0],mb.map(-h)[1],
                   mb.map(h)[0],mb.map(h)[1] ) ;


          
     }

     public void fLine3d(double xl, double yl, double zl,
                         double xr, double yr, double zr) {
          double X1 = xl*proj[0][0]+yl*proj[0][1]+zl*proj[0][2] ;
          double Y1 = xl*proj[1][0]+yl*proj[1][1]+zl*proj[1][2] ;
          double X2 = xr*proj[0][0]+yr*proj[0][1]+zr*proj[0][2] ;
          double Y2 = xr*proj[1][0]+yr*proj[1][1]+zr*proj[1][2] ;
          fLine(X1,Y1,X2,Y2) ;
     }

     public void fDisk3d(double x, double y, double z,
                         double r1, double r2, long TYPE) {
          double X = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          double Y = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;
          fDisk(X,Y,r1,r2,TYPE) ;
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
          
          double[] out = {0,0} ;
          double x = cx+xa*Math.cos(t*Math.PI/180)+xb*Math.sin(t*Math.PI/180) ;
          double y = cy+ya*Math.cos(t*Math.PI/180)+yb*Math.sin(t*Math.PI/180) ;
          double z = cz+za*Math.cos(t*Math.PI/180)+zb*Math.sin(t*Math.PI/180) ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;

          return out ;
   }
}


class MobiusTh implements S2V {

     double[][] proj = { {1, 0, 0},   { 0,  1, 0}   };
     double R = 50.0 ;
     double v = 1.0 ;
     double offset = 0.0 ;

   public MobiusTh(double[][] proj, 
                  double R, double offset, double  v) {
        this.proj = proj ;
        this.R  = R ;
        this.v  = v ;
        this.offset  = offset ;
   }

     public double[] map(double t) {
          
          double[] out = {0,0} ;
          double th1 = (t+offset)*Math.PI/180 ;
          double th2 = t*Math.PI/180 ;
          double hrx = Math.cos(th1) ; double hry = Math.sin(th1) ;
          double x = R*hrx +v*hrx*Math.cos(th2/2) ;
          double y = R*hry +v*hry*Math.cos(th2/2) ;
          double z = v*Math.sin(th2/2) ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;
          return out ;
   }
}


class MobiusV implements S2V {

     double[][] proj = { {1, 0, 0},   { 0,  1, 0}   };
     double R = 50.0 ;
     double th1 = 0.0 ;
     double th2 = 0.0 ;
     double offset = 0.0 ;

   public MobiusV(double[][] proj, 
                  double R, double offset, double  th) {
        this.proj = proj ;
        this.R  = R ;
        this.offset  = offset ;
        this.th1  = (th+offset)*Math.PI/180 ;
        this.th2  = th*Math.PI/180 ;
   }

     public double[] map(double t) {
          
          double[] out = {0,0} ;
          double hrx = Math.cos(th1) ; double hry = Math.sin(th1) ;
          double x = R*hrx +t*hrx*Math.cos(th2/2) ;
          double y = R*hry +t*hry*Math.cos(th2/2) ;
          double z = t*Math.sin(th2/2) ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;
          return out ;
   }
}



