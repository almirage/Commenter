
var commenter = {};
commenter.display = function(targetel, url, tag){
	$(function(){
		function itemUpdate(data){
			if (data.value != 'ng') {
				var m = eval(data);
				var ulEl = document.createElement("ul");
				document.getElementById(targetel).appendChild(ulEl);
				for (var c in m) {
					var el = document.createElement("li");
					el.appendChild(document.createTextNode(m[c].comment));
					el.appendChild(document.createTextNode(" -- "));
					el.appendChild(document.createTextNode(m[c].name));
					el.appendChild(document.createTextNode(" ("+ m[c].makeDate +") "));
					var delLink = document.createElement("a");
					delLink.href = "javascript:window.confirm('コメントを削除します。(誤クリック防止用確認ウインド)') ? location.href = '/commenter/delete?id="+ m[c].id+"' : false";
					var delStr = document.createTextNode("[del]");
					delLink.style.Color = "#666666";
					delLink.style.fontSize = "75%";
					delLink.appendChild(delStr);
					el.appendChild(delLink);
					ulEl.appendChild(el);
				}
				var fm = document.createElement("form");
				fm.action = "/commenter/comment/post";
				fm.method = "post";
				var inputArea = document.createElement("p");
				fm.appendChild(inputArea);
				var inputNameLabel = document.createElement("span");
				inputNameLabel.appendChild(document.createTextNode("お名前: "));
				inputArea.appendChild(inputNameLabel);
				
				var inputName = createInputElement("text", "name", "inputName");
				inputName.style.fontSize = "100%";
				inputName.style.width = "6em";
				inputName.style.marginRight = "0.5em";
				inputName.value = $.cookie("name") === null ? "" : decodeURI($.cookie("name"));
				inputArea.appendChild(inputName);
				var inputComment = createInputElement("text", "comment", "inputComment");
				inputComment.style.fontSize = "100%";
				inputComment.style.width = "18em";
				inputComment.style.marginRight = "0.5em";
				inputArea.appendChild(inputComment);
				var inputPasswordLabel = document.createElement("span");
				inputPasswordLabel.appendChild(document.createTextNode("削除キー: "));
				inputArea.appendChild(inputPasswordLabel);
				var inputPassword = createInputElement("password", "password", "inputPassword");
				inputPassword.style.fontSize = "100%";
				inputPassword.style.width = "4em";
				inputPassword.value = $.cookie("delkey") === null ? "" : decodeURI($.cookie("delkey"));
				inputArea.appendChild(inputPassword);
				var hiddenUrl = createInputElement("hidden", "url", "");
				hiddenUrl.value = url;
				inputArea.appendChild(hiddenUrl);
				var hiddenTag = createInputElement("hidden", "tag", "");
				hiddenTag.value = tag;
				inputArea.appendChild(hiddenTag);
				var inputSubmit = createInputElement("submit", "post", "");
				inputSubmit.value = "投稿";
				inputSubmit.style.fontSize = "100%";
				inputArea.appendChild(inputSubmit);
				document.getElementById(targetel).appendChild(fm);
				
			}
		}
		$.post("/commenter/thread?url="+ url, {}, itemUpdate);
	})
};
function createInputElement(type, name, styleClass) {
	var r = document.createElement("input");
	r.type = type;
	r.name = name;
	r.className = styleClass;
	return r;
}

commenter.tag = function(targetel, tag, limit, pastLabel) {
	$(function(){
		function itemUpdate(data){
			if (data.value != 'ng') {
				var m = eval(data);
				var ulEl = document.createElement("ul");
				ulEl.style.margin = "0";
				document.getElementById(targetel).appendChild(ulEl);
				for (var c in m) {
					var el = document.createElement("li");
					var ael = document.createElement("a");
					ael.href = m[c].url;
					el.appendChild(ael);
					ael.appendChild(document.createTextNode(m[c].comment.substr(0, 12)));
					ael.appendChild(document.createTextNode(" -- "));
					ael.appendChild(document.createTextNode(m[c].name));
					el.appendChild(document.createTextNode(" ("+ m[c].makeDate +") "));
					ulEl.appendChild(el);
				}
				var el = document.createElement("p");
				var ael = document.createElement("a");
				ael.href = "/commenter/tag/list/?tag="+ tag;
				el.appendChild(ael);
				ael.appendChild(document.createTextNode(pastLabel));
				el.style.margin = "0";
				document.getElementById(targetel).appendChild(el);
			}
		}
		$.post("/commenter/tag?tag="+ tag +"&limit="+ limit, {}, itemUpdate);
	})
};

