'use strict'

App.factory('UserService',['$http','$q',function($http,$q){
  console.log("UserService.....")
  var BASE_URL="http://localhost:8081/CollobrationPortal/"
  return{
    fetchallusers:function(){
      return $http.get(BASE_URL + '/customers').then(function(response){
        return response.data;
      },
    function(errResponse){
      console.error('error fetching all users...');
      return $q.reject(errResponse);
    });
  }
};
}]);
