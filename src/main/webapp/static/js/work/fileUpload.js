const fileUpload = {
  upload(files) {
    const formData = new FormData(); // POST방식이 기본, multipart가 기본 설정
    for (const file of files) {
        formData.append("files", file);
    }
  }
};

window.addEventListener("DOMContentLoaded", function() {
    const fileUploads = document.getElementsByClassName("fileUpload");
    const fileEl = document.getElementById("file");

    for (const el of fileUploads) {
        el.addEventListener("click", function() {
            fileEl.click();
        });
    }

    // 파일 탐색기에서 파일 선택 : change 이벤트가 발생
    fileEl.addEventListener("change", function(e) {
        const files = e.target.files;
        fileUpload.upload(files);
    });
});