package fpml.consolidated.reg.fpmlreporting.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.reg.fpmlreporting.shared.RequestRegulatoryReportingStatusMessage;
import fpml.consolidated.reg.fpmlreporting.shared.validation.RequestRegulatoryReportingStatusMessageTypeFormatValidator;
import fpml.consolidated.reg.fpmlreporting.shared.validation.RequestRegulatoryReportingStatusMessageValidator;
import fpml.consolidated.reg.fpmlreporting.shared.validation.exists.RequestRegulatoryReportingStatusMessageOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RequestRegulatoryReportingStatusMessage.class)
public class RequestRegulatoryReportingStatusMessageMeta implements RosettaMetaData<RequestRegulatoryReportingStatusMessage> {

	@Override
	public List<Validator<? super RequestRegulatoryReportingStatusMessage>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RequestRegulatoryReportingStatusMessage, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RequestRegulatoryReportingStatusMessage> validator(ValidatorFactory factory) {
		return factory.<RequestRegulatoryReportingStatusMessage>create(RequestRegulatoryReportingStatusMessageValidator.class);
	}

	@Override
	public Validator<? super RequestRegulatoryReportingStatusMessage> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RequestRegulatoryReportingStatusMessage>create(RequestRegulatoryReportingStatusMessageTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RequestRegulatoryReportingStatusMessage> validator() {
		return new RequestRegulatoryReportingStatusMessageValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RequestRegulatoryReportingStatusMessage> typeFormatValidator() {
		return new RequestRegulatoryReportingStatusMessageTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequestRegulatoryReportingStatusMessage, Set<String>> onlyExistsValidator() {
		return new RequestRegulatoryReportingStatusMessageOnlyExistsValidator();
	}
}
