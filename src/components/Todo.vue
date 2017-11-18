
 <template>
  <div class="page lists-show">
    <nav>
      <div class="form list-edit-form" v-show="isUpdate">
        <input type="text" v-model="mark.title"    @keyup.enter="updateTitle" :disabled="mark.locked">
        <div class="nav-group right">
          <a class="nav-item" @click="isUpdate = false">
            <span class="icon-close">
            </span>
          </a>
        </div>
      </div>
      <div class="nav-group" @click="$store.dispatch('updateMenu')" v-show="!isUpdate">
        <a class="nav-item">
          <span class="icon-list-unordered">
          </span>
        </a>
      </div>
      <h1 class="title-page" v-show="!isUpdate" @click="isUpdate = true">
        <span class="title-wrapper">{{mark.title}}</span>
        <span class="count-list">{{mark.item.length}}</span>
      </h1>
      <div class="nav-group right" v-show="!isUpdate">
        <div class="options-web"> 
          <a class=" nav-item"> 
            <span class="icon-lock" v-if="mark.locked"></span>
            <span class="icon-unlock" v-else>
            </span>
          </a>
          <a class=" nav-item">
            <span class="icon-trash">
            </span>
          </a>
        </div>
      </div>
  
      <div class=" form todo-new input-symbol"> 
         <input type="text" v-model="text" placeholder='请输入'@keyup.enter="onAdd" :disabled="mark.locked" />
        <span class="icon-add"></span>
      </div>
    </nav>
    <div class="content-scrollable list-items">
      <!-- <div v-for="item in mark.item"> -->
      <div v-for="(item1,index) in mark.item" :key="index">
        <item :item="item1"></item>
      </div>
    </div>
  </div>
</template>
<script>
import item from './Item'
import { updateMarkApi } from '../api/api'
export default {
  name: 'todo',
  components: {
    item
  },
  data () {
    return {
      mark: {
        id: '1',
        title: '',
        activity: false,
        locaked: false,
        item: []
      },
      text: '',
      isUpdate: false
    }
  },
  // computed: {
  //   mark () {
  //     this.init()
  //   }
  // },
  watch: {
    '$route.params.id' () {
      this.init()
    },
    '$store.state.markList' () {
      this.init()
    }
  },
  methods: {
    init () {
      // if (this.$store.state.markList.length >= this.$route.params.id) {
      this.mark = this.$store.getters.getMarkById(this.$route.params.id)
      this.count = this.mark.item.length
      // }
    },
    onAdd () {
      this.mark.item.push({
        checked: false, text: this.text, activity: false
      })
      updateMarkApi(this.mark).then(res => {
        this.text = ''
      })
    },
    updateTitle () {
      console.log('title = ', this.mark.title)
      updateMarkApi(this.mark).then(res => {
        this.isUpdate = !this.isUpdate
        this.$store.dispatch('markListAsync')
      })
    }
  }
}
</script>
<style lang = "less">
@import '../common/style/nav.less';
@import '../common/style/form.less';
@import '../common/style/todo.less';
</style>