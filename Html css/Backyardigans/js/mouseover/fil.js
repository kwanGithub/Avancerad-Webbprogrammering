window.onload = function(){							//allt inom dessa m�svingar l�ses in n�r sidan l�ses in i webbl�saren
	
	var gmi = document.getElementById("link");
		// denna variable h�mtar v�r img tagg med id "link"
	
	gmi.onmouseover = function(){					// onmouseover s� utf�rs funktionen hover
		hover(this);
	}
	
	gmi.onmouseout = function(){					// onmouseout s� utf�rs funktionen out
		out(this);
	}
}


function hover(element){							//funktionen hover byter bilden till dark_blue.png n�r muspekaren �r �ver img bilden
	element.src = '../../bilder/tyrone/tyrone.jpg';
	
}

function out(element){								//funtkionen out byter bilden till blue.png n�r muspekaren inte �r �ver img bilden
	element.src = '../../bilder/tyrone/tyrone3.jpg';

}








