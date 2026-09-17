package fpml.consolidated.option.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.option.shared.NotifyingParty;
import fpml.consolidated.option.shared.validation.NotifyingPartyTypeFormatValidator;
import fpml.consolidated.option.shared.validation.NotifyingPartyValidator;
import fpml.consolidated.option.shared.validation.exists.NotifyingPartyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=NotifyingParty.class)
public class NotifyingPartyMeta implements RosettaMetaData<NotifyingParty> {

	@Override
	public List<Validator<? super NotifyingParty>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NotifyingParty, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NotifyingParty> validator(ValidatorFactory factory) {
		return factory.<NotifyingParty>create(NotifyingPartyValidator.class);
	}

	@Override
	public Validator<? super NotifyingParty> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NotifyingParty>create(NotifyingPartyTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NotifyingParty> validator() {
		return new NotifyingPartyValidator();
	}

	@Deprecated
	@Override
	public Validator<? super NotifyingParty> typeFormatValidator() {
		return new NotifyingPartyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NotifyingParty, Set<String>> onlyExistsValidator() {
		return new NotifyingPartyOnlyExistsValidator();
	}
}
