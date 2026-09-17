package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.PartySelector;
import fpml.consolidated.ird.validation.PartySelectorTypeFormatValidator;
import fpml.consolidated.ird.validation.PartySelectorValidator;
import fpml.consolidated.ird.validation.datarule.PartySelectorChoice;
import fpml.consolidated.ird.validation.exists.PartySelectorOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PartySelector.class)
public class PartySelectorMeta implements RosettaMetaData<PartySelector> {

	@Override
	public List<Validator<? super PartySelector>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PartySelector>create(PartySelectorChoice.class)
		);
	}
	
	@Override
	public List<Function<? super PartySelector, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PartySelector> validator(ValidatorFactory factory) {
		return factory.<PartySelector>create(PartySelectorValidator.class);
	}

	@Override
	public Validator<? super PartySelector> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PartySelector>create(PartySelectorTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PartySelector> validator() {
		return new PartySelectorValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PartySelector> typeFormatValidator() {
		return new PartySelectorTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartySelector, Set<String>> onlyExistsValidator() {
		return new PartySelectorOnlyExistsValidator();
	}
}
