<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css" rel="stylesheet"/>
    <link href="<c:url value="/view/mainstyle.css"/>" rel="stylesheet">
    <style>
        @import url(https://fonts.googleapis.com/css2?family=Work+Sans:wght@300;400;500;600;700&display=swap);
        *{
        }
        body{
            background: #f1fbff;
        }
        .section padding{
            padding: 100px 0;
        }
        .carousel-item{
            height: 100vh;
            min-height: 300px;
        }
        .carousel-caption{
            bottom: 220px;
            z-index: 2;
        }
        .carousel-caption h5{
            font-size: 45px;
            text-transform: uppercase;
            letter-spacing: 2px;
            margin-top: 25px;
        }
        .carousel-caption p{
            width: 60%;
            margin: auto;
            font-size: 15px;
            line-height: 1.9;
        }
        .carousel-inner::before{
            content:"";
            position: absolute;
            width: 100%;
            height: 100%;
            top: 0;
            left: 0;
            background: rgba(0, 0, 0, 0.7);
            z-index: 1;
        }
        .navbar-nav a {
            font-size: 15px;
            text-transform: uppercase;
            font-weight: 500;
        }
        .navbar-light .navbar-brand {
            color: #000;
            font-size: 25px;
            text-transform: uppercase;
            font-weight: bold;
            letter-spacing: 2px;
        }
        .navbar-light .navbar-brand:focus, .navbar-light .navbar-brand:hover {
            color: #000;
        }
        .navbar-light .navbar-nav .nav-link {
            color: #000;
        }
        .navbar-light .navbar-nav .nav-link:focus, .navbar-light .navbar-nav .nav-link:hover {
            color: #000;
        }
        .w-100 {
            height: 100vh;
        }
        @media only screen and (min-width: 768px) and (max-width: 991px) {
            .carousel-caption {
                bottom: 370px;
            }
            .carousel-caption p {
                width: 100%;
            }
            .card {
                margin-bottom: 30px;
            }
            .img-area img {
                width: 100%;
            }
        }
        @media only screen and (max-width: 767px) {
            .navbar-nav {
                text-align: center;
            }
            .carousel-caption {
                bottom: 125px;
            }
            .carousel-caption h5 {
                font-size: 17px;
            }
            .carousel-caption a {
                padding: 10px 15px;
                font-size: 15px;
            }
            .carousel-caption p {
                width: 100%;
                line-height: 1.6;
                font-size: 12px;
            }
            .about-text {
                padding-top: 50px;
            }
            .card {
                margin-bottom: 30px;
            }
        }
        *,
        *::before,
        *::after {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        .avatar-group {
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .avatar {
            position: relative;
            transition: .2s;
            margin-left: 10px;
        }
        .avatar:not(:first-child) {
            margin-left: -1.5rem;
        }
        .avatar:hover {
            z-index: 1;
            transform: translateY(-.5rem);
        }
        .avatar-name {
            position: absolute;
            top: calc(100% + .5rem);
            left: 50%;
            transform: translateX(-50%);
            padding: .5rem .75rem;
            border-radius: .25rem;
            background-color: rgba(0, 0, 0, .7);
            color: #fff;
            font-size: .875rem;
            white-space: nowrap;
            opacity: 0;
            visibility: hidden;
            transition: .2s;
        }
        .avatar:hover .avatar-name {
            opacity: 1;
            visibility: visible;
        }
        .avatar img {
            width: 4rem;
            height: 4rem;
            display: block;
            object-fit: cover;
            border-radius: 50%;
            border: 3px solid #fff;
            box-shadow: 0 .25rem 1rem rgba(0, 0, 0, .1);
        }
        footer {
            background: #101010;
            padding: 86px 0;
        }
        .single-content {
            text-align: center;
            padding: 115px 0;
        }
        .single-box p {
            color: #fff;
            line-height: 1.9;
        }
        .single-box h3 {
            font-size: 16px;
            font-weight: 700;
            color: #fff;
        }
        .single-box .card-area i {
            color: #ffffff;
            font-size: 20px;
            margin-right: 10px;
        }
        .single-box ul {
            list-style: none;
            padding: 0;
        }
        .single-box ul li a {
            text-decoration: none;
            color: #fff;
            line-height: 2.5;
            font-weight: 100;
        }
        .single-box h2 {
            color: #fff;
            font-size: 20px;
            font-weight: 700;
        }
        .socials i {
            font-size: 18px;
            margin-right: 15px;
        }
        .user-login{
            display: none;
        }
    </style>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
    <div class="container">
        <a class="navbar-brand" href="#">WhatTo<span class="text-warning">Eat<i class="fa fa-cutlery"></i></span></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="/whattoeat?action=main">Home<i class='bx bx-home'></i></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/whattoeat?wikipage=1">Wiki<i class='bx bxl-wikipedia' ></i></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Restaurant<i class='bx bxs-food-menu' ></i></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">About us</a>
                </li>
                <li class="nav-item">
                    <form action="/whattoeat?action=login" method="post">
                        <button class="btn btn-danger logout">Log out <i class="fa fa-sign-out"></i></button>
                    </form>
                </li>
            </ul>
        </div>
        <div class="avatar-group">
            <div class="avatar">
                <span class="avatar-name">Hello <c:out value="${user.username}"/></span>
                <img src="https://t3.ftcdn.net/jpg/05/16/27/58/240_F_516275801_f3Fsp17x6HQK0xQgDQEELoTuERO4SsWV.jpg" alt="Image">
            </div>
        </div>
    </div>
</nav>

<div id="carouselExampleCaptions" class="carousel slide">
    <div class="carousel-indicators">
        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
    </div>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="/resources/food3.png" class="d-block w-100">
            <div class="carousel-caption">
                <h5>FOOD WIKI</h5>
                <p>See the culinary all around the world with your own eyes</p>
                <p><a href="/whattoeat?wikipage=1" class="btn btn-warning mt-3">Explore Here</a></p>
            </div>
        </div>
        <div class="carousel-item">
            <img src="/resources/food2.jpg" class="d-block w-100">
            <div class="carousel-caption">
                <h5>RESTAURANT LOCATION</h5>
                <p>Find restaurants that have your selected dish nearby you</p>
                <p><a href="#" class="btn btn-warning mt-3">Look Here</a></p>
            </div>
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>

<footer>
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-sm-6">
                <div class="single-box">
                    <h2>Section</h2>
                    <ul>
                        <li><a href="/whattoeat?action=main">Home</a></li>
                        <li><a href="/whattoeat?wikipage=1">Wiki</a></li>
                        <li><a href="#">Restaurant</a></li>
                        <li><a href="#">About us</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-6 col-sm-6">
            </div>
            <div class="col-lg-3 col-sm-6">
                <div class="single-box socials-box">
                    <h2>Follow us on</h2>
                    <p class="socials">
                        <i class="fa fa-facebook"></i>
                        <i class="fa fa-instagram"></i>
                        <i class="fa fa-telegram"></i>
                        <i class="fa fa-twitter"></i>
                    </p>
                </div>
            </div>
        </div>
    </div>
</footer>
<table class="user-login">
    <tr>
        <td><input name="username" value="<c:out value='${user.username}'/>"></td>
    </tr>
</table>
</body>
</html>

