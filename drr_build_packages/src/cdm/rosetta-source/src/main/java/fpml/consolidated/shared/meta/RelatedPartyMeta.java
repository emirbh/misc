package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.RelatedParty;
import fpml.consolidated.shared.validation.RelatedPartyTypeFormatValidator;
import fpml.consolidated.shared.validation.RelatedPartyValidator;
import fpml.consolidated.shared.validation.exists.RelatedPartyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RelatedParty.class)
public class RelatedPartyMeta implements RosettaMetaData<RelatedParty> {

	@Override
	public List<Validator<? super RelatedParty>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RelatedParty, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RelatedParty> validator(ValidatorFactory factory) {
		return factory.<RelatedParty>create(RelatedPartyValidator.class);
	}

	@Override
	public Validator<? super RelatedParty> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RelatedParty>create(RelatedPartyTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RelatedParty> validator() {
		return new RelatedPartyValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RelatedParty> typeFormatValidator() {
		return new RelatedPartyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RelatedParty, Set<String>> onlyExistsValidator() {
		return new RelatedPartyOnlyExistsValidator();
	}
}
