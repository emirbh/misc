package fpml.consolidated.eq.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.InterestLeg;
import fpml.consolidated.eq.shared.validation.InterestLegTypeFormatValidator;
import fpml.consolidated.eq.shared.validation.InterestLegValidator;
import fpml.consolidated.eq.shared.validation.exists.InterestLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=InterestLeg.class)
public class InterestLegMeta implements RosettaMetaData<InterestLeg> {

	@Override
	public List<Validator<? super InterestLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InterestLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super InterestLeg> validator(ValidatorFactory factory) {
		return factory.<InterestLeg>create(InterestLegValidator.class);
	}

	@Override
	public Validator<? super InterestLeg> typeFormatValidator(ValidatorFactory factory) {
		return factory.<InterestLeg>create(InterestLegTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super InterestLeg> validator() {
		return new InterestLegValidator();
	}

	@Deprecated
	@Override
	public Validator<? super InterestLeg> typeFormatValidator() {
		return new InterestLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InterestLeg, Set<String>> onlyExistsValidator() {
		return new InterestLegOnlyExistsValidator();
	}
}
