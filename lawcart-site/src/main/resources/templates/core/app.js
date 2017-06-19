var app = angular.module('LawMaster', ['ngRoute'])
 .config(['$routeProvider',    function($routeProvider) {     
 
  $routeProvider.
      when('/',{
            templateUrl: 'views/home.html',
            controller: 'expenseController'
           
            }).
      when('/home',{
          templateUrl: 'views/home.html',
          controller: 'expenseController'
            }). 
	  when('/Ask',{
          templateUrl: 'views/Ask-a-Question.html',
          controller: 'expenseController'
            }).
	  when('/Talk',{
          templateUrl: 'views/Talk-to-a-lawyer.html',
          controller: 'expenseController'
            }).
	  when('/Services',{
          templateUrl: 'views/Legal-Services.html',
          controller: 'expenseController'
            }).  
	  when('/Terms',{
          templateUrl: 'views/Terms-of-use.html',
          controller: 'expenseController'
            }). 
	  when('/Privacy',{
          templateUrl: 'views/Privacy-Policy.html',
          controller: 'expenseController'
            }). 
	   when('/Questions',{
          templateUrl: 'views/Questions.html',
          controller: 'expenseController'
            }).
     when('/error', {     
            templateUrl: 'views/home.html',
            controller: 'expenseController'
           
    }).      
otherwise({       
 redirectTo: '/error'      
});   
}
]);
