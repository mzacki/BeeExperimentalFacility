$(document).ready( function () {
    var table = $('#beehiveTable').DataTable({
        "sAjaxSource": "getList",
        "sAjaxDataProp": "",
        "order": [[ 0, "asc" ]],
        "aoColumns": [
            { "mData": "id"},
            { "mData": "colour" },
            { "mData": "breed" },
            { "mData": "queen.marking" },
            { "mData": "numbers" },
            { "mData": "nuc" }
        ]
    })
});