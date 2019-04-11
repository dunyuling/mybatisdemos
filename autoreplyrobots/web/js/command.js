$(function () {
    basePath = $("#basePath").val();

    deleteOne();
    checkBatch();
    deleteBatch();

    // alert("aaa");


});

var basePath;

function deleteOne() {
    $("a[id^=deleteOne_]").click(function () {

        var confirmed = confirm("确定删除吗");
        if (confirmed) {
            var id = this.id.split('_')[1];
            $.post(basePath + "command/deleteOne.do", {"id": id}, function (response) {
                var respObj = JSON.parse(response);
                if (respObj.code === 0) {
                    $("#command_checkbox_" + id).prop("checked", false);
                    $("#tr_" + id).hide();
                } else {
                    alert('删除失败');
                }
            });
        }
    });
}

var checkAll = false;
function checkBatch() {
    $("#command_checkbox_all").click(function () {
        $('input:checkbox[name=command_checkbox]').each(function() {
            $(this).prop("checked", !checkAll)
        });
        checkAll = !checkAll;
    });
}

function deleteBatch() {
    $("#deleteBatch").click(function () {
        var idsStr = '';
        $('input:checkbox[name=command_checkbox]:checked').each(function (i) {
            idsStr = 0 === i ? idsStr = $(this).val() : idsStr += ',' + $(this).val();
        });

        if ($.trim(idsStr) !== '') {
            var confirmed = confirm("确定删除吗");
            if (confirmed) {
                $.post(basePath + "command/deleteBatch.do", {"ids": idsStr}, function (response) {
                    var respObj = JSON.parse(response);
                    if (respObj.code === 0) {
                        var arr = idsStr.split(',');
                        $(arr).each(function (i) {
                            $("#tr_" + arr[i]).hide();
                        });
                    } else {
                        alert('删除失败');
                    }
                });
            }
        }
    });
}