package iso20022.auth108.iso.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.ReportingExemption1;
import iso20022.auth108.iso.validation.ReportingExemption1TypeFormatValidator;
import iso20022.auth108.iso.validation.ReportingExemption1Validator;
import iso20022.auth108.iso.validation.exists.ReportingExemption1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ReportingExemption1.class)
public class ReportingExemption1Meta implements RosettaMetaData<ReportingExemption1> {

	@Override
	public List<Validator<? super ReportingExemption1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReportingExemption1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReportingExemption1> validator(ValidatorFactory factory) {
		return factory.<ReportingExemption1>create(ReportingExemption1Validator.class);
	}

	@Override
	public Validator<? super ReportingExemption1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReportingExemption1>create(ReportingExemption1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReportingExemption1> validator() {
		return new ReportingExemption1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super ReportingExemption1> typeFormatValidator() {
		return new ReportingExemption1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReportingExemption1, Set<String>> onlyExistsValidator() {
		return new ReportingExemption1OnlyExistsValidator();
	}
}
