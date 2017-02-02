

$(function(){
        $('#playForm').on('submit', function(e){
            e.preventDefault();

            $.ajax({
            url: "http://localhost:8080/blackjack/game/create", //process to mail
            data: $('form.playForm').serialize(),
            type: 'POST',
            contentType: "application/json; charset=utf-8",
                success: function(data){
                    alert("ok");
                }
            });
         });
});