package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.PartyProfileChoice;
import fpml.consolidated.loan.validation.PartyProfileChoiceTypeFormatValidator;
import fpml.consolidated.loan.validation.PartyProfileChoiceValidator;
import fpml.consolidated.loan.validation.datarule.PartyProfileChoiceChoice;
import fpml.consolidated.loan.validation.exists.PartyProfileChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PartyProfileChoice.class)
public class PartyProfileChoiceMeta implements RosettaMetaData<PartyProfileChoice> {

	@Override
	public List<Validator<? super PartyProfileChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PartyProfileChoice>create(PartyProfileChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super PartyProfileChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PartyProfileChoice> validator(ValidatorFactory factory) {
		return factory.<PartyProfileChoice>create(PartyProfileChoiceValidator.class);
	}

	@Override
	public Validator<? super PartyProfileChoice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PartyProfileChoice>create(PartyProfileChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PartyProfileChoice> validator() {
		return new PartyProfileChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PartyProfileChoice> typeFormatValidator() {
		return new PartyProfileChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyProfileChoice, Set<String>> onlyExistsValidator() {
		return new PartyProfileChoiceOnlyExistsValidator();
	}
}
