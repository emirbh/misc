package drr.regulation.common.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.CommonPartiesReport;
import drr.regulation.common.validation.CommonPartiesReportTypeFormatValidator;
import drr.regulation.common.validation.CommonPartiesReportValidator;
import drr.regulation.common.validation.exists.CommonPartiesReportOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=CommonPartiesReport.class)
public class CommonPartiesReportMeta implements RosettaMetaData<CommonPartiesReport> {

	@Override
	public List<Validator<? super CommonPartiesReport>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommonPartiesReport, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommonPartiesReport> validator(ValidatorFactory factory) {
		return factory.<CommonPartiesReport>create(CommonPartiesReportValidator.class);
	}

	@Override
	public Validator<? super CommonPartiesReport> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommonPartiesReport>create(CommonPartiesReportTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommonPartiesReport> validator() {
		return new CommonPartiesReportValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommonPartiesReport> typeFormatValidator() {
		return new CommonPartiesReportTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommonPartiesReport, Set<String>> onlyExistsValidator() {
		return new CommonPartiesReportOnlyExistsValidator();
	}
}
