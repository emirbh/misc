package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.SinglePostingParty;
import cdm.legaldocumentation.csa.validation.SinglePostingPartyTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.SinglePostingPartyValidator;
import cdm.legaldocumentation.csa.validation.exists.SinglePostingPartyOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=SinglePostingParty.class)
public class SinglePostingPartyMeta implements RosettaMetaData<SinglePostingParty> {

	@Override
	public List<Validator<? super SinglePostingParty>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SinglePostingParty, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SinglePostingParty> validator(ValidatorFactory factory) {
		return factory.<SinglePostingParty>create(SinglePostingPartyValidator.class);
	}

	@Override
	public Validator<? super SinglePostingParty> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SinglePostingParty>create(SinglePostingPartyTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SinglePostingParty> validator() {
		return new SinglePostingPartyValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SinglePostingParty> typeFormatValidator() {
		return new SinglePostingPartyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SinglePostingParty, Set<String>> onlyExistsValidator() {
		return new SinglePostingPartyOnlyExistsValidator();
	}
}
