$wnd.jsme.runAsyncCallback2('var z4="Any",A4="Aromatic",B4="Nonring",C4="Reset",D4="Ring";function E4(a,b){if(0>b||b>=a.lb.options.length)throw new AD;}function F4(a,b){E4(a,b);return a.lb.options[b].value}function G4(){this.lb=$doc.createElement("<SELECT>");this.lb[Rh]="gwt-ListBox"}x(400,377,Bm,G4);function H4(){H4=y}\nfunction I4(a,b){if(null==b)throw new rA("Missing message: awt.103");var c=-1,d,e,f;f=a.rd.a.lb;e=hx(Wj);e.text=b;e.removeAttribute("bidiwrapped");e.value=b;d=f.options.length;(0>c||c>d)&&(c=d);c==d?f.add(e):(c=f.options[c])?f.add(e,c.index):f.add(e)}function J4(){H4();zG.call(this);new Fp;this.rd=new K4((AG(),this))}x(467,454,{57:1,59:1,66:1,83:1,93:1},J4);_.kf=function(){return FG(this.rd,this)};\n_.zf=function(){return(null==this.od&&(this.od=iG(this)),this.od)+Eb+this.zd+Eb+this.Ad+Eb+this.wd+Ml+this.ld+(this.vd?n:",hidden")+",current="+F4(this.rd.a,this.rd.a.lb.selectedIndex)};function L4(){v0.call(this,7)}x(481,1,Xm,L4);function M4(a){a.rd.eg(a.k);!kG(a)&&U_(a);O_(a)}\nfunction N4(a,b,c){I0.call(this);this.rd&&this.rd.fg(!1);n0(this,!1);OG(this,new v0(0));a=new y0(a,1);Q_(this,a,null);a=new TG;Q_(a,this.j,null);Q_(this,a,null);b&&(this.k=oG(b),m0(this),H0(this.k,~~(bx(b.bd.lb,Qj)/2)-~~(this.wd/2),~~(bx(b.bd.lb,Pj)/2)-~~(this.ld/2)));c&&M_(this,c)}x(663,664,aY,N4);_.Hi=function(){return kY};x(698,590,bn);_.Zd=function(){M4(new N4(this.b,this.a,this.a.H))};x(700,590,bn);_.Zd=function(){this.a.yc?this.a.yc.rd.vf()?this.a.yc.rd.hg():M4(this.a.yc):this.a.yc=new O4(this.a)};\nfunction P4(a,b){J_(b)==a.a?M_(b,(oH(),zH)):M_(b,a.a)}\nfunction Q4(a){var b,c,d,e;e=n;d=!1;J_(R4)!=a.a?(e=wb,d=!0):J_(S4)!=a.a?(e="!#6",d=!0):J_(T4)!=a.a?(M_(U4,(oH(),zH)),M_(V4,zH),M_(W4,zH),M_(X4,zH),e="F,Cl,Br,I"):(b=J_(Y4)!=a.a,c=J_(Z4)!=a.a,J_($4)!=a.a&&(b?e+="c,":c?e+="C,":e+="#6,"),J_(a5)!=a.a&&(b?e+="n,":c?e+="N,":e+="#7,"),J_(b5)!=a.a&&(b?e+="o,":c?e+="O,":e+="#8,"),J_(c5)!=a.a&&(b?e+="s,":c?e+="S,":e+="#16,"),J_(d5)!=a.a&&(b?e+="p,":c?e+="P,":e+="#15,"),J_(U4)!=a.a&&(e+="F,"),J_(V4)!=a.a&&(e+="Cl,"),J_(W4)!=a.a&&(e+="Br,"),J_(X4)!=a.a&&(e+=\n"I,"),Pr(e,Eb)&&(e=Qr(e,0,e.length-1)),1>e.length&&!a.b&&(b?e=$g:c?e=Gd:(M_(R4,(oH(),zH)),e=wb)));b=n;d&&J_(Y4)!=a.a&&(b+=";a");d&&J_(Z4)!=a.a&&(b+=";A");J_(e5)!=a.a&&(b+=";R");J_(f5)!=a.a&&(b+=";!R");J_(R4)!=a.a&&0<b.length?e=Qr(b,1,b.length):e+=b;d=g5.rd.a.lb.selectedIndex;0<d&&(--d,e+=";H"+d);d=h5.rd.a.lb.selectedIndex;0<d&&(--d,e+=";D"+d);J_(i5)!=a.a&&(e=Rl);J_(j5)!=a.a&&(e=kd);J_(k5)!=a.a&&(e=Fd);J_(l5)!=a.a&&(e="!@");HI(a.e,e)}\nfunction m5(a){n5(a);o5(a);var b=g5.rd.a;E4(b,0);b.lb.options[0].selected=!0;b=h5.rd.a;E4(b,0);b.lb.options[0].selected=!0;M_(Y4,a.a);M_(Z4,a.a);M_(e5,a.a);M_(f5,a.a);M_(g5,a.a);M_(h5,a.a);p5(a)}function n5(a){M_($4,a.a);M_(a5,a.a);M_(b5,a.a);M_(c5,a.a);M_(d5,a.a);M_(U4,a.a);M_(V4,a.a);M_(W4,a.a);M_(X4,a.a)}function o5(a){M_(R4,a.a);M_(S4,a.a);M_(T4,a.a)}function p5(a){M_(i5,a.a);M_(j5,a.a);M_(k5,a.a);M_(l5,a.a);a.b=!1}\nfunction O4(a){q0.call(this,"Atom/Bond Query");this.j=new h0(this.Hi());hH(this.s,new J0(this));this.c=a;this.a=a.H;this.d||(a=oG(a),this.d=new A0(a),H0(this.d,-150,10));this.k=this.d;OG(this,new L4);M_(this,this.a);a=new TG;OG(a,new VH(0,3,1));Q_(a,new x0("Atom type :"),null);R4=new h0(z4);S4=new h0("Any except C");T4=new h0("Halogen");Q_(a,R4,null);Q_(a,S4,null);Q_(a,T4,null);Q_(this,a,null);a=new TG;OG(a,new VH(0,3,1));Q_(a,new y0("Or select one or more from the list :",0),null);Q_(this,a,null);\na=new TG;OG(a,new VH(0,3,1));$4=new h0(de);a5=new h0(Hf);b5=new h0(Of);c5=new h0(mg);d5=new h0(Wf);U4=new h0(Ne);V4=new h0(ue);W4=new h0(ce);X4=new h0($e);Q_(a,$4,null);Q_(a,a5,null);Q_(a,b5,null);Q_(a,c5,null);Q_(a,d5,null);Q_(a,U4,null);Q_(a,V4,null);Q_(a,W4,null);Q_(a,X4,null);Q_(this,a,null);a=new TG;OG(a,new VH(0,3,1));g5=new J4;I4(g5,z4);I4(g5,Oc);I4(g5,Tc);I4(g5,$c);I4(g5,bd);Q_(a,new x0("Number of hydrogens :  "),null);Q_(a,g5,null);Q_(this,a,null);a=new TG;OG(a,new VH(0,3,1));h5=new J4;I4(h5,\nz4);I4(h5,Oc);I4(h5,Tc);I4(h5,$c);I4(h5,bd);I4(h5,fd);I4(h5,id);I4(h5,jd);Q_(a,new y0("Number of connections :",0),null);Q_(a,h5,null);Q_(a,new y0(" (H\'s don\'t count.)",0),null);Q_(this,a,null);a=new TG;OG(a,new VH(0,3,1));Q_(a,new x0("Atom is :"),null);Y4=new h0(A4);Q_(a,Y4,null);Z4=new h0("Nonaromatic");Q_(a,Z4,null);e5=new h0(D4);Q_(a,e5,null);f5=new h0(B4);Q_(a,f5,null);Q_(this,a,null);a=new TG;M_(a,GH(J_(this)));OG(a,new VH(0,3,1));Q_(a,new x0("Bond is :"),null);i5=new h0(z4);Q_(a,i5,null);j5=\nnew h0(A4);Q_(a,j5,null);k5=new h0(D4);Q_(a,k5,null);l5=new h0(B4);Q_(a,l5,null);Q_(this,a,null);a=new TG;OG(a,new VH(1,3,1));this.e=new JI(wb,20);Q_(a,this.e,null);Q_(a,new h0(C4),null);Q_(a,this.j,null);Q_(this,a,null);this.rd&&this.rd.fg(!1);n0(this,!1);n5(this);o5(this);p5(this);M_(Y4,this.a);M_(Z4,this.a);M_(e5,this.a);M_(f5,this.a);M_(g5,this.a);M_(h5,this.a);P4(this,R4);m0(this);this.rd.eg(this.k);!kG(this)&&U_(this);O_(this)}x(717,664,aY,O4);\n_.Ii=function(a,b){var c;Q(b,C4)?(m5(this),P4(this,R4),Q4(this)):E(a.f,56)?(p5(this),fB(a.f)===fB(R4)?(n5(this),o5(this)):fB(a.f)===fB(S4)?(n5(this),o5(this)):fB(a.f)===fB(T4)?(n5(this),o5(this)):fB(a.f)===fB(e5)?M_(f5,this.a):fB(a.f)===fB(f5)?(M_(e5,this.a),M_(Y4,this.a)):fB(a.f)===fB(Y4)?(M_(Z4,this.a),M_(f5,this.a)):fB(a.f)===fB(Z4)?M_(Y4,this.a):fB(a.f)===fB(i5)||fB(a.f)===fB(j5)||fB(a.f)===fB(k5)||fB(a.f)===fB(l5)?(m5(this),this.b=!0):o5(this),P4(this,a.f),Q4(this)):E(a.f,57)&&(p5(this),c=a.f,\n0==c.rd.a.lb.selectedIndex?M_(c,this.a):M_(c,(oH(),zH)),Q4(this));107!=this.c.o&&(this.c.o=107,YG(this.c));return!0};_.a=null;_.b=!1;_.c=null;_.d=null;var R4=_.e=null,i5=null,S4=null,Y4=null,j5=null,W4=null,$4=null,h5=null,g5=null,V4=null,U4=null,T4=null,X4=null,a5=null,Z4=null,f5=null,l5=null,b5=null,d5=null,e5=null,k5=null,c5=null;function K4(a){xW();zW.call(this);this.a=new G4;hD(this.a,new q5(this,a),(hZ(),hZ(),iZ))}x(770,768,{},K4);_.dg=function(){return this.a};_.a=null;\nfunction q5(a,b){this.a=a;this.b=b}x(771,1,{},q5);_.fe=function(a){AG();L0(a,this.b,F4(this.a.a,this.a.a.lb.selectedIndex))};_.a=null;_.b=null;x(810,777,{});_.hg=function(){A1(this.c)};Z(663);Z(717);Z(467);Z(770);Z(771);Z(400);U(YX)(2);\n//@ sourceURL=2.js\n');