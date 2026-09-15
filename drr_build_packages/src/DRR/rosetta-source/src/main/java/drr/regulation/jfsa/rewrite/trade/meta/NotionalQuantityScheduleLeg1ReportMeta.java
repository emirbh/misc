package drr.regulation.jfsa.rewrite.trade.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.jfsa.rewrite.trade.NotionalQuantityScheduleLeg1Report;
import drr.regulation.jfsa.rewrite.trade.validation.NotionalQuantityScheduleLeg1ReportTypeFormatValidator;
import drr.regulation.jfsa.rewrite.trade.validation.NotionalQuantityScheduleLeg1ReportValidator;
import drr.regulation.jfsa.rewrite.trade.validation.exists.NotionalQuantityScheduleLeg1ReportOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=NotionalQuantityScheduleLeg1Report.class)
public class NotionalQuantityScheduleLeg1ReportMeta implements RosettaMetaData<NotionalQuantityScheduleLeg1Report> {

	@Override
	public List<Validator<? super NotionalQuantityScheduleLeg1Report>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NotionalQuantityScheduleLeg1Report, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NotionalQuantityScheduleLeg1Report> validator(ValidatorFactory factory) {
		return factory.<NotionalQuantityScheduleLeg1Report>create(NotionalQuantityScheduleLeg1ReportValidator.class);
	}

	@Override
	public Validator<? super NotionalQuantityScheduleLeg1Report> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NotionalQuantityScheduleLeg1Report>create(NotionalQuantityScheduleLeg1ReportTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NotionalQuantityScheduleLeg1Report> validator() {
		return new NotionalQuantityScheduleLeg1ReportValidator();
	}

	@Deprecated
	@Override
	public Validator<? super NotionalQuantityScheduleLeg1Report> typeFormatValidator() {
		return new NotionalQuantityScheduleLeg1ReportTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NotionalQuantityScheduleLeg1Report, Set<String>> onlyExistsValidator() {
		return new NotionalQuantityScheduleLeg1ReportOnlyExistsValidator();
	}
}
