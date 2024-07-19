# school assignments

Java Spring Boot Lecture management system

```text
lmssystem/
├── Dockerfile ... 開発用 Dockerfile
├── Dockerfile.demo ... デモ用 Dockerfile
├── README.md ... このファイル
├── backend/ ... Java Maven プロジェクト
├── compose.yaml ... 開発用 compose ファイル
└── demo/ ... デモ用
```

## デモ環境について

デモ用の Docker イメージ をビルドして、それを使って Docker コンテナーを起動することで、デモを利用できるようになります。

説明は `demo/README.md` にありますので、そちらを参照してください。

## System

A lecture management system is a software application that manages information about lectures, students, and instructors. For each lecture, there is detailed information such as the lecture name, classroom, lecture day and time, instructor, and a list of enrolled students. For students, there is detailed information such as name, student ID, and enrolled lectures. For instructors, there is detailed information such as name, instructor ID, and assigned lectures.

## Target Users

- Administrative staff: Maintain student records and manage enrollment data

## er figure

![image](https://github.com/user-attachments/assets/743f1f23-b2e7-4e4a-b323-a75a3135480c)

## 開発環境構築

### dockerの開発コンテナを使う場合

#### 必要なもの

　devcon-gnpr-202312 を動作をさせるには、Docker、Docker Compose、Visual Studio Code (VS Code) 、Docker 拡張機能、Dev Containers 拡張機能が必要です。

#### Docker

- [Docker Engine](https://docs.docker.com/engine/)
- [Docker Compose](https://docs.docker.com/compose/)

　これらは [Docker Desktop](https://docs.docker.com/desktop/) をインストールしてあれば使えます。Linux では Docker Desktop をインストールしなくても Docker Engine と Docker Compose だけをインストールして使えます。Ubuntuの場合,  [Install Docker Engine on Ubuntu](https://docs.docker.com/engine/install/ubuntu/) を参照してインストールしてください。

#### Visual Studio Code

- [Visual Studio Code](https://code.visualstudio.com/)
- [Docker 拡張機能](https://marketplace.visualstudio.com/items?itemName=ms-azuretools.vscode-docker)
- [Dev Containers 拡張機能](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers)

　VS Code の拡張機能である Docker と Dev Containers を VS Code へインストールしておく必要があります。

### 使い方

```console
mkdir target
code .
```

vscodeが起動すると,  右下に通知が表示されるので, その中の, 「再度コンテナで開く」をクリックします.すると, 開発コンテナにアタッチしたvscodeの画面になります. それから,  コンテナ内でターミナルを開き, 以下のコマンドを実行してください.

```console
cd /app
mvn clean
mvn install
```

以上で準備が完了したので, 以下でパッケージ化して、.jarファイルを作成できます,

```console
mvn package
```

単に起動する場合は, 次のコマンドを実行.

```console
mvn spring-boot:run
```

それから, webブラウザで以下のURLにアクセスすることで, アプリを使用できます.

- <http://localhost:8080/>

### docker を使わない場合

製作者二人（windows wsl2 ubuntu22,04, MAC OS)にて動作確認済みです.

```console
apt-get update
apt-get upgrade -y
apt-get install -y maven sqlite3
cd backend
mvn clean
mvn install
```

以下でパッケージ化して、.jarファイルを作成できます,

```console
mvn package
```

単に起動する場合は, 次のコマンドを実行.

```console
mvn spring-boot:run
```

それから, webブラウザで以下のURLにアクセスすることで, アプリを使用できます.

- <http://localhost:8080/>

## 動作イメージ

![image](https://github.com/user-attachments/assets/31a44216-f617-4093-951a-259dca76787c)
![image](https://github.com/user-attachments/assets/ec357b44-9c7f-4cd6-8b7d-5468173b0038)
![image](https://github.com/user-attachments/assets/4d4a27ec-fdbe-4584-95cd-1c05f73531ce)
