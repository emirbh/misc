package fpml.consolidated.recordkeeping.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.recordkeeping.processes.RegulatoryReportingAcknowledgement;
import fpml.consolidated.recordkeeping.processes.validation.RegulatoryReportingAcknowledgementTypeFormatValidator;
import fpml.consolidated.recordkeeping.processes.validation.RegulatoryReportingAcknowledgementValidator;
import fpml.consolidated.recordkeeping.processes.validation.exists.RegulatoryReportingAcknowledgementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RegulatoryReportingAcknowledgement.class)
public class RegulatoryReportingAcknowledgementMeta implements RosettaMetaData<RegulatoryReportingAcknowledgement> {

	@Override
	public List<Validator<? super RegulatoryReportingAcknowledgement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RegulatoryReportingAcknowledgement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RegulatoryReportingAcknowledgement> validator(ValidatorFactory factory) {
		return factory.<RegulatoryReportingAcknowledgement>create(RegulatoryReportingAcknowledgementValidator.class);
	}

	@Override
	public Validator<? super RegulatoryReportingAcknowledgement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RegulatoryReportingAcknowledgement>create(RegulatoryReportingAcknowledgementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryReportingAcknowledgement> validator() {
		return new RegulatoryReportingAcknowledgementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryReportingAcknowledgement> typeFormatValidator() {
		return new RegulatoryReportingAcknowledgementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RegulatoryReportingAcknowledgement, Set<String>> onlyExistsValidator() {
		return new RegulatoryReportingAcknowledgementOnlyExistsValidator();
	}
}
