#!/bin/bash

PROFILE=true
PURGE_UMLAUTS=true

testfile=data/compounds.txt

for word in `cat $testfile`
do
    echo
    echo $word
    echo
    java -jar bin/composite-split.jar $word
done
