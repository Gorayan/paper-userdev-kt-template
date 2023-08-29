# Paper Kotlin Template

Kotlinで作るPaperプラグインのテンプレートリポジトリです。

`paperweight-userdev`を使用しており、NMSコードを扱うことができます。

## Paperweight

* [Githubリポジトリ](https://github.com/PaperMC/paperweight)
* [公式プラグインサンプル](https://github.com/PaperMC/paperweight-test-plugin)

## 設定項目

各プロジェクトごとに変更してください。

### gradle/lib.versions.toml

* `paper` : Paperのバージョン
* `paper-api` : PaperAPIのバージョン ※plugin.ymlで使用

### gradle.properties

* `pluginName` : プラグイン名 ※plugin.ymlで使用
* `pluginVersion` : プラグインのバージョン ※plugin.ymlで使用
* `pluginDescription` : プラグインの説明 ※plugin.ymlで使用
* `mavenGroup` : プロジェクトグループ

## ビルド

`./build/libs`にプラグインが出力されます。

```bash
./gradlew build
```

## テストサーバーを起動

プロジェクトディレクトリの`run`でサーバーが起動します。
ビルドしたプラグインは手動で`plugins`に配置する必要があります。

```bash
./gradlew runServer
```