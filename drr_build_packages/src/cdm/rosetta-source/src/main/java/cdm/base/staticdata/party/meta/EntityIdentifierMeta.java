package cdm.base.staticdata.party.meta;

import cdm.base.staticdata.party.EntityIdentifier;
import cdm.base.staticdata.party.validation.EntityIdentifierTypeFormatValidator;
import cdm.base.staticdata.party.validation.EntityIdentifierValidator;
import cdm.base.staticdata.party.validation.exists.EntityIdentifierOnlyExistsValidator;
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
@RosettaMeta(model=EntityIdentifier.class)
public class EntityIdentifierMeta implements RosettaMetaData<EntityIdentifier> {

	@Override
	public List<Validator<? super EntityIdentifier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EntityIdentifier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EntityIdentifier> validator(ValidatorFactory factory) {
		return factory.<EntityIdentifier>create(EntityIdentifierValidator.class);
	}

	@Override
	public Validator<? super EntityIdentifier> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EntityIdentifier>create(EntityIdentifierTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EntityIdentifier> validator() {
		return new EntityIdentifierValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EntityIdentifier> typeFormatValidator() {
		return new EntityIdentifierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EntityIdentifier, Set<String>> onlyExistsValidator() {
		return new EntityIdentifierOnlyExistsValidator();
	}
}
