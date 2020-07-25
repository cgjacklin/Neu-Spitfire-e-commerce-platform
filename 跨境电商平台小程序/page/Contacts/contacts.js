// pages/contact/contact.js
const app = getApp();
var inputVal = '';
var msgList = [];
var windowWidth = wx.getSystemInfoSync().windowWidth;
var windowHeight = wx.getSystemInfoSync().windowHeight;
var keyHeight = 0;

/**
 * 初始化数据
 */
function initData(that) {
  inputVal = '';

  msgList = [{
      speaker: 'server',
      contentType: 'text',
      content: '您好，有什么可以帮到您的'
    },
  ]
  that.setData({
    msgList,
    inputVal
  })
}

/**
 * 计算msg总高度
 */
// function calScrollHeight(that, keyHeight) {
//   var query = wx.createSelectorQuery();
//   query.select('.scrollMsg').boundingClientRect(function(rect) {
//   }).exec();
// }

Page({

  /**
   * 页面的初始数据
   */
  data: {
    scrollHeight: '100vh',
    inputBottom: 0,
  },

  // submitTo:function(e){
  //   console.log(e)
  //      msgList.push({
  //     speaker: 'customer',
  //     contentType: 'text',
  //     content: e.detail.value
  //   })
  //   inputVal = '';
  //   this.setData({
  //     msgList,
  //     inputVal
  //   });
  //   console.log(e)
  //   let _url = `http://www.tuling123.com/openapi/api`;
  //   wx.request({
  //       url: _url, 
  //       data:{
  //           key: "d13b441029804ee99fc4e3b617a5f557",
  //           info: e.detail.value
  //       },
  //       header: {
  //           'Content-Type': 'application/json'
  //       },
  //       success: function(res) {
  //         let data = res.data;
  //         if(data.code === 100000){
  //           msgList.push({
  //             speaker: 'server',
  //     contentType: 'text',
  //     content: data.text
  //           })
  //           inputVal = '';
  //   this.setData({
  //     msgList,
  //     inputVal
  //   });      
  //         }else{          
  //         }     
  //       }
  //     })
  // },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    initData(this);
    this.setData({
  
    });
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {
  },

  /**
   * 获取聚焦
   */
  focus: function(e) {
    keyHeight = e.detail.height;
    this.setData({
      scrollHeight: (windowHeight - keyHeight) + 'px'
    });
    this.setData({
      toView: 'msg-' + (msgList.length - 1),
      inputBottom: keyHeight + 'px'
    })
    //计算msg高度
    // calScrollHeight(this, keyHeight);

  },

  //失去聚焦(软键盘消失)
  blur: function(e) {
    this.setData({
      scrollHeight: '100vh',
      inputBottom: 0
    })
    this.setData({
      toView: 'msg-' + (msgList.length - 1)
    })

  },

  sendClick: function(e) {
    msgList.push({
      speaker: 'customer',
      contentType: 'text',
      content: e.detail.value
    })
    inputVal = '';
    this.setData({
      msgList,
      inputVal
    });
    let _url = `http://www.tuling123.com/openapi/api`;
    wx.request({
        url: _url, 
        data:{
            key: "dc32930dd93b4da188850f47b35eee30",
            info: e.detail.value
        },
        header: {'Content-Type': 'application/json'},
        success: (res) => {
          let data = res.data;
          console.log(res)
          if(data.code === 100000){
            msgList.push({
              speaker: 'server',
      contentType: 'text',
      content: data.text
            })
            inputVal = '';
            this.setData({
              msgList,
              inputVal
            });   
          }else{ 
            msgList.push({
              speaker: 'server',
      contentType: 'text',
      content: "客服已下班，請改日再來"
            })
            inputVal = '';
            this.setData({
              msgList,
              inputVal
            });           
          }     
        }
      })

  },


  toBackClick: function() {
    wx.navigateBack({})
  }

})
