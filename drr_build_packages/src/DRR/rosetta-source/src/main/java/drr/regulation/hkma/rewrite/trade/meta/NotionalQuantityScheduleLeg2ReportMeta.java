package drr.regulation.hkma.rewrite.trade.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.hkma.rewrite.trade.NotionalQuantityScheduleLeg2Report;
import drr.regulation.hkma.rewrite.trade.validation.NotionalQuantityScheduleLeg2ReportTypeFormatValidator;
import drr.regulation.hkma.rewrite.trade.validation.NotionalQuantityScheduleLeg2ReportValidator;
import drr.regulation.hkma.rewrite.trade.validation.exists.NotionalQuantityScheduleLeg2ReportOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=NotionalQuantityScheduleLeg2Report.class)
public class NotionalQuantityScheduleLeg2ReportMeta implements RosettaMetaData<NotionalQuantityScheduleLeg2Report> {

	@Override
	public List<Validator<? super NotionalQuantityScheduleLeg2Report>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NotionalQuantityScheduleLeg2Report, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NotionalQuantityScheduleLeg2Report> validator(ValidatorFactory factory) {
		return factory.<NotionalQuantityScheduleLeg2Report>create(NotionalQuantityScheduleLeg2ReportValidator.class);
	}

	@Override
	public Validator<? super NotionalQuantityScheduleLeg2Report> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NotionalQuantityScheduleLeg2Report>create(NotionalQuantityScheduleLeg2ReportTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NotionalQuantityScheduleLeg2Report> validator() {
		return new NotionalQuantityScheduleLeg2ReportValidator();
	}

	@Deprecated
	@Override
	public Validator<? super NotionalQuantityScheduleLeg2Report> typeFormatValidator() {
		return new NotionalQuantityScheduleLeg2ReportTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NotionalQuantityScheduleLeg2Report, Set<String>> onlyExistsValidator() {
		return new NotionalQuantityScheduleLeg2ReportOnlyExistsValidator();
	}
}
