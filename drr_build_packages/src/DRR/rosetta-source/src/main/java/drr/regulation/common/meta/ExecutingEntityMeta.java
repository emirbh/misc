package drr.regulation.common.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.ExecutingEntity;
import drr.regulation.common.validation.ExecutingEntityTypeFormatValidator;
import drr.regulation.common.validation.ExecutingEntityValidator;
import drr.regulation.common.validation.exists.ExecutingEntityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=ExecutingEntity.class)
public class ExecutingEntityMeta implements RosettaMetaData<ExecutingEntity> {

	@Override
	public List<Validator<? super ExecutingEntity>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExecutingEntity, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ExecutingEntity> validator(ValidatorFactory factory) {
		return factory.<ExecutingEntity>create(ExecutingEntityValidator.class);
	}

	@Override
	public Validator<? super ExecutingEntity> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ExecutingEntity>create(ExecutingEntityTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ExecutingEntity> validator() {
		return new ExecutingEntityValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ExecutingEntity> typeFormatValidator() {
		return new ExecutingEntityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExecutingEntity, Set<String>> onlyExistsValidator() {
		return new ExecutingEntityOnlyExistsValidator();
	}
}
