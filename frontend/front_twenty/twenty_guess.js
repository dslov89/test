var food_data=[]; // api로 fetch받은 데이터
var question_length=[]; // 질문마다 길이가 저장됨
var guess_start_check=0;
var choose_record=[];


function slide(){
    //$(".slide").click(function(){ 
      $(".slide").animate({marginLeft:"-900px"}, 400);
      $(".guess_slide").animate({marginLeft:"-200px"}, 400);
      //$("#guess_button_a").hide();
      $(".slide").animate({marginLeft:"1100px"}, 0000);
      $(".guess_slide").animate({marginLeft:"900px"}, 0000);
      $(".slide").animate({marginLeft:"0px"}, 400);
      $(".guess_slide").animate({marginLeft:"0px"}, 700);
    };

//시간 지연을 위해 사용
function sleep(ms) {
  const wakeUpTime = Date.now() + ms;
  while (Date.now() < wakeUpTime) {}
}

//fetch 시작
async function getjson(){
  const response = await fetch(`https://mwomeokji.shop/questions/dishes`);
  const data = await response.json();
  console.log(data.dishes);
  food_data = data;
  for(key in data) {
    question_length.push(data[key].question.length); // 문자열 뒤에 length를 붙이는 것만으로 길이 측정
  }
  var i=0 

  if(guess_start_check==0){
    guess_start_check=1;
    next_guess();
    like();
    count("plus");
  }

  return data;

}


var rst=[]; // 질문들이 랜덤하게 들어있고 안에 그 순서가 지정되있다 
function getRandom(min, max) {
  return Math.floor((Math.random()*(max-min+1))+min);
  }
  
  // 랜덤하게 추출 (array Ver)
  function getRandomArray(min, max, count) {
    if (max-min+1<count) return;
    while(1){
      var index=getRandom(min,max);
      // 중복 여부를 체크
      if (rst.indexOf(index) > -1) {
        continue;
      }
      rst.push(index);
      if (rst.length == count) {
        break;
      }
    }
  }


getRandomArray(0,44,45);

var target = document.getElementById("guess_text");
var length=question_length[rst[guess_order]];

var guess_order=0;
var clicked_count=0;

function next_guess(){
  clicked_count+=1;
  data=getjson();
  const guessElement = document.getElementById('guess_text');

  guessElement.innerText = food_data[rst[guess_order]].question;

  console.log(food_data[rst[guess_order]].question);
  console.log(food_data[rst[guess_order]].question.length);

  //for(var j=0 ; j<44 ; j++){
    //console.log(j+" "+food_data[rst[j]].question);
  //}

  if(food_data[rst[guess_order]].question.length >20){
    $('#background_img2').css({
      "width":"400px",
      "left":"-120px"
    });
    
    $('#guess_text').css({
      "width":"400px",
      "left":"-10px"
    });
    document.getElementById("background_img").src= "./img_file_twenty/twenty_guess_guess_long.svg";
  }
  else{
    $('#background_img2').css({
      "width":"100px",
      "left":"-180px"
    });
    $('#guess_text').css({
      "width":"300px",
      "right":"-20px"
    });
    document.getElementById("background_img").src= "./img_file_twenty/twenty_guess_guess_background.svg";
  }
}
var arr = {};
function make_arr(){
  
  for( var order = 1 ; order <106 ; order++){
    arr[order] = 0;
  }
  console.log("arr");
  console.log(arr);
}
make_arr();

function like(){

  console.log("rst");
  console.log(food_data[rst[0]].dishes[0].name);
  console.log(food_data[rst[guess_order]].dishes.length);
  
  guess_order=guess_order+1;
  if (clicked_count > 45){
    choose();
  }
  bar_progress();
  if(clicked_count<=1){

    console.log(arr);
    return;
  }
  
  else{
    //console.log("question ", food_data[rst[guess_order-2]].question);
    for(smallkey in food_data[rst[guess_order-2]].dishes){
      arr[food_data[rst[guess_order-2]].dishes[smallkey].id]+=1;
      //console.log(guess_order-2 +" guess "+arr[food_data[rst[guess_order-1]].name]);
    }
    //console.log("arr 배열");
    console.log(arr);
    choose_record[guess_order]=1;
    console.log(choose_record);
  }

}

function dislike(){
  guess_order=guess_order+1;
  if (clicked_count > 45){
    choose();
  }
  bar_progress();
  if(clicked_count<=1){

    console.log(arr);
    return;
  }
  
  else{
    console.log("question", food_data[rst[guess_order-2]].question);
    for(smallkey in food_data[rst[guess_order-2]].dishes){
      arr[food_data[rst[guess_order-2]].dishes[smallkey].id]-=1;
      console.log(guess_order-2 +" guess "+arr[food_data[rst[guess_order-2]].dishes[smallkey].name]);
    }
  }
    console.log(arr);
    choose_record[guess_order]=-1;
    console.log(choose_record);
}  
  


function normal(){
  guess_order=guess_order+1;
  if (clicked_count > 45){
    choose();
  }
  bar_progress();
  if(clicked_count<=1){

    console.log(arr);
    return;
  }
  
  else{
    choose_record[guess_order]=0;
    console.log(choose_record);
  }  
}

function guess_back(){
  if(food_data[rst[guess_order-2]].question.length >20){
    $('#background_img2').css({
      "width":"400px",
      "left":"-120px"

    });
    
    $('#guess_text').css({
      "width":"400px",
      "left":"-10px"
    });
    document.getElementById("background_img").src= "./img_file_twenty/twenty_guess_guess_long.svg";
  }
  else{
    $('#background_img2').css({
      "width":"100px",
      "left":"-180px"
    });

    $('#guess_text').css({
      "width":"300px",
      "right":"-20px"
    });
    document.getElementById("background_img").src= "./img_file_twenty/twenty_guess_guess_background.svg";
  }
  const guessElement = document.getElementById('guess_text');

  if(choose_record[guess_order]==1){
    for(smallkey in food_data[rst[guess_order-2]].dishes){
      arr[food_data[rst[guess_order-2]].dishes[smallkey].id]-=1;
    }
    guessElement.innerText = food_data[rst[guess_order-2]].question;
    console.log(arr);
    choose_record[guess_order]=0;
    console.log(choose_record);
    guess_order-=1;
    bar_progress();
  }

  else if(choose_record[guess_order]==-1){
    for(smallkey in food_data[rst[guess_order-2]].dishes){
      arr[food_data[rst[guess_order-2]].dishes[smallkey].id]+=1;
    }
    guessElement.innerText = food_data[rst[guess_order-2]].question;
    console.log(arr);
    choose_record[guess_order]=0;
    console.log(choose_record);
    guess_order-=1;
  }

  else if(choose_record[guess_order]==2){
    guessElement.innerText = food_data[rst[guess_order-2]].question;
    console.log(arr);
    choose_record[guess_order]=0;
    console.log(choose_record);
    guess_order-=1;
  }

  else{
    //console.log("둘다 아님");
    //console.log(guess_order);
    //console.log("choose "+choose_record);
    //console.log(choose_record);
    //console.log(arr);
  }

    //$(".slide").click(function(){ 
      $(".slide").animate({marginLeft:"-1100px"}, 0000);
      $(".guess_slide").animate({marginLeft:"-900px"}, 0000);


      $(".slide").animate({marginLeft:"0px"}, 400);
      $(".guess_slide").animate({marginLeft:"0px"}, 700);      

      //$(".slide").animate({marginLeft:"+900px"}, 400);
      //$(".guess_slide").animate({marginLeft:"+200px"}, 400, function(){
        //next_guess();
      //});
      //$("#guess_button_a").hide();


}

function bar_progress(){
  document.getElementById( 'jb' ).value = guess_order;

}

next_guess();
console.log(rst);

 
let chose_food=1;

function choose(){
  const resultElement = document.getElementById('guess_number');
  number = resultElement.innerText;

  if(number>7){
    let sorted = Object.entries(arr).sort((a, b) => b[1] - a[1]);
    var sorted_arr = [];
    var big_value=sorted[0][1];
    var chose;
    var big_value_arr=[];
    var length=0;

    for(let element of sorted) {
      if(big_value==element[1]){
        big_value_arr.push(element[0]);
        console.log(length);
        length+=1;
      }

	  sorted_arr.push(element[0]);
    }

    var num = Math.random() * length; // Math 앞에 대문자
    var ball1 = parseInt(num); // parseInt 철자 주의
    var chose_food=parseInt(big_value_arr[ball1]); 

    localStorage.setItem("food_code", chose_food);
    location.href='./twenty_loading.html';
  }
  else if(number<8){
    window.alert("조금 더 진행해주시면 감사하겠습니다");
  }
  
}

function count(type)  {
  // 결과를 표시할 element
  const resultElement = document.getElementById('guess_number');
  // 현재 화면에 표시된 값
  let number = resultElement.innerText;

  if(type === 'plus') {
    number = parseInt(number) + 1;

  }else if(type === 'minus')  {
    number = parseInt(number) - 1;
    console.log(arr);
    if(number === -1){
      location.href='./twenty_main.html';
    }
  }


  if(number>12){
    document.getElementById("skipd").src= "./img_file_twenty/twenty_guess_skip_guess.svg";
  }

  else{
    document.getElementById("skipd").src= "./img_file_twenty/twenty_guess_choose_more.svg";
  }
  
  // 결과 출력
  if(number < 10){
    resultElement.innerText = "0"+number+".";
  }
  else{
    resultElement.innerText = number+".";
  }
}

/*

*/

