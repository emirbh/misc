package fpml.consolidated.mktenv.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.mktenv.YieldCurveValuation;
import fpml.consolidated.mktenv.validation.YieldCurveValuationTypeFormatValidator;
import fpml.consolidated.mktenv.validation.YieldCurveValuationValidator;
import fpml.consolidated.mktenv.validation.exists.YieldCurveValuationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=YieldCurveValuation.class)
public class YieldCurveValuationMeta implements RosettaMetaData<YieldCurveValuation> {

	@Override
	public List<Validator<? super YieldCurveValuation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super YieldCurveValuation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super YieldCurveValuation> validator(ValidatorFactory factory) {
		return factory.<YieldCurveValuation>create(YieldCurveValuationValidator.class);
	}

	@Override
	public Validator<? super YieldCurveValuation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<YieldCurveValuation>create(YieldCurveValuationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super YieldCurveValuation> validator() {
		return new YieldCurveValuationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super YieldCurveValuation> typeFormatValidator() {
		return new YieldCurveValuationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super YieldCurveValuation, Set<String>> onlyExistsValidator() {
		return new YieldCurveValuationOnlyExistsValidator();
	}
}
