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

## デモ

## インストール方法
ご自身のデータベースアドレスをJava HttpServlet内の変数、driverUrlに入力の上実行してください。　</br>
`$ git clone https://github.com/C0118128/Training-Record-Servlet.git`

## 作者
* Ryoto

## ライセンス
This sample code is under [MIT license](https://en.wikipedia.org/wiki/MIT_License).
