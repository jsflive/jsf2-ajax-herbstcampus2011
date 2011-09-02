function processAjaxUpdate(msgId) {
    function processEvent(data) {
        var msg = document.getElementById(msgId);
        if (!data.source.mgPoll) {
            if (data.status == "begin") {
                msg.style.display = '';
            } else if (data.status == "success") {
                setTimeout(function(){hide(msg)}, 500);
            }
        }
    }
    return processEvent;
}

function hide(element) {
    element.style.display = 'none';
}

function registerAjaxStatus(msgId) {
    jsf.ajax.addOnEvent(processAjaxUpdate(msgId));
}
