package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.Party;
import fpml.consolidated.shared.validation.PartyTypeFormatValidator;
import fpml.consolidated.shared.validation.PartyValidator;
import fpml.consolidated.shared.validation.datarule.PartyChoice;
import fpml.consolidated.shared.validation.exists.PartyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Party.class)
public class PartyMeta implements RosettaMetaData<Party> {

	@Override
	public List<Validator<? super Party>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<Party>create(PartyChoice.class)
		);
	}
	
	@Override
	public List<Function<? super Party, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Party> validator(ValidatorFactory factory) {
		return factory.<Party>create(PartyValidator.class);
	}

	@Override
	public Validator<? super Party> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Party>create(PartyTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Party> validator() {
		return new PartyValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Party> typeFormatValidator() {
		return new PartyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Party, Set<String>> onlyExistsValidator() {
		return new PartyOnlyExistsValidator();
	}
}
