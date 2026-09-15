package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.ResourceLength;
import fpml.consolidated.shared.validation.ResourceLengthTypeFormatValidator;
import fpml.consolidated.shared.validation.ResourceLengthValidator;
import fpml.consolidated.shared.validation.exists.ResourceLengthOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ResourceLength.class)
public class ResourceLengthMeta implements RosettaMetaData<ResourceLength> {

	@Override
	public List<Validator<? super ResourceLength>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ResourceLength, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ResourceLength> validator(ValidatorFactory factory) {
		return factory.<ResourceLength>create(ResourceLengthValidator.class);
	}

	@Override
	public Validator<? super ResourceLength> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ResourceLength>create(ResourceLengthTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ResourceLength> validator() {
		return new ResourceLengthValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ResourceLength> typeFormatValidator() {
		return new ResourceLengthTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ResourceLength, Set<String>> onlyExistsValidator() {
		return new ResourceLengthOnlyExistsValidator();
	}
}
