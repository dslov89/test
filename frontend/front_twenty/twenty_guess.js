
var keys=[];
var food_named=[];
var food_data=[];
var question_length=[];
//let number=0;
//export var chose_food=0;


function sleep(ms) {
  const wakeUpTime = Date.now() + ms;
  while (Date.now() < wakeUpTime) {}
}

//fetch 시작
async function getjson(){
  const response = await fetch(`http://ec2-43-200-137-107.ap-northeast-2.compute.amazonaws.com:8081/questions/dishes`);
  const data = await response.json();
  console.log(data.dishes);
  food_data = data;
  for(key in data) {
    keys.push(key);
      //console.log(key+ data[key]);
      //console.log("key "+ data[key].question);
      //console.log("key "+ data[key].question.length);
      question_length.push(data[key].question.length);
      //질문들을 알 수 있음
  }
  
  for(var key in data) {
    keys.push(key);
      //console.log(key+ data[key]);
      //console.log("메뉴 "+key+ data[key].dishes); //out 질문에 대한 음식 갯수체크정도
      //질문들을 알 수 있음
      ///for(var smallkey in data[key].dishes){
        ///food_named.push(smallkey);
        //console.log(food_named);
        //console.log(smallkey+ data[key].dishes[smallkey].name);
        //data[key].dishes[1].name
        //key값에 포함된 음식들을 알 수 있음
      ///}
  }
  //console.log("test "+food_named[0].dishes[smallkey].name)


  
  data.forEach(o => {
      if (o.id != '{id: 92, name: 쌀국수}') {
          //console.log(o);
      }
      else {
          //console.log(o);
      }
  });const unique = [...new Set(data.map(item => item.group))];

  console.log("질문 0부터 10까지");
  for(var i=0 ; i<10 ; i++){
    console.log("i="+i+" "+food_data[rst[i]].question);
  }



  return data;
}
//fetch 끝



var guess_food_data = getjson();
/*
console.log("data = "+guess_food_data);
var keys=[];
for(key in guess_food_data) {
  keys.push(key);
    console.log(key+ guess_food_data[key]);
    console.log("11");
    //console.log(key+ [key].question);
    //질문들을 알 수 있음
}
*/



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
console.log("guestion_list random");

getRandomArray(0,9,10);
//next_guess();
//배열 랜덤으로 만드는 부분(0부터 9까지 10개의 수를 배열)
//console.log("배열 "+rst);

  /*
  //let guess_text = guessElement.innerText;
  //console.log(guess_text);
  console.log("--");
  console.log("guess_order "+guess_order);
  console.log("rst guess order "+rst[guess_order]);
  console.log("글자수 = "+question_length[rst[guess_order]]);
  var target = document.getElementById("guess_text");
  var length=question_length[rst[guess_order]];
  */
 function start(){
  console.log("-------------------------------------------------------------------------------");
  console.log("clicked_count "+clicked_count);
  console.log("next guess guess_order = "+guess_order);
  console.log(guess_order+" guess_order "+food_data[rst[guess_order]].question);
  console.log("-------------------------------------------------------------------------------");
  
 }

var guess_order=0;
var clicked_count=0;

function next_guess(){
  clicked_count+=1;
  data=getjson();
  const guessElement = document.getElementById('guess_text');

  guessElement.innerText = food_data[rst[guess_order]].question;

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
  guess_order=guess_order+1;
  if(clicked_count<=1){
    //console.log("좀만 더 해주세요");
    //const guessElement = document.getElementById('guess_text');
    //guessElement.innerText = food_data[rst[guess_order+1]].question;
    console.log(arr);
    return;
  }
  
  else{

    for(smallkey in food_data[rst[guess_order-2]].dishes){
      //console.log("guess order "+guess_order-2);
      console.log("guess order "+food_data[rst[guess_order-2]].question);
      console.log(food_data[rst[guess_order-2]].dishes[smallkey].name+" "+food_data[rst[guess_order-2]].dishes[smallkey].id);
    
      //질문마다 속해있는 음식 말해줌
      arr[food_data[rst[guess_order-2]].dishes[smallkey].id]+=1;
      console.log("arr "+arr[food_data[rst[guess_order-2]].dishes[smallkey].id])
    }
    console.log("결과");
    console.log(arr);

  }

}

function dislike(){
  guess_order=guess_order+1;
  if(clicked_count<=1){
    //console.log("좀만 더 해주세요");
    //const guessElement = document.getElementById('guess_text');
    //guessElement.innerText = food_data[rst[guess_order+1]].question;
    // 수정할 부분
    console.log(arr);
    return;
  }
  
  else{

    for(smallkey in food_data[rst[guess_order-2]].dishes){

      console.log("guess order "+food_data[rst[guess_order-2]].question);
      console.log(food_data[rst[guess_order-2]].dishes[smallkey].name+" "+food_data[rst[guess_order-2]].dishes[smallkey].id);
    
      //질문마다 속해있는 음식 말해줌
      arr[food_data[rst[guess_order-2]].dishes[smallkey].id]-=1;
      console.log("arr "+arr[food_data[rst[guess_order-2]].dishes[smallkey].id])
    }
    console.log(arr);

  }  
  
}

function nurmal(){
  console.log(arr);
}

function guess_back(){
  const guessElement = document.getElementById('guess_text');
  guess_order-=1;

  console.log()
  for(smallkey in food_data[rst[guess_order-1]].dishes){
    console.log(food_data[rst[guess_order-1]].dishes[smallkey].name);
    //질문마다 속해있는 음식 말해줌
    arr[food_data[rst[guess_order-1]].dishes[smallkey].id]-=1;
  }
  guessElement.innerText = food_data[rst[guess_order-1]].question;
  console.log(arr);
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
	    sorted_arr.push(element[0])

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
  // 더하기/빼기
  if(type === 'plus') {
    number = parseInt(number) + 1;
  }else if(type === 'minus')  {
    number = parseInt(number) - 1;
    if(number === -1){
      location.href='./twenty_main.html';
    }
  }


  if(number>7){
    document.getElementById("skipd").src= "./img_file_twenty/twenty_guess_skip_guess.svg";
  }
  
  // 결과 출력
  if(number < 10){
    resultElement.innerText = "0"+number+".";
  }
  else{
    resultElement.innerText = number+".";
  }
}


