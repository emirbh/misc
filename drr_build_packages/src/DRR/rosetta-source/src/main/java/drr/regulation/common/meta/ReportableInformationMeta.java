package drr.regulation.common.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.validation.ReportableInformationTypeFormatValidator;
import drr.regulation.common.validation.ReportableInformationValidator;
import drr.regulation.common.validation.datarule.ReportableInformationMandatorilyClearableConditionCFTC;
import drr.regulation.common.validation.datarule.ReportableInformationMandatorilyClearableConditionESMA;
import drr.regulation.common.validation.datarule.ReportableInformationMandatorilyClearableConditionFCA;
import drr.regulation.common.validation.datarule.ReportableInformationNotDuplicatedJurisdictions;
import drr.regulation.common.validation.datarule.ReportableInformationTradingCapacityMAS;
import drr.regulation.common.validation.exists.ReportableInformationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=ReportableInformation.class)
public class ReportableInformationMeta implements RosettaMetaData<ReportableInformation> {

	@Override
	public List<Validator<? super ReportableInformation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ReportableInformation>create(ReportableInformationNotDuplicatedJurisdictions.class),
			factory.<ReportableInformation>create(ReportableInformationTradingCapacityMAS.class),
			factory.<ReportableInformation>create(ReportableInformationMandatorilyClearableConditionESMA.class),
			factory.<ReportableInformation>create(ReportableInformationMandatorilyClearableConditionFCA.class),
			factory.<ReportableInformation>create(ReportableInformationMandatorilyClearableConditionCFTC.class)
		);
	}
	
	@Override
	public List<Function<? super ReportableInformation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReportableInformation> validator(ValidatorFactory factory) {
		return factory.<ReportableInformation>create(ReportableInformationValidator.class);
	}

	@Override
	public Validator<? super ReportableInformation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReportableInformation>create(ReportableInformationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReportableInformation> validator() {
		return new ReportableInformationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReportableInformation> typeFormatValidator() {
		return new ReportableInformationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReportableInformation, Set<String>> onlyExistsValidator() {
		return new ReportableInformationOnlyExistsValidator();
	}
}
