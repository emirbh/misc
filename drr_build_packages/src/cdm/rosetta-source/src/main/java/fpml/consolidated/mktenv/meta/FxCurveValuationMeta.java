package fpml.consolidated.mktenv.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.mktenv.FxCurveValuation;
import fpml.consolidated.mktenv.validation.FxCurveValuationTypeFormatValidator;
import fpml.consolidated.mktenv.validation.FxCurveValuationValidator;
import fpml.consolidated.mktenv.validation.exists.FxCurveValuationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxCurveValuation.class)
public class FxCurveValuationMeta implements RosettaMetaData<FxCurveValuation> {

	@Override
	public List<Validator<? super FxCurveValuation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxCurveValuation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxCurveValuation> validator(ValidatorFactory factory) {
		return factory.<FxCurveValuation>create(FxCurveValuationValidator.class);
	}

	@Override
	public Validator<? super FxCurveValuation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxCurveValuation>create(FxCurveValuationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxCurveValuation> validator() {
		return new FxCurveValuationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxCurveValuation> typeFormatValidator() {
		return new FxCurveValuationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxCurveValuation, Set<String>> onlyExistsValidator() {
		return new FxCurveValuationOnlyExistsValidator();
	}
}
