package fpml.consolidated.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ObjectType;
import fpml.consolidated.validation.ObjectTypeTypeFormatValidator;
import fpml.consolidated.validation.ObjectTypeValidator;
import fpml.consolidated.validation.exists.ObjectTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ObjectType.class)
public class ObjectTypeMeta implements RosettaMetaData<ObjectType> {

	@Override
	public List<Validator<? super ObjectType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ObjectType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ObjectType> validator(ValidatorFactory factory) {
		return factory.<ObjectType>create(ObjectTypeValidator.class);
	}

	@Override
	public Validator<? super ObjectType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ObjectType>create(ObjectTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ObjectType> validator() {
		return new ObjectTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ObjectType> typeFormatValidator() {
		return new ObjectTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ObjectType, Set<String>> onlyExistsValidator() {
		return new ObjectTypeOnlyExistsValidator();
	}
}
