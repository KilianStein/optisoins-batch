# Change Log
### Correction
Tous les changements notables du projet seront documentés dans ce fichier.
La nomenclature de ce fichier se base sur [KeepAChangelog](http://keepachangelog.com/).

## [Non livré]
### Ajout
- Gestion du ticket moderateur pour l'aide médicale sud : 
	* affichage de texte explicatif sur la feuille de soins
	* calcul du total d'un acte : honoraire + FD - 10% de l'honoraire
	* affichage du total des actes avec les 10% du ticket modérateur et de l'explication du calcul
- Gestion de nouveaux modèles de feuilles de soins. Les nouveaux modèles sont configurables dans optisoins.conf

## [1.3.6] - 2016-09-29
### Ajout
- Affichage d'une popup en cas d'erreur.

### Correction
- Le fichier xls d'exemple des données possèdait deux colonnes "numeroEtat" pour les 100% 

## [1.3.5] - 2016-03-04
### Correction
- Correction de la date de naissance du malade qui ne s'affichait pas.

## [1.3.4] - 2016-03-02
### Ajout
- Mise en place d'un CHANGELOG pour suivre les évolutions.
- Gestion de l'écriture de "oui" ou "non" dans la colonne ticketModerateur : si on veut que "O" ou "N" s'affiche. Si rien n'est écrit alors rien ne s'affichera.
- Possibilité d'avoir deux fichiers excels (si tu veux gérer les cabinets indépendamment).
- Generation de l'etat de l'aide médicale nord + modification du fichiers de données.
- Logo optisoins.
- Génération de la feuille de soins par defaut ainsi que des configurations si le projet est lancé pour la premiere fois.
- Generation de l'etat de l'aide médicale sud.

### Changement
- Non-génération des pdfs si la colonne "nomEtPrenomMalade" n'est pas renseigné dans le xls.
- Mise à jour du fichier de données xls par defaut.
- Séparation de l'onglet aide médical nord et sud avec la mise à jour des colonnes.

### Suppression
- Suppression du parametre "UN_DOSSIER_PAR_EXCEL" qui est realisé automatiquement lorsque deux excels sont présents.

### Correction
- Correction de la date des états à la date du jour.
- Correction technique:  génération des lignes vides de l'etat du nord, si les dates ne sont pas remplis.
- Correction de l'utilitaire sur la conversion de nombres en mots.

## [1.3.3] - 2016-01-07
### Ajout
- Génération de l'état 100%.
- Prise en charge des lignes des données de l'xls avec le même nom.

### Changement
- Changement du nom des fichiers des feuilles de soins.

### Correction
- Correction sur l'affiche de la coche accident qui était toujours coché.

## [1.3.2] - 2016-01-06
### Ajout
- ajout dans la configuration de la marge de spécifier en pixel ou millimetre.

### Correction
- optimisation de la tolérence au décalage.

## [1.3.1] - 2016-01-06
### Ajout
- Ouverture du Dossier de fichiers générés lorsque la génération est terminé sans erreur.

### Correction
- Correction de la génération du total sur les feuilles de soins qui avait disparu.

## [1.3.0] - 2016-01-04
### Changement
- Simplification de l'utilisation du fichier de données xls.

## [1.2.1] - 2015-12-30
### Correction
- Correction d'un problème de AMO : il est possible que l'AMO ne soit pas défini.

## [1.2] - 2015-12-30
### Ajout
- Gestion des actes d'une feuille de soins.
- Generation du fichier de log.
- Mise en place fichier de configuration.
- Ajout de la gestion des marges.

### Correction
- Correction : l'application genere des pdf vides.

## [1.0.1] - 2015-12-21
### Ajout
- Gestion des feuilles de soins.
- Ajout de la gestion des onglets dans le fichiers de données xls.
- Il est possible d'avoir plusieurs fichiers xls.
- Adaptation des fichiers générés à l'imprimante.
- Gestion de la génération des pdf pour plusieurs lignes d'excel.
- Gestion des cases à cocher.
- Création d'un .exe au lieu d'un jar.
