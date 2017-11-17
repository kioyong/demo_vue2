import axios from 'axios'
export const getTodoList = params => {
  return axios.get(`http://localhost:9001/mark`)
}
export const getTodo = params => {
  return axios.get(`http://localhost:9001/mark/` + params.id)
}
