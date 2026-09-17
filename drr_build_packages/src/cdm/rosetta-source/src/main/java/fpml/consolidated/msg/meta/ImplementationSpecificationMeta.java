package fpml.consolidated.msg.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.msg.ImplementationSpecification;
import fpml.consolidated.msg.validation.ImplementationSpecificationTypeFormatValidator;
import fpml.consolidated.msg.validation.ImplementationSpecificationValidator;
import fpml.consolidated.msg.validation.exists.ImplementationSpecificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ImplementationSpecification.class)
public class ImplementationSpecificationMeta implements RosettaMetaData<ImplementationSpecification> {

	@Override
	public List<Validator<? super ImplementationSpecification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ImplementationSpecification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ImplementationSpecification> validator(ValidatorFactory factory) {
		return factory.<ImplementationSpecification>create(ImplementationSpecificationValidator.class);
	}

	@Override
	public Validator<? super ImplementationSpecification> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ImplementationSpecification>create(ImplementationSpecificationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ImplementationSpecification> validator() {
		return new ImplementationSpecificationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ImplementationSpecification> typeFormatValidator() {
		return new ImplementationSpecificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ImplementationSpecification, Set<String>> onlyExistsValidator() {
		return new ImplementationSpecificationOnlyExistsValidator();
	}
}
