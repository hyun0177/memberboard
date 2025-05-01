document.addEventListener("DOMContentLoaded", function() {
    let isScrolledToBottom = true; // 처음에는 맨 아래로 스크롤되어 있다고 가정

    // 전송 버튼 클릭 이벤트 리스너
    document.getElementById("send-button").addEventListener("click", function() {
        const userInput = document.getElementById("user-input").value; // 사용자 입력 받기

        if (userInput.trim() !== "") { // 공백이 아닌 경우에만 처리
            // 1. 사용자 메시지를 UI에 추가
            const userMessageDiv = document.createElement("div"); // 새 div 생성
            userMessageDiv.classList.add("message", "user-message"); // 사용자 메시지 스타일 추가
            userMessageDiv.innerHTML = `<p><strong>나:</strong> ${userInput}</p>`; // 내용 추가
            document.getElementById("chat-area").appendChild(userMessageDiv); // chat-area에 추가

            // 2. 입력 필드 비우기
            document.getElementById("user-input").value = "";

            // 3. 스크롤을 맨 아래로 이동 (스크롤이 맨 아래에 있을 때만)
            if (isScrolledToBottom) {
                scrollToBottom();
            }

            // 4. 서버로 사용자 메시지 전송
            fetch('http://localhost:8080/chatbot/ask', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({
                    message: userInput
                })
            })
                .then(response => response.json()) // 서버 응답을 JSON으로 받음
                .then(data => {
                    console.log(data);  // 서버 응답을 콘솔에 출력
                    const botMessageDiv = document.createElement("div"); // 새 div 생성
                    botMessageDiv.classList.add("message", "bot-message"); // 봇 메시지 스타일 추가
                    botMessageDiv.innerHTML = `<p><strong>봇:</strong> ${data.message}</p>`; // 봇 응답 추가
                    document.getElementById("chat-area").appendChild(botMessageDiv); // chat-area에 추가

                    // 5. 스크롤을 맨 아래로 이동 (스크롤이 맨 아래에 있을 때만)
                    if (isScrolledToBottom) {
                        scrollToBottom();
                    }
                })
                .catch(error => console.error('Error:', error)); // 오류가 발생하면 콘솔에 출력
        }
    });

    // 감정 분석 버튼 클릭 시 채팅 UI에 감정 분석 결과 표시
    document.getElementById("song-recommendation-button").addEventListener("click", function() {
        // 버튼 클릭 시 서버로 감정 분석 요청
        fetch('http://localhost:8080/chatbot/emotion', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            }
        })
            .then(response => response.json()) // 서버 응답을 JSON으로 받음
            .then(data => {
                // 감정 분석 결과를 UI에 표시
                const emotionMessageDiv = document.createElement("div"); // 새 div 생성
                emotionMessageDiv.classList.add("message", "bot-message"); // 봇 메시지 스타일 추가
                emotionMessageDiv.innerHTML = `<p><strong>봇:</strong> 대화의 감정은: ${data.emotion}</p>`; // 감정 분석 결과 추가
                document.getElementById("chat-area").appendChild(emotionMessageDiv); // chat-area에 추가

                // 5. 스크롤을 맨 아래로 이동 (스크롤이 맨 아래에 있을 때만)
                if (isScrolledToBottom) {
                    scrollToBottom();
                }
            })
            .catch(error => console.error('Error:', error)); // 오류가 발생하면 콘솔에 출력
    });

    // 리셋 버튼 클릭 이벤트 리스너
    document.getElementById("reset-button").addEventListener("click", function() {
        console.log("리셋 버튼 클릭됨");
        // 화면의 대화 내용 초기화
        document.getElementById("chat-area").innerHTML = ""; // 채팅 영역 비우기
        document.getElementById("user-input").value = ""; // 입력 필드 비우기

        // 서버 측 대화 히스토리 초기화 요청
        fetch('http://localhost:8080/chatbot/reset', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
        })
            .then(response => response.json())
            .then(data => {
                console.log("대화 히스토리가 초기화되었습니다.");
                // 리셋 후 첫 번째 시스템 메시지 추가 (UI에도 반영)
                const systemMessageDiv = document.createElement("div");
                systemMessageDiv.classList.add("message", "bot-message");
                systemMessageDiv.innerHTML = `<p><strong>봇:</strong> 안녕하세요! 무엇을 도와드릴까요?</p>`;
                document.getElementById("chat-area").appendChild(systemMessageDiv);
            })
            .catch(error => console.error('리셋 요청 실패:', error));
    });

    // 엔터 키로도 전송 가능하도록 설정
    document.getElementById("user-input").addEventListener("keypress", function(event) {
        if (event.key === "Enter") {
            document.getElementById("send-button").click(); // 엔터키 눌렀을 때 버튼 클릭과 같은 효과
        }
    });

    // 스크롤을 맨 아래로 자동으로 이동시키는 함수
    function scrollToBottom() {
        const chatArea = document.getElementById("chat-area");
        chatArea.scrollTop = chatArea.scrollHeight;
    }

    // 스크롤 이벤트 리스너
    document.getElementById("chat-area").addEventListener("scroll", function() {
        const chatArea = document.getElementById("chat-area");
        // 스크롤이 맨 아래에 있는지 확인
        isScrolledToBottom = chatArea.scrollHeight - chatArea.scrollTop === chatArea.clientHeight;
    });
});
