#!/bin/bash

export PROFILE=true
export PURGE_UMLAUT=true

testfile=data/compounds.txt

for word in `cat $testfile`
do
    echo
    echo $word
    echo
    java -jar bin/composite-split.jar $word
done
