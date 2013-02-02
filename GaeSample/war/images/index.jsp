<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<meta charset="UTF-8">
<title>イメージサービス</title>
<div>
	<p class="caption">オリジナル画像</p>
	<p class="img"><img src="/images/resize?rate=100"></p>
</div>

<div>
	<p class="caption">縮小：２０％</p>
	<p class="img"><img src="/images/resize?rate=20"></p>
</div>

<div>
	<p class="caption">回転：９０度</p>
	<p class="img"><img src="/images/rotate?degree=90"></p>
</div>

<div>
	<p class="caption">左右反転</p>
	<p class="img"><img src="/images/flip?direction=horizontal"></p>
</div>

<div>
	<p class="caption">上下反転</p>
	<p class="img"><img src="/images/flip?direction=vertical"></p>
</div>

<div>
	<p class="caption">合成</p>
	<p class="img"><img src="/images/composite"></p>
</div>


