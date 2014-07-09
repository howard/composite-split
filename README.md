Usage
-----

If no wordlist is specified via the `-d` option, `data/german-common-nouns-extended.txt` must be
present relative to the execution directory.

To enable runtime measuring, set environment variable `PROFILE` to `true`. Profiling information
is printed to stderr, so it won't interfere with piping the output to other processes.To replace
umlauts with regular characters, set the environment variable `PURGE_UMLAUTS` to `true`. This is
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
