                  /*  File:  OE01DQ4.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE01DQ4 extends Template {

     static {templateClass = new OE01DQ4() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;

     public void setup() {
          filePrefix = "OE01DQ4" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 4.0 ;    
          ysize = 4.0 ;  
          xmin = -2 ;
          xmax =  3 ;
          ymin = -2 ;
          ymax =  3 ;
          topmargin = -0.5 ;   // in inches
          bottommargin = -0.5 ;   // in inches
          leftmargin = 0.0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double al = 20 ;
          x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
          x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
//          x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
//          x1 = Math.sin(Math.PI*(1+al/180)) ;
          double a = Math.sqrt(2) ;

          double xm = 2.5 ;
          double ym = 1.8 ;
          double zm = 1.8 ;


          fEnv("lineWidth", 0.3) ;
          fLine3d(0,0,0, 0,0,zm) ;
          fLine3d(0,0,0, 0,ym,0) ;
          fLine3d(0,0,0, xm,0,0) ;
          fTeXlabel3d(0,0,zm+0.1, "cb", "$z$") ;
          fTeXlabel3d(0,ym+0.1,0, "cl", "$y$") ;
          fTeXlabel3d(xm,-0.1,-0.1, "tr", "$x$") ;


          fEnv("lineWidth", 1.0) ;
          canvas.append( new fPsWrite("0.6 setgray\n")) ;
          fCurve(new circ3d(al, 0.5,   0,0,0, 2,0,0, 0,a,0),
                 0,90,OPEN)  ;
          fCurve(new circ3d(al, 0.5,   0,0,0, 2,0,0, 0,0,a),
                 0,90,OPEN)  ;
          fCurve(new circ3d(al, 0.5,   0,0,0, 0,0,a, 0,a,0),
                 0,90,OPEN)  ;
          canvas.append( new fPsWrite("0.0 setgray\n")) ;
          fCurve(new circ3d(al, 0.5,   0,0,0, 2,0,0, 0,1,1),
                 0,90,OPEN)  ;
          fLine3d(0,0,0,  0,1,1) ;
          fLine3d(0,0,0,  2,0,0) ;


          fTeXlabel3d(0, 1.03,1.03, "bl", "$(0,1,1)$") ;
          fTeXlabel3d(2,-0.03,0,  "br", "$(2,0,0)$") ;
          fTeXlabel3d(0,0.6,0.5,  "cl", "$y=z$") ;
          fTeXlabel3d(0, 1.3,0.5, "bl",
                  "$\\tfrac{x^2}{4}+\\tfrac{y^2}{2}+\\tfrac{z^2}{2}=1$") ;



          
     }

     public void fLine3d(double xl, double yl, double zl,
                         double xr, double yr, double zr) {
          double X1 = xl*x0+yl;
          double Y1 = xl*x1+zl;
          double X2 = xr*x0+yr;
          double Y2 = xr*x1+zr;
          fLine(X1,Y1,X2,Y2) ;
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



