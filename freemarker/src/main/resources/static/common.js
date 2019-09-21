(function($){
    $.common={

        commonSubmit:function (formId) {
            var _that = this;
            if(!formId){
                formId="updateForm";
            }
            var _action = jQuery("#"+formId).attr("action");
            jQuery("#"+formId).attr("action",_action).submit();
            layer.load(2);
        }
    }

})(window);