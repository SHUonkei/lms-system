# デモ用の環境

ここでは、デモ用の環境を用意する方法について説明します。
Docker Engine と Docker Compose Plugin の環境が必要です。

- <https://docs.docker.com/engine/>
- <https://docs.docker.com/compose/>

カレントディレクトリーを、この README.md ファイルがあるディレクトリーにして作業します。

次の順に説明します。

1. イメージのビルド
2. コンテナーの起動
3. コンテナー起動の確認
4. デモの利用
5. コンテナーの破棄
6. 環境の初期化

参考までに、Linux 環境で、これらの操作時に利用可能なスクリプトを用意して、`script` ディレクトリーにおいてあります。

| スクリプト名 | 説明     |
| ------------ | -------- |
| build.sh     | ビルド用 |
| clean.sh     | 初期化用 |
| down.sh      | 破棄用   |
| run.sh       | 起動用   |

## イメージのビルド

最初にデモ用の Docker イメージを用意する必要があります。そのためには、`docker compose build` コマンドを実行します。

```console
docker compose build
```

次のように、exporting layers、writing image、naming to の行が表示されれば成功です。

```console
$ docker compose build
（略）
[+] Building 2.2s (12/12) FINISHED
 => [lms-system-demo internal] load build definition from Dockerfile.（略）
（略）
 => => exporting layers（略）
 => => writing image sha256:（略）
 => => naming to docker.io/library/lms-system-demo（略）
```

### コンテナーの起動

コンテナーを起動するには `docker compose up -d` コマンドを実行します。

```console
docker compose up -d
```

コンテナーが起動すると、`Container lms-system-demo Started` と表示されます。
実行例を次に示します。

```console
$ docker compose up -d
（略）
[+] Running 1/1
 ✔ Container lms-system-demo  Started
```

### 起動の確認

コンテナーが起動していることを確認するには `docker compose ls` コマンドを使います。
次のように、NAME が `lms-system-demo` の行について、STATUS が `running(1)` となっていれば大丈夫です。

```console
$ docker compose ls
NAME               STATUS      CONFIG FILES
lms-system-demo  running(1)  （略）/lms-system/demo/compose.yaml
```

### デモの利用

コンテナーが起動したら、Web ブラウザで <http://localhost:8080/> へアクセスすると、Spring Web アプリケーションの画面が表示されます。

### コンテナーの破棄

コンテナーを停止するには `docker compose -p jsb-lms2024-demo down` のコマンドを実行します。

```console
docker compose -p jsb-lms2024-demo down
```

実際に実行したときの表示例を次に示します。使用していた Docker コンテナーと Docker ネットワークが Removed されます。

```console
$ docker compose -p jsb-lms2024-demo down
[+] Running 2/2
 ✔ Container lms-system-demo       Removed 0.7s
 ✔ Network lms-system-demo_default Removed 0.4s
```

## 環境の初期化

作成したものを削除して、環境を初期化するには、まず、デモ用のコンテナーを破棄します。

```console
docker compose -p jsb-lms2024-demo down
```

それから、`docker image rm` コマンドで Docker イメージを削除します。

```console
docker image rm lms-system-demo
```
