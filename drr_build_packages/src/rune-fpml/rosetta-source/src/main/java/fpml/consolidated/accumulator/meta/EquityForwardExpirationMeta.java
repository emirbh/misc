package fpml.consolidated.accumulator.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.accumulator.EquityForwardExpiration;
import fpml.consolidated.accumulator.validation.EquityForwardExpirationTypeFormatValidator;
import fpml.consolidated.accumulator.validation.EquityForwardExpirationValidator;
import fpml.consolidated.accumulator.validation.datarule.EquityForwardExpirationChoice;
import fpml.consolidated.accumulator.validation.exists.EquityForwardExpirationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=EquityForwardExpiration.class)
public class EquityForwardExpirationMeta implements RosettaMetaData<EquityForwardExpiration> {

	@Override
	public List<Validator<? super EquityForwardExpiration>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<EquityForwardExpiration>create(EquityForwardExpirationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super EquityForwardExpiration, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EquityForwardExpiration> validator(ValidatorFactory factory) {
		return factory.<EquityForwardExpiration>create(EquityForwardExpirationValidator.class);
	}

	@Override
	public Validator<? super EquityForwardExpiration> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EquityForwardExpiration>create(EquityForwardExpirationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EquityForwardExpiration> validator() {
		return new EquityForwardExpirationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EquityForwardExpiration> typeFormatValidator() {
		return new EquityForwardExpirationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EquityForwardExpiration, Set<String>> onlyExistsValidator() {
		return new EquityForwardExpirationOnlyExistsValidator();
	}
}
