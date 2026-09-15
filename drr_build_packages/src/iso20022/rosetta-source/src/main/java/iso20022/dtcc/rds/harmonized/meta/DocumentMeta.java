package iso20022.dtcc.rds.harmonized.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.dtcc.rds.harmonized.Document;
import iso20022.dtcc.rds.harmonized.validation.DocumentTypeFormatValidator;
import iso20022.dtcc.rds.harmonized.validation.DocumentValidator;
import iso20022.dtcc.rds.harmonized.validation.datarule.DocumentChoice;
import iso20022.dtcc.rds.harmonized.validation.exists.DocumentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Document.class)
public class DocumentMeta implements RosettaMetaData<Document> {

	@Override
	public List<Validator<? super Document>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<Document>create(DocumentChoice.class)
		);
	}
	
	@Override
	public List<Function<? super Document, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Document> validator(ValidatorFactory factory) {
		return factory.<Document>create(DocumentValidator.class);
	}

	@Override
	public Validator<? super Document> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Document>create(DocumentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Document> validator() {
		return new DocumentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Document> typeFormatValidator() {
		return new DocumentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Document, Set<String>> onlyExistsValidator() {
		return new DocumentOnlyExistsValidator();
	}
}
