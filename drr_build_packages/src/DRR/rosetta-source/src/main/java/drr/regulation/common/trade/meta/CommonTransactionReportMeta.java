package drr.regulation.common.trade.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.trade.CommonTransactionReport;
import drr.regulation.common.trade.validation.CommonTransactionReportTypeFormatValidator;
import drr.regulation.common.trade.validation.CommonTransactionReportValidator;
import drr.regulation.common.trade.validation.exists.CommonTransactionReportOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=CommonTransactionReport.class)
public class CommonTransactionReportMeta implements RosettaMetaData<CommonTransactionReport> {

	@Override
	public List<Validator<? super CommonTransactionReport>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommonTransactionReport, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommonTransactionReport> validator(ValidatorFactory factory) {
		return factory.<CommonTransactionReport>create(CommonTransactionReportValidator.class);
	}

	@Override
	public Validator<? super CommonTransactionReport> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommonTransactionReport>create(CommonTransactionReportTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommonTransactionReport> validator() {
		return new CommonTransactionReportValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommonTransactionReport> typeFormatValidator() {
		return new CommonTransactionReportTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommonTransactionReport, Set<String>> onlyExistsValidator() {
		return new CommonTransactionReportOnlyExistsValidator();
	}
}
