package iso20022.dtcc.rds.harmonized.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.dtcc.rds.harmonized.Core;
import iso20022.dtcc.rds.harmonized.validation.CoreTypeFormatValidator;
import iso20022.dtcc.rds.harmonized.validation.CoreValidator;
import iso20022.dtcc.rds.harmonized.validation.exists.CoreOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Core.class)
public class CoreMeta implements RosettaMetaData<Core> {

	@Override
	public List<Validator<? super Core>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Core, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Core> validator(ValidatorFactory factory) {
		return factory.<Core>create(CoreValidator.class);
	}

	@Override
	public Validator<? super Core> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Core>create(CoreTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Core> validator() {
		return new CoreValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Core> typeFormatValidator() {
		return new CoreTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Core, Set<String>> onlyExistsValidator() {
		return new CoreOnlyExistsValidator();
	}
}
