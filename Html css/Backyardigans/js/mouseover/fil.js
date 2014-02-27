window.onload = function(){							//allt inom dessa måsvingar läses in när sidan läses in i webbläsaren
	
	var gmi = document.getElementById("link");
		// denna variable hämtar vår img tagg med id "link"
	
	gmi.onmouseover = function(){					// onmouseover så utförs funktionen hover
		hover(this);
	}
	
	gmi.onmouseout = function(){					// onmouseout så utförs funktionen out
		out(this);
	}
}


function hover(element){							//funktionen hover byter bilden till dark_blue.png när muspekaren är över img bilden
	element.src = '../../bilder/tyrone/tyrone.jpg';
	
}

function out(element){								//funtkionen out byter bilden till blue.png när muspekaren inte är över img bilden
	element.src = '../../bilder/tyrone/tyrone3.jpg';

}








