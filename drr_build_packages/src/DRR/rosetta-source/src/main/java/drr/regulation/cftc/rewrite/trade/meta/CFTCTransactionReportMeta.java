package drr.regulation.cftc.rewrite.trade.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.cftc.rewrite.trade.CFTCTransactionReport;
import drr.regulation.cftc.rewrite.trade.validation.CFTCTransactionReportTypeFormatValidator;
import drr.regulation.cftc.rewrite.trade.validation.CFTCTransactionReportValidator;
import drr.regulation.cftc.rewrite.trade.validation.exists.CFTCTransactionReportOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=CFTCTransactionReport.class)
public class CFTCTransactionReportMeta implements RosettaMetaData<CFTCTransactionReport> {

	@Override
	public List<Validator<? super CFTCTransactionReport>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CFTCTransactionReport, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CFTCTransactionReport> validator(ValidatorFactory factory) {
		return factory.<CFTCTransactionReport>create(CFTCTransactionReportValidator.class);
	}

	@Override
	public Validator<? super CFTCTransactionReport> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CFTCTransactionReport>create(CFTCTransactionReportTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CFTCTransactionReport> validator() {
		return new CFTCTransactionReportValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CFTCTransactionReport> typeFormatValidator() {
		return new CFTCTransactionReportTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CFTCTransactionReport, Set<String>> onlyExistsValidator() {
		return new CFTCTransactionReportOnlyExistsValidator();
	}
}
