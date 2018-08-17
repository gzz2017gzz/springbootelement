import moment from 'moment';

export const DATETIME_FORMAT =function (time) {
    return new moment(time).format("YYYY-MM-DD HH:mm:ss")
}


export const DATE_FORMAT =function (time) {
  return new moment(time).format("YYYY-MM-DD")
}

