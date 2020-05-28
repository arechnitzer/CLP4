                  /*  File:  shearFieldb.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class shearFieldb extends Template {

     static {templateClass = new shearFieldb() ; }

     public void setup() {
          filePrefix = "shearFieldb" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3 ;      // in inches
          ysize = 3 ;   // in inches. 
          xmin = -5 ;
          xmax = 5 ;
          ymin = -5 ;
          ymax = 5 ;
          topmargin = 0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 0.5) ;
          double xp = 2 ; double yp = 1.6 ; double r = 0.07 ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fDisk(xp,yp, r,r, FILLED) ;
          fTeXlabel(xp+0.15, yp, "cl", "$P$") ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("psFillColor", Black) ;


//          fTeXlabel((xmax+xmin)/2, ymin-0.3, "tc", "vector field $\\vv= y\\,\\hi$") ;

          double scale = 0.18 ;
          
          double[] xlist = {-4, -3, -2, -1, 0, 1, 2, 3, 4} ;
          double[] ylist = {-3.6, -2.8, -2, -1.2, -0.4, 0.4, 1.2, 2, 2.8, 3.6} ;
          int nx = xlist.length ;
          int ny = ylist.length ;


          fEnv("headHalfWidth", 2.0*0.6) ;
          fEnv("headLength", 6.0*0.6) ;
          double dx, dy, len ;
          for (int i=0; i<ny ; i++) {
          for (int j=0; j<nx ; j++) {
                    len = Math.sqrt( Math.abs(ylist[i]) ) ; 
                    dx = scale*len ; 
                    if ( ylist[i] < 0 ) {
                        dx =-dx ;
                    }
                    dy = 0 ;
                    fArrow(xlist[j]-dx, ylist[i]-dy, xlist[j]+dx, ylist[i]+dy) ;
          }}

          fEnv("lineWidth", 1.0) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ;
          fEnv("headHalfWidth", 2.0*1.4) ;
          fEnv("headLength", 6.0*1.4) ;
          double h = 0.6 ;
          {  
             double[] xxlist = {2-h,   2+h  , 2+h  , 2-h} ;
             double[] yylist = {1.6+h, 1.6+h, 1.6-h, 1.6-h} ;
             fPolygon(xxlist, yylist, 4, CLOSED) ; 
             fArrowhead(2-h, 1.6, -90) ; }
             fTeXlabel(xp-h-0.05, yp-h, "tr", "$\\cC$") ;

          
     }
}
