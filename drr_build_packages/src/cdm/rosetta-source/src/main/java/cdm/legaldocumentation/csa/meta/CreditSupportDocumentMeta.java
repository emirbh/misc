package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.CreditSupportDocument;
import cdm.legaldocumentation.csa.validation.CreditSupportDocumentTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.CreditSupportDocumentValidator;
import cdm.legaldocumentation.csa.validation.exists.CreditSupportDocumentOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=CreditSupportDocument.class)
public class CreditSupportDocumentMeta implements RosettaMetaData<CreditSupportDocument> {

	@Override
	public List<Validator<? super CreditSupportDocument>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditSupportDocument, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CreditSupportDocument> validator(ValidatorFactory factory) {
		return factory.<CreditSupportDocument>create(CreditSupportDocumentValidator.class);
	}

	@Override
	public Validator<? super CreditSupportDocument> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CreditSupportDocument>create(CreditSupportDocumentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CreditSupportDocument> validator() {
		return new CreditSupportDocumentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CreditSupportDocument> typeFormatValidator() {
		return new CreditSupportDocumentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditSupportDocument, Set<String>> onlyExistsValidator() {
		return new CreditSupportDocumentOnlyExistsValidator();
	}
}
