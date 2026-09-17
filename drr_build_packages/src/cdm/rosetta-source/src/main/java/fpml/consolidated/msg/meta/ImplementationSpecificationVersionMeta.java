package fpml.consolidated.msg.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.msg.ImplementationSpecificationVersion;
import fpml.consolidated.msg.validation.ImplementationSpecificationVersionTypeFormatValidator;
import fpml.consolidated.msg.validation.ImplementationSpecificationVersionValidator;
import fpml.consolidated.msg.validation.exists.ImplementationSpecificationVersionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ImplementationSpecificationVersion.class)
public class ImplementationSpecificationVersionMeta implements RosettaMetaData<ImplementationSpecificationVersion> {

	@Override
	public List<Validator<? super ImplementationSpecificationVersion>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ImplementationSpecificationVersion, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ImplementationSpecificationVersion> validator(ValidatorFactory factory) {
		return factory.<ImplementationSpecificationVersion>create(ImplementationSpecificationVersionValidator.class);
	}

	@Override
	public Validator<? super ImplementationSpecificationVersion> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ImplementationSpecificationVersion>create(ImplementationSpecificationVersionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ImplementationSpecificationVersion> validator() {
		return new ImplementationSpecificationVersionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ImplementationSpecificationVersion> typeFormatValidator() {
		return new ImplementationSpecificationVersionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ImplementationSpecificationVersion, Set<String>> onlyExistsValidator() {
		return new ImplementationSpecificationVersionOnlyExistsValidator();
	}
}
