import axios from 'axios';
import {MessageBox, Message} from 'element-ui';

axios.defaults.headers.post['Content-Type'] = 'application/json';
let instance = axios.create({
  validateStatus: function (status) {
    return status == 200 || status == 400;
  },
});
// Add a response interceptor
instance.interceptors.response.use(function (response) {
  if (response.status == 400) {
    Message.error(response.data.error);
    response.data = null;
  }
  return response;
}, function (error) {
  if (error.message === 'Network Error') {
    MessageBox.alert('回话过期，请重新登录', '提示', {
      confirmButtonText: '确定',
      callback: function () {
        window.location.href = '/';
      }
    });
  }
  // Do something with response error
  return Promise.reject(error);
});

export default instance;
