var app    = getApp();
var common = require('../../util/util.js');
var detail = {
  "data": {
    "details": ["../../image/product.jpg","../../image/product.jpg","../../image/product.jpg"],
    "endTime": 1485070860000,
    "imgBanner": "../../image/product.jpg",
    "oldPrice": "5666",
    "sellPrice": "423",
    // "standard": '[{"1":"m","0":"l","name":"Size","code ":"ys"},{"1":"Blue","0":"Red","name":"Color","code":"ys"}]',
    "standard": '[{"1":"Blue","0":"Red","name":"Color","code":"ys"}]',
    "startTime": 1488866679350,
    "storeTotal": 5,
    "tagline": "brand1_enNEW",
    "title": "111",
  }
}
Page({
  data: {
    indicatorDots: true,
    autoplay: true,
    interval: 5000,
    duration: 1000,
    circular: true,
    isShow: false,
    warning: false,
    warnDes: "",
    number: 1,
    postData: {},
    title:"",
    remark:"",
    retail_price:"",
    replenishment_period:"",
    name_en:"",
    brd_id:"",
    pro_id:"",
    man_id:"1",
    sku_cd:"",
  },
  postData: {},
  onLoad: function(e) {
    var self      = this,
        item      = detail.data;
    item.property = common.goodsPropFilter(item.standard);
    self.setData({
      storeTotal: item.storeTotal,
      item: item,
      imgUrls: common.strToArray(item.imgBanner),
      title:e.title,
      remark:e.remark,
      retail_price:e.retail_price,
      replenishment_period:e.replenishment_period,
      name_en:e.name_en,
      brd_id:e.brd_id,
      pro_id:e.pro_id,
      man_id:e.man_id,
      sku_cd:e.sku_cd,
    })
  },
  onShow: function(e) {
  },
  onHide: function() {
  },
  closeBanner: function() {
    this.setData({
      isShow: false,
    })
  },
  onClickIcon() {

    wx.switchTab({
      url: "../Contacts/contacts",
      success: function(res) {
      },
    })
  },

  onClickButton() {
    wx.showToast({
      title: 'Not yet open',
      icon: 'loading',
      duration: 1000,
      mask:true
    })
  
  },

  checkGoods: function() {
    this.setData({
      isShow: true,
    })
  },


  getChecked: function(e) {
    var self            = this,
        haveCheckedProp = "",
        name            = e.currentTarget.dataset.property,
        value           = e.currentTarget.dataset.value,
        length, objLength;
    self.postData[name] = value;
    length              = self.data.item.property.length;
    objLength = common.objLength(self.postData);
    for(var key in self.postData) {
      haveCheckedProp += " " + self.postData[key];
    }
    if(length == objLength) {
      self.setData({
        getCount: true,
      });
    }
    this.setData({
      postData: self.postData,
      haveCheckedProp: haveCheckedProp
    })
  },

  addOrder: function() {
    var self      = this,
        length    = self.data.item.property.length,   
        objLength = common.objLength(self.data.postData);   
    if(self.data.item.storeTotal == 0) {
      common.alert.call(self, "Not enough stock");
    } else {
      if(length === objLength) {
        var createdate;
        let time_url = `http://localhost:8088/order/getTimestamp`;
        wx.request({
          url: time_url, 
          method:"POST",
          dataType: 'json',
          data:{
          },
          header: {
              'Content-Type': 'application/json;charset=UTF-8',
              'Authorization':"Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU5NTc0OTU3MCwiaWF0IjoxNTk1Mzg5NTcwfQ.WVgsE2BWq3p_AZ1q3PlAKsBcGkyKKErZA6oq6ly4gEo"
          },
          success: (res) => {
            createdate=res.data.timestamp
          }
        })
  let _url = `http://localhost:8088/order/addOrder`;
  wx.request({
      url: _url, 
      method:"POST",
      dataType: 'json',
      data:{
    str_id:2,
    man_id:this.data.man_id,
    pro_id:this.data.pro_id,
    dsr_id:7,
    order_id:"AMAZON",
    sales_price:this.data.retail_price,
    qty:this.data.number,
    sku_no:this.data.sku_cd,
    receive_name:"唐麒森",
    receive_address:"辽宁省沈阳市浑南区东北大学",
    receive_phone:"18604013195",
    sts_cd:"1",
    order_created_time:createdate
      },
      header: {
          'Content-Type': 'application/json;charset=UTF-8',
          'Authorization':"Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU5NTc0OTU3MCwiaWF0IjoxNTk1Mzg5NTcwfQ.WVgsE2BWq3p_AZ1q3PlAKsBcGkyKKErZA6oq6ly4gEo"
      },
      success: (res) => {
       if(res.data.code==200){
       
        wx.switchTab({
          url: "../Product/Product",
          success: function(res) {
          },
        })
         wx.showToast({
          title: 'Order successfully',
          icon: 'success',
          duration: 2000,
          mask:true
        })
       }else{
        wx.showToast({
          title: 'Something wrong happened',
          icon: 'loading',
          duration: 2000,
          mask:true
        })
        wx.switchTab({
          url: "../Product/Product",
          success: function(res) {
          },
        })
        
       }
      }
    })
      } else {
        common.alert.call(self, "Please choose the color");
      }
    }

  },
  addNum: function() {
    var self = this,
        num  = self.data.number;
    if(num + 1 > self.data.item.storeTotal) {
      common.alert.call(self, "replenishment_period");
    } else {
      num += 1;
      self.setData({
        number: num,
      })
    }
  },
  minusNum: function() {
    var self = this,
        num  = self.data.number;
    if(num - 1 < 1) {
      common.alert.call(self, "The Amount must be larger than 1");
    } else {
      num -= 1;
      self.setData({
        number: num,
      })
    }
  }
})