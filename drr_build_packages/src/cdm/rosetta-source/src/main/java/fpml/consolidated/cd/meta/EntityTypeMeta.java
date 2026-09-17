package fpml.consolidated.cd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.EntityType;
import fpml.consolidated.cd.validation.EntityTypeTypeFormatValidator;
import fpml.consolidated.cd.validation.EntityTypeValidator;
import fpml.consolidated.cd.validation.exists.EntityTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=EntityType.class)
public class EntityTypeMeta implements RosettaMetaData<EntityType> {

	@Override
	public List<Validator<? super EntityType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EntityType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EntityType> validator(ValidatorFactory factory) {
		return factory.<EntityType>create(EntityTypeValidator.class);
	}

	@Override
	public Validator<? super EntityType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EntityType>create(EntityTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EntityType> validator() {
		return new EntityTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EntityType> typeFormatValidator() {
		return new EntityTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EntityType, Set<String>> onlyExistsValidator() {
		return new EntityTypeOnlyExistsValidator();
	}
}
