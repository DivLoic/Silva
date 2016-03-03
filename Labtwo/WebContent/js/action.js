/*
**
** Part 1
**
*/


$("input[value='female']").prop('checked', true);
/** Now we are sure we prepare for a girl**/
fs1 = $("fielset").first();
h1 = $(".partone h1").first();

function validation(){
	conformance = true;
	$(document).ready(function(){
		var warning = 'Take Care, some of those field are empty!\nPlease complete the form.';
		var content = '\n';
		$(".partone input[type='text']").each(function(){
			content += $(this).attr('name')+': '+ $(this).val()+'\n'
		});
		$(".partone input[type='radio']").each(function(){
			var n = $(this).attr('value');
			if( $(".partone input[value='"+n+"']").is(":checked")== true){
			content += $(this).attr('name')+': '+ $(this).val()+'\n';
			}
		});
		
		$(".partone input[type='text']").each(function(i){
			if($(this).val() == ""){
				console.log($(this));
				conformance = false;
				alert(warning + content);
				return false;
			}
		});
	});
	return conformance;
}

$(document).ready(function(){
	$("input[type='radio']").change(function(){
		if($(this).val() == 'male'){
			$("fieldset").addClass("male")
			h1.text("Hi Bro! Welcome, to the Lab session n°2.")
		} else {
			$("fieldset").removeClass('male');
			h1.text("Hello Madam. Nice to see you\n in this Lab session.")
		}
	})
})

/*
**
** Part 2
**
*/

randomTxt = [ "Steve Jobs: You can fly, you just have to trust you a lot.",
              "Steve Jobs: Stay Angry, Stay foolish.",
              "Stephen Hawking: Intelligence is the ability to adapt to change.",
              "Alan Turing: Science's a diff-E. Religion is a boundary condition.",
              "James C. Maxwell: Aye, I suppose I could stay up that late.",
              "Simple scripts with Jquery LabTwo part 2"
             ];

var f1 = function(){
	n = parseInt(6*Math.random());
	$(".parttwo h1").text(randomTxt[n])
};

divtest = [ 0,
            "This <--- Is a super div to perform exercise.",
            "/!\\ Have u found out the div used for the question 2?",
            "Bro, Look OUT !!! I'm a DIV TAG ^^",
            "This is a divtest for the lab session N°2",
          ];

function f2(){
	if(divtest[0] + 1 <= 4){
		divtest[0] += 1;
		$("#divtest").text(divtest[divtest[0]]);
	} else {
		divtest[0] = 0;
		f2();
	}
}

function f3(){
	$("#divtest").after("<p>Bla Bla Bla, I'm jsut some meaningless paragraph...</p>");
}

function f4(){
	val = $("title").text();
	val = '*' +val+ '*';
	alert("Check Out the title page, \n We just added 2 Stars.")
	$("title").text(val);
}

function f5(){
	$(".badge").fadeToggle(800);
}



/*
**
** Part 3
**
*/



function idHelper(data){
	offer = $(".partthree input[type='text']").val();
	if(data == "1"){
		$(".partthree span.failure").css("display","none");
		$(".partthree span.succes strong").text(offer);
		$(".partthree span.succes").css("display","inline-block");
	} else {
		$(".partthree span.succes").css("display","none");
		$(".partthree span.failure strong").text(offer);
		$(".partthree span.failure").css("display","inline-block");
	}
}

function loginHelper(data){
	var e = $(".partthree input[type='password']");
	if(data == "0"){
		var l = 5;
		e.val("");
		e.css("color", "red");
		for( var i = 0; i < 10; i++ ){
			e.animate( { 'margin-left': "+=" + ( l = -l ) + 'px'}, 60);
		}
		
	} else {
		$(".partthree form").submit();
	}
}

$(document).ready(function(){
	$(".partthree input[type='text']").keyup(function(){
		if($(this).val() != ""){
			$.post("/Labtwo/IdGetter", {id :$(this).val()}, function(data, status){
				idHelper(data);
			})
		} else {
			$(".partthree span.ajaxflag").css("display","none");
		}
	})
});

$(document).ready(function(){
	$("#submitter3").on('click', function(event){
		event.preventDefault();
		$.post("/Labtwo/IdGetter", {
			id : $(".partthree input[type='text']").val(),
			passwd :$(".partthree input[type='password']").val()
			}, function(data, status){
				loginHelper(data);
			})
	})
});

$(document).ready(function(){
	$(".partthree input[type='password']").click(function(){
		$(this).css('color', '#9B6415');
	})
});





/*
**
** Part 4
**
*/



/*
$(function() {
    var availableTags = [
      "ActionScript",
      "AppleScript",
      "Asp",
      "BASIC",
      "C",
      "C++",
      "Clojure",
      "COBOL",
      "ColdFusion",
      "Erlang",
      "Fortran",
      "Groovy",
      "Haskell",
      "Java",
      "JavaScript",
      "Lisp",
      "Perl",
      "PHP",
      "Python",
      "Ruby",
      "Scala",
      "Scheme"
    ];

$(".partfour input").autocomplete(
		{ 	source : availableTags,
			messages: {
		        noResults: '',
		        results: function() {}
		    }
		});

});
*/


jQuery(function () {
	jQuery(".partfour input").autocomplete({
		messages: {
			noResults: '',
			results: ''
		},
		source: function (request, response) {
			jQuery.getJSON(
					"http://gd.geobytes.com/AutoCompleteCity?callback=?&q="+request.term,
					function (data) {
						response(data);
						  /*response(data.map(function (value) {
			                    return {
			                        //'label': '<a href="google.com">' + value + '</a>',
			                        'value':  '<a href="google.com">' + value + '</a>'
			                    };
						  }))*/
					}
			);
		},
		minLength: 3,
		select: function (event, ui) {
			var url = "https://www.google.fr/maps/search/";
			var input = jQuery(".partfour input");
			var form = jQuery(".partfour form");
			var selectedObj = ui.item;
			
			form.attr('action', url + selectedObj.value.replace(/ /g,"+"))
			input.val(selectedObj.value);
			//getcitydetails(selectedObj.value);
			return false;
		},
		open: function () {
			jQuery(this).addClass("ui-corner-top");//.removeClass("ui-corner-all")
		},
		close: function () {
			jQuery(this).removeClass("ui-corner-top").addClass("ui-corner-all");
		}
	});
	jQuery("#f_elem_city").autocomplete("option", "delay", 10);
	
});
