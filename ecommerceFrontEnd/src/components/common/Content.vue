<template>
  <div class="app-main-container">
    <transition name="fade-transform" mode="out-in">
      <router-view></router-view>
    </transition>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.app-main-container {
  overflow: auto;
  height: calc(100vh - 100px);
  position: relative;
  padding: 20px;
  background-color: rgb(255, 255, 255);
}
</style>