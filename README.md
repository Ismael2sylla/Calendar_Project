#PROJET_1

Explication du Code Scala - Application de Calendrier

Ce programme est une application de calendrier en ligne de commande. Il permet à l’utilisateur de :
1. Ajouter un événement avec un nom, une date et un lieu.
2. Afficher tous les événements.
3. Modifier un événement existant.
4. Supprimer un événement.
5. Quitter l’application.

 1. Classe Calendar qui gère les événements
La classe `Calendar` est responsable de la gestion des événements. Elle utilise une liste mutable (`ListBuffer[String]`) pour stocker les événements. Elle dispose des méthodes suivantes :
- `addEvent`: Ajoute un événement avec un nom, une date et un lieu. La date est parsée en utilisant `DateTimeFormatter` et un ID unique est attribué à chaque événement.
- `showEvents`: Affiche tous les événements présents dans le calendrier. Si la liste est vide, elle retourne un message d'erreur.
- `modifyEvent`: Permet de modifier un événement existant en utilisant son ID. Si l'ID est trouvé, les informations de l'événement sont mises à jour.
- `deleteEvent`: Permet de supprimer un événement en utilisant son ID.

La gestion des erreurs est effectuée à l'aide de `Either`, qui permet de renvoyer soit un message de succès (`Right`) soit un message d'erreur (`Left`).

 2. Objet Singleton `CalendarSingleton`
L'objet `CalendarSingleton` garantit qu'il existe une seule instance de la classe `Calendar` dans toute l'application. Cette instance est accessible via la méthode `getInstance`.
Cela permet de centraliser l'accès aux événements et d'éviter la création de multiples instances de `Calendar`, ce qui est essentiel pour la gestion de l'état global du programme.

 3. Interface en ligne de commande (CLI)
L'objet `CalendarCLI` est responsable de l'interface en ligne de commande. Il affiche un menu interactif pour l'utilisateur et prend en charge les différentes options :
- Ajouter un événement.
- Afficher tous les événements.
- Modifier un événement.
- Supprimer un événement.
- Quitter l'application.

L'interface prend les entrées de l'utilisateur, puis appelle les méthodes appropriées de la classe `Calendar`. Les erreurs sont gérées et affichées de manière appropriée à l'utilisateur.

 4. Gestion des exceptions avec `Either`
L'utilisation de `Either` dans ce programme permet de gérer les erreurs de manière explicite. Au lieu d'utiliser des exceptions classiques, chaque méthode qui peut échouer retourne un `Either` :
- `Right`: Indique que l'opération a réussi, et retourne le message ou le résultat souhaité.
- `Left`: Indique qu'une erreur s'est produite, et retourne un message d'erreur détaillé.

Cela permet de gérer les erreurs plus proprement et de rendre le programme plus robuste, notamment en fournissant des retours d'erreurs clairs à l'utilisateur.

 5. Résumé des améliorations
Avec cette refactorisation :
- Le code est mieux organisé grâce à l'utilisation de la classe `Calendar` et de l'objet Singleton.
- La gestion des erreurs est plus claire et explicite grâce à l'utilisation de `Either`.
- L'interface en ligne de commande est séparée du reste du programme, ce qui rend l'application plus modulaire et maintenable.



#PROJET_2


Explication du Code Scala Refactorisé - Application de Calendrier

Ce programme refactorisé est une application de calendrier en ligne de commande. Il permet à l’utilisateur de :
1. Ajouter un événement avec un nom, une date et un lieu.
2. Afficher tous les événements.
3. Modifier un événement existant.
4. Supprimer un événement.
5. Quitter l’application.

Cette version utilise des objets, des classes, un design pattern Singleton, ainsi qu'une gestion des erreurs avec `Either` pour rendre l'application plus maintenable et modulaire.

 1. Classe Calendar
La classe `Calendar` est responsable de la gestion des événements. Elle utilise une liste mutable (`ListBuffer[String]`) pour stocker les événements. Elle dispose des méthodes suivantes :
- `addEvent`: Ajoute un événement avec un nom, une date et un lieu. La date est parsée en utilisant `DateTimeFormatter` et un ID unique est attribué à chaque événement.
- `showEvents`: Affiche tous les événements présents dans le calendrier. Si la liste est vide, elle retourne un message d'erreur.
- `modifyEvent`: Permet de modifier un événement existant en utilisant son ID. Si l'ID est trouvé, les informations de l'événement sont mises à jour.
- `deleteEvent`: Permet de supprimer un événement en utilisant son ID.

La gestion des erreurs est effectuée à l'aide de `Either`, qui permet de renvoyer soit un message de succès (`Right`) soit un message d'erreur (`Left`).

 2. Objet Singleton `CalendarSingleton`
L'objet `CalendarSingleton` garantit qu'il existe une seule instance de la classe `Calendar` dans toute l'application. Cette instance est accessible via la méthode `getInstance`.
Cela permet de centraliser l'accès aux événements et d'éviter la création de multiples instances de `Calendar`, ce qui est essentiel pour la gestion de l'état global du programme.

 3. Interface en ligne de commande (CLI)
L'objet `CalendarCLI` est responsable de l'interface en ligne de commande. Il affiche un menu interactif pour l'utilisateur et prend en charge les différentes options :
- Ajouter un événement.
- Afficher tous les événements.
- Modifier un événement.
- Supprimer un événement.
- Quitter l'application.

L'interface prend les entrées de l'utilisateur, puis appelle les méthodes appropriées de la classe `Calendar`. Les erreurs sont gérées et affichées de manière appropriée à l'utilisateur.

 4. Gestion des exceptions avec `Either`
L'utilisation de `Either` dans ce programme permet de gérer les erreurs de manière explicite. Au lieu d'utiliser des exceptions classiques, chaque méthode qui peut échouer retourne un `Either` :
- `Right`: Indique que l'opération a réussi, et retourne le message ou le résultat souhaité.
- `Left`: Indique qu'une erreur s'est produite, et retourne un message d'erreur détaillé.

Cela permet de gérer les erreurs plus proprement et de rendre le programme plus robuste, notamment en fournissant des retours d'erreurs clairs à l'utilisateur.

 5. Résumé des améliorations
Avec cette refactorisation :
- Le code est mieux organisé grâce à l'utilisation de la classe `Calendar` et de l'objet Singleton.
- La gestion des erreurs est plus claire et explicite grâce à l'utilisation de `Either`.
- L'interface en ligne de commande est séparée du reste du programme, ce qui rend l'application plus modulaire et maintenable.

