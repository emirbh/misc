package drr.base.trade.basket.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.base.trade.basket.BasketConstituentsReport;
import drr.base.trade.basket.validation.BasketConstituentsReportTypeFormatValidator;
import drr.base.trade.basket.validation.BasketConstituentsReportValidator;
import drr.base.trade.basket.validation.exists.BasketConstituentsReportOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=BasketConstituentsReport.class)
public class BasketConstituentsReportMeta implements RosettaMetaData<BasketConstituentsReport> {

	@Override
	public List<Validator<? super BasketConstituentsReport>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BasketConstituentsReport, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BasketConstituentsReport> validator(ValidatorFactory factory) {
		return factory.<BasketConstituentsReport>create(BasketConstituentsReportValidator.class);
	}

	@Override
	public Validator<? super BasketConstituentsReport> typeFormatValidator(ValidatorFactory factory) {
		return factory.<BasketConstituentsReport>create(BasketConstituentsReportTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super BasketConstituentsReport> validator() {
		return new BasketConstituentsReportValidator();
	}

	@Deprecated
	@Override
	public Validator<? super BasketConstituentsReport> typeFormatValidator() {
		return new BasketConstituentsReportTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BasketConstituentsReport, Set<String>> onlyExistsValidator() {
		return new BasketConstituentsReportOnlyExistsValidator();
	}
}
