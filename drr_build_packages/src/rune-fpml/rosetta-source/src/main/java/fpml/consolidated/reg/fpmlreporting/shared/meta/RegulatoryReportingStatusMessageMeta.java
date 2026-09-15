package fpml.consolidated.reg.fpmlreporting.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.reg.fpmlreporting.shared.RegulatoryReportingStatusMessage;
import fpml.consolidated.reg.fpmlreporting.shared.validation.RegulatoryReportingStatusMessageTypeFormatValidator;
import fpml.consolidated.reg.fpmlreporting.shared.validation.RegulatoryReportingStatusMessageValidator;
import fpml.consolidated.reg.fpmlreporting.shared.validation.exists.RegulatoryReportingStatusMessageOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RegulatoryReportingStatusMessage.class)
public class RegulatoryReportingStatusMessageMeta implements RosettaMetaData<RegulatoryReportingStatusMessage> {

	@Override
	public List<Validator<? super RegulatoryReportingStatusMessage>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RegulatoryReportingStatusMessage, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RegulatoryReportingStatusMessage> validator(ValidatorFactory factory) {
		return factory.<RegulatoryReportingStatusMessage>create(RegulatoryReportingStatusMessageValidator.class);
	}

	@Override
	public Validator<? super RegulatoryReportingStatusMessage> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RegulatoryReportingStatusMessage>create(RegulatoryReportingStatusMessageTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryReportingStatusMessage> validator() {
		return new RegulatoryReportingStatusMessageValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryReportingStatusMessage> typeFormatValidator() {
		return new RegulatoryReportingStatusMessageTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RegulatoryReportingStatusMessage, Set<String>> onlyExistsValidator() {
		return new RegulatoryReportingStatusMessageOnlyExistsValidator();
	}
}
