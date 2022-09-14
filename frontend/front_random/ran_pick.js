var food=[];
var category = localStorage.getItem("category_code");
console.log("cate "+category);

async function getjson(){
  if(category==6){
    const response = await fetch('https://mwomeokji.shop/dishes/random');
    const data = await response.json();
    food = data;
  }
  else{
    if(category==1) category = "한식";
    else if(category==2) category = "일식";
    else if(category==3) category = "양식";
    else if(category==4) category = "기타";
    else if(category==5) category = "중식";

  var category_url = "https://mwomeokji.shop/dishes/random?category="
  const response = await fetch(category_url+category);
  //const response = await fetch(category_url);
  const data = await response.json();
  food = data;
  console.log(food);
  console.log(data.name);
  console.log("33333333");
  console.log(category);
  }
    console.log("22");
    console.log(food);
    console.log(food.id);
    console.log(food.name);
    url = food.imageUrl;
    document.getElementById("food_img").src= url;

    const resultElement = document.getElementById("food_name");
    let food_name = resultElement.innerText;

    resultElement.innerText = "'"+food.name+"'";
  }
  getjson();
  
  function again(){
    getjson();
  }