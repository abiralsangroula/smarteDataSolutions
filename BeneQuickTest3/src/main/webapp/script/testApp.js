angular.module('bqTestModule', [])
	.controller('FetchController', ['$scope', '$http',
		function($scope, $http) {
			$scope.stateName=null,
			$scope.memberData = [];
			
			$scope.fetchData = function(stateName){
				$http({ method: 'GET', url: 'api/load-data/'+stateName}).then(function(response) {
					console.log(response.data);
					$scope.memberData = response.data;
				}, function(reason) {
					console.log('error ' + reason)
				});
			}

		}]);
