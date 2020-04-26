[TOC]



# 千人千面- PDP模块

代码分支：feature_c20200331_NHK-7431

## PDP You may also like功能

完成度：接口完成了，页面还未对接

```java
代码位置：
PC:com.jumbo.shop.web.controller.product.ItemCrossController#loadUserRecommendationV2
   com.jumbo.shop.manager.recommand.RecommandManagerImpl#recommandHtmlNewV2
Mobile:
com.jumbo.shop.mobile.web.controller.product.MobileItemCrossController#loadUserRecommendation
```

manager走的逻辑相同，只是controller分了PC端和Mobile端

manager逻辑：鞋子未走缓存模式，因为要根据人群分组推送不同的产品；

                            服饰和装备使用了缓存模式，提高页面响应速度；

## PDP 浏览历史

完成度：接口完成，页面还未对接

```javadoc
代码位置：
PC:com.jumbo.shop.web.controller.product.ItemCrossController#loadUserHistoryTour
Mobile: com.jumbo.shop.mobile.web.controller.product.MobileItemCrossController#loadUserHistoryTour
```

PC和Mobile逻辑相同，通过cookie保存最近浏览的sku的code，在用户打开pdp的时候，保存code；

## Enhanced PDP

### PDP页面产品描述动态展示

逻辑：通过 key 去模板库中获取对应的pdp页面详情内容展示

未开发

## PDP 爬虫功能

### 爬虫工具

可以通过skucode或者pdp_url抓取素材，下载压缩包到本地

```java
代码位置 在nike-repo model中
爬虫工具：com.feilong.tools.CrawlerUtil
controller：
com.jumbo.web.controller.pdpMessage.PdpCrawlerInfoController#index
com.jumbo.web.controller.pdpMessage.PdpCrawlerInfoController#downZip
```

### CMS 模板管理修改

背景：可以根据sku的属性来动态的显示pdp页面的产品描述

如图：![image-20200420144326396](C:\Users\jm009218\AppData\Roaming\Typora\typora-user-images\image-20200420144326396.png)

逻辑：

```java
* 1.先保存模板 
	1.1页面输入模板的是特定的pdp页面的模板的路径需要如下格式：
	1.1.1: skucode类型：cms-xxxxxx-xxx/detail.htm eg:cms-SP0040-101/detail.htm
	1.1.2: style类型：cms-xxxxxx/detail.htm       eg:cms-SP0040/detail.htm
	1.1.2: category类型：cms-xxxxxx/detail.htm    eg:cms-kid/detail.htm
* 2.模板保存成功后，先根据key 通过正则识别出是什么类型的
* 3.保存新的标签到标签库
* 4.贴标签
```

完成度：未完成 基本逻辑写好了，剩下调试

代码位置：

```java
controller：com.jumbo.web.controller.newMobileTemplate.NewMobileTemplateController#templateSaveV2
manager: com.jumbo.shop.manager.newMobileTemplate.NewMobileTemplateRelationManager#insertNewMobileTemplateRelationV2
```

