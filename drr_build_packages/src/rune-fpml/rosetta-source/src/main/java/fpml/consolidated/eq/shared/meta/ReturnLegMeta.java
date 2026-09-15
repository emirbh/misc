package fpml.consolidated.eq.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.ReturnLeg;
import fpml.consolidated.eq.shared.ReturnSwapLegUnderlyer;
import fpml.consolidated.eq.shared.validation.ReturnLegTypeFormatValidator;
import fpml.consolidated.eq.shared.validation.ReturnLegValidator;
import fpml.consolidated.eq.shared.validation.datarule.ReturnSwapLegUnderlyerChoice;
import fpml.consolidated.eq.shared.validation.exists.ReturnLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ReturnLeg.class)
public class ReturnLegMeta implements RosettaMetaData<ReturnLeg> {

	@Override
	public List<Validator<? super ReturnLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ReturnSwapLegUnderlyer>create(ReturnSwapLegUnderlyerChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ReturnLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReturnLeg> validator(ValidatorFactory factory) {
		return factory.<ReturnLeg>create(ReturnLegValidator.class);
	}

	@Override
	public Validator<? super ReturnLeg> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReturnLeg>create(ReturnLegTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReturnLeg> validator() {
		return new ReturnLegValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReturnLeg> typeFormatValidator() {
		return new ReturnLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReturnLeg, Set<String>> onlyExistsValidator() {
		return new ReturnLegOnlyExistsValidator();
	}
}
