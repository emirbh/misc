package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.ResourceId;
import fpml.consolidated.shared.validation.ResourceIdTypeFormatValidator;
import fpml.consolidated.shared.validation.ResourceIdValidator;
import fpml.consolidated.shared.validation.exists.ResourceIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ResourceId.class)
public class ResourceIdMeta implements RosettaMetaData<ResourceId> {

	@Override
	public List<Validator<? super ResourceId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ResourceId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ResourceId> validator(ValidatorFactory factory) {
		return factory.<ResourceId>create(ResourceIdValidator.class);
	}

	@Override
	public Validator<? super ResourceId> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ResourceId>create(ResourceIdTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ResourceId> validator() {
		return new ResourceIdValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ResourceId> typeFormatValidator() {
		return new ResourceIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ResourceId, Set<String>> onlyExistsValidator() {
		return new ResourceIdOnlyExistsValidator();
	}
}
