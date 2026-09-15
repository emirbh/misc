package drr.regulation.common.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.validation.ReportableJurisdictionInformationTypeFormatValidator;
import drr.regulation.common.validation.ReportableJurisdictionInformationValidator;
import drr.regulation.common.validation.datarule.ReportableJurisdictionInformationASICReportingRegime;
import drr.regulation.common.validation.datarule.ReportableJurisdictionInformationCFTCReportingRegime;
import drr.regulation.common.validation.datarule.ReportableJurisdictionInformationCFTCTransactionInformation;
import drr.regulation.common.validation.datarule.ReportableJurisdictionInformationCSAReportingRegime;
import drr.regulation.common.validation.datarule.ReportableJurisdictionInformationDoddFranckActSupervisoryBodies;
import drr.regulation.common.validation.datarule.ReportableJurisdictionInformationESMAReportingRegime;
import drr.regulation.common.validation.datarule.ReportableJurisdictionInformationESMATransactionInformation;
import drr.regulation.common.validation.datarule.ReportableJurisdictionInformationFCAReportingRegime;
import drr.regulation.common.validation.datarule.ReportableJurisdictionInformationHKMAReportingRegime;
import drr.regulation.common.validation.datarule.ReportableJurisdictionInformationSECReportingRegime;
import drr.regulation.common.validation.exists.ReportableJurisdictionInformationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=ReportableJurisdictionInformation.class)
public class ReportableJurisdictionInformationMeta implements RosettaMetaData<ReportableJurisdictionInformation> {

	@Override
	public List<Validator<? super ReportableJurisdictionInformation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ReportableJurisdictionInformation>create(ReportableJurisdictionInformationESMATransactionInformation.class),
			factory.<ReportableJurisdictionInformation>create(ReportableJurisdictionInformationCFTCTransactionInformation.class),
			factory.<ReportableJurisdictionInformation>create(ReportableJurisdictionInformationDoddFranckActSupervisoryBodies.class),
			factory.<ReportableJurisdictionInformation>create(ReportableJurisdictionInformationCFTCReportingRegime.class),
			factory.<ReportableJurisdictionInformation>create(ReportableJurisdictionInformationCSAReportingRegime.class),
			factory.<ReportableJurisdictionInformation>create(ReportableJurisdictionInformationSECReportingRegime.class),
			factory.<ReportableJurisdictionInformation>create(ReportableJurisdictionInformationESMAReportingRegime.class),
			factory.<ReportableJurisdictionInformation>create(ReportableJurisdictionInformationFCAReportingRegime.class),
			factory.<ReportableJurisdictionInformation>create(ReportableJurisdictionInformationASICReportingRegime.class),
			factory.<ReportableJurisdictionInformation>create(ReportableJurisdictionInformationHKMAReportingRegime.class)
		);
	}
	
	@Override
	public List<Function<? super ReportableJurisdictionInformation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReportableJurisdictionInformation> validator(ValidatorFactory factory) {
		return factory.<ReportableJurisdictionInformation>create(ReportableJurisdictionInformationValidator.class);
	}

	@Override
	public Validator<? super ReportableJurisdictionInformation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReportableJurisdictionInformation>create(ReportableJurisdictionInformationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReportableJurisdictionInformation> validator() {
		return new ReportableJurisdictionInformationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReportableJurisdictionInformation> typeFormatValidator() {
		return new ReportableJurisdictionInformationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReportableJurisdictionInformation, Set<String>> onlyExistsValidator() {
		return new ReportableJurisdictionInformationOnlyExistsValidator();
	}
}
