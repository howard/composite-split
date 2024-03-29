composite-split
===============

This is a simple tool to split a German compound noun into separate sub-nouns using a wordlist.


Usage
-----

If no wordlist is specified via the `-d` option, `data/german-common-nouns-extended.txt` must be
present relative to the execution directory.

To enable runtime measuring, set environment variable `PROFILE` to `true`. Profiling information
is printed to stderr, so it won't interfere with piping the output to other processes.To replace
umlauts with regular characters, set the environment variable `PURGE_UMLAUT` to `true`. This is
necessary for some wordlists.

Example Usage:
```
java -jar bin/composite-split.jar Donaudampfschifffahrtselektrizitätenhauptbetriebswerkbauunterbeamtengesellschaft
```
```
java -jar -d path/to/my/wordlist.txt Donaudampfschifffahrtselektrizitätenhauptbetriebswerkbauunterbeamtengesellschaft
```

Additionally, there is a `test.sh` script that runs all compound words specified in
`data/compounds.txt`.


TODO
----
*   Extend wordlist with -ung form of common verbs
*   Support irregular pluralization
*   Favor shorter words if this allows finding a following word:

Licensing
---------

The code in this repository is covered by the LICENSE file, except for the files in `data`. Those
files have been taken from various sources under the terms of academic fair use. If you are the
copyright holder and object the use of those files in this context, please get in touch so they can
be taken down.
