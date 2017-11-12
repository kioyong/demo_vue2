<template>
  <div>
    <h1>This is User {{$route.params.id}} </h1>
    <!-- 如何接收路由参数 -->
  </div>
</template>
<script>
// import VueRouter from 'vue-router'
export default {
  name: 'user'
}
</script>
