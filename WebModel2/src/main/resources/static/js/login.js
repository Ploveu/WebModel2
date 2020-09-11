var vm = new Vue({
    el:"#page-login",
    data: {
        email:"",
        password:"",
    },
    methods: {
        Sign_in() {
            console.log(this.email);
            $.ajax({
                url: "/admin/CheckLogin",
                type: "POST",
                dataType: "text",
                data: { email: this.email, password: this.password },
                success: function (result) {
                    console.log(result);
                    if (result=="success"){
                        location.replace("/index.html");
                    }else {

                    }
                },
                error:function(e){
                    console.log(e);
                    // alert("错误"+e.responseText);

                }
            });
        },
    }
})