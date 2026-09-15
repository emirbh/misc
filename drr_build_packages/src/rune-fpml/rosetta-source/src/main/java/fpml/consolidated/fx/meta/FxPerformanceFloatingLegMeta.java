package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FxPerformanceFloatingLeg;
import fpml.consolidated.fx.validation.FxPerformanceFloatingLegTypeFormatValidator;
import fpml.consolidated.fx.validation.FxPerformanceFloatingLegValidator;
import fpml.consolidated.fx.validation.exists.FxPerformanceFloatingLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxPerformanceFloatingLeg.class)
public class FxPerformanceFloatingLegMeta implements RosettaMetaData<FxPerformanceFloatingLeg> {

	@Override
	public List<Validator<? super FxPerformanceFloatingLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxPerformanceFloatingLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxPerformanceFloatingLeg> validator(ValidatorFactory factory) {
		return factory.<FxPerformanceFloatingLeg>create(FxPerformanceFloatingLegValidator.class);
	}

	@Override
	public Validator<? super FxPerformanceFloatingLeg> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxPerformanceFloatingLeg>create(FxPerformanceFloatingLegTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxPerformanceFloatingLeg> validator() {
		return new FxPerformanceFloatingLegValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxPerformanceFloatingLeg> typeFormatValidator() {
		return new FxPerformanceFloatingLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxPerformanceFloatingLeg, Set<String>> onlyExistsValidator() {
		return new FxPerformanceFloatingLegOnlyExistsValidator();
	}
}
