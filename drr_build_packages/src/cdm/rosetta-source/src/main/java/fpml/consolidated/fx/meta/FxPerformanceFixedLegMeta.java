package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FxPerformanceFixedLeg;
import fpml.consolidated.fx.validation.FxPerformanceFixedLegTypeFormatValidator;
import fpml.consolidated.fx.validation.FxPerformanceFixedLegValidator;
import fpml.consolidated.fx.validation.exists.FxPerformanceFixedLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxPerformanceFixedLeg.class)
public class FxPerformanceFixedLegMeta implements RosettaMetaData<FxPerformanceFixedLeg> {

	@Override
	public List<Validator<? super FxPerformanceFixedLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxPerformanceFixedLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxPerformanceFixedLeg> validator(ValidatorFactory factory) {
		return factory.<FxPerformanceFixedLeg>create(FxPerformanceFixedLegValidator.class);
	}

	@Override
	public Validator<? super FxPerformanceFixedLeg> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxPerformanceFixedLeg>create(FxPerformanceFixedLegTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxPerformanceFixedLeg> validator() {
		return new FxPerformanceFixedLegValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxPerformanceFixedLeg> typeFormatValidator() {
		return new FxPerformanceFixedLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxPerformanceFixedLeg, Set<String>> onlyExistsValidator() {
		return new FxPerformanceFixedLegOnlyExistsValidator();
	}
}
