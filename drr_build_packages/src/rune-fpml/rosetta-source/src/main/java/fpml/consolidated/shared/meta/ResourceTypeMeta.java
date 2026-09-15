package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.ResourceType;
import fpml.consolidated.shared.validation.ResourceTypeTypeFormatValidator;
import fpml.consolidated.shared.validation.ResourceTypeValidator;
import fpml.consolidated.shared.validation.exists.ResourceTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ResourceType.class)
public class ResourceTypeMeta implements RosettaMetaData<ResourceType> {

	@Override
	public List<Validator<? super ResourceType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ResourceType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ResourceType> validator(ValidatorFactory factory) {
		return factory.<ResourceType>create(ResourceTypeValidator.class);
	}

	@Override
	public Validator<? super ResourceType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ResourceType>create(ResourceTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ResourceType> validator() {
		return new ResourceTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ResourceType> typeFormatValidator() {
		return new ResourceTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ResourceType, Set<String>> onlyExistsValidator() {
		return new ResourceTypeOnlyExistsValidator();
	}
}
