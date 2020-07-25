var app = getApp()
var common  = require('../../util/util.js');
Page( {
    data: {
        activeNames: ['1'],
        Nickname:"唐麒森",
        Phone:"18604013195",
        Email:"1192185532@qq.com",
        hasLogin: false,
        userInfo: {
            avatarUrl: '../../image/default-head.png',
            nickName: '未登陆'
        },
        userListInfo: [ 
         {
            icon: '../../image/iconfont-card.png',
            text: 'Address',
            isunread: false,
            unreadNum: 2,
            url: "address"
        }]
    },
    onLoad: function() {
        
    },
    onChange(event) {
        this.setData({
          activeNames: event.detail,
        });
      },
    jumpUrl: function(e){
        var url = e.currentTarget.dataset.url;
        wx.navigateTo({
            url: url
        })
    },

})