var store = {
    debug: true,
    state: {
      isCollapse: false
    },
    setAction (newValue) {
      if (this.debug) console.log('setAction isCollapse', newValue)
      this.state.isCollapse = newValue
    }
}

export default store