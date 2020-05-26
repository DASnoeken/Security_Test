#!/bin/bash
if [ $# -ne 1 ]
then
	echo "Je moet je naam opgeven als input argument"
	exit 1
elif [ $1 != "Daan" ] && [ $1 != "Joeri" ] && [ $1 != "Marijn" ]
then
	echo "Verkeerde naam pipo"
	exit 1
fi
git add .
git commit
./gitU.sh $1
