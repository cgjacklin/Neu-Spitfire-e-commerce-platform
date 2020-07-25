var app    = getApp();
var common = require('../../util/util.js');
// var detail = {
//   data: [
//     {
//       imageList: ["../../image/test.jpg","../../image/test1.jpg",
//         "../../image/test2.jpg","../../image/test3.jpg"
//       ],
//       goodsList: [

//       ]
//     },
//   ]
// }

Page({
  data: {
    indicatorDots: true,
    autoplay: true,
    interval: 5000,
    duration: 1000,
    curNav: "0",
    circular: true,
    List:[],
    // Listimage:["../../image/test.jpg","../../image/test1.jpg",
    // "../../image/test2.jpg","../../image/test3.jpg"],
    Listimage:[],
  },
  onLoad: function(options) {  

    let _url = `http://localhost:8088/product/getProductOnShelf`;
    var List = [];
    var Listimage =[];
  wx.request({
      url: _url, 
      method:"POST",
      dataType: 'json',
      data:{
        user_id: "3",
      },
      header: {
        'Content-Type': 'application/json;charset=UTF-8',
        'Authorization':"Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU5NTc0OTU3MCwiaWF0IjoxNTk1Mzg5NTcwfQ.WVgsE2BWq3p_AZ1q3PlAKsBcGkyKKErZA6oq6ly4gEo"
      },
      success: (res) => {
       List=res.data.data;
       for(var i=0;i<res.data.data.length;i++){
          Listimage.push({
            remark:res.data.data[i].remark
          })
       }
        this.setData({
          List:List,
          Listimage:Listimage,
        });  
      }
    })
  },
  onHide: function() {
  },
  onShow: function() {
  },
  
  switchTab: function(e) {
    var self  = this,
        index = e.currentTarget.dataset.index;
    var info  = detail.data[index];
    info.goodsList.forEach(function(value) {
      value.timer = common.formatTime(new Date(value.beginTime), "yyyy-MM-dd hh:mm");
      self.setData({
        list: info,
        curNav: index
      });
      
    });
  },

  getDetail: function(e) {
    var data      = e.currentTarget.dataset.value;
    wx.navigateTo({
      url: "goodsDetail?title=" + data.title + "&remark=" + data.remark + "&retail_price=" + data.retail_price + "&replenishment_period=" + data.replenishment_period + "&name_en=" + data.name_en+"&brd_id=" + data.brd_id
      +"&pro_id=" + data.pro_id +"&man_id=" + data.man_id+"&sku_cd=" + data.sku_cd,
   
      success: function(res) {
      },
    })
  },
})