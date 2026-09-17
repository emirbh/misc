package fpml.consolidated.eqd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eqd.EquityForward;
import fpml.consolidated.eqd.validation.EquityForwardTypeFormatValidator;
import fpml.consolidated.eqd.validation.EquityForwardValidator;
import fpml.consolidated.eqd.validation.exists.EquityForwardOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=EquityForward.class)
public class EquityForwardMeta implements RosettaMetaData<EquityForward> {

	@Override
	public List<Validator<? super EquityForward>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EquityForward, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EquityForward> validator(ValidatorFactory factory) {
		return factory.<EquityForward>create(EquityForwardValidator.class);
	}

	@Override
	public Validator<? super EquityForward> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EquityForward>create(EquityForwardTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EquityForward> validator() {
		return new EquityForwardValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EquityForward> typeFormatValidator() {
		return new EquityForwardTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EquityForward, Set<String>> onlyExistsValidator() {
		return new EquityForwardOnlyExistsValidator();
	}
}
