package fpml.consolidated.mktenv.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.mktenv.VolatilityMatrixValuation;
import fpml.consolidated.mktenv.validation.VolatilityMatrixValuationTypeFormatValidator;
import fpml.consolidated.mktenv.validation.VolatilityMatrixValuationValidator;
import fpml.consolidated.mktenv.validation.exists.VolatilityMatrixValuationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=VolatilityMatrixValuation.class)
public class VolatilityMatrixValuationMeta implements RosettaMetaData<VolatilityMatrixValuation> {

	@Override
	public List<Validator<? super VolatilityMatrixValuation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super VolatilityMatrixValuation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super VolatilityMatrixValuation> validator(ValidatorFactory factory) {
		return factory.<VolatilityMatrixValuation>create(VolatilityMatrixValuationValidator.class);
	}

	@Override
	public Validator<? super VolatilityMatrixValuation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<VolatilityMatrixValuation>create(VolatilityMatrixValuationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super VolatilityMatrixValuation> validator() {
		return new VolatilityMatrixValuationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super VolatilityMatrixValuation> typeFormatValidator() {
		return new VolatilityMatrixValuationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super VolatilityMatrixValuation, Set<String>> onlyExistsValidator() {
		return new VolatilityMatrixValuationOnlyExistsValidator();
	}
}
