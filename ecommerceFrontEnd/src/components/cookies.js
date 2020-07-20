//设置cookie
// export function setCookie ((_keyname, _value, _live) {
    export function setCookie (_keyname, _value) {
        // let d = new Date();
        // d.setDate(d.getDate()+_live);
        // document.cookie = _keyname+"="+_value+";expires="+d.toGMTString();
        document.cookie = _keyname+"="+_value;
    };
    //获取cookie
    export function getCookie(_keyname){
        if (document.cookie.length>0){
            let c_start=document.cookie.indexOf(_keyname + "=")
            if (c_start!=-1){ 
                c_start = c_start + _keyname.length+1 
                let c_end=document.cookie.indexOf(";",c_start)
                if (c_end==-1) c_end=document.cookie.length
                return unescape(document.cookie.substring(c_start,c_end))
            } 
        }
    };
    /*删除cookie*/
    export function delCookie(_keyname) {
        setCookie(_keyname, "", -1)
    };
    