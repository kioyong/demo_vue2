import axios from 'axios'
export const getMarkListApi = params => {
  return axios.get(`http://localhost:9001/mark`)
}

export const updateMarkApi = params => {
  return axios.put('http://localhost:9001/mark', params).then(res => res.data)
}
