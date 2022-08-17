var colors = [
    '#FDF5A9',
	'#B7D08F' ,
    '#E9B882' ,
    '#E9B882' ,
    '#ADD0E4' 
]


function getScrollPoistion() {
    var ContainerElement = document.getElementById("main_main_sec_tut_scroll");
    var x = ContainerElement.scrollLeft;
    var y = ContainerElement.scrollTop;
    console.log(x); // scroll position from Left
    console.log(y); // scroll position from top

    var box1= document.getElementById("main_main_sec_tut_box1");
    var text1 = document.getElementById("main_main_sec_tut_text1");
    var box2 = document.getElementById("main_main_sec_tut_box2");
    var text2 = document.getElementById("main_main_sec_tut_text2");
    var box3 = document.getElementById("main_main_sec_tut_box3");
    var text31 = document.getElementById("main_main_sec_tut_text3-1");
    var text32 = document.getElementById("main_main_sec_tut_text3-2");
    var box4 = document.getElementById("main_main_sec_tut_box4");
    var text4 = document.getElementById("main_main_sec_tut_text4");
    
    var scrolls = document.getElementById("main_main_sec_bar1-1");
    var scrolll = document.getElementById("main_main_sec_bar1-2");
    var scroll21 = document.getElementById("main_main_sec_bar2-1");
    var scroll22 = document.getElementById("main_main_sec_bar2-2");
    var scroll23 = document.getElementById("main_main_sec_bar2-3");
    var scroll31 = document.getElementById("main_main_sec_bar3-1");
    var scroll32 = document.getElementById("main_main_sec_bar3-2");
    var scroll33 = document.getElementById("main_main_sec_bar3-3");
    var scroll41 = document.getElementById("main_main_sec_bar4-1");
    var scroll42 = document.getElementById("main_main_sec_bar4-2");
   
    var img1 = document.getElementById("main_main_sec_tut_img1");
    var img21 = document.getElementById("main_main_sec_tut_img21");
    var img22 = document.getElementById("main_main_sec_tut_img22");
    var img23 = document.getElementById("main_main_sec_tut_img23");
    var img3 = document.getElementById("main_main_sec_tut_img3");
    var img4 = document.getElementById("main_main_sec_tut_img4");
    
    if (y>=0&&y<150){
        addBoxCss(box1,0);
        addTextCss(text1,0);
        removeBoxCss(box2);
        removeTextCss(text2,1);
        
        addScrollBa(scrolls,1);
        addScrollBa(scrolll,0);
        removeScrollBa(scroll21);
        removeScrollBa(scroll22);
        removeScrollBa(scroll23);

        addImg(img1);
        removeImg(img21);
        removeImg(img22);
        removeImg(img23);
    }
    else if (y>=150&&y<300){
        removeBoxCss(box1);
        removeTextCss(text1,0);
        removeBoxCss(box3);
        removeTextCss(text31,2);
        removeTextCss(text32,3);
        addBoxCss(box2,1);
        addTextCss(text2,1);

        removeScrollBa(scrolls);
        removeScrollBa(scrolll);
        addScrollBa(scroll21,0);
        addScrollBa(scroll22,1);
        addScrollBa(scroll23,0);
        removeScrollBa(scroll31);
        removeScrollBa(scroll32);
        removeScrollBa(scroll33);

        addImg(img21);
        addImg(img22);
        addImg(img23);
        removeImg(img1);
        removeImg(img3);
    }
    else if (y>=300&&y<450){
        removeBoxCss(box2);
        removeTextCss(text2,1);
        removeBoxCss(box4);
        removeTextCss(text4,4);
        addBoxCss(box3,2);
        addTextCss(text31,2);
        addTextCss(text32,3);

        removeScrollBa(scroll21);
        removeScrollBa(scroll22);
        removeScrollBa(scroll23);
        addScrollBa(scroll31,0);
        addScrollBa(scroll32,1);
        addScrollBa(scroll33,0);
        removeScrollBa(scroll41);
        removeScrollBa(scroll42);

        addImg(img3);
        removeImg(img4);
        removeImg(img21);
        removeImg(img22);
        removeImg(img23);
    }
    else if (y>450){
        removeBoxCss(box3);
        removeTextCss(text31,2);
        removeTextCss(text32,3);
        addBoxCss(box4,4);
        addTextCss(text4,4);

        removeScrollBa(scroll31);
        removeScrollBa(scroll32);
        removeScrollBa(scroll33);
        addScrollBa(scroll41,0);
        addScrollBa(scroll42,1);

        addImg(img4);
        removeImg(img3);
    }


  }


//스크롤 시 스타일
function addBoxCss(header,i){
    header.style.backgroundColor = colors[i];
    header.style.boxShadow = '0px 8px 10px 1px #d4d3d3';
    header.style.zIndex = i+5;
    header.style.borderRadius = '32px';
} 

function addTextCss(header1,i){
    header1.style.backgroundColor = 'transparent';
    header1.style.color='#494646';
    if (i==0||i==1||i==3){ 
        // 한글 
        header1.style.webkitTextStroke = '0px #646464';
        header1.style.fontSize = '3.438rem';
        header1.style.top = '2.438rem';
    }
    else {
        // 영어
        header1.style.zIndex=10;
        header1.style.fontSize = '3.438rem';
        header1.style.letterSpacing = '0.25em';
        header1.style.fontWeight = '700';
        header1.style.top = '2.25rem';
        header1.style.textShadow = '0px 0 #646464, 0 0px #646464, 0px 0 #646464, 0 0px #646464';
    }
    

}


// 원래 스타일
function removeBoxCss(id){
    id.style.backgroundColor = '#E9E9E9';
    id.style.boxShadow = '0px 0px 0px 0px gray';
    id.style.zIndex = 1;

}
function removeTextCss(id,i){
    id.style.backgroundColor = '#E9E9E9';
    id.style.color='#E9E9E9';
    if (i==0||i==1||i==3){
        // 한글
        id.style.webkitTextStroke = '0.094rem #646464';
        id.style.fontSize = '4.063rem';
        
        id.style.top = '5.063rem';
    }
    else {
        // 영어
        id.style.textShadow = '0.125rem 0 #646464, 0 -0.125rem #646464, -0.125rem 0 #646464, 0  0.125rem #646464';
    
        id.style.fontSize =  '4.063rem';
        id.style.letterSpacing = '0.2em';
        id.style.fontWeight = '680';
        id.style.top = '4.563rem';
        
    }
   
}

function addScrollBa(id,i){
    if (i == 1){
        id.style.backgroundColor = '#9B9B9B';
    }

    else {
        id.style.backgroundColor = '#E9E9E9';
    }
    
}

function removeScrollBa(id){
    id.style.backgroundColor = 'transparent';
}


function addImg(img){
    img.style.visibility = 'visible';
}
function removeImg(img){
    img.style.visibility = 'hidden';
}

function includeHTML() {
    var z, i, elmnt, file, xhttp;
    z = document.getElementsByTagName("*");
    for (i = 0; i < z.length; i++) {
      elmnt = z[i];
      file = elmnt.getAttribute("include-html");
      if (file) {
        xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
          if (this.readyState == 4 && this.status == 200) {
            elmnt.innerHTML = this.responseText;
            elmnt.removeAttribute("include-html");
            includeHTML();
          }
        };
        xhttp.open("GET", file, true);
        xhttp.send();
        return;
      }
    }
  }

  
  
  function clickScroll(){
    var ContainerElement = document.getElementById("main_main_sec_tut_scroll");
    var y = ContainerElement.scrollTop;

    if (y>=0&&y<150){
        location.href='../front_twenty/twenty_main.html' //여기에 스무고개 html 연결
    }
    else if (y>=150&&y<300){
        location.href='../front_rps/rps_main.html' //여기에 가위바위보 html 연결 
    }
    else if (y>=300&&y<450){
        // location.href='random_category_sec.html' 여기에 맛집 html 연결
    }
    else if (y>450){
        // location.href='random_category_sec.html' 여기에 랜덤 html 연결
    }

  }

