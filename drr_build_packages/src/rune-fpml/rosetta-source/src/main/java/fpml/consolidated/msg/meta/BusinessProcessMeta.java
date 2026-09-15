package fpml.consolidated.msg.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.msg.BusinessProcess;
import fpml.consolidated.msg.validation.BusinessProcessTypeFormatValidator;
import fpml.consolidated.msg.validation.BusinessProcessValidator;
import fpml.consolidated.msg.validation.exists.BusinessProcessOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=BusinessProcess.class)
public class BusinessProcessMeta implements RosettaMetaData<BusinessProcess> {

	@Override
	public List<Validator<? super BusinessProcess>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BusinessProcess, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BusinessProcess> validator(ValidatorFactory factory) {
		return factory.<BusinessProcess>create(BusinessProcessValidator.class);
	}

	@Override
	public Validator<? super BusinessProcess> typeFormatValidator(ValidatorFactory factory) {
		return factory.<BusinessProcess>create(BusinessProcessTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super BusinessProcess> validator() {
		return new BusinessProcessValidator();
	}

	@Deprecated
	@Override
	public Validator<? super BusinessProcess> typeFormatValidator() {
		return new BusinessProcessTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BusinessProcess, Set<String>> onlyExistsValidator() {
		return new BusinessProcessOnlyExistsValidator();
	}
}
