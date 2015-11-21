<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Kickstarter пожертвування</title>
    <meta name="generator" content="Bootply"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="/kickstarter/css/bootstrap.min.css" rel="stylesheet">
    <link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <link href="/kickstarter/css/styleforaddnew.css" rel="stylesheet">
</head>
<body>
<header class="navbar navbar-bright navbar-fixed-top" role="banner">
    <div class="container">
        <div class="navbar-header">
            <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Навігація</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <nav class="collapse navbar-collapse" role="navigation">
            <ul class="nav navbar-nav">
                <li>
                    <a href="/kickstarter/" class="navbar-brand">Головна</a>
                </li>
                <li>
                    <a href="/kickstarter/categories" class="navbar-brand">До категорій</a>
                </li>
                <li>
                    <a href="#">Про платформу</a>
                </li>
                <li>
                    <a href="#">Про нас</a>
                </li>
            </ul>
            <ul class="nav navbar-right navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i
                            class="glyphicon glyphicon-search"></i></a>
                    <ul class="dropdown-menu" style="padding:12px;">
                        <form class="form-inline">
                            <button type="submit" class="btn btn-default pull-right"><i
                                    class="glyphicon glyphicon-search"></i></button>
                            <input type="text" class="form-control pull-left" placeholder="Пошук">
                        </form>
                    </ul>
                </li>
            </ul>
        </nav>
    </div>
</header>

<div id="masthead">
    <div class="container">
        <div class="row">
            <div class="col-md-7">
                <h1>Kickstarter
                    <p class="lead"></p>
                </h1>
            </div>
        </div>
    </div>
</div>


<div class="container">
    <div class="row">

        <div class="col-md-12">

            <div class="panel">
                <div class="panel-body">


                    <form:form action="/kickstarter/projects/${project.id}" method="POST">
                    <!--/stories-->
                    <div class="row">
                        <br>

                        <div class="col-md-2 col-sm-3 text-center">
                        </div>
                        <div class="col-md-10 col-sm-9">
                            <div class="col-xs-9">
                                <h3>Жертвування</h3>
                                <hr>
                                <input type="text" class="form-control" name="name" placeholder="Ім'я">
                                <input type="text" class="form-control" name="card" placeholder="Номер картки">
                                <input type="text" class="form-control" name="amount" placeholder="Сума">
                                <hr>
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-9">
                        <a href="/kickstarter/projects/${project.id}" class="btn btn-success pull-right btnNext">Жертвувати<i
                                class="glyphicon glyphicon-plus"></i></a></div>
                </div>
                </form:form>
            </div>


        </div>
    </div>
</div>


<div class="container" id="footer">
    <div class="row">
        <div class="col col-sm-12">

            <h1>Слідкуйте за нами</h1>

            <div class="btn-group">
                <a class="btn btn-twitter btn-lg" href="#"><i class="icon-twitter icon-large"></i> Twitter</a>
                <a class="btn btn-facebook btn-lg" href="#"><i class="icon-facebook icon-large"></i> Facebook</a>
                <a class="btn btn-google-plus btn-lg" href="#"><i class="icon-google-plus icon-large"></i> Google+</a>
            </div>

        </div>
    </div>
</div>

</body>
<footer>
    <div class="container">
        <div class="col-sm-6">
            <h3 class="pull-center foot">&copy; Deuces Inc. 2015. Всі права захищені.</h3>
        </div>
    </div>
    </div>
</footer>
<!-- script references -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>