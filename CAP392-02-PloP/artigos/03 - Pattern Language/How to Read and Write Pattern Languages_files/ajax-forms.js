!function(){var e=void 0;!function t(r,n,o){function a(s,u){if(!n[s]){if(!r[s]){var l="function"==typeof e&&e;if(!u&&l)return l(s,!0);if(i)return i(s,!0);var c=new Error("Cannot find module '"+s+"'");throw c.code="MODULE_NOT_FOUND",c}var d=n[s]={exports:{}};r[s][0].call(d.exports,function(e){var t=r[s][1][e];return a(t?t:e)},d,d.exports,t,r,n,o)}return n[s].exports}for(var i="function"==typeof e&&e,s=0;s<o.length;s++)a(o[s]);return a}({1:[function(e,t,r){"use strict";function n(e){function t(){e.setResponse(""),c.start(),r()}function r(){i=!0;var t=new XMLHttpRequest;t.onreadystatechange=function(){if(4==this.readyState)if(u(),this.status>=200&&this.status<400){try{var t=JSON.parse(this.responseText)}catch(r){return console.log('MailChimp for WordPress: failed to parse AJAX response.\n\nError: "'+r+'"'),void e.setResponse(l)}n(t)}else console.log(this.responseText)},t.open("POST",s.ajax_url,!0),t.setRequestHeader("Content-Type","application/x-www-form-urlencoded"),t.send(e.getSerializedData()),t=null}function n(t){if(a.trigger("submitted",[e]),t.error)e.setResponse(t.error.message),a.trigger("error",[e,t.error.errors]);else{var r=e.getData();e.setResponse(t.data.message),t.data.hide_fields&&(e.element.querySelector(".mc4wp-form-fields").style.display="none"),t.data.redirect_to&&(window.location.href=t.data.redirect_to),e.element.reset(),a.trigger("success",[e,r]),a.trigger(t.data.event,[e,r])}}function u(){c.stop(),i=!1}var c=new o(e.element);i||t()}function o(e){function t(){if(n=e.querySelector('input[type="submit"]')){o=n.cloneNode(!0);var t=n.getAttribute("data-loading-text");if(t)return void(n.value=t);var r=window.getComputedStyle(n);n.style.width=r.width,n.value=u,a=window.setInterval(function(){return n.value.length>=5?void(n.value=u):void(n.value+=" "+u)},500)}else e.style.opacity="0.5"}function r(){n?(n.style.width=o.style.width,n.value=o.value,window.clearInterval(a)):e.style.opacity=""}var n,o,a;return{start:t,stop:r}}var a=window.mc4wp.forms,i=!1,s=mc4wp_ajax_vars||{},u=s.loading_character||"·",l='<div class="mc4wp-alert mc4wp-error"><p>'+s.error_text+"</p></div>";a.on("submit",function(e,t){if(!(e.element.getAttribute("class").indexOf("mc4wp-ajax")<0)){try{n(e)}catch(r){return console.error(r),!0}return t.returnValue=!1,t.preventDefault(),!1}})},{}]},{},[1])}();
//# sourceMappingURL=ajax-forms.min.js.map
