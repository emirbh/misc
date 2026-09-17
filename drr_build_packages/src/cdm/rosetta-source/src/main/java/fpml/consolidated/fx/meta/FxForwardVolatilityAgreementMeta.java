package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FxForwardVolatilityAgreement;
import fpml.consolidated.fx.validation.FxForwardVolatilityAgreementTypeFormatValidator;
import fpml.consolidated.fx.validation.FxForwardVolatilityAgreementValidator;
import fpml.consolidated.fx.validation.exists.FxForwardVolatilityAgreementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxForwardVolatilityAgreement.class)
public class FxForwardVolatilityAgreementMeta implements RosettaMetaData<FxForwardVolatilityAgreement> {

	@Override
	public List<Validator<? super FxForwardVolatilityAgreement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxForwardVolatilityAgreement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxForwardVolatilityAgreement> validator(ValidatorFactory factory) {
		return factory.<FxForwardVolatilityAgreement>create(FxForwardVolatilityAgreementValidator.class);
	}

	@Override
	public Validator<? super FxForwardVolatilityAgreement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxForwardVolatilityAgreement>create(FxForwardVolatilityAgreementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxForwardVolatilityAgreement> validator() {
		return new FxForwardVolatilityAgreementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxForwardVolatilityAgreement> typeFormatValidator() {
		return new FxForwardVolatilityAgreementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxForwardVolatilityAgreement, Set<String>> onlyExistsValidator() {
		return new FxForwardVolatilityAgreementOnlyExistsValidator();
	}
}
