sudo su -
sudo apt install make
sudo apt update
sudo apt install build-essential
sudo apt-get install maven
mkdir -p cranfield-collection
cd cranfield-collection
curl -L https://ir.dcs.gla.ac.uk/resources/test_collections/cran/cran.tar.gz | tar xz
cd ..
[[ -d trec_eval-9.0.7 ]] && rm -r trec_eval-9.0.7
curl -L https://trec.nist.gov/trec_eval/trec_eval-9.0.7.tar.gz | tar xz
cd trec_eval-9.0.7
make
make quicktest
cd ..