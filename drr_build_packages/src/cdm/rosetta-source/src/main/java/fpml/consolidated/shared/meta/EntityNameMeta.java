package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.EntityName;
import fpml.consolidated.shared.validation.EntityNameTypeFormatValidator;
import fpml.consolidated.shared.validation.EntityNameValidator;
import fpml.consolidated.shared.validation.exists.EntityNameOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=EntityName.class)
public class EntityNameMeta implements RosettaMetaData<EntityName> {

	@Override
	public List<Validator<? super EntityName>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EntityName, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EntityName> validator(ValidatorFactory factory) {
		return factory.<EntityName>create(EntityNameValidator.class);
	}

	@Override
	public Validator<? super EntityName> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EntityName>create(EntityNameTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EntityName> validator() {
		return new EntityNameValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EntityName> typeFormatValidator() {
		return new EntityNameTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EntityName, Set<String>> onlyExistsValidator() {
		return new EntityNameOnlyExistsValidator();
	}
}
