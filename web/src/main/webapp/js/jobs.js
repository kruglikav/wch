$(document).ready(function () {

    $("#jobSelect").attr("disabled", true);
    $("#jobTypeSelect").change(function () {

        $("#jobSelect").empty();
        var jobTypeId = this.value;
//        var json = {"jobTypeId": jobTypeId};

        //make the AJAX request, dataType is set to json
        //meaning we are expecting JSON data in response from the server
        $.ajax({
            type: "GET",
            url: "/wch/user/jobList/"+jobTypeId,
//            data: JSON.stringify(json),


            //if received a response from the server
            success: function (data, textStatus, jqXHR) {

                $.each(data, function (index, object) {

                    $('#jobSelect')
                            .append($('<option>', { value: object.id })
                                    .text(object.description));
                });

            },

            //If there was no resonse from the server
            error: function(jqXHR, textStatus, errorThrown){
                alert("Something really bad happened " + textStatus);
//                $("#ajaxResponse").html(jqXHR.responseText);
            },

            //capture the request before it was sent to server
            beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },


            //this is called after the response or error functions are finsihed
            //so that we can take some action
            complete: function (jqXHR, textStatus) {
                //enable the button
                $("#jobSelect").attr("disabled", false);
            }

        });
    });

});