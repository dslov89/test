function functionA() {
    console.log("start botton clicked");
}
localStorage.setItem('num','value');

if(localStorage.getItem('num')){
    var lastData = localStorage.getItem('num')
    console.log(lastData);
   }
