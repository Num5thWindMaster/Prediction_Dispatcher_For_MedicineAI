$wnd.jsme.runAsyncCallback1('var e4="Assignment of aromatic double bonds failed";function f4(a,b){var c;c=a.x[b];return 3<=c&&4>=c||11<=c&&13>=c||19<=c&&31>=c||37<=c&&51>=c||55<=c&&84>=c||87<=c&&103>=c}function $(a,b){var c,d;c=b;for(d=0;0!=b;)0==a.c&&(a.e=(a.a[++a.d]&63)<<11,a.c=6),d|=(65536&a.e)>>16-c+b,a.e<<=1,--b,--a.c;return d}function g4(a,b,c){a.c=6;a.d=c;a.a=b;a.e=(b[a.d]&63)<<11}function h4(a,b){var c,d;c=~~(b/2);(d=a>=c)&&(a-=c);c=~~(b/32)*a/(c-a);return d?-c:c}function i4(){this.b=!0}x(24,1,{},i4);_.a=null;_.b=!1;\n_.c=0;_.d=0;_.e=0;_.f=null;function j4(a,b){var c,d,e;1==a.b.B[b]&&Gn(a.b,b,2);for(d=0;2>d;++d){c=D(a.b,d,b);Rq(a.b,c,!1);for(e=0;e<a.b.f[c];++e)a.a[In(a.b,c,e)]=!1}}function k4(a){var b,c,d,e,f,g,h;do{h=!1;for(c=0;c<a.b.d;++c)if(a.a[c]){f=!1;for(e=0;2>e;++e){b=!1;d=D(a.b,e,c);for(g=0;g<a.b.f[d];++g)if(c!=In(a.b,d,g)&&a.a[In(a.b,d,g)]){b=!0;break}if(!b){f=!0;break}}f&&(h=!0,j4(a,c))}}while(h)}function l4(){}x(29,1,{},l4);_.a=null;_.b=null;\nfunction m4(a,b,c,d){a.b||(4==a.i||3==a.i&&-1!=a.c?a.b=!0:(a.j[a.i]=d,a.f[a.i]=b,a.k[a.i]=c,++a.i))}\nfunction n4(a,b){var c,d,e,f;if(a.b)return 3;-1!=a.c&&(a.c=b[a.c]);for(e=0;e<a.i;++e)2147483647!=a.f[e]&&(a.f[e]=b[a.f[e]]);if(-1==a.c&&0==a.d){d=2147483647;f=-1;for(e=0;e<a.i;++e)d>a.k[e]&&(d=a.k[e],f=e);a.c=a.f[f];for(e=f+1;e<a.i;++e)a.f[e-1]=a.f[e],a.k[e-1]=a.k[e],a.j[e-1]=a.j[e];--a.i}f=(-1==a.c?0:1)+a.d+a.i;if(4<f||3>f)return 3;c=-1==a.c&&1==a.d||-1!=a.c&&kr(a.n.b,a.c);d=-1;for(e=0;e<a.i;++e)if(a.j[e]){if(-1!=d||c)return 3;d=e}f=!1;if(-1!=d)for(e=0;e<a.i;++e)!a.j[e]&&a.f[d]<a.f[e]&&(f=!f);d=\n!1;if(-1!=a.c&&!c)for(e=0;e<a.i;++e)a.c<a.f[e]&&(d=!d);e=a.f;c=a.k;var g,h,j;h=!1;for(g=1;g<a.i;++g)for(j=0;j<g;++j)e[j]>e[g]&&(h=!h),c[j]>c[g]&&(h=!h);return a.e^h^d^f?2:1}function o4(a,b,c,d,e,f){this.n=a;0!=d&&1!=d?this.b=!0:(this.a=b,this.c=c,this.d=d,this.e=f,this.i=0,this.j=C(Fn,ym,-1,4,2),this.f=C(B,w,-1,4,1),this.k=C(B,w,-1,4,1),-1!=c&&1==d&&(m4(this,2147483647,e,!0),this.d=0))}x(30,1,{},o4);_.a=0;_.b=!1;_.c=0;_.d=0;_.e=!1;_.f=null;_.i=0;_.j=null;_.k=null;_.n=null;\nfunction p4(a){En(a,15);if(a.b){var a=a.b,b;for(b=0;b<a.H.c;++b)if(0==(a.H.s[b]&67108864)&&3==a.S[b]){var c=a.H;c.s[b]|=67108864;c.K&=3}for(b=0;b<a.H.d;++b)3==a.k[b]&&2==Mn(a.H,b)&&Gn(a.H,b,26)}}function q4(){this.e=1}x(33,1,{},q4);\nfunction r4(a){var b,c;if(null==a||0==a.length||0==Jr(a).length)return xM(new XK,n,!0);c=new Xr;var d=new l4,e=eS(Jr(a)),f,g,h,j,l,m,q,r,t,A,v,s,F,G,H,u,ba,aa,M,da,sb,tb,Oa,Ya,S,oa,pa,fa,Fa,Ka,Ca,Tb,R,ta,qb,Lb,Za;d.b=c;Aq(d.b);Oa=null;j=C(B,w,-1,64,1);j[0]=-1;oa=C(B,w,-1,64,1);pa=C(B,w,-1,64,1);for(F=0;64>F;++F)oa[F]=-1;g=S=0;fa=Ya=Ka=!1;m=0;Fa=e.length;for(l=1;32>=e[S];)++S;for(;S<Fa;)if(Ca=e[S++]&65535,s4(Ca)||42==Ca){h=0;v=-1;G=tb=H=!1;if(Ka)82==Ca&&jK(e[S]&65535)?(aa=null!=String.fromCharCode(e[S+\n1]&65535).match(/\\d/)?2:1,h=cr(Bq(e,S-1,1+aa)),S+=aa):(u=String.fromCharCode(e[S]&65535).toLowerCase().charCodeAt(0)==(e[S]&65535)&&s4(e[S]&65535)?2:1,h=cr(Bq(e,S-1,u)),S+=u-1,v=0),64==e[S]&&(++S,64==e[S]&&(G=!0,++S),tb=!0),72==e[S]&&(++S,v=1,jK(e[S]&65535)&&(v=e[S]-48,++S));else if(42==Ca)h=6,H=!0;else switch(String.fromCharCode(Ca).toUpperCase().charCodeAt(0)){case 66:S<Fa&&114==e[S]?(h=35,++S):h=5;break;case 67:S<Fa&&108==e[S]?(h=17,++S):h=6;break;case 70:h=9;break;case 73:h=53;break;case 78:h=\n7;break;case 79:h=8;break;case 80:h=15;break;case 83:h=16}if(0==h)throw new Ho("SmilesParser: unknown element label found");f=vq(d.b,h);H?(fa=!0,Uq(d.b,f,1)):Rq(d.b,f,String.fromCharCode(Ca).toLowerCase().charCodeAt(0)==Ca&&s4(Ca));if(-1!=v&&1!=h){q=C(hp,Tm,-1,1,1);q[0]=v<<24>>24;var Va=d.b,Ub=f,$b=q;null!=$b&&0==$b.length&&($b=null);null==$b?null!=Va.r&&(Va.r[Ub]=null):(null==Va.r&&(Va.r=C(tq,o,3,Va.G,0)),Va.r[Ub]=$b)}s=j[m];-1!=j[m]&&128!=l&&zq(d.b,f,j[m],l);l=1;j[m]=f;0!=g&&(Sq(d.b,f,g),g=0);(da=\n!Oa?null:zr(Oa,uN(s)))&&m4(da,f,S,1==h);tb&&(!Oa&&(Oa=new Rr),Sr(Oa,uN(f),new o4(d,f,s,v,S,G)))}else if(46==Ca)l=128;else if(61==Ca)l=2;else if(35==Ca)l=4;else if(jK(Ca))if(M=Ca-48,Ka){for(;S<Fa&&jK(e[S]&65535);)M=10*M+e[S]-48,++S;g=M}else{Ya&&S<Fa&&jK(e[S]&65535)&&(M=10*M+e[S]-48,++S);Ya=!1;if(64<=M)throw new Ho("SmilesParser: ringClosureAtom number out of range");if(-1==oa[M])oa[M]=j[m],pa[M]=S-1;else{if(oa[M]==j[m])throw new Ho("SmilesParser: ring closure to same atom");Oa&&((da=zr(Oa,uN(oa[M])))&&\nm4(da,j[m],pa[M],!1),(da=zr(Oa,uN(j[m])))&&m4(da,oa[M],S-1,!1));zq(d.b,j[m],oa[M],l);oa[M]=-1}l=1}else if(43==Ca){if(!Ka)throw new Ho("SmilesParser: \'+\' found outside brackets");for(r=1;43==e[S];)++r,++S;1==r&&jK(e[S]&65535)&&(r=e[S]-48,++S);Lq(d.b,j[m],r)}else if(45==Ca){if(Ka){for(r=-1;45==e[S];)--r,++S;-1==r&&jK(e[S]&65535)&&(r=48-e[S],++S);Lq(d.b,j[m],r)}}else if(40==Ca){if(-1==j[m])throw new Ho("Smiles with leading parenthesis are not supported");j[m+1]=j[m];++m}else if(41==Ca)--m;else if(91==\nCa){if(Ka)throw new Ho("SmilesParser: nested square brackets found");Ka=!0}else if(93==Ca){if(!Ka)throw new Ho("SmilesParser: closing bracket without opening one");Ka=!1}else if(37==Ca)Ya=!0;else if(58==Ca)if(Ka){for(ba=0;jK(e[S]&65535);)ba=10*ba+e[S]-48,++S;d.b.u[j[m]]=ba}else l=64;else if(47==Ca)l=17;else if(92==Ca)l=9;else throw new Ho("SmilesParser: unexpected character found: \'"+String.fromCharCode(Ca)+jb);if(1!=l)throw new Ho("SmilesParser: dangling open bond");for(F=0;64>F;++F)if(-1!=oa[F])throw new Ho("SmilesParser: dangling ring closure");\nvar ea=d.b,qa,ca,Ib,ka,Ab,X;X=C(B,w,-1,ea.o,1);ka=C(Fn,ym,-1,ea.o,2);for(ca=0;ca<ea.p;++ca)for(Ib=0;2>Ib;++Ib)kr(ea,ea.y[Ib][ca])&&!kr(ea,ea.y[1-Ib][ca])&&(ka[ea.y[Ib][ca]]=!0);for(Ab=ea.o-1;0<=Ab&&ka[Ab];)X[Ab]=Ab,--Ab;for(qa=0;qa<=Ab;++qa)if(ka[qa]){X[qa]=Ab;X[Ab]=qa;for(--Ab;0<=Ab&&ka[Ab];)X[Ab]=Ab,--Ab}else X[qa]=qa;d.b.J=!0;En(d.b,1);for(f=0;f<d.b.o;++f)if(null!=(null==c.r?null:null==c.r[f]?null:Bq(c.r[f],0,c.r[f].length))&&!Iq(d.b,f))if(A=(null==d.b.r?null:d.b.r[f])[0],d.b.x[f]<(Do(),sq).length&&\nnull!=sq[d.b.x[f]]){t=!1;Tb=op(d.b,f);Tb-=qp(d.b,f,Tb);for(ta=sq[d.b.x[f]],qb=0,Lb=ta.length;qb<Lb;++qb)if(R=ta[qb],Tb<=R){t=!0;R!=Tb+A&&Kq(d.b,f,Tb+A);break}t||Kq(d.b,f,Tb+A)}var N,ic,ac,fd;for(N=0;N<d.b.c;++N)if(7==d.b.x[N]&&0==d.b.q[N]&&3<op(d.b,N)&&0<d.b.k[N])for(fd=0;fd<d.b.f[N];++fd)if(ic=Jn(d.b,N,fd),ac=In(d.b,N,fd),1<Mn(d.b,ac)&&er(d.b.x[ic])){4==d.b.B[ac]?Gn(d.b,ac,2):Gn(d.b,ac,1);Lq(d.b,N,d.b.q[N]+1);Lq(d.b,ic,d.b.q[ic]-1);break}var Mb,Xa,ga,Vb,Ia,T,za,Bb,Vc,gc,Pc,oc,cb,Kc,xb,Pa;En(d.b,\n1);d.a=C(Fn,ym,-1,d.b.d,2);for(ga=0;ga<d.b.d;++ga)64==d.b.B[ga]&&(Gn(d.b,ga,1),d.a[ga]=!0);Pa=new Hn(d.b,3);Bb=C(Fn,ym,-1,Pa.i.c,2);for(cb=0;cb<Pa.i.c;++cb){Kc=Pn(Pa.i,cb);Bb[cb]=!0;for(za=0;za<Kc.length;++za)if(!Iq(d.b,Kc[za])){Bb[cb]=!1;break}if(Bb[cb]){xb=Pn(Pa.j,cb);for(za=0;za<xb.length;++za)d.a[xb[za]]=!0}}for(ga=0;ga<d.b.d;++ga)if(!d.a[ga]&&0!=Pa.b[ga]&&Iq(d.b,D(d.b,0,ga))&&Iq(d.b,D(d.b,1,ga)))a:{var tc=d,kb=ga,pc=void 0,L=void 0,Jb=void 0,Qc=void 0,Wc=void 0,Wb=void 0,bc=void 0,Nb=void 0,\nLc=void 0,ld=void 0,Mc=void 0,la=void 0,Xc=void 0,Nb=C(B,w,-1,tc.b.c,1),Wb=C(B,w,-1,tc.b.c,1),bc=C(B,w,-1,tc.b.c,1),Lc=C(B,w,-1,tc.b.c,1),pc=D(tc.b,0,kb),L=D(tc.b,1,kb);Wb[0]=pc;Wb[1]=L;bc[0]=-1;bc[1]=kb;Nb[pc]=1;Nb[L]=2;Lc[pc]=-1;Lc[L]=pc;for(ld=Wc=1;Wc<=ld&&15>Nb[Wb[Wc]];){Xc=Wb[Wc];for(Mc=0;Mc<tc.b.f[Xc];++Mc)if(Jb=Jn(tc.b,Xc,Mc),Jb!=Lc[Xc]){Qc=In(tc.b,Xc,Mc);if(Jb==pc){bc[0]=Qc;for(la=0;la<=ld;++la)tc.a[bc[Mc]]=!0;break a}Iq(tc.b,Jb)&&0==Nb[Jb]&&(++ld,Wb[ld]=Jb,bc[ld]=Qc,Nb[Jb]=Nb[Xc]+1,Lc[Jb]=\nXc)}++Wc}}En(d.b,3);for(cb=0;cb<Pa.i.c;++cb)if(Bb[cb]){Kc=Pn(Pa.i,cb);for(za=0;za<Kc.length;++za){var qe;var qc=d,wa=Kc[za],Ge=void 0;16==qc.b.x[wa]&&0>=qc.b.q[wa]||6==qc.b.x[wa]&&0!=qc.b.q[wa]||!Iq(qc.b,wa)?qe=!1:(Ge=null==wp(qc.b,wa)?0:(null==qc.b.r?null:qc.b.r[wa])[0],qe=1>Gq(qc.b,wa)-op(qc.b,wa)-Ge||5!=qc.b.x[wa]&&6!=qc.b.x[wa]&&7!=qc.b.x[wa]&&8!=qc.b.x[wa]&&15!=qc.b.x[wa]&&16!=qc.b.x[wa]&&33!=qc.b.x[wa]&&34!=qc.b.x[wa]?!1:!0);if(!qe){Rq(d.b,Kc[za],!1);for(gc=0;gc<d.b.f[Kc[za]];++gc)d.a[In(d.b,\nKc[za],gc)]=!1}}}k4(d);for(cb=0;cb<Pa.i.c;++cb)if(Bb[cb]&&6==Pn(Pa.j,cb).length){xb=Pn(Pa.j,cb);Vc=!0;for(Vb=0,Ia=xb.length;Vb<Ia;++Vb)if(ga=xb[Vb],!d.a[ga]){Vc=!1;break}Vc&&(j4(d,xb[0]),j4(d,xb[2]),j4(d,xb[4]),k4(d))}for(oc=5;4<=oc;--oc){do{Pc=!1;for(ga=0;ga<d.b.d;++ga)if(d.a[ga]){for(za=Mb=0;2>za;++za){T=D(d.b,za,ga);for(gc=0;gc<d.b.f[T];++gc)d.a[In(d.b,T,gc)]&&++Mb}if(Mb==oc){j4(d,ga);k4(d);Pc=!0;break}}}while(Pc)}for(ga=0;ga<d.b.d;++ga)if(d.a[ga])throw new Ho(e4);for(Xa=0;Xa<d.b.c;++Xa)if(Iq(d.b,\nXa))throw new Ho(e4);d.b.r=null;d.b.J=!1;var gb,lb,jc,Ob,Nc,bd,Yc,Ed,Ja,cc,uc;En(d.b,3);Ja=!1;cc=C(B,w,-1,2,1);uc=C(B,w,-1,2,1);Ed=C(B,w,-1,2,1);for(lb=0;lb<d.b.d;++lb)if(!so(d.b,lb)&&2==d.b.B[lb]){for(Ob=0;2>Ob;++Ob){cc[Ob]=-1;Ed[Ob]=-1;gb=D(d.b,Ob,lb);for(Yc=0;Yc<d.b.f[gb];++Yc)jc=In(d.b,gb,Yc),jc!=lb&&(17==d.b.B[jc]||9==d.b.B[jc]?(cc[Ob]=Jn(d.b,gb,Yc),uc[Ob]=jc):Ed[Ob]=Jn(d.b,gb,Yc));if(-1==cc[Ob])break}if(-1!=cc[0]&&-1!=cc[1]){bd=d.b.B[uc[0]]!=d.b.B[uc[1]];Nc=!1;for(Ob=0;2>Ob;++Ob)-1!=Ed[Ob]&&\nEd[Ob]<cc[Ob]&&(Nc=!Nc);Zq(d.b,lb,bd^Nc?2:1,!1);Ja=!0}}for(lb=0;lb<d.b.d;++lb)(17==d.b.B[lb]||9==d.b.B[lb])&&Gn(d.b,lb,1);Ja&&(d.b.K|=4);rs(new q4,d.b);if(Oa){for(sb=t4((Za=new fT(Oa),new u4(Oa,Za)));zS(sb.a.a);)da=(sb.a.b=Pp(sb.a.a)).wi(),Tq(d.b,da.a,n4(da,X),!1);d.b.K|=4}lr(d.b);p4(d.b);fa&&ar(d.b,!0);b=new tr(c);return ax(b.a.a)}function s4(a){return null!=String.fromCharCode(a).match(/[A-Z]/i)}function t4(a){a=new iT(a.b.a);return new v4(a)}function u4(a,b){this.a=a;this.b=b}x(630,618,{},u4);\n_.ti=function(a){a:{var b,c;for(c=new iT((new fT(this.a)).a);zS(c.a);)if(b=c.b=Pp(c.a),b=b.wi(),null==a?null==b:Tv(a,b)){a=!0;break a}a=!1}return a};_.Ue=function(){return t4(this)};_.ng=function(){return this.b.a.c};_.a=null;_.b=null;function v4(a){this.a=a}x(631,1,{},v4);_.te=function(){return zS(this.a.a)};_.ue=function(){return(this.a.b=Pp(this.a.a)).wi()};_.ve=function(){hT(this.a)};_.a=null;function w4(){NS();this.a=6122;this.b=12230397}x(647,1,{},w4);x(697,590,bn);\n_.Zd=function(){var a,b,c,d,e;a=b=d=null;if(this.b.a==(EN(),FN)&&this.b.i==(GN(),HN))try{var f=this.b.b,g,h,j;j=null;h=new Xr;Er(new Ur,h,new sJ(new xJ(f)))&&(g=new tr(h),j=ax(g.a.a));b=j;if(null==b)throw new Ho("V3000 read failed.");a=yk;this.a.Gc.a="V3000 conversion provided by OpenChemLib"}catch(l){if(l=uo(l),E(l,101))c=l,d=c.Xd();else throw l;}else if(this.b.a==$T)try{var m=this.b.b,q,r,t,A,v,s,F;b=-1!=m.indexOf(zd)?(q=cS(m,zd),r=3<=q.length&&0<q[2].length,t=2<=q.length&&0<q[1].length,A=r4(q[0]),\nv=r?r4(q[2]):r4(n),s=t?r4(q[1]):r4(n),F=n,F+=ab,F+=vO(1,3)+vO(1,3),t&&(F+=vO(1,3)),F+=ia,F+=Ua+A,F+=Ua+v,t&&(F+=Ua+s),F):r4(m);this.b.f==(BN(),KN)?a="readSMIRKS":this.b.f==XT&&(a="readSMILES");this.a.Gc.a="SMILES conversion provided by OpenChemLib"}catch(G){if(G=uo(G),E(G,101))c=G,d="SMILES parsing error:"+c.Xd();else throw G;}else if(d="Invalid or unsupported input",this.a.Yc&&!this.b.d)try{var H,u=new i4,ba=Jr(this.b.b),aa;if(null==ba||0==ba.length)aa=null;else{var M=eS(ba),da,sb,tb,Oa,Ya;if(null==\nM)aa=null;else{g4(u,M,0);da=$(u,4);Oa=$(u,4);8<da&&(da=Oa);sb=$(u,da);tb=$(u,Oa);Ya=new Lr(sb,tb);var S=null,oa,pa,fa,Fa,Ka,Ca,Tb,R,ta,qb,Lb,Za,Va,Ub,$b,ea,qa,ca,Ib,ka,Ab,X,N,ic,ac,fd,Mb,Xa,ga,Vb,Ia,T,za,Bb,Vc,gc,Pc,oc,cb,Kc,xb,Pa,tc,kb,pc,L,Jb,Qc,Wc,Wb,bc,Nb,Lc,ld,Mc,la,Xc,qe,qc,wa,Ge,gb,lb,jc,Ob,Nc,bd,Yc,Ed,Ja,cc,uc;Nc=8;u.f=Ya;Aq(u.f);if(!(null==M||0==M.length))if(null!=S&&0==S.length&&(S=null),g4(u,M,0),fa=$(u,4),ea=$(u,4),8<fa&&(Nc=fa,fa=ea),0==fa)ar(u.f,1==$(u,1));else{Fa=$(u,fa);Ka=$(u,ea);\nMc=$(u,fa);qc=$(u,fa);qe=$(u,fa);ac=$(u,fa);for(R=0;R<Fa;++R)vq(u.f,6);for(L=0;L<Mc;++L)yq(u.f,$(u,fa),7);for(L=0;L<qc;++L)yq(u.f,$(u,fa),8);for(L=0;L<qe;++L)yq(u.f,$(u,fa),$(u,8));for(L=0;L<ac;++L)Lq(u.f,$(u,fa),$(u,4)-8);fd=1+Ka-Fa;za=$(u,4);$b=0;Vq(u.f,0,0);Wq(u.f,0,0);Xq(u.f,0,0);Bb=null!=S&&39<=S[0];uc=Ja=Yc=Ob=0;Vb=ga=!1;Bb&&(S.length>2*Fa-2&&39==S[2*Fa-2]||S.length>3*Fa-3&&39==S[3*Fa-3]?(Vb=!0,Jb=(ga=S.length==3*Fa-3+9)?3*Fa-3:2*Fa-2,Ub=86*(S[Jb+1]-40)+S[Jb+2]-40,Ob=Math.pow(10,Ub/2E3-1),Jb+=\n2,bd=86*(S[Jb+1]-40)+S[Jb+2]-40,Yc=Math.pow(10,bd/1500-1),Jb+=2,Ed=86*(S[Jb+1]-40)+S[Jb+2]-40,Ja=Math.pow(10,Ed/1500-1),ga&&(Jb+=2,cc=86*(S[Jb+1]-40)+S[Jb+2]-40,uc=Math.pow(10,cc/1500-1))):ga=S.length==3*Fa-3);u.b&&ga&&(S=null,Bb=!1);for(L=1;L<Fa;++L)Vc=$(u,za),0==Vc?(Bb&&(Vq(u.f,L,u.f.D[0].a+8*(S[2*L-2]-83)),Wq(u.f,L,u.f.D[0].b+8*(S[2*L-1]-83)),ga&&Xq(u.f,L,u.f.D[0].c+8*(S[2*Fa-3+L]-83))),++fd):($b+=Vc-1,Bb&&(Vq(u.f,L,ao(u.f,$b)+S[2*L-2]-83),Wq(u.f,L,bo(u.f,$b)+S[2*L-1]-83),ga&&Xq(u.f,L,co(u.f,$b)+\n(S[2*Fa-3+L]-83))),zq(u.f,$b,L,1));for(L=0;L<fd;++L)zq(u.f,$(u,fa),$(u,fa),1);Wc=C(Fn,ym,-1,Ka,2);for(ca=0;ca<Ka;++ca)switch(Ab=$(u,2),Ab){case 0:f4(u.f,D(u.f,0,ca))||f4(u.f,D(u.f,1,ca))?Gn(u.f,ca,32):Wc[ca]=!0;break;case 2:Gn(u.f,ca,2);break;case 3:Gn(u.f,ca,4)}pa=$(u,fa);for(L=0;L<pa;++L)if(R=$(u,fa),8==Nc)wa=$(u,2),3==wa?(Nq(u.f,R,1,0),Tq(u.f,R,1,!1)):Tq(u.f,R,wa,!1);else switch(wa=$(u,3),wa){case 4:Tq(u.f,R,1,!1);Nq(u.f,R,1,$(u,3));break;case 5:Tq(u.f,R,2,!1);Nq(u.f,R,1,$(u,3));break;case 6:Tq(u.f,\nR,1,!1);Nq(u.f,R,2,$(u,3));break;case 7:Tq(u.f,R,2,!1);Nq(u.f,R,2,$(u,3));break;default:Tq(u.f,R,wa,!1)}8==Nc&&0==$(u,1)&&(u.f.F=!0);oa=$(u,ea);for(L=0;L<oa;++L)if(ca=$(u,ea),1==u.f.B[ca])switch(wa=$(u,3),wa){case 4:Zq(u.f,ca,1,!1);Yq(u.f,ca,1,$(u,3));break;case 5:Zq(u.f,ca,2,!1);Yq(u.f,ca,1,$(u,3));break;case 6:Zq(u.f,ca,1,!1);Yq(u.f,ca,2,$(u,3));break;case 7:Zq(u.f,ca,2,!1);Yq(u.f,ca,2,$(u,3));break;default:Zq(u.f,ca,wa,!1)}else Zq(u.f,ca,$(u,2),!1);ar(u.f,1==$(u,1));Tb=null;for(Xc=0;1==$(u,1);)switch(T=\nXc+$(u,4),T){case 0:la=$(u,fa);for(L=0;L<la;++L)R=$(u,fa),Uq(u.f,R,2048);break;case 1:la=$(u,fa);for(L=0;L<la;++L)R=$(u,fa),Lc=$(u,8),Sq(u.f,R,Lc);break;case 2:la=$(u,ea);for(L=0;L<la;++L)ca=$(u,ea),Gn(u.f,ca,64);break;case 3:la=$(u,fa);for(L=0;L<la;++L)R=$(u,fa),Uq(u.f,R,4096);break;case 4:la=$(u,fa);for(L=0;L<la;++L)R=$(u,fa),jc=$(u,4)<<3,Uq(u.f,R,jc);break;case 5:la=$(u,fa);for(L=0;L<la;++L)R=$(u,fa),Ca=$(u,2)<<1,Uq(u.f,R,Ca);break;case 6:la=$(u,fa);for(L=0;L<la;++L)R=$(u,fa),Uq(u.f,R,1);break;\ncase 7:la=$(u,fa);for(L=0;L<la;++L)R=$(u,fa),kb=$(u,4)<<7,Uq(u.f,R,kb);break;case 8:la=$(u,fa);for(L=0;L<la;++L){R=$(u,fa);Lb=$(u,4);ta=C(B,w,-1,Lb,1);for(Wb=0;Wb<Lb;++Wb)qb=$(u,8),ta[Wb]=qb;var td=u.f,mb=R,kc=ta;null==td.t&&(td.t=C(io,Jm,91,td.G,0));null!=kc&&Ro(kc);td.t[mb]=kc;td.K=0;td.E=!0}break;case 9:la=$(u,ea);for(L=0;L<la;++L)ca=$(u,ea),jc=$(u,2)<<4,$q(u.f,ca,jc);break;case 10:la=$(u,ea);for(L=0;L<la;++L)ca=$(u,ea),X=$(u,4),$q(u.f,ca,X);break;case 11:la=$(u,fa);for(L=0;L<la;++L)R=$(u,fa),\nUq(u.f,R,8192);break;case 12:la=$(u,ea);for(L=0;L<la;++L)ca=$(u,ea),N=$(u,8)<<6,$q(u.f,ca,N);break;case 13:la=$(u,fa);for(L=0;L<la;++L)R=$(u,fa),Ge=$(u,3)<<14,Uq(u.f,R,Ge);break;case 14:la=$(u,fa);for(L=0;L<la;++L)R=$(u,fa),ld=$(u,5)<<17,Uq(u.f,R,ld);break;case 15:Xc=16;break;case 16:la=$(u,fa);for(L=0;L<la;++L)R=$(u,fa),lb=$(u,3)<<22,Uq(u.f,R,lb);break;case 17:la=$(u,fa);for(L=0;L<la;++L)R=$(u,fa),Kq(u.f,R,$(u,4));break;case 18:la=$(u,fa);Nb=$(u,4);for(L=0;L<la;++L){R=$(u,fa);Ia=$(u,Nb);bc=C(hp,\nTm,-1,Ia,1);for(Wb=0;Wb<Ia;++Wb)bc[Wb]=$(u,7)<<24>>24;var md=u.f,ud=R,Cb=Bq(bc,0,bc.length),Ac=void 0;if(null!=Cb)if(0==Cb.length)Cb=null;else if(Ac=cr(Cb),0!=Ac&&Q(Cb,pq[Ac])||Q(Cb,Cd))yq(md,ud,Ac),Cb=null;null==Cb?null!=md.r&&(md.r[ud]=null):(null==md.r&&(md.r=C(tq,o,3,md.G,0)),md.r[ud]=eS(Cb))}break;case 19:la=$(u,fa);for(L=0;L<la;++L)R=$(u,fa),ic=$(u,3)<<25,Uq(u.f,R,ic);break;case 20:la=$(u,ea);for(L=0;L<la;++L)ca=$(u,ea),lb=$(u,3)<<14,$q(u.f,ca,lb);break;case 21:la=$(u,fa);for(L=0;L<la;++L)R=\n$(u,fa),Pq(u.f,R,$(u,2)<<4);break;case 22:la=$(u,fa);for(L=0;L<la;++L)R=$(u,fa),Uq(u.f,R,268435456);break;case 23:la=$(u,ea);for(L=0;L<la;++L)ca=$(u,ea),$q(u.f,ca,131072);break;case 24:la=$(u,ea);for(L=0;L<la;++L)ca=$(u,ea),Ca=$(u,2)<<18,$q(u.f,ca,Ca);break;case 25:for(L=0;L<Fa;++L)if(1==$(u,1)){var He=u.f;He.s[L]|=512}break;case 26:la=$(u,ea);Tb=C(B,w,-1,la,1);for(L=0;L<la;++L)Tb[L]=$(u,ea);break;case 27:la=$(u,fa);for(L=0;L<la;++L)R=$(u,fa),Uq(u.f,R,536870912)}Dn(new Qn(u.f),Wc);if(null!=Tb)for(Ib=\n0,ka=Tb.length;Ib<ka;++Ib)ca=Tb[Ib],Gn(u.f,ca,2==u.f.B[ca]?4:2);Mb=0;if(null==S&&M.length>u.d+1&&(32==M[u.d+1]||9==M[u.d+1]))S=M,Mb=u.d+2;if(null!=S)try{if(33==S[Mb]||35==S[Mb]){g4(u,S,Mb+1);ga=1==$(u,1);Vb=1==$(u,1);gb=2*$(u,4);qa=1<<gb;ca=0;for(R=1;R<Fa;++R)ca<Ka&&D(u.f,1,ca)==R?(Pa=D(u.f,0,ca++),xb=1):(Pa=0,xb=8),Vq(u.f,R,ao(u.f,Pa)+xb*($(u,gb)-~~(qa/2))),Wq(u.f,R,bo(u.f,Pa)+xb*($(u,gb)-~~(qa/2))),ga&&Xq(u.f,R,co(u.f,Pa)+xb*($(u,gb)-~~(qa/2)));Va=ga?1.5:(Do(),24);Za=Cq(u.f,Fa,Ka,Va);if(35==S[Mb]){pc=\n0;tc=C(B,w,-1,Fa,1);for(R=0;R<Fa;++R)pc+=tc[R]=Qo(u.f,R);for(R=0;R<Fa;++R)for(L=0;L<tc[R];++L)kb=vq(u.f,1),zq(u.f,R,kb,1),Vq(u.f,kb,ao(u.f,R)+($(u,gb)-~~(qa/2))),Wq(u.f,kb,bo(u.f,R)+($(u,gb)-~~(qa/2))),ga&&Xq(u.f,kb,co(u.f,R)+($(u,gb)-~~(qa/2)));Fa+=pc}if(Vb){var re=$(u,gb),$a=Math.log(2E3)*Math.LOG10E*re/(qa-1)-1;Ob=Math.pow(10,$a);Yc=Ob*h4($(u,gb),qa);Ja=Ob*h4($(u,gb),qa);ga&&(uc=Ob*h4($(u,gb),qa));xb=Ob/Za;for(R=0;R<Fa;++R)Vq(u.f,R,Yc+xb*ao(u.f,R)),Wq(u.f,R,Ja+xb*bo(u.f,R)),ga&&Xq(u.f,R,uc+xb*\nco(u.f,R))}else{xb=1.5/Za;for(R=0;R<Fa;++R)Vq(u.f,R,xb*ao(u.f,R)),Wq(u.f,R,xb*bo(u.f,R)),ga&&Xq(u.f,R,xb*co(u.f,R))}}else if(ga&&!Vb&&0==Ob&&(Ob=1.5),0!=Ob&&0!=u.f.p){for(ca=Za=0;ca<u.f.p;++ca)gc=ao(u.f,D(u.f,0,ca))-ao(u.f,D(u.f,1,ca)),Pc=bo(u.f,D(u.f,0,ca))-bo(u.f,D(u.f,1,ca)),oc=ga?co(u.f,D(u.f,0,ca))-co(u.f,D(u.f,1,ca)):0,Za+=Math.sqrt(gc*gc+Pc*Pc+oc*oc);Za/=u.f.p;Kc=Ob/Za;for(R=0;R<u.f.o;++R)Vq(u.f,R,ao(u.f,R)*Kc+Yc),Wq(u.f,R,bo(u.f,R)*Kc+Ja),ga&&Xq(u.f,R,co(u.f,R)*Kc+uc)}}catch(cd){if(cd=uo(cd),\nE(cd,101))cb=cd,cb.Xd(),S=null,ga=!1;else throw cd;}if((Xa=null!=S&&!ga)||u.b){En(u.f,3);for(ca=0;ca<u.f.d;++ca)if(2==Mn(u.f,ca)&&!so(u.f,ca)&&0==(u.f.z[ca]&3)){var yb=u.f;yb.z[ca]|=16777216}}!Xa&&u.b&&(u.f.K|=4,Qc=new q4,Qc.i=new w4,rs(Qc,u.f),Xa=!0);Xa?(lr(u.f),p4(u.f)):ga||(u.f.K|=4)}aa=Ya}}H=new tr(aa);b=ax(H.a.a);a="readOCLCode";d=null}catch(Md){if(Md=uo(Md),!E(Md,101))throw Md;}e=!1;if(null!=b&&null==d)try{if((e=IN(this.a,b,!1))&&this.c){var nb=this.a;if(nb.v){var Ie=nb.v;Ie.a=a;UL(Ie,nb.Vb,\n0,0,0)}nb.Fc=!0}}catch(fe){if(fe=uo(fe),E(fe,101))d="Invalid converted molfile";else throw fe;}this.a.cc=e;this.e?e?QN(this.e):RN(this.e,new Ho(d)):null!=d&&A0(this.a,d);this.d&&YG(this.a)};Z(630);Z(631);Z(24);Z(29);Z(30);U(YX)(1);\n//@ sourceURL=1.js\n');