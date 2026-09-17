package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.PartyProfile;
import fpml.consolidated.loan.validation.PartyProfileTypeFormatValidator;
import fpml.consolidated.loan.validation.PartyProfileValidator;
import fpml.consolidated.loan.validation.exists.PartyProfileOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PartyProfile.class)
public class PartyProfileMeta implements RosettaMetaData<PartyProfile> {

	@Override
	public List<Validator<? super PartyProfile>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartyProfile, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PartyProfile> validator(ValidatorFactory factory) {
		return factory.<PartyProfile>create(PartyProfileValidator.class);
	}

	@Override
	public Validator<? super PartyProfile> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PartyProfile>create(PartyProfileTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PartyProfile> validator() {
		return new PartyProfileValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PartyProfile> typeFormatValidator() {
		return new PartyProfileTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyProfile, Set<String>> onlyExistsValidator() {
		return new PartyProfileOnlyExistsValidator();
	}
}
