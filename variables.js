//  firstVar = "myfirstVar";

// for ( var index = 0; index < 2; index++ ){
//      firstVar = "changed value";
// }
// console.table(firstVar);


// function restOperator(a, ...b){
//     console.log(a);
//     console.log(b[4]);
// }

// restOperator(1, 2, 3, 4, 5 , 6)




// var x=1;
// a();
// b();
// console.log(x);
// function a(){
//     var x=10;
//     console.log(x);
// }
// function b(){
//     var x=100;
//     console.log(x);
// }




// for ( var index = 0; index < 2; index++ ){
//      var firstVar = "changed value";
// }
// console.log(firstVar);


function x(){
    for ( let i=1; i<=5; i++ ){
        setTimeout(function(){
            console.log(i);
        }, i*1000);
    }
}
x();


// Closures are functions with its lexical scope. Example:
// function outer(){
//     // var a = 1;
//     function inner(){
//         // var a = 2;
//         console.log(a)
//     }
//     return inner;
// }
// var a = 1;
// outer()(); // OR var close = outer(); close();
//  Closures Advantages are Data hinding and encapsulations



// function close(){
//     var count =0 ;
//     return function increment(){
//         count++;
//         console.log(count);
//     }
// }

// var counter =close();
// counter(); counter();
// var counter2 = close();
// counter2();
// close()(); close()();
//  Everytime it will create a new copy and scope. That's why output will be 1 1


// Online Javascript Editor for free
// Write, Edit and Run your Javascript code using JS Online Compiler
const { JSDOM } = require("jsdom");
const htmlString ="<div><p>Hello, world!</p></div>"
const dom = new JSDOM(htmlString);

// Access the DOM like you would in a browser
const parsedHtml = dom.window.document.body;

console.log(parsedHtml);