package fpml.consolidated.reg.fpmlreporting.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.reg.fpmlreporting.shared.RequestRegulatoryReportingStatus;
import fpml.consolidated.reg.fpmlreporting.shared.validation.RequestRegulatoryReportingStatusTypeFormatValidator;
import fpml.consolidated.reg.fpmlreporting.shared.validation.RequestRegulatoryReportingStatusValidator;
import fpml.consolidated.reg.fpmlreporting.shared.validation.exists.RequestRegulatoryReportingStatusOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RequestRegulatoryReportingStatus.class)
public class RequestRegulatoryReportingStatusMeta implements RosettaMetaData<RequestRegulatoryReportingStatus> {

	@Override
	public List<Validator<? super RequestRegulatoryReportingStatus>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RequestRegulatoryReportingStatus, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RequestRegulatoryReportingStatus> validator(ValidatorFactory factory) {
		return factory.<RequestRegulatoryReportingStatus>create(RequestRegulatoryReportingStatusValidator.class);
	}

	@Override
	public Validator<? super RequestRegulatoryReportingStatus> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RequestRegulatoryReportingStatus>create(RequestRegulatoryReportingStatusTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RequestRegulatoryReportingStatus> validator() {
		return new RequestRegulatoryReportingStatusValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RequestRegulatoryReportingStatus> typeFormatValidator() {
		return new RequestRegulatoryReportingStatusTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequestRegulatoryReportingStatus, Set<String>> onlyExistsValidator() {
		return new RequestRegulatoryReportingStatusOnlyExistsValidator();
	}
}
