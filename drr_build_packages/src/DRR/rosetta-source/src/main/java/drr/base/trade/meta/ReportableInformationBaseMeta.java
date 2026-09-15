package drr.base.trade.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.base.trade.ReportableInformationBase;
import drr.base.trade.validation.ReportableInformationBaseTypeFormatValidator;
import drr.base.trade.validation.ReportableInformationBaseValidator;
import drr.base.trade.validation.exists.ReportableInformationBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=ReportableInformationBase.class)
public class ReportableInformationBaseMeta implements RosettaMetaData<ReportableInformationBase> {

	@Override
	public List<Validator<? super ReportableInformationBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReportableInformationBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReportableInformationBase> validator(ValidatorFactory factory) {
		return factory.<ReportableInformationBase>create(ReportableInformationBaseValidator.class);
	}

	@Override
	public Validator<? super ReportableInformationBase> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReportableInformationBase>create(ReportableInformationBaseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReportableInformationBase> validator() {
		return new ReportableInformationBaseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReportableInformationBase> typeFormatValidator() {
		return new ReportableInformationBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReportableInformationBase, Set<String>> onlyExistsValidator() {
		return new ReportableInformationBaseOnlyExistsValidator();
	}
}
