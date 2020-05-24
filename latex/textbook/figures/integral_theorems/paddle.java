                  /*  File:  paddle.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class paddle extends Template {

     static {templateClass = new paddle() ; }



// Oblique projection with direction of view (1,-Xy, -Xz). The point 
// (x,y,z) is projected to (0, yp, zp) = (x,y,z) + a (1,-Xy, -Xz) with a 
// chosen so that x+a=0. 
     static double al = 60 ;
     // cabinet projection
//     static double[][] proj = { {0.5*Math.cos(Math.PI*(1+al/180)), 1, 0},
//                                {0.5*Math.sin(Math.PI*(1+al/180)), 0, 1}   } ;
//     // cavalier projection
//     static double[][] proj = { {Math.cos(Math.PI*(1+al/180)), 1, 0},
//                                {Math.sin(Math.PI*(1+al/180)), 0, 1}   } ;
//     static double[] view = {1, -proj[0][0], -proj[1][0]} ;

////  Orthogonal isometric projection with direction of view (1,1,1).  
//     static double[][] proj = { {-Math.sqrt(3)/2.0, Math.sqrt(3)/2.0, 0},
//                                {             -0.5,             -0.5, 1}   } ;
//     static double[] view = {1, 1, 1} ;

////  General orthogonal projection.  
     static double[] fwd = {1, 0.45, 0.3} ; 
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
          filePrefix = "paddle" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.0 ;    
          ysize = 3.0 ;  

          double Xmin= -10 ;
          double Xmax= 90 ;
          double Ymin= -10 ;
          double Ymax= 90 ;
          double Zmin= -10 ;
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
          double a = 65 ;
          double xm = 90 ;
          double ym = 90 ;
          double zm = 90 ;


//          fEnv("lineWidth", 0.4) ;
//          fLine3d(0,0,0, 0,0,zm) ;
//          fLine3d(0,0,0, 0,ym,0) ;
//          fLine3d(0,0,0, xm,0,0) ;
//          fTeXlabel3d(0,0,zm+3, "cb", "$z$") ;
//          fTeXlabel3d(0,ym+3,0, "cl", "$y$") ;
//          fTeXlabel3d(xm,-1,-1, "tr", "$x$") ;

          double cx, cy, cz, h, w, r ;
          cx = 50 ;
          cy = 50 ;
          cz = 50 ;
          r = 30 ;
          h = 5 ;
          w = 15 ;



          double[] X =new double[4] ;
          double[] Y =new double[4] ;
          double dx = w/2 ;
          double dy = w/2 ;
          double dz = h/2 ;

          fEnv("lineWidth", 1.0) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          fArrow3d(cx, cy+r, cz, cx-30, cy+r, cz) ;
          fTeXlabel3d(cx-30, cy+r+1, cz, "bl", "$\\hvt$") ;


          fEnv("lineWidth", 0.5) ;
          fCurve(new circ3d(proj,   cx,cy,cz, r,0,0, 0,r,0), 90,135,OPEN)  ;

          //right
          X[0] = cx*proj[0][0]+(cy+r-dy)*proj[0][1]+(cz-dz)*proj[0][2] ;
          Y[0] = cx*proj[1][0]+(cy+r-dy)*proj[1][1]+(cz-dz)*proj[1][2] ;
          X[1] = cx*proj[0][0]+(cy+r+dy)*proj[0][1]+(cz-dz)*proj[0][2] ;
          Y[1] = cx*proj[1][0]+(cy+r+dy)*proj[1][1]+(cz-dz)*proj[1][2] ;
          X[2] = cx*proj[0][0]+(cy+r+dy)*proj[0][1]+(cz+dz)*proj[0][2] ;
          Y[2] = cx*proj[1][0]+(cy+r+dy)*proj[1][1]+(cz+dz)*proj[1][2] ;
          X[3] = cx*proj[0][0]+(cy+r-dy)*proj[0][1]+(cz+dz)*proj[0][2] ;
          Y[3] = cx*proj[1][0]+(cy+r-dy)*proj[1][1]+(cz+dz)*proj[1][2] ;
          fEnv("psFillGray", 0.7) ;
          fPolygon(X, Y, 4, FILLED) ;

          fCurve(new circ3d(proj,   cx,cy,cz, r,0,0, 0,r,0), 180,270,OPEN)  ;         

          //back
          X[0] = (cx-r-dx)*proj[0][0]+cy*proj[0][1]+(cz-dz)*proj[0][2] ;
          Y[0] = (cx-r-dx)*proj[1][0]+cy*proj[1][1]+(cz-dz)*proj[1][2] ;
          X[1] = (cx-r+dx)*proj[0][0]+cy*proj[0][1]+(cz-dz)*proj[0][2] ;
          Y[1] = (cx-r+dx)*proj[1][0]+cy*proj[1][1]+(cz-dz)*proj[1][2] ;
          X[2] = (cx-r+dx)*proj[0][0]+cy*proj[0][1]+(cz+dz)*proj[0][2] ;
          Y[2] = (cx-r+dx)*proj[1][0]+cy*proj[1][1]+(cz+dz)*proj[1][2] ;
          X[3] = (cx-r-dx)*proj[0][0]+cy*proj[0][1]+(cz+dz)*proj[0][2] ;
          Y[3] = (cx-r-dx)*proj[1][0]+cy*proj[1][1]+(cz+dz)*proj[1][2] ;
          fEnv("psFillGray", 0.7) ;
          fPolygon(X, Y, 4, FILLED) ;

          fCurve(new circ3d(proj,   cx,cy,cz, r,0,0, 0,r,0), 135,180,OPEN)  ;

          //left
          X[0] = cx*proj[0][0]+(cy-r-dy)*proj[0][1]+(cz-dz)*proj[0][2] ;
          Y[0] = cx*proj[1][0]+(cy-r-dy)*proj[1][1]+(cz-dz)*proj[1][2] ;
          X[1] = cx*proj[0][0]+(cy-r+dy)*proj[0][1]+(cz-dz)*proj[0][2] ;
          Y[1] = cx*proj[1][0]+(cy-r+dy)*proj[1][1]+(cz-dz)*proj[1][2] ;
          X[2] = cx*proj[0][0]+(cy-r+dy)*proj[0][1]+(cz+dz)*proj[0][2] ;
          Y[2] = cx*proj[1][0]+(cy-r+dy)*proj[1][1]+(cz+dz)*proj[1][2] ;
          X[3] = cx*proj[0][0]+(cy-r-dy)*proj[0][1]+(cz+dz)*proj[0][2] ;
          Y[3] = cx*proj[1][0]+(cy-r-dy)*proj[1][1]+(cz+dz)*proj[1][2] ;
          fEnv("psFillGray", 0.7) ;
          fPolygon(X, Y, 4, FILLED) ;

          fCurve(new circ3d(proj,   cx,cy,cz, r,0,0, 0,r,0), 270,360,OPEN)  ;


          //front
          X[0] = (cx+r-dx)*proj[0][0]+cy*proj[0][1]+(cz-dz)*proj[0][2] ;
          Y[0] = (cx+r-dx)*proj[1][0]+cy*proj[1][1]+(cz-dz)*proj[1][2] ;
          X[1] = (cx+r+dx)*proj[0][0]+cy*proj[0][1]+(cz-dz)*proj[0][2] ;
          Y[1] = (cx+r+dx)*proj[1][0]+cy*proj[1][1]+(cz-dz)*proj[1][2] ;
          X[2] = (cx+r+dx)*proj[0][0]+cy*proj[0][1]+(cz+dz)*proj[0][2] ;
          Y[2] = (cx+r+dx)*proj[1][0]+cy*proj[1][1]+(cz+dz)*proj[1][2] ;
          X[3] = (cx+r-dx)*proj[0][0]+cy*proj[0][1]+(cz+dz)*proj[0][2] ;
          Y[3] = (cx+r-dx)*proj[1][0]+cy*proj[1][1]+(cz+dz)*proj[1][2] ;
          fEnv("psFillGray", 0.7) ;
          fPolygon(X, Y, 4, FILLED) ;

          fCurve(new circ3d(proj,   cx,cy,cz, r,0,0, 0,r,0), 0,90,OPEN)  ;


          fEnv("lineWidth", 1.0) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          fArrow3d(cx, cy, cz, cx, cy, cz+30) ;
          fLine3d(cx, cy-r+dy, cz, cx, cy+r-dy, cz) ;
          fLine3d(cx-r+dx, cy, cz, cx+r-dx, cy, cz) ;
          fTeXlabel3d(cx,cy+1,cz+30, "bl", "$\\hn$") ;
          fTeXlabel3d(cx,cy+r/2.0,cz+1, "bl", "$\\veps$") ;
          
          double th = 20*Math.PI/180.0 ;
          double dth = 3*Math.PI/180.0 ;
          fArrow3d(cx+r*Math.cos(th), cy+r*Math.sin(th), cz,
                   cx+r*Math.cos(th+dth), cy+r*Math.sin(th+dth), cz) ;
          fTeXlabel3d(cx+r*Math.cos(th), cy+r*Math.sin(th), cz-2, "tc", "$C_\\veps$") ;

          
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
          
          double[] out = {0,0} ;
          double x = cx+xa*Math.cos(t*Math.PI/180)+xb*Math.sin(t*Math.PI/180) ;
          double y = cy+ya*Math.cos(t*Math.PI/180)+yb*Math.sin(t*Math.PI/180) ;
          double z = cz+za*Math.cos(t*Math.PI/180)+zb*Math.sin(t*Math.PI/180) ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;

          return out ;
   }
}



