package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.PartyName;
import fpml.consolidated.shared.validation.PartyNameTypeFormatValidator;
import fpml.consolidated.shared.validation.PartyNameValidator;
import fpml.consolidated.shared.validation.exists.PartyNameOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PartyName.class)
public class PartyNameMeta implements RosettaMetaData<PartyName> {

	@Override
	public List<Validator<? super PartyName>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartyName, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PartyName> validator(ValidatorFactory factory) {
		return factory.<PartyName>create(PartyNameValidator.class);
	}

	@Override
	public Validator<? super PartyName> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PartyName>create(PartyNameTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PartyName> validator() {
		return new PartyNameValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PartyName> typeFormatValidator() {
		return new PartyNameTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyName, Set<String>> onlyExistsValidator() {
		return new PartyNameOnlyExistsValidator();
	}
}
