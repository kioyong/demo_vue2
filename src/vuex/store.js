import Vue from 'vue'
import Vuex from 'vuex'
import { getMarkListApi } from '../api/api'
Vue.use(Vuex)

export const store = new Vuex.Store({
  state: {
    markList: []
  },
  mutations: {
    markList (state, data) {
      state.markList = data
    }
  },
  getters: {
    getMarkById: (state, getters) => (id) => {
      return state.markList.find(mark => mark.id === id)
    },
    getMarkList: state => {
      return state.markList
    }
  },
  actions: {
    // markListAsync ({ commit }) {
      // return new Promise((resolve)=> {
        // getMarkListApi().then(res => {
          // commit('markList', res.data)
          // resolve()
        // })
      // }
    // },
    markListAsync ({ commit }) {
      return new Promise((resolve) => {
        getMarkListApi().then(res => {
          commit('markList', res.data)
          resolve()
        })
      })
    }
  }
})
