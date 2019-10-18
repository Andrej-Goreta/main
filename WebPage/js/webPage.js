let surveyAnswers = [];
let answers =  {
    answer1: '',
    answer2: '',
    answer3: ''
}
let comments = [];


function answer1ToObject(){
    let surveyQuestion1 = document.querySelectorAll('input[name="question1"]');
    for(i=0; i<surveyQuestion1.length; i++){
        if(surveyQuestion1[i].checked){
           answers.answer1 = surveyQuestion1[i].defaultValue;
        }
    }
}

function answer2ToObject(){
    let surveyQuestion2 = document.querySelectorAll('input[name="question2"]');
    for(i=0; i<surveyQuestion2.length; i++){
        if(surveyQuestion2[i].checked){
           answers.answer2 = surveyQuestion2[i].defaultValue;
        }
    } 
}

function answer3ToObject(){
    let surveyQuestion3 = document.querySelectorAll('input[name="question3"]');
    for(i=0; i<surveyQuestion3.length; i++){
        if(surveyQuestion3[i].checked){
           answers.answer3 = surveyQuestion3[i].defaultValue;
           
        }
    } 
}

function allAnswersToArray(){
   surveyAnswers.push(answers)
}

function commentToArray(){
    let comment = document.getElementById('comment');
    comments.push(comment.value);
}

let submitButton = document.getElementById('submit_button');
submitButton.addEventListener('click', ()=>{
answer1ToObject();
answer2ToObject();
answer3ToObject();
allAnswersToArray();
commentToArray();
localStorage.setItem("answersKey", JSON.stringify(surveyAnswers));
localStorage.setItem("commentsKey", JSON.stringify(comments)); 

});

function displayAnswers(){
    let injectAnswers = document.getElementById('show_answers');
    let showAnswers = JSON.parse(localStorage.getItem("answersKey"));
    injectAnswers.innerText = '1.) ' + showAnswers[0].answer1 + "\n" + '2.) ' + showAnswers[0].answer2 + "\n " + '3.) ' + showAnswers[0].answer3;

}

function displayComment(){
    let injectComment = document.getElementById('show_comment');
    let showComment = JSON.parse(localStorage.getItem("commentsKey"));
    injectComment.innerText = showComment[0];
   
}

displayAnswers();
displayComment();





