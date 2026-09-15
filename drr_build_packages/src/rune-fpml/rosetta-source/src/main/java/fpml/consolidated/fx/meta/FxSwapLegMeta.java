package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FxSwapLeg;
import fpml.consolidated.fx.validation.FxSwapLegTypeFormatValidator;
import fpml.consolidated.fx.validation.FxSwapLegValidator;
import fpml.consolidated.fx.validation.datarule.FxSwapLegChoice0;
import fpml.consolidated.fx.validation.datarule.FxSwapLegChoice1;
import fpml.consolidated.fx.validation.exists.FxSwapLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxSwapLeg.class)
public class FxSwapLegMeta implements RosettaMetaData<FxSwapLeg> {

	@Override
	public List<Validator<? super FxSwapLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxSwapLeg>create(FxSwapLegChoice0.class),
			factory.<FxSwapLeg>create(FxSwapLegChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super FxSwapLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxSwapLeg> validator(ValidatorFactory factory) {
		return factory.<FxSwapLeg>create(FxSwapLegValidator.class);
	}

	@Override
	public Validator<? super FxSwapLeg> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxSwapLeg>create(FxSwapLegTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxSwapLeg> validator() {
		return new FxSwapLegValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxSwapLeg> typeFormatValidator() {
		return new FxSwapLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxSwapLeg, Set<String>> onlyExistsValidator() {
		return new FxSwapLegOnlyExistsValidator();
	}
}
