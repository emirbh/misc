package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FxSingleLeg;
import fpml.consolidated.fx.validation.FxSingleLegTypeFormatValidator;
import fpml.consolidated.fx.validation.FxSingleLegValidator;
import fpml.consolidated.fx.validation.datarule.FxSingleLegChoice0;
import fpml.consolidated.fx.validation.datarule.FxSingleLegChoice1;
import fpml.consolidated.fx.validation.exists.FxSingleLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxSingleLeg.class)
public class FxSingleLegMeta implements RosettaMetaData<FxSingleLeg> {

	@Override
	public List<Validator<? super FxSingleLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxSingleLeg>create(FxSingleLegChoice0.class),
			factory.<FxSingleLeg>create(FxSingleLegChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super FxSingleLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxSingleLeg> validator(ValidatorFactory factory) {
		return factory.<FxSingleLeg>create(FxSingleLegValidator.class);
	}

	@Override
	public Validator<? super FxSingleLeg> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxSingleLeg>create(FxSingleLegTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxSingleLeg> validator() {
		return new FxSingleLegValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxSingleLeg> typeFormatValidator() {
		return new FxSingleLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxSingleLeg, Set<String>> onlyExistsValidator() {
		return new FxSingleLegOnlyExistsValidator();
	}
}
