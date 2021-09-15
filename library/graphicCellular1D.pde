void drawCellular(Cellular1D C,color[] trad){
  float scale=width/C.getLength();
  int Line=C.gen;
  scale(scale);
  float dat=Line%(height/scale);
  for(int i=0;i<C.getLength();i++){
    fill(trad[C.state[i]]);
    rect(i,dat,1,1);
  }  
}


void drawCellular(Cellular1D C,color[] trad,int skip){
  float scale=width/C.getLength();
  scale(scale);
  int Line=C.gen;
  for(int j=0;j<skip;j++){
    float dat=Line%(height/scale);
    for(int i=0;i<C.getLength();i++){
      fill(trad[C.state[i]]);
      rect(i,dat,1,1);
    }  
    Line+=1;
    C.nextGen();
  }
}

void screenShot(Cellular1D C){
  saveFrame("./screenshot/"+C.getRule()+"-"+C.getLength()+"-"+test.gen+".png");
}


void anim(){
  saveFrame("./frames/#####.tga");
}
