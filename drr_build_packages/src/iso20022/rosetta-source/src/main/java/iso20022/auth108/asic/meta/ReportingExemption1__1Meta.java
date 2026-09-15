package iso20022.auth108.asic.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.asic.ReportingExemption1__1;
import iso20022.auth108.asic.validation.ReportingExemption1__1TypeFormatValidator;
import iso20022.auth108.asic.validation.ReportingExemption1__1Validator;
import iso20022.auth108.asic.validation.exists.ReportingExemption1__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ReportingExemption1__1.class)
public class ReportingExemption1__1Meta implements RosettaMetaData<ReportingExemption1__1> {

	@Override
	public List<Validator<? super ReportingExemption1__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReportingExemption1__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReportingExemption1__1> validator(ValidatorFactory factory) {
		return factory.<ReportingExemption1__1>create(ReportingExemption1__1Validator.class);
	}

	@Override
	public Validator<? super ReportingExemption1__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReportingExemption1__1>create(ReportingExemption1__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReportingExemption1__1> validator() {
		return new ReportingExemption1__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super ReportingExemption1__1> typeFormatValidator() {
		return new ReportingExemption1__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReportingExemption1__1, Set<String>> onlyExistsValidator() {
		return new ReportingExemption1__1OnlyExistsValidator();
	}
}
