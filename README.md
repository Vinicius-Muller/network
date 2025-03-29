# Online Gaming Server - Java Spring Boot

This project is a **Java Spring Boot** based online gaming server that supports both **TCP** and **UDP** connections. It enables continuous connections using **multi-threading**, allowing for independent actions by players in a multiplayer environment.

## 🛠 Features

- **Multi-threading**: Each player has an independent thread for continuous actions without blocking other players.
- **TCP & UDP Support**: Supports both TCP and UDP protocols to allow flexible communication between clients and the server.
- **Continuous Connections**: Players can remain connected to the server, interacting in real time with no interruptions.
- **Matchmaking**: Dynamic player matchmaking, automatically balancing players into sessions for competitive gameplay.
- **Real-time Communication**: Server can send real-time messages to players, including game status, latency (ping), and other updates.

## 🚀 Installation

1. **Clone the repository**:
    ```bash
    git clone https://github.com/your-username/online-gaming-server.git
    cd online-gaming-server
    ```

2. **Build the project**:
    **Gradle**:
    ```bash
    ./gradlew build
    ```

3. **Run the application**:
    ```bash
    ./gradlew bootRun
    ```

4. The server will start running at `http://localhost:8080` by default.

## ⚡ Usage

- **Connecting Players**:
    Players can connect to the server via TCP or UDP based on the protocol chosen during the connection phase.
  
- **Matchmaking**:
    Players will be matched in pairs or groups depending on the game type. Matchmaking occurs as soon as players are available.

- **Ping**:
    The server continuously monitors the latency (ping) for each connected client and sends the ping value in real-time to the player.

- **Multi-threaded Actions**:
    Each player has a dedicated thread for their actions, allowing independent movement and interaction with the game world without blocking others.

## 🎮 Technologies Used

- **Java**: Core programming language for building the server.
- **Spring Boot**: Framework for building the REST API and managing the game server logic.
- **TCP & UDP**: For managing network connections and real-time communication between clients and the server.
- **Multi-threading**: To manage multiple players and their independent actions simultaneously.
