// 목록으로 버튼 클릭 시 "/" 이동(Get 요청)
const goToList = document.querySelector("#goToList");

// 목록으로 버튼이 클릭 된 경우
goToList.addEventListener("click", function () {
  // "/" 메인페이지 요청(GET 방식)
  location.href = "/";
});

// 할 일 상세 조회 페이지에서 쿼리스트링 값 얻어오기
// url 에서 얻어오면 된다!

// location.search : 쿼리스트링만 얻어오기
// URLSearchParams : 쿼리스트링을 객체 형태로 다룰 수 있는 객체
const todoNo = new URLSearchParams(location.search).get("todoNo");


// 완료 여부 변경
const completeBtn = document.querySelector("#completeBtn");

// 완료 여부 변경 버튼 클릭 시
completeBtn.addEventListener("click", () => {

  // 현재 보고있는 Todo의 완료 여부를
  // O(true) <-> X(false) 변경 요청하기 (GET 요청)
  location.href = "/todo/complete?todoNo=" + todoNo;


});
// 삭제 버튼
// 수정 버튼
const updateBtn = document.querySelector("#updateBtn");

// 수정 버튼 클릭 시 제목과 내용을 input 과 textarea로 변경하기

updateBtn.addEventListener("click", () => {
  document.querySelector(".btn-container2").classList.remove("hidden")
  document.querySelector(".btn-container").classList.add("hidden")

  const title = document.querySelector(".title").addEventListener("click", () => {
    document.querySelector(".inputTitle").innerText = document.querySelector(".title").value
    document.querySelector(".title").classList.add("hidden")
    document.querySelector(".inputTitle").classList.remove("hidden")
  });
  
  const detail = document.querySelector(".content").addEventListener("click", () => {
    document.querySelector(".content").classList.add("hidden")
    document.querySelector(".content2").classList.remove("hidden")
  });
});


const saveBtn = document.querySelector("#saveBtn");

saveBtn.addEventListener("click", () => {

  const title = document.querySelector(".inputTitle").value;
  const detail = document.querySelector(".updateDetail").value;

  location.href = "/todo/update?todoNo=" + todoNo + "&title=" + title + "&detail=" + detail;

});

backBtn.addEventListener("click", () => {

  document.querySelector(".title").classList.remove("hidden")
  document.querySelector(".inputTitle").classList.add("hidden")
  document.querySelector(".btn-container2").classList.add("hidden")
  document.querySelector(".btn-container").classList.remove("hidden")

  document.querySelector(".content").classList.remove("hidden")
  document.querySelector(".content2").classList.add("hidden")


});

const deleteBtn = document.querySelector("#deleteBtn");
deleteBtn.addEventListener("click", () => {

  // 정말 삭제할 것인지 confirm() 을 이용해서 확인
  // confirm() 은 확인 클릭시 true, 취소 클릭시 false 반환

  // 취소 클릭시
  if(!confirm("정말 삭제하시겠습니까?")) return; 
  
  // 확인 클릭시
  // /todo/delete?todoNo=1 Get 방식 요청 보내기
 
    location.href = "/todo/delete?todoNo=" + todoNo;
 

});

// const updateBtn = document.querySelector("#updateBtn");
// updateBtn.addEventListener("click", () => {
//   // 수정 페이지로 이동
//   location.href = "/todo/update?todoNo=" + todoNo;
// });