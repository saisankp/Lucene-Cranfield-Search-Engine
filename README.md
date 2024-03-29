# Apache Lucene Search Engine for the Cranfield Collection
This project uses Java 1.8 and Apache Lucene 8.11.2 to index the [Cranfield Collection](https://ir.dcs.gla.ac.uk/resources/test_collections/cran/), search the generated index and score my search engine using the queries provided in the Cranfield Collection. For details on my implementation, view my [report](https://github.com/saisankp/Lucene-Cranfield-Search-Engine/blob/main/report/report.pdf).

# Setting up trec_eval
In this codebase, trec_eval is a git submodule. To setup trec_eval for your machine, run these commands:

```
git submodule update --init
cd trec_eval
make
make quicktest
cd ..
```

# How to run the code
```
chmod +x run.sh
./run.sh
```

# How to setup the project
The project is already setup. But if you're curious, you can run the commands I did to setup trec_eval and get the cranfield collection using:
```
chmod +x setup.sh
./setup.sh
```

# Useful information

The QRELS file in the Cranfield Collection will not be in the correct format for trec_eval, so I got QRelsCorrectedforTRECeval instead from [here][link] (only Trinity College Dublin email addresses can access this Google Drive folder).

Also, If you are setting up the git submodule for trec_eval for the first time, you may get a trec_eval.diff being tracked which won't go away. Simply make a .gitignore inside the trec_eval folder and put the wildcard '*' inside.

# Results
![visualization](https://github.com/saisankp/Lucene-Cranfield-Search-Engine/assets/34750736/533a3528-d7cb-4805-8beb-784b8dc53e13)


[link]: https://drive.google.com/drive/folders/1W7Sey6hIJl8nemj1pmRUnnDoXXEZuk1O?usp=sharing]
