# TheOne

前不久在简书上看到一哥们写的仿《一个ONE》APP，看了之后觉得这个项目还挺不错的，又加上自己还没怎么正儿八经地用MVP模式写过项目，所以就拿它练手了~

简书传送门:   [http://www.jianshu.com/p/15dc7a464613#](http://www.jianshu.com/p/15dc7a464613#)


##  项目运行效果

![gif1](https://github.com/smashinggit/TheOne/blob/master/gif/gif1.gif)

![gif2](https://github.com/smashinggit/TheOne/blob/master/gif/gif2.gif)

## 分包
![分包](https://github.com/smashinggit/TheOne/blob/master/gif/分包.png)

如何分包？

    经过查阅网上一些MVP的文章之后，有部分案例在presenter中实现具体的逻辑或者把Model单纯的看作是具体的Bean，
    个人觉得是不太准确的，MVX（MVC、MVP和MVVM）中，M的职责都应该包含两部分业务逻辑和提供View显示的数据，而X的
    部分则是为了实现UI界面和业务逻辑解耦的桥梁   
    
    来自 [MVP在Android项目中的简单体现](http://blog.csdn.net/jiujiedexiaoming/article/details/54927617)
    
    
## 项目中使用到的库
 
### 1.  网络请求框架    OkGo
 
   完美支持RxJava，比Retrofit更简单易用
    
   GitHub地址：[https://github.com/jeasonlzy/okhttp-OkGo](https://github.com/jeasonlzy/okhttp-OkGo)
    
    
### 2. LRecyclerView
 
   支持addHeaderView、 addFooterView、下拉刷新、分页加载数据的RecyclerView
   
   GitHub地址: [https://github.com/jdsjlzx/LRecyclerView](https://github.com/jdsjlzx/LRecyclerView)
   
   
### 3. butterknife
 
  一个依赖注入框架，解放你的双手。
  
   GitHub地址:[https://github.com/JakeWharton/butterknife](https://github.com/JakeWharton/butterknife)
   
   
### 4. 插件 MVPHelper
 
   一款Intellj IDEA 和Android Studio的插件，可以为MVP生成接口以及实现类，解放双手。
   
   GitHub地址: [https://github.com/githubwing/MVPHelper](https://github.com/githubwing/MVPHelper)
   
   
### 感谢

  感谢提供Api的哥们
  
  Api地址 ：[https://github.com/jokermonn/-Api/blob/master/ONEv3.5.0~.md](https://github.com/jokermonn/-Api/blob/master/ONEv3.5.0~.md)
  
  
### 说点废话

   1.项目还会持续更新
   
   2.项目仅用于学习和交流，严禁用于任何商业用途
   
   3.水平有限，如果有什么问题可以留言或是qq联系，267049507
   
   4.如果觉得对你有帮助，欢迎点赞和star
   
   
  
  

 
 
 
 
  
  
   
