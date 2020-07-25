var app     = getApp();
var common  = require('../../util/util.js');
var address = {
  "code": 200,
  "requestId": "xxx",
  "data": [
   
    {
      recipient: "唐麒森",
      telephone: 18604013195,
      province: "河南",
      city: "开封市",
      area: "电视塔西路",
      address: "首座时代",
      isDefault: 0
    },
    {
      recipient: "唐麒森",
      telephone: 18604013195,
      province: "辽宁",
      city: "沈阳市",
      area: "浑南区",
      address: "智慧大街",
      isDefault: 1
    },
    {
      recipient: "唐麒森",
      telephone: 18604013195,
      province: "河南",
      city: "开封市",
      area: "龙亭区",
      address: "仁和馨园",
      isDefault: 0
    }
  ],
  "success": true,
  "message": "success"
}
Page({
  data: {},
  onLoad: function() {

  },
  onShow: function(){
    var self = this,
        data = address.data;
    self.setData({
      address: data
    })
  },
  setDefault: function(e) {
    var self    = this,
        bindVal = e.currentTarget.dataset.value.index;
  },
  delAddr: function(e) {
    var id = e.currentTarget.dataset.id;
  },
  editAddr: function(e) {
    var id = e.currentTarget.dataset.id;
    wx.navigateTo({
      url: "editAddr?id=" + id,
      success: function(res) {
      },
    })
  },

  addAddr: function() {
    wx.navigateTo({
      url: "editAddr",
      success: function(res) {
      },
    })
  }

})