package fpml.consolidated.reg.fpmlreporting.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.reg.fpmlreporting.shared.RegulatoryReportingStatus;
import fpml.consolidated.reg.fpmlreporting.shared.validation.RegulatoryReportingStatusTypeFormatValidator;
import fpml.consolidated.reg.fpmlreporting.shared.validation.RegulatoryReportingStatusValidator;
import fpml.consolidated.reg.fpmlreporting.shared.validation.exists.RegulatoryReportingStatusOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RegulatoryReportingStatus.class)
public class RegulatoryReportingStatusMeta implements RosettaMetaData<RegulatoryReportingStatus> {

	@Override
	public List<Validator<? super RegulatoryReportingStatus>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RegulatoryReportingStatus, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RegulatoryReportingStatus> validator(ValidatorFactory factory) {
		return factory.<RegulatoryReportingStatus>create(RegulatoryReportingStatusValidator.class);
	}

	@Override
	public Validator<? super RegulatoryReportingStatus> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RegulatoryReportingStatus>create(RegulatoryReportingStatusTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryReportingStatus> validator() {
		return new RegulatoryReportingStatusValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryReportingStatus> typeFormatValidator() {
		return new RegulatoryReportingStatusTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RegulatoryReportingStatus, Set<String>> onlyExistsValidator() {
		return new RegulatoryReportingStatusOnlyExistsValidator();
	}
}
