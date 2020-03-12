<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">

<head>
    <title>Proxy Banque</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="css/app-style.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="css/app-style.css">
</head>

<body>
    <div class="container-fluid bg-light">
        <div class="container">
            <nav class="navbar navbar-expand-sm navbar-light">
                <a class="navbar-brand" href="index.jsp">Proxy Banque</a>
                <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse"
                    data-target="#collapsibleNavId" aria-controls="collapsibleNavId" aria-expanded="false"
                    aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="collapsibleNavId">
                    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                        <li class="nav-item">
                            <a class="nav-link" href="authentification.jsp">S'authentifier</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="subscription.jsp">S'enregistrer</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="dropdownId" data-toggle="dropdown"
                                aria-haspopup="true" aria-expanded="false">Mes Comptes</a>
                            <div class="dropdown-menu" aria-labelledby="dropdownId">
                                <a class="dropdown-item" href="clientInfo">List des comptes</a>
                                <a class="dropdown-item" href="nouveauCompte.jsp">Create Un Nouveau Compte</a>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="clientAdmin">Administration</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>

    </div>
    <div class="container mt-5">
        <div class="row">
            <div class="col-6">
                <h4>Les informations du Client</h4>
                <img src="img/Asset01.png"
                    class="img-fluid"
                    alt="">
            </div>
            <div class="col-6">
                <h5>Bienveau a Proxy Bank</h5>
                <div class="py-5">
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Placeat earum quo pariatur rem culpa? Nemo
                    eligendi architecto culpa, cum nulla inventore nisi minus reprehenderit illum voluptas delectus vel
                    ad aut!
                    Delectus, quo. Minima, facere delectus obcaecati voluptas veniam maiores consequatur alias cumque
                    officiis excepturi recusandae itaque ullam culpa commodi et magnam hic voluptates. Magnam neque
                    explicabo, voluptatem illum doloribus dolore.
                    Suscipit veniam consequatur fugiat totam reprehenderit fuga voluptatibus tenetur earum sint sequi
                    explicabo quia commodi, officia, exercitationem voluptates illum veritatis accusantium quam nostrum
                    dicta consequuntur? Dolores tenetur esse natus asperiores?
                </div>
                <a name="" id="" class="btn btn-primary" href="authentification.jsp" role="button">Login</a>
                <a name="" id="" class="btn btn-primary" href="subscription.jsp" role="button">S'enregistrer</a>
            </div>
        </div>
    </div>

    <!--footer-->

    <footer style="background-color: #202020;">
        <div class="container-fluid pt-5 mt-5">
            <div>
                <div class="container text-white">
                    <div class="row mfooter">
                        <div class="col-7">
                            <h3>Proxy Banque</h3>
                        </div>
                        <div class="col-5">
                            <ul>
                                <li>S’authentifier</li>
                                <li>S'enregistrer</li>
                                <li>Mes Comptes
                                    <ul>
                                        <li>List des comptes</li>
                                        <li>Create Un Nouveau Compte</li>
                                    </ul>
                                </li>
                                <li>Administration</li>
                            </ul>
                        </div>
                    </div>

                    <div class="text-white pb-2 pl-5">
                        projet <b>Proxy Banque</b> java ee licda. 2020
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>

</html>