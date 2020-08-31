# 筋トレ記録WEBアプリケーション ~ Training-Record-Servlet ~

## 概要
Web上からトレーニング種目ごとトレーニングの記録を保存・削除・閲覧(全データ閲覧とデータ検索)することができるWEBアプリケーション。データの保存にはデータベースを利用し、端末を問わず記録管理を行える。

## 機能&技術
* アプリケーションの各操作フォーム(HTML)
* データの保存(HTML,Java HttpServlet,データベース,SQL)
* データの削除(HTML,Java HttpServlet,データベース,SQL)
* 全データの閲覧(HTML,Java HttpServlet,データベース,SQL)
* データ検索(HTML,Java HttpServlet,データベース,SQL)

* eclipe上でのアプリケーション実行(Apache Tomcat v8.5)
## デモの目次
***Heroku上でデモを公開しています。***

* [トップ画面](#トップ画面)
* [レコード登録画面](#レコード登録画面)
* [全レコード確認画面](#全レコード確認画面)
* [レコード削除画面](#レコード削除画面)
* [検索画面](#検索画面)

## インストール方法
ご自身のデータベースアドレスをJava HttpServlet内の変数、driverUrlに入力の上実行してください。　</br>
`$ git clone https://github.com/C0118128/Training-Record-Servlet.git`

## 作者
* Ryoto

## ライセンス
This sample code is under [MIT license](https://en.wikipedia.org/wiki/MIT_License).

## デモ
### トップ画面
![トップ画面](https://github.com/C0118128/Training-Record-Servlet/blob/doc/images/%E3%83%88%E3%83%83%E3%83%97%E7%94%BB%E9%9D%A2.png) </br>
[目次へ戻る](#デモの目次)

---

### レコード登録画面
![レコード登録画面入力](https://github.com/C0118128/Training-Record-Servlet/blob/doc/images/%E3%83%AC%E3%82%B3%E3%83%BC%E3%83%89%E7%99%BB%E9%8C%B2%E7%94%BB%E9%9D%A2%E5%85%A5%E5%8A%9B.png) </br>
</br>
![レコード登録画面結果](https://github.com/C0118128/Training-Record-Servlet/blob/doc/images/%E3%83%AC%E3%82%B3%E3%83%BC%E3%83%89%E7%99%BB%E9%8C%B2%E7%94%BB%E9%9D%A2%E7%B5%90%E6%9E%9C.png) </br>
[目次へ戻る](#デモの目次)

---

### 全レコード確認画面
![全レコード確認画面](https://github.com/C0118128/Training-Record-Servlet/blob/doc/images/%E5%85%A8%E3%83%AC%E3%82%B3%E3%83%BC%E3%83%89%E7%A2%BA%E8%AA%8D%E7%94%BB%E9%9D%A2.png) </br>
[目次へ戻る](#デモの目次)

---

### レコード削除画面
![レコード削除画面入力](https://github.com/C0118128/Training-Record-Servlet/blob/doc/images/%E3%83%AC%E3%82%B3%E3%83%BC%E3%83%89%E5%89%8A%E9%99%A4%E7%94%BB%E9%9D%A2%E5%85%A5%E5%8A%9B.png) </br>
</br>
![レコード削除画面結果](https://github.com/C0118128/Training-Record-Servlet/blob/doc/images/%E3%83%AC%E3%82%B3%E3%83%BC%E3%83%89%E5%89%8A%E9%99%A4%E7%94%BB%E9%9D%A2%E7%B5%90%E6%9E%9C.png) </br>
[目次へ戻る](#デモの目次)

---

### 検索画面
![検索画面入力](https://github.com/C0118128/Training-Record-Servlet/blob/doc/images/%E6%A4%9C%E7%B4%A2%E7%94%BB%E9%9D%A2%E5%85%A5%E5%8A%9B.png) </br>
</br>
![検索画面結果](https://github.com/C0118128/Training-Record-Servlet/blob/doc/images/%E6%A4%9C%E7%B4%A2%E7%94%BB%E9%9D%A2%E7%B5%90%E6%9E%9C.png) </br>
[目次へ戻る](#デモの目次)
