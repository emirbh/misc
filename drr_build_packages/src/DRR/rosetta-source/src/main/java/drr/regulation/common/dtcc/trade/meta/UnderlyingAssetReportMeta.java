package drr.regulation.common.dtcc.trade.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.dtcc.trade.UnderlyingAssetReport;
import drr.regulation.common.dtcc.trade.validation.UnderlyingAssetReportTypeFormatValidator;
import drr.regulation.common.dtcc.trade.validation.UnderlyingAssetReportValidator;
import drr.regulation.common.dtcc.trade.validation.exists.UnderlyingAssetReportOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=UnderlyingAssetReport.class)
public class UnderlyingAssetReportMeta implements RosettaMetaData<UnderlyingAssetReport> {

	@Override
	public List<Validator<? super UnderlyingAssetReport>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super UnderlyingAssetReport, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super UnderlyingAssetReport> validator(ValidatorFactory factory) {
		return factory.<UnderlyingAssetReport>create(UnderlyingAssetReportValidator.class);
	}

	@Override
	public Validator<? super UnderlyingAssetReport> typeFormatValidator(ValidatorFactory factory) {
		return factory.<UnderlyingAssetReport>create(UnderlyingAssetReportTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super UnderlyingAssetReport> validator() {
		return new UnderlyingAssetReportValidator();
	}

	@Deprecated
	@Override
	public Validator<? super UnderlyingAssetReport> typeFormatValidator() {
		return new UnderlyingAssetReportTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super UnderlyingAssetReport, Set<String>> onlyExistsValidator() {
		return new UnderlyingAssetReportOnlyExistsValidator();
	}
}
