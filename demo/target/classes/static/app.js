var app = angular.module('pdfApp', []);

app.controller('PdfController',
function($scope, $http, $sce) {
    $scope.msg = "Angular is working";
    $scope.files = [];
    $scope.loading = false;

    $scope.search = function() {
        $scope.loading = true;
        $http.get('/api/search?keyword='
                + $scope.keyword)

        .then(function(response) {
            $scope.files = response.data;
        })
        .finally(function() {
            $scope.loading = false;
        });
    };

    $scope.openPdf = function(path) {
        var url = '/api/pdf?path='
                    + encodeURIComponent(path);

        $scope.pdfUrl =
            $sce.trustAsResourceUrl(url);
    };

    $scope.totalPdf = 120;
    $scope.searchCount = 45;
    $scope.uploadCount = 12;
    $scope.darkMode = false;

    $scope.toggleTheme = function() {
            $scope.darkMode = !$scope.darkMode;
    };
});