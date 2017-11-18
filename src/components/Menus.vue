<template>
  <div class="list-todos">
    <!-- <a class="list-todo list activeListClass" v-for="item in items"  >
      <span class="icon-lock" v-if="item.locked"></span>
      <span class="count-list" v-if="item.count >
      0">{{item.count}}</span>
      {{item.title}}
    </a> -->
    <a @click="goList(mark.id)" class="list-todo list activeListClass" :class="{'active': mark.id === todoId}" v-for="(mark,index) in todoList" :key="index">
      <span class="icon-lock" v-if="mark.locked"></span>
      <span class="count-list" v-if="mark.item.length > 0">{{mark.item.length}}</span>
      {{mark.title}}
    </a>
    <a class=" link-list-new" @click="addList()">
      <span class="icon-plus"></span>新增
    </a>
  </div>
</template>
<script>
// import { getMarkList } from '../api/api'
export default {
  name: 'menus',
  data () {
    return {
      todoId: ''
    }
  },
  computed: {
    todoList () {
      return this.$store.getters.getMarkList
    }
  },
  created () {
    console.log('start get menus')
    this.$store.dispatch('markListAsync').then(() => {
      this.$nextTick(() => {
        this.goList(this.todoList[0].id)
      })
    })
  },
  watch: {
    'todoId' (id) {
      this.$router.push({ name: 'todo', params: { id: id } })
    }
  },
  methods: {
    goList (id) {
      this.todoId = id
    },
    addList () {
      this.items.push(
        { id: this.items.length + 1, count: 3, title: 'new Text', isDelete: false, locked: true }
      )
    }
  }
}
</script>
<style lang="less">
@import '../common/style/menu.less';
</style>