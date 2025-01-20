import { check, sleep } from "k6";
import http from "k6/http";
import ws from "k6/ws";

const wsUrl = "ws://34.22.108.61:8080/ws/chat";

export let options = {
  stages: [
    { duration: "20s", target: 10 },
    // { duration: "30s", target: 10000 },
    // { duration: "10s", target: 0 },
  ],
};

let websocketConnection = null;

function initializeWebSocketConnection() {
  if (websocketConnection) {
    return websocketConnection;
  }
  const connection = ws.connect(wsUrl, function (socket) {
    socket.on("open", function () {
      socket.send("Hello from k6 WebSocket!");
    });

    socket.on("message", function (message) {});

    socket.on("close", function () {});
  });

  websocketConnection = connection;
  return connection;
}

export default function () {
  websocketTest();
  sleep(3);
}

export function websocketTest() {
  //   initializeWebSocketConnection();
  ws.connect(wsUrl, function (socket) {
    socket.on("open", function () {
      socket.send("Hello from k6!");
    });
  });
}
