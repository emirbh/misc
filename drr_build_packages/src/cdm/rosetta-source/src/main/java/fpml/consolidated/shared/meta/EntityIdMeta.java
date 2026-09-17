package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.EntityId;
import fpml.consolidated.shared.validation.EntityIdTypeFormatValidator;
import fpml.consolidated.shared.validation.EntityIdValidator;
import fpml.consolidated.shared.validation.exists.EntityIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=EntityId.class)
public class EntityIdMeta implements RosettaMetaData<EntityId> {

	@Override
	public List<Validator<? super EntityId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EntityId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EntityId> validator(ValidatorFactory factory) {
		return factory.<EntityId>create(EntityIdValidator.class);
	}

	@Override
	public Validator<? super EntityId> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EntityId>create(EntityIdTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EntityId> validator() {
		return new EntityIdValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EntityId> typeFormatValidator() {
		return new EntityIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EntityId, Set<String>> onlyExistsValidator() {
		return new EntityIdOnlyExistsValidator();
	}
}
