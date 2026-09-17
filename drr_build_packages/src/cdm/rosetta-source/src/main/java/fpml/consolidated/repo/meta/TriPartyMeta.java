package fpml.consolidated.repo.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.repo.TriParty;
import fpml.consolidated.repo.validation.TriPartyTypeFormatValidator;
import fpml.consolidated.repo.validation.TriPartyValidator;
import fpml.consolidated.repo.validation.exists.TriPartyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TriParty.class)
public class TriPartyMeta implements RosettaMetaData<TriParty> {

	@Override
	public List<Validator<? super TriParty>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TriParty, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TriParty> validator(ValidatorFactory factory) {
		return factory.<TriParty>create(TriPartyValidator.class);
	}

	@Override
	public Validator<? super TriParty> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TriParty>create(TriPartyTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TriParty> validator() {
		return new TriPartyValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TriParty> typeFormatValidator() {
		return new TriPartyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TriParty, Set<String>> onlyExistsValidator() {
		return new TriPartyOnlyExistsValidator();
	}
}
