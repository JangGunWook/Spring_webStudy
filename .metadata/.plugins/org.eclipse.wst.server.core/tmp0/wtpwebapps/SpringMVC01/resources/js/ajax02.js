/**
 * 
 */



const loadData =async()=>{
	await $.ajax({
		url:'load',
		type :"get",
		success : function(res){
			console.log(res)
		},
		erro : function(e){
			console.log(e)
		}
	})
}
const btn =$("#btn");

btn.on("click",loadData);
