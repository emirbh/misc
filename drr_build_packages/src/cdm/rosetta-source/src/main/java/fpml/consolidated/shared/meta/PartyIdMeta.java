package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.PartyId;
import fpml.consolidated.shared.validation.PartyIdTypeFormatValidator;
import fpml.consolidated.shared.validation.PartyIdValidator;
import fpml.consolidated.shared.validation.exists.PartyIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PartyId.class)
public class PartyIdMeta implements RosettaMetaData<PartyId> {

	@Override
	public List<Validator<? super PartyId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartyId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PartyId> validator(ValidatorFactory factory) {
		return factory.<PartyId>create(PartyIdValidator.class);
	}

	@Override
	public Validator<? super PartyId> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PartyId>create(PartyIdTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PartyId> validator() {
		return new PartyIdValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PartyId> typeFormatValidator() {
		return new PartyIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyId, Set<String>> onlyExistsValidator() {
		return new PartyIdOnlyExistsValidator();
	}
}
