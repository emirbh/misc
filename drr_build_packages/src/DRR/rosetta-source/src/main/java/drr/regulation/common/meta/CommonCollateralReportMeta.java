package drr.regulation.common.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.CommonCollateralReport;
import drr.regulation.common.validation.CommonCollateralReportTypeFormatValidator;
import drr.regulation.common.validation.CommonCollateralReportValidator;
import drr.regulation.common.validation.exists.CommonCollateralReportOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=CommonCollateralReport.class)
public class CommonCollateralReportMeta implements RosettaMetaData<CommonCollateralReport> {

	@Override
	public List<Validator<? super CommonCollateralReport>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommonCollateralReport, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommonCollateralReport> validator(ValidatorFactory factory) {
		return factory.<CommonCollateralReport>create(CommonCollateralReportValidator.class);
	}

	@Override
	public Validator<? super CommonCollateralReport> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommonCollateralReport>create(CommonCollateralReportTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommonCollateralReport> validator() {
		return new CommonCollateralReportValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommonCollateralReport> typeFormatValidator() {
		return new CommonCollateralReportTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommonCollateralReport, Set<String>> onlyExistsValidator() {
		return new CommonCollateralReportOnlyExistsValidator();
	}
}
