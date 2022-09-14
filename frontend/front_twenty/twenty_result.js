var food_id=0;

chose_succuess(food_id)
result()
function result(name){
    const resultElement = document.getElementById("food_name");
    let food_name = resultElement.innerText;
    food_name=1;
    resultElement.innerText = "'"+name+"'";
    food_id = localStorage.getItem("food_code");
  }
var food_img_code="";

async function chose_succuess(food_id){
    food_id = localStorage.getItem("food_code");
    var result_url = "https://mwomeokji.shop/dishes/";
    const response = await fetch(result_url+food_id);
    const data = await response.json();
    result(data.name);
    food_img_code = data.imageUrl;
    input_img(food_img_code);

    }

  function input_img(code){
    document.getElementById("food_img").src= code;    
  }
chose_succuess(chose_food);

function go_top(){
  window.scrollTo({top:0, left:0, behavior:"smooth"});
}
