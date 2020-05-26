#!/bin/bash
if [ $# -ne 1 ] 
then
	echo "Voer je naam in als input argument"
	exit 1
elif [ $1 != "Daan" ] && [ $1 != "Joeri" ] && [ $1 != "Marijn" ]
then
	echo "Ongeldige naam pipo"
	exit 1
fi

git checkout master
git pull
fbranch="feature"$1
echo "Nu op featurebranch: "$fbranch
git checkout $fbranch
git merge master