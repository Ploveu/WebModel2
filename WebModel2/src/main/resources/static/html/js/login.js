var vm = new Vue({
    el:"#page-login",
    data: {
        email:"",
        password:""
    },
    methods:{
        Sign_in:function () {
            alert(this.email+"+"+this.password);

        }
    }

})