package fpml.consolidated.msg.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.msg.ServiceAdvisory;
import fpml.consolidated.msg.validation.ServiceAdvisoryTypeFormatValidator;
import fpml.consolidated.msg.validation.ServiceAdvisoryValidator;
import fpml.consolidated.msg.validation.exists.ServiceAdvisoryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ServiceAdvisory.class)
public class ServiceAdvisoryMeta implements RosettaMetaData<ServiceAdvisory> {

	@Override
	public List<Validator<? super ServiceAdvisory>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ServiceAdvisory, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ServiceAdvisory> validator(ValidatorFactory factory) {
		return factory.<ServiceAdvisory>create(ServiceAdvisoryValidator.class);
	}

	@Override
	public Validator<? super ServiceAdvisory> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ServiceAdvisory>create(ServiceAdvisoryTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ServiceAdvisory> validator() {
		return new ServiceAdvisoryValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ServiceAdvisory> typeFormatValidator() {
		return new ServiceAdvisoryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ServiceAdvisory, Set<String>> onlyExistsValidator() {
		return new ServiceAdvisoryOnlyExistsValidator();
	}
}
