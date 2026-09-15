package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.PartyRoleType;
import fpml.consolidated.shared.validation.PartyRoleTypeTypeFormatValidator;
import fpml.consolidated.shared.validation.PartyRoleTypeValidator;
import fpml.consolidated.shared.validation.exists.PartyRoleTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PartyRoleType.class)
public class PartyRoleTypeMeta implements RosettaMetaData<PartyRoleType> {

	@Override
	public List<Validator<? super PartyRoleType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartyRoleType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PartyRoleType> validator(ValidatorFactory factory) {
		return factory.<PartyRoleType>create(PartyRoleTypeValidator.class);
	}

	@Override
	public Validator<? super PartyRoleType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PartyRoleType>create(PartyRoleTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PartyRoleType> validator() {
		return new PartyRoleTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PartyRoleType> typeFormatValidator() {
		return new PartyRoleTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyRoleType, Set<String>> onlyExistsValidator() {
		return new PartyRoleTypeOnlyExistsValidator();
	}
}
