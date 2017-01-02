'use strict'

sampleApp.controller('UserController',['$scope','UserService',function($scope,UserService){
  var self=this;
  self.user={user_id:'',userName:'',type_of_user:'',email_id:'',phone_no:'',password:''};
  self.users=[];
  self.fetchallusers=function(){
    UserService.fetchallusers().then(function(d){
      self.users=d;},
      function(errResponse){
        console.error("Error while fetching users");
      }
    );
  }
}]);
