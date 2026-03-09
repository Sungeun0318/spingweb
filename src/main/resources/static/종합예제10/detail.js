console.log('detail.js')

// 1] 쿼리스트링이란? URL(주소) 뒤에?로 매개변수(값) 포함하는 경우
// 2] JS에서 쿼리스트링의 값 가져오는 방법
// new URLSearchParams(location.href).get(변수명);
const bno = new URLSearchParams(location.search).get('bno');
console.log(bno);