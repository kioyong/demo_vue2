import axios from 'axios'
export const getTodoList = params => {
  return axios.get(`/todo/list`, {
    params: params
  })
}
export const getTodo = params => {
  return axios.get(`/todo/listId`, {
    params: params
  })
}
