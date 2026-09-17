package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.PartyGroupType;
import fpml.consolidated.shared.validation.PartyGroupTypeTypeFormatValidator;
import fpml.consolidated.shared.validation.PartyGroupTypeValidator;
import fpml.consolidated.shared.validation.exists.PartyGroupTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PartyGroupType.class)
public class PartyGroupTypeMeta implements RosettaMetaData<PartyGroupType> {

	@Override
	public List<Validator<? super PartyGroupType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartyGroupType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PartyGroupType> validator(ValidatorFactory factory) {
		return factory.<PartyGroupType>create(PartyGroupTypeValidator.class);
	}

	@Override
	public Validator<? super PartyGroupType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PartyGroupType>create(PartyGroupTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PartyGroupType> validator() {
		return new PartyGroupTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PartyGroupType> typeFormatValidator() {
		return new PartyGroupTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyGroupType, Set<String>> onlyExistsValidator() {
		return new PartyGroupTypeOnlyExistsValidator();
	}
}
