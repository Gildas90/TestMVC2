function _carUtil(){
    this.deletecar=function(id){
        if (confirm("Are you sure?")){
            window.location="/deletecar/"+id;
        }
    }
}

var CarUtil= new _carUtil();