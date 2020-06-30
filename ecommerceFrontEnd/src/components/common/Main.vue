<template>
    <div>
        <Sidebar></Sidebar>
        <div class="right-container" :class="{'collapse-ml': sharedState.state.isCollapse}">
            <Topbar></Topbar>
            <Content></Content>
        </div>
    </div>
</template>

<script>
  import Sidebar from './Sidebar.vue';
  import Topbar from './Topbar.vue';
  import Content from './Content.vue';
    export default {
        data() {
            return {
                sharedState: this.$isCollapse
            }
        },
        components:{
            Sidebar,Topbar,Content
        },
        methods: {
    
        }
    }
</script>

<style scoped>
.right-container{
    min-height: 100%;
    margin-left: 200px;
    transition: margin-left 0.3s;
}
.collapse-ml{
    margin-left: 64px !important;
}
</style>