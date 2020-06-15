﻿//Màn hình ADM003////////////////////////////////////////
var isHideJapan = true;
 function showJapan() {
    if(isHideJapan){
     document.getElementById('japan1').classList.remove("japan");
     document.getElementById('japan2').classList.remove("japan");
     document.getElementById('japan3').classList.remove("japan");
     document.getElementById('japan4').classList.remove("japan");
     isHideJapan = false;
     return;
     }
     if(!isHideJapan){
     document.getElementById('japan1').classList.add("japan");
          document.getElementById('japan2').classList.add("japan");
          document.getElementById('japan3').classList.add("japan");
          document.getElementById('japan4').classList.add("japan");
          isHideJapan = true;
     }
 }
 function checkForm() {
     var user = document.form.user.value;
     var group = document.form.group.value;
     var name = document.form.name.value;
     var yearofbirth = document.form.yearofbirth.value;
     var monthofbirth = document.form.monthofbirth.value;
     var dayofbirth = document.form.dayofbirth.value;
     var email = document.form.email.value;
     var phonenumber = document.form.phonenumber.value;
     var password = document.form.password.value;
     var confirmpass = document.form.confirmpass.value;
     var contract = document.form.contract.value;
     var validate = "";
     var flag = true;
     if (user == "") {
         validate += '<h4>Hãy nhập アカウント名</h4>';
         console.log('abc');
         flag = false;
     }
     if (group == "") {
         validate += '<h4>Hãy chọn グループ</h4>';
         flag = false;
     }
     if (name == "") {
         validate += '<h4>Hãy nhập 氏名</h4>';
         flag = false;
     }
     if (yearofbirth == "" || monthofbirth == "" || dayofbirth == "") {
         validate += '<h4>Hãy chọn 生年月日</h4>';
         flag = false;
     }
     if (email == "") {
         validate += '<h4>Hãy nhập メールアドレス</h4>';
         flag = false;
     }
     if (phonenumber == "") {
         validate += '<h4>Hãy nhập 電話番号</h4>';
         flag = false;
     }
     if (password == "") {
         validate += '<h4>Hãy chọn パスワード</h4>';
         flag = false;
     }
     if (confirmpass == "") {
         validate += '<h4>Hãy nhập パスワード（確認）</h4>';
         flag = false;
     }
     if (contract == "") {
         validate += '<h4>Hãy chọn 雇用形態</h4>';
         flag = false;
     }
     document.getElementById('validate').innerHTML = validate;
     return flag;
 }
 var days = ['01',
     '02', '03', '04', '05', '06', '07', '08', '09', 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31
 ]
 function changeMonth(obj, idYear, idDay){
    var year = document.getElementById(idYear).value;
         var result = '';
         function getDay(j) {
             for (var i = 0; i < j; i++) {
                 result += '<option value="' + days[i] + '">' + days[i] + '</option>'
             }
         }
         var choose = obj.value;
         switch (choose) {
             case '01':
             case '03':
             case '05':
             case '07':
             case '08':
             case '10':
             case '12':
                 getDay(31);
                 break;
             case '02':
             if(year%4==0){
                getDay(29);
             }else{
             getDay(28);
             }
                 break;
             default:
                 getDay(30);
                 break;
         }
         document.getElementById(idDay).innerHTML = result;
     }
     function changeYear(idYear, idMonth, idDay){
        changeMonth(document.getElementById(idMonth), idYear,idDay);
     }
 function setYear(){
     var now = new Date();
     var nowYear = now.getFullYear();
     var result = '<option value="1990" selected="selected">1990</option>';
     for(var i = 1991; i<= nowYear; i++){
        result += '<option value="' + i + '">' + i + '</option>';
     }
     document.getElementById('yearofbirth').innerHTML = result;
     document.getElementById('startyear').innerHTML = result;
     document.getElementById('endyear').innerHTML = result;
 }

 //Màn hình ADM004///////////////////////////
 function del(){
 var isDel = confirm('Bạn có muốn xóa không?');
 if(isDel){
 document.getElementById('goADM002').href='01_PhanVanHiep_ADM002.html';
 }
 }
 ////Màn hình ADM002//////
         document.getElementById('check-parent').onclick = function() {
             var x = document.getElementsByClassName('check-child');
             if (document.querySelector('#check-parent').checked) {

                 for (var i = 0; i < x.length; i++) {
                     x[i].checked = "checked";
                 }
             } else {
                 for (var i = 0; i < x.length; i++) {
                     x[i].checked = "";
                 }
             }
         }
         function isCheckParent(){
              var x = document.getElementsByClassName('check-child');
              var cout = 0;
               for (var i = 0; i < x.length; i++) {
                    if(x[i].checked){
                        cout ++;
                    }
           }
           if(cout == x.length){
             document.querySelector('#check-parent').checked="checked";
           }else{
             document.querySelector('#check-parent').checked="";
           }
         }