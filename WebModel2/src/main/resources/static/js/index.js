var role="";
var name="";

window.onload=function () {
  vm.setUser();
}

var vm = new Vue({
  el:"#user-info",
  data(){
    return{
      Role:'',
      UserName:'',
      num1:"30",
    }
  },
  mounted(){
    this.getUser();
  },
  methods: {
    getUser() {
      $.ajax({
        url: "/admin/GetUserInfo",
        type: "POST",
        dataType: "json",
        success: function (result) {
          console.log(result);
          name=result.username;
          role=result.role;
        },
        error:function(e){
          console.log(e);

        }
      });
    },
    setUser(){
      this.Role=role;
      this.UserName=name;
    }
  }
})