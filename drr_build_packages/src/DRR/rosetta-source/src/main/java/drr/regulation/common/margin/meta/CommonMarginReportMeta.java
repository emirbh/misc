package drr.regulation.common.margin.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.margin.CommonMarginReport;
import drr.regulation.common.margin.validation.CommonMarginReportTypeFormatValidator;
import drr.regulation.common.margin.validation.CommonMarginReportValidator;
import drr.regulation.common.margin.validation.exists.CommonMarginReportOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=CommonMarginReport.class)
public class CommonMarginReportMeta implements RosettaMetaData<CommonMarginReport> {

	@Override
	public List<Validator<? super CommonMarginReport>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommonMarginReport, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommonMarginReport> validator(ValidatorFactory factory) {
		return factory.<CommonMarginReport>create(CommonMarginReportValidator.class);
	}

	@Override
	public Validator<? super CommonMarginReport> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommonMarginReport>create(CommonMarginReportTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommonMarginReport> validator() {
		return new CommonMarginReportValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommonMarginReport> typeFormatValidator() {
		return new CommonMarginReportTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommonMarginReport, Set<String>> onlyExistsValidator() {
		return new CommonMarginReportOnlyExistsValidator();
	}
}
