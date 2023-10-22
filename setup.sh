mkdir -p cranfield-collection
cd cranfield-collection
curl -L https://ir.dcs.gla.ac.uk/resources/test_collections/cran/cran.tar.gz | tar xz
cd ..
curl -L https://trec.nist.gov/trec_eval/trec_eval-9.0.7.tar.gz | tar xz
cd trec_eval-9.0.7
make
make quicktest
cd ..