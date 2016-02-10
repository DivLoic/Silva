# Reverse

Readme du 1er exercice du cours technologie web (II.3506 ISEP'2015) pour les étudiants:   
- RASOLOMALALA Narisely (7206)    
- Divad Loïc (8333)   

### Prérequis   

- java
- maven 3   
    
Les versions sur lequelles l'exercice a été vérifié sont les suivantes:
- OS: "mac os x 10.11.2"    
- jdk.1.7.0_79 & jdk.1.8.0_65   
- Apache Maven 3.0.5    
  
### Installation

Une fois décompressé (ou cloné) entrer dans le dossier `Reverse`, et editez les lignes 52 à 57 inclus qui font références aux paramètres liés à votre base de données. l'ordre suivant doit être repecté:    
- ip    
- port    
- schema    
- user    
- password    
- Nom du driver utilisé   

Comme l'exemple suivant:    

```xml
<arguments>
  <argument>127.0.0.1</argument>
  <argument>8081</argument>
  <argument>sakila</argument>
  <argument>root</argument>
  <argument>root</argument>
  <argument>com.mysql.jdbc.Driver</argument>
<arguments>
```

Une fois réalisé les commandes suivante doivent être lancé pour obtenir le script sql:
```shell
mvn install
mvn package
mvn exec:java
```

### Architecture
Nous avons une interface **Structure** de laquelle cinq classes abstaites hériterons :
- Database  
- Table 
- Index 
- ForeignKey  
- Column  

Pour chaque base de donnée il faut étendre ces class (Exemple: Table -> MysqlTable, PostgresTable). C'est dans ce dernier niveau d'héritage qu'est géré la syntaxe. Une instance de `MysqlDatabace` ne créra donc que des intances de MysqlTables et auront donc une implémentation de `toSql()` adaptée à la syntaxe de Mysql.

### Exception :collision:
*Note: dans le cadre de ce devoir seul le cas de la base MySQL a été travaillé. Mais pour donner d'autres exemples, d'autres class et dépendances ont été ajouté. Si le nom du driver est changé le programme renverra une `TooLazyStudentException` pour indiquer ces limites. (voir les autres driver disponible dans le pom.xml)*

### Test
Des tests unitaires réalisés couvrent quelque cas limites pour la syntaxe MySQL.    
Un dossier de ressource est associé aux tests. Il contient 2 fichiers : un fichier `json` et un script `.sqlite` avec lequel nous tentons de réaliser un mock d'une base de données.
