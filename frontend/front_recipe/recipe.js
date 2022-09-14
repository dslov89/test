
var recipe1 = [
    '야채와 해물을 준비합니다.',
    '밀가루와 야채와 해물을 섞어 반죽을 만듭니다.',
    '후라이팬에 기름을 둘러 반죽을 예쁘게 부칩니다.',
    '맛있게 먹습니다.'
    
]

var recipe2 = [
    '나갈 준비를 합니다.',
    '맛집을 찾아 갑니다.',
    '맛있게 먹습니다.',
    '후라이팬에 기름을 둘러 반죽을 예쁘게 부칩니다.',
    
]

function replaceClass(id, oldClass, newClass) {
    var elem = document.getElementById(id);
    elem.classList.remove(oldClass);
    elem.classList.add(newClass);
}

function button(a,b,c,d){ 
   addButtonCss("recipe_button"+d);
   removeButtonCss("recipe_button"+a);
   removeButtonCss("recipe_button"+b);
   removeButtonCss("recipe_button"+c);
   
   if(d==2){
        replaceText(recipe2);
   }

   else if(d==1){
        replaceText(recipe1);
   }
}


function removeButtonCss(id){
    replaceClass(id, "recipe_button", "recipe_button1");
    replaceClass(id+"_text", "recipe_button_text", "recipe_button_text1");
    replaceClass(id+"_num", "recipe_button_num", "recipe_button_num1");
}

function addButtonCss(id){
    replaceClass(id, "recipe_button1", "recipe_button");
    replaceClass(id+"_text", "recipe_button_text1", "recipe_button_text");
    replaceClass(id+ "_num", "recipe_button_num1", "recipe_button_num");
}

function replaceText(list){
    document.getElementById("recipe_list_text1").innerText=list[0];
    document.getElementById("recipe_list_text2").innerText=list[1];
    document.getElementById("recipe_list_text3").innerText=list[2];
    document.getElementById("recipe_list_text4").innerText=list[3];
}

function star(a){
    for (var i=1; i<=a;i++){
        addStar("star"+i);
    }
    for (var i=5; i>a;i--){
        removeStar("star"+i);
    }
}

function addStar(id){
    document.getElementById(id).src="img_recipe/recipe_star1.svg"
}

function removeStar(id){
    document.getElementById(id).src="img_recipe/recipe_star.svg"
}



function submit(){
    var submit = document.getElementById("submit_button");
    submitCss(submit);
}

function submitCss(id){
    id.style.backgroundColor='transparent';
    id.innerText="Thank you!";
}

var i=0;
function bookMark(id){
    var book = document.getElementById("recipe_book");
    
    if (i%2==0){
        addBook(book);  
        i++;
    }
    else {
        removeBook(book);
        i++;
    }
     
}

function addBook(id){
    id.src = "img_recipe/recipe_bookmark1.svg";
}

function removeBook(id){
    id.src = "img_recipe/recipe_bookmark.svg";
}
   

 

