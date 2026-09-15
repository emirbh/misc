package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.CreditDerivativesNotices;
import fpml.consolidated.doc.validation.CreditDerivativesNoticesTypeFormatValidator;
import fpml.consolidated.doc.validation.CreditDerivativesNoticesValidator;
import fpml.consolidated.doc.validation.exists.CreditDerivativesNoticesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CreditDerivativesNotices.class)
public class CreditDerivativesNoticesMeta implements RosettaMetaData<CreditDerivativesNotices> {

	@Override
	public List<Validator<? super CreditDerivativesNotices>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditDerivativesNotices, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CreditDerivativesNotices> validator(ValidatorFactory factory) {
		return factory.<CreditDerivativesNotices>create(CreditDerivativesNoticesValidator.class);
	}

	@Override
	public Validator<? super CreditDerivativesNotices> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CreditDerivativesNotices>create(CreditDerivativesNoticesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CreditDerivativesNotices> validator() {
		return new CreditDerivativesNoticesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CreditDerivativesNotices> typeFormatValidator() {
		return new CreditDerivativesNoticesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditDerivativesNotices, Set<String>> onlyExistsValidator() {
		return new CreditDerivativesNoticesOnlyExistsValidator();
	}
}
