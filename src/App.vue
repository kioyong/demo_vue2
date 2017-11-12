<template>
  <div id="app">
    <!-- <li v-for="item in items"><router-link :to="item.path" >{{item.message}} </router-link></li> -->
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'app'
}
</script>

<style >
</style>