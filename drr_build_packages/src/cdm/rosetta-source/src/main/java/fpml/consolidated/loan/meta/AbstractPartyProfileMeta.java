package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AbstractPartyProfile;
import fpml.consolidated.loan.validation.AbstractPartyProfileTypeFormatValidator;
import fpml.consolidated.loan.validation.AbstractPartyProfileValidator;
import fpml.consolidated.loan.validation.exists.AbstractPartyProfileOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AbstractPartyProfile.class)
public class AbstractPartyProfileMeta implements RosettaMetaData<AbstractPartyProfile> {

	@Override
	public List<Validator<? super AbstractPartyProfile>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractPartyProfile, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AbstractPartyProfile> validator(ValidatorFactory factory) {
		return factory.<AbstractPartyProfile>create(AbstractPartyProfileValidator.class);
	}

	@Override
	public Validator<? super AbstractPartyProfile> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AbstractPartyProfile>create(AbstractPartyProfileTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AbstractPartyProfile> validator() {
		return new AbstractPartyProfileValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AbstractPartyProfile> typeFormatValidator() {
		return new AbstractPartyProfileTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractPartyProfile, Set<String>> onlyExistsValidator() {
		return new AbstractPartyProfileOnlyExistsValidator();
	}
}
