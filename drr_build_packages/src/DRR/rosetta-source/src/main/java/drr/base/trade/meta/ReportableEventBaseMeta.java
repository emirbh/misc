package drr.base.trade.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.validation.ReportableEventBaseTypeFormatValidator;
import drr.base.trade.validation.ReportableEventBaseValidator;
import drr.base.trade.validation.exists.ReportableEventBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=ReportableEventBase.class)
public class ReportableEventBaseMeta implements RosettaMetaData<ReportableEventBase> {

	@Override
	public List<Validator<? super ReportableEventBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReportableEventBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReportableEventBase> validator(ValidatorFactory factory) {
		return factory.<ReportableEventBase>create(ReportableEventBaseValidator.class);
	}

	@Override
	public Validator<? super ReportableEventBase> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReportableEventBase>create(ReportableEventBaseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReportableEventBase> validator() {
		return new ReportableEventBaseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReportableEventBase> typeFormatValidator() {
		return new ReportableEventBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReportableEventBase, Set<String>> onlyExistsValidator() {
		return new ReportableEventBaseOnlyExistsValidator();
	}
}
