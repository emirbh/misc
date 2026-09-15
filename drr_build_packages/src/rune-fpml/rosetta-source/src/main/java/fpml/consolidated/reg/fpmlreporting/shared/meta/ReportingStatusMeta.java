package fpml.consolidated.reg.fpmlreporting.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.reg.fpmlreporting.shared.ReportingStatus;
import fpml.consolidated.reg.fpmlreporting.shared.validation.ReportingStatusTypeFormatValidator;
import fpml.consolidated.reg.fpmlreporting.shared.validation.ReportingStatusValidator;
import fpml.consolidated.reg.fpmlreporting.shared.validation.exists.ReportingStatusOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ReportingStatus.class)
public class ReportingStatusMeta implements RosettaMetaData<ReportingStatus> {

	@Override
	public List<Validator<? super ReportingStatus>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReportingStatus, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReportingStatus> validator(ValidatorFactory factory) {
		return factory.<ReportingStatus>create(ReportingStatusValidator.class);
	}

	@Override
	public Validator<? super ReportingStatus> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReportingStatus>create(ReportingStatusTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReportingStatus> validator() {
		return new ReportingStatusValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReportingStatus> typeFormatValidator() {
		return new ReportingStatusTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReportingStatus, Set<String>> onlyExistsValidator() {
		return new ReportingStatusOnlyExistsValidator();
	}
}
