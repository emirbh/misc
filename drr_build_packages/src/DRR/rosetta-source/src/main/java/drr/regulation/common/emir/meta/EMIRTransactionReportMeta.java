package drr.regulation.common.emir.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.emir.EMIRTransactionReport;
import drr.regulation.common.emir.validation.EMIRTransactionReportTypeFormatValidator;
import drr.regulation.common.emir.validation.EMIRTransactionReportValidator;
import drr.regulation.common.emir.validation.exists.EMIRTransactionReportOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=EMIRTransactionReport.class)
public class EMIRTransactionReportMeta implements RosettaMetaData<EMIRTransactionReport> {

	@Override
	public List<Validator<? super EMIRTransactionReport>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EMIRTransactionReport, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EMIRTransactionReport> validator(ValidatorFactory factory) {
		return factory.<EMIRTransactionReport>create(EMIRTransactionReportValidator.class);
	}

	@Override
	public Validator<? super EMIRTransactionReport> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EMIRTransactionReport>create(EMIRTransactionReportTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EMIRTransactionReport> validator() {
		return new EMIRTransactionReportValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EMIRTransactionReport> typeFormatValidator() {
		return new EMIRTransactionReportTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EMIRTransactionReport, Set<String>> onlyExistsValidator() {
		return new EMIRTransactionReportOnlyExistsValidator();
	}
}
