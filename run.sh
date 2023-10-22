# Compile source code and package into JAR
mvn compile
mvn package

# Use standard analyzer to index the Cranfield Collection
java -jar target/CS7IS3-Assignment1-Prathamesh-0.0.1-SNAPSHOT.jar --operation index StandardAnalyzer

# Evaluate with StandardAnalyzer
echo "StandardAnalyzer + BM25 + QueryParser"
java -jar target/CS7IS3-Assignment1-Prathamesh-0.0.1-SNAPSHOT.jar --operation evaluate StandardAnalyzer BM25 QueryParser
standardBM25ParserMAP=$(./trec_eval-9.0.7/trec_eval -m map cranfield-collection/QRelsCorrectedforTRECeval evaluation/scores | grep -oE '[0-9]+([.][0-9]+)?')
echo "MAP: $standardBM25ParserMAP"
standardBM25ParserSetRecall=$(./trec_eval-9.0.7/trec_eval -m set_recall cranfield-collection/QRelsCorrectedforTRECeval evaluation/scores | grep -oE '[0-9]+([.][0-9]+)?')
echo "Set_Recall: $standardBM25ParserSetRecall"

echo "StandardAnalyzer + BM25 + MultiFieldQueryParser"
java -jar target/CS7IS3-Assignment1-Prathamesh-0.0.1-SNAPSHOT.jar --operation evaluate StandardAnalyzer BM25 MultiFieldQueryParser
standardBM25MultiFieldParserMAP=$(./trec_eval-9.0.7/trec_eval -m map cranfield-collection/QRelsCorrectedforTRECeval evaluation/scores | grep -oE '[0-9]+([.][0-9]+)?')
echo "MAP: $standardBM25MultiFieldParserMAP"
standardBM25MultiFieldParserSetRecall=$(./trec_eval-9.0.7/trec_eval -m set_recall cranfield-collection/QRelsCorrectedforTRECeval evaluation/scores | grep -oE '[0-9]+([.][0-9]+)?')
echo "Set_Recall: $standardBM25MultiFieldParserSetRecall"

echo "StandardAnalyzer + VSM + QueryParser"
java -jar target/CS7IS3-Assignment1-Prathamesh-0.0.1-SNAPSHOT.jar --operation evaluate StandardAnalyzer VSM QueryParser
standardVSMParserMAP=$(./trec_eval-9.0.7/trec_eval -m map cranfield-collection/QRelsCorrectedforTRECeval evaluation/scores | grep -oE '[0-9]+([.][0-9]+)?')
echo "MAP: $standardVSMParserMAP"
standardVSMParserSetRecall=$(./trec_eval-9.0.7/trec_eval -m set_recall cranfield-collection/QRelsCorrectedforTRECeval evaluation/scores | grep -oE '[0-9]+([.][0-9]+)?')
echo "Set_Recall: $standardVSMParserSetRecall"

echo "StandardAnalyzer + VSM + MultiFieldQueryParser"
java -jar target/CS7IS3-Assignment1-Prathamesh-0.0.1-SNAPSHOT.jar --operation evaluate StandardAnalyzer VSM MultiFieldQueryParser
standardVSMMultiFieldParserMAP=$(./trec_eval-9.0.7/trec_eval -m map cranfield-collection/QRelsCorrectedforTRECeval evaluation/scores | grep -oE '[0-9]+([.][0-9]+)?')
echo "MAP: $standardVSMMultiFieldParserMAP"
standardVSMMultiFieldParserSetRecall=$(./trec_eval-9.0.7/trec_eval -m set_recall cranfield-collection/QRelsCorrectedforTRECeval evaluation/scores | grep -oE '[0-9]+([.][0-9]+)?')
echo "Set_Recall: $standardVSMMultiFieldParserSetRecall"

echo "StandardAnalyzer + LMDirichlet + QueryParser"
java -jar target/CS7IS3-Assignment1-Prathamesh-0.0.1-SNAPSHOT.jar --operation evaluate StandardAnalyzer LMDirichlet QueryParser
standardLMDirichletParserMAP=$(./trec_eval-9.0.7/trec_eval -m map cranfield-collection/QRelsCorrectedforTRECeval evaluation/scores | grep -oE '[0-9]+([.][0-9]+)?')
echo "MAP: $standardLMDirichletParserMAP"
standardLMDirichletParserSetRecall=$(./trec_eval-9.0.7/trec_eval -m set_recall cranfield-collection/QRelsCorrectedforTRECeval evaluation/scores | grep -oE '[0-9]+([.][0-9]+)?')
echo "Set_Recall: $standardLMDirichletParserSetRecall"

echo "StandardAnalyzer + LMDirichlet + MultiFieldQueryParser"
java -jar target/CS7IS3-Assignment1-Prathamesh-0.0.1-SNAPSHOT.jar --operation evaluate StandardAnalyzer LMDirichlet MultiFieldQueryParser
standardLMDirichletMultiFieldParserMAP=$(./trec_eval-9.0.7/trec_eval -m map cranfield-collection/QRelsCorrectedforTRECeval evaluation/scores | grep -oE '[0-9]+([.][0-9]+)?')
echo "MAP: $standardLMDirichletMultiFieldParserMAP"
standardLMDirichletMultiFieldParserSetRecall=$(./trec_eval-9.0.7/trec_eval -m set_recall cranfield-collection/QRelsCorrectedforTRECeval evaluation/scores | grep -oE '[0-9]+([.][0-9]+)?')
echo "Set_Recall: $standardLMDirichletMultiFieldParserSetRecall"

echo "StandardAnalyzer + LMJelinekMercer + QueryParser"
java -jar target/CS7IS3-Assignment1-Prathamesh-0.0.1-SNAPSHOT.jar --operation evaluate StandardAnalyzer LMJelinekMercer QueryParser
standardLMJelinekMercerParserMAP=$(./trec_eval-9.0.7/trec_eval -m map cranfield-collection/QRelsCorrectedforTRECeval evaluation/scores | grep -oE '[0-9]+([.][0-9]+)?')
echo "MAP: $standardLMJelinekMercerParserMAP"
standardLMJelinekMercerParserSetRecall=$(./trec_eval-9.0.7/trec_eval -m set_recall cranfield-collection/QRelsCorrectedforTRECeval evaluation/scores | grep -oE '[0-9]+([.][0-9]+)?')
echo "Set_Recall: $standardLMJelinekMercerParserSetRecall"

echo "StandardAnalyzer + LMJelinekMercer + MultiFieldQueryParser"
java -jar target/CS7IS3-Assignment1-Prathamesh-0.0.1-SNAPSHOT.jar --operation evaluate StandardAnalyzer LMJelinekMercer MultiFieldQueryParser
standardLMJelinekMercerMultiFieldParserMAP=$(./trec_eval-9.0.7/trec_eval -m map cranfield-collection/QRelsCorrectedforTRECeval evaluation/scores | grep -oE '[0-9]+([.][0-9]+)?')
echo "MAP: $standardLMJelinekMercerMultiFieldParserMAP"
standardLMJelinekMercerMultiFieldParserSetRecall=$(./trec_eval-9.0.7/trec_eval -m set_recall cranfield-collection/QRelsCorrectedforTRECeval evaluation/scores | grep -oE '[0-9]+([.][0-9]+)?')
echo "Set_Recall: $standardLMJelinekMercerMultiFieldParserSetRecall"

# Use my cranfield analyzer to index the cranfield collection
java -jar target/CS7IS3-Assignment1-Prathamesh-0.0.1-SNAPSHOT.jar --operation index CranfieldAnalyzer

# Evaluate with my cranfield analyzer
echo "StandardAnalyzer + BM25 + QueryParser"
java -jar target/CS7IS3-Assignment1-Prathamesh-0.0.1-SNAPSHOT.jar --operation evaluate CranfieldAnalyzer BM25 QueryParser
cranfieldBM25ParserMAP=$(./trec_eval-9.0.7/trec_eval -m map cranfield-collection/QRelsCorrectedforTRECeval evaluation/scores | grep -oE '[0-9]+([.][0-9]+)?')
echo "MAP: $cranfieldBM25ParserMAP"
cranfieldBM25ParserSetRecall=$(./trec_eval-9.0.7/trec_eval -m set_recall cranfield-collection/QRelsCorrectedforTRECeval evaluation/scores | grep -oE '[0-9]+([.][0-9]+)?')
echo "Set_Recall: $cranfieldBM25ParserSetRecall"

echo "StandardAnalyzer + BM25 + MultiFieldQueryParser"
java -jar target/CS7IS3-Assignment1-Prathamesh-0.0.1-SNAPSHOT.jar --operation evaluate CranfieldAnalyzer BM25 MultiFieldQueryParser
cranfieldBM25MultiFieldParserMAP=$(./trec_eval-9.0.7/trec_eval -m map cranfield-collection/QRelsCorrectedforTRECeval evaluation/scores | grep -oE '[0-9]+([.][0-9]+)?')
echo "MAP: $cranfieldBM25MultiFieldParserMAP"
cranfieldBM25MultiFieldParserSetRecall=$(./trec_eval-9.0.7/trec_eval -m set_recall cranfield-collection/QRelsCorrectedforTRECeval evaluation/scores | grep -oE '[0-9]+([.][0-9]+)?')
echo "Set_Recall: $cranfieldBM25MultiFieldParserSetRecall"

echo "StandardAnalyzer + VSM + QueryParser"
java -jar target/CS7IS3-Assignment1-Prathamesh-0.0.1-SNAPSHOT.jar --operation evaluate CranfieldAnalyzer VSM QueryParser
cranfieldVSMParserMAP=$(./trec_eval-9.0.7/trec_eval -m map cranfield-collection/QRelsCorrectedforTRECeval evaluation/scores | grep -oE '[0-9]+([.][0-9]+)?')
echo "MAP: $cranfieldVSMParserMAP"
cranfieldVSMParserSetRecall=$(./trec_eval-9.0.7/trec_eval -m set_recall cranfield-collection/QRelsCorrectedforTRECeval evaluation/scores | grep -oE '[0-9]+([.][0-9]+)?')
echo "Set_Recall: $cranfieldVSMParserSetRecall"

echo "StandardAnalyzer + VSM + MultiFieldQueryParser"
java -jar target/CS7IS3-Assignment1-Prathamesh-0.0.1-SNAPSHOT.jar --operation evaluate CranfieldAnalyzer VSM MultiFieldQueryParser
cranfieldVSMMultiFieldParserMAP=$(./trec_eval-9.0.7/trec_eval -m map cranfield-collection/QRelsCorrectedforTRECeval evaluation/scores | grep -oE '[0-9]+([.][0-9]+)?')
echo "MAP: $cranfieldVSMMultiFieldParserMAP"
cranfieldVSMMultiFieldParserSetRecall=$(./trec_eval-9.0.7/trec_eval -m set_recall cranfield-collection/QRelsCorrectedforTRECeval evaluation/scores | grep -oE '[0-9]+([.][0-9]+)?')
echo "Set_Recall: $cranfieldVSMMultiFieldParserSetRecall"

echo "StandardAnalyzer + LMDirichlet + QueryParser"
java -jar target/CS7IS3-Assignment1-Prathamesh-0.0.1-SNAPSHOT.jar --operation evaluate CranfieldAnalyzer LMDirichlet QueryParser
cranfieldLMDirichletParserMAP=$(./trec_eval-9.0.7/trec_eval -m map cranfield-collection/QRelsCorrectedforTRECeval evaluation/scores | grep -oE '[0-9]+([.][0-9]+)?')
echo "MAP: $cranfieldLMDirichletParserMAP"
cranfieldLMDirichletParserSetRecall=$(./trec_eval-9.0.7/trec_eval -m set_recall cranfield-collection/QRelsCorrectedforTRECeval evaluation/scores | grep -oE '[0-9]+([.][0-9]+)?')
echo "Set_Recall: $cranfieldLMDirichletParserSetRecall"

echo "StandardAnalyzer + LMDirichlet + MultiFieldQueryParser"
java -jar target/CS7IS3-Assignment1-Prathamesh-0.0.1-SNAPSHOT.jar --operation evaluate CranfieldAnalyzer LMDirichlet MultiFieldQueryParser
cranfieldLMDirichletMultiFieldParserMAP=$(./trec_eval-9.0.7/trec_eval -m map cranfield-collection/QRelsCorrectedforTRECeval evaluation/scores | grep -oE '[0-9]+([.][0-9]+)?')
echo "MAP: $cranfieldLMDirichletMultiFieldParserMAP"
cranfieldLMDirichletMultiFieldParserSetRecall=$(./trec_eval-9.0.7/trec_eval -m set_recall cranfield-collection/QRelsCorrectedforTRECeval evaluation/scores | grep -oE '[0-9]+([.][0-9]+)?')
echo "Set_Recall: $cranfieldLMDirichletMultiFieldParserSetRecall"

echo "StandardAnalyzer + LMJelinekMercer + QueryParser"
java -jar target/CS7IS3-Assignment1-Prathamesh-0.0.1-SNAPSHOT.jar --operation evaluate CranfieldAnalyzer LMJelinekMercer QueryParser
cranfieldLMJelinekMercerParserMAP=$(./trec_eval-9.0.7/trec_eval -m map cranfield-collection/QRelsCorrectedforTRECeval evaluation/scores | grep -oE '[0-9]+([.][0-9]+)?')
echo "MAP: $cranfieldLMJelinekMercerParserMAP"
cranfieldLMJelinekMercerParserSetRecall=$(./trec_eval-9.0.7/trec_eval -m set_recall cranfield-collection/QRelsCorrectedforTRECeval evaluation/scores | grep -oE '[0-9]+([.][0-9]+)?')
echo "Set_Recall: $cranfieldLMJelinekMercerParserSetRecall"

echo "StandardAnalyzer + LMJelinekMercer + MultiFieldQueryParser"
java -jar target/CS7IS3-Assignment1-Prathamesh-0.0.1-SNAPSHOT.jar --operation evaluate CranfieldAnalyzer LMJelinekMercer MultiFieldQueryParser
cranfieldLMJelinekMercerMultiFieldParserMAP=$(./trec_eval-9.0.7/trec_eval -m map cranfield-collection/QRelsCorrectedforTRECeval evaluation/scores | grep -oE '[0-9]+([.][0-9]+)?')
echo "MAP: $cranfieldLMJelinekMercerMultiFieldParserMAP"
cranfieldLMJelinekMercerMultiFieldParserSetRecall=$(./trec_eval-9.0.7/trec_eval -m set_recall cranfield-collection/QRelsCorrectedforTRECeval evaluation/scores | grep -oE '[0-9]+([.][0-9]+)?')
echo "Set_Recall: $cranfieldLMJelinekMercerMultiFieldParserSetRecall"

# Visualize the MAP and set_recall values
java -jar target/CS7IS3-Assignment1-Prathamesh-0.0.1-SNAPSHOT.jar --visualize $standardBM25ParserMAP $standardBM25ParserSetRecall $standardBM25MultiFieldParserMAP $standardBM25MultiFieldParserSetRecall $standardVSMParserMAP $standardVSMParserSetRecall $standardVSMMultiFieldParserMAP $standardVSMMultiFieldParserSetRecall $standardLMDirichletParserMAP $standardLMDirichletParserSetRecall $standardLMDirichletMultiFieldParserMAP $standardLMDirichletMultiFieldParserSetRecall $standardLMJelinekMercerParserMAP $standardLMJelinekMercerParserSetRecall $standardLMJelinekMercerMultiFieldParserMAP $standardLMJelinekMercerMultiFieldParserSetRecall $cranfieldBM25ParserMAP $cranfieldBM25ParserSetRecall $cranfieldBM25MultiFieldParserMAP $cranfieldBM25MultiFieldParserSetRecall $cranfieldVSMParserMAP $cranfieldVSMParserSetRecall $cranfieldVSMMultiFieldParserMAP $cranfieldVSMMultiFieldParserSetRecall $cranfieldLMDirichletParserMAP $cranfieldLMDirichletParserSetRecall $cranfieldLMDirichletMultiFieldParserMAP $cranfieldLMDirichletMultiFieldParserSetRecall $cranfieldLMJelinekMercerParserMAP $cranfieldLMJelinekMercerParserSetRecall $cranfieldLMJelinekMercerMultiFieldParserMAP $cranfieldLMJelinekMercerMultiFieldParserSetRecall
echo "Created visualization.png using MAP and set_recall values"