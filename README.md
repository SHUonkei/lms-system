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

## Systemについて

A lecture management system is a software application that manages information about lectures, students, and instructors. For each lecture, there is detailed information such as the lecture name, classroom, lecture day and time, instructor, and a list of enrolled students. For students, there is detailed information such as name, student ID, and enrolled lectures. For instructors, there is detailed information such as name, instructor ID, and assigned lectures.

### Target Users

- Administrative staff: Maintain student records and manage enrollment data

### ER figure

![image](https://github.com/user-attachments/assets/743f1f23-b2e7-4e4a-b323-a75a3135480c)

## デモ環境について

デモ用の Docker イメージ をビルドして、それを使って Docker コンテナーを起動することで、デモを利用できるようになります.

説明は `demo/README.md` にありますので、そちらを参照してください.

## 開発環境について

我々はdockerの開発コンテナを利用して開発した. 同じ状態で開発環境を用意するには以下の 「dockerの開発コンテナを使う場合」 を参照されたい. 一方で, dockerを使用せずともJavaの開発環境があれば, 開発ができる. その場合については, 後述の「docker を使わない場合」を参照されたい.

### dockerの開発コンテナを使う場合

#### 必要なもの

　devcon-gnpr-202312 を動作をさせるには、Docker、Docker Compose、Visual Studio Code (VS Code) 、Docker 拡張機能、Dev Containers 拡張機能が必要です.

#### Docker

- [Docker Engine](https://docs.docker.com/engine/)
- [Docker Compose](https://docs.docker.com/compose/)

　これらは [Docker Desktop](https://docs.docker.com/desktop/) をインストールしてあれば使えます.Linux では Docker Desktop をインストールしなくても Docker Engine と Docker Compose だけをインストールして使えます.Ubuntuの場合,  [Install Docker Engine on Ubuntu](https://docs.docker.com/engine/install/ubuntu/) を参照してインストールしてください.

#### Visual Studio Code

- [Visual Studio Code](https://code.visualstudio.com/)
- [Docker 拡張機能](https://marketplace.visualstudio.com/items?itemName=ms-azuretools.vscode-docker)
- [Dev Containers 拡張機能](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers)

　VS Code の拡張機能である Docker と Dev Containers を VS Code へインストールしておく必要があります.

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

docker を使わない場合については, 製作者の環境（windows wsl2 ubuntu22,04)にて動作確認済みです.

javaのversionはopenjdk-21-jdkです.

```console
sudo apt install openjdk-21-jdk
```

```console
sudo apt-get update
sudo apt-get upgrade -y
sudo apt-get install -y maven sqlite3
cd backend
mvn clean
mvn install
```

ここで, 複数のversionのjdkを入れている場合, 環境変数JAVA_HOMEを指定して, mvn コマンドを実行するのが確実です. 例えば, jdk17が入っているとmvnがそれを参照してしまうことがあります.

次の例では, ubuntuで, jdk21を使っています.

```console
JAVA_HOME=/usr/lib/jvm/java-1.21.0-openjdk-amd64 mvn install
```

次に, `backend/src/main/resources/application.properties`のを以下のように書き換えます.

```properties
spring.datasource.url=jdbc:sqlite:./db/lmsdb.db
```

`./db/lmsdb.db`このパスは, 絶対パスにする方が確実ですが, 以下のコマンドが`backend`ディレクトリをカレントディレクトリとして実行されることを想定し, 相対パスで指定しています.

単に起動する場合は, 次のコマンドを実行.

```console
mvn spring-boot:run
```

それから, webブラウザで以下のURLにアクセスすることで, アプリを使用できます.

- <http://localhost:8080/>

また, 以下でパッケージ化して、.jarファイルを作成できます,

```console
mvn package
```

これを起動するには以下のコマンドを実行.

```console
java -jar target/backend-0.0.1-SNAPSHOT.jar 
```

同様に, webブラウザで以下のURLにアクセスすることで, アプリを使用できます.

- <http://localhost:8080/>

## 動作イメージ

![image](https://github.com/user-attachments/assets/31a44216-f617-4093-951a-259dca76787c)
![image](https://github.com/user-attachments/assets/ec357b44-9c7f-4cd6-8b7d-5468173b0038)
![image](https://github.com/user-attachments/assets/4d4a27ec-fdbe-4584-95cd-1c05f73531ce)
