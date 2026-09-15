package drr.base.trade.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.base.trade.ReportablePriceSource;
import drr.base.trade.validation.ReportablePriceSourceTypeFormatValidator;
import drr.base.trade.validation.ReportablePriceSourceValidator;
import drr.base.trade.validation.datarule.ReportablePriceSourceChoice;
import drr.base.trade.validation.exists.ReportablePriceSourceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=ReportablePriceSource.class)
public class ReportablePriceSourceMeta implements RosettaMetaData<ReportablePriceSource> {

	@Override
	public List<Validator<? super ReportablePriceSource>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ReportablePriceSource>create(ReportablePriceSourceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ReportablePriceSource, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReportablePriceSource> validator(ValidatorFactory factory) {
		return factory.<ReportablePriceSource>create(ReportablePriceSourceValidator.class);
	}

	@Override
	public Validator<? super ReportablePriceSource> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReportablePriceSource>create(ReportablePriceSourceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReportablePriceSource> validator() {
		return new ReportablePriceSourceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReportablePriceSource> typeFormatValidator() {
		return new ReportablePriceSourceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReportablePriceSource, Set<String>> onlyExistsValidator() {
		return new ReportablePriceSourceOnlyExistsValidator();
	}
}
