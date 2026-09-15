package fpml.consolidated.reg.fpmlreporting.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.reg.fpmlreporting.shared.RegulatorReportingStatusCode;
import fpml.consolidated.reg.fpmlreporting.shared.validation.RegulatorReportingStatusCodeTypeFormatValidator;
import fpml.consolidated.reg.fpmlreporting.shared.validation.RegulatorReportingStatusCodeValidator;
import fpml.consolidated.reg.fpmlreporting.shared.validation.exists.RegulatorReportingStatusCodeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RegulatorReportingStatusCode.class)
public class RegulatorReportingStatusCodeMeta implements RosettaMetaData<RegulatorReportingStatusCode> {

	@Override
	public List<Validator<? super RegulatorReportingStatusCode>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RegulatorReportingStatusCode, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RegulatorReportingStatusCode> validator(ValidatorFactory factory) {
		return factory.<RegulatorReportingStatusCode>create(RegulatorReportingStatusCodeValidator.class);
	}

	@Override
	public Validator<? super RegulatorReportingStatusCode> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RegulatorReportingStatusCode>create(RegulatorReportingStatusCodeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RegulatorReportingStatusCode> validator() {
		return new RegulatorReportingStatusCodeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RegulatorReportingStatusCode> typeFormatValidator() {
		return new RegulatorReportingStatusCodeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RegulatorReportingStatusCode, Set<String>> onlyExistsValidator() {
		return new RegulatorReportingStatusCodeOnlyExistsValidator();
	}
}
